import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by ZZZ on 2017/8/21.
 */
public class MainServerHandler  extends ChannelInboundHandlerAdapter{
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);

        MsgOuterClass.Msg req = (MsgOuterClass.Msg) msg;

        System.out.println(req);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ctx.close();
    }

    public static MainServerHandler Default() {
        return new MainServerHandler();
    }
}
