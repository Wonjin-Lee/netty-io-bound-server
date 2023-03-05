package io.wonjin.netty.server.async.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.wonjin.netty.server.async.domain.DataBody;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;

@Slf4j
public class Encoder extends MessageToByteEncoder {

    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        log.info("[Encoder - encode] DataBody -> Byte Stream !!!");

        DataBody responseBody = (DataBody) msg;
        out.writeBytes(responseBody.toString().getBytes(Charset.forName("euc-kr")));
    }
}
