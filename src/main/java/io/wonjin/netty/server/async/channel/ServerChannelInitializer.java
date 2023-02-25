package io.wonjin.netty.server.async.channel;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.wonjin.netty.server.async.handler.Decoder;
import io.wonjin.netty.server.async.handler.RequestProcessor;
import io.wonjin.netty.server.async.handler.ServerHandler;

public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new ServerHandler());
        pipeline.addLast(new Decoder());
        pipeline.addLast(new RequestProcessor());
    }
}
