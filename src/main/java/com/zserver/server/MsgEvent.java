package com.zserver.server;

import com.zserver.proto.MsgOuterClass;
import io.netty.channel.ChannelId;

/**
 * Created by ZZZ on 2017/8/25.
 */
public class MsgEvent{
    public ChannelId channelId;
    public MsgOuterClass.Msg msg;

    public MsgEvent(ChannelId channelId, MsgOuterClass.Msg msg) {
        this.channelId = channelId;
        this.msg = msg;
    }
}
