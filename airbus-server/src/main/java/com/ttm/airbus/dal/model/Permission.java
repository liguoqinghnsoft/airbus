package com.ttm.airbus.dal.model;

/**
 * Created by liguoqing on 2016/9/14.
 */
public class Permission extends BaseModel{

    private String code; //权限代码
    private String desc; //权限描述

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
