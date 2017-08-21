import com.zserver.helper.ByteHelper;
import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Test;

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




    }


    void Log(String log) {
        System.out.println(log);

    }


}