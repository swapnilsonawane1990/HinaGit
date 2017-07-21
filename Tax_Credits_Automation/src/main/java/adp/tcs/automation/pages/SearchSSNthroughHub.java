package adp.tcs.automation.pages;

import adp.tcs.automation.locators.SearchSSNHub;
import adp.tcs.automation.stepsfiles.BaseTempletSteps;
import adp.tcs.automation.utilities.WndowAction;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/**
 * Created by BhuteSac on 4/3/2016.
 */
public class SearchSSNthroughHub extends BaseTempletSteps {

    WebElement element = null;
    
    WndowAction windowAct = new WndowAction();

    public WebElement Search_SSN_Process_Tab(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_PROCESS_TAB);
        return element;

    }

    public WebElement Search_SSN_Process_Tax_Credit_Tab(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_PROCESS_TAX_CREDIT_TAB);
        return element;

    }

    public WebElement Search_SSN_Process_Tax_Credit_Operation_Tab(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_PROCESS_TAX_CREDIT_OPERATIONS_TAB);
        return element;

    }

    public WebElement Search_SSN_The_Hub_Link(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_THE_HUB_LINK);
        return element;

    }

    public WebElement Search_SSN_The_InputBox(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_INPUTBOX);
        return element;

    }

    public WebElement Search_SSN_The_SearchButton(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_SEARCH_BUTTON);
        return element;

    }

    public WebElement Search_SSN_The_SearchResult(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_SEARCH_RESULT_TEXT);
        return element;

    }
    public WebElement Search_SSN_Reset_Button(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_RESET_BUTTON);
        return element;

    }
    public WebElement Search_SSN_Export_To_Excel_Button(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_EXPORT_TO_EXCEL_BUTTON);
        return element;

    }

    public WebElement Search_SSN_Reset_Check(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_RESET_CHECK);
        return element;

    }

    public WebElement advance_Search_Client_TextBox(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_SHOW_ADVANCE_SEARCH_CLIENT_TEXTBOX);
        return element;

    }
    public WebElement advance_Search_Company_TextBox(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_SHOW_ADVANCE_SEARCH_COMPANY_TEXTBOX);
        return element;

    }
    public WebElement advance_Search_CreatedBy_TextBox(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_SHOW_ADVANCE_SEARCH_CREATEDBY_TEXTBOX);
        return element;

    }
    public WebElement advance_Search_HireDate_TextBox(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_SHOW_ADVANCE_SEARCH_HIREDATE_TEXTBOX);
        return element;

    }
    public WebElement advance_Search_Link(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_SHOW_ADVANCE_SEARCH_LINK);
        return element;

    }
    public WebElement advance_Search_Retro_Project_Dropdown(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_SHOW_ADVANCE_SEARCH_RETRO_PROJECT_DROPDOWN);
        return element;

    }
    public WebElement advance_Search_Screened_Date_From(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_SHOW_ADVANCE_SEARCH_SCREENED_DATEFROM_TEXTBOX);
        return element;

    }
    public WebElement advance_Search_Screened_Date_To(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_SHOW_ADVANCE_SEARCH_SCREENED_DATETO_TEXTBOX);
        return element;

    }
    public WebElement advance_Search_Button(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_SHOW_ADVANCE_SEARCH_SEARCH_BUTTON);
        return element;

    }
    public WebElement advance_Search_Work_Start_From(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_SHOW_ADVANCE_SEARCH_WORKSTARTFROM_TEXTBOX);
        return element;

    }
    public WebElement advance_Search_Work_Start_To(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_SHOW_ADVANCE_SEARCH_WORKSTARTTO_TEXTBOX);
        return element;

    }
    public WebElement search_SSN_Home_Menu(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_HOME_PAGE);
        return element;
    }

    public WebElement search_SSN_Company_Result(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_SHOW_ADVANCE_COMPANY_RESULT);
        return element;
    }



    public WebElement search_SSN_Client_Autopop(){

        element = getDriver().findElement(SearchSSNHub.SEARCH_SSN_SHOW_ADVANCE_CLIENTNAME_AUTOPOP);
        return element;
    }

    public WebElement search_SSN_Hide_Advance_Search(){

        element = getDriver().findElement(SearchSSNHub. SEARCH_SSN_SHOW_HIDE_ADVANCE_SEARCH);
        return element;
    }


    public WebElement search_SSN_Area_Dropdown(){

        element = getDriver().findElement(SearchSSNHub. SEARCH_SSN_SHOW_AREA_DROPDOWN);
        return element;
    }


    public WebElement search_SSN_Area_Dropdown_WOTC_Value(){

        element = getDriver().findElement(SearchSSNHub. SEARCH_SSN_SHOW_ADVANCE_AREA_DROPDOWN_WOTC_VALUE);
        return element;
    }

    public WebElement search_SSN_Area_Dropdown_CA_Value(){

        element = getDriver().findElement(SearchSSNHub. SEARCH_SSN_SHOW_ADVANCE_AREA_DROPDOWN_CA_VALUE);
        return element;
    }
    public WebElement search_SSN_Area_Dropdown_POH_Value(){

        element = getDriver().findElement(SearchSSNHub. SEARCH_SSN_SHOW_ADVANCE_AREA_DROPDOWN_POH_VALUE);
        return element;
    }

    public WebElement search_SSN_Area_Actual_Area_Result(){

        element = getDriver().findElement(SearchSSNHub. SEARCH_SSN_SHOW_ADVANCE_AREA_RESULT);
        return element;
    }



    public WebElement search_SSN_Application_Staus_Dropdown(){

        element = getDriver().findElement(SearchSSNHub. SEARCH_SSN_SHOW_ADVANCE_SEARCH_APPLICATION_STATUS);
        return element;
    }



    public WebElement search_SSN_Application_Hire_Date_Edit_Page(){

        element = getDriver().findElement(SearchSSNHub. SEARCH_SSN_HIRE_DATE_EDIT_PAGE);
        return element;
    }


    public WebElement search_SSN_Screened_Eligi(){

        element = getDriver().findElement(SearchSSNHub. SEARCH_SSN_ADVANCE_SEARCH_HIRED_ELIG_REC);
        return element;
    }
    public WebElement search_SSN_Screened_Ineligi(){

        element = getDriver().findElement(SearchSSNHub. SEARCH_SSN_ADVANCE_SEARCH_SCREENED_INELIG_REC);
        return element;
    }

    public ArrayList<WebElement> search_SSN_Screened_Date_From(){

        ArrayList<WebElement> element = (ArrayList<WebElement>) getDriver().findElements(SearchSSNHub. SEARCH_SSN_ADVANCE_SEARCH_SCREENING_DATE_FROM);
        return element;
    }
    public ArrayList<WebElement> search_SSN_Screened_Date_To(){

        ArrayList<WebElement> element = (ArrayList<WebElement>) getDriver().findElements(SearchSSNHub. SEARCH_SSN_ADVANCE_SEARCH_SCREENING_TO);
        return element;
    }

    public WebElement search_SSN_Screened_Date(){

        element = getDriver().findElement(SearchSSNHub. SEARCH_SSN_ADVANCE_SEARCH_SCREENING_DATE);
        return element;
    }



    public WebElement search_SSN_Screening_date_edit_page(){

        element = getDriver().findElement(SearchSSNHub. SEARCH_SSN_ADVANCE_SEARCH_SCREENING_DATE_ON_EDIT);
        return element;
    }



    public WebElement search_SSN_Hire_date_edit_page(){

        element = getDriver().findElement(SearchSSNHub. SEARCH_SSN_ADVANCE_SEARCH_HIRE_DATE_ON_EDIT);
        return element;
    }



    public WebElement search_SSN_Confirmation_TextBox(){

        element = getDriver().findElement(SearchSSNHub. SEARCH_SSN_ADVANCE_SEARCH_CONFIRMATION_NUM_TEXTBOX);
        return element;
    }


    public WebElement search_SSN_Confirmation_Edit_Page(){

        element = getDriver().findElement(SearchSSNHub. SEARCH_SSN_CONFIRMATION_NUM_EDIT_PAGE);
        return element;
    }



    public WebElement search_SSN_WorkStart_Edit_Page(){

        element = getDriver().findElement(SearchSSNHub. SEARCH_SSN_ADVANCE_SEARCH_WORK_DATE_ON_EDIT);
        return element;
    }



    public WebElement search_SSN_Date_Prev_Month_Button(){

        element = getDriver().findElement(SearchSSNHub. SEARCH_SSN_DATE_PICKER_PREV_BUTTON);
        return element;
    }


    public WebElement search_SSN_Next_Button(){

        element = getDriver().findElement(SearchSSNHub. SEARCH_SSN_NEXT_BUTTON);
        return element;
    }
    
    public WebElement hub_SEARCH_RESULT_HEADER(){
        element = getDriver().findElement(SearchSSNHub.HUB_SEARCH_RESULT_HEADER);
        return element;
    }
    
    public WebElement HUB_SEARCH_DEATILS_NAME(){
        element = getDriver().findElement(SearchSSNHub.HUB_SEARCH_DEATILS_NAME);
        return element;
    }

    public WebElement CAPS_QA_ENVIRONEMT_Operation_Tab_Chg(){
        WebElement element = getDriver().findElement(SearchSSNHub.SELECT_OPERATION_TAB);
        return element;
    }
    public WebElement CAPS_QA_Hub_New_Link(){
        WebElement element = getDriver().findElement(SearchSSNHub.THE_HUB_LINK);
        return element;
    }


    public void searchSSNnumber(String ssnNumber) throws InterruptedException {
        navigateBackOffice();
        Search_SSN_The_InputBox().sendKeys(ssnNumber);
        Search_SSN_The_SearchButton().click();
        sleep(2000);
        if (loadPropValues("envName").equalsIgnoreCase("Fit2")) {
            int rowcount = getCount(SearchSSNHub.HUB_SEARCH_RESULT_CONST_PATH);
            for (int i = 0; i < 60; i++) {
                if (rowcount > 0) {
                    break;
                } else {
                    sleep(2000);
                }

            }
        }
    }

    
    public void navigateBackOffice() throws InterruptedException {
        sleep(2000);
        waitForLoad();
        explicitWaitForElement(SearchSSNHub.SELECT_OPERATION_TAB,65);
        CAPS_QA_ENVIRONEMT_Operation_Tab_Chg().click();
        sleep(2000);
        explicitWaitForElement(SearchSSNHub.THE_HUB_LINK,65);        
        sleep(2000);
        windowAct.switchtoMultiChildWindow(CAPS_QA_Hub_New_Link());
        explicitWaitForElement(SearchSSNHub.SEARCH_SSN_INPUTBOX,65);
        sleep(2000);
    }

    
   /* // functions

    public void searchSSNnumber(String ssnNumber) throws InterruptedException {

        Thread.sleep(3000);
        waitForLoad();
        Search_SSN_Process_Tab().click();
        Thread.sleep(2000);
        Search_SSN_Process_Tax_Credit_Tab().click();
        Thread.sleep(2000);
        Search_SSN_Process_Tax_Credit_Operation_Tab().click();
        Thread.sleep(2000);

        sleep(2000);
        explicitWaitForElement(SearchSSNHub.SEARCH_SSN_PROCESS_TAB,65);
        waitForLoad();
        Search_SSN_Process_Tab().click();
        sleep(2000);
        Search_SSN_Process_Tax_Credit_Tab().click();
        sleep(2000);
        Search_SSN_Process_Tax_Credit_Operation_Tab().click();
        sleep(2000);

        explicitWaitForElement(SearchSSNHub.SEARCH_SSN_THE_HUB_LINK,65);
        Thread.sleep(1000);
        WebElement hubLink = Search_SSN_The_Hub_Link();
>>>>>>> 7c5ef346ae5c83d9028c531167d07fd09ba31349
        Thread.sleep(2000);
        windowAct.switchtoMultiChildWindow(CAPS_QA_Hub_New_Link());
        explicitWaitForElement(SearchSSNHub.SEARCH_SSN_INPUTBOX,65);
<<<<<<< HEAD
        sleep(2000);
    }
=======
        Search_SSN_The_InputBox().sendKeys(ssnNumber);
        Search_SSN_The_SearchButton().click();
    }*/


}
