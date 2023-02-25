package io.wonjin;

import io.wonjin.netty.server.ServerType;
import io.wonjin.netty.server.async.AsyncServer;
import io.wonjin.netty.server.sync.SyncServer;

public class Main {

    private static final int SERVER_TYPE_INDEX = 0;

    public static void main(String[] args) throws Exception {
        args = new String[1];
        args[SERVER_TYPE_INDEX] = "async";

        ServerType serverType = ServerType.of(args[SERVER_TYPE_INDEX]);

        switch (serverType) {
            case ASYNC_SERVER:
                new AsyncServer().run();
                break;

            case SYNC_SERVER:
                new SyncServer().run();
                break;
        }
    }
}