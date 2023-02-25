package io.wonjin.netty.server.async;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.wonjin.netty.server.Server;
import io.wonjin.netty.server.async.channel.ClientChannelInitializer;
import io.wonjin.netty.server.async.channel.ServerChannelInitializer;

import java.util.stream.IntStream;

public class AsyncServer implements Server {
    @Override
    public void run() {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap clientBootstrap = new Bootstrap()
                .group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .handler(new ClientChannelInitializer())
                .remoteAddress("127.0.0.1", 20000);

        IntStream.rangeClosed(0, 4).forEach(i -> clientBootstrap.bind());

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap()
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .handler(new ServerChannelInitializer());

        serverBootstrap.bind(20000);
    }
}
