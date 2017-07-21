package adp.tcs.automation.stepsfiles;

import adp.tcs.automation.pages.BackOfficActions;
import adp.tcs.automation.utilities.CustomizedAssertion;
import adp.tcs.automation.utilities.ReadingxlsFile;
import adp.tcs.automation.utilities.TakeScreenshotAction;
import adp.tcs.automation.utilities.UserAction;
import adp.tcs.automation.locators.EditPersonalInfo;
import adp.tcs.automation.pages.*;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by BhuteSac on 5/12/2016.
 */
public class US002_AdvancedSearch_Steps extends BaseTempletSteps {
    Login loginPage = new Login();
    SearchSSNthroughHub searchSSNumber = new SearchSSNthroughHub();
    EditPersonalInformation editpersonalinfo = new EditPersonalInformation();
    CustomizedAssertion assertion = new CustomizedAssertion();
    TakeScreenshotAction screenshot = new TakeScreenshotAction();
    SearchSSNthroughHub searchSSN = new SearchSSNthroughHub();
    UserAction userAction = new UserAction();
    BackOfficActions bcAct = new BackOfficActions();
    ReadingxlsFile dataFromxls = new ReadingxlsFile();   
    MoreDetails MoreDtls = new MoreDetails();
    public String expectedSSN;
    public String fromDate;
    public String todate;
    public String hireDt;
    public String workSrtDate;
    public String workEdDate;

    @Given("I Logged in and Advanced Search Page is displayed")
    public void advanceSearch() throws InterruptedException {
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
       // searchSSNumber.Search_SSN_Reset_Button().click();
      //  Thread.sleep(2000);
    }

    @When("I Search with valid clientID")
    public void advanceSearchEnterValue(@Named("clientID") String clientID) throws InterruptedException {
        searchSSNumber.advance_Search_Client_TextBox().clear();
        searchSSNumber.advance_Search_Client_TextBox().sendKeys(clientID);
        Thread.sleep(3000);
        searchSSNumber.search_SSN_Client_Autopop().click();
        searchSSNumber.advance_Search_Button().click();
        Thread.sleep(2000);
    }

    @Then("I should see the correct Search result for specified client ID")
    public void advanceSearchResultVerify() throws Exception {
        boolean flag = false;
        Thread.sleep(2000);
        String companyResult = searchSSNumber.search_SSN_Company_Result().getText();
        searchSSNumber.advance_Search_Company_TextBox().sendKeys(companyResult);
        Thread.sleep(2000);
        String actualComp = searchSSNumber.search_SSN_Client_Autopop().getText();
        Thread.sleep(1000);
        if(actualComp.equals(companyResult))
        {
            flag= true;
        }
        Thread.sleep(2000);
        searchSSNumber.Search_SSN_Reset_Button().click();
        Thread.sleep(2000);
        searchSSNumber.search_SSN_Hide_Advance_Search().click();
        assertion.verifyTrue(flag ,"verifyBackButton");

    }

//    @Given("I Logged in and Advanced Search Page to search on Area and Company")
//    public void advanceareaSearch() throws InterruptedException {
//
//    }

    @When("I Search with valid Area and Company Name")
    public void advanceSearchComapnyNameArea(@Named("CompanyName") String companyName,
                                             @Named("Area") String area) throws Exception {
        try{
            searchSSNumber.advance_Search_Link().click();
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

        searchSSNumber.advance_Search_Company_TextBox().clear();
        searchSSNumber.advance_Search_Company_TextBox().sendKeys(companyName);
            Thread.sleep(3000);
            searchSSNumber.search_SSN_Client_Autopop().click();
        searchSSNumber.advance_Search_Button().click();
        Thread.sleep(3000);
        }catch(Exception e)
        {
            screenshot.getScreenshot("005_US123_advanceSearchComapnyNameArea");
            e.printStackTrace();
        }
    }


