package com.ttm.airbus.dal.model;

/**
 * Created by liguoqing on 2016/9/18.
 */
public class RolePermission extends BaseModel{

    private Long roleId; //角色标识
    private Long permissionId; //权限标识

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
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
