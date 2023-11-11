// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ClientServerService.proto

package clientserverstubs;

public interface ImageBlockOrBuilder extends
    // @@protoc_insertion_point(interface_extends:clientserverservice.ImageBlock)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string image_id = 1;</code>
   * @return The imageId.
   */
  java.lang.String getImageId();
  /**
   * <code>string image_id = 1;</code>
   * @return The bytes for imageId.
   */
  com.google.protobuf.ByteString
      getImageIdBytes();

  /**
   * <code>bytes data = 2;</code>
   * @return The data.
   */
  com.google.protobuf.ByteString getData();

  /**
   * <code>repeated string keywords = 3;</code>
   * @return A list containing the keywords.
   */
  java.util.List<java.lang.String>
      getKeywordsList();
  /**
   * <code>repeated string keywords = 3;</code>
   * @return The count of keywords.
   */
  int getKeywordsCount();
  /**
   * <code>repeated string keywords = 3;</code>
   * @param index The index of the element to return.
   * @return The keywords at the given index.
   */
  java.lang.String getKeywords(int index);
  /**
   * <code>repeated string keywords = 3;</code>
   * @param index The index of the value to return.
   * @return The bytes of the keywords at the given index.
   */
  com.google.protobuf.ByteString
      getKeywordsBytes(int index);
}
