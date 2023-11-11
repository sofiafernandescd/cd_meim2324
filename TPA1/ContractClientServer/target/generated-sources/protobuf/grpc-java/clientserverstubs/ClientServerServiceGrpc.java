package clientserverstubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * serviço com operações sobre números
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: ClientServerService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ClientServerServiceGrpc {

  private ClientServerServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "clientserverservice.ClientServerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<clientserverstubs.ImageBlock,
      clientserverstubs.ImageStatusResponse> getProcessImageToServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "processImageToServer",
      requestType = clientserverstubs.ImageBlock.class,
      responseType = clientserverstubs.ImageStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<clientserverstubs.ImageBlock,
      clientserverstubs.ImageStatusResponse> getProcessImageToServerMethod() {
    io.grpc.MethodDescriptor<clientserverstubs.ImageBlock, clientserverstubs.ImageStatusResponse> getProcessImageToServerMethod;
    if ((getProcessImageToServerMethod = ClientServerServiceGrpc.getProcessImageToServerMethod) == null) {
      synchronized (ClientServerServiceGrpc.class) {
        if ((getProcessImageToServerMethod = ClientServerServiceGrpc.getProcessImageToServerMethod) == null) {
          ClientServerServiceGrpc.getProcessImageToServerMethod = getProcessImageToServerMethod =
              io.grpc.MethodDescriptor.<clientserverstubs.ImageBlock, clientserverstubs.ImageStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "processImageToServer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientserverstubs.ImageBlock.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientserverstubs.ImageStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ClientServerServiceMethodDescriptorSupplier("processImageToServer"))
              .build();
        }
      }
    }
    return getProcessImageToServerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<clientserverstubs.ImageStatusRequest,
      clientserverstubs.ImageStatusResponse> getCheckImageStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckImageStatus",
      requestType = clientserverstubs.ImageStatusRequest.class,
      responseType = clientserverstubs.ImageStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<clientserverstubs.ImageStatusRequest,
      clientserverstubs.ImageStatusResponse> getCheckImageStatusMethod() {
    io.grpc.MethodDescriptor<clientserverstubs.ImageStatusRequest, clientserverstubs.ImageStatusResponse> getCheckImageStatusMethod;
    if ((getCheckImageStatusMethod = ClientServerServiceGrpc.getCheckImageStatusMethod) == null) {
      synchronized (ClientServerServiceGrpc.class) {
        if ((getCheckImageStatusMethod = ClientServerServiceGrpc.getCheckImageStatusMethod) == null) {
          ClientServerServiceGrpc.getCheckImageStatusMethod = getCheckImageStatusMethod =
              io.grpc.MethodDescriptor.<clientserverstubs.ImageStatusRequest, clientserverstubs.ImageStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckImageStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientserverstubs.ImageStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientserverstubs.ImageStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ClientServerServiceMethodDescriptorSupplier("CheckImageStatus"))
              .build();
        }
      }
    }
    return getCheckImageStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<clientserverstubs.ImageDownloadRequestId,
      clientserverstubs.ImageBlock> getDownloadMarkedImageByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DownloadMarkedImageById",
      requestType = clientserverstubs.ImageDownloadRequestId.class,
      responseType = clientserverstubs.ImageBlock.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<clientserverstubs.ImageDownloadRequestId,
      clientserverstubs.ImageBlock> getDownloadMarkedImageByIdMethod() {
    io.grpc.MethodDescriptor<clientserverstubs.ImageDownloadRequestId, clientserverstubs.ImageBlock> getDownloadMarkedImageByIdMethod;
    if ((getDownloadMarkedImageByIdMethod = ClientServerServiceGrpc.getDownloadMarkedImageByIdMethod) == null) {
      synchronized (ClientServerServiceGrpc.class) {
        if ((getDownloadMarkedImageByIdMethod = ClientServerServiceGrpc.getDownloadMarkedImageByIdMethod) == null) {
          ClientServerServiceGrpc.getDownloadMarkedImageByIdMethod = getDownloadMarkedImageByIdMethod =
              io.grpc.MethodDescriptor.<clientserverstubs.ImageDownloadRequestId, clientserverstubs.ImageBlock>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DownloadMarkedImageById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientserverstubs.ImageDownloadRequestId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientserverstubs.ImageBlock.getDefaultInstance()))
              .setSchemaDescriptor(new ClientServerServiceMethodDescriptorSupplier("DownloadMarkedImageById"))
              .build();
        }
      }
    }
    return getDownloadMarkedImageByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<clientserverstubs.ImageDownloadRequestKeywords,
      clientserverstubs.ImageBlock> getDownloadMarkedImageByKeywordsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DownloadMarkedImageByKeywords",
      requestType = clientserverstubs.ImageDownloadRequestKeywords.class,
      responseType = clientserverstubs.ImageBlock.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<clientserverstubs.ImageDownloadRequestKeywords,
      clientserverstubs.ImageBlock> getDownloadMarkedImageByKeywordsMethod() {
    io.grpc.MethodDescriptor<clientserverstubs.ImageDownloadRequestKeywords, clientserverstubs.ImageBlock> getDownloadMarkedImageByKeywordsMethod;
    if ((getDownloadMarkedImageByKeywordsMethod = ClientServerServiceGrpc.getDownloadMarkedImageByKeywordsMethod) == null) {
      synchronized (ClientServerServiceGrpc.class) {
        if ((getDownloadMarkedImageByKeywordsMethod = ClientServerServiceGrpc.getDownloadMarkedImageByKeywordsMethod) == null) {
          ClientServerServiceGrpc.getDownloadMarkedImageByKeywordsMethod = getDownloadMarkedImageByKeywordsMethod =
              io.grpc.MethodDescriptor.<clientserverstubs.ImageDownloadRequestKeywords, clientserverstubs.ImageBlock>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DownloadMarkedImageByKeywords"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientserverstubs.ImageDownloadRequestKeywords.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientserverstubs.ImageBlock.getDefaultInstance()))
              .setSchemaDescriptor(new ClientServerServiceMethodDescriptorSupplier("DownloadMarkedImageByKeywords"))
              .build();
        }
      }
    }
    return getDownloadMarkedImageByKeywordsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClientServerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClientServerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ClientServerServiceStub>() {
        @java.lang.Override
        public ClientServerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ClientServerServiceStub(channel, callOptions);
        }
      };
    return ClientServerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClientServerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClientServerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ClientServerServiceBlockingStub>() {
        @java.lang.Override
        public ClientServerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ClientServerServiceBlockingStub(channel, callOptions);
        }
      };
    return ClientServerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClientServerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClientServerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ClientServerServiceFutureStub>() {
        @java.lang.Override
        public ClientServerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ClientServerServiceFutureStub(channel, callOptions);
        }
      };
    return ClientServerServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * serviço com operações sobre números
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * 2. Uma aplicação Cliente usa  operações que permitem realizar upload de imagens para um servidor, uma lista de keywords
     * a serem marcadas na imagem inicial e a obtenção posterior da correspondente imagem marcada;
     * Enviar uma imagem para processamento a um servidor específico
     * </pre>
     */
    default io.grpc.stub.StreamObserver<clientserverstubs.ImageBlock> processImageToServer(
        io.grpc.stub.StreamObserver<clientserverstubs.ImageStatusResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getProcessImageToServerMethod(), responseObserver);
    }

    /**
     * <pre>
     * 3. Um Cliente pode submeter um conjunto de imagens e só posteriormente pedir ao servidor para obter
     * (download) uma imagem marcada específica. Assim o servidor após receber uma imagem a processar
     * deve retornar um identificador único que identifique a imagem. Através desse identificador o Cliente
     * pode também interrogar o servidor se a imagem correspondente já foi processada, isto é, se já pode
     * fazer o download da imagem marcada;
     * Verificar o status de processamento de uma imagem
     * </pre>
     */
    default void checkImageStatus(clientserverstubs.ImageStatusRequest request,
        io.grpc.stub.StreamObserver<clientserverstubs.ImageStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckImageStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * Fazer o download de uma imagem marcada, pelo Id
     * </pre>
     */
    default void downloadMarkedImageById(clientserverstubs.ImageDownloadRequestId request,
        io.grpc.stub.StreamObserver<clientserverstubs.ImageBlock> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDownloadMarkedImageByIdMethod(), responseObserver);
    }

    /**
     * <pre>
     * Fazer o download de uma imagem marcada, pelas keywords
     * </pre>
     */
    default io.grpc.stub.StreamObserver<clientserverstubs.ImageDownloadRequestKeywords> downloadMarkedImageByKeywords(
        io.grpc.stub.StreamObserver<clientserverstubs.ImageBlock> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getDownloadMarkedImageByKeywordsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ClientServerService.
   * <pre>
   * serviço com operações sobre números
   * </pre>
   */
  public static abstract class ClientServerServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ClientServerServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ClientServerService.
   * <pre>
   * serviço com operações sobre números
   * </pre>
   */
  public static final class ClientServerServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ClientServerServiceStub> {
    private ClientServerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientServerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClientServerServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 2. Uma aplicação Cliente usa  operações que permitem realizar upload de imagens para um servidor, uma lista de keywords
     * a serem marcadas na imagem inicial e a obtenção posterior da correspondente imagem marcada;
     * Enviar uma imagem para processamento a um servidor específico
     * </pre>
     */
    public io.grpc.stub.StreamObserver<clientserverstubs.ImageBlock> processImageToServer(
        io.grpc.stub.StreamObserver<clientserverstubs.ImageStatusResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getProcessImageToServerMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * 3. Um Cliente pode submeter um conjunto de imagens e só posteriormente pedir ao servidor para obter
     * (download) uma imagem marcada específica. Assim o servidor após receber uma imagem a processar
     * deve retornar um identificador único que identifique a imagem. Através desse identificador o Cliente
     * pode também interrogar o servidor se a imagem correspondente já foi processada, isto é, se já pode
     * fazer o download da imagem marcada;
     * Verificar o status de processamento de uma imagem
     * </pre>
     */
    public void checkImageStatus(clientserverstubs.ImageStatusRequest request,
        io.grpc.stub.StreamObserver<clientserverstubs.ImageStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckImageStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Fazer o download de uma imagem marcada, pelo Id
     * </pre>
     */
    public void downloadMarkedImageById(clientserverstubs.ImageDownloadRequestId request,
        io.grpc.stub.StreamObserver<clientserverstubs.ImageBlock> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getDownloadMarkedImageByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Fazer o download de uma imagem marcada, pelas keywords
     * </pre>
     */
    public io.grpc.stub.StreamObserver<clientserverstubs.ImageDownloadRequestKeywords> downloadMarkedImageByKeywords(
        io.grpc.stub.StreamObserver<clientserverstubs.ImageBlock> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getDownloadMarkedImageByKeywordsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ClientServerService.
   * <pre>
   * serviço com operações sobre números
   * </pre>
   */
  public static final class ClientServerServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ClientServerServiceBlockingStub> {
    private ClientServerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientServerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClientServerServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 3. Um Cliente pode submeter um conjunto de imagens e só posteriormente pedir ao servidor para obter
     * (download) uma imagem marcada específica. Assim o servidor após receber uma imagem a processar
     * deve retornar um identificador único que identifique a imagem. Através desse identificador o Cliente
     * pode também interrogar o servidor se a imagem correspondente já foi processada, isto é, se já pode
     * fazer o download da imagem marcada;
     * Verificar o status de processamento de uma imagem
     * </pre>
     */
    public clientserverstubs.ImageStatusResponse checkImageStatus(clientserverstubs.ImageStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckImageStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Fazer o download de uma imagem marcada, pelo Id
     * </pre>
     */
    public java.util.Iterator<clientserverstubs.ImageBlock> downloadMarkedImageById(
        clientserverstubs.ImageDownloadRequestId request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getDownloadMarkedImageByIdMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ClientServerService.
   * <pre>
   * serviço com operações sobre números
   * </pre>
   */
  public static final class ClientServerServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ClientServerServiceFutureStub> {
    private ClientServerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientServerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClientServerServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 3. Um Cliente pode submeter um conjunto de imagens e só posteriormente pedir ao servidor para obter
     * (download) uma imagem marcada específica. Assim o servidor após receber uma imagem a processar
     * deve retornar um identificador único que identifique a imagem. Através desse identificador o Cliente
     * pode também interrogar o servidor se a imagem correspondente já foi processada, isto é, se já pode
     * fazer o download da imagem marcada;
     * Verificar o status de processamento de uma imagem
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<clientserverstubs.ImageStatusResponse> checkImageStatus(
        clientserverstubs.ImageStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckImageStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_IMAGE_STATUS = 0;
  private static final int METHODID_DOWNLOAD_MARKED_IMAGE_BY_ID = 1;
  private static final int METHODID_PROCESS_IMAGE_TO_SERVER = 2;
  private static final int METHODID_DOWNLOAD_MARKED_IMAGE_BY_KEYWORDS = 3;

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
        case METHODID_CHECK_IMAGE_STATUS:
          serviceImpl.checkImageStatus((clientserverstubs.ImageStatusRequest) request,
              (io.grpc.stub.StreamObserver<clientserverstubs.ImageStatusResponse>) responseObserver);
          break;
        case METHODID_DOWNLOAD_MARKED_IMAGE_BY_ID:
          serviceImpl.downloadMarkedImageById((clientserverstubs.ImageDownloadRequestId) request,
              (io.grpc.stub.StreamObserver<clientserverstubs.ImageBlock>) responseObserver);
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
        case METHODID_PROCESS_IMAGE_TO_SERVER:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.processImageToServer(
              (io.grpc.stub.StreamObserver<clientserverstubs.ImageStatusResponse>) responseObserver);
        case METHODID_DOWNLOAD_MARKED_IMAGE_BY_KEYWORDS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.downloadMarkedImageByKeywords(
              (io.grpc.stub.StreamObserver<clientserverstubs.ImageBlock>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getProcessImageToServerMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              clientserverstubs.ImageBlock,
              clientserverstubs.ImageStatusResponse>(
                service, METHODID_PROCESS_IMAGE_TO_SERVER)))
        .addMethod(
          getCheckImageStatusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              clientserverstubs.ImageStatusRequest,
              clientserverstubs.ImageStatusResponse>(
                service, METHODID_CHECK_IMAGE_STATUS)))
        .addMethod(
          getDownloadMarkedImageByIdMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              clientserverstubs.ImageDownloadRequestId,
              clientserverstubs.ImageBlock>(
                service, METHODID_DOWNLOAD_MARKED_IMAGE_BY_ID)))
        .addMethod(
          getDownloadMarkedImageByKeywordsMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              clientserverstubs.ImageDownloadRequestKeywords,
              clientserverstubs.ImageBlock>(
                service, METHODID_DOWNLOAD_MARKED_IMAGE_BY_KEYWORDS)))
        .build();
  }

  private static abstract class ClientServerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClientServerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return clientserverstubs.ClientServerServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ClientServerService");
    }
  }

  private static final class ClientServerServiceFileDescriptorSupplier
      extends ClientServerServiceBaseDescriptorSupplier {
    ClientServerServiceFileDescriptorSupplier() {}
  }

  private static final class ClientServerServiceMethodDescriptorSupplier
      extends ClientServerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ClientServerServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ClientServerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClientServerServiceFileDescriptorSupplier())
              .addMethod(getProcessImageToServerMethod())
              .addMethod(getCheckImageStatusMethod())
              .addMethod(getDownloadMarkedImageByIdMethod())
              .addMethod(getDownloadMarkedImageByKeywordsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