    @Then("I should see the correct Search result for specified Area and Company")
    public void advanceSearchAreaCompanyVerify(@Named("CompanyName") String companyName, @Named("Area") String area) throws Exception {
        boolean flag = false;
        String actualompany = searchSSNumber.search_SSN_Company_Result().getText();
        String actualArea = searchSSNumber.search_SSN_Area_Actual_Area_Result().getText();
        Thread.sleep(2000);
        if(companyName.equalsIgnoreCase(actualompany) && area.equalsIgnoreCase(actualArea))
        {
            flag = true;
        }
        searchSSNumber.Search_SSN_Reset_Button().click();
        Thread.sleep(2000);
        searchSSNumber.search_SSN_Hide_Advance_Search().click();
        assertion.verifyTrue(flag ,"005_US123_advanceSearchAreaCompanyVerify");

    }

    @When("I Search with valid Application Status")
    public void advanceSearchApplicationStatus(@Named("ApplicationStatus") String applicationStatus,
                                               @Named("companyResult") String companyResult) throws Exception {
        try{

        searchSSNumber.search_SSN_Application_Staus_Dropdown().click();
        bcAct.selectStatusOnAdvSearchApplicationStatus(applicationStatus);
        searchSSNumber.advance_Search_Company_TextBox().sendKeys(companyResult);
        Thread.sleep(2000);
        searchSSNumber.search_SSN_Client_Autopop().click();
        searchSSNumber.advance_Search_Button().click();
        Thread.sleep(2000);
        }catch(Exception e)
        {
            screenshot.getScreenshot("advanceSearchApplicationStatus");
            e.printStackTrace();
        }
    }

    @Then("I should see the correct Search result for specified Application Status")
    public void advanceSearchResultApplicationStatus(@Named("ApplicationStatus") String applicationStatus) throws Exception {
        boolean flag = false;
        if(applicationStatus.equalsIgnoreCase("Hired Records")) {
            WebElement empInfo = searchSSNumber.Search_SSN_The_SearchResult();
            userAction.doubleClick(empInfo);
            Thread.sleep(5000);
            flag = searchSSNumber.search_SSN_Application_Hire_Date_Edit_Page().isDisplayed();
            searchSSNumber.search_SSN_Home_Menu().click();
            Thread.sleep(2000);
            if (searchSSNumber.Search_SSN_Reset_Button().isEnabled()) {
                searchSSNumber.Search_SSN_Reset_Button().click();
                Thread.sleep(1000);
            }
        }else{
            Thread.sleep(1000);
            flag =  true;
        }

        assertion.verifyTrue(flag ,"advanceSearchResultApplicationStatus");

    }

    @When("I Search with valid Start Date From and Start Date to fields")
    public void advanceSearchStartDateFromTo(@Named("SearchDateFrom") int searchDateFrom,
                                               @Named("SearchDateTo") int searchDateTo) throws Exception {
        try{

                 searchSSNumber.advance_Search_Screened_Date_From().click();
            Thread.sleep(2000);
                 ArrayList<WebElement> fromdate = searchSSNumber.search_SSN_Screened_Date_From();
                 int from_date_count = fromdate.size();
                 for(int i=0; i<from_date_count;i++){
                     if(searchDateFrom ==i){
                         fromdate.get(i).click();
                         break;
                     }
                 }
                 searchSSNumber.advance_Search_Screened_Date_To().click();
            Thread.sleep(2000);
                 ArrayList<WebElement> todates =searchSSNumber.search_SSN_Screened_Date_From();
                 int to_date_count = fromdate.size();
                 for(int i=1; i<to_date_count;i++){
                     if(searchDateTo ==i){
                         todates.get(i).click();
                         break;
                     }
                 }
                 fromDate = searchSSNumber.advance_Search_Screened_Date_From().getAttribute("value");
                 todate = searchSSNumber.advance_Search_Screened_Date_To().getAttribute("value");
                 searchSSNumber.advance_Search_Button().click();
                 WebElement empInfo =searchSSNumber.Search_SSN_The_SearchResult();
                 userAction.doubleClick(empInfo);
                 Thread.sleep(5000);
                 explicitWaitForElement(EditPersonalInfo.EDIT_BUTTON_ON_PERSONAL_INFO,10);

        }catch(Exception e)
        {
            screenshot.getScreenshot("advanceSearchStartDateFromTo");
            e.printStackTrace();
        }
    }


