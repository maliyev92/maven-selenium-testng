package testngBasics.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {

    @Test
    public void verifyDbRecordsMatchingUiRecords(){

        /* Selenium Automation that does:
        * Navigates to OrangeHRM
        * Logs In with valid creds
        * Click on PIM tab
        * Click on Employee SubTab
        * In search employee by id enter : 14031
        * Then retrieve all the records from UI
        * */

        /* After we retrieve the data from UI */
        String uiFirstName = "Omar";
        String uiLastName = "Ramo";
        String uiJobTitle = "SDET";
        String uiEmploymentStatus = "Full Time";
        String uiSubUnit = "Distributed";
        String uiSupervisor = "Yoll Academy";

        /* Automate the sql query retrieval with jdbc api */
        String dbFirstName = "Omar";
        String dbLastName = "Ramo";
        String dbJobTitle = "SDET";
        String dbEmploymentStatus = "Full Time";
        String dbSubUnit = "Distributed";
        String dbSupervisor = "Yoll Academy";

        Assert.assertEquals(uiFirstName, dbFirstName, "First Name verification failed!");
        Assert.assertEquals(uiLastName, dbLastName, "Last Name verification failed!");
        Assert.assertEquals(uiJobTitle, dbJobTitle, "Job Title verification failed!");
        Assert.assertEquals(uiEmploymentStatus, dbEmploymentStatus, "Employment Status verification failed!");
        Assert.assertEquals(uiSubUnit, dbSubUnit, "Sub Unit verification failed!");
        Assert.assertEquals(uiSupervisor, dbSupervisor, "Supervisor verification failed!");

    }

    @Test
    public void verifyDbRecordsMatchingUiRecordWithSoftAssert(){
        /*
         * Assert (Hard Assert) it fails the test case immediately when an assertion throws you an exceptions
         * Sometimes, when we have long flow or multiple data points we need our assertions to run all at once regardless if failed or not
         * Here we can use SoftAssert
         * Assert vs SoftAssert
         * - Assert - fails the test immediately
         * - SoftAssert - allows to execute all other subsequent code even if the assertion fails
         * - Assert - has static methods and we call them by class name
         * - SoftAssert - has non static methods and we will need to create object to be able to call the methods
         *
         * Note: all the methods from Assert class will be the same in SoftAssert
         * */

        /* After we retrieve the data from UI */
        String uiFirstName = "Omar";
        String uiLastName = "Ramo";
        String uiJobTitle = "SDET";
        String uiEmploymentStatus = "Full Time";
        String uiSubUnit = "Distributed";
        String uiSupervisor = "Yoll Academy";

        /* Automate the sql query retrieval with jdbc api */
        String dbFirstName = "Omar";
        String dbLastName = "Ramo";
        String dbJobTitle = "SDET";
        String dbEmploymentStatus = "Full Time";
        String dbSubUnit = "Distributed";
        String dbSupervisor = "Yoll Academy";

        // Create an object of SoftAssert to be able to use those methods
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(uiFirstName, dbFirstName, "First Name verification failed!");
        softAssert.assertEquals(uiLastName, dbLastName, "Last Name verification failed!");
        softAssert.assertEquals(uiJobTitle, dbJobTitle, "Job Title verification failed!");
        softAssert.assertEquals(uiEmploymentStatus, dbEmploymentStatus, "Employment Status verification failed!");
        softAssert.assertEquals(uiSubUnit, dbSubUnit, "Sub Unit verification failed!");
        softAssert.assertEquals(uiSupervisor, dbSupervisor, "Supervisor verification failed!");

        // Inorder to activate the methods and get the proper result we will need to use assertAll() once all assertions are completed.
        softAssert.assertAll("Soft assertions completed!");

    }

}
