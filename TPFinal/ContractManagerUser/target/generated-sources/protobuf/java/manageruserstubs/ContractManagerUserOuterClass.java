// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ContractManagerUser.proto

package manageruserstubs;

public final class ContractManagerUserOuterClass {
  private ContractManagerUserOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_contractmanageruser_Category_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_contractmanageruser_Category_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_contractmanageruser_Resume_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_contractmanageruser_Resume_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_contractmanageruser_Void_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_contractmanageruser_Void_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_contractmanageruser_Request_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_contractmanageruser_Request_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\031ContractManagerUser.proto\022\023contractman" +
      "ageruser\032\037google/protobuf/timestamp.prot" +
      "o\"\034\n\010Category\022\020\n\010category\030\001 \001(\t\"(\n\006Resum" +
      "e\022\020\n\010category\030\001 \001(\t\022\014\n\004data\030\002 \001(\014\"\006\n\004Voi" +
      "d\"<\n\007Request\022\025\n\roriginAddress\030\002 \001(\t\022\032\n\022d" +
      "estinationAddress\030\003 \001(\t2`\n\023ContractManag" +
      "erUser\022I\n\tgetResume\022\035.contractmanageruse" +
      "r.Category\032\033.contractmanageruser.Resume0" +
      "\001B\024\n\020manageruserstubsP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.TimestampProto.getDescriptor(),
        });
    internal_static_contractmanageruser_Category_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_contractmanageruser_Category_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_contractmanageruser_Category_descriptor,
        new java.lang.String[] { "Category", });
    internal_static_contractmanageruser_Resume_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_contractmanageruser_Resume_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_contractmanageruser_Resume_descriptor,
        new java.lang.String[] { "Category", "Data", });
    internal_static_contractmanageruser_Void_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_contractmanageruser_Void_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_contractmanageruser_Void_descriptor,
        new java.lang.String[] { });
    internal_static_contractmanageruser_Request_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_contractmanageruser_Request_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_contractmanageruser_Request_descriptor,
        new java.lang.String[] { "OriginAddress", "DestinationAddress", });
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
