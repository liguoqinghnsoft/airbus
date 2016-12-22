package com.ttm.airbus.common;

import com.ttm.airbus.AirbusApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by liguoqing on 2016/12/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AirbusApplication.class)
public class YmlTest {

    private static final Logger logger = LoggerFactory.getLogger(YmlTest.class);

    @Resource
    private Environment environment;

    @Test
    public void testEnv() {
        String[] activeProfiles = environment.getActiveProfiles();
        for (String active : activeProfiles) {
            logger.info("YmlTest.testEnv env result {}", active);
        }
    }

}
