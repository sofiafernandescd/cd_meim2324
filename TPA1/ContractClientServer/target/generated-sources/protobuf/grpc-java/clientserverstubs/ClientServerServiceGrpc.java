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
  private static volatile io.grpc.MethodDescriptor<clientserverstubs.AddOperands,
      clientserverstubs.Result> getAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "add",
      requestType = clientserverstubs.AddOperands.class,
      responseType = clientserverstubs.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<clientserverstubs.AddOperands,
      clientserverstubs.Result> getAddMethod() {
    io.grpc.MethodDescriptor<clientserverstubs.AddOperands, clientserverstubs.Result> getAddMethod;
    if ((getAddMethod = ClientServerServiceGrpc.getAddMethod) == null) {
      synchronized (ClientServerServiceGrpc.class) {
        if ((getAddMethod = ClientServerServiceGrpc.getAddMethod) == null) {
          ClientServerServiceGrpc.getAddMethod = getAddMethod =
              io.grpc.MethodDescriptor.<clientserverstubs.AddOperands, clientserverstubs.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientserverstubs.AddOperands.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientserverstubs.Result.getDefaultInstance()))
              .setSchemaDescriptor(new ClientServerServiceMethodDescriptorSupplier("add"))
              .build();
        }
      }
    }
    return getAddMethod;
  }

  private static volatile io.grpc.MethodDescriptor<clientserverstubs.NumberAndMaxExponent,
      clientserverstubs.Result> getGeneratePowersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "generatePowers",
      requestType = clientserverstubs.NumberAndMaxExponent.class,
      responseType = clientserverstubs.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<clientserverstubs.NumberAndMaxExponent,
      clientserverstubs.Result> getGeneratePowersMethod() {
    io.grpc.MethodDescriptor<clientserverstubs.NumberAndMaxExponent, clientserverstubs.Result> getGeneratePowersMethod;
    if ((getGeneratePowersMethod = ClientServerServiceGrpc.getGeneratePowersMethod) == null) {
      synchronized (ClientServerServiceGrpc.class) {
        if ((getGeneratePowersMethod = ClientServerServiceGrpc.getGeneratePowersMethod) == null) {
          ClientServerServiceGrpc.getGeneratePowersMethod = getGeneratePowersMethod =
              io.grpc.MethodDescriptor.<clientserverstubs.NumberAndMaxExponent, clientserverstubs.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "generatePowers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientserverstubs.NumberAndMaxExponent.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientserverstubs.Result.getDefaultInstance()))
              .setSchemaDescriptor(new ClientServerServiceMethodDescriptorSupplier("generatePowers"))
              .build();
        }
      }
    }
    return getGeneratePowersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<clientserverstubs.Number,
      clientserverstubs.Result> getAddSeqOfNumbersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addSeqOfNumbers",
      requestType = clientserverstubs.Number.class,
      responseType = clientserverstubs.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<clientserverstubs.Number,
      clientserverstubs.Result> getAddSeqOfNumbersMethod() {
    io.grpc.MethodDescriptor<clientserverstubs.Number, clientserverstubs.Result> getAddSeqOfNumbersMethod;
    if ((getAddSeqOfNumbersMethod = ClientServerServiceGrpc.getAddSeqOfNumbersMethod) == null) {
      synchronized (ClientServerServiceGrpc.class) {
        if ((getAddSeqOfNumbersMethod = ClientServerServiceGrpc.getAddSeqOfNumbersMethod) == null) {
          ClientServerServiceGrpc.getAddSeqOfNumbersMethod = getAddSeqOfNumbersMethod =
              io.grpc.MethodDescriptor.<clientserverstubs.Number, clientserverstubs.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addSeqOfNumbers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientserverstubs.Number.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientserverstubs.Result.getDefaultInstance()))
              .setSchemaDescriptor(new ClientServerServiceMethodDescriptorSupplier("addSeqOfNumbers"))
              .build();
        }
      }
    }
    return getAddSeqOfNumbersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<clientserverstubs.AddOperands,
      clientserverstubs.Result> getMultipleAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "multipleAdd",
      requestType = clientserverstubs.AddOperands.class,
      responseType = clientserverstubs.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<clientserverstubs.AddOperands,
      clientserverstubs.Result> getMultipleAddMethod() {
    io.grpc.MethodDescriptor<clientserverstubs.AddOperands, clientserverstubs.Result> getMultipleAddMethod;
    if ((getMultipleAddMethod = ClientServerServiceGrpc.getMultipleAddMethod) == null) {
      synchronized (ClientServerServiceGrpc.class) {
        if ((getMultipleAddMethod = ClientServerServiceGrpc.getMultipleAddMethod) == null) {
          ClientServerServiceGrpc.getMultipleAddMethod = getMultipleAddMethod =
              io.grpc.MethodDescriptor.<clientserverstubs.AddOperands, clientserverstubs.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "multipleAdd"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientserverstubs.AddOperands.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  clientserverstubs.Result.getDefaultInstance()))
              .setSchemaDescriptor(new ClientServerServiceMethodDescriptorSupplier("multipleAdd"))
              .build();
        }
      }
    }
    return getMultipleAddMethod;
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
     * add two numbers
     * </pre>
     */
    default void add(clientserverstubs.AddOperands request,
        io.grpc.stub.StreamObserver<clientserverstubs.Result> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddMethod(), responseObserver);
    }

    /**
     * <pre>
     * generate the number powers with exponents betwwen 1 and maximum 
     * </pre>
     */
    default void generatePowers(clientserverstubs.NumberAndMaxExponent request,
        io.grpc.stub.StreamObserver<clientserverstubs.Result> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGeneratePowersMethod(), responseObserver);
    }

    /**
     * <pre>
     * add a sequence of numbers, ex: 1,2, 10, 5 = 18
     * </pre>
     */
    default io.grpc.stub.StreamObserver<clientserverstubs.Number> addSeqOfNumbers(
        io.grpc.stub.StreamObserver<clientserverstubs.Result> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getAddSeqOfNumbersMethod(), responseObserver);
    }

    /**
     * <pre>
     * Multiple add operations using a bidirecional stream
     * </pre>
     */
    default io.grpc.stub.StreamObserver<clientserverstubs.AddOperands> multipleAdd(
        io.grpc.stub.StreamObserver<clientserverstubs.Result> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getMultipleAddMethod(), responseObserver);
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
     * add two numbers
     * </pre>
     */
    public void add(clientserverstubs.AddOperands request,
        io.grpc.stub.StreamObserver<clientserverstubs.Result> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * generate the number powers with exponents betwwen 1 and maximum 
     * </pre>
     */
    public void generatePowers(clientserverstubs.NumberAndMaxExponent request,
        io.grpc.stub.StreamObserver<clientserverstubs.Result> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGeneratePowersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * add a sequence of numbers, ex: 1,2, 10, 5 = 18
     * </pre>
     */
    public io.grpc.stub.StreamObserver<clientserverstubs.Number> addSeqOfNumbers(
        io.grpc.stub.StreamObserver<clientserverstubs.Result> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getAddSeqOfNumbersMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Multiple add operations using a bidirecional stream
     * </pre>
     */
    public io.grpc.stub.StreamObserver<clientserverstubs.AddOperands> multipleAdd(
        io.grpc.stub.StreamObserver<clientserverstubs.Result> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getMultipleAddMethod(), getCallOptions()), responseObserver);
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
     * add two numbers
     * </pre>
     */
    public clientserverstubs.Result add(clientserverstubs.AddOperands request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * generate the number powers with exponents betwwen 1 and maximum 
     * </pre>
     */
    public java.util.Iterator<clientserverstubs.Result> generatePowers(
        clientserverstubs.NumberAndMaxExponent request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGeneratePowersMethod(), getCallOptions(), request);
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
     * add two numbers
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<clientserverstubs.Result> add(
        clientserverstubs.AddOperands request) {
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
          serviceImpl.add((clientserverstubs.AddOperands) request,
              (io.grpc.stub.StreamObserver<clientserverstubs.Result>) responseObserver);
          break;
        case METHODID_GENERATE_POWERS:
          serviceImpl.generatePowers((clientserverstubs.NumberAndMaxExponent) request,
              (io.grpc.stub.StreamObserver<clientserverstubs.Result>) responseObserver);
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
              (io.grpc.stub.StreamObserver<clientserverstubs.Result>) responseObserver);
        case METHODID_MULTIPLE_ADD:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.multipleAdd(
              (io.grpc.stub.StreamObserver<clientserverstubs.Result>) responseObserver);
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
              clientserverstubs.AddOperands,
              clientserverstubs.Result>(
                service, METHODID_ADD)))
        .addMethod(
          getGeneratePowersMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              clientserverstubs.NumberAndMaxExponent,
              clientserverstubs.Result>(
                service, METHODID_GENERATE_POWERS)))
        .addMethod(
          getAddSeqOfNumbersMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              clientserverstubs.Number,
              clientserverstubs.Result>(
                service, METHODID_ADD_SEQ_OF_NUMBERS)))
        .addMethod(
          getMultipleAddMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              clientserverstubs.AddOperands,
              clientserverstubs.Result>(
                service, METHODID_MULTIPLE_ADD)))
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
