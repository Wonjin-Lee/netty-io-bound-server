package io.wonjin.netty.server.async.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.wonjin.netty.server.async.domain.DataBody;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;
import java.util.List;

@Slf4j
public class Decoder extends ByteToMessageDecoder {

    private static final int DATA_BODY_LENGTH = 520;
    private static final String EUC_KR = "EUC-KR";

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        log.info("[Decoder - decode] Byte Stream -> DataBody !!!");

        log.info(in.readableBytes() + "");

        if (in.readableBytes() >= DATA_BODY_LENGTH) {

            DataBody requestBody = new DataBody();

            requestBody.setItem1(in.readBytes(7).toString(Charset.forName(EUC_KR)));
            requestBody.setItem2(in.readBytes(4).toString(Charset.forName(EUC_KR)));
            requestBody.setItem3(in.readBytes(3).toString(Charset.forName(EUC_KR)));
            requestBody.setItem4(in.readBytes(3).toString(Charset.forName(EUC_KR)));
            requestBody.setItem5(in.readBytes(6).toString(Charset.forName(EUC_KR)));
            requestBody.setItem6(in.readBytes(18).toString(Charset.forName(EUC_KR)));
            requestBody.setItem7(in.readBytes(19).toString(Charset.forName(EUC_KR)));
            requestBody.setItem8(in.readBytes(460).toString(Charset.forName(EUC_KR)));

            out.add(requestBody);
        }
    }
}