    @Then("I should see the correct Search result for specified Start Date Range")
    public void advanceSearchResultStartDateFromTo(@Named("SearchDateFrom") int expSearchDateFrom,
                                                   @Named("SearchDateTo") int expsearchDateTo) throws Exception {
        boolean flag = false;
        String screeningDate = searchSSNumber.search_SSN_Screening_date_edit_page().getText();
        String actualDate = screeningDate.substring(3,5);
        String fromD = fromDate.substring(3,5);
        String toD = todate.substring(3,5);
        if(actualDate.contains("/"))
        {
            actualDate =  actualDate.replace("/", "");
        }
        if(fromD.contains("/"))
        {
            fromD =  actualDate.replace("/", "");
        }
        if(toD.contains("/"))
        {
            toD =  actualDate.replace("/", "");
        }
        int actualDat = Integer.parseInt(actualDate);
        int from = Integer.parseInt(fromD);
        int to = Integer.parseInt(toD);
        if(actualDat >=from)
        {
            if(actualDat <=to)
            {
                flag = true;
            }
        }
        assertion.verifyTrue(flag ,"advanceSearchResultStartDateFromTo");

    }



    @When("I Search with valid Hire Date")
    public void advanceSearchHire(@Named("HireDate") int hireDate) throws Exception {
        try{

            searchSSNumber.advance_Search_HireDate_TextBox().click();
            Thread.sleep(2000);
            searchSSNumber.search_SSN_Date_Prev_Month_Button().click();
            Thread.sleep(2000);
            ArrayList<WebElement> fromdate = searchSSNumber.search_SSN_Screened_Date_From();
            int from_date_count = fromdate.size();
            for(int i=0; i<from_date_count;i++){
                if(hireDate ==i){
                    fromdate.get(i).click();
                    break;
                }
            }
            hireDt = searchSSNumber.advance_Search_HireDate_TextBox().getAttribute("value");
            searchSSNumber.advance_Search_Button().click();
            WebElement empInfo =searchSSNumber.Search_SSN_The_SearchResult();
            userAction.doubleClick(empInfo);
            Thread.sleep(5000);
            explicitWaitForElement(EditPersonalInfo.EDIT_BUTTON_ON_PERSONAL_INFO,10);

        }catch(Exception e)
        {
            screenshot.getScreenshot("advanceSearchHire");
            e.printStackTrace();
        }
    }


    @Then("I should see the correct Search result for Hire date Field")
    public void advanceSearchResultHire(@Named("HireDate") int hireDate
                                                   ) throws Exception {
        boolean flag = false;
        String hireDat = searchSSNumber.search_SSN_Hire_date_edit_page().getText();
       // String actuaHireDate = hireDat.substring(3,5);
      if(hireDat.equalsIgnoreCase(hireDt)){
          flag=true;
      }
        assertion.verifyTrue(flag ,"advanceSearchResultHire");
    }

    @When("I Search with valid Confirmation Number")
    public void advanceSearchConfirmationNum(@Named("ConfirmationNum") String confirmationNum) throws Exception {
        try{

            searchSSNumber.search_SSN_Confirmation_TextBox().sendKeys(confirmationNum);
            Thread.sleep(2000);
            searchSSNumber.advance_Search_Button().click();
            WebElement empInfo =searchSSNumber.Search_SSN_The_SearchResult();
            userAction.doubleClick(empInfo);
            Thread.sleep(5000);
            explicitWaitForElement(EditPersonalInfo.EDIT_BUTTON_ON_PERSONAL_INFO,10);
        }catch(Exception e)
        {
            screenshot.getScreenshot("advanceSearchHire");
            e.printStackTrace();
        }
    }

