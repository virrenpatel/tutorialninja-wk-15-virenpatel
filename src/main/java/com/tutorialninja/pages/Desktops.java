package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Desktops extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyLink;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Show All Desktops')]")
    WebElement clickOnShowAllDeskTop;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortByNameZtoA;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement clickOnHpLp3065;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement verifyTextHplp3065;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement clickShoppingCart;

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement verifyShoppingCart;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement verifyHPlp3065;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement verifyDate;

    @CacheLookup
    @FindBy(xpath = "//li[contains(text(),'Product Code: Product 21')]")
    WebElement verifyModel;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement verifyTotal;

    public void clickOnCurrencyLink() {
        Reporter.log("clickOnCurrencyLink" + currencyLink.toString());
        clickOnElement(currencyLink);
        CustomListeners.test.log(Status.PASS,"clickOnCurrencyLink");
    }

    public void clickOnAllDesktop() {
        Reporter.log("clickOnAllDesktop" + clickOnShowAllDeskTop.toString());
        clickOnElement(clickOnShowAllDeskTop);
        CustomListeners.test.log(Status.PASS,"clickOnAllDesktop");
    }

    public void SortByNameZtoAFromDropdown() {
        Reporter.log("SortByNameZtoAFromDropdown" + sortByNameZtoA.toString());
        sendTextToElement(sortByNameZtoA, "Name (Z - A)");
        CustomListeners.test.log(Status.PASS,"SortByNameZtoAFromDropdown");
    }

    public void clickOnHPlp3065() {
        Reporter.log("clickOnHPlp3065" + clickOnHpLp3065.toString());
        clickOnElement(clickOnHpLp3065);
        CustomListeners.test.log(Status.PASS,"clickOnHPlp3065");
    }

    public void clickOnAdToCart() {
        Reporter.log("clickOnAdToCart" + addToCart.toString());
        clickOnElement(addToCart);
        CustomListeners.test.log(Status.PASS,"clickOnAdToCart");
    }

    public String getVerifyTextHp() {
        Reporter.log("getVerifyTextHp" + verifyTextHplp3065.toString());
        CustomListeners.test.log(Status.PASS,"getVerifyTextHp");
        return getTextFromElement(verifyTextHplp3065);

    }

    //SelectDate
    public void selectDeliveryDate() {
        //select delivery date
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        //desktops.selectDeliveryDate();
        //clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnShoppingCart() {
        Reporter.log("clickOnShoppingCart" + clickShoppingCart.toString());
        clickOnElement(clickShoppingCart);
        CustomListeners.test.log(Status.PASS,"clickOnShoppingCart");
    }

    public String getVerifyShoppingCart() {
        Reporter.log("getVerifyShoppingCart" + verifyShoppingCart.toString());
        CustomListeners.test.log(Status.PASS,"getVerifyShoppingCart");
        return getTextFromElement(verifyShoppingCart);
    }

    public String getVerifyProductName() {
        Reporter.log("getVerifyProductName" + verifyHPlp3065.toString());
        CustomListeners.test.log(Status.PASS,"getVerifyProductName");
        return getTextFromElement(verifyHPlp3065);
    }

    public String getVerifyDeliveryDate() {
        Reporter.log("getVerifyDeliveryDate" + verifyDate.toString());
        CustomListeners.test.log(Status.PASS,"getVerifyDeliveryDate");
        return getTextFromElement(verifyDate);
    }

    public String getVerifyModel() {
        Reporter.log("getVerifyModel" + verifyModel.toString());
        CustomListeners.test.log(Status.PASS,"getVerifyModel");
        return getTextFromElement(verifyModel);
    }

    public String getVerifyTotal() {
        Reporter.log("getVerifyTotal" + verifyTotal.toString());
        CustomListeners.test.log(Status.PASS,"getVerifyTotal");
        return getTextFromElement(verifyTotal);
    }

    public void verifyZtoAFromDropDroDown() {
        // Get all the products name and stored into array list
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        // Select sort by Name Z - A
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);

    }
}