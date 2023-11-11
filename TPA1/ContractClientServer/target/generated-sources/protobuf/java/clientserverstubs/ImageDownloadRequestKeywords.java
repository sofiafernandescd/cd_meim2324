// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ClientServerService.proto

package clientserverstubs;

/**
 * Protobuf type {@code clientserverservice.ImageDownloadRequestKeywords}
 */
public final class ImageDownloadRequestKeywords extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:clientserverservice.ImageDownloadRequestKeywords)
    ImageDownloadRequestKeywordsOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ImageDownloadRequestKeywords.newBuilder() to construct.
  private ImageDownloadRequestKeywords(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ImageDownloadRequestKeywords() {
    keywords_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ImageDownloadRequestKeywords();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return clientserverstubs.ClientServerServiceOuterClass.internal_static_clientserverservice_ImageDownloadRequestKeywords_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return clientserverstubs.ClientServerServiceOuterClass.internal_static_clientserverservice_ImageDownloadRequestKeywords_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            clientserverstubs.ImageDownloadRequestKeywords.class, clientserverstubs.ImageDownloadRequestKeywords.Builder.class);
  }

  public static final int KEYWORDS_FIELD_NUMBER = 1;
  private com.google.protobuf.LazyStringList keywords_;
  /**
   * <code>repeated string keywords = 1;</code>
   * @return A list containing the keywords.
   */
  public com.google.protobuf.ProtocolStringList
      getKeywordsList() {
    return keywords_;
  }
  /**
   * <code>repeated string keywords = 1;</code>
   * @return The count of keywords.
   */
  public int getKeywordsCount() {
    return keywords_.size();
  }
  /**
   * <code>repeated string keywords = 1;</code>
   * @param index The index of the element to return.
   * @return The keywords at the given index.
   */
  public java.lang.String getKeywords(int index) {
    return keywords_.get(index);
  }
  /**
   * <code>repeated string keywords = 1;</code>
   * @param index The index of the value to return.
   * @return The bytes of the keywords at the given index.
   */
  public com.google.protobuf.ByteString
      getKeywordsBytes(int index) {
    return keywords_.getByteString(index);
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
    for (int i = 0; i < keywords_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, keywords_.getRaw(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < keywords_.size(); i++) {
        dataSize += computeStringSizeNoTag(keywords_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getKeywordsList().size();
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
    if (!(obj instanceof clientserverstubs.ImageDownloadRequestKeywords)) {
      return super.equals(obj);
    }
    clientserverstubs.ImageDownloadRequestKeywords other = (clientserverstubs.ImageDownloadRequestKeywords) obj;

    if (!getKeywordsList()
        .equals(other.getKeywordsList())) return false;
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
    if (getKeywordsCount() > 0) {
      hash = (37 * hash) + KEYWORDS_FIELD_NUMBER;
      hash = (53 * hash) + getKeywordsList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static clientserverstubs.ImageDownloadRequestKeywords parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static clientserverstubs.ImageDownloadRequestKeywords parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static clientserverstubs.ImageDownloadRequestKeywords parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static clientserverstubs.ImageDownloadRequestKeywords parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static clientserverstubs.ImageDownloadRequestKeywords parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static clientserverstubs.ImageDownloadRequestKeywords parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static clientserverstubs.ImageDownloadRequestKeywords parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static clientserverstubs.ImageDownloadRequestKeywords parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static clientserverstubs.ImageDownloadRequestKeywords parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static clientserverstubs.ImageDownloadRequestKeywords parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static clientserverstubs.ImageDownloadRequestKeywords parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static clientserverstubs.ImageDownloadRequestKeywords parseFrom(
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
  public static Builder newBuilder(clientserverstubs.ImageDownloadRequestKeywords prototype) {
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
   * Protobuf type {@code clientserverservice.ImageDownloadRequestKeywords}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:clientserverservice.ImageDownloadRequestKeywords)
      clientserverstubs.ImageDownloadRequestKeywordsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return clientserverstubs.ClientServerServiceOuterClass.internal_static_clientserverservice_ImageDownloadRequestKeywords_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return clientserverstubs.ClientServerServiceOuterClass.internal_static_clientserverservice_ImageDownloadRequestKeywords_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              clientserverstubs.ImageDownloadRequestKeywords.class, clientserverstubs.ImageDownloadRequestKeywords.Builder.class);
    }

    // Construct using clientserverstubs.ImageDownloadRequestKeywords.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      keywords_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return clientserverstubs.ClientServerServiceOuterClass.internal_static_clientserverservice_ImageDownloadRequestKeywords_descriptor;
    }

    @java.lang.Override
    public clientserverstubs.ImageDownloadRequestKeywords getDefaultInstanceForType() {
      return clientserverstubs.ImageDownloadRequestKeywords.getDefaultInstance();
    }

    @java.lang.Override
    public clientserverstubs.ImageDownloadRequestKeywords build() {
      clientserverstubs.ImageDownloadRequestKeywords result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public clientserverstubs.ImageDownloadRequestKeywords buildPartial() {
      clientserverstubs.ImageDownloadRequestKeywords result = new clientserverstubs.ImageDownloadRequestKeywords(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) != 0)) {
        keywords_ = keywords_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.keywords_ = keywords_;
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
      if (other instanceof clientserverstubs.ImageDownloadRequestKeywords) {
        return mergeFrom((clientserverstubs.ImageDownloadRequestKeywords)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(clientserverstubs.ImageDownloadRequestKeywords other) {
      if (other == clientserverstubs.ImageDownloadRequestKeywords.getDefaultInstance()) return this;
      if (!other.keywords_.isEmpty()) {
        if (keywords_.isEmpty()) {
          keywords_ = other.keywords_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureKeywordsIsMutable();
          keywords_.addAll(other.keywords_);
        }
        onChanged();
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
              java.lang.String s = input.readStringRequireUtf8();
              ensureKeywordsIsMutable();
              keywords_.add(s);
              break;
            } // case 10
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
    private int bitField0_;

    private com.google.protobuf.LazyStringList keywords_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureKeywordsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        keywords_ = new com.google.protobuf.LazyStringArrayList(keywords_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated string keywords = 1;</code>
     * @return A list containing the keywords.
     */
    public com.google.protobuf.ProtocolStringList
        getKeywordsList() {
      return keywords_.getUnmodifiableView();
    }
    /**
     * <code>repeated string keywords = 1;</code>
     * @return The count of keywords.
     */
    public int getKeywordsCount() {
      return keywords_.size();
    }
    /**
     * <code>repeated string keywords = 1;</code>
     * @param index The index of the element to return.
     * @return The keywords at the given index.
     */
    public java.lang.String getKeywords(int index) {
      return keywords_.get(index);
    }
    /**
     * <code>repeated string keywords = 1;</code>
     * @param index The index of the value to return.
     * @return The bytes of the keywords at the given index.
     */
    public com.google.protobuf.ByteString
        getKeywordsBytes(int index) {
      return keywords_.getByteString(index);
    }
    /**
     * <code>repeated string keywords = 1;</code>
     * @param index The index to set the value at.
     * @param value The keywords to set.
     * @return This builder for chaining.
     */
    public Builder setKeywords(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureKeywordsIsMutable();
      keywords_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string keywords = 1;</code>
     * @param value The keywords to add.
     * @return This builder for chaining.
     */
    public Builder addKeywords(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureKeywordsIsMutable();
      keywords_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string keywords = 1;</code>
     * @param values The keywords to add.
     * @return This builder for chaining.
     */
    public Builder addAllKeywords(
        java.lang.Iterable<java.lang.String> values) {
      ensureKeywordsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, keywords_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string keywords = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearKeywords() {
      keywords_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string keywords = 1;</code>
     * @param value The bytes of the keywords to add.
     * @return This builder for chaining.
     */
    public Builder addKeywordsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureKeywordsIsMutable();
      keywords_.add(value);
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


    // @@protoc_insertion_point(builder_scope:clientserverservice.ImageDownloadRequestKeywords)
  }

  // @@protoc_insertion_point(class_scope:clientserverservice.ImageDownloadRequestKeywords)
  private static final clientserverstubs.ImageDownloadRequestKeywords DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new clientserverstubs.ImageDownloadRequestKeywords();
  }

  public static clientserverstubs.ImageDownloadRequestKeywords getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ImageDownloadRequestKeywords>
      PARSER = new com.google.protobuf.AbstractParser<ImageDownloadRequestKeywords>() {
    @java.lang.Override
    public ImageDownloadRequestKeywords parsePartialFrom(
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

  public static com.google.protobuf.Parser<ImageDownloadRequestKeywords> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ImageDownloadRequestKeywords> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public clientserverstubs.ImageDownloadRequestKeywords getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
