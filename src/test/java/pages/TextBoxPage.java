package pages;

import org.openqa.selenium.*;

public class TextBoxPage {
    WebDriver driver;

    //Initiate driver
    public TextBoxPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    //Start driver session
    public void openSite() {
        driver.get("https://demoqa.com/text-box");
    }

    //Element definition
    By userName = By.id("userName");
    By userEmail = By.id("userEmail");
    By userCurrentAddress = By.id("currentAddress");
    By userPermanentAddress = By.id("permanentAddress");
    By submitBtn = By.id("submit");
    By nameAssertion = By.id("name");

    //Element Interaction
    public void enterUserName(String username) {
        WebElement usernameTextBox = driver.findElement(userName);
        usernameTextBox.sendKeys(username);
    }

    public void enterUserEmail(String email) {
        driver.findElement(userEmail).sendKeys(email);
    }

    public void enterCurrentAddress(String currentAddress) {
        driver.findElement(userCurrentAddress).sendKeys(currentAddress);
    }

    public void enterPermanentAddress(String permanentAddress) {
        driver.findElement(userPermanentAddress).sendKeys(permanentAddress);
    }

    public void clickSubmitBtn() {
        WebElement btn = driver.findElement(submitBtn);
        int retryCounter = 0;
        boolean isButtonClicked = false;

        while (!isButtonClicked){
            try {
                if (btn.isDisplayed() && btn.isEnabled()){
                    btn.click();
                    isButtonClicked = true;
                    continue;
                }
            } catch (ElementClickInterceptedException e) {
                System.out.println("Unable to click Submit, Allowing exception to happen then trying to scroll");
                scrollToElement(btn);
                btn.click();
                isButtonClicked = true;
                continue;
            }
            retryCounter++;

        }

    }

    public String getNameAssertion(){
        String nameText = driver.findElement(nameAssertion).getText();
        System.out.println(nameText);
        return nameText;
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
