package io.wonjin.netty.server.async.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.wonjin.netty.server.async.channel.ClientChannelPool;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        log.info("Channel ID : {}", channel.id());

        ClientChannelPool.addChannel(channel);
    }
}
