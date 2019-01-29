package com.hogwarts.page;

import com.hogwarts.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.util.ArrayList;

/**
 * Function：自选页
 *
 * @author YangWang
 * @date 2019-01-18
 * Created by YangWang on 2019-01-18 0:18.
 */
public class ZixuanPage extends BasePage{
    // 添加自选
    public ZixuanPage addZixuan(String keyword){

        // 点击搜索框，输入关键字
        find(By.id("action_create_cube")).sendKeys(keyword);
        Driver.getCurrentDriver().findElements(By.id("add_attention")).get(0).click();
        return new ZixuanPage();
    }
    // 删除自选
    public ZixuanPage delZixuan(String name){
        TouchActions action = new TouchActions(Driver.getCurrentDriver());
        action.longPress(find(text(name)));
        action.perform();
        find(text("删除")).click();
        return new ZixuanPage();
    }

    public ArrayList<String> getAll() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (WebElement e : Driver.getCurrentDriver().findElements(By.id("portfolio_stockName"))) {
            arrayList.add(e.getText());
        }
        return arrayList;
    }
}
