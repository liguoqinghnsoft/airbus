package com.ttm.airbus.dal.model;

/**
 * Created by liguoqing on 2016/12/23.
 */
public class UserPermission extends BaseModel{

    private Long userId; //用户标识
    private Long permissionId; //权限标识

    @Override
    public String toString() {
        return "UserPermission{" +
                "userId=" + userId +
                ", permissionId=" + permissionId +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
