package TestRunner;

import Pages.LoginPage;
import Pages.SignupPage;
import Setup.Setup;
import Utils.Utils;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignupTestRunner extends Setup {
    @Test(priority = 1,description = "SignIN")
    public void doSignup() throws InterruptedException, IOException, ParseException {
        driver.get("http://automationpractice.com/");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.linkLogin.click();
        SignupPage signupPage=new SignupPage(driver);
        Utils utils=new Utils();
        String emailUserAcc="testautouser"+utils.generateRandomNumber(1000,9999);
        String email=emailUserAcc+"@test.com";
        String password=utils.generateRandomPassword(8);
        String mobile="175"+utils.generateRandomNumber(1000000,9999999);
        signupPage.doRegistration(email,password,mobile);
        utils.writeUserInfo(email,password);
    }
}
