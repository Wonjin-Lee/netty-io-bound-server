package io.wonjin.netty.server.async;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.wonjin.netty.server.Server;
import io.wonjin.netty.server.async.channel.ClientChannelInitializer;
import io.wonjin.netty.server.async.channel.ClientChannelPool;
import io.wonjin.netty.server.async.channel.ServerChannelInitializer;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;

@Slf4j
public class AsyncServer implements Server {

    private static final int SERVER_PORT = 20200;
    private static final int CLIENT_PORT = 20100;

    @Override
    public void run() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap()
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ServerChannelInitializer());

        log.info("Server Port : {}", SERVER_PORT);

        serverBootstrap.bind(new InetSocketAddress(SERVER_PORT));

//        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
//        Bootstrap clientBootstrap = new Bootstrap()
//                .group(eventLoopGroup)
//                .channel(NioSocketChannel.class)
//                .handler(new ClientChannelInitializer());
//
//        log.info("Client Port : {}", SERVER_PORT);
//
//        while (true) {
//            boolean isConnected = true;
//            for (int i = 0; i < 5; i++) {
//                ChannelFuture future = clientBootstrap.connect(new InetSocketAddress("127.0.0.1", SERVER_PORT));
//
//                Thread.sleep(2000);
//                if (!future.channel().isActive()) {
//                    log.warn("Client socket is not connected !!!");
//                    Thread.sleep(5000);
//                    isConnected = false;
//                    break;
//                }
//            }
//
//            if (isConnected) {
//                break;
//            }
//        }
//
//        Thread.sleep(5000);
//
//        log.info("Bootstrap Succcess !!!");
//
//        ClientChannelPool.getStoredChannelList().forEach(channel -> {
//            log.info(channel.toString());
//            log.info("" + channel.id());
//        });
    }
}