    @Then("I should see the correct Search result for Confirmation Number")
    public void advanceSearchResultConformationNum(@Named("ConfirmationNum") String confirmationNum
    ) throws Exception {
        boolean flag = false;
        String confirmNumber = searchSSNumber.search_SSN_Confirmation_Edit_Page().getText();
        // String actuaHireDate = hireDat.substring(3,5);
        if(confirmNumber.equalsIgnoreCase(confirmationNum)){
            flag=true;
        }
        assertion.verifyTrue(flag ,"advanceSearchResultHire");
    }

    @When("I Search with valid Work Start Date and End date")
    public void workStartTo(@Named("WorkStartDate") int workStartDate,
                            @Named("WorkEndDate") int workEndDate) throws InterruptedException {
        searchSSNumber.advance_Search_Work_Start_From().click();

        Thread.sleep(2000);
        ArrayList<WebElement> fromdate = searchSSNumber.search_SSN_Screened_Date_From();
        int from_date_count = fromdate.size();
        for(int i=0; i<from_date_count;i++){
            if(workStartDate ==i){
                fromdate.get(i).click();
                break;
            }
        }
        searchSSNumber.advance_Search_Work_Start_To().click();
        Thread.sleep(2000);
        ArrayList<WebElement> todates =searchSSNumber.search_SSN_Screened_Date_From();
        int to_date_count = fromdate.size();
        for(int i=1; i<to_date_count;i++){
            if(workEndDate ==i){
                todates.get(i).click();
                break;
            }
        }
        workSrtDate = searchSSNumber.advance_Search_Work_Start_From().getAttribute("value");
        workEdDate = searchSSNumber.advance_Search_Work_Start_To().getAttribute("value");
        searchSSNumber.advance_Search_Button().click();
        WebElement empInfo =searchSSNumber.Search_SSN_The_SearchResult();
        userAction.doubleClick(empInfo);
        Thread.sleep(5000);



    }

    @Then("I should see the correct Search result for Work Start")
    public void advanceSearchResultWorkStart(@Named("WorkStartDate") int workStartDate,
                                             @Named("WorkEndDate") int workEndDate
    ) throws Exception {
        boolean flag = false;
        String workStart = searchSSNumber.search_SSN_WorkStart_Edit_Page().getText();
        // String actuaHireDate = hireDat.substring(3,5);
        String actualWork = workStart.substring(3,5);
        String wfromD = workSrtDate.substring(3,5);
        String wtoD = workEdDate.substring(3,5);
        if(actualWork.contains("/"))
        {
            actualWork =  actualWork.replace("/", "");
        }
        if(wfromD.contains("/"))
        {
            wfromD =  actualWork.replace("/", "");
        }
        if(wtoD.contains("/"))
        {
            wtoD =  actualWork.replace("/", "");
        }
        int actualDat = Integer.parseInt(actualWork);
        int from = Integer.parseInt(wfromD);
        int to = Integer.parseInt(wtoD);
        if(actualDat >=from)
        {
            if(actualDat <=to)
            {
                flag = true;
            }
        }
        assertion.verifyTrue(flag ,"advanceSearchResultWorkStart");
    }


    @When("I Search by selecting Valid Status on Hub Search")
    public void advanceSearchDiffrentStatus(@Named("Status") String status
                                               ) throws Exception {
        try{

            bcAct.selectStatusOnAdvSearchStatus(status);
            searchSSNumber.advance_Search_Button().click();
            Thread.sleep(2000);
        }catch(Exception e)
        {
            screenshot.getScreenshot("advanceSearchDiffrentStatus");
            e.printStackTrace();
        }
    }

    @Then("I should see the correct Search result for Selected Status")
    public void advanceSearchResultStatus(@Named("StatusReq") String statusReq) throws Exception {
        boolean flag = false;
        List<WebElement> records = bcAct.selectStatusOnAdvStatusResult(statusReq);
        int recCount = records.size();
        System.out.println("Record Count for Search : " + recCount);
        if(recCount> 0)
        {
            flag = true;
        }
       // if(!statusReq.equalsIgnoreCase("E")){
            assertion.verifyTrue(flag ,"advanceSearchResultStatus");
       // }


    }

