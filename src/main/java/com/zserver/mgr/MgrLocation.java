package com.zserver.mgr;

/**
 * Created by ZZZ on 2017/8/22.
 */
public enum  MgrLocation {
    INST;

    private ChannelMgr channelMgr = new ChannelMgr();
    private MessageMgr messageMgr = new MessageMgr();
    private DBMgr dbMgr = new DBMgr();

    public ChannelMgr getChannelMgr() {
        return channelMgr;
    }

    public MessageMgr getMessageMgr() {
        return messageMgr;
    }

    public DBMgr getDbMgr() {
        return dbMgr;
    }
}
