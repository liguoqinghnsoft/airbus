package com.ttm.airbus.dal.model;

/**
 * Created by liguoqing on 2016/9/14.
 */
public class UserRole extends BaseModel{

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    private Long userId; //用户标识
    private Long roleId; //角色标识

    @Override
    public String toString() {
        return "UserRole{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