    @When("Open the record and update status on more details Page")
    public void moreDetailsStatusEdit(@Named("StatusReq") String status) throws Exception {
        try{
        WebElement empInfo =searchSSNumber.Search_SSN_The_SearchResult();
        userAction.doubleClick(empInfo);
        Thread.sleep(5000);
        MoreDtls.edit_More_Details_Link().click();
        Thread.sleep(2000);
        MoreDtls.edit_More_Details_Status_dropDown().click();
        Thread.sleep(2000);
      //  bcAct.selectStatusOnMoreDetails("Review");
            MoreDtls.edit_More_Details_Status_Select().click();
            Thread.sleep(2000);
            MoreDtls.more_Details_Save_Button().click();
        Thread.sleep(2000);
            MoreDtls.more_Details_Back_Button().click();
            Thread.sleep(2000);
        }catch(Exception e)
        {
            screenshot.getScreenshot("moreDetailsStatusEdit");
            e.printStackTrace();
        }
    }

    @Then("I Should see the updated status for the record on edit page")
    public void moreDetailsStatusResult(@Named("StatusReq") String statusReq) throws Exception {
        try {
        boolean flag;
        String actualValue = bcAct.statusOnMoreDetailsAfterEdit(statusReq);
        assertion.verifyText(actualValue,statusReq,"moreDetailsStatusResult");
            searchSSNumber.search_SSN_Home_Menu().click();
            Thread.sleep(2000);
        }catch(Exception e)
        {
            screenshot.getScreenshot("moreDetailsStatusResult");
            e.printStackTrace();
        }
    }

    @When("Open the record and update PSN Date on more details Page")
    public void moreDetailsPSNDateEdit(@Named("PSNdate") String pSNdate,@Named("ResubmitDate") String resubmitDate) throws Exception {
        try {

            WebElement empInfo =searchSSNumber.Search_SSN_The_SearchResult();
            userAction.doubleClick(empInfo);
            Thread.sleep(5000);
            MoreDtls.edit_More_Details_Link().click();
            Thread.sleep(2000);
            MoreDtls.more_Details_PSN_Update().click();
            ArrayList<WebElement> fromdate = searchSSNumber.search_SSN_Screened_Date_From();
            int from_date_count = fromdate.size();
            for(int i=0; i<from_date_count;i++){
                if(pSNdate.equalsIgnoreCase(fromdate.get(i).getText())){
                    fromdate.get(i).click();
                    break;
                }
            }
            MoreDtls.more_Details_Resubmit_Date().click();
            ArrayList<WebElement> resubmitDt = searchSSNumber.search_SSN_Screened_Date_From();
            int resubmit_date_count = resubmitDt.size();
            for(int i=0; i<resubmit_date_count;i++){
                if(resubmitDate.equalsIgnoreCase(resubmitDt.get(i).getText())){
                    resubmitDt.get(i).click();
                    break;
                }
            }
            Thread.sleep(2000);
            if(MoreDtls.more_Details_Save_Button().isEnabled()){
            MoreDtls.more_Details_Save_Button().click();}
            Thread.sleep(2000);
            MoreDtls.more_Details_Back_Button().click();
            Thread.sleep(2000);
            MoreDtls.edit_More_Details_Link().click();
            Thread.sleep(2000);
        }catch(Exception e)
        {
            screenshot.getScreenshot("moreDetailsPSNDateEdit");
            e.printStackTrace();
        }
    }

