package user;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import manageruserstubs.Category;
import manageruserstubs.ContractManagerUserGrpc;
import manageruserstubs.Resume;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class UserApp {

    public static void main(String[] args) {
        // Criar um canal gRPC para se comunicar com o Manager
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
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
                    break;
                case 2:
                    solicitarResumo(stub, "CASA");
                    break;
                case 3:
                    solicitarResumo(stub, "AMBOS");
                    break;
                case 4:
                    System.out.println("Saindo do programa.");
                    channel.shutdown();
                    return;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1. Resumo para a categoria ALIMENTAR");
        System.out.println("2. Resumo para a categoria CASA");
        System.out.println("3. Resumo para ambas as categorias");
        System.out.println("4. Sair");
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
                future.completeExceptionally(throwable);
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
