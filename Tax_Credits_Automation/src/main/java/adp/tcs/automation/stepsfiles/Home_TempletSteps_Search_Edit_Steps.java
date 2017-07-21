package adp.tcs.automation.stepsfiles;

import adp.tcs.automation.locators.EditPersonalInfo;
import adp.tcs.automation.pages.*;
import adp.tcs.automation.utilities.*;
import org.jbehave.core.annotations.*;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by bhutesac on 6/17/2016.
 */
public class Home_TempletSteps_Search_Edit_Steps extends BaseTempletSteps {

    private Login loginPage = new Login();
    private SearchSSNthroughHub searchSSNumber = new SearchSSNthroughHub();
    private EditPersonalInformation editpersonalinfo = new EditPersonalInformation();
    private CustomizedAssertion assertion = new CustomizedAssertion();
    private TakeScreenshotAction screenshot = new TakeScreenshotAction();
    private SearchSSNthroughHub searchSSN = new SearchSSNthroughHub();
    private UserAction userAction = new UserAction();
    private BackOfficActions bcAct = new BackOfficActions();
    private ReadingxlsFile dataFromxls = new ReadingxlsFile();
    private MoreDetails MoreDtls = new MoreDetails();
    private ExtendReport extentReport = new ExtendReport();
    private SearchSSNthroughHub searchSsnhub = new SearchSSNthroughHub();
    private final WndowAction windowAct = new WndowAction();
    private static final DriverUtilities driverutil = new DriverUtilities();
    private static final BaseTempletSteps baseTempletSteps= new BaseTempletSteps();
//    public static VideoRecords videoRecord = new VideoRecords();
    public String inputSSN ="";
    public String expectedSSN;
    public String fromDate;
    public String todate;
    public String hireDt;
    public String workSrtDate;
    public String workEdDate;



    @Given("I Log in to Back Office with correct credential<UserName> <Password>")
    public void backOfficelogin() throws Exception {
        try{
        	//getExcelData().put("SSN", "839990632");
            verifyTest("I Log in to Back Office with correct credential<UserName> <Password>");
            loginPage.backOffLogin(loadPropValues("username"), loadPropValues("password"));
        }catch(Exception e){
            screenshot.getScreenshot("backOfficelogin");
            e.printStackTrace();
        }
    }
    
    @Given("I Log in to Back Office with correct credential for Client User <UserName> <Password>")
    public void backOfficeloginClient() throws Exception {
        try{
            verifyTest("I Log in to Back Office with correct credential for Client User <UserName> <Password>");
            loginPage.backOffLogin(loadPropValues("clientUnserName"), loadPropValues("clientPassword"));
        }catch(Exception e){
            screenshot.getScreenshot("backOfficeloginClient");
            e.printStackTrace();
        }
    }
    
    @Then("I Log out from Back Office and Portal application")
    public void backOfficelogout() throws Exception {
        try{
            verifyTest("I Log out from Back Office and Portal application");
            loginPage.portalBackOffLogout();
        }catch(Exception e){
            screenshot.getScreenshot("PortalBackofficelogout");
            e.printStackTrace();
        }
    }

    @When("I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button")
    public void searchSSN() throws Exception {
        try{
           verifyTest("I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button");
           inputSSN = getExcelData().get("SSN");
          /* inputSSN = "152198309";
           getExcelData().put("SSN", inputSSN);*/
           sleep(2000);
           waitForLoad();
           searchSSNumber.searchSSNnumber(inputSSN);

        }catch(Exception e)
        {
            screenshot.getScreenshot("searchSSN");
            e.printStackTrace();
        }
    }
    
