package io.wonjin.netty.server.async.domain;

import lombok.Getter;

@Getter
public class DataBody {

    private String item1;
    private String item2;
    private String item3;

    @Override
    public String toString() {
        return item1 + item2 + item3;
    }
}
