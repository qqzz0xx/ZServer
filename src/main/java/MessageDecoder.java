import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created by ZZZ on 2017/8/21.
 */
public class MessageDecoder extends ByteToMessageDecoder {
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        byte[] data = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(data);

        MsgOuterClass.Msg msg = MsgOuterClass.Msg.parseFrom(data);

        list.add(msg);

    }

    public static MessageDecoder Default() {
        return new MessageDecoder();
    }
}
