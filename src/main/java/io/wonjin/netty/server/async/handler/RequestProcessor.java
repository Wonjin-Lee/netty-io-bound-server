package io.wonjin.netty.server.async.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.wonjin.netty.server.async.channel.ClientChannelPool;
import io.wonjin.netty.server.async.domain.DataBody;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestProcessor extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("[RequestProcessor - channelRead] Put RequestBody In ClientChannel !!!");

        DataBody requestBody = (DataBody) msg;

        Channel channel = ClientChannelPool.getChannel();
        channel.writeAndFlush(requestBody);
    }
}
