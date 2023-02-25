package io.wonjin.netty.server;

import java.util.Arrays;

public enum ServerType {
    ASYNC_SERVER("async"),
    SYNC_SERVER("sync");

    private final String serverTypeName;

    ServerType(String serverTypeName) {
        this.serverTypeName = serverTypeName;
    }

    public static ServerType of(String serverTypeName) {
        return Arrays.stream(values()).filter(serverType -> serverType.serverTypeName.equals(serverTypeName)).findAny().orElseThrow(() -> new IllegalArgumentException());
    }
}
