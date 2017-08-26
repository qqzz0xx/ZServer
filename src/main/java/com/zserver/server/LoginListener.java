package com.zserver.server;

import com.zserver.mgr.MessageMgr;
import com.zserver.mgr.MgrLocation;
import com.zserver.proto.MsgOuterClass;
import io.netty.channel.ChannelId;

/**
 * Created by ZZZ on 2017/8/25.
 */
public class LoginListener implements IMsgListener {
    @Override
    public void Invoke(MsgEvent event) {
        long userId = event.msg.getBody().getLoginReq().getUserid();
        String passWd = MgrLocation.INST.getDbMgr().FindPasswd(userId);

        if (passWd.equals(event.msg.getBody().getLoginReq().getPasswd())) {
            NotifyLogin(event.channelId, true);
        }else {
            NotifyLogin(event.channelId, false);
        }

    }

    private void NotifyLogin(ChannelId channelId, boolean isSucc) {
        MsgOuterClass.Msg.Builder builder = MsgOuterClass.Msg.newBuilder();
        builder.setMsgid(MsgOuterClass.MsgId.MSG_ID_LOGIN_REQ);
        builder.getBodyBuilder().getLoginResBuilder().setSucc(isSucc);

        MessageMgr.Send(channelId, builder.build());
    }

}
