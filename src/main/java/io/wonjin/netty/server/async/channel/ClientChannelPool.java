package io.wonjin.netty.server.async.channel;

import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ClientChannelPool {
    private static final List<Channel> list = new ArrayList<>();

    public static Channel getChannel() {
        int randomIndex = new SecureRandom().nextInt(list.size());
        return list.get(randomIndex);
    }

    public static void addChannel(Channel channel) {
        list.add(channel);
        log.info("Current Pool Size : {}", list.size());
    }

    public static List<Channel> getStoredChannelList() {
        return list;
    }
}
