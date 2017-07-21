package adp.tcs.automation.pages;

import adp.tcs.automation.stepsfiles.BaseTempletSteps;
import adp.tcs.automation.utilities.WndowAction;
import adp.tcs.automation.locators.EditMoreDetails;

import org.openqa.selenium.WebElement;

/**
 * Created by BhuteSac on 6/7/2016.
 */
public class MoreDetails extends BaseTempletSteps {

    WebElement element = null;
    
    WndowAction windowAct = new WndowAction();


    public WebElement edit_More_Details_Link(){

        element = getDriver().findElement(EditMoreDetails.EDIT_SSN_MORE_DETAILS_LINK);
        return element;
    }

    public WebElement edit_More_Details_Status_dropDown(){

        element = getDriver().findElement(EditMoreDetails.EDIT_SSN_MORE_DETAILS_STATUS_DROPDOWN);
        return element;
    }


    public WebElement edit_More_Details_Status_Select(){

        element = getDriver().findElement(EditMoreDetails.EDIT_SSN_MORE_DETAILS_REVIEW_STATUS);
        return element;
    }

    public WebElement more_Details_Back_Button(){

        element = getDriver().findElement(EditMoreDetails.PERSONAL_INFO_MORE_DETAIL_BACK_BUTON);
        return element;
    }



    public WebElement more_Details_Save_Button(){

        element = getDriver().findElement(EditMoreDetails.PERSONAL_INFO_MORE_DETAIL_SAVE_BUTTON);
        return element;
    }



    public WebElement more_Details_PSN_Update(){

        element = getDriver().findElement(EditMoreDetails.PERSONAL_INFO_MORE_DETAIL_PSN_DATE_EDIT);
        return element;
    }

    public WebElement more_Details_Resubmit_Date(){

        element = getDriver().findElement(EditMoreDetails.PERSONAL_INFO_MORE_DETAIL_RESUBMIT_DATE_EDIT);
        return element;
    }

    public WebElement more_Details_Start_Date(){

        element = getDriver().findElement(EditMoreDetails.PERSONAL_INFO_MORE_DETAIL_START_DATE_EDIT);
        return element;
    }

    public WebElement more_Details_Invalid_Date(){

        element = getDriver().findElement(EditMoreDetails.PERSONAL_INFO_MORE_DETAIL_INVALID_DATE_EDIT);
        return element;
    }


    public WebElement more_Details_Verification_Date(){

        element = getDriver().findElement(EditMoreDetails.PERSONAL_INFO_MORE_DETAIL_VERIFICATION_DATE_EDIT);
        return element;
    }

    public WebElement more_Details_Appeal_sent_Date(){

        element = getDriver().findElement(EditMoreDetails.PERSONAL_INFO_MORE_DETAIL_APPEAL_SENT_DATE_EDIT);
        return element;
    }

    public WebElement more_Details_Denied_Date(){

        element = getDriver().findElement(EditMoreDetails.PERSONAL_INFO_MORE_DETAIL_DENIED_DATE_EDIT);
        return element;
    }

    public WebElement more_Details_Cert_Effective_End_Date(){

        element = getDriver().findElement(EditMoreDetails.PERSONAL_INFO_MORE_DETAIL_CERT_EFFECTIVE_SENT_DATE_EDIT);
        return element;
    }

    public WebElement more_Details_Need_Letter_Date(){

        element = getDriver().findElement(EditMoreDetails.PERSONAL_INFO_MORE_DETAIL_NEED_LETTER_DATE_EDIT);
        return element;
    }


    public WebElement more_Details_Confirmation_PopUp(){

        element = getDriver().findElement(EditMoreDetails.PERSONAL_INFO_MORE_DETAIL_SURE_POPUP_EDIT);
        return element;
    }





}
