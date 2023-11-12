package registerserverstubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Serviço de registo de servidores
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: RegisterServerService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RegisterServerServiceGrpc {

  private RegisterServerServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "registerserverservice.RegisterServerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<registerserverstubs.ServerInfo,
      registerserverstubs.ServerResponse> getRegistServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "registServer",
      requestType = registerserverstubs.ServerInfo.class,
      responseType = registerserverstubs.ServerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<registerserverstubs.ServerInfo,
      registerserverstubs.ServerResponse> getRegistServerMethod() {
    io.grpc.MethodDescriptor<registerserverstubs.ServerInfo, registerserverstubs.ServerResponse> getRegistServerMethod;
    if ((getRegistServerMethod = RegisterServerServiceGrpc.getRegistServerMethod) == null) {
      synchronized (RegisterServerServiceGrpc.class) {
        if ((getRegistServerMethod = RegisterServerServiceGrpc.getRegistServerMethod) == null) {
          RegisterServerServiceGrpc.getRegistServerMethod = getRegistServerMethod =
              io.grpc.MethodDescriptor.<registerserverstubs.ServerInfo, registerserverstubs.ServerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "registServer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  registerserverstubs.ServerInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  registerserverstubs.ServerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterServerServiceMethodDescriptorSupplier("registServer"))
              .build();
        }
      }
    }
    return getRegistServerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RegisterServerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegisterServerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegisterServerServiceStub>() {
        @java.lang.Override
        public RegisterServerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegisterServerServiceStub(channel, callOptions);
        }
      };
    return RegisterServerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegisterServerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegisterServerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegisterServerServiceBlockingStub>() {
        @java.lang.Override
        public RegisterServerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegisterServerServiceBlockingStub(channel, callOptions);
        }
      };
    return RegisterServerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RegisterServerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegisterServerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegisterServerServiceFutureStub>() {
        @java.lang.Override
        public RegisterServerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegisterServerServiceFutureStub(channel, callOptions);
        }
      };
    return RegisterServerServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Serviço de registo de servidores
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * 1. Existe um servidor Register com localização (IP, porto) bem conhecida que funciona
     * como serviço de registo dos N servidores de processamento de imagens.
     * </pre>
     */
    default void registServer(registerserverstubs.ServerInfo request,
        io.grpc.stub.StreamObserver<registerserverstubs.ServerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegistServerMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RegisterServerService.
   * <pre>
   * Serviço de registo de servidores
   * </pre>
   */
  public static abstract class RegisterServerServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return RegisterServerServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RegisterServerService.
   * <pre>
   * Serviço de registo de servidores
   * </pre>
   */
  public static final class RegisterServerServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RegisterServerServiceStub> {
    private RegisterServerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterServerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegisterServerServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 1. Existe um servidor Register com localização (IP, porto) bem conhecida que funciona
     * como serviço de registo dos N servidores de processamento de imagens.
     * </pre>
     */
    public void registServer(registerserverstubs.ServerInfo request,
        io.grpc.stub.StreamObserver<registerserverstubs.ServerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegistServerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RegisterServerService.
   * <pre>
   * Serviço de registo de servidores
   * </pre>
   */
  public static final class RegisterServerServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RegisterServerServiceBlockingStub> {
    private RegisterServerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterServerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegisterServerServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 1. Existe um servidor Register com localização (IP, porto) bem conhecida que funciona
     * como serviço de registo dos N servidores de processamento de imagens.
     * </pre>
     */
    public registerserverstubs.ServerResponse registServer(registerserverstubs.ServerInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegistServerMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service RegisterServerService.
   * <pre>
   * Serviço de registo de servidores
   * </pre>
   */
  public static final class RegisterServerServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RegisterServerServiceFutureStub> {
    private RegisterServerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegisterServerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegisterServerServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 1. Existe um servidor Register com localização (IP, porto) bem conhecida que funciona
     * como serviço de registo dos N servidores de processamento de imagens.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<registerserverstubs.ServerResponse> registServer(
        registerserverstubs.ServerInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegistServerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGIST_SERVER = 0;

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
        case METHODID_REGIST_SERVER:
          serviceImpl.registServer((registerserverstubs.ServerInfo) request,
              (io.grpc.stub.StreamObserver<registerserverstubs.ServerResponse>) responseObserver);
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
          getRegistServerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              registerserverstubs.ServerInfo,
              registerserverstubs.ServerResponse>(
                service, METHODID_REGIST_SERVER)))
        .build();
  }

  private static abstract class RegisterServerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegisterServerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return registerserverstubs.RegisterServerServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RegisterServerService");
    }
  }

  private static final class RegisterServerServiceFileDescriptorSupplier
      extends RegisterServerServiceBaseDescriptorSupplier {
    RegisterServerServiceFileDescriptorSupplier() {}
  }

  private static final class RegisterServerServiceMethodDescriptorSupplier
      extends RegisterServerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RegisterServerServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (RegisterServerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RegisterServerServiceFileDescriptorSupplier())
              .addMethod(getRegistServerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
