import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * Created by ZZZ on 2017/8/21.
 */
public class MainServer {
    private int m_Port = 8888;

    public MainServer() {
        m_Port = 8888;
    }

    public MainServer(int port) {
        m_Port = port;
    }


    public void Run()
    {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        EventLoopGroup childLoopGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap.group(eventLoopGroup, childLoopGroup);
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.handler(new LoggingHandler(LogLevel.DEBUG));

        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                ChannelPipeline p = socketChannel.pipeline();
                p.addLast(new EchoHandler());
                p.addLast(LengthDecoder.Default());
                p.addLast(MessageDecoder.Default());

            }
        });

        try {
            ChannelFuture f = serverBootstrap.bind(m_Port).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {

            eventLoopGroup.shutdownGracefully();

        }


    }

}
