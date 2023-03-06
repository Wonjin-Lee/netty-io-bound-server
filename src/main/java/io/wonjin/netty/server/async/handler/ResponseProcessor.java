package io.wonjin.netty.server.async.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.wonjin.netty.server.async.domain.DataBody;
import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;

@Slf4j
public class ResponseProcessor extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("[ResponseProcessor - channelRead] Send ResponseBody To Encoder !!!");

        DataBody requestBody = (DataBody) msg;

        DataBody responseBody = new DataBody();
        responseBody.setItem1(requestBody.getItem1());
        responseBody.setItem2("0210");
        responseBody.setItem3(requestBody.getItem3());
        responseBody.setItem4("000");
        responseBody.setItem5(requestBody.getItem5());
        responseBody.setItem6(requestBody.getItem6());
        responseBody.setItem7(generateMockData(requestBody.getItem7()));

        ctx.writeAndFlush(responseBody);
    }

    private String generateMockData(String baseData) {
        SecureRandom random = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < baseData.trim().length(); i++) {
            if (random.nextBoolean()) {
                stringBuilder.append((char)(random.nextInt(26) + 97));
            } else {
                stringBuilder.append(random.nextInt(10));
            }
        }

        return baseData.trim() + stringBuilder;
    }
}
