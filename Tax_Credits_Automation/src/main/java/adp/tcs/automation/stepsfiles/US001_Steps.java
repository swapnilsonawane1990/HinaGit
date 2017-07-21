package adp.tcs.automation.stepsfiles;

import adp.tcs.automation.pages.EditPersonalInformation;
import adp.tcs.automation.pages.Login;
import adp.tcs.automation.pages.SearchSSNthroughHub;
import adp.tcs.automation.utilities.*;
import org.jbehave.core.annotations.*;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


/**
 * Created by bhutesac on 4/1/2016.
 */
public class US001_Steps extends BaseTempletSteps {

    Login loginPage = new Login();
    SearchSSNthroughHub searchSSNumber = new SearchSSNthroughHub();
    EditPersonalInformation editpersonalinfo = new EditPersonalInformation();
    CustomizedAssertion assertion = new CustomizedAssertion();
    TakeScreenshotAction screenshot = new TakeScreenshotAction();
    SearchSSNthroughHub searchSSN = new SearchSSNthroughHub();
    UserAction userAction = new UserAction();
    ReadingxlsFile dataFromxls = new ReadingxlsFile();
    public String inputSSN ="";
    public ReadingxlsFile xlsxAccess = new ReadingxlsFile();




    @Given("I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button Only")
    public void searchSSNforEdit() throws Exception {
        try{
            inputSSN = dataFromxls.readHashSeparatedValueFromXlsx("V2").toString();
            Thread.sleep(2000);
            searchSSNumber.search_SSN_Home_Menu().click();
            Thread.sleep(2000);
            searchSSN.Search_SSN_The_InputBox().clear();
            searchSSN.Search_SSN_The_InputBox().sendKeys(inputSSN);
            searchSSN.Search_SSN_The_SearchButton().click();
            Thread.sleep(2000);
        }catch(Exception e)
        {
            screenshot.getScreenshot("searchSSN");
            e.printStackTrace();
        }

    }

    @When("I Double Click on SSN and Edit the Personal Information related to search SSN")
    public void editPersonalInformation(@Named("firstName") String firstName,@Named("middleName") String middleName,@Named("lastName") String lastName,
                                        @Named("updatedSSN") String updatedSSN,@Named("phoneNumber") String phoneNumber,@Named("addressLine") String addressLine,
                                        @Named("cityName") String cityName,@Named("countryName") String countryName,@Named("zipCode") String zipCode,@Named("companyName") String companyName,
                                        @Named("unit") String unit,@Named("emailAddress") String emailAddress,@Named("startingWages") String startingWages,
                                        @Named("stateName") String stateName,@Named("position") String position,@Named("startDateInput") String startDateInput,
                                        @Named("hireDateInput") String hireDateInput) throws Exception {
        try {
            inputSSN = dataFromxls.readHashSeparatedValueFromXlsx("V2").toString();
            editpersonalinfo.editPersonalDetails(firstName,middleName, lastName,
                    inputSSN,  phoneNumber, addressLine,
                     cityName,  countryName, zipCode,companyName,
                    unit, emailAddress, startingWages ,stateName,
                    position, startDateInput, hireDateInput);


        }catch(Exception e)
        {
            screenshot.getScreenshot("editPersonalInformation");
            e.printStackTrace();
        }
    }


    @Then("The Newly Edited Information Should be Displayed")
    public void verifyEditedInformation(@Named("firstName") String firstName,@Named("middleName") String middleName,@Named("lastName") String lastName,
                                        @Named("updatedSSN") String updatedSSN,@Named("phoneNumber") String phoneNumber,@Named("addressLine") String addressLine,
                                        @Named("cityName") String cityName,@Named("countryName") String countryName,@Named("zipCode") String zipCode,@Named("companyName") String companyName,
                                        @Named("unit") String unit,@Named("emailAddress") String emailAddress,@Named("startingWages") String startingWages,
                                        @Named("stateName") String stateName,@Named("position") String position) throws Exception {
       // try {
            boolean flag = true;
        inputSSN = dataFromxls.readHashSeparatedValueFromXlsx("V2").toString();
            String actualString = editpersonalinfo.edit_Save_Successfully_Msg().getText();
           String firstNameActual =  editpersonalinfo.edit_First_Name_TextBox().getAttribute("value");
           String midNameActual =  editpersonalinfo.edit_Middle_Name_TextBox().getAttribute("value");
            String lastNameActual =  editpersonalinfo.edit_Last_Name_TextBox().getAttribute("value");
            String ssnNumberActual = editpersonalinfo.edit_Personal_SSN_Number_TextBox().getAttribute("value");
            String phoneNumActual = editpersonalinfo.edit_Phone_Number_Box().getAttribute("value");
            String addressLineActual = editpersonalinfo.edit_Address_Line_TextBox().getAttribute("value");
            String cityActual = editpersonalinfo.edit_City_TextBox().getAttribute("value");
            String emailActual =  editpersonalinfo. edit_Email_Address_TextBox().getAttribute("value");
            String countryActual = editpersonalinfo.edit_Country_TextBox().getAttribute("value");
            String zipCodeNameActual = editpersonalinfo.edit_Zip_code_TextBox().getAttribute("value");
            String companyActual = editpersonalinfo.edit_Company_Name_TextBox().getAttribute("value");
            String wagesActual = editpersonalinfo.edit_Starting_Wages_TextBox().getAttribute("value");
            String stateActual = editpersonalinfo.edit_Position_Employee_State_Text().getAttribute("value");
            String jobTitleActual = editpersonalinfo.edit_Position_Employee_Job_Title_Text().getAttribute("value");

            if(actualString.contains("Employee details updated successfully") && midNameActual.equals(middleName) && lastNameActual.equals(lastName)
                    && firstNameActual.equals(firstName)&& ssnNumberActual.equals(inputSSN)&& phoneNumActual.equals(phoneNumber)
                    && addressLineActual.equals(addressLine)&& cityActual.equals(cityName)&& emailActual.equals(emailAddress)
                    && countryActual.equals(countryName)&& zipCodeNameActual.equals(zipCode)&& companyActual.equals(companyName)
                    && wagesActual.equals(startingWages) && stateActual.equals(stateName) && jobTitleActual.equals(position))
            {
                flag = true;

            }
        editpersonalinfo.edit_Back_Button().click();
        Thread.sleep(2000);
        searchSSNumber.search_SSN_Home_Menu().click();
        Thread.sleep(2000);
            assertion.verifyTrue(flag ,"verifyEditedInformation");

          //  Assert.assertTrue("Expected value for flag is" + flag + "Actual is True",flag);
       // }catch(Exception e)
       // {
         //   screenshot.getScreenshot("verifyEditedInformation");
         //   e.printStackTrace();
      //  }
    }

