package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.RegisterAccountClass;
import testBase.BaseClass;
import utilities.DataProviders;

/*
 * Register Account Tests
 * DDT + Log4j2 Logger + Extent Reports
 */

public class RegisterAccount extends BaseClass {

    RegisterAccountClass rac;

    // ----------------------------
    // TC1 - Mandatory Fields
    // ----------------------------
    @Test(priority=1,
          dataProvider="MandatoryData",
          dataProviderClass=DataProviders.class)
    public void reg_MandatoryFields(String fName,
                                    String lName,
                                    String email,
                                    String phone,
                                    String pwd) {

        test = extent.createTest("TC1 - Register With Mandatory Fields");
        logger.info("========== TC1 Started ==========");

        rac = new RegisterAccountClass(driver);

        rac.primaryBtn();
        logger.info("Clicked on Register link");
        test.info("Clicked on Register link");

        String uniqueEmail =
                System.currentTimeMillis() + email + "@gmail.com";

        rac.mandFields(fName, lName, uniqueEmail, phone, pwd, pwd);
        logger.info("Entered mandatory registration details");
        test.info("Entered mandatory registration details");

        rac.agree();
        logger.info("Accepted Privacy Policy");
        test.info("Accepted Privacy Policy");

        rac.Cont();
        logger.info("Clicked Continue button");
        test.info("Clicked Continue button");

        Assert.assertEquals(rac.acmessage(),
                "Your Account Has Been Created!");

        logger.info("TC1 PASSED - Account Created Successfully");
        test.pass("Account Created Successfully");
    }


    // ----------------------------
    // TC2 - All Fields
    // ----------------------------
    @Test(priority=2, groups = {"smoke"},
          dataProvider="AllFieldsData",
          dataProviderClass=DataProviders.class)
    public void reg_AllFields(String fName,
                              String lName,
                              String email,
                              String phone,
                              String pwd,
                              String newsletter) {

        test = extent.createTest("TC2 - Register With All Fields");
        logger.info("========== TC2 Started ==========");

        rac = new RegisterAccountClass(driver);

        rac.primaryBtn();
        logger.info("Clicked on Register link");
        test.info("Clicked on Register link");

        String uniqueEmail =
                System.currentTimeMillis() + email + "@gmail.com";

        rac.mandFields(fName, lName, uniqueEmail, phone, pwd, pwd);
        logger.info("Entered all registration details");
        test.info("Entered all registration details");

        if(newsletter.equalsIgnoreCase("yes")) {
            rac.newsltr();
            logger.info("Newsletter option selected");
            test.info("Newsletter option selected");
        }

        rac.agree();
        rac.Cont();

        logger.info("Clicked Continue button");
        test.info("Clicked Continue button");

        Assert.assertEquals(rac.acmessage(),
                "Your Account Has Been Created!");

        logger.info("TC2 PASSED - Account Created Successfully");
        test.pass("Account Created Successfully");
    }


    // ----------------------------
    // TC3 - No Fields
    // ----------------------------
    @Test(priority=3,
          dataProvider="NegativeData",
          dataProviderClass=DataProviders.class)
    public void reg_NoFields(String expectedWarning) {

        test = extent.createTest("TC3 - Register Without Fields");
        logger.info("========== TC3 Started ==========");

        rac = new RegisterAccountClass(driver);

        rac.primaryBtn();
        logger.info("Clicked on Register link");
        test.info("Clicked on Register link");

        rac.Cont();
        logger.info("Clicked Continue without entering data");
        test.info("Clicked Continue without entering data");

        Assert.assertEquals(rac.warPrivactPolicy(),
                expectedWarning);

        logger.info("TC3 PASSED - Warning Message Displayed");
        test.pass("Warning Message Displayed Successfully");
    }
}
