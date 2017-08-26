package com.zserver.server;

/**
 * Created by ZZZ on 2017/8/25.
 */
public interface IMsgListener{
    void Invoke(MsgEvent event);
}