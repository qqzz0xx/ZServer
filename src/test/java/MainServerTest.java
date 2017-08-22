import com.zserver.client.Client;
import com.zserver.server.MainServer;
import com.zserver.helper.ByteHelper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.zserver.proto.MsgOuterClass;
import io.netty.channel.ChannelFuture;
import org.junit.Test;

import java.net.InetSocketAddress;

/**
 * Created by ZZZ on 2017/8/21.
 */
public class MainServerTest {
    @Test
    public void RunTest() {

        MainServer mainServer = new MainServer(8888);
        mainServer.Run();
    }

    @Test
    public void RunClient() {
        Client client = new Client();
        ChannelFuture f = client.Connet(new InetSocketAddress("127.0.0.1", 8888));


        MsgOuterClass.Msg.Builder msgbuilder = MsgOuterClass.Msg.newBuilder();
        msgbuilder.setMsgid(MsgOuterClass.MsgId.MSG_ID_CONNET_REQ);
        msgbuilder.getBodyBuilder().getConnetReqBuilder().setT1(2);
        msgbuilder.getBodyBuilder().getConnetReqBuilder().setT2(22);
        msgbuilder.getBodyBuilder().getConnetResBuilder().setPlatform(444);

        MsgOuterClass.Msg req = msgbuilder.build();

        try {
            f.channel().writeAndFlush(req);

            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.Close();
        }


        Log("run client");
    }


    @Test
    public void GetSysProperty() {
        Log(System.getProperty("ssl"));
        String a = System.getProperty("port", "8080");
    }

    @Test
    public void ProtoTest() {
        MsgOuterClass.Msg.Builder msgBuilder = MsgOuterClass.Msg.newBuilder();
        msgBuilder.setSeqid(1);
        msgBuilder.setMsgid(MsgOuterClass.MsgId.MSG_ID_REQ);
        MsgOuterClass.Body.Builder builderBody = MsgOuterClass.Body.newBuilder();
        msgBuilder.setBody(builderBody.build());

        MsgOuterClass.Msg msg = msgBuilder.build();

        Log(msg.toString());

        byte[] data = msg.toByteArray();
        try {
            MsgOuterClass.Msg pMsg = MsgOuterClass.Msg.parseFrom(data);

            Log("" + pMsg.getMsgid());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void IntToByteTest() {

        byte[] b = ByteHelper.Int32ToBytes(4);


        MsgOuterClass.Msg.Builder builder = MsgOuterClass.Msg.newBuilder();
        MsgOuterClass.Body.Builder bb = builder.getBodyBuilder();


        MsgOuterClass.Msg msg = builder.build();



    }




    void Log(String log) {
        System.out.println(log);

    }


}