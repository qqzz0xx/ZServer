// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: msg.proto

public final class MsgOuterClass {
  private MsgOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  /**
   * Protobuf enum {@code MsgId}
   */
  public enum MsgId
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>MSG_ID_REQ = 1;</code>
     */
    MSG_ID_REQ(0, 1),
    /**
     * <code>MSG_ID_RES = 2;</code>
     */
    MSG_ID_RES(1, 2),
    ;

    /**
     * <code>MSG_ID_REQ = 1;</code>
     */
    public static final int MSG_ID_REQ_VALUE = 1;
    /**
     * <code>MSG_ID_RES = 2;</code>
     */
    public static final int MSG_ID_RES_VALUE = 2;


    public final int getNumber() {
      return value;
    }

    public static MsgId valueOf(int value) {
      switch (value) {
        case 1: return MSG_ID_REQ;
        case 2: return MSG_ID_RES;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<MsgId>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        MsgId> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<MsgId>() {
            public MsgId findValueByNumber(int number) {
              return MsgId.valueOf(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(index);
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return MsgOuterClass.getDescriptor().getEnumTypes().get(0);
    }

    private static final MsgId[] VALUES = values();

    public static MsgId valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }

    private final int index;
    private final int value;

    private MsgId(int index, int value) {
      this.index = index;
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:MsgId)
  }

  public interface MsgOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Msg)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional .MsgId msgid = 1;</code>
     */
    boolean hasMsgid();
    /**
     * <code>optional .MsgId msgid = 1;</code>
     */
    MsgOuterClass.MsgId getMsgid();

    /**
     * <code>optional int32 seqid = 2;</code>
     */
    boolean hasSeqid();
    /**
     * <code>optional int32 seqid = 2;</code>
     */
    int getSeqid();

    /**
     * <code>optional .Body body = 3;</code>
     */
    boolean hasBody();
    /**
     * <code>optional .Body body = 3;</code>
     */
    MsgOuterClass.Body getBody();
    /**
     * <code>optional .Body body = 3;</code>
     */
    MsgOuterClass.BodyOrBuilder getBodyOrBuilder();
  }
  /**
   * Protobuf type {@code Msg}
   */
  public  static final class Msg extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:Msg)
      MsgOrBuilder {
    // Use Msg.newBuilder() to construct.
    private Msg(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
    }
    private Msg() {
      msgid_ = 1;
      seqid_ = 0;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Msg(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry) {
      this();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              int rawValue = input.readEnum();
              MsgOuterClass.MsgId value = MsgOuterClass.MsgId.valueOf(rawValue);
              if (value == null) {
                unknownFields.mergeVarintField(1, rawValue);
              } else {
                bitField0_ |= 0x00000001;
                msgid_ = rawValue;
              }
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              seqid_ = input.readInt32();
              break;
            }
            case 26: {
              MsgOuterClass.Body.Builder subBuilder = null;
              if (((bitField0_ & 0x00000004) == 0x00000004)) {
                subBuilder = body_.toBuilder();
              }
              body_ = input.readMessage(MsgOuterClass.Body.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(body_);
                body_ = subBuilder.buildPartial();
              }
              bitField0_ |= 0x00000004;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw new RuntimeException(e.setUnfinishedMessage(this));
      } catch (java.io.IOException e) {
        throw new RuntimeException(
            new com.google.protobuf.InvalidProtocolBufferException(
                e.getMessage()).setUnfinishedMessage(this));
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return MsgOuterClass.internal_static_Msg_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MsgOuterClass.internal_static_Msg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              MsgOuterClass.Msg.class, MsgOuterClass.Msg.Builder.class);
    }

    private int bitField0_;
    public static final int MSGID_FIELD_NUMBER = 1;
    private int msgid_;
    /**
     * <code>optional .MsgId msgid = 1;</code>
     */
    public boolean hasMsgid() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional .MsgId msgid = 1;</code>
     */
    public MsgOuterClass.MsgId getMsgid() {
      MsgOuterClass.MsgId result = MsgOuterClass.MsgId.valueOf(msgid_);
      return result == null ? MsgOuterClass.MsgId.MSG_ID_REQ : result;
    }

    public static final int SEQID_FIELD_NUMBER = 2;
    private int seqid_;
    /**
     * <code>optional int32 seqid = 2;</code>
     */
    public boolean hasSeqid() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional int32 seqid = 2;</code>
     */
    public int getSeqid() {
      return seqid_;
    }

    public static final int BODY_FIELD_NUMBER = 3;
    private MsgOuterClass.Body body_;
    /**
     * <code>optional .Body body = 3;</code>
     */
    public boolean hasBody() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional .Body body = 3;</code>
     */
    public MsgOuterClass.Body getBody() {
      return body_ == null ? MsgOuterClass.Body.getDefaultInstance() : body_;
    }
    /**
     * <code>optional .Body body = 3;</code>
     */
    public MsgOuterClass.BodyOrBuilder getBodyOrBuilder() {
      return body_ == null ? MsgOuterClass.Body.getDefaultInstance() : body_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeEnum(1, msgid_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeInt32(2, seqid_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeMessage(3, getBody());
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(1, msgid_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, seqid_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(3, getBody());
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    public static MsgOuterClass.Msg parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static MsgOuterClass.Msg parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static MsgOuterClass.Msg parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static MsgOuterClass.Msg parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static MsgOuterClass.Msg parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static MsgOuterClass.Msg parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static MsgOuterClass.Msg parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static MsgOuterClass.Msg parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static MsgOuterClass.Msg parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static MsgOuterClass.Msg parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(MsgOuterClass.Msg prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Msg}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Msg)
        MsgOuterClass.MsgOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return MsgOuterClass.internal_static_Msg_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return MsgOuterClass.internal_static_Msg_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                MsgOuterClass.Msg.class, MsgOuterClass.Msg.Builder.class);
      }

      // Construct using MsgOuterClass.Msg.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
          getBodyFieldBuilder();
        }
      }
      public Builder clear() {
        super.clear();
        msgid_ = 1;
        bitField0_ = (bitField0_ & ~0x00000001);
        seqid_ = 0;
        bitField0_ = (bitField0_ & ~0x00000002);
        if (bodyBuilder_ == null) {
          body_ = null;
        } else {
          bodyBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000004);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return MsgOuterClass.internal_static_Msg_descriptor;
      }

      public MsgOuterClass.Msg getDefaultInstanceForType() {
        return MsgOuterClass.Msg.getDefaultInstance();
      }

      public MsgOuterClass.Msg build() {
        MsgOuterClass.Msg result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public MsgOuterClass.Msg buildPartial() {
        MsgOuterClass.Msg result = new MsgOuterClass.Msg(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.msgid_ = msgid_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.seqid_ = seqid_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        if (bodyBuilder_ == null) {
          result.body_ = body_;
        } else {
          result.body_ = bodyBuilder_.build();
        }
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof MsgOuterClass.Msg) {
          return mergeFrom((MsgOuterClass.Msg)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(MsgOuterClass.Msg other) {
        if (other == MsgOuterClass.Msg.getDefaultInstance()) return this;
        if (other.hasMsgid()) {
          setMsgid(other.getMsgid());
        }
        if (other.hasSeqid()) {
          setSeqid(other.getSeqid());
        }
        if (other.hasBody()) {
          mergeBody(other.getBody());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        MsgOuterClass.Msg parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (MsgOuterClass.Msg) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int msgid_ = 1;
      /**
       * <code>optional .MsgId msgid = 1;</code>
       */
      public boolean hasMsgid() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>optional .MsgId msgid = 1;</code>
       */
      public MsgOuterClass.MsgId getMsgid() {
        MsgOuterClass.MsgId result = MsgOuterClass.MsgId.valueOf(msgid_);
        return result == null ? MsgOuterClass.MsgId.MSG_ID_REQ : result;
      }
      /**
       * <code>optional .MsgId msgid = 1;</code>
       */
      public Builder setMsgid(MsgOuterClass.MsgId value) {
        if (value == null) {
          throw new NullPointerException();
        }
        bitField0_ |= 0x00000001;
        msgid_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <code>optional .MsgId msgid = 1;</code>
       */
      public Builder clearMsgid() {
        bitField0_ = (bitField0_ & ~0x00000001);
        msgid_ = 1;
        onChanged();
        return this;
      }

      private int seqid_ ;
      /**
       * <code>optional int32 seqid = 2;</code>
       */
      public boolean hasSeqid() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>optional int32 seqid = 2;</code>
       */
      public int getSeqid() {
        return seqid_;
      }
      /**
       * <code>optional int32 seqid = 2;</code>
       */
      public Builder setSeqid(int value) {
        bitField0_ |= 0x00000002;
        seqid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 seqid = 2;</code>
       */
      public Builder clearSeqid() {
        bitField0_ = (bitField0_ & ~0x00000002);
        seqid_ = 0;
        onChanged();
        return this;
      }

      private MsgOuterClass.Body body_ = null;
      private com.google.protobuf.SingleFieldBuilder<
          MsgOuterClass.Body, MsgOuterClass.Body.Builder, MsgOuterClass.BodyOrBuilder> bodyBuilder_;
      /**
       * <code>optional .Body body = 3;</code>
       */
      public boolean hasBody() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>optional .Body body = 3;</code>
       */
      public MsgOuterClass.Body getBody() {
        if (bodyBuilder_ == null) {
          return body_ == null ? MsgOuterClass.Body.getDefaultInstance() : body_;
        } else {
          return bodyBuilder_.getMessage();
        }
      }
      /**
       * <code>optional .Body body = 3;</code>
       */
      public Builder setBody(MsgOuterClass.Body value) {
        if (bodyBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          body_ = value;
          onChanged();
        } else {
          bodyBuilder_.setMessage(value);
        }
        bitField0_ |= 0x00000004;
        return this;
      }
      /**
       * <code>optional .Body body = 3;</code>
       */
      public Builder setBody(
          MsgOuterClass.Body.Builder builderForValue) {
        if (bodyBuilder_ == null) {
          body_ = builderForValue.build();
          onChanged();
        } else {
          bodyBuilder_.setMessage(builderForValue.build());
        }
        bitField0_ |= 0x00000004;
        return this;
      }
      /**
       * <code>optional .Body body = 3;</code>
       */
      public Builder mergeBody(MsgOuterClass.Body value) {
        if (bodyBuilder_ == null) {
          if (((bitField0_ & 0x00000004) == 0x00000004) &&
              body_ != null &&
              body_ != MsgOuterClass.Body.getDefaultInstance()) {
            body_ =
              MsgOuterClass.Body.newBuilder(body_).mergeFrom(value).buildPartial();
          } else {
            body_ = value;
          }
          onChanged();
        } else {
          bodyBuilder_.mergeFrom(value);
        }
        bitField0_ |= 0x00000004;
        return this;
      }
      /**
       * <code>optional .Body body = 3;</code>
       */
      public Builder clearBody() {
        if (bodyBuilder_ == null) {
          body_ = null;
          onChanged();
        } else {
          bodyBuilder_.clear();
        }
        bitField0_ = (bitField0_ & ~0x00000004);
        return this;
      }
      /**
       * <code>optional .Body body = 3;</code>
       */
      public MsgOuterClass.Body.Builder getBodyBuilder() {
        bitField0_ |= 0x00000004;
        onChanged();
        return getBodyFieldBuilder().getBuilder();
      }
      /**
       * <code>optional .Body body = 3;</code>
       */
      public MsgOuterClass.BodyOrBuilder getBodyOrBuilder() {
        if (bodyBuilder_ != null) {
          return bodyBuilder_.getMessageOrBuilder();
        } else {
          return body_ == null ?
              MsgOuterClass.Body.getDefaultInstance() : body_;
        }
      }
      /**
       * <code>optional .Body body = 3;</code>
       */
      private com.google.protobuf.SingleFieldBuilder<
          MsgOuterClass.Body, MsgOuterClass.Body.Builder, MsgOuterClass.BodyOrBuilder> 
          getBodyFieldBuilder() {
        if (bodyBuilder_ == null) {
          bodyBuilder_ = new com.google.protobuf.SingleFieldBuilder<
              MsgOuterClass.Body, MsgOuterClass.Body.Builder, MsgOuterClass.BodyOrBuilder>(
                  getBody(),
                  getParentForChildren(),
                  isClean());
          body_ = null;
        }
        return bodyBuilder_;
      }

      // @@protoc_insertion_point(builder_scope:Msg)
    }

    // @@protoc_insertion_point(class_scope:Msg)
    private static final MsgOuterClass.Msg DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new MsgOuterClass.Msg();
    }

    public static MsgOuterClass.Msg getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<Msg>
        PARSER = new com.google.protobuf.AbstractParser<Msg>() {
      public Msg parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        try {
          return new Msg(input, extensionRegistry);
        } catch (RuntimeException e) {
          if (e.getCause() instanceof
              com.google.protobuf.InvalidProtocolBufferException) {
            throw (com.google.protobuf.InvalidProtocolBufferException)
                e.getCause();
          }
          throw e;
        }
      }
    };

    public static com.google.protobuf.Parser<Msg> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Msg> getParserForType() {
      return PARSER;
    }

    public MsgOuterClass.Msg getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface BodyOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Body)
      com.google.protobuf.MessageOrBuilder {
  }
  /**
   * Protobuf type {@code Body}
   */
  public  static final class Body extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:Body)
      BodyOrBuilder {
    // Use Body.newBuilder() to construct.
    private Body(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
    }
    private Body() {
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Body(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry) {
      this();
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw new RuntimeException(e.setUnfinishedMessage(this));
      } catch (java.io.IOException e) {
        throw new RuntimeException(
            new com.google.protobuf.InvalidProtocolBufferException(
                e.getMessage()).setUnfinishedMessage(this));
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return MsgOuterClass.internal_static_Body_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return MsgOuterClass.internal_static_Body_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              MsgOuterClass.Body.class, MsgOuterClass.Body.Builder.class);
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    public static MsgOuterClass.Body parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static MsgOuterClass.Body parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static MsgOuterClass.Body parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static MsgOuterClass.Body parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static MsgOuterClass.Body parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static MsgOuterClass.Body parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static MsgOuterClass.Body parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static MsgOuterClass.Body parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static MsgOuterClass.Body parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static MsgOuterClass.Body parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(MsgOuterClass.Body prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Body}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Body)
        MsgOuterClass.BodyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return MsgOuterClass.internal_static_Body_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return MsgOuterClass.internal_static_Body_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                MsgOuterClass.Body.class, MsgOuterClass.Body.Builder.class);
      }

      // Construct using MsgOuterClass.Body.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return MsgOuterClass.internal_static_Body_descriptor;
      }

      public MsgOuterClass.Body getDefaultInstanceForType() {
        return MsgOuterClass.Body.getDefaultInstance();
      }

      public MsgOuterClass.Body build() {
        MsgOuterClass.Body result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public MsgOuterClass.Body buildPartial() {
        MsgOuterClass.Body result = new MsgOuterClass.Body(this);
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof MsgOuterClass.Body) {
          return mergeFrom((MsgOuterClass.Body)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(MsgOuterClass.Body other) {
        if (other == MsgOuterClass.Body.getDefaultInstance()) return this;
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        MsgOuterClass.Body parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (MsgOuterClass.Body) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      // @@protoc_insertion_point(builder_scope:Body)
    }

    // @@protoc_insertion_point(class_scope:Body)
    private static final MsgOuterClass.Body DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new MsgOuterClass.Body();
    }

    public static MsgOuterClass.Body getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<Body>
        PARSER = new com.google.protobuf.AbstractParser<Body>() {
      public Body parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        try {
          return new Body(input, extensionRegistry);
        } catch (RuntimeException e) {
          if (e.getCause() instanceof
              com.google.protobuf.InvalidProtocolBufferException) {
            throw (com.google.protobuf.InvalidProtocolBufferException)
                e.getCause();
          }
          throw e;
        }
      }
    };

    public static com.google.protobuf.Parser<Body> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Body> getParserForType() {
      return PARSER;
    }

    public MsgOuterClass.Body getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_Msg_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Msg_fieldAccessorTable;
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_Body_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Body_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\tmsg.proto\"@\n\003Msg\022\025\n\005msgid\030\001 \001(\0162\006.MsgI" +
      "d\022\r\n\005seqid\030\002 \001(\005\022\023\n\004body\030\003 \001(\0132\005.Body\"\006\n" +
      "\004Body*\'\n\005MsgId\022\016\n\nMSG_ID_REQ\020\001\022\016\n\nMSG_ID" +
      "_RES\020\002"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Msg_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Msg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_Msg_descriptor,
        new java.lang.String[] { "Msgid", "Seqid", "Body", });
    internal_static_Body_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Body_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_Body_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}