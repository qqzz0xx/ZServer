package com.zserver.helper;

import com.zserver.mgr.MgrLocation;
import io.netty.channel.Channel;
import io.netty.channel.ChannelId;

import java.util.Map;

/**
 * Created by ZZZ on 2017/8/22.
 */
public class DefineHelper {

    public static Map<ChannelId, Channel> GetChannelMap() {

        return MgrLocation.INST.getChannelMgr().getChannelMap();

    }


}
