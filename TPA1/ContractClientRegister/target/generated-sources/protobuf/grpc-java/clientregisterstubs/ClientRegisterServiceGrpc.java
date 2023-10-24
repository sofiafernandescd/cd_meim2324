package clientregisterstubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * serviço com operações sobre números
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
  private static volatile io.grpc.MethodDescriptor<clientregisterstubs.AddOperands,
      clientregisterstubs.Result> getAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "add",
      requestType = clientregisterstubs.AddOperands.class,
      responseType = clientregisterstubs.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<clientregisterstubs.AddOperands,
      clientregisterstubs.Result> getAddMethod() {
    io.grpc.MethodDescriptor<clientregisterstubs.AddOperands, clientregisterstubs.Result> getAddMethod;
    if ((getAddMethod = ClientRegisterServiceGrpc.getAddMethod) == null) {
      synchronized (ClientRegisterServiceGrpc.class) {
        if ((getAddMethod = ClientRegisterServiceGrpc.getAddMethod) == null) {
          ClientRegisterServiceGrpc.getAddMethod = getAddMethod =
              io.grpc.MethodDescriptor.<clientregisterstubs.AddOperands, clientregisterstubs.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientregisterstubs.AddOperands.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientregisterstubs.Result.getDefaultInstance()))
              .setSchemaDescriptor(new ClientRegisterServiceMethodDescriptorSupplier("add"))
              .build();
        }
      }
    }
    return getAddMethod;
  }

  private static volatile io.grpc.MethodDescriptor<clientregisterstubs.NumberAndMaxExponent,
      clientregisterstubs.Result> getGeneratePowersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "generatePowers",
      requestType = clientregisterstubs.NumberAndMaxExponent.class,
      responseType = clientregisterstubs.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<clientregisterstubs.NumberAndMaxExponent,
      clientregisterstubs.Result> getGeneratePowersMethod() {
    io.grpc.MethodDescriptor<clientregisterstubs.NumberAndMaxExponent, clientregisterstubs.Result> getGeneratePowersMethod;
    if ((getGeneratePowersMethod = ClientRegisterServiceGrpc.getGeneratePowersMethod) == null) {
      synchronized (ClientRegisterServiceGrpc.class) {
        if ((getGeneratePowersMethod = ClientRegisterServiceGrpc.getGeneratePowersMethod) == null) {
          ClientRegisterServiceGrpc.getGeneratePowersMethod = getGeneratePowersMethod =
              io.grpc.MethodDescriptor.<clientregisterstubs.NumberAndMaxExponent, clientregisterstubs.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "generatePowers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientregisterstubs.NumberAndMaxExponent.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientregisterstubs.Result.getDefaultInstance()))
              .setSchemaDescriptor(new ClientRegisterServiceMethodDescriptorSupplier("generatePowers"))
              .build();
        }
      }
    }
    return getGeneratePowersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<clientregisterstubs.Number,
      clientregisterstubs.Result> getAddSeqOfNumbersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addSeqOfNumbers",
      requestType = clientregisterstubs.Number.class,
      responseType = clientregisterstubs.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<clientregisterstubs.Number,
      clientregisterstubs.Result> getAddSeqOfNumbersMethod() {
    io.grpc.MethodDescriptor<clientregisterstubs.Number, clientregisterstubs.Result> getAddSeqOfNumbersMethod;
    if ((getAddSeqOfNumbersMethod = ClientRegisterServiceGrpc.getAddSeqOfNumbersMethod) == null) {
      synchronized (ClientRegisterServiceGrpc.class) {
        if ((getAddSeqOfNumbersMethod = ClientRegisterServiceGrpc.getAddSeqOfNumbersMethod) == null) {
          ClientRegisterServiceGrpc.getAddSeqOfNumbersMethod = getAddSeqOfNumbersMethod =
              io.grpc.MethodDescriptor.<clientregisterstubs.Number, clientregisterstubs.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addSeqOfNumbers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientregisterstubs.Number.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientregisterstubs.Result.getDefaultInstance()))
              .setSchemaDescriptor(new ClientRegisterServiceMethodDescriptorSupplier("addSeqOfNumbers"))
              .build();
        }
      }
    }
    return getAddSeqOfNumbersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<clientregisterstubs.AddOperands,
      clientregisterstubs.Result> getMultipleAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "multipleAdd",
      requestType = clientregisterstubs.AddOperands.class,
      responseType = clientregisterstubs.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<clientregisterstubs.AddOperands,
      clientregisterstubs.Result> getMultipleAddMethod() {
    io.grpc.MethodDescriptor<clientregisterstubs.AddOperands, clientregisterstubs.Result> getMultipleAddMethod;
    if ((getMultipleAddMethod = ClientRegisterServiceGrpc.getMultipleAddMethod) == null) {
      synchronized (ClientRegisterServiceGrpc.class) {
        if ((getMultipleAddMethod = ClientRegisterServiceGrpc.getMultipleAddMethod) == null) {
          ClientRegisterServiceGrpc.getMultipleAddMethod = getMultipleAddMethod =
              io.grpc.MethodDescriptor.<clientregisterstubs.AddOperands, clientregisterstubs.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "multipleAdd"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientregisterstubs.AddOperands.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientregisterstubs.Result.getDefaultInstance()))
              .setSchemaDescriptor(new ClientRegisterServiceMethodDescriptorSupplier("multipleAdd"))
              .build();
        }
      }
    }
    return getMultipleAddMethod;
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
   * serviço com operações sobre números
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * add two numbers
     * </pre>
     */
    default void add(clientregisterstubs.AddOperands request,
        io.grpc.stub.StreamObserver<clientregisterstubs.Result> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddMethod(), responseObserver);
    }

    /**
     * <pre>
     * generate the number powers with exponents betwwen 1 and maximum 
     * </pre>
     */
    default void generatePowers(clientregisterstubs.NumberAndMaxExponent request,
        io.grpc.stub.StreamObserver<clientregisterstubs.Result> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGeneratePowersMethod(), responseObserver);
    }

    /**
     * <pre>
     * add a sequence of numbers, ex: 1,2, 10, 5 = 18
     * </pre>
     */
    default io.grpc.stub.StreamObserver<clientregisterstubs.Number> addSeqOfNumbers(
        io.grpc.stub.StreamObserver<clientregisterstubs.Result> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getAddSeqOfNumbersMethod(), responseObserver);
    }

    /**
     * <pre>
     * Multiple add operations using a bidirecional stream
     * </pre>
     */
    default io.grpc.stub.StreamObserver<clientregisterstubs.AddOperands> multipleAdd(
        io.grpc.stub.StreamObserver<clientregisterstubs.Result> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getMultipleAddMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ClientRegisterService.
   * <pre>
   * serviço com operações sobre números
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
   * serviço com operações sobre números
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
     * add two numbers
     * </pre>
     */
    public void add(clientregisterstubs.AddOperands request,
        io.grpc.stub.StreamObserver<clientregisterstubs.Result> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * generate the number powers with exponents betwwen 1 and maximum 
     * </pre>
     */
    public void generatePowers(clientregisterstubs.NumberAndMaxExponent request,
        io.grpc.stub.StreamObserver<clientregisterstubs.Result> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGeneratePowersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * add a sequence of numbers, ex: 1,2, 10, 5 = 18
     * </pre>
     */
    public io.grpc.stub.StreamObserver<clientregisterstubs.Number> addSeqOfNumbers(
        io.grpc.stub.StreamObserver<clientregisterstubs.Result> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getAddSeqOfNumbersMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Multiple add operations using a bidirecional stream
     * </pre>
     */
    public io.grpc.stub.StreamObserver<clientregisterstubs.AddOperands> multipleAdd(
        io.grpc.stub.StreamObserver<clientregisterstubs.Result> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getMultipleAddMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ClientRegisterService.
   * <pre>
   * serviço com operações sobre números
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
     * add two numbers
     * </pre>
     */
    public clientregisterstubs.Result add(clientregisterstubs.AddOperands request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * generate the number powers with exponents betwwen 1 and maximum 
     * </pre>
     */
    public java.util.Iterator<clientregisterstubs.Result> generatePowers(
        clientregisterstubs.NumberAndMaxExponent request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGeneratePowersMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ClientRegisterService.
   * <pre>
   * serviço com operações sobre números
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
     * add two numbers
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<clientregisterstubs.Result> add(
        clientregisterstubs.AddOperands request) {
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
          serviceImpl.add((clientregisterstubs.AddOperands) request,
              (io.grpc.stub.StreamObserver<clientregisterstubs.Result>) responseObserver);
          break;
        case METHODID_GENERATE_POWERS:
          serviceImpl.generatePowers((clientregisterstubs.NumberAndMaxExponent) request,
              (io.grpc.stub.StreamObserver<clientregisterstubs.Result>) responseObserver);
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
              (io.grpc.stub.StreamObserver<clientregisterstubs.Result>) responseObserver);
        case METHODID_MULTIPLE_ADD:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.multipleAdd(
              (io.grpc.stub.StreamObserver<clientregisterstubs.Result>) responseObserver);
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
              clientregisterstubs.AddOperands,
              clientregisterstubs.Result>(
                service, METHODID_ADD)))
        .addMethod(
          getGeneratePowersMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              clientregisterstubs.NumberAndMaxExponent,
              clientregisterstubs.Result>(
                service, METHODID_GENERATE_POWERS)))
        .addMethod(
          getAddSeqOfNumbersMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              clientregisterstubs.Number,
              clientregisterstubs.Result>(
                service, METHODID_ADD_SEQ_OF_NUMBERS)))
        .addMethod(
          getMultipleAddMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              clientregisterstubs.AddOperands,
              clientregisterstubs.Result>(
                service, METHODID_MULTIPLE_ADD)))
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
