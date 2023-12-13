package manager;

import com.google.protobuf.ByteString;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import manageruserstubs.Category;
import manageruserstubs.ContractManagerUserGrpc;
import manageruserstubs.Resume;
import spread.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;




public class ManagerServerGrpc extends ContractManagerUserGrpc.ContractManagerUserImplBase {
    public final String ipInterno;

    public ManagerServerGrpc(String ipInterno) {
        this.ipInterno = ipInterno;
    }

    //    private SpreadGroup spreadGroup;
    public static void main(String[] args) throws Exception {
        String ipInterno = args[0];
        Server server = ServerBuilder.forPort(9090)
                .addService(new ManagerServerGrpc(ipInterno))
                .build();

        System.out.println("Iniciando servidor gRPC na porta 9090");
        server.start();
        server.awaitTermination();
    }

    @Override
    public void getResume(Category request, StreamObserver<Resume> responseObserver) {
        final SpreadConnection spreadConnection;
        spreadConnection = new SpreadConnection();
        SpreadGroup spreadGroup = new SpreadGroup();
        try {
            spreadConnection.connect(InetAddress.getByName(ipInterno), 4803, "Manager", false, true);
            spreadGroup.join(spreadConnection, "SpreadGroup" + request.getCategory());
        } catch (SpreadException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        // Lógica para processar o pedido de resumo e enviar várias vendas
        String categoria = request.getCategory();

        // Sample data as a string (you should replace this with your actual data)
        String resumeDataString = "This is a sample resume data.";

        // Convert the string to bytes
        byte[] resumeBlockFromExchange = resumeDataString.getBytes();

        // Now you can proceed with the rest of your code
        byte[] resumeBlock = resumeBlockFromExchange;

        Resume resume = Resume.newBuilder()
                                  .setCategory(request.getCategory())
                                  .setData(ByteString.copyFrom(resumeBlock))
                                  .build();
        // Envie cada venda para o cliente
        responseObserver.onNext(resume);


        // Sinalize o término do fluxo
        responseObserver.onCompleted();

        // Solicita que os Workers realizem o resumo
        SpreadMessage spreadMessage = new SpreadMessage();
        spreadMessage.setSafe();
        spreadMessage.addGroup(spreadGroup);
        spreadMessage.setData(("RESUME_REQUEST " + categoria + " summary.txt").getBytes());
        try {

            spreadConnection.multicast(spreadMessage);
        } catch (SpreadException e) {
            e.printStackTrace();
        }
    }
}
