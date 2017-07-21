package adp.tcs.automation.stepsfiles;

import adp.tcs.automation.locators.MassProcessHub;

import adp.tcs.automation.pages.Dol_generate;

import adp.tcs.automation.utilities.TakeScreenshotAction;
import adp.tcs.automation.utilities.UserAction;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebElement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by VermaVik on 7/2/2016.
 */
public class Generate_DOL_Files_Steps extends BaseTempletSteps {
   
    private Dol_generate dolgenerate = new Dol_generate(); 
    private TakeScreenshotAction screenshot = new TakeScreenshotAction();   
    private UserAction userAction = new UserAction();   
    private Manager_Hire_Steps mgr_Hire = new Manager_Hire_Steps();
    public String expectedSSN;
    public String fromDate;
    public String todate;
    public String hireDt;
    public String workSrtDate;
    public String workEdDate;
    DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssZ");
    Date date = new Date();

    @Given("User Navigate To the PSN Update Generate DOL and COM Page")
    public void navigateEsignMassProcess() throws Exception {
    	   try {
    		  Thread.sleep(2000);
    	      verifyTest("User Navigate To the PSN Update Generate DOL and COM Page");
    	      Thread.sleep(2000);
    	      waitForLoad();
    	           dolgenerate.search_Operations_Tab_On_Hub().click();
    	           sleep(2000);
    	           dolgenerate.search_PSN_DOL_COM_Operations_On_Hub().click();
    	           sleep(2000);
    	           if(!isDisplayed(dolgenerate.edit_PSN_DOL_COM_Combo_Page_Button_Count_On_Hub())){
    	               for(int i = 1; i >= 20; i++){
    	                   dolgenerate.search_Operations_Tab_On_Hub().click();
    	                   sleep(2000);
    	                   dolgenerate.search_PSN_DOL_COM_Operations_On_Hub().click();
    	                   sleep(2000);
    	                   if(isDisplayed(dolgenerate.edit_PSN_DOL_COM_Combo_Page_Button_Count_On_Hub())){
    	                       break;
    	                   }
    	               }
    	           }
    	      /*Actions action = new Actions(driver);
    	      action.moveToElement(dolgenerate.search_Operations_Tab_On_Hub())
    	            .moveToElement(dolgenerate.search_PSN_DOL_COM_Operations_On_Hub()).click().build().perform();*/
    	      Thread.sleep(1000);
    	      dolgenerate.click_PSN_DOL_COM_Combo_Page_Action_Label_On_Hub().click();
    	      Thread.sleep(2000);
    	   } catch (Exception e) {
    	      screenshot.getScreenshot("advanceSearchStartDateFromTo");
    	      verifyTest("User Navigate To the PSN Update Generate DOL and COM Page", false);
    	      e.printStackTrace();

    	   }
    	}


