package com.hogwarts;

import com.hogwarts.page.MainPage;
import com.hogwarts.page.ZixuanPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;

/**
 * Function：自选测试
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
    void A添加自选A(String keyword, String name) {
        zixuanPage.addZixuan(keyword);
        ArrayList<String> arrayList = zixuanPage.cancel().getAll();
        assertThat(arrayList, hasItems(name));
    }

    @ParameterizedTest
    @CsvSource({
            "pdd, 拼多多",
            "alibaba, 阿里巴巴",
            "sogo, 搜狗"
    })
    void B删除自选B(String name) {
        ArrayList<String> arrayList = zixuanPage.delZixuan(name).back().getAll();
        assertThat(arrayList, hasItems(name));
    }
}
