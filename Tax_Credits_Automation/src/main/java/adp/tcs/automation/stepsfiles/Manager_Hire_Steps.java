package adp.tcs.automation.stepsfiles;

import adp.tcs.automation.locators.ManagerHire;
import adp.tcs.automation.pages.ManagerHiredPage;
import adp.tcs.automation.pages.SearchSSNthroughHub;
import adp.tcs.automation.utilities.CalenderHandling;
import adp.tcs.automation.utilities.TakeScreenshotAction;
import adp.tcs.automation.utilities.UserAction;
import adp.tcs.automation.utilities.WndowAction;
import cucumber.api.java.en.When;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by bhutesac on 7/21/2016.
 */
public class Manager_Hire_Steps extends BaseTempletSteps {

    private ManagerHiredPage managerHire = new ManagerHiredPage();
    private TakeScreenshotAction screenshot = new TakeScreenshotAction();
    private CalenderHandling calHandling = new CalenderHandling();
    private UserAction userAct = new UserAction();
    private SearchSSNthroughHub searchSSNumber = new SearchSSNthroughHub();
    private WndowAction windowAct = new WndowAction();
    DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssZ");
    Date date = new Date();


    @Given("I Navigate to Hire Compliance Page and Search with SSN")
    public void navigateToHireComplience() throws Exception {
        try {
            String currentDate = dateFormat.format(date);
            String currentDt = currentDate.substring(4,6);
            System.out.println(currentDt);
            Thread.sleep(4000);
            managerHire.process_Tab_For_Manager_Hire().click();
            managerHire.tax_Credit_Tab_For_Manager_Hire().click();
            managerHire.hiring_Complience_Tab_For_Manager_Hire().click();
            userAct.switchToFrame("managerHireIFrame_iframe");
            waitForLoad();
            //refecter the code
            Thread.sleep(3000);
            managerHire.search_SSN_Manager_Hire_Textbox().sendKeys(getExcelData().get("SSN"));
            System.out.println("SSN Records is Hiring : " + getExcelData().get("SSN"));
            managerHire.search_SSN_Manager_Hire_Button().click();
            managerHire.hire_Button().click();
            Thread.sleep(5000);
            managerHire.manager_Hire_Offer_Date().click();
            selectDateCurrentMonth(currentDt);
            managerHire.manager_Hire_Date().click();
            selectDateCurrentMonth(currentDt);
            managerHire.manager_Hire_Start_Date().click();
            selectDateCurrentMonth(currentDt);

            managerHire.manager_Hire_Hourly_Wages_Dropdown().sendKeys(getExcelData().get("HIRE_WAGE"));
            WebElement jobtype = managerHire.job_Type_Dropdown();
            userAct.selectDropDown(jobtype, getExcelData().get("HIRE_JOB_POSITION"));
            managerHire.manager_Hire_Submit_Button().click();
            Thread.sleep(5000);
           // userAct.switchToFrame("managerHireIFrame_iframe");
         //   userAct.switchToDefaultFrame();
            String managerHr = managerHire.applicant_Hire_Message().getText();
         //   String managerHrattr = managerHire.applicant_Hire_Message().getAttribute("value");
            managerHire.manager_Hire_Back_Button().click();
            Thread.sleep(3000);

        } catch (Exception e) {
            screenshot.getScreenshot("navigateToHireComplience");
            e.printStackTrace();
        }
    }

    @Then("Manager hire to update the status to E")
    public void navigateToHireCompliencePage() throws Exception {
    	//getExcelData().put("SSN", "383758580");
    	verifyTest("Manager hire to update the status to E");
        try {
            sleep(4000);
            managerHire.process_Tab_For_Manager_Hire().click();
            managerHire.tax_Credit_Tab_For_Manager_Hire().click();
            managerHire.hiring_Complience_Tab_For_Manager_Hire().click();
            userAct.switchToFrame("managerHireIFrame_iframe");
            sleep(3000);
            managerHire.search_SSN_Manager_Hire_Textbox().sendKeys(getExcelData().get("SSN"));
            System.out.println("SSN Records is Hiring : " + getExcelData().get("SSN"));
            userAct.selectDropDown(managerHire.manager_Hire_Application_Status_Dropdown(),"Hired");
            managerHire.search_SSN_Manager_Hire_Button().click();
            sleep(2000);           
            managerHire.manager_Update_Hire_Button().click();
            sleep(5000);
            managerHire.manager_Gave_Info_Date().click();
            selectCalenderDate(currentdate());
            sleep(3000);
            managerHire.manager_Hire_Offer_Date().click();
            selectCalenderDate(currentdate());
            managerHire.manager_Hire_Date().click();
            selectCalenderDate(currentdate());
            managerHire.manager_Hire_Start_Date().click();
            selectCalenderDate(currentdate());
            managerHire.manager_Hire_Submit_Button().click();
            sleep(5000);           
            managerHire.manager_Hire_Back_Button().click();
            sleep(3000);
        } catch (Exception e) {
            screenshot.getScreenshot("navigateToHireComplience");
            e.printStackTrace();
        }finally{
        	//getDriver().manage().deleteAllCookies();
        	userAct.switchToDefaultFrame();
            Thread.sleep(2000);
            managerHire.manager_Hire_Log_Out_Button().click();
            Thread.sleep(2000);
            explicitWaitForElement(ManagerHire.MANAGER_LOGOUT_OK_BUTTON, 10);
            managerHire.MANAGER_LOGOUT_OK_BUTTON().click();
        }
    }
    
