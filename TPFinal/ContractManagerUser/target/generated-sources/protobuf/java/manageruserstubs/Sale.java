// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ContractManagerUser.proto

package manageruserstubs;

/**
 * <pre>
 * o conteúdo de uma venda (Sale) tem as seguintes informações
 * (Data, CodigoProduto, NomeProduto, Quant, PreçoUnitário, Total, Iva).
 * </pre>
 *
 * Protobuf type {@code contractmanageruser.Sale}
 */
public final class Sale extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:contractmanageruser.Sale)
    SaleOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Sale.newBuilder() to construct.
  private Sale(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Sale() {
    codigoProduto_ = "";
    nomeProduto_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Sale();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return manageruserstubs.ContractManagerUserOuterClass.internal_static_contractmanageruser_Sale_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return manageruserstubs.ContractManagerUserOuterClass.internal_static_contractmanageruser_Sale_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            manageruserstubs.Sale.class, manageruserstubs.Sale.Builder.class);
  }

  public static final int DATA_FIELD_NUMBER = 1;
  private com.google.protobuf.Timestamp data_;
  /**
   * <code>.google.protobuf.Timestamp data = 1;</code>
   * @return Whether the data field is set.
   */
  @java.lang.Override
  public boolean hasData() {
    return data_ != null;
  }
  /**
   * <code>.google.protobuf.Timestamp data = 1;</code>
   * @return The data.
   */
  @java.lang.Override
  public com.google.protobuf.Timestamp getData() {
    return data_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : data_;
  }
  /**
   * <code>.google.protobuf.Timestamp data = 1;</code>
   */
  @java.lang.Override
  public com.google.protobuf.TimestampOrBuilder getDataOrBuilder() {
    return getData();
  }

  public static final int CODIGOPRODUTO_FIELD_NUMBER = 2;
  private volatile java.lang.Object codigoProduto_;
  /**
   * <code>string codigoProduto = 2;</code>
   * @return The codigoProduto.
   */
  @java.lang.Override
  public java.lang.String getCodigoProduto() {
    java.lang.Object ref = codigoProduto_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      codigoProduto_ = s;
      return s;
    }
  }
  /**
   * <code>string codigoProduto = 2;</code>
   * @return The bytes for codigoProduto.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getCodigoProdutoBytes() {
    java.lang.Object ref = codigoProduto_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      codigoProduto_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int NOMEPRODUTO_FIELD_NUMBER = 3;
  private volatile java.lang.Object nomeProduto_;
  /**
   * <code>string nomeProduto = 3;</code>
   * @return The nomeProduto.
   */
  @java.lang.Override
  public java.lang.String getNomeProduto() {
    java.lang.Object ref = nomeProduto_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      nomeProduto_ = s;
      return s;
    }
  }
  /**
   * <code>string nomeProduto = 3;</code>
   * @return The bytes for nomeProduto.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getNomeProdutoBytes() {
    java.lang.Object ref = nomeProduto_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      nomeProduto_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int QUANTIDADE_FIELD_NUMBER = 4;
  private int quantidade_;
  /**
   * <code>int32 quantidade = 4;</code>
   * @return The quantidade.
   */
  @java.lang.Override
  public int getQuantidade() {
    return quantidade_;
  }

  public static final int PRECOUNITARIO_FIELD_NUMBER = 5;
  private double precoUnitario_;
  /**
   * <code>double precoUnitario = 5;</code>
   * @return The precoUnitario.
   */
  @java.lang.Override
  public double getPrecoUnitario() {
    return precoUnitario_;
  }

  public static final int TOTAL_FIELD_NUMBER = 6;
  private double total_;
  /**
   * <code>double total = 6;</code>
   * @return The total.
   */
  @java.lang.Override
  public double getTotal() {
    return total_;
  }

  public static final int IVA_FIELD_NUMBER = 7;
  private double iva_;
  /**
   * <code>double iva = 7;</code>
   * @return The iva.
   */
  @java.lang.Override
  public double getIva() {
    return iva_;
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
    if (data_ != null) {
      output.writeMessage(1, getData());
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(codigoProduto_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, codigoProduto_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(nomeProduto_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, nomeProduto_);
    }
    if (quantidade_ != 0) {
      output.writeInt32(4, quantidade_);
    }
    if (java.lang.Double.doubleToRawLongBits(precoUnitario_) != 0) {
      output.writeDouble(5, precoUnitario_);
    }
    if (java.lang.Double.doubleToRawLongBits(total_) != 0) {
      output.writeDouble(6, total_);
    }
    if (java.lang.Double.doubleToRawLongBits(iva_) != 0) {
      output.writeDouble(7, iva_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (data_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getData());
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(codigoProduto_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, codigoProduto_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(nomeProduto_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, nomeProduto_);
    }
    if (quantidade_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, quantidade_);
    }
    if (java.lang.Double.doubleToRawLongBits(precoUnitario_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(5, precoUnitario_);
    }
    if (java.lang.Double.doubleToRawLongBits(total_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(6, total_);
    }
    if (java.lang.Double.doubleToRawLongBits(iva_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(7, iva_);
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
    if (!(obj instanceof manageruserstubs.Sale)) {
      return super.equals(obj);
    }
    manageruserstubs.Sale other = (manageruserstubs.Sale) obj;

    if (hasData() != other.hasData()) return false;
    if (hasData()) {
      if (!getData()
          .equals(other.getData())) return false;
    }
    if (!getCodigoProduto()
        .equals(other.getCodigoProduto())) return false;
    if (!getNomeProduto()
        .equals(other.getNomeProduto())) return false;
    if (getQuantidade()
        != other.getQuantidade()) return false;
    if (java.lang.Double.doubleToLongBits(getPrecoUnitario())
        != java.lang.Double.doubleToLongBits(
            other.getPrecoUnitario())) return false;
    if (java.lang.Double.doubleToLongBits(getTotal())
        != java.lang.Double.doubleToLongBits(
            other.getTotal())) return false;
    if (java.lang.Double.doubleToLongBits(getIva())
        != java.lang.Double.doubleToLongBits(
            other.getIva())) return false;
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
    if (hasData()) {
      hash = (37 * hash) + DATA_FIELD_NUMBER;
      hash = (53 * hash) + getData().hashCode();
    }
    hash = (37 * hash) + CODIGOPRODUTO_FIELD_NUMBER;
    hash = (53 * hash) + getCodigoProduto().hashCode();
    hash = (37 * hash) + NOMEPRODUTO_FIELD_NUMBER;
    hash = (53 * hash) + getNomeProduto().hashCode();
    hash = (37 * hash) + QUANTIDADE_FIELD_NUMBER;
    hash = (53 * hash) + getQuantidade();
    hash = (37 * hash) + PRECOUNITARIO_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getPrecoUnitario()));
    hash = (37 * hash) + TOTAL_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getTotal()));
    hash = (37 * hash) + IVA_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getIva()));
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static manageruserstubs.Sale parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static manageruserstubs.Sale parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static manageruserstubs.Sale parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static manageruserstubs.Sale parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static manageruserstubs.Sale parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static manageruserstubs.Sale parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static manageruserstubs.Sale parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static manageruserstubs.Sale parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static manageruserstubs.Sale parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static manageruserstubs.Sale parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static manageruserstubs.Sale parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static manageruserstubs.Sale parseFrom(
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
  public static Builder newBuilder(manageruserstubs.Sale prototype) {
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
   * <pre>
   * o conteúdo de uma venda (Sale) tem as seguintes informações
   * (Data, CodigoProduto, NomeProduto, Quant, PreçoUnitário, Total, Iva).
   * </pre>
   *
   * Protobuf type {@code contractmanageruser.Sale}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:contractmanageruser.Sale)
      manageruserstubs.SaleOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return manageruserstubs.ContractManagerUserOuterClass.internal_static_contractmanageruser_Sale_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return manageruserstubs.ContractManagerUserOuterClass.internal_static_contractmanageruser_Sale_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              manageruserstubs.Sale.class, manageruserstubs.Sale.Builder.class);
    }

    // Construct using manageruserstubs.Sale.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (dataBuilder_ == null) {
        data_ = null;
      } else {
        data_ = null;
        dataBuilder_ = null;
      }
      codigoProduto_ = "";

      nomeProduto_ = "";

      quantidade_ = 0;

      precoUnitario_ = 0D;

      total_ = 0D;

      iva_ = 0D;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return manageruserstubs.ContractManagerUserOuterClass.internal_static_contractmanageruser_Sale_descriptor;
    }

    @java.lang.Override
    public manageruserstubs.Sale getDefaultInstanceForType() {
      return manageruserstubs.Sale.getDefaultInstance();
    }

    @java.lang.Override
    public manageruserstubs.Sale build() {
      manageruserstubs.Sale result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public manageruserstubs.Sale buildPartial() {
      manageruserstubs.Sale result = new manageruserstubs.Sale(this);
      if (dataBuilder_ == null) {
        result.data_ = data_;
      } else {
        result.data_ = dataBuilder_.build();
      }
      result.codigoProduto_ = codigoProduto_;
      result.nomeProduto_ = nomeProduto_;
      result.quantidade_ = quantidade_;
      result.precoUnitario_ = precoUnitario_;
      result.total_ = total_;
      result.iva_ = iva_;
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
      if (other instanceof manageruserstubs.Sale) {
        return mergeFrom((manageruserstubs.Sale)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(manageruserstubs.Sale other) {
      if (other == manageruserstubs.Sale.getDefaultInstance()) return this;
      if (other.hasData()) {
        mergeData(other.getData());
      }
      if (!other.getCodigoProduto().isEmpty()) {
        codigoProduto_ = other.codigoProduto_;
        onChanged();
      }
      if (!other.getNomeProduto().isEmpty()) {
        nomeProduto_ = other.nomeProduto_;
        onChanged();
      }
      if (other.getQuantidade() != 0) {
        setQuantidade(other.getQuantidade());
      }
      if (other.getPrecoUnitario() != 0D) {
        setPrecoUnitario(other.getPrecoUnitario());
      }
      if (other.getTotal() != 0D) {
        setTotal(other.getTotal());
      }
      if (other.getIva() != 0D) {
        setIva(other.getIva());
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
              input.readMessage(
                  getDataFieldBuilder().getBuilder(),
                  extensionRegistry);

              break;
            } // case 10
            case 18: {
              codigoProduto_ = input.readStringRequireUtf8();

              break;
            } // case 18
            case 26: {
              nomeProduto_ = input.readStringRequireUtf8();

              break;
            } // case 26
            case 32: {
              quantidade_ = input.readInt32();

              break;
            } // case 32
            case 41: {
              precoUnitario_ = input.readDouble();

              break;
            } // case 41
            case 49: {
              total_ = input.readDouble();

              break;
            } // case 49
            case 57: {
              iva_ = input.readDouble();

              break;
            } // case 57
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

    private com.google.protobuf.Timestamp data_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> dataBuilder_;
    /**
     * <code>.google.protobuf.Timestamp data = 1;</code>
     * @return Whether the data field is set.
     */
    public boolean hasData() {
      return dataBuilder_ != null || data_ != null;
    }
    /**
     * <code>.google.protobuf.Timestamp data = 1;</code>
     * @return The data.
     */
    public com.google.protobuf.Timestamp getData() {
      if (dataBuilder_ == null) {
        return data_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : data_;
      } else {
        return dataBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.Timestamp data = 1;</code>
     */
    public Builder setData(com.google.protobuf.Timestamp value) {
      if (dataBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        data_ = value;
        onChanged();
      } else {
        dataBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp data = 1;</code>
     */
    public Builder setData(
        com.google.protobuf.Timestamp.Builder builderForValue) {
      if (dataBuilder_ == null) {
        data_ = builderForValue.build();
        onChanged();
      } else {
        dataBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp data = 1;</code>
     */
    public Builder mergeData(com.google.protobuf.Timestamp value) {
      if (dataBuilder_ == null) {
        if (data_ != null) {
          data_ =
            com.google.protobuf.Timestamp.newBuilder(data_).mergeFrom(value).buildPartial();
        } else {
          data_ = value;
        }
        onChanged();
      } else {
        dataBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp data = 1;</code>
     */
    public Builder clearData() {
      if (dataBuilder_ == null) {
        data_ = null;
        onChanged();
      } else {
        data_ = null;
        dataBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp data = 1;</code>
     */
    public com.google.protobuf.Timestamp.Builder getDataBuilder() {
      
      onChanged();
      return getDataFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Timestamp data = 1;</code>
     */
    public com.google.protobuf.TimestampOrBuilder getDataOrBuilder() {
      if (dataBuilder_ != null) {
        return dataBuilder_.getMessageOrBuilder();
      } else {
        return data_ == null ?
            com.google.protobuf.Timestamp.getDefaultInstance() : data_;
      }
    }
    /**
     * <code>.google.protobuf.Timestamp data = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> 
        getDataFieldBuilder() {
      if (dataBuilder_ == null) {
        dataBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder>(
                getData(),
                getParentForChildren(),
                isClean());
        data_ = null;
      }
      return dataBuilder_;
    }

    private java.lang.Object codigoProduto_ = "";
    /**
     * <code>string codigoProduto = 2;</code>
     * @return The codigoProduto.
     */
    public java.lang.String getCodigoProduto() {
      java.lang.Object ref = codigoProduto_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        codigoProduto_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string codigoProduto = 2;</code>
     * @return The bytes for codigoProduto.
     */
    public com.google.protobuf.ByteString
        getCodigoProdutoBytes() {
      java.lang.Object ref = codigoProduto_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        codigoProduto_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string codigoProduto = 2;</code>
     * @param value The codigoProduto to set.
     * @return This builder for chaining.
     */
    public Builder setCodigoProduto(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      codigoProduto_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string codigoProduto = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearCodigoProduto() {
      
      codigoProduto_ = getDefaultInstance().getCodigoProduto();
      onChanged();
      return this;
    }
    /**
     * <code>string codigoProduto = 2;</code>
     * @param value The bytes for codigoProduto to set.
     * @return This builder for chaining.
     */
    public Builder setCodigoProdutoBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      codigoProduto_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object nomeProduto_ = "";
    /**
     * <code>string nomeProduto = 3;</code>
     * @return The nomeProduto.
     */
    public java.lang.String getNomeProduto() {
      java.lang.Object ref = nomeProduto_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        nomeProduto_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string nomeProduto = 3;</code>
     * @return The bytes for nomeProduto.
     */
    public com.google.protobuf.ByteString
        getNomeProdutoBytes() {
      java.lang.Object ref = nomeProduto_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        nomeProduto_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string nomeProduto = 3;</code>
     * @param value The nomeProduto to set.
     * @return This builder for chaining.
     */
    public Builder setNomeProduto(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      nomeProduto_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string nomeProduto = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearNomeProduto() {
      
      nomeProduto_ = getDefaultInstance().getNomeProduto();
      onChanged();
      return this;
    }
    /**
     * <code>string nomeProduto = 3;</code>
     * @param value The bytes for nomeProduto to set.
     * @return This builder for chaining.
     */
    public Builder setNomeProdutoBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      nomeProduto_ = value;
      onChanged();
      return this;
    }

    private int quantidade_ ;
    /**
     * <code>int32 quantidade = 4;</code>
     * @return The quantidade.
     */
    @java.lang.Override
    public int getQuantidade() {
      return quantidade_;
    }
    /**
     * <code>int32 quantidade = 4;</code>
     * @param value The quantidade to set.
     * @return This builder for chaining.
     */
    public Builder setQuantidade(int value) {
      
      quantidade_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 quantidade = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearQuantidade() {
      
      quantidade_ = 0;
      onChanged();
      return this;
    }

    private double precoUnitario_ ;
    /**
     * <code>double precoUnitario = 5;</code>
     * @return The precoUnitario.
     */
    @java.lang.Override
    public double getPrecoUnitario() {
      return precoUnitario_;
    }
    /**
     * <code>double precoUnitario = 5;</code>
     * @param value The precoUnitario to set.
     * @return This builder for chaining.
     */
    public Builder setPrecoUnitario(double value) {
      
      precoUnitario_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double precoUnitario = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearPrecoUnitario() {
      
      precoUnitario_ = 0D;
      onChanged();
      return this;
    }

    private double total_ ;
    /**
     * <code>double total = 6;</code>
     * @return The total.
     */
    @java.lang.Override
    public double getTotal() {
      return total_;
    }
    /**
     * <code>double total = 6;</code>
     * @param value The total to set.
     * @return This builder for chaining.
     */
    public Builder setTotal(double value) {
      
      total_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double total = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearTotal() {
      
      total_ = 0D;
      onChanged();
      return this;
    }

    private double iva_ ;
    /**
     * <code>double iva = 7;</code>
     * @return The iva.
     */
    @java.lang.Override
    public double getIva() {
      return iva_;
    }
    /**
     * <code>double iva = 7;</code>
     * @param value The iva to set.
     * @return This builder for chaining.
     */
    public Builder setIva(double value) {
      
      iva_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double iva = 7;</code>
     * @return This builder for chaining.
     */
    public Builder clearIva() {
      
      iva_ = 0D;
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


    // @@protoc_insertion_point(builder_scope:contractmanageruser.Sale)
  }

  // @@protoc_insertion_point(class_scope:contractmanageruser.Sale)
  private static final manageruserstubs.Sale DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new manageruserstubs.Sale();
  }

  public static manageruserstubs.Sale getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Sale>
      PARSER = new com.google.protobuf.AbstractParser<Sale>() {
    @java.lang.Override
    public Sale parsePartialFrom(
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

  public static com.google.protobuf.Parser<Sale> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Sale> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public manageruserstubs.Sale getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
