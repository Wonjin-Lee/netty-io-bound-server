package io.wonjin.netty.server.async.channel;

import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Slf4j
public class ClientChannelPool {
    private static final Queue<Channel> queue = new ConcurrentLinkedQueue<>();

    public static Channel getChannel() {
        return queue.peek();
    }

    public static void addChannel(Channel channel) {
        queue.add(channel);
        log.info("Current Pool Size : {}", queue.size());
    }
}
