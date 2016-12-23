package com.ttm.airbus.dal.mapper;

import com.ttm.airbus.dal.model.Permission;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liguoqing on 2016/9/22.
 */
public interface PermissionMapper extends BaseMapper<Permission>{

    public List<Permission> findByRoleId(Serializable roleId);

    public List<Permission> findByUserId(Serializable userId);

}
