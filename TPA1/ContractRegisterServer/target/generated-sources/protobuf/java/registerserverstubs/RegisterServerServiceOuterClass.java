// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RegisterServerService.proto

package registerserverstubs;

public final class RegisterServerServiceOuterClass {
  private RegisterServerServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_registerserverservice_ServerInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_registerserverservice_ServerInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_registerserverservice_ServerResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_registerserverservice_ServerResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_registerserverservice_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_registerserverservice_Empty_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\033RegisterServerService.proto\022\025registers" +
      "erverservice\"&\n\nServerInfo\022\n\n\002ip\030\001 \001(\t\022\014" +
      "\n\004port\030\002 \001(\005\"\"\n\016ServerResponse\022\020\n\010respon" +
      "se\030\001 \001(\t\"\007\n\005Empty2q\n\025RegisterServerServi" +
      "ce\022X\n\014registServer\022!.registerserverservi" +
      "ce.ServerInfo\032%.registerserverservice.Se" +
      "rverResponseB\027\n\023registerserverstubsP\001b\006p" +
      "roto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_registerserverservice_ServerInfo_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_registerserverservice_ServerInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_registerserverservice_ServerInfo_descriptor,
        new java.lang.String[] { "Ip", "Port", });
    internal_static_registerserverservice_ServerResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_registerserverservice_ServerResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_registerserverservice_ServerResponse_descriptor,
        new java.lang.String[] { "Response", });
    internal_static_registerserverservice_Empty_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_registerserverservice_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_registerserverservice_Empty_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