    @When("User Search <SSNNumber> in PSN Update Genrate DOL and COM and Click on Count Button")
    public void searchSSNOnEsignMassProcessPage() throws Exception {
        try {
            verifyTest("User Search <SSNNumber> in PSN Update Genrate DOL and COM and Click on Count Button");
            String currentDate = dateFormat.format(date);
            String currentDt = currentDate.substring(4,6);
//            Thread.sleep(1000);
//            dolgenerate.edit_PSN_DOL_COM_Combo_Page_From_Start_Date_On_Hub().click();
//            Thread.sleep(1000);
//            //***********************THIS CODE WILL ENTER FROM DATE VALUE IN CALENDER *****************************************
            //ArrayList<WebElement> fromdate = dolgenerate.edit_PSN_DOL_COM_Combo_Page_Calender_On_Hub();
//            ArrayList<WebElement> fromdate = searchSSNumber.search_SSN_Screened_Date_From();
//            int from_date_count = fromdate.size();
//
//            for (int i = 0; i < from_date_count; i++) {
//                String number = fromdate.get(i).getText();
//                System.out.println(number);
//                if (searchDateFrom.equals(number)) {
//                    fromdate.get(i).click();
//                    break;
//                }
//            }

            //***********************THIS CODE WILL ENTER TO DATE VALUE IN CALENDER *****************************************
//            dolgenerate.edit_PSN_DOL_COM_Combo_Page_To_Start_Date_On_Hub().click();
//            Thread.sleep(1000);
//            ArrayList<WebElement> todates = searchSSNumber.search_SSN_Screened_Date_From();
//            int to_date_count = fromdate.size();
//
//            for (int i = 0; i < to_date_count; i++) {
//                String number1 = todates.get(i).getText();
//                System.out.println(number1);
//                if (searchDateTo.equals(number1)) {
//                    todates.get(i).click();
//                    break;
//                }
//            }

            //       ArrayList<WebElement> todates =dolgenerate.edit_PSN_DOL_COM_Combo_Page_Calender_On_Hub();
            /*
             * ==========Edited by Saurab on 11/4/2016 ===========
            */
            if (getExcelData().get("HIRE_CURRENT_DATE").equalsIgnoreCase("YES")) 
			{
				fromDate = dolgenerate.edit_PSN_DOL_COM_Combo_Page_From_Start_Date_On_Hub().getAttribute("value");
			}
			else
			{ 
				if(getExcelData().get("HIRE_START_DATE") != ""){
					//this.operations_Esign_Mass_Print_Start_From_Date_field().clear();
					dolgenerate.edit_PSN_DOL_COM_Combo_Page_From_Start_Date_On_Hub().clear();
					selectCalenderDate(getExcelData().get("HIRE_START_DATE"));
					fromDate = dolgenerate.edit_PSN_DOL_COM_Combo_Page_From_Start_Date_On_Hub().getAttribute("value");
				}

			}
            /*
             * ================
            */
            
            todate = dolgenerate.edit_PSN_DOL_COM_Combo_Page_To_Start_Date_On_Hub().getAttribute("value");
            dolgenerate.edit_PSN_DOL_COM_Combo_Page_SSN_TextBox_On_Hub().sendKeys(getExcelData().get("SSN"));
            Thread.sleep(2000);
            WebElement btncount = dolgenerate.edit_PSN_DOL_COM_Combo_Page_Button_Count_On_Hub();
//            WebElement empInfo =dolgenerate.Search_SSN_The_SearchResult();
            userAction.doubleClick(btncount);
            Thread.sleep(5000);

            //***********************************THIS CODE WILL ENTER THE PSN DATE *****************************************
            dolgenerate.edit_PSN_DOL_COM_Combo_Page_PSN_Date_On_Hub().click();
            Thread.sleep(2000);
            mgr_Hire.selectDateCurrentMonth(currentDt);


            //***********************************THIS CODE WILL ENTER THE DOL DATE *****************************************
            dolgenerate.edit_PSN_DOL_COM_Combo_Page_DOL_FORM_DATE_On_Hub().click();
            Thread.sleep(2000);
            mgr_Hire.selectDateCurrentMonth(currentDt);

            Thread.sleep(2000);
            dolgenerate.edit_PSN_DOL_COM_Combo_Page_Button_Update_On_Hub().click();
            Thread.sleep(30000);
            dolgenerate.verify_PSN_DOL_COM_Combo_Page_Process_ID_Number_On_Hub().click();
            Thread.sleep(2000);
            dolgenerate.click_PSN_DOL_COM_Combo_Page_Download_Link_On_Hub().click();

            Thread.sleep(3000);
            dolgenerate.click_PSN_DOL_COM_Combo_Page_Download_PSN_XLS_Report_Link_On_Hub().click();
            Thread.sleep(5000);
            sleep(2000);
           if(!isDisplayed(MassProcessHub.PSN_DOL_COMBO_PAGE_DOWNLOAD_PSN_XLS_REPORT))
           {
             dolgenerate.click_PSN_DOL_COM_Combo_Page_Download_Link_On_Hub().click();
               sleep(2000);
           }

            dolgenerate.click_PSN_DOL_COM_Combo_Page_Download_PSN_PDF_Report_Link_On_Hub().click();
            Thread.sleep(5000);

            if(!isDisplayed(MassProcessHub.PSN_DOL_COMBO_PAGE_DOWNLOAD_PSN_XLS_REPORT))
            {
                dolgenerate.click_PSN_DOL_COM_Combo_Page_Download_Link_On_Hub().click();
                sleep(2000);
            }

            dolgenerate.click_PSN_DOL_COM_Combo_Page_Download_Free_State_PDF_Report_Link_On_Hub().click();
            Thread.sleep(5000);

            if(!isDisplayed(MassProcessHub.PSN_DOL_COMBO_PAGE_DOWNLOAD_PSN_XLS_REPORT))
            {
                dolgenerate.click_PSN_DOL_COM_Combo_Page_Download_Link_On_Hub().click();
                sleep(2000);
            }

            dolgenerate.click_PSN_DOL_COM_Combo_Page_Download_DOL_Form_Zip_Link_On_Hub().click();
            Thread.sleep(5000);

            dolgenerate.click_PSN_DOL_COM_Combo_Close_Download_PopUp_On_Hub().click();
            Thread.sleep(2000);

        } catch (Exception e) {
            screenshot.getScreenshot("advanceSearchStartDateFromTo");
            verifyTest("User Navigate To the PSN Update Generate DOL and COM Page", false);
            e.printStackTrace();
        }

    }
    



@When("User Search <SSNNumber> in PSN Combo and search the <SSNNumber> for Specified Date")
    public void searchSSNOnPSNComboUserSpecificDt() throws Exception {
        try {
            verifyTest("User Search <SSNNumber> in PSN Combo and search the <SSNNumber> for Specified Date");
            String currentDate = dateFormat.format(date);
            String currentDt = currentDate.substring(4,6);



            fromDate = dolgenerate.edit_PSN_DOL_COM_Combo_Page_From_Start_Date_On_Hub().getAttribute("value");
            todate = dolgenerate.edit_PSN_DOL_COM_Combo_Page_To_Start_Date_On_Hub().getAttribute("value");
            dolgenerate.edit_PSN_DOL_COM_Combo_Page_SSN_TextBox_On_Hub().sendKeys(getExcelData().get("SSN"));
            Thread.sleep(2000);
            //

    		String strStartDate = getExcelData().get("HIRE_START_DATE");
    		Thread.sleep(2000);
    		dolgenerate.edit_PSN_DOL_COM_Combo_Page_From_Start_Date_On_Hub().click();
    		// dolgenerate.edit_PSN_DOL_COM_Combo_Page_From_Start_Date_On_Hub().click();
    		Thread.sleep(2000);
    		selectCalenderDate(strStartDate);
    		Thread.sleep(2000);    

            WebElement btncount = dolgenerate.edit_PSN_DOL_COM_Combo_Page_Button_Count_On_Hub();
//            WebElement empInfo =dolgenerate.Search_SSN_The_SearchResult();
            userAction.doubleClick(btncount);
            Thread.sleep(5000);


            //***********************************THIS CODE WILL ENTER THE PSN DATE *****************************************
            dolgenerate.edit_PSN_DOL_COM_Combo_Page_PSN_Date_On_Hub().click();
            Thread.sleep(2000);
            mgr_Hire.selectDateCurrentMonth(currentDt);


            //***********************************THIS CODE WILL ENTER THE DOL DATE *****************************************
            dolgenerate.edit_PSN_DOL_COM_Combo_Page_DOL_FORM_DATE_On_Hub().click();
            Thread.sleep(2000);
            mgr_Hire.selectDateCurrentMonth(currentDt);

            Thread.sleep(2000);
            dolgenerate.edit_PSN_DOL_COM_Combo_Page_Button_Update_On_Hub().click();
            Thread.sleep(10000);
            dolgenerate.verify_PSN_DOL_COM_Combo_Page_Process_ID_Number_On_Hub().click();

            Thread.sleep(2000);
            dolgenerate.click_PSN_DOL_COM_Combo_Page_Download_Link_On_Hub().click();

            if (dolgenerate.edit_PSN_DOL_COM_Combo_Page_Button_Refresh_On_Hub().isEnabled()) {
                //dolgenerate.search_Operations_Tab_On_Hub().click();
                WebElement btncount3 = dolgenerate.edit_PSN_DOL_COM_Combo_Page_Button_Refresh_On_Hub();
                userAction.doubleClick(btncount3);
                Thread.sleep(5000);
            }
            Thread.sleep(1000);
            dolgenerate.click_PSN_DOL_COM_Combo_Page_Download_PSN_XLS_Report_Link_On_Hub().click();
            Thread.sleep(5000);

            dolgenerate.click_PSN_DOL_COM_Combo_Page_Download_PSN_PDF_Report_Link_On_Hub().click();
            Thread.sleep(5000);

            dolgenerate.click_PSN_DOL_COM_Combo_Page_Download_Free_State_PDF_Report_Link_On_Hub().click();
            Thread.sleep(5000);

            dolgenerate.click_PSN_DOL_COM_Combo_Page_Download_DOL_Form_Zip_Link_On_Hub().click();
            Thread.sleep(5000);

            dolgenerate.click_PSN_DOL_COM_Combo_Close_Download_PopUp_On_Hub().click();
            Thread.sleep(2000);

        } catch (Exception e) {
            screenshot.getScreenshot("advanceSearchStartDateFromTo");
            verifyTest("User Navigate To the PSN Combo", false);
            e.printStackTrace();
        }

    }

        
    
    @Then("The status of record <ExpectedSSN> should be changed to K from E")
    public void verifySSNAfterEsignMassProcess() throws Exception {
        try {
            boolean flag = false;
        } catch (Exception e) {
            verifyTest("The status of record <ExpectedSSN> should be changed to K from E", false);
            e.printStackTrace();
        }

    }

}