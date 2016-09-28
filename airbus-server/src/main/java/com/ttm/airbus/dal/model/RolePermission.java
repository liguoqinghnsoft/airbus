package com.ttm.airbus.dal.model;

/**
 * Created by liguoqing on 2016/9/18.
 */
public class RolePermission extends BaseModel{

    private long roleId; //角色标识
    private long permissionId; //权限标识

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(long permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "roleId=" + roleId +
                ", permissionId=" + permissionId +
                '}';
    }
}