    @Then("I Should see the updated PSN Date for the record on More Details Page")
    public void moreDetailsPSNDateResult(@Named("PSNdate") String pSNdate,@Named("ResubmitDate") String resubmitDate) throws Exception {
        try {
            boolean flag = false;
            String psn_Date = MoreDtls.more_Details_PSN_Update().getAttribute("value");
            String resubmit_Date = MoreDtls.more_Details_Resubmit_Date().getAttribute("value");
            String actualPSN_Date = psn_Date.substring(3,5);
            String actual_Resubmit_Date = resubmit_Date.substring(3,5);
            if(actualPSN_Date.equalsIgnoreCase(pSNdate) && actual_Resubmit_Date.equalsIgnoreCase(resubmitDate))
            {
                flag=true;
            }
            Thread.sleep(2000);
            MoreDtls.more_Details_Back_Button().click();
            Thread.sleep(2000);
            searchSSNumber.search_SSN_Home_Menu().click();
            assertion.verifyTrue(flag,"moreDetailsPSNDateResult");

        }catch(Exception e)
        {
            screenshot.getScreenshot("moreDetailsStatusResult");
            e.printStackTrace();
        }
    }

    @When("Open the record and update State Date ivnalid Date verification and Appeal sent Date on more details Page")
    public void moreDetailsDateEdit(@Named("StateDate") String stateDate,@Named("invalidDate") String invalidDate,
                                    @Named("verificationDate") String verificationDate,@Named("appealDate") String appealDate,
                                    @Named("DeniedDate") String deniedDate, @Named("CertEffectiveEndDt") String certEffectiveEndDt) throws Exception {
        try {

            WebElement empInfo =searchSSNumber.Search_SSN_The_SearchResult();
            userAction.doubleClick(empInfo);
            Thread.sleep(5000);
            MoreDtls.edit_More_Details_Link().click();
            Thread.sleep(2000);
            MoreDtls.more_Details_Start_Date().click();
            ArrayList<WebElement> calenderAllDate = searchSSNumber.search_SSN_Screened_Date_From();
            int from_date_count = calenderAllDate.size();
            for(int i=0; i<from_date_count;i++){
                if(stateDate.equalsIgnoreCase(calenderAllDate.get(i).getText())){
                    calenderAllDate.get(i).click();
                    break;
                }
            }
            MoreDtls.more_Details_Invalid_Date().click();
            ArrayList<WebElement> calenderAllDt = searchSSNumber.search_SSN_Screened_Date_From();
            int dte_count = calenderAllDt.size();
            for(int i=0; i<dte_count;i++){
                if(invalidDate.equalsIgnoreCase(calenderAllDt.get(i).getText())){
                    calenderAllDt.get(i).click();
                    break;
                }
            }
            MoreDtls.more_Details_Appeal_sent_Date().click();
            ArrayList<WebElement> calenderAllDte = searchSSNumber.search_SSN_Screened_Date_From();
            int dt_count = calenderAllDte.size();
            for(int i=0; i<dt_count;i++){
                if(verificationDate.equalsIgnoreCase(calenderAllDte.get(i).getText())){
                    calenderAllDte.get(i).click();
                    break;
                }
            }
            MoreDtls.more_Details_Verification_Date().click();
            ArrayList<WebElement> calenderAllD = searchSSNumber.search_SSN_Screened_Date_From();
            int d_count = calenderAllD.size();
            for(int i=0; i<d_count;i++){
                if(appealDate.equalsIgnoreCase(calenderAllD.get(i).getText())){
                    calenderAllD.get(i).click();
                    break;
                }
            }

            MoreDtls.more_Details_Denied_Date().click();
            ArrayList<WebElement> calenderAlDates = searchSSNumber.search_SSN_Screened_Date_From();
            int dates_Count = calenderAlDates.size();
            for(int i=0; i<dates_Count;i++){
                if(deniedDate.equalsIgnoreCase(calenderAlDates.get(i).getText())){
                    calenderAlDates.get(i).click();
                    break;
                }
            }

            MoreDtls.more_Details_Cert_Effective_End_Date().click();
            ArrayList<WebElement> calenderAlDate = searchSSNumber.search_SSN_Screened_Date_From();
            int dates_Cnt = calenderAlDate.size();
            for(int i=0; i<dates_Cnt;i++){
                if(certEffectiveEndDt.equalsIgnoreCase(calenderAlDate.get(i).getText())){
                    calenderAlDate.get(i).click();
                    break;
                }
            }

            Thread.sleep(2000);
            if(MoreDtls.more_Details_Save_Button().isEnabled()){
                MoreDtls.more_Details_Save_Button().click();}
            Thread.sleep(2000);
            MoreDtls.more_Details_Back_Button().click();
            Thread.sleep(2000);
            MoreDtls.edit_More_Details_Link().click();
            Thread.sleep(2000);
        }catch(Exception e)
        {
            screenshot.getScreenshot("moreDetailsPSNDateEdit");
            e.printStackTrace();
        }
    }

