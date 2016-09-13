package com.ttm.airbus.dal.model;

import java.io.Serializable;

/**
 * Created by liguoqing on 2016/9/13.
 */
public class BaseModel implements Serializable{

    private static final long serialVersionUID = -7399696040766075020L;

    public long getPkId() {
        return pkId;
    }

    public void setPkId(long pkId) {
        this.pkId = pkId;
    }

    private long pkId;

}
