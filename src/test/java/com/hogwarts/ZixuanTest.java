package com.hogwarts;

import com.hogwarts.page.MainPage;
import com.hogwarts.page.ZixuanPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Function：
 *
 * @author YangWang
 * @date 2019-01-18
 * Created by YangWang on 2019-01-18 1:14.
 */
public class ZixuanTest {
    static MainPage mainPage;
    static ZixuanPage zixuanPage;

    @BeforeAll
    static void beforeAll() {
        mainPage = MainPage.start();
        zixuanPage = mainPage.gotoZixuan();
    }

    @ParameterizedTest
    @CsvSource({
            "pdd, 拼多多",
            "alibaba, 阿里巴巴",
            "sogo, 搜狗"
    })
    void 添加自选(String keyword, String name) {
        String content = zixuanPage.addZixuan(keyword).getAll().get(0);
        assertThat(content, equalTo(name));
    }


    @ParameterizedTest
    @CsvSource({
            "pdd, 拼多多",
            "alibaba, 阿里巴巴",
            "sogo, 搜狗"
    })
    void 删除自选(String name) {
//        ArrayList<String> arrayList =  zixuanPage.delZixuan("").addSelected();
//        assertThat(arrayList, hasItems("com.xueqiu.android:id/followed_btn", "com.xueqiu.android:id/follow_btn"));
    }
}