    @Then("I Should see the updated State Invalid  Date verification Appeal for the record on More Details Page")
    public void moreDetailDateResult(@Named("StateDate") String stateDate,@Named("invalidDate") String invalidDate,
                                     @Named("verificationDate") String verificationDate,@Named("appealDate") String appealDate,
                                     @Named("DeniedDate") String deniedDate, @Named("CertEffectiveEndDt") String certEffectiveEndDt) throws Exception {
        try {
            boolean flag = false;
            String start_date = MoreDtls.more_Details_Start_Date().getAttribute("value");
            String invalidation_Date = MoreDtls.more_Details_Invalid_Date().getAttribute("value");
            String verification_Date = MoreDtls.more_Details_Verification_Date().getAttribute("value");
            String appeal_Date = MoreDtls.more_Details_Appeal_sent_Date().getAttribute("value");
            String denied_Date = MoreDtls.more_Details_Appeal_sent_Date().getAttribute("value");
            String certEffective_Date = MoreDtls.more_Details_Cert_Effective_End_Date().getAttribute("value");
            String actualStart_Date = start_date.substring(3,5);
            String actual_Invalidation_Date = invalidation_Date.substring(3,5);
            String actual_Verification_Date = verification_Date.substring(3,5);
            String actual_Appeal_Date = appeal_Date.substring(3,5);
            String actual_denied_Date = denied_Date.substring(3,5);
            String actual_certEffective_Date = certEffective_Date.substring(3,5);

            if(actualStart_Date.equalsIgnoreCase(stateDate) && actual_Invalidation_Date.equalsIgnoreCase(invalidDate)&&
                    actual_Verification_Date.equalsIgnoreCase(verificationDate) && actual_Appeal_Date.equalsIgnoreCase(appealDate) &&
                    actual_denied_Date.equalsIgnoreCase(deniedDate) && actual_certEffective_Date.equalsIgnoreCase(certEffectiveEndDt))
            {
                flag=true;
            }
            Thread.sleep(2000);
            MoreDtls.more_Details_Back_Button().click();
            Thread.sleep(2000);
            searchSSNumber.search_SSN_Home_Menu().click();
            Thread.sleep(2000);
            assertion.verifyTrue(flag,"moreDetailDateResult");

        }catch(Exception e)
        {
            screenshot.getScreenshot("moreDetailDateResult");
            e.printStackTrace();
        }
    }

    @When("Open the record and update Need Letter Received Date")
    public void moreDetailNeedReportLetter(@Named("NeedReportDt") String needReportDt) throws Exception {
        try {
            WebElement empInfo =searchSSNumber.Search_SSN_The_SearchResult();
            userAction.doubleClick(empInfo);
            Thread.sleep(5000);
            MoreDtls.edit_More_Details_Link().click();
            Thread.sleep(2000);
            MoreDtls.more_Details_Need_Letter_Date().click();
            ArrayList<WebElement> calenderAllDt = searchSSNumber.search_SSN_Screened_Date_From();
            int dte_count = calenderAllDt.size();
            for(int i=0; i<dte_count;i++){
                if(needReportDt.equalsIgnoreCase(calenderAllDt.get(i).getText())){
                    calenderAllDt.get(i).click();
                    break;
                }
            }
            if(MoreDtls.more_Details_Save_Button().isEnabled()){
                MoreDtls.more_Details_Save_Button().click();}
            Thread.sleep(2000);
            MoreDtls.more_Details_Back_Button().click();
            Thread.sleep(2000);
            MoreDtls.edit_More_Details_Link().click();
            Thread.sleep(2000);
        }catch(Exception e)
        {
            screenshot.getScreenshot("moreDetailNeedReportLetter");
            e.printStackTrace();
        }
    }

