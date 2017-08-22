package com.zserver.mgr;

import io.netty.channel.Channel;
import io.netty.channel.ChannelId;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by ZZZ on 2017/8/22.
 */
public class ChannelMgr {

    private Map<ChannelId, Channel> channelMap = new Hashtable<ChannelId, Channel>();


    public Map<ChannelId, Channel> getChannelMap() {
        return channelMap;
    }
}
