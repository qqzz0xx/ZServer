package com.zserver.mgr;

import com.zserver.proto.MsgOuterClass;
import com.zserver.server.IMsgListener;
import com.zserver.server.MsgEvent;
import io.netty.channel.Channel;
import io.netty.channel.ChannelId;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Created by ZZZ on 2017/8/22.
 */


public class MessageMgr {

    private Map<MsgOuterClass.MsgId , List<IMsgListener>> msgListenerMap
            = new Hashtable<>();

    public void AddListener(MsgOuterClass.MsgId msgId, IMsgListener listener) {
        List<IMsgListener> list = msgListenerMap.get(msgId);
        if (list == null) {
            list = new Vector<IMsgListener>();
            msgListenerMap.put(msgId, list);
        }
        list.add(listener);
    }

    public void RemoveListener(MsgOuterClass.MsgId msgId, IMsgListener listener) {
        List<IMsgListener> list = msgListenerMap.get(msgId);
        if (list == null) return;
        list.remove(listener);
    }

    public void Dispatch(MsgEvent event) {

        List<IMsgListener> msgListenerList = msgListenerMap.get(event.msg.getMsgid());
        if (msgListenerList != null ) {
            for (IMsgListener listener : msgListenerList) {
                listener.Invoke(event);
            }
        }
    }


    public static void Send(ChannelId id, MsgOuterClass.Msg msg) {

        Map<ChannelId, Channel> map = ChannelMgr.GetChannelMap();
        Channel channel = map.get(id);
        channel.writeAndFlush(msg);

    }

    public static void Send(Channel channel, MsgOuterClass.Msg msg) {

        channel.writeAndFlush(msg);
    }

}
