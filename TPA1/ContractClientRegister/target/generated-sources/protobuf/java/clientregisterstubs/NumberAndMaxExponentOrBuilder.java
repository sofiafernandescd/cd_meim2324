// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ClientRegisterService.proto

package clientregisterstubs;

public interface NumberAndMaxExponentOrBuilder extends
    // @@protoc_insertion_point(interface_extends:clientregisterservice.NumberAndMaxExponent)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string Id = 1;</code>
   * @return The id.
   */
  java.lang.String getId();
  /**
   * <code>string Id = 1;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>int32 baseNumber = 2;</code>
   * @return The baseNumber.
   */
  int getBaseNumber();

  /**
   * <code>int32 maxExponent = 3;</code>
   * @return The maxExponent.
   */
  int getMaxExponent();
}