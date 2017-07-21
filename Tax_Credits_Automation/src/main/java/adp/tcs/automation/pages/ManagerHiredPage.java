package adp.tcs.automation.pages;

import adp.tcs.automation.locators.ManagerHire;
import adp.tcs.automation.stepsfiles.BaseTempletSteps;

import org.openqa.selenium.WebElement;

/**
 * Created by bhutesac on 7/21/2016.
 */
public class ManagerHiredPage extends BaseTempletSteps {

    private WebElement element = null;

    public WebElement process_Tab_For_Manager_Hire(){
        element = getDriver().findElement(ManagerHire.PROCESS_TAB_FOR_MANAGER_HIRE);
        return element;
    }
    public WebElement tax_Credit_Tab_For_Manager_Hire(){
        element = getDriver().findElement(ManagerHire.TAX_CREDIT_TAB_FOR_MANAGER_HIRE);
        return element;
    }

    public WebElement hiring_Complience_Tab_For_Manager_Hire(){
        element = getDriver().findElement(ManagerHire.HIRING_COMPLIANCE_TAB_FOR_MANAGER_HIRE);
        return element;
    }

    public WebElement search_SSN_Manager_Hire_Textbox(){
        element = getDriver().findElement(ManagerHire.SSN_SEARCH_MANAGER_HIRE_TEXTBOX);
        return element;
    }

    public WebElement search_SSN_Manager_Hire_Button(){
        element = getDriver().findElement(ManagerHire.SSN_SEARCH_MANAGER_HIRE_BUTTON);
        return element;
    }

    public WebElement hire_Button(){
        element = getDriver().findElement(ManagerHire.MANAGER_HIRE_BUTTON);
        return element;
    }
    
    public WebElement job_Type_Dropdown(){
        element = getDriver().findElement(ManagerHire.MANAGER_HIRE_JOB_TYPE_DROPDOWN);
        return element;
    }

    public WebElement manager_Hire_Hourly_Wages_Dropdown(){
        element = getDriver().findElement(ManagerHire.MANAGER_HIRE_HOURLY_WAGES_DROPDOWN);
        return element;
    }

    public WebElement manager_Hire_Submit_Button(){
        element = getDriver().findElement(ManagerHire.MANAGER_HIRE_SUBMIT_BUTTON);
        return element;
    }

    public WebElement applicant_Hire_Message(){
        element = getDriver().findElement(ManagerHire.APPLICANT_HIRE_MESSAGE);
        return element;
    }
    public WebElement manager_Hire_Back_Button(){
        element = getDriver().findElement(ManagerHire.MANAGER_HIRE_BACK_BUTTON);
        return element;
    }

    public WebElement manager_Hire_Logout_Button(){
        element = getDriver().findElement(ManagerHire.MANAGER_HIRE_LOGOUT_BUTTON);
        return element;
    }
    public WebElement manager_Hire_Logout_OK_Button(){
        element = getDriver().findElement(ManagerHire.MANAGER_HIRE_LOGOUT_OK_BUTTON);
        return element;
    }


    public WebElement manager_Hire_Gave_Date(){
        element = getDriver().findElement(ManagerHire.MANAGER_HIRE_GAVE_DATE);
        return element;
    }

    public WebElement manager_Hire_Offer_Date(){
        element = getDriver().findElement(ManagerHire.MANAGER_HIRE_OFFER_DATE);
        return element;
    }

    public WebElement manager_Hire_Date(){
        element = getDriver().findElement(ManagerHire.MANAGER_HIRE_HIRE_DATE);
        return element;
    }

    public WebElement manager_Hire_Start_Date(){
        element = getDriver().findElement(ManagerHire.MANAGER_HIRE_START_DATE);
        return element;
    }


    public WebElement manager_Hire_Application_Status_Dropdown(){
        element = getDriver().findElement(ManagerHire.MANAGER_HIRE_APPLICATION_STATUS);
        return element;
    }

    public WebElement manager_Update_Hire_Button(){
        element = getDriver().findElement(ManagerHire.MANAGER_UPDATE_HIRE_BUTTON);
        return element;
    }
    public WebElement manager_Gave_Info_Date(){
        element = getDriver().findElement(ManagerHire.MANAGER_GAVE_INFO_DATE);
        return element;
    }
    public WebElement manager_Hire_Log_Out_Button(){
        element = getDriver().findElement(ManagerHire.MANAGER_LOGOUT_BUTTON);
        return element;
    }
    
    public WebElement MANAGER_LOGOUT_OK_BUTTON(){
        element = getDriver().findElement(ManagerHire.MANAGER_LOGOUT_OK_BUTTON);
        return element;
    }

    public WebElement MANAGER_SMART_COMPLIANCE_BUTTON(){
        element = getDriver().findElement(ManagerHire.MANAGER_SMART_COMPLIANCE_BUTTON);
        return element;
    }
    public WebElement MANAGER_SMART_COMPLIANCE_TOUR_SKIP_LINK(){
        element = getDriver().findElement(ManagerHire.MANAGER_SMART_COMPLIANCE_TOUR_SKIP_LINK);
        return element;
    }
    public WebElement MANAGER_SMART_COMPLIANCE_PROCESS_TAB(){
        element = getDriver().findElement(ManagerHire.MANAGER_SMART_COMPLIANCE_PROCESS_TAB);
        return element;
    }

    public WebElement MANAGER_SMART_COMPLIANCE_TAX_SERVICE_SUBTAB(){
        element = getDriver().findElement(ManagerHire.MANAGER_SMART_COMPLIANCE_TAX_SERVICE_SUBTAB);
        return element;
    }
    public WebElement MANAGER_SMART_COMPLIANCE_HIRE_PAGE(){
        element = getDriver().findElement(ManagerHire.MANAGER_SMART_COMPLIANCE_HIRE_PAGE);
        return element;
    }

    public WebElement MANAGER_SMART_COMPLIANCE_HIRING_COMPLIANCE(){
        element = getDriver().findElement(ManagerHire.MANAGER_SMART_COMPLIANCE_HIRING_COMPLIANCE);
        return element;
    }
    public WebElement MANAGER_SMART_COMPLIANCE_SEARCH_TEXTBOX(){
        element = getDriver().findElement(ManagerHire.MANAGER_SMART_COMPLIANCE_SEARCH_TEXTBOX);
        return element;
    }

    public WebElement client_User_Avatar_Link(){
        element = getDriver().findElement(ManagerHire.CLIENT_USER_AVATAR_LINK);
        return element;
    }
    public WebElement client_Logout_Btn(){
        element = getDriver().findElement(ManagerHire.CLIENT_LOGOUT_BUTTON);
        return element;
    }



}
