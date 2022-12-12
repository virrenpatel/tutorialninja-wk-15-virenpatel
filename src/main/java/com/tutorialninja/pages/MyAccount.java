package com.tutorialninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialninja.customlisteners.CustomListeners;
import com.tutorialninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class MyAccount extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccount;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement verifyRegister;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement verifyReturning;

    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement enterEmail;

    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement enterPhone;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement enterPass;

    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPass;

    @CacheLookup
    @FindBy(xpath = "//input[@name='newsletter']")
    WebElement newsLetter;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicy;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement clickOnContinue;

    @CacheLookup
    @FindBy(xpath = "//div[@id ='content']//h1")
    WebElement verifyMessage;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountTab;


    public void clickOnMyAccount() {
        Reporter.log("clickOnMyAccount" + myAccount.toString());
        clickOnElement(myAccount);
        CustomListeners.test.log(Status.PASS,"clickOnMyAccount");
    }

    public String getVerifyRegister() {
        Reporter.log("getVerifyRegister" + verifyRegister.toString());
        CustomListeners.test.log(Status.PASS,"getVerifyRegister");
        return getTextFromElement(verifyRegister);

    }

    public String getVerifyReturning() {
        Reporter.log("getVerifyReturning" + verifyReturning.toString());
        CustomListeners.test.log(Status.PASS,"getVerifyReturning");
        return getTextFromElement(verifyReturning);

    }

    public void enterFirstName(String name) {
        Reporter.log("enterFirstName" + name +firstName.toString());
        sendTextToElement(firstName, name);
        CustomListeners.test.log(Status.PASS,"enterFirstName"+name);
    }

    public void enterLastName(String lastname) {
        Reporter.log("enterLastName" + lastname +lastname.toString());
        sendTextToElement(lastName, lastname);
        CustomListeners.test.log(Status.PASS,"enterLastName"+lastname);
    }

    public void enterEmailAdd(String email) {
        Reporter.log("enterEmailAdd" + email +enterEmail.toString());
        sendTextToElement(enterEmail, email);
        CustomListeners.test.log(Status.PASS,"enterEmailAdd"+email);
    }

    public void enterPhone(String phone) {
        Reporter.log("enterPhone" + enterPhone.toString());
        sendTextToElement(enterPhone, phone);
        CustomListeners.test.log(Status.PASS,"enterPhone"+phone);
    }

    public void enterPassword(String password) {
        Reporter.log("enterPassword" + enterPass.toString());
        sendTextToElement(enterPass, password);
        CustomListeners.test.log(Status.PASS,"enterPassword");
    }

    public void enterConfirmPass(String confirmPassword) {
        Reporter.log("enterConfirmPass" +confirmPass.toString());
        sendTextToElement(confirmPass, confirmPassword);
        CustomListeners.test.log(Status.PASS,"enterConfirmPass");
    }

    public void clickYesOnNewsLetter() {
        Reporter.log("clickYesOnNewsLetter" +newsLetter.toString());
        clickOnElement(newsLetter);
        CustomListeners.test.log(Status.PASS,"clickYesOnNewsLetter");
    }

    public void clickOnPrivacy() {
        Reporter.log("clickOnPrivacy" + privacyPolicy.toString());
        clickOnElement(privacyPolicy);
        CustomListeners.test.log(Status.PASS,"clickOnPrivacy");
    }

    public void clickFinalContinue() {
        Reporter.log("clickFinalContinue" + clickOnContinue.toString());
        clickOnElement(clickOnContinue);
        CustomListeners.test.log(Status.PASS,"clickFinalContinue");
    }

    public String getVerifyMessage() {
        Reporter.log("getVerifyMessage" + verifyMessage.toString());
        CustomListeners.test.log(Status.PASS,"getVerifyMessage");
        return getTextFromElement(verifyMessage);
    }

    public void clickOnMyAccountTab() {
        Reporter.log("clickOnMyAccountTab" + myAccountTab.toString());
        clickOnElement(myAccountTab);
        CustomListeners.test.log(Status.PASS,"clickOnMyAccountTab");
    }

    public void clickOnContinueTab() {
        Reporter.log("clickOnContinueTab" +continueButton.toString());
        clickOnElement(continueButton);
        CustomListeners.test.log(Status.PASS,"clickOnContinueTab");
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    }
}
