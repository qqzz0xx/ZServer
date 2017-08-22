package com.zserver.com.zserver.server;

import com.zserver.helper.ByteHelper;
import com.zserver.proto.MsgOuterClass;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by sunqiongzai on 2017/8/21.
 */

public class MessageEncoder extends MessageToByteEncoder<MsgOuterClass.Msg> {

    protected void encode(ChannelHandlerContext channelHandlerContext, MsgOuterClass.Msg msg, ByteBuf byteBuf) throws Exception {

        byte[] data = msg.toByteArray();
        byte[] size = ByteHelper.Int32ToBytes(data.length);

        byteBuf.writeBytes(size);
        byteBuf.writeBytes(data);

    }

    public static MessageEncoder Default() {
        return new MessageEncoder();
    }
}
