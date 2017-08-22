package com.zserver.client;

import com.zserver.server.LengthDecoder;
import com.zserver.server.MessageDecoder;
import com.zserver.server.MessageEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * Created by ZZZ on 2017/8/22.
 */
public class Client {
    EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

    public ChannelFuture Connet(SocketAddress address)
    {
        final Bootstrap serverBootstrap = new Bootstrap();

        serverBootstrap.group(eventLoopGroup);
        serverBootstrap.channel(NioSocketChannel.class);
        serverBootstrap.remoteAddress(address);
        serverBootstrap.option(ChannelOption.TCP_NODELAY, true);
        serverBootstrap.handler(new ChannelInitializer<SocketChannel>() {
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                ChannelPipeline p = socketChannel.pipeline();
                p.addLast(LengthDecoder.Default());
                p.addLast(MessageDecoder.Default());
                p.addLast(MessageEncoder.Default());
                p.addLast(ClientHandler.Default());

            }
        });

        ChannelFuture f = serverBootstrap.connect();
        return f;

    }
    public ChannelFuture Connet(String ip, int port)
    {
        InetSocketAddress ad = new InetSocketAddress(ip, port);
        return Connet(ad);
    }
    public void Close() {
        eventLoopGroup.shutdownGracefully();
    }


}
