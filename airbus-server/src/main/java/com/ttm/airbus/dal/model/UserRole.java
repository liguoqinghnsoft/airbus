package com.ttm.airbus.dal.model;

/**
 * Created by liguoqing on 2016/9/14.
 */
public class UserRole extends BaseModel{

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    private long userId; //用户标识
    private long roleId; //角色标识

    @Override
    public String toString() {
        return "UserRole{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
