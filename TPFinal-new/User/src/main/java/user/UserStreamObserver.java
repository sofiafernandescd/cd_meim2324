package user;

import io.grpc.stub.StreamObserver;
import manageruserstubs.Resume;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserStreamObserver implements StreamObserver<Resume>{
    private boolean isCompleted=false;
    private boolean success=false;

    public boolean OnSuccess() { return success; }
    public boolean isCompleted() { return isCompleted; }
    List<byte[]> results = new ArrayList<>();

    String categoria;

    @Override
    public void onNext(Resume resumeBlock) {
        System.out.println("Carregando Resumo");
        results.add(resumeBlock.getData().toByteArray());
        if(categoria == null){
            categoria = resumeBlock.getCategory();
        }
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Error on call:"+ throwable.getMessage());
        isCompleted=true; success=false;
    }

    @Override
    public void onCompleted() {
        byte[] resumo = agruparBlocos(results);
        String path = System.getProperty("user.dir") + "resumo.txt";
        String downloadPath = path.replaceAll("target", "");
        downloadFile(resumo, downloadPath);
        System.out.println("Resumo Completo");
        isCompleted = true;
        success = true;
    }

    // Função para agrupar vários blocos de bytes em uma única mensagem
    private static byte[] agruparBlocos(List<byte[]> blocos) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            for (byte[] bloco : blocos) {
                outputStream.write(bloco);
            }
            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    private static void downloadFile(byte[] data, String filePath) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(data);
            System.out.println("File downloaded successfully to: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error downloading file: " + e.getMessage());
        }
    }
}