    @Then("I should see records should be hired status")
    public void verifyHire() throws Exception
    {
        Thread.sleep(10000);
        boolean flag = false;
        managerHire.search_SSN_Manager_Hire_Textbox().sendKeys(getExcelData().get("SSN"));
        WebElement applicantStatus = managerHire.manager_Hire_Application_Status_Dropdown();
        userAct.selectDropDown(applicantStatus,"Hired");
        managerHire.search_SSN_Manager_Hire_Button().click();
        Thread.sleep(5000);
        if(managerHire.manager_Update_Hire_Button().isEnabled())
        {
            flag = true;
        }
        
        //need to log out of the Application for Admin user log in
        userAct.switchToDefaultFrame();
        Thread.sleep(2000);
        managerHire.manager_Hire_Log_Out_Button().click();
        Thread.sleep(2000);
        managerHire.MANAGER_LOGOUT_OK_BUTTON().click();
        
        Assert.assertTrue("No Update Hire Button is Displayed on Page", flag);
        Thread.sleep(5000);

    }


    @Given("I Navigate to SCP Hire Compliance Page and Search with SSN")
    public void navigateToSCPHireComplience() throws Exception {
        try {
            String currentDate = dateFormat.format(date);
            String currentDt = currentDate.substring(4,6);
            System.out.println(currentDt);
            sleep(4000);            
            if(isDisplayed(ManagerHire.MANAGER_SMART_COMPLIANCE_TOUR_SKIP_LINK)){
            	managerHire.MANAGER_SMART_COMPLIANCE_TOUR_SKIP_LINK().click();
            }
            waitForLoad();
            managerHire.MANAGER_SMART_COMPLIANCE_PROCESS_TAB().click();
            sleep(2000);
            managerHire.MANAGER_SMART_COMPLIANCE_TAX_SERVICE_SUBTAB().click();           
            sleep(2000);
            managerHire.MANAGER_SMART_COMPLIANCE_HIRE_PAGE().click();
            Thread.sleep(4000);
            waitForLoad();
            userAct.switchToFrame("managerHireIFrame_iframe");
            managerHire.search_SSN_Manager_Hire_Textbox().sendKeys(getExcelData().get("SSN"));
            System.out.println("SSN Records is Hiring : " + getExcelData().get("SSN"));
            managerHire.search_SSN_Manager_Hire_Button().click();
            managerHire.hire_Button().click();
            // can be replaced with select_details_on_hire_page
            Thread.sleep(5000);
            managerHire.manager_Hire_Offer_Date().click();
            selectDateCurrentMonth(currentDt);
            managerHire.manager_Hire_Date().click();
            selectDateCurrentMonth(currentDt);
            managerHire.manager_Hire_Start_Date().click();
            selectDateCurrentMonth(currentDt);
            managerHire.manager_Hire_Hourly_Wages_Dropdown().sendKeys(getExcelData().get("HIRE_WAGE"));
            WebElement jobtype = managerHire.job_Type_Dropdown();
            userAct.selectDropDown(jobtype, getExcelData().get("HIRE_JOB_POSITION"));
            managerHire.manager_Hire_Submit_Button().click();
            Thread.sleep(5000);       
            String managerHr = managerHire.applicant_Hire_Message().getText();
            managerHire.manager_Hire_Back_Button().click();
            Thread.sleep(3000);
            userAct.switchToDefaultFrame();
            managerHire.client_User_Avatar_Link().click();
            managerHire.client_Logout_Btn().click();
            sleep(2000);
        } catch (Exception e) {
            screenshot.getScreenshot("navigateToHireComplience");
            e.printStackTrace();
        }
    }


    public void selectDateCurrentMonth(String date) throws Exception {
        Thread.sleep(1000);
        String zero =date.substring(0,1);
        if(zero.equalsIgnoreCase("0"))
        {
            date = date.substring(1,2);
        }
        ArrayList<WebElement> fromdt = searchSSNumber.search_SSN_Screened_Date_From();

        int from_date_count = fromdt.size();
        for (int i = 0; i < from_date_count; i++) {
           // String dte = fromdt.get(i).getText();

            if (date.equalsIgnoreCase(fromdt.get(i).getText())) {
                fromdt.get(i).click();
                Thread.sleep(1000);
                break;
            }
        }
    }


