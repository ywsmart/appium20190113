package com.hogwarts;

import com.hogwarts.page.LoginPage;
import com.hogwarts.page.MainPage;
import com.hogwarts.page.ProfilePage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Function：
 *
 * @author YangWang
 * @date 2019-01-13
 * Created by YangWang on 2019-01-13 14:50.
 */
public class LoginTest {
    static MainPage mainPage;
    static ProfilePage profilePage;
    @BeforeAll
    static void beforeAll(){
        mainPage=MainPage.start();
        profilePage=mainPage.gotoProfile();
    }

    @ParameterizedTest
    @CsvSource({
            "15600534760, xxxxxxxx, 用户名或密码错误",
            "1560053476, xxxxxxxx, 手机号码填写错误"
    })
    void 密码登录(String username, String password, String expection) {
        LoginPage loginPage = profilePage.gotoLogin();
        loginPage.passwordFail(username, password);
        assertThat(loginPage.getMessage(), equalTo(expection));
        profilePage=loginPage.gotoProfile();
    }

}
