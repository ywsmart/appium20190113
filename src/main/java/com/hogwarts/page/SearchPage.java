package com.hogwarts.page;

import com.hogwarts.driver.Driver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/**
 * Function：
 *
 * @author YangWang
 * @date 2019-01-13
 * Created by YangWang on 2019-01-13 16:53.
 */
public class SearchPage extends BasePage {
    public SearchPage search(String keyword) {
        find(By.className("android.widget.EditText")).sendKeys(keyword);
        return this;
    }

    public MainPage cancel() {
        find(By.id("action_close")).click();
        return new MainPage();
    }

    public ArrayList<String> getAll() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (WebElement e : Driver.getCurrentDriver().findElements(By.id("stockName"))) {
            arrayList.add(e.getText());
        }
        return arrayList;
    }

    public SearchPage getByStock() {
        return this;
    }

    public ArrayList<String> addSelected() {
        ArrayList<String> arrayList = new ArrayList<>();
        AndroidElement select = (AndroidElement) find(By.xpath("//*[contain(@resource-id,'follow') and contains(@resource-id,'_btn')]"));
        arrayList.add(select.getAttribute("resourceId"));
        select.click();
        AndroidElement select2 = (AndroidElement) find(By.xpath("//*[contain(@resource-id,'follow') and contains(@resource-id,'_btn')]"));
        arrayList.add(select2.getAttribute("resourceId"));
        return arrayList;
    }

    public SearchPage removeSelected() {
        return this;
    }
}