    ///----------------------------***************-----------------------------------------------


    @Given("I Navigate to SCP Hire Compliance Page and Enter SSN and click on Search")
    public void navigateToSCPHireComplianceAndSearch() throws Exception {
        try {
            String currentDate = dateFormat.format(date);
            String currentDt = currentDate.substring(4,6);
            System.out.println(currentDt);
            sleep(4000);
            if(isDisplayed(ManagerHire.MANAGER_SMART_COMPLIANCE_TOUR_SKIP_LINK)){
                managerHire.MANAGER_SMART_COMPLIANCE_TOUR_SKIP_LINK().click();
            }
            waitForLoad();
            managerHire.MANAGER_SMART_COMPLIANCE_PROCESS_TAB().click();
            sleep(2000);
            managerHire.MANAGER_SMART_COMPLIANCE_TAX_SERVICE_SUBTAB().click();
            sleep(2000);
            managerHire.MANAGER_SMART_COMPLIANCE_HIRE_PAGE().click();
            Thread.sleep(4000);
            waitForLoad();
            userAct.switchToFrame("managerHireIFrame_iframe");
            managerHire.search_SSN_Manager_Hire_Textbox().sendKeys(getExcelData().get("SSN"));
            managerHire.search_SSN_Manager_Hire_Button().click();


        } catch (Exception e) {
            screenshot.getScreenshot("navigateToHireComplience");
            e.printStackTrace();
        }
    }

    @Then("Logout from Hiring Compliance")
    public void LogoutHiringCompliance() throws Exception
    {
        try {

            Thread.sleep(3000);
            userAct.switchToDefaultFrame();
            managerHire.client_User_Avatar_Link().click();
            managerHire.client_Logout_Btn().click();
            sleep(2000);
        }catch (Exception e)
        {
            screenshot.getScreenshot("Logout from Hiring Compliance");
            e.printStackTrace();
        }
    }

    @Then("I entered past hire dates and clicked on Submit")
    public void select_past_date_for_denied_Hire() throws Exception
    {
        try {
            System.out.println("SSN Records is Hiring : " + getExcelData().get("SSN"));

            managerHire.hire_Button().click();
            String currentDt = addSubtractfromCurrentDate(Integer.valueOf(getExcelData().get("HIRE_DATE_CALCULATE_NO_OF_DAYS")));
            select_details_on_hire_page(currentDt, currentDt, currentDt, currentDt);
            managerHire.manager_Hire_Submit_Button().click();
            Thread.sleep(5000);
            String managerHr = managerHire.applicant_Hire_Message().getText();
            managerHire.manager_Hire_Back_Button().click();

        }catch (Exception e)
        {
            screenshot.getScreenshot("I entered past hire dates and clicked on Submit");
            e.printStackTrace();
        }
    }

    @Then("I entered Gave info greater than job offer date and clicked on Submit")
    public void select_past_date_for_QD_Hire() throws Exception
    {
        try {
            System.out.println("SSN Records is Hiring : " + getExcelData().get("SSN"));

            managerHire.hire_Button().click();
            String GaveDt = addSubtractfromCurrentDate(Integer.valueOf(getExcelData().get("HIRE_DATE_CALCULATE_NO_OF_DAYS")));
            String currentDt = addSubtractfromCurrentDate(0);

            select_details_on_hire_page(GaveDt, currentDt, currentDt, currentDt);
            managerHire.manager_Hire_Submit_Button().click();
            Thread.sleep(5000);
            String managerHr = managerHire.applicant_Hire_Message().getText();
            managerHire.manager_Hire_Back_Button().click();

        }catch (Exception e)
        {
            screenshot.getScreenshot("I entered past hire dates and clicked on Submit");
            e.printStackTrace();
        }
    }

    public void select_details_on_hire_page(String gavedate,String offerdate, String hiredate,String startdate) throws Exception
    {
        Thread.sleep(5000);
        managerHire.manager_Hire_Gave_Date().click();
        selectCalenderDate(gavedate);
        managerHire.manager_Hire_Offer_Date().click();
        selectCalenderDate(offerdate);
        managerHire.manager_Hire_Date().click();
        selectCalenderDate(hiredate);
        managerHire.manager_Hire_Start_Date().click();
        selectCalenderDate(startdate);
        managerHire.manager_Hire_Hourly_Wages_Dropdown().sendKeys(getExcelData().get("HIRE_WAGE"));
        WebElement jobtype = managerHire.job_Type_Dropdown();
        userAct.selectDropDown(jobtype, getExcelData().get("HIRE_JOB_POSITION"));
    }
}