    @Given("I log in as the Admin user")
    public void adminLogin()
    {
        System.out.println("User on Search SSN page");
    }

    @Then("Reset and Export Button should be displayed")
    public void verifyButtononSearchSSN() throws Exception { boolean flag = false;
        System.out.println("after search page");
        Thread.sleep(3000);
        WebElement resetButton = searchSSNumber.Search_SSN_Reset_Button();
        WebElement exportButton = searchSSNumber.Search_SSN_Export_To_Excel_Button();
        if(resetButton.isDisplayed() && exportButton.isDisplayed())
        {
            flag= true;
        }
        assertion.verifyTrue(flag ,"verifyButtononSearchSSN");
    }

    @When("I Click on Reset Button")
    public void clickonResetButton() throws Exception {
        try{
            Thread.sleep(2000);
            searchSSNumber.search_SSN_Home_Menu().click();
            Thread.sleep(2000);
            searchSSNumber.Search_SSN_Reset_Button().click();
            Thread.sleep(2000);
        }catch(Exception e)
        {
            screenshot.getScreenshot("searchSSN");
            e.printStackTrace();
        }
    }

    @Then("Reset should be performed for Search Result and fields")
    public void verifyReset() throws Exception
    { boolean flag = false;
        WebElement afterReset = searchSSNumber.Search_SSN_Reset_Check();
        if(afterReset.isDisplayed())
        {
            flag= true;
        }

        assertion.verifyTrue(flag ,"verifyReset");
    }

    @Then("Click On the Back Button, Edit Button Should be displayed")
    public void verifyBackButton() throws Exception
    { boolean flag = false;
        editpersonalinfo.edit_Back_Button().click();
        Thread.sleep(2000);
        WebElement editButton = editpersonalinfo.edit_Personal_Info_Button();
        Thread.sleep(2000);
        if(editButton.isDisplayed())
        {
            flag= true;
        }
        assertion.verifyTrue(flag ,"verifyBackButton");
    }

    /*@BeforeStories
    public void setUpBrowser() throws Exception
    {
        DriverUtilitiesHub driverutil = new DriverUtilitiesHub();
        System.out.println("Testing Started");

        // driver.test();

        ExcelReaderWriter excelReaderWriter= new ExcelReaderWriter();
        HashMap<String, String> excelData = excelReaderWriter.readxlsxFileDataAsPerCell("TestData-FIT","WebIn_TG_Eligible1");
        setExcelData(excelData);
        //  webInWOTCScreening.createWOTCScreening();
        //  webInWOTCScreening.driverClose();
        String browser = (PropertiesUtilities.loadKeyValue("browserType"));
        String appurl = PropertiesUtilities.loadKeyValue("applicationUrl");
        setDriver(driverutil.setBrowser(browser));
        //implesit time for find WebElement
        getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        getDriver().manage().deleteAllCookies();
        Thread.sleep(2000);
        getDriver().manage().window().maximize();
        Thread.sleep(2000);
        getDriver().get(appurl);
        Thread.sleep(2000);
        //Delete Old Reports and Screenshot Before Execution
        DeleteFilesAction.deleteScreenShot(screenShotPath);
        DeleteFilesAction.deleteScreenShot(jbehaveReportPath);
        DeleteFilesAction.deleteScreenShot(jbehaveReport);

    }

    @AfterStories
    public void exitApp()
    {
        getDriver().close();
        getDriver().quit();
    }*/

}
