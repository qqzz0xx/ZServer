package com.zserver.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
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

    public static int MaxFrameLength = 1024;
    public static int BodyLengthOffset = 0;
    public static int BodyLengthSize= 4;

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
        serverBootstrap.option(ChannelOption.SO_BACKLOG, MaxFrameLength);

        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                ChannelPipeline p = socketChannel.pipeline();
                p.addLast(LengthDecoder.Default());
                p.addLast(MessageDecoder.Default());
                p.addLast(MessageEncoder.Default());
                p.addLast(MainServerHandler.Default());

            }
        });

        try {
            ChannelFuture f = serverBootstrap.bind(m_Port).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            childLoopGroup.shutdownGracefully();
            eventLoopGroup.shutdownGracefully();

        }


    }

}
