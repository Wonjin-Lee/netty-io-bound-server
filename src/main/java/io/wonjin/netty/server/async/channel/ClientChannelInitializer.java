package io.wonjin.netty.server.async.channel;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.wonjin.netty.server.async.handler.ClientHandler;
import io.wonjin.netty.server.async.handler.Encoder;
import io.wonjin.netty.server.async.handler.ResponseProcessor;

public class ClientChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new ClientHandler());
        pipeline.addLast(new ResponseProcessor());
        pipeline.addLast(new Encoder());
    }
}
