package com.hogwarts.driver;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Function：
 *
 * @author YangWang
 * @date 2019-01-20
 * Created by YangWang on 2019-01-20 11:03.
 */
class GlobalConfigTest {
    @Test
    void load() {
        GlobalConfig config= GlobalConfig.load("/data/xueqiu.yaml");
        assertThat(config, not(equalTo(null)));

    }

}