package com.hogwarts;

import com.hogwarts.page.MainPage;
import com.hogwarts.page.SearchPage;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

/**
 * Function：
 *
 * @author YangWang
 * @date 2019-01-13
 * Created by YangWang on 2019-01-13 17:13.
 */
public class SearchTest {
    static MainPage mainPage;
    static SearchPage searchPage;

    @BeforeAll
    static void beforeAll() {
        mainPage = MainPage.start();
        searchPage = mainPage.gotoSearch();
    }

    @ParameterizedTest
    @CsvSource({
            "pdd, 拼多多",
            "alibaba, 阿里巴巴",
            "sogo, 搜狗"
    })
    void 搜索测试(String keyword, String name) {
        String content = searchPage.search(keyword).getAll().get(0);
        assertThat(content, equalTo(name));
    }

    @Test
    void 选择() {
        ArrayList<String> arrayList = searchPage.search("mi").addSelected();
        assertThat(arrayList, hasItems("com.xueqiu.android:id/followed_btn", "com.xueqiu.android:id/follow_btn"));
    }
}
