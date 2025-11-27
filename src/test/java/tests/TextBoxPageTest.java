package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxPageTest extends BaseTest {
    @Test
    void userCanSubmitAForm(){
        //Creating an instance of TextBoxPage via constructor
        TextBoxPage textBoxPage = new TextBoxPage(driver);

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.getMessage();
        }

        //Open the web page
        textBoxPage.openSite();

        //Enter username
        textBoxPage.enterUserName("steve");

        //Enter user email
        textBoxPage.enterUserEmail("steve@apple.com");

        //Enter current address
        textBoxPage.enterCurrentAddress("San Fransisco");

        //Enter permanent address
        textBoxPage.enterPermanentAddress("Los Angeles");

        //Click submit Btn
        textBoxPage.clickSubmitBtn();

    }
}
