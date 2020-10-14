package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    //@FindAll({
    //        @FindBy(id="pretendedInput"),
    //        @FindBy(xpath="_username")
    //})
    //gives us option to use multiple locators, if it finds at least one of the webelements then it will return it
    //public WebElement username2;

    //@FindBys({
    //        @FindBy(id="pretendedInput"),
    //        @FindBy(xpath="_username")
    //})
    //if all locators matching with the webelements then it will return it.AND logıc is apllied here.
    //public WebElement username2;

    //same with driver.findElement(By.id("prependedInput"))
    @FindBy(name = "_username")
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginBtn;

    public void login(String usernameStr, String passwordStr){
        usernameInput.sendKeys(usernameStr);
        passwordInput.sendKeys(passwordStr);
        loginBtn.click();
    }




}
