// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RegisterServerService.proto

package registerserverstubs;

/**
 * Protobuf type {@code registerserverservice.ServerInfo}
 */
public final class ServerInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:registerserverservice.ServerInfo)
    ServerInfoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ServerInfo.newBuilder() to construct.
  private ServerInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ServerInfo() {
    ip_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ServerInfo();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return registerserverstubs.RegisterServerServiceOuterClass.internal_static_registerserverservice_ServerInfo_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return registerserverstubs.RegisterServerServiceOuterClass.internal_static_registerserverservice_ServerInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            registerserverstubs.ServerInfo.class, registerserverstubs.ServerInfo.Builder.class);
  }

  public static final int IP_FIELD_NUMBER = 1;
  private volatile java.lang.Object ip_;
  /**
   * <code>string ip = 1;</code>
   * @return The ip.
   */
  @java.lang.Override
  public java.lang.String getIp() {
    java.lang.Object ref = ip_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      ip_ = s;
      return s;
    }
  }
  /**
   * <code>string ip = 1;</code>
   * @return The bytes for ip.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getIpBytes() {
    java.lang.Object ref = ip_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      ip_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PORT_FIELD_NUMBER = 2;
  private int port_;
  /**
   * <code>int32 port = 2;</code>
   * @return The port.
   */
  @java.lang.Override
  public int getPort() {
    return port_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(ip_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, ip_);
    }
    if (port_ != 0) {
      output.writeInt32(2, port_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(ip_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, ip_);
    }
    if (port_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, port_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof registerserverstubs.ServerInfo)) {
      return super.equals(obj);
    }
    registerserverstubs.ServerInfo other = (registerserverstubs.ServerInfo) obj;

    if (!getIp()
        .equals(other.getIp())) return false;
    if (getPort()
        != other.getPort()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + IP_FIELD_NUMBER;
    hash = (53 * hash) + getIp().hashCode();
    hash = (37 * hash) + PORT_FIELD_NUMBER;
    hash = (53 * hash) + getPort();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static registerserverstubs.ServerInfo parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static registerserverstubs.ServerInfo parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static registerserverstubs.ServerInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static registerserverstubs.ServerInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static registerserverstubs.ServerInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static registerserverstubs.ServerInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static registerserverstubs.ServerInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static registerserverstubs.ServerInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static registerserverstubs.ServerInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static registerserverstubs.ServerInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static registerserverstubs.ServerInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static registerserverstubs.ServerInfo parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(registerserverstubs.ServerInfo prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code registerserverservice.ServerInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:registerserverservice.ServerInfo)
      registerserverstubs.ServerInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return registerserverstubs.RegisterServerServiceOuterClass.internal_static_registerserverservice_ServerInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return registerserverstubs.RegisterServerServiceOuterClass.internal_static_registerserverservice_ServerInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              registerserverstubs.ServerInfo.class, registerserverstubs.ServerInfo.Builder.class);
    }

    // Construct using registerserverstubs.ServerInfo.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      ip_ = "";

      port_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return registerserverstubs.RegisterServerServiceOuterClass.internal_static_registerserverservice_ServerInfo_descriptor;
    }

    @java.lang.Override
    public registerserverstubs.ServerInfo getDefaultInstanceForType() {
      return registerserverstubs.ServerInfo.getDefaultInstance();
    }

    @java.lang.Override
    public registerserverstubs.ServerInfo build() {
      registerserverstubs.ServerInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public registerserverstubs.ServerInfo buildPartial() {
      registerserverstubs.ServerInfo result = new registerserverstubs.ServerInfo(this);
      result.ip_ = ip_;
      result.port_ = port_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof registerserverstubs.ServerInfo) {
        return mergeFrom((registerserverstubs.ServerInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(registerserverstubs.ServerInfo other) {
      if (other == registerserverstubs.ServerInfo.getDefaultInstance()) return this;
      if (!other.getIp().isEmpty()) {
        ip_ = other.ip_;
        onChanged();
      }
      if (other.getPort() != 0) {
        setPort(other.getPort());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              ip_ = input.readStringRequireUtf8();

              break;
            } // case 10
            case 16: {
              port_ = input.readInt32();

              break;
            } // case 16
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }

    private java.lang.Object ip_ = "";
    /**
     * <code>string ip = 1;</code>
     * @return The ip.
     */
    public java.lang.String getIp() {
      java.lang.Object ref = ip_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        ip_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string ip = 1;</code>
     * @return The bytes for ip.
     */
    public com.google.protobuf.ByteString
        getIpBytes() {
      java.lang.Object ref = ip_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        ip_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string ip = 1;</code>
     * @param value The ip to set.
     * @return This builder for chaining.
     */
    public Builder setIp(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      ip_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string ip = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearIp() {
      
      ip_ = getDefaultInstance().getIp();
      onChanged();
      return this;
    }
    /**
     * <code>string ip = 1;</code>
     * @param value The bytes for ip to set.
     * @return This builder for chaining.
     */
    public Builder setIpBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      ip_ = value;
      onChanged();
      return this;
    }

    private int port_ ;
    /**
     * <code>int32 port = 2;</code>
     * @return The port.
     */
    @java.lang.Override
    public int getPort() {
      return port_;
    }
    /**
     * <code>int32 port = 2;</code>
     * @param value The port to set.
     * @return This builder for chaining.
     */
    public Builder setPort(int value) {
      
      port_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 port = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearPort() {
      
      port_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:registerserverservice.ServerInfo)
  }

  // @@protoc_insertion_point(class_scope:registerserverservice.ServerInfo)
  private static final registerserverstubs.ServerInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new registerserverstubs.ServerInfo();
  }

  public static registerserverstubs.ServerInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ServerInfo>
      PARSER = new com.google.protobuf.AbstractParser<ServerInfo>() {
    @java.lang.Override
    public ServerInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<ServerInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ServerInfo> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public registerserverstubs.ServerInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

