package com.ttm.airbus.dal.mapper;

import com.ttm.airbus.dal.model.User;

import java.io.Serializable;

/**
 * Created by liguoqing on 2016/9/22.
 */
public interface UserMapper extends BaseMapper<User>{

    public User findByUserId(Serializable userId);

    public User login(User user);

}
