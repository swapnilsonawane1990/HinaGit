package adp.tcs.automation.pages;


import adp.tcs.automation.locators.SearchSSNHub;
import adp.tcs.automation.stepsfiles.BaseTempletSteps;

import adp.tcs.automation.utilities.WndowAction;

import org.openqa.selenium.WebElement;
import adp.tcs.automation.locators.MassProcessHub;

import java.util.ArrayList;

/**
 * Created by VermaVik on 4/3/2016.
 */
public class Dol_generate extends BaseTempletSteps {

    WebElement element = null;
   
    WndowAction windowAct = new WndowAction();

    public WebElement search_Operations_Tab_On_Hub(){

        element = getDriver().findElement(MassProcessHub.LABEL_FOR_OPERATIONS);
        return element;
    }

    public WebElement search_PSN_DOL_COM_Operations_On_Hub(){

        element = getDriver().findElement(MassProcessHub.LABEL_PSN_UPDATE_DOL_COM);
        return element;
    }

    public WebElement edit_PSN_DOL_COM_Combo_Page_From_Start_Date_On_Hub(){

        element = getDriver().findElement(MassProcessHub.PSN_DOL_COMBO_PAGE_FROM_START_DATE);
        return element;
    }

    public WebElement edit_PSN_DOL_COM_Combo_Page_To_Start_Date_On_Hub(){

        element = getDriver().findElement(MassProcessHub.PSN_DOL_COMBO_PAGE_TO_START_DATE);
        return element;
    }

    public ArrayList<WebElement> edit_PSN_DOL_COM_Combo_Page_Calender_On_Hub(){

        ArrayList<WebElement> element = (ArrayList<WebElement>) getDriver().findElement(MassProcessHub.PSN_DOL_COMBO_PAGE_CALENDER);
        return element;
    }

    public WebElement edit_PSN_DOL_COM_Combo_Page_SSN_TextBox_On_Hub(){

        element = getDriver().findElement(MassProcessHub.PSN_DOL_COMBO_PAGE_SSN_TEXTBOX);
        return element;
    }

    public WebElement edit_PSN_DOL_COM_Combo_Page_Button_Count_On_Hub(){

        element = getDriver().findElement(MassProcessHub.PSN_DOL_COMBO_PAGE_COUNT_BUTTON);
        return element;
    }

    public WebElement edit_PSN_DOL_COM_Combo_Page_Button_Update_On_Hub(){

        element = getDriver().findElement(MassProcessHub.PSN_DOL_COMBO_PAGE_UPDATE_BUTTON);
        return element;
    }

    public WebElement edit_PSN_DOL_COM_Combo_Page_Button_Refresh_On_Hub(){

        element = getDriver().findElement(MassProcessHub.PSN_DOL_COMBO_PAGE_REFRESH_BUTTON);
        return element;
    }

    public WebElement edit_PSN_DOL_COM_Combo_Page_PSN_Date_On_Hub(){

        element = getDriver().findElement(MassProcessHub.PSN_DOL_COMBO_PAGE_PSN_DATE);
        return element;
    }

    public WebElement edit_PSN_DOL_COM_Combo_Page_DOL_FORM_DATE_On_Hub(){

        element = getDriver().findElement(MassProcessHub.PSN_DOL_COMBO_PAGE_DOL_FORM_DATE);
        return element;
    }

    public WebElement verify_PSN_DOL_COM_Combo_Page_Process_ID_Number_On_Hub(){

        element = getDriver().findElement(MassProcessHub.PSN_DOL_COMBO_PAGE_PROCESS_ID_NUMBER);
        return element;
    }

    public WebElement click_PSN_DOL_COM_Combo_Page_Download_Link_On_Hub(){

        element = getDriver().findElement(MassProcessHub.PSN_DOL_COMBO_PAGE_DOWNLOAD_LINK);
        return element;
    }

    public WebElement click_PSN_DOL_COM_Combo_Page_Download_PSN_XLS_Report_Link_On_Hub(){

        element = getDriver().findElement(MassProcessHub.PSN_DOL_COMBO_PAGE_DOWNLOAD_PSN_XLS_REPORT);
        return element;
    }

    public WebElement click_PSN_DOL_COM_Combo_Page_Download_PSN_PDF_Report_Link_On_Hub(){

        element = getDriver().findElement(MassProcessHub.PSN_DOL_COMBO_PAGE_DOWNLOAD_PSN_PDF_REPORT);
        return element;
    }

    public WebElement click_PSN_DOL_COM_Combo_Page_Download_Free_State_PDF_Report_Link_On_Hub(){

        element = getDriver().findElement(MassProcessHub.PSN_DOL_COMBO_PAGE_DOWNLOAD_FREE_STATE_PDF_REPORT);
        return element;
    }

    public WebElement click_PSN_DOL_COM_Combo_Page_Download_DOL_Form_Zip_Link_On_Hub(){

        element = getDriver().findElement(MassProcessHub.PSN_DOL_COMBO_PAGE_DOWNLOAD_DOL_FORMS_ZIP);
        return element;
    }

    public WebElement click_PSN_DOL_COM_Combo_Page_Action_Label_On_Hub(){

        element = getDriver().findElement(MassProcessHub.PSN_DOL_COMBO_PAGE_ACTION_LABEL);
        return element;
    }

    public WebElement click_PSN_DOL_COM_Combo_Close_Download_PopUp_On_Hub(){

        element = getDriver().findElement(MassProcessHub.PSN_DOL_COMBO_PAGE_CLOSE_DOWNLOAD_POP_UP);
        return element;
    }
    
    public WebElement check_POPOVER_POPUP(){

        element = getDriver().findElement(MassProcessHub.POPOVER_POPUP);
        return element;
    }

}