    @When("I Navigate to Hub Page from Portal Application")
    public void navigateToHubPageFromPortal() throws Exception {
        try{
           verifyTest("I Navigate to Hub Page from Portal Application");
           sleep(2000);
           waitForLoad();
           searchSSNumber.navigateBackOffice();
        }catch(Exception e)
        {
            screenshot.getScreenshot("searchSSN");
            e.printStackTrace();
        }
    }
    
    
    @Then("The Search <ExpectedSSN> should be displayed in the result")
    public void verifySSNSearch() throws Exception {
        // try {
        try {
            Thread.sleep(2000);
            inputSSN = getExcelData().get("SSN");
            String actualSSN = "";
            actualSSN = searchSSN.Search_SSN_The_SearchResult().getText();
            String ssnActual = actualSSN.replace("-", "");
            if(inputSSN.contains("]"))
                inputSSN = inputSSN.replace("[", "");
            inputSSN = inputSSN.replace("]", "");
            assertion.verifyText(ssnActual,inputSSN,"001_US123_Search_For_SSN_Number_Stories");
        } catch (Exception e) {
            e.printStackTrace();
            verifyTest("The Search <ExpectedSSN> should be displayed in the result", false);
        }
//        }catch(Exception e)
//        {
//            screenshot.getScreenshot("verifySSNSearch");
//            e.printStackTrace();
//        }
    }

    @Then("The Search <ExpectedSSN> SSN Status correctly should be displyed on Hub")
    public void verifySSNStatus(@Named("Status") String status) throws Exception {
        // try {
        try {
            Thread.sleep(2000);
            inputSSN = getExcelData().get("SSN");
            String statuschkt = editpersonalinfo.home_PAGE_STATUS().getText();
            assertion.verifyText(statuschkt.trim(),status,"The Search <ExpectedSSN> SSN Status correctly should be displyed on Hub");
        } catch (Exception e) {
            e.printStackTrace();
            verifyTest("The Search <ExpectedSSN> SSN Status correctly should be displyed on Hub", false);
        }
    }


@When("Search the Manual Key In Record with SSN")
public void searchSSNManualKeyIn() throws Exception {
    try{       
       // windowAct.switchtoChildWindowReturnParent();
    	windowAct.switchToWindowByTitle("ADP TaxCredits");
        verifyTest("Search the Manual Key In Record with SSN");
        inputSSN = getExcelData().get("SSN");
        sleep(2000);
        editpersonalinfo.home_page_link().click();
        sleep(2000);
        searchSsnhub.Search_SSN_The_InputBox().sendKeys(inputSSN);
        searchSsnhub.Search_SSN_The_SearchButton().click();
         waitForLoad();
    }catch(Exception e){
        screenshot.getScreenshot("searchSSNManualKeyIn");
        e.printStackTrace();
    }
}
    @Given("User Navigate To the Home page")
    public void homePageNavigation() throws Exception {
        try{
            Thread.sleep(2000);
            if(searchSSNumber.search_SSN_Home_Menu().isDisplayed()) {
                searchSSNumber.search_SSN_Home_Menu().click();
            }
            Thread.sleep(2000);
            if(searchSSNumber.Search_SSN_Reset_Button().isEnabled()) {
                try {
                    searchSSNumber.Search_SSN_Reset_Button().click();
                    Thread.sleep(1000);
                }catch(Exception e)
                {System.out.print(e.getStackTrace());}
            }
            if(!searchSSNumber.advance_Search_Client_TextBox().isDisplayed()){
                searchSSNumber.advance_Search_Link().click();
                Thread.sleep(2000);}
        }catch(Exception e)
        {
            screenshot.getScreenshot("homePageNavigation");
            verifyTest("User Navigate To the Home page", false);
            e.printStackTrace();
        }
    }

