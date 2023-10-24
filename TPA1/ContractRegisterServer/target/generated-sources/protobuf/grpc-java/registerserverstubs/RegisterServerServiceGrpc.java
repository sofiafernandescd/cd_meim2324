package registerserverstubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * serviço com operações sobre números
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
  private static volatile io.grpc.MethodDescriptor<registerserverstubs.AddOperands,
      registerserverstubs.Result> getAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "add",
      requestType = registerserverstubs.AddOperands.class,
      responseType = registerserverstubs.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<registerserverstubs.AddOperands,
      registerserverstubs.Result> getAddMethod() {
    io.grpc.MethodDescriptor<registerserverstubs.AddOperands, registerserverstubs.Result> getAddMethod;
    if ((getAddMethod = RegisterServerServiceGrpc.getAddMethod) == null) {
      synchronized (RegisterServerServiceGrpc.class) {
        if ((getAddMethod = RegisterServerServiceGrpc.getAddMethod) == null) {
          RegisterServerServiceGrpc.getAddMethod = getAddMethod =
              io.grpc.MethodDescriptor.<registerserverstubs.AddOperands, registerserverstubs.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  registerserverstubs.AddOperands.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  registerserverstubs.Result.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterServerServiceMethodDescriptorSupplier("add"))
              .build();
        }
      }
    }
    return getAddMethod;
  }

  private static volatile io.grpc.MethodDescriptor<registerserverstubs.NumberAndMaxExponent,
      registerserverstubs.Result> getGeneratePowersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "generatePowers",
      requestType = registerserverstubs.NumberAndMaxExponent.class,
      responseType = registerserverstubs.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<registerserverstubs.NumberAndMaxExponent,
      registerserverstubs.Result> getGeneratePowersMethod() {
    io.grpc.MethodDescriptor<registerserverstubs.NumberAndMaxExponent, registerserverstubs.Result> getGeneratePowersMethod;
    if ((getGeneratePowersMethod = RegisterServerServiceGrpc.getGeneratePowersMethod) == null) {
      synchronized (RegisterServerServiceGrpc.class) {
        if ((getGeneratePowersMethod = RegisterServerServiceGrpc.getGeneratePowersMethod) == null) {
          RegisterServerServiceGrpc.getGeneratePowersMethod = getGeneratePowersMethod =
              io.grpc.MethodDescriptor.<registerserverstubs.NumberAndMaxExponent, registerserverstubs.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "generatePowers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  registerserverstubs.NumberAndMaxExponent.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  registerserverstubs.Result.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterServerServiceMethodDescriptorSupplier("generatePowers"))
              .build();
        }
      }
    }
    return getGeneratePowersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<registerserverstubs.Number,
      registerserverstubs.Result> getAddSeqOfNumbersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addSeqOfNumbers",
      requestType = registerserverstubs.Number.class,
      responseType = registerserverstubs.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<registerserverstubs.Number,
      registerserverstubs.Result> getAddSeqOfNumbersMethod() {
    io.grpc.MethodDescriptor<registerserverstubs.Number, registerserverstubs.Result> getAddSeqOfNumbersMethod;
    if ((getAddSeqOfNumbersMethod = RegisterServerServiceGrpc.getAddSeqOfNumbersMethod) == null) {
      synchronized (RegisterServerServiceGrpc.class) {
        if ((getAddSeqOfNumbersMethod = RegisterServerServiceGrpc.getAddSeqOfNumbersMethod) == null) {
          RegisterServerServiceGrpc.getAddSeqOfNumbersMethod = getAddSeqOfNumbersMethod =
              io.grpc.MethodDescriptor.<registerserverstubs.Number, registerserverstubs.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addSeqOfNumbers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  registerserverstubs.Number.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  registerserverstubs.Result.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterServerServiceMethodDescriptorSupplier("addSeqOfNumbers"))
              .build();
        }
      }
    }
    return getAddSeqOfNumbersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<registerserverstubs.AddOperands,
      registerserverstubs.Result> getMultipleAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "multipleAdd",
      requestType = registerserverstubs.AddOperands.class,
      responseType = registerserverstubs.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<registerserverstubs.AddOperands,
      registerserverstubs.Result> getMultipleAddMethod() {
    io.grpc.MethodDescriptor<registerserverstubs.AddOperands, registerserverstubs.Result> getMultipleAddMethod;
    if ((getMultipleAddMethod = RegisterServerServiceGrpc.getMultipleAddMethod) == null) {
      synchronized (RegisterServerServiceGrpc.class) {
        if ((getMultipleAddMethod = RegisterServerServiceGrpc.getMultipleAddMethod) == null) {
          RegisterServerServiceGrpc.getMultipleAddMethod = getMultipleAddMethod =
              io.grpc.MethodDescriptor.<registerserverstubs.AddOperands, registerserverstubs.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "multipleAdd"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  registerserverstubs.AddOperands.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  registerserverstubs.Result.getDefaultInstance()))
              .setSchemaDescriptor(new RegisterServerServiceMethodDescriptorSupplier("multipleAdd"))
              .build();
        }
      }
    }
    return getMultipleAddMethod;
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
   * serviço com operações sobre números
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * add two numbers
     * </pre>
     */
    default void add(registerserverstubs.AddOperands request,
        io.grpc.stub.StreamObserver<registerserverstubs.Result> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddMethod(), responseObserver);
    }

    /**
     * <pre>
     * generate the number powers with exponents betwwen 1 and maximum 
     * </pre>
     */
    default void generatePowers(registerserverstubs.NumberAndMaxExponent request,
        io.grpc.stub.StreamObserver<registerserverstubs.Result> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGeneratePowersMethod(), responseObserver);
    }

    /**
     * <pre>
     * add a sequence of numbers, ex: 1,2, 10, 5 = 18
     * </pre>
     */
    default io.grpc.stub.StreamObserver<registerserverstubs.Number> addSeqOfNumbers(
        io.grpc.stub.StreamObserver<registerserverstubs.Result> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getAddSeqOfNumbersMethod(), responseObserver);
    }

    /**
     * <pre>
     * Multiple add operations using a bidirecional stream
     * </pre>
     */
    default io.grpc.stub.StreamObserver<registerserverstubs.AddOperands> multipleAdd(
        io.grpc.stub.StreamObserver<registerserverstubs.Result> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getMultipleAddMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RegisterServerService.
   * <pre>
   * serviço com operações sobre números
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
   * serviço com operações sobre números
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
     * add two numbers
     * </pre>
     */
    public void add(registerserverstubs.AddOperands request,
        io.grpc.stub.StreamObserver<registerserverstubs.Result> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * generate the number powers with exponents betwwen 1 and maximum 
     * </pre>
     */
    public void generatePowers(registerserverstubs.NumberAndMaxExponent request,
        io.grpc.stub.StreamObserver<registerserverstubs.Result> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGeneratePowersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * add a sequence of numbers, ex: 1,2, 10, 5 = 18
     * </pre>
     */
    public io.grpc.stub.StreamObserver<registerserverstubs.Number> addSeqOfNumbers(
        io.grpc.stub.StreamObserver<registerserverstubs.Result> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getAddSeqOfNumbersMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Multiple add operations using a bidirecional stream
     * </pre>
     */
    public io.grpc.stub.StreamObserver<registerserverstubs.AddOperands> multipleAdd(
        io.grpc.stub.StreamObserver<registerserverstubs.Result> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getMultipleAddMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RegisterServerService.
   * <pre>
   * serviço com operações sobre números
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
     * add two numbers
     * </pre>
     */
    public registerserverstubs.Result add(registerserverstubs.AddOperands request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * generate the number powers with exponents betwwen 1 and maximum 
     * </pre>
     */
    public java.util.Iterator<registerserverstubs.Result> generatePowers(
        registerserverstubs.NumberAndMaxExponent request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGeneratePowersMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service RegisterServerService.
   * <pre>
   * serviço com operações sobre números
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
     * add two numbers
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<registerserverstubs.Result> add(
        registerserverstubs.AddOperands request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD = 0;
  private static final int METHODID_GENERATE_POWERS = 1;
  private static final int METHODID_ADD_SEQ_OF_NUMBERS = 2;
  private static final int METHODID_MULTIPLE_ADD = 3;

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
        case METHODID_ADD:
          serviceImpl.add((registerserverstubs.AddOperands) request,
              (io.grpc.stub.StreamObserver<registerserverstubs.Result>) responseObserver);
          break;
        case METHODID_GENERATE_POWERS:
          serviceImpl.generatePowers((registerserverstubs.NumberAndMaxExponent) request,
              (io.grpc.stub.StreamObserver<registerserverstubs.Result>) responseObserver);
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
        case METHODID_ADD_SEQ_OF_NUMBERS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.addSeqOfNumbers(
              (io.grpc.stub.StreamObserver<registerserverstubs.Result>) responseObserver);
        case METHODID_MULTIPLE_ADD:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.multipleAdd(
              (io.grpc.stub.StreamObserver<registerserverstubs.Result>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getAddMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              registerserverstubs.AddOperands,
              registerserverstubs.Result>(
                service, METHODID_ADD)))
        .addMethod(
          getGeneratePowersMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              registerserverstubs.NumberAndMaxExponent,
              registerserverstubs.Result>(
                service, METHODID_GENERATE_POWERS)))
        .addMethod(
          getAddSeqOfNumbersMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              registerserverstubs.Number,
              registerserverstubs.Result>(
                service, METHODID_ADD_SEQ_OF_NUMBERS)))
        .addMethod(
          getMultipleAddMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              registerserverstubs.AddOperands,
              registerserverstubs.Result>(
                service, METHODID_MULTIPLE_ADD)))
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
              .addMethod(getAddMethod())
              .addMethod(getGeneratePowersMethod())
              .addMethod(getAddSeqOfNumbersMethod())
              .addMethod(getMultipleAddMethod())
              .build();
        }
      }
    }
    return result;
  }
}