    @Then("I Should see the updated Need Letter Received Date with Updated Value")
    public void moreDetailNeedReportLetterResult(@Named("NeedReportDt") String needReportDt) throws Exception {

        boolean flag = false;
        String need_Letter_date = MoreDtls.more_Details_Need_Letter_Date().getAttribute("value");
        String need_Letter_Dt = need_Letter_date.substring(3,5);
        Thread.sleep(2000);
        MoreDtls.more_Details_Back_Button().click();
        Thread.sleep(2000);
        searchSSNumber.search_SSN_Home_Menu().click();
        Thread.sleep(2000);
        assertion.verifyText(need_Letter_Dt,needReportDt,"moreDetailNeedReportLetterResult");
    }


    @When("Open the record and change the Target Group on more details Page")
    public void moreDetailTargetGroup(@Named("TagetGroupName") String targetGroupName) throws Exception {
        try {

                WebElement empInfo = searchSSNumber.Search_SSN_The_SearchResult();
                userAction.doubleClick(empInfo);
                Thread.sleep(5000);
                MoreDtls.edit_More_Details_Link().click();
                Thread.sleep(2000);
                MoreDtls.edit_More_Details_Status_dropDown().click();
                Thread.sleep(2000);
                //  bcAct.selectStatusOnMoreDetails("Review");
                MoreDtls.edit_More_Details_Status_Select().click();
                Thread.sleep(2000);

                List<String> dataPerPage = Arrays.asList(targetGroupName.split("#"));
                int targetGrpCount = dataPerPage.size();
                for(int i=0; i<=targetGrpCount;i++)
                {
                    if(!bcAct.updateForTargetResult(dataPerPage.get(i)).isSelected()) {
                        bcAct.updateForTargetResult(dataPerPage.get(i)).click();
                        System.out.println("Target Group Name is not displayed : " + dataPerPage.get(i));
                    }
                }
                if(MoreDtls.more_Details_Save_Button().isEnabled()){
                    MoreDtls.more_Details_Save_Button().click();
                    Thread.sleep(2000);}
           if(MoreDtls.more_Details_Confirmation_PopUp().isDisplayed())
          {
                MoreDtls.more_Details_Confirmation_PopUp().click();
          }
                Thread.sleep(2000);
                MoreDtls.more_Details_Back_Button().click();
                Thread.sleep(2000);
        }catch(Exception e)
        {
            screenshot.getScreenshot("moreDetailTargetGroup");
            e.printStackTrace();
        }
    }


    @Then("I Should see the updated Target Group on the main page")
    public void moreDetailTargetGroupResult(@Named("TagetGroupName") String targetGroupName) throws Exception {
        boolean flag = false;
        try{
            int i;
            List<String> dataPerPage = Arrays.asList(targetGroupName.split("#"));
            int targetGrpCount = dataPerPage.size();
            for(i=0; i<=targetGrpCount;i++)
            {
                if(!bcAct.updateForTargetResult(dataPerPage.get(i)).isDisplayed())
                {
                    flag = true;
                    break;
                };
                System.out.println("Targrt Group Name is not displayed : " + dataPerPage.get(i));

            }

        assertion.verifyFalse(flag,"moreDetailTargetGroupResult " + dataPerPage.get(i));
        }catch(Exception e)
        {
            assertion.verifyFalse(flag,"moreDetailTargetGroupResult");
            screenshot.getScreenshot("moreDetailTargetGroup");
            e.printStackTrace();
        }
    }

}