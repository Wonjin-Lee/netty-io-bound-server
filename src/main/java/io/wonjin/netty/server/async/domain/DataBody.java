package io.wonjin.netty.server.async.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DataBody {

    private String item1;
    private String item2;
    private String item3;
    private String item4;
    private String item5;
    private String item6;
    private String item7;
    private String item8;

    @Override
    public String toString() {
        return item1 + item2 + item3 + item4 + item5 + item6 + item7 + item8;
    }
}
