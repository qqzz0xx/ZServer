package com.zserver.helper;

import com.zserver.mgr.MgrLocation;
import com.zserver.proto.MsgOuterClass;
import io.netty.channel.Channel;
import io.netty.channel.ChannelId;

import java.util.Map;


/**
 * Created by ZZZ on 2017/8/22.
 */
public class MessageHelper {
    public static void Send(ChannelId id, MsgOuterClass.Msg msg) {

        Map<ChannelId, Channel> map = DefineHelper.GetChannelMap();
        Channel channel = map.get(id);
        channel.writeAndFlush(msg);

    }

    public static void Send(Channel channel, MsgOuterClass.Msg msg) {

        channel.writeAndFlush(msg);
    }

}
