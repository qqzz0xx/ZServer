package com.zserver.mgr;

import com.zserver.proto.MsgOuterClass;
import io.netty.channel.Channel;
import io.netty.channel.ChannelId;

import java.util.Map;

/**
 * Created by ZZZ on 2017/8/22.
 */
public class MessageMgr {


    public static void Send(ChannelId id, MsgOuterClass.Msg msg) {

        Map<ChannelId, Channel> map = ChannelMgr.GetChannelMap();
        Channel channel = map.get(id);
        channel.writeAndFlush(msg);

    }

    public static void Send(Channel channel, MsgOuterClass.Msg msg) {

        channel.writeAndFlush(msg);
    }

}
