package clientregisterstubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 1. Existe um servidor Register com localização (IP, porto) bem conhecida que funciona 
 * como serviço de registo dos N servidores de processamento de imagens. 
 * Os clientes recorrem a este servidor para obterem a localização (IP, porto) 
 * de um servidor (Server#N) de processamento de imagens, ao qual irão submeter pedidos;
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: ClientRegisterService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ClientRegisterServiceGrpc {

  private ClientRegisterServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "clientregisterservice.ClientRegisterService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<clientregisterstubs.ClientRequest,
      clientregisterstubs.ServerInfo> getGetServerEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServerEndpoint",
      requestType = clientregisterstubs.ClientRequest.class,
      responseType = clientregisterstubs.ServerInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<clientregisterstubs.ClientRequest,
      clientregisterstubs.ServerInfo> getGetServerEndpointMethod() {
    io.grpc.MethodDescriptor<clientregisterstubs.ClientRequest, clientregisterstubs.ServerInfo> getGetServerEndpointMethod;
    if ((getGetServerEndpointMethod = ClientRegisterServiceGrpc.getGetServerEndpointMethod) == null) {
      synchronized (ClientRegisterServiceGrpc.class) {
        if ((getGetServerEndpointMethod = ClientRegisterServiceGrpc.getGetServerEndpointMethod) == null) {
          ClientRegisterServiceGrpc.getGetServerEndpointMethod = getGetServerEndpointMethod =
              io.grpc.MethodDescriptor.<clientregisterstubs.ClientRequest, clientregisterstubs.ServerInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetServerEndpoint"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientregisterstubs.ClientRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientregisterstubs.ServerInfo.getDefaultInstance()))
              .setSchemaDescriptor(new ClientRegisterServiceMethodDescriptorSupplier("GetServerEndpoint"))
              .build();
        }
      }
    }
    return getGetServerEndpointMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClientRegisterServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClientRegisterServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ClientRegisterServiceStub>() {
        @java.lang.Override
        public ClientRegisterServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ClientRegisterServiceStub(channel, callOptions);
        }
      };
    return ClientRegisterServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClientRegisterServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClientRegisterServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ClientRegisterServiceBlockingStub>() {
        @java.lang.Override
        public ClientRegisterServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ClientRegisterServiceBlockingStub(channel, callOptions);
        }
      };
    return ClientRegisterServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClientRegisterServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClientRegisterServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ClientRegisterServiceFutureStub>() {
        @java.lang.Override
        public ClientRegisterServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ClientRegisterServiceFutureStub(channel, callOptions);
        }
      };
    return ClientRegisterServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 1. Existe um servidor Register com localização (IP, porto) bem conhecida que funciona 
   * como serviço de registo dos N servidores de processamento de imagens. 
   * Os clientes recorrem a este servidor para obterem a localização (IP, porto) 
   * de um servidor (Server#N) de processamento de imagens, ao qual irão submeter pedidos;
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Obter o EndPoint de um servidor Server
     * </pre>
     */
    default void getServerEndpoint(clientregisterstubs.ClientRequest request,
        io.grpc.stub.StreamObserver<clientregisterstubs.ServerInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetServerEndpointMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ClientRegisterService.
   * <pre>
   * 1. Existe um servidor Register com localização (IP, porto) bem conhecida que funciona 
   * como serviço de registo dos N servidores de processamento de imagens. 
   * Os clientes recorrem a este servidor para obterem a localização (IP, porto) 
   * de um servidor (Server#N) de processamento de imagens, ao qual irão submeter pedidos;
   * </pre>
   */
  public static abstract class ClientRegisterServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ClientRegisterServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ClientRegisterService.
   * <pre>
   * 1. Existe um servidor Register com localização (IP, porto) bem conhecida que funciona 
   * como serviço de registo dos N servidores de processamento de imagens. 
   * Os clientes recorrem a este servidor para obterem a localização (IP, porto) 
   * de um servidor (Server#N) de processamento de imagens, ao qual irão submeter pedidos;
   * </pre>
   */
  public static final class ClientRegisterServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ClientRegisterServiceStub> {
    private ClientRegisterServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientRegisterServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClientRegisterServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Obter o EndPoint de um servidor Server
     * </pre>
     */
    public void getServerEndpoint(clientregisterstubs.ClientRequest request,
        io.grpc.stub.StreamObserver<clientregisterstubs.ServerInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServerEndpointMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ClientRegisterService.
   * <pre>
   * 1. Existe um servidor Register com localização (IP, porto) bem conhecida que funciona 
   * como serviço de registo dos N servidores de processamento de imagens. 
   * Os clientes recorrem a este servidor para obterem a localização (IP, porto) 
   * de um servidor (Server#N) de processamento de imagens, ao qual irão submeter pedidos;
   * </pre>
   */
  public static final class ClientRegisterServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ClientRegisterServiceBlockingStub> {
    private ClientRegisterServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientRegisterServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClientRegisterServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Obter o EndPoint de um servidor Server
     * </pre>
     */
    public clientregisterstubs.ServerInfo getServerEndpoint(clientregisterstubs.ClientRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServerEndpointMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ClientRegisterService.
   * <pre>
   * 1. Existe um servidor Register com localização (IP, porto) bem conhecida que funciona 
   * como serviço de registo dos N servidores de processamento de imagens. 
   * Os clientes recorrem a este servidor para obterem a localização (IP, porto) 
   * de um servidor (Server#N) de processamento de imagens, ao qual irão submeter pedidos;
   * </pre>
   */
  public static final class ClientRegisterServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ClientRegisterServiceFutureStub> {
    private ClientRegisterServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientRegisterServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClientRegisterServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Obter o EndPoint de um servidor Server
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<clientregisterstubs.ServerInfo> getServerEndpoint(
        clientregisterstubs.ClientRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServerEndpointMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SERVER_ENDPOINT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_SERVER_ENDPOINT:
          serviceImpl.getServerEndpoint((clientregisterstubs.ClientRequest) request,
              (io.grpc.stub.StreamObserver<clientregisterstubs.ServerInfo>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetServerEndpointMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              clientregisterstubs.ClientRequest,
              clientregisterstubs.ServerInfo>(
                service, METHODID_GET_SERVER_ENDPOINT)))
        .build();
  }

  private static abstract class ClientRegisterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClientRegisterServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return clientregisterstubs.ClientRegisterServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ClientRegisterService");
    }
  }

  private static final class ClientRegisterServiceFileDescriptorSupplier
      extends ClientRegisterServiceBaseDescriptorSupplier {
    ClientRegisterServiceFileDescriptorSupplier() {}
  }

  private static final class ClientRegisterServiceMethodDescriptorSupplier
      extends ClientRegisterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ClientRegisterServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ClientRegisterServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClientRegisterServiceFileDescriptorSupplier())
              .addMethod(getGetServerEndpointMethod())
              .build();
        }
      }
    }
    return result;
  }
}
