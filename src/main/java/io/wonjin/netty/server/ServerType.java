package io.wonjin.netty.server;

public enum ServerType {
    ASYNC_SERVER("async"),
    SYNC_SERVER("sync");

    private final String serverType;

    ServerType(String serverType) {
        this.serverType = serverType;
    }
}
