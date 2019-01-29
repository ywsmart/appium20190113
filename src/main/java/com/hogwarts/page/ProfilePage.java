package com.hogwarts.page;

import com.hogwarts.driver.Driver;
import org.openqa.selenium.By;

/**
 * Function：用户页
 *
 * @author YangWang
 * @date 2019-01-13
 * Created by YangWang on 2019-01-13 15:20.
 */
public class ProfilePage {
    By login = By.xpath("//*[@text='点击登录']");

    public void gotoWeixinLogin() {

    }

    public void goto验证码登录() {

    }

    public LoginPage gotoLogin() {
        Driver.getCurrentDriver().findElement(login).click();
        return new LoginPage();
    }
}
