package com.ttm.airbus.dal.mapper;

import com.ttm.airbus.dal.model.Role;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liguoqing on 2016/9/22.
 */
public interface RoleMapper extends BaseMapper<Role>{

    public List<Role> findByUserId(Serializable userId);

    public List<Role> findAll();

}
