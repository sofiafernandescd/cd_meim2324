// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ClientRegisterService.proto

package clientregisterstubs;

public interface ServerInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:clientregisterservice.ServerInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string server_id = 1;</code>
   * @return The serverId.
   */
  java.lang.String getServerId();
  /**
   * <code>string server_id = 1;</code>
   * @return The bytes for serverId.
   */
  com.google.protobuf.ByteString
      getServerIdBytes();

  /**
   * <code>string ip = 2;</code>
   * @return The ip.
   */
  java.lang.String getIp();
  /**
   * <code>string ip = 2;</code>
   * @return The bytes for ip.
   */
  com.google.protobuf.ByteString
      getIpBytes();

  /**
   * <code>int32 port = 3;</code>
   * @return The port.
   */
  int getPort();
}
