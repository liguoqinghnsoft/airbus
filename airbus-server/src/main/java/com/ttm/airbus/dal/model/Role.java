package com.ttm.airbus.dal.model;

/**
 * Created by liguoqing on 2016/9/14.
 */
public class Role extends BaseModel{

    private String name; //角色名称


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                '}';
    }
}
