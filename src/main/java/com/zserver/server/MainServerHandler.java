package com.zserver.server;

import com.zserver.mgr.MessageMgr;
import com.zserver.mgr.MgrLocation;
import com.zserver.proto.MsgOuterClass;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Map;

/**
 * Created by ZZZ on 2017/8/21.
 */
public class MainServerHandler  extends ChannelInboundHandlerAdapter{
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object obj) throws Exception {
        super.channelRead(ctx, obj);

        MsgOuterClass.Msg msg = (MsgOuterClass.Msg) obj;

        System.out.println(msg);

        ChannelId id = ctx.channel().id();

        MgrLocation.INST.getMessageMgr().Dispatch(new MsgEvent(id, msg));

        switch (msg.getMsgid())
        {
            case MSG_ID_CONNET_REQ:
                Map<ChannelId, Channel> map = MgrLocation.INST.getChannelMgr().getChannelMap();
                map.put(id, ctx.channel());
                NotifyConnetRes(id);
                break;
            case MSG_ID_REQ:


                break;
            default:
                break;

        }

    }

    private void NotifyConnetRes(ChannelId id) {

        MsgOuterClass.Msg.Builder builder = MsgOuterClass.Msg.newBuilder();
        builder.setMsgid(MsgOuterClass.MsgId.MSG_ID_CONNET_RES);

        MessageMgr.Send(id, builder.build());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        MgrLocation.INST.getChannelMgr().getChannelMap().remove(ctx.channel().id());

        ctx.close();
    }

    public static MainServerHandler Default() {
        return new MainServerHandler();
    }
}
