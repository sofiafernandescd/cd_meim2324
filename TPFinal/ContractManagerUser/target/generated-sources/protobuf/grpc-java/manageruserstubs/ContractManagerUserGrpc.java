package manageruserstubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: ContractManagerUser.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ContractManagerUserGrpc {

  private ContractManagerUserGrpc() {}

  public static final java.lang.String SERVICE_NAME = "contractmanageruser.ContractManagerUser";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<manageruserstubs.Category,
      manageruserstubs.Sale> getGetResumeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getResume",
      requestType = manageruserstubs.Category.class,
      responseType = manageruserstubs.Sale.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<manageruserstubs.Category,
      manageruserstubs.Sale> getGetResumeMethod() {
    io.grpc.MethodDescriptor<manageruserstubs.Category, manageruserstubs.Sale> getGetResumeMethod;
    if ((getGetResumeMethod = ContractManagerUserGrpc.getGetResumeMethod) == null) {
      synchronized (ContractManagerUserGrpc.class) {
        if ((getGetResumeMethod = ContractManagerUserGrpc.getGetResumeMethod) == null) {
          ContractManagerUserGrpc.getGetResumeMethod = getGetResumeMethod =
              io.grpc.MethodDescriptor.<manageruserstubs.Category, manageruserstubs.Sale>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getResume"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  manageruserstubs.Category.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  manageruserstubs.Sale.getDefaultInstance()))
              .setSchemaDescriptor(new ContractManagerUserMethodDescriptorSupplier("getResume"))
              .build();
        }
      }
    }
    return getGetResumeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ContractManagerUserStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContractManagerUserStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ContractManagerUserStub>() {
        @java.lang.Override
        public ContractManagerUserStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ContractManagerUserStub(channel, callOptions);
        }
      };
    return ContractManagerUserStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ContractManagerUserBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContractManagerUserBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ContractManagerUserBlockingStub>() {
        @java.lang.Override
        public ContractManagerUserBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ContractManagerUserBlockingStub(channel, callOptions);
        }
      };
    return ContractManagerUserBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ContractManagerUserFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContractManagerUserFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ContractManagerUserFutureStub>() {
        @java.lang.Override
        public ContractManagerUserFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ContractManagerUserFutureStub(channel, callOptions);
        }
      };
    return ContractManagerUserFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getResume(manageruserstubs.Category request,
        io.grpc.stub.StreamObserver<manageruserstubs.Sale> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetResumeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ContractManagerUser.
   */
  public static abstract class ContractManagerUserImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ContractManagerUserGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ContractManagerUser.
   */
  public static final class ContractManagerUserStub
      extends io.grpc.stub.AbstractAsyncStub<ContractManagerUserStub> {
    private ContractManagerUserStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContractManagerUserStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContractManagerUserStub(channel, callOptions);
    }

    /**
     */
    public void getResume(manageruserstubs.Category request,
        io.grpc.stub.StreamObserver<manageruserstubs.Sale> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetResumeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ContractManagerUser.
   */
  public static final class ContractManagerUserBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ContractManagerUserBlockingStub> {
    private ContractManagerUserBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContractManagerUserBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContractManagerUserBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<manageruserstubs.Sale> getResume(
        manageruserstubs.Category request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetResumeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ContractManagerUser.
   */
  public static final class ContractManagerUserFutureStub
      extends io.grpc.stub.AbstractFutureStub<ContractManagerUserFutureStub> {
    private ContractManagerUserFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContractManagerUserFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContractManagerUserFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_RESUME = 0;

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
        case METHODID_GET_RESUME:
          serviceImpl.getResume((manageruserstubs.Category) request,
              (io.grpc.stub.StreamObserver<manageruserstubs.Sale>) responseObserver);
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
          getGetResumeMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              manageruserstubs.Category,
              manageruserstubs.Sale>(
                service, METHODID_GET_RESUME)))
        .build();
  }

  private static abstract class ContractManagerUserBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ContractManagerUserBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return manageruserstubs.ContractManagerUserOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ContractManagerUser");
    }
  }

  private static final class ContractManagerUserFileDescriptorSupplier
      extends ContractManagerUserBaseDescriptorSupplier {
    ContractManagerUserFileDescriptorSupplier() {}
  }

  private static final class ContractManagerUserMethodDescriptorSupplier
      extends ContractManagerUserBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ContractManagerUserMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ContractManagerUserGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ContractManagerUserFileDescriptorSupplier())
              .addMethod(getGetResumeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
