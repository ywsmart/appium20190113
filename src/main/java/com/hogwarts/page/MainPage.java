package com.hogwarts.page;

import com.hogwarts.driver.Driver;
import org.openqa.selenium.By;

/**
 * Function：主页
 *
 * @author YangWang
 * @date 2019-01-13
 * Created by YangWang on 2019-01-13 14:59.
 */
public class MainPage extends BasePage {
    By profile = By.id("user_profile_icon");

    public static MainPage start() {
        Driver.start();
        return new MainPage();
    }

    public ProfilePage gotoProfile() {
        Driver.getCurrentDriver().findElement(profile).click();
        return new ProfilePage();
    }

    public SearchPage gotoSearch() {
        find(By.id("home_search")).click();
        return new SearchPage();
    }

    public ZixuanPage gotoZixuan() {
        Driver.getCurrentDriver().findElements(By.id("tab_name")).get(1).click();
        return new ZixuanPage();
    }
}
