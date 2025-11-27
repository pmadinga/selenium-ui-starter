package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage {
    WebDriver driver;

    //Initiate driver
    public TextBoxPage(WebDriver webDriver){
        this.driver = webDriver;
    }

    //Start driver session
    public void openSite(){
        driver.get("https://demoqa.com/text-box");
    }

    //Element definition
    By userName = By.id("userName");
    By userEmail = By.id("userEmail");
    By userCurrentAddress = By.id("currentAddress");
    By userPermanentAddress = By.id("permanentAddress");
    By submitBtn = By.id("submit");

    //Element Interaction
    public void enterUserName(String username){
        WebElement usernameTextBox = driver.findElement(userName);
        usernameTextBox.sendKeys(username);
    }
    public void enterUserEmail(String email){
        driver.findElement(userEmail).sendKeys(email);
    }
    public void enterCurrentAddress(String currentAddress){
        driver.findElement(userCurrentAddress).sendKeys(currentAddress);
    }
    public void enterPermanentAddress(String permanentAddress){
        driver.findElement(userPermanentAddress).sendKeys(permanentAddress);
    }
    public void clickSubmitBtn(){
        WebElement btn = driver.findElement(submitBtn);
        if(btn.isDisplayed() && btn.isEnabled()){
            btn.click();

        }else{
            System.out.println("Unable to click Submit");
        }

    }

}
