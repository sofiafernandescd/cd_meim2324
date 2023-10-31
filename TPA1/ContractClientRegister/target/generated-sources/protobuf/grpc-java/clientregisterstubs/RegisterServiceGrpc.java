package clientregisterstubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: ClientRegisterService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RegisterServiceGrpc {

  private RegisterServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "clientregisterservice.RegisterService";

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
    if ((getGetServerEndpointMethod = RegisterServiceGrpc.getGetServerEndpointMethod) == null) {
      synchronized (RegisterServiceGrpc.class) {
        if ((getGetServerEndpointMethod = RegisterServiceGrpc.getGetServerEndpointMethod) == null) {
          RegisterServiceGrpc.getGetServerEndpointMethod = getGetServerEndpointMethod =
              io.grpc.MethodDescriptor.<clientregisterstubs.ClientRequest, clientregisterstubs.ServerInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetServerEndpoint"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientregisterstubs.ClientRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientregisterstubs.ServerInfo.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterServiceMethodDescriptorSupplier("GetServerEndpoint"))
              .build();
        }
      }
    }
    return getGetServerEndpointMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RegisterServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegisterServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegisterServiceStub>() {
        @java.lang.Override
        public RegisterServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegisterServiceStub(channel, callOptions);
        }
      };
    return RegisterServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegisterServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegisterServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegisterServiceBlockingStub>() {
        @java.lang.Override
        public RegisterServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegisterServiceBlockingStub(channel, callOptions);
        }
      };
    return RegisterServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RegisterServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegisterServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegisterServiceFutureStub>() {
        @java.lang.Override
        public RegisterServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegisterServiceFutureStub(channel, callOptions);
        }
      };
    return RegisterServiceFutureStub.newStub(factory, channel);
  }

  /**
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
   * Base class for the server implementation of the service RegisterService.
   */
  public static abstract class RegisterServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return RegisterServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RegisterService.
   */
  public static final class RegisterServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RegisterServiceStub> {
    private RegisterServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegisterServiceStub(channel, callOptions);
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
   * A stub to allow clients to do synchronous rpc calls to service RegisterService.
   */
  public static final class RegisterServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RegisterServiceBlockingStub> {
    private RegisterServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegisterServiceBlockingStub(channel, callOptions);
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
   * A stub to allow clients to do ListenableFuture-style rpc calls to service RegisterService.
   */
  public static final class RegisterServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RegisterServiceFutureStub> {
    private RegisterServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegisterServiceFutureStub(channel, callOptions);
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

  private static abstract class RegisterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegisterServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return clientregisterstubs.ClientRegisterServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RegisterService");
    }
  }

  private static final class RegisterServiceFileDescriptorSupplier
      extends RegisterServiceBaseDescriptorSupplier {
    RegisterServiceFileDescriptorSupplier() {}
  }

  private static final class RegisterServiceMethodDescriptorSupplier
      extends RegisterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RegisterServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (RegisterServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RegisterServiceFileDescriptorSupplier())
              .addMethod(getGetServerEndpointMethod())
              .build();
        }
      }
    }
    return result;
  }
}
