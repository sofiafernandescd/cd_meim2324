// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ClientServerService.proto

package clientserverstubs;

public final class ClientServerServiceOuterClass {
  private ClientServerServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_clientserverservice_ImageStatusRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_clientserverservice_ImageStatusRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_clientserverservice_ImageStatusResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_clientserverservice_ImageStatusResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_clientserverservice_ImageBlock_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_clientserverservice_ImageBlock_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_clientserverservice_ImageDownloadRequestId_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_clientserverservice_ImageDownloadRequestId_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_clientserverservice_ImageDownloadRequestKeywords_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_clientserverservice_ImageDownloadRequestKeywords_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\031ClientServerService.proto\022\023clientserve" +
      "rservice\"&\n\022ImageStatusRequest\022\020\n\010image_" +
      "id\030\001 \001(\t\"7\n\023ImageStatusResponse\022\020\n\010image" +
      "_id\030\001 \001(\t\022\016\n\006status\030\002 \001(\010\"\032\n\nImageBlock\022" +
      "\014\n\004data\030\001 \001(\014\"*\n\026ImageDownloadRequestId\022" +
      "\020\n\010image_id\030\001 \001(\t\"0\n\034ImageDownloadReques" +
      "tKeywords\022\020\n\010keywords\030\001 \001(\t2\305\003\n\023ClientSe" +
      "rverService\022c\n\024ProcessImageToServer\022\037.cl" +
      "ientserverservice.ImageBlock\032(.clientser" +
      "verservice.ImageStatusResponse(\001\022e\n\020Chec" +
      "kImageStatus\022\'.clientserverservice.Image" +
      "StatusRequest\032(.clientserverservice.Imag" +
      "eStatusResponse\022i\n\027DownloadMarkedImageBy" +
      "Id\022+.clientserverservice.ImageDownloadRe" +
      "questId\032\037.clientserverservice.ImageBlock" +
      "0\001\022w\n\035DownloadMarkedImageByKeywords\0221.cl" +
      "ientserverservice.ImageDownloadRequestKe" +
      "ywords\032\037.clientserverservice.ImageBlock(" +
      "\0010\001B\025\n\021clientserverstubsP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_clientserverservice_ImageStatusRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_clientserverservice_ImageStatusRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_clientserverservice_ImageStatusRequest_descriptor,
        new java.lang.String[] { "ImageId", });
    internal_static_clientserverservice_ImageStatusResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_clientserverservice_ImageStatusResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_clientserverservice_ImageStatusResponse_descriptor,
        new java.lang.String[] { "ImageId", "Status", });
    internal_static_clientserverservice_ImageBlock_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_clientserverservice_ImageBlock_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_clientserverservice_ImageBlock_descriptor,
        new java.lang.String[] { "Data", });
    internal_static_clientserverservice_ImageDownloadRequestId_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_clientserverservice_ImageDownloadRequestId_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_clientserverservice_ImageDownloadRequestId_descriptor,
        new java.lang.String[] { "ImageId", });
    internal_static_clientserverservice_ImageDownloadRequestKeywords_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_clientserverservice_ImageDownloadRequestKeywords_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_clientserverservice_ImageDownloadRequestKeywords_descriptor,
        new java.lang.String[] { "Keywords", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
