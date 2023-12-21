package user;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import manageruserstubs.Category;
import manageruserstubs.ContractManagerUserGrpc;
import manageruserstubs.Resume;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;



public class UserApp {

    public static void main(String[] args) throws IOException {
        String ipManager = args[0];
        // Criar um canal gRPC para se comunicar com o Manager
        ManagedChannel channel = ManagedChannelBuilder.forAddress(ipManager, 8080)
                .usePlaintext()
                .build();

        // Criar um cliente gRPC usando o contrato gerado
        ContractManagerUserGrpc.ContractManagerUserStub stub = ContractManagerUserGrpc.newStub(channel);


        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenu();
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    solicitarResumo(stub, "ALIMENTAR");
                    System.out.println("Quer fazer download:");
                    String download = readline("1 - Yes     2 - No");
                    if (Objects.equals(download, "1")){
                        downloadFile("/var/sharedfiles/RESUMO_ALIMENTAR.txt","ALIMENTAR_resumo.txt");
                    };
                    break;
                case 2:
                    solicitarResumo(stub, "CASA");
                    System.out.println("Quer fazer download:");
                    String download1 = readline("1 - Yes     2 - No");
                        if (Objects.equals(download1, "1")) {
                            downloadFile("/var/sharedfiles/RESUMO_ALIMENTAR.txt", "CASA_resumo.txt");
                    };
                    break;
                case 3:
                    System.out.println("Saindo do programa.");
                    channel.shutdown();
                    return;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }

    private static String readline(String msg) {
        Scanner scaninput = new Scanner(System.in);
        System.out.println(msg);
        return scaninput.nextLine();
    }

    private static void exibirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1. Resumo para a categoria ALIMENTAR");
        System.out.println("2. Resumo para a categoria CASA");
        System.out.println("3. Sair");
    }

    // Download do ficheiro
    private static void downloadFile(String fileUrl, String destinationPath) throws IOException {
        //URL url = new URL(fileUrl);
        //URLConnection connection = url.openConnection();

        // try (InputStream in = connection.getInputStream();
        try (InputStream in = new FileInputStream(fileUrl);
             FileOutputStream out = new FileOutputStream(destinationPath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            System.out.println("Download Feito com sucesso");
        }
    }

    private static void solicitarResumo(ContractManagerUserGrpc.ContractManagerUserStub stub, String categoria) {
        Category category = Category.newBuilder().setCategory(categoria).build();

        // Usando CompletableFuture para processamento assíncrono
        CompletableFuture<Void> future = new CompletableFuture<>();

        // Fazendo a chamada assíncrona
        stub.getResume(category, new StreamObserver<Resume>() {
            @Override
            public void onNext(Resume sale) {
                // Processar cada venda (exibir ou salvar conforme necessário)
                System.out.println("Venda recebida: " + sale);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Erro ao receber resumo: " + throwable.getMessage());
                future.complete(null);
            }

            @Override
            public void onCompleted() {
                System.out.println("Resumo recebido com sucesso.");
                future.complete(null); // Completa o futuro quando a chamada é concluída
            }
        });

        // Aguarde até que a chamada assíncrona seja concluída (pode usar CompletableFuture.join())
        future.join();
    }
}
