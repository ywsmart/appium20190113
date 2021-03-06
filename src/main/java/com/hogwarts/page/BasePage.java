package com.hogwarts.page;

import com.hogwarts.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Function：基页
 *
 * @author YangWang
 * @date 2019-01-13
 * Created by YangWang on 2019-01-13 15:38.
 */
public class BasePage {
    static WebElement find(By locator){
        WebDriverWait webDriverWait = new WebDriverWait(Driver.getCurrentDriver(),10);
        // 此处后面需要改循环
        try {
            return webDriverWait.until(ExpectedConditions.elementToBeClickable(Driver.getCurrentDriver().findElement(locator)));
        }catch (Exception e){
            Driver.getCurrentDriver().findElement(text("下次再说")).click();
            return Driver.getCurrentDriver().findElement(locator);
        }
    }

    static By locate(String locator){
        if (locator.matches("/.*")){
            return By.xpath(locator);
        }else {
            return By.id(locator);
        }
    }
    static By text(String contents){
        return By.xpath("//*[@text='"+contents+"']");
    }
}
