package io.wonjin.netty.server.async.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.wonjin.netty.server.async.domain.DataBody;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResponseProcessor extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("[ResponseProcessor - channelRead] Send ResponseBody To Encoder !!!");

        DataBody requestBody = (DataBody) msg;

        // TODO Request -> Response
        DataBody responseBody = new DataBody();

        ctx.writeAndFlush(responseBody);
    }
}
