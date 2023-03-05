package io.wonjin.netty.server.async.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.wonjin.netty.server.async.domain.DataBody;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Decoder extends ByteToMessageDecoder {

    private static final int DATA_BODY_LENGTH = 0;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        log.info("[Decoder - decode] Byte Stream -> DataBody !!!");

        if (in.readableBytes() >= DATA_BODY_LENGTH) {
            // TODO Byte Stream -> DataBody

            DataBody requestBody = new DataBody();
            out.add(requestBody);
        }
    }
}
