package com.zserver.client;

import com.zserver.proto.MsgOuterClass;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by ZZZ on 2017/8/22.
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        MsgOuterClass.Msg.Builder msgbuilder = MsgOuterClass.Msg.newBuilder();
        msgbuilder.setMsgid(MsgOuterClass.MsgId.MSG_ID_REQ);
        msgbuilder.setSeqid(2);

        MsgOuterClass.Msg req = msgbuilder.build();

        ctx.writeAndFlush(req);

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        MsgOuterClass.Msg msg1 = (MsgOuterClass.Msg) msg;
        System.out.println(msg1);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    public static ClientHandler Default() {
        return new ClientHandler();
    }
}
