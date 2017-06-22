package com.ttm.airbus.dal;

import com.ttm.airbus.BaseTest;
import com.ttm.airbus.dal.mapper.UserMapper;
import com.ttm.airbus.dal.model.User;
import com.ttm.airbus.utils.PwdEncoder;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;

/**
 * Created by liguoqing on 2017/6/22.
 */
@ActiveProfiles("dev")
public class UserMapperTest extends BaseTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        PwdEncoder encoder = new PwdEncoder("test", "SHA");
        User user = new User();
        user.setUserId("test");
        user.setUserPwd(encoder.encoder("test"));
        user.setSalt("test");
        user.setStatus(true);
        userMapper.insert(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setPkId(1L);
        user.setStatus(false);
        userMapper.update(user);
    }

}
