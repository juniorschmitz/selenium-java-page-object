package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import support.Generator;
import support.Screenshot;
import support.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "UsersLoginData.csv")
public class testLogin {
    private WebDriver mybrowser;
    private String directory_path;

    @Before
    public void setUp(){
        directory_path = System.getProperty("user.dir") + "/reports/" + Generator.dateHourNow() + ".png";
        mybrowser = Web.createChrome();
        mybrowser.get("http://automationpractice.com");
    }

    @Test
    public void testLoginUser(@Param(name="email")String email, @Param(name="password")String password) {
//        The test could be done like this commented way, or the other way under those
//        HomePage homepage = new HomePage(mybrowser);
//        LoginPage loginpage = homepage.clickSignIn();
//        MyAccountPage myaccount = loginpage.login(email, password);
        String myNameAfterLogin = new HomePage(mybrowser)
                .clickSignIn()
                .login(email, password)
                .getMyName();

        Assert.assertEquals("Automacao automatinho", myNameAfterLogin);
    }

    @After
    public void tearDown(){
        Screenshot.take(mybrowser, directory_path);
        mybrowser.quit();
    }
}
