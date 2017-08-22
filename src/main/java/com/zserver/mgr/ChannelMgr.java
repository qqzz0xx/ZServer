package com.zserver.mgr;

import io.netty.channel.Channel;
import io.netty.channel.ChannelId;
import sun.rmi.runtime.Log;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by ZZZ on 2017/8/22.
 */
public class ChannelMgr {

    private Map<ChannelId, Channel> channelMap = new Hashtable<ChannelId, Channel>();
    private Map<Long, ChannelId> roleChanelMap = new Hashtable<Long, ChannelId>();

    public Map<ChannelId, Channel> getChannelMap() {
        return channelMap;
    }

    public Map<Long, ChannelId> getRoleChanelMap() {
        return roleChanelMap;
    }

    public Channel GetChannelByRoleID(Long roleID) {
        ChannelId chid = roleChanelMap.get(roleID);
        return channelMap.get(chid);
    }

    //static
    public static Map<ChannelId, Channel> GetChannelMap() {

        return MgrLocation.INST.getChannelMgr().getChannelMap();

    }

}