    @When("User Go To Advance Search Page and Search for ssn and area")
    @Aliases(values={"User Go To Advance Search Page and Search for ssn area Company",
            "User Go To Advance Search Page and Search for Name Contains area Company",
            "User Go To Advance Search Page and Search for Name Contains and Company",
            "User Go To Advance Search Page and Search for Area_SSN_Status_U_D_S_C_W_B",
            "User Go To Advance Search Page and Search for SSN_Status_U_D_S_C_W_B",
            "User Go To Advance Search Page and Search for Area_Name_Contains_Work_Start_Date",
            "User Go To Advance Search Page and Search for Area SSN and K status",
            "User Go To Advance Search Page and Search for Area_SSN_Work_Start_From_Work_Start_To"})
    public void searchWithCombination(@Named("SSN") String ssn,@Named("Area") String area,@Named("Company") String company,
                                      @Named("NameContains") String nameContains, @Named("Status") String status,
                                      @Named("WorkStartFrm") String workStartFrm,@Named("WorkStartTo") String workStartTo) {
        try{
            if(ssn.length()>0)
            {
                searchSSN.Search_SSN_The_InputBox().clear();
                searchSSN.Search_SSN_The_InputBox().sendKeys(ssn);
            }
            if(nameContains.length()>0)
            {
                searchSSN.Search_SSN_The_InputBox().clear();
                searchSSN.Search_SSN_The_InputBox().sendKeys(nameContains);
            }

            if(area.length()>0)
            {
                Thread.sleep(2000);
                searchSSNumber.search_SSN_Area_Dropdown().click();
                Thread.sleep(2000);
                char areaChar = area.charAt(0);
                switch (areaChar) {
                    case 'W':
                        searchSSNumber.search_SSN_Area_Dropdown_WOTC_Value().click();
                        break;
                    case 'C':
                        searchSSNumber.search_SSN_Area_Dropdown_CA_Value().click();
                        break;
                    case 'P':
                        searchSSNumber.search_SSN_Area_Dropdown_POH_Value().click();

                    default:
                        System.out.println("Invalid Area");

                }
            }

            if(company.length()>0)
            {
                searchSSNumber.advance_Search_Company_TextBox().clear();
                searchSSNumber.advance_Search_Company_TextBox().sendKeys(company);
                Thread.sleep(3000);
                searchSSNumber.search_SSN_Client_Autopop().click();
            }

            if(status.length()>0)
            {
                List<String> allStatus = Arrays.asList(status.split("#"));
                int statusCount = allStatus.size();
                for(int i=0; i<statusCount;i++) {
                    bcAct.selectStatusOnAdvSearchStatus(allStatus.get(i));
                    System.out.println("Status Selected");
                }
            }

            if(workStartFrm.length()>0)
            {
                int wrkstart= Integer.parseInt(workStartFrm);
                System.out.println(wrkstart);
                searchSSNumber.advance_Search_Work_Start_From().click();
                Thread.sleep(2000);
                ArrayList<WebElement> fromdate = searchSSNumber.search_SSN_Screened_Date_From();
                int dte_count = fromdate.size();
                for(int i=0; i<dte_count;i++){
                    if(workStartFrm.equalsIgnoreCase(fromdate.get(i).getText())){
                        fromdate.get(i).click();
                        workSrtDate = searchSSNumber.advance_Search_Work_Start_From().getAttribute("value");
                        break;
                    }
                }
            }

            if(workStartTo.length()>0)
            {
                searchSSNumber.advance_Search_Work_Start_To().click();
                Thread.sleep(2000);
                ArrayList<WebElement> fromdt = searchSSNumber.search_SSN_Screened_Date_From();
                int from_date_count = fromdt.size();
                for(int i=0; i<from_date_count;i++){
                    if(workStartTo.equalsIgnoreCase(fromdt.get(i).getText())){
                        fromdt.get(i).click();
                        Thread.sleep(2000);
                        workEdDate = searchSSNumber.advance_Search_Work_Start_To().getAttribute("value");
                        break;
                    }
                }
            }


            Thread.sleep(2000);
            searchSSNumber.advance_Search_Button().click();
            Thread.sleep(2000);

        }catch(Exception e)
        {
            try {
                screenshot.getScreenshot("searchSSN");
                verifyTest("User Navigate To the Home page", false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @Then("The Search Result should be displayed with correct value for SSN AND AREA")
    public void verifySSNSearchForAreaSSN(@Named("SSN") String ssn,@Named("Area") String area) throws Exception {
        Thread.sleep(2000);
        String actualSSN = "";
        actualSSN = searchSSN.Search_SSN_The_SearchResult().getText();
        String ssnActual = actualSSN.replace("-", "");
        List<WebElement> areaElement = bcAct.selectStatusOnAdvStatusResult(area);
       String areaText=areaElement.get(0).getText();
        assertion.verifyText(ssnActual,ssn,"001_US123_Advance_Search_For_SSN_Number_Stories");
        assertion.verifyText(areaText,area,"001_US123_Advance_Search_For_SSN_Number_Stories");
    }



    @Then("The Search Result should be displayed with correct value for SSN AND AREA AND Company")
    public void verifySSNSearchForAreaSSNCompany(@Named("SSN") String ssn,@Named("Area") String area,
                                                @Named("Company") String company) throws Exception {

        Thread.sleep(2000);
        String actualSSN = "";
        actualSSN = searchSSN.Search_SSN_The_SearchResult().getText();
        String ssnActual = actualSSN.replace("-", "");
        List<WebElement> areaElement = bcAct.selectStatusOnAdvStatusResult(area);
        String areaText=areaElement.get(0).getText();
        List<WebElement> companyElement = bcAct.selectStatusOnAdvStatusResult(company);
        String companyText=companyElement.get(0).getText();

        assertion.verifyText(ssnActual,ssn,"002_US_ID02_Hub_Search_With_Area_SSN_Company");
        assertion.verifyText(areaText,area,"002_US_ID02_Hub_Search_With_Area_SSN_Company");
        assertion.verifyText(companyText,company,"002_US_ID02_Hub_Search_With_Area_SSN_Company");



    }

    @Then("The Search Result should be displayed with correct value for Name Contains AND AREA AND Company")
    public void verifySSNSearchForAreaSSNNameContains(@Named("Company") String company,@Named("Area") String area,
                                                      @Named("NameContains") String nameContains) throws Exception {
        List<WebElement> areaElementt = bcAct.selectStatusOnAdvStatusResult(area);
        String areaText=areaElementt.get(0).getText();
        List<WebElement> companyElementt = bcAct.selectStatusOnAdvStatusResult(company);
        String companyText=companyElementt.get(0).getText();
        WebElement empInfo =searchSSNumber.Search_SSN_The_SearchResult();
        userAction.doubleClick(empInfo);
        Thread.sleep(3000);
        explicitWaitForElement(EditPersonalInfo.EDIT_BUTTON_ON_PERSONAL_INFO,10);
        editpersonalinfo.edit_Personal_Info_Button().click();
        Thread.sleep(3000);
        String firstNameActual =  editpersonalinfo.edit_First_Name_TextBox().getAttribute("value");
        editpersonalinfo.edit_Back_Button().click();
        Thread.sleep(2000);
        assertion.verifyText(areaText,area,"002_US_ID02_Hub_Search_With_Area_SSN_Company");
        assertion.verifyText(companyText,company,"002_US_ID02_Hub_Search_With_Area_SSN_Company");
        assertion.verifyText(firstNameActual,nameContains,"002_US_ID02_Hub_Search_With_Area_SSN_Company");


    }

    @Then("The Search Result should be displayed with correct value for Name Contains AND Company")
    public void verifySSNSearchForComapnyNameContains(@Named("Company") String company,
                                                      @Named("NameContains") String nameContains) throws Exception {

        List<WebElement> companyElementt = bcAct.selectStatusOnAdvStatusResult(company);
        String companyText=companyElementt.get(0).getText();
        WebElement empInfo =searchSSNumber.Search_SSN_The_SearchResult();
        userAction.doubleClick(empInfo);
        Thread.sleep(3000);
        explicitWaitForElement(EditPersonalInfo.EDIT_BUTTON_ON_PERSONAL_INFO,10);
        editpersonalinfo.edit_Personal_Info_Button().click();
        Thread.sleep(3000);
        String firstNameActual =  editpersonalinfo.edit_First_Name_TextBox().getAttribute("value");
        editpersonalinfo.edit_Back_Button().click();
        Thread.sleep(2000);
        assertion.verifyText(companyText,company,"002_US_ID04_Hub_Search_With_Name_Contains_Company");
        assertion.verifyText(firstNameActual,nameContains,"002_US_ID04_Hub_Search_With_Name_Contains_Company");

    }

    @Then("The Search Result should be displayed with correct value for Area SSN and Staus UDSCWB")
    public void verifySSNSearchForComapnyNameContainsArea_SSNStatusUDSCWB(@Named("Area") String area,
                                                                          @Named("SSN") String ssn,
                                                                          @Named("Status") String status) throws Exception {
        List<WebElement> areaElementt = bcAct.selectStatusOnAdvStatusResult(area);
        String areaText=areaElementt.get(0).getText();

        String actualSSN = "";
        actualSSN = searchSSN.Search_SSN_The_SearchResult().getText();
        String ssnActual = actualSSN.replace("-", "");
        verifyStatus("U");
        searchSSNumber.advance_Search_Button().click();
        verifyStatus("D");
        searchSSNumber.advance_Search_Button().click();
        verifyStatus("S");
        searchSSNumber.advance_Search_Button().click();
      //  verifyStatus("C");
      //  verifyStatus("W");
      //  verifyStatus("B");

        assertion.verifyText(areaText,area,"002_US_ID05_Hub_Search_With_Area_SSN_Status_U_D_S_C_W_B");
       // assertion.verifyText(ssnActual,ssn,"002_US_ID05_Hub_Search_With_Area_SSN_Status_U_D_S_C_W_B");

    }

    @Then("The Search Result should be displayed with correct value for SSN AND status UDSCWB")
    public void verifySSNSearchForComapnyNameContainsSSNStatusUDSCWB(@Named("SSN") String ssn,
                                                                          @Named("Status") String status) throws Exception {
        Thread.sleep(5000);
        String actualSSN = "";
        actualSSN = searchSSN.Search_SSN_The_SearchResult().getText();
        String ssnActual = actualSSN.replace("-", "");

        verifyStatus("U");
        verifyStatus("D");
        verifyStatus("S");
       // verifyStatus("C");
        //verifyStatus("W");
        //verifyStatus("B");

       // assertion.verifyText(ssnActual,ssn,"002_US_ID05_Hub_Search_With_SSN_Status_U_D_S_C_W_B");

    }

    @Then("The Search Result should be displayed with correct value for Area Name contain and work start Date")
    public void verifySSNSearchAreaNameContStartTo(@Named("Area") String area,
                                                   @Named("NameContains") String nameContains,
                                                   @Named("WorkStartFrm") String workStartFrm) throws Exception {
        boolean flag = false;
        List<WebElement> areaElementt = bcAct.selectStatusOnAdvStatusResult(area);
        String areaText=areaElementt.get(0).getText();
        WebElement empInfo =searchSSNumber.Search_SSN_The_SearchResult();
        userAction.doubleClick(empInfo);
        Thread.sleep(3000);
        explicitWaitForElement(EditPersonalInfo.EDIT_BUTTON_ON_PERSONAL_INFO,10);
        editpersonalinfo.edit_Personal_Info_Button().click();
        Thread.sleep(3000);
        String firstNameActual =  editpersonalinfo.edit_First_Name_TextBox().getAttribute("value");
        String startDateActual = editpersonalinfo.edit_Position_Employee_Start_Date().getAttribute("value");

        String actualStartDate = startDateActual.substring(3,5);
        int actualWorkStart= Integer.parseInt(actualStartDate);
        int wrkstartFromExpec= Integer.parseInt(workStartFrm);
        if(wrkstartFromExpec <= actualWorkStart){
            flag =true;
        }
        editpersonalinfo.edit_Back_Button().click();
        Thread.sleep(2000);

        assertion.verifyText(areaText,area,"002_US_ID04_Hub_Search_With_Name_Contains_Company");
        assertion.verifyText(firstNameActual,nameContains,"002_US_ID04_Hub_Search_With_Name_Contains_Company");
        assertion.verifyTrue(flag,"002_US_ID04_Hub_Search_With_Name_Contains_Company");

    }

    @Then("The Search Result should be displayed with correct value for Area SSN and K Status")
    public void verifySSNSearchAreaSSNKstatus(@Named("Area") String area,
                                                   @Named("SSN") String ssn,
                                                   @Named("Status") String status) throws Exception {
        boolean flag = false;
        List<WebElement> areaElementt = bcAct.selectStatusOnAdvStatusResult(area);
        String areaText=areaElementt.get(0).getText();

        String actualSSN = "";
        actualSSN = searchSSN.Search_SSN_The_SearchResult().getText();
        String ssnActual = actualSSN.replace("-", "");

        List<WebElement> records = bcAct.selectStatusOnAdvStatusResult("K");
        int recCount = records.size();
        System.out.println("Record Count for Search : " + recCount);
        if(recCount> 0)
        {
            flag = true;
        }
        // if(!statusReq.equalsIgnoreCase("E")){
        assertion.verifyTrue(flag ,"002_US_ID08_Hub_Search_With_Area_SSN_and_K_Status");
        assertion.verifyText(areaText,area,"002_US_ID08_Hub_Search_With_Area_SSN_and_K_Status");
        assertion.verifyText(ssnActual,ssn,"002_US_ID08_Hub_Search_With_Area_SSN_and_K_Status");

    }

    @Then("The Search Result should be displayed with correct value for Area SSN Work start From and Work start To")
    public void verifySSNSearchAreaSSNWorktoFrom(@Named("Area") String area,
                                              @Named("SSN") String ssn,
                                              @Named("WorkStartFrm") String WorkStartFrm,
                                                 @Named("WorkStartTo") String workStartTo) throws Exception {
        boolean flag = false;

        List<WebElement> areaElementt = bcAct.selectStatusOnAdvStatusResult(area);
        String areaText=areaElementt.get(0).getText();

        String actualSSN = "";
        actualSSN = searchSSN.Search_SSN_The_SearchResult().getText();
        String ssnActual = actualSSN.replace("-", "");

        WebElement empInfo =searchSSNumber.Search_SSN_The_SearchResult();
        userAction.doubleClick(empInfo);
        Thread.sleep(3000);
        explicitWaitForElement(EditPersonalInfo.EDIT_BUTTON_ON_PERSONAL_INFO,10);
        editpersonalinfo.edit_Personal_Info_Button().click();
        Thread.sleep(3000);
        String startDateActual = editpersonalinfo.edit_Position_Employee_Start_Date().getAttribute("value");
        String actualStartDate = startDateActual.substring(3,5);
        int actualWorkStart= Integer.parseInt(actualStartDate);
        int wrkstartFromExpec= Integer.parseInt(WorkStartFrm);
        int wrkstartToExpec= Integer.parseInt(workStartTo);
        if(wrkstartFromExpec < actualWorkStart && actualWorkStart < wrkstartToExpec){
            flag =true;
        }
        editpersonalinfo.edit_Back_Button().click();

        assertion.verifyText(areaText,area,"002_US_ID09_Hub_Search_With_Area_SSN_Work_Start_From_Work_Start_To");
        assertion.verifyText(ssnActual,ssn,"002_US_ID09_Hub_Search_With_Area_SSN_Work_Start_From_Work_Start_To");
        assertion.verifyTrue(flag,"002_US_ID09_Hub_Search_With_Area_SSN_Work_Start_From_Work_Start_To");
    }

    public void verifyStatus(String status) throws Exception
    {
        boolean flag = false;
        if(searchSSNumber.search_SSN_Next_Button().isDisplayed() && searchSSNumber.search_SSN_Next_Button().isEnabled())
        {
            do {
                Thread.sleep(2000);
                List<WebElement> records = bcAct.selectStatusOnAdvStatusResult(status);
                int recCount = records.size();
                if (recCount > 0) {
                    flag = true;
                    searchSSNumber.advance_Search_Button().click();
                    System.out.println("Record Count for Search : " + recCount);
                }
                searchSSNumber.search_SSN_Next_Button().click();
                Thread.sleep(2000);
            }while(searchSSNumber.search_SSN_Next_Button().isDisplayed() && searchSSNumber.search_SSN_Next_Button().isEnabled() && flag == false);

        }

        assertion.verifyTrue(flag,"Status is not displayed for Search " + status);
    }

    public static void main(String[] args) throws Exception {
        BaseTempletSteps bstmp = new BaseTempletSteps();
        PDFfilesValidation pdffiles = new PDFfilesValidation();
        StateExport_Steps statexp = new StateExport_Steps();
        pdffiles.verifyPDFContent(bstmp.deleteDownlaodFileLoc+"\\FSU-7101.pdf", "test");
        DeleteFilesAction.deleteScreenShot(bstmp.deleteDownlaodFileLoc);
    }


	@BeforeStory
	public void beforeStory() throws ClassNotFoundException, InstantiationException, IllegalAccessException,Exception{
		reportMapping = new ReportMapping();
		String startTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		setStartTime(startTime);

        String browser = (PropertiesUtilities.loadKeyValue("browserType"));
        BaseTempletSteps.setDriver(driverutil.setBrowser(browser));
        baseTempletSteps.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        baseTempletSteps.getDriver().manage().deleteAllCookies();
        baseTempletSteps.getDriver().manage().window().maximize();


	    getDriver().manage().deleteAllCookies();
	    MoveFiles.moveFiles(deleteDownlaodFileLoc);
        MoveFiles.moveFiles(unzipFilesLoc);
        DeleteFilesAction.deleteScreenShot(screenShotPath);
        DeleteFilesAction.deleteScreenShot(deleteDownlaodFileLoc);
        DeleteFilesAction.deleteScreenShot(unzipFilesLoc);
        MoveFiles.moveFiles(deleteDownlaodFileLoc);
        MoveFiles.moveFiles(unzipFilesLoc);
        DeleteFilesAction.deleteScreenShot(deleteDownlaodFileLoc);
        DeleteFilesAction.deleteScreenShot(unzipFilesLoc);
//        DeleteFilesAction.deleteScreenShot(videoRecord.videoPath);
//        videoRecord.startRecording();

	}	
	
	@AfterStory
	public void afterStory()throws Exception
	{	//videoRecord.stopRecording();
		String endTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		setEndTime(endTime);
		String totalTimeTakenBySingleStory = calcTime();
		
		reportMapping.setDuration(totalTimeTakenBySingleStory);
		System.out.println("--"+reportMapping.getStatus());
		if(reportMapping.getStatus() == "" || reportMapping.getStatus() == "FAIL"){
			  reportMapping.setStatus("FAIL");
		}else{			  
			  reportMapping.setStatus("PASS");
		}
		
		reportMapping.setBrowserName(getBrwoserName());
		reportMapping.setBrowserVersion(getBrwoserVersion());    
		reportMapping.setMachineName(getIPAddress());
		reportMapping.setSSN(String.valueOf(getSSN()));
		
		comprehensiveMap.add(reportMapping);		
		reportMapping = null;
//        videoRecord=null;
        getDriver().manage().deleteAllCookies();
        cleanExecelData();
        getDriver().quit();
    }
   
    
    }


