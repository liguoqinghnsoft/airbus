package com.ttm.airbus.dal.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by liguoqing on 2016/9/13.
 */
public class BaseModel implements Serializable{

    private static final long serialVersionUID = -7399696040766075020L;

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    private Long pkId;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Date createTime;

    private Date updateTime;

    private Boolean isDelete;

    @Override
    public String toString() {
        return "BaseModel{" +
                "pkId=" + pkId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                '}';
    }
}
