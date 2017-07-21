package adp.tcs.automation.pages;

import adp.tcs.automation.locators.StateExports;
import adp.tcs.automation.stepsfiles.BaseTempletSteps;

import org.openqa.selenium.WebElement;

/**
 * Created by BhuteSac on 7/26/2016.
 */
public class StateExportPage extends BaseTempletSteps{

    private WebElement element = null;

    public WebElement state_Export_SubTab(){

        element = getDriver().findElement(StateExports.OPERATION_STATE_EXPORT_SUBTAB);
        return element;
    }

    public WebElement state_Export_State_Dropdown(){

        element = getDriver().findElement(StateExports.OPERATION_STATE_EXPORT_STATE_DROPDOWN);
        return element;
    }
    public WebElement state_Export_PSN_From_Date(){

        element = getDriver().findElement(StateExports.OPERATION_STATE_EXPORT_PSN_FROM_DATE);
        return element;
    }
    public WebElement state_Export_PSN_To_Date(){

        element = getDriver().findElement(StateExports.OPERATION_STATE_EXPORT_PSN_TO_DATE);
        return element;
    }
    public WebElement state_Export_Give_Info_From_Date(){

        element = getDriver().findElement(StateExports.OPERATION_STATE_EXPORT_GIVE_INFO_FROM_DATE);
        return element;
    }
    public WebElement state_Export_Offer_From_Dte(){

        element = getDriver().findElement(StateExports.OPERATION_STATE_EXPORT_OFFER_FROM_DATE);
        return element;
    }

    public WebElement state_Export_Hire_from_Date(){

        element = getDriver().findElement(StateExports.OPERATION_STATE_EXPORT_HIRE_FROM_DATE);
        return element;
    }

    public WebElement state_Export_Start_From_Date(){

        element = getDriver().findElement(StateExports.OPERATION_STATE_EXPORT_START_FROM_DATE);
        return element;
    }
    public WebElement state_Export_Give_Info_Date(){

        element = getDriver().findElement(StateExports.OPERATION_STATE_EXPORT_GIVE_INFO_TO_DATE);
        return element;
    }
    public WebElement state_Export_Offer_To_Date(){

        element = getDriver().findElement(StateExports.OPERATION_STATE_EXPORT_OFFER_TO_DATE);
        return element;
    }
    public WebElement state_Export_Hire_To_Date(){

        element = getDriver().findElement(StateExports.OPERATION_STATE_EXPORT_HIRE_TO_DATE);
        return element;
    }
    public WebElement state_Export_Start_To_Date(){

        element = getDriver().findElement(StateExports.OPERATION_STATE_EXPORT_START_TO_DATE);
        return element;
    }

    public WebElement state_Export_Export_Button(){

        element = getDriver().findElement(StateExports.OPERATION_STATE_EXPORT_EXPORT_BUTTON);
        return element;
    }
    public WebElement state_Export_Process_Id_Link(){

        element = getDriver().findElement(StateExports.OPERATION_STATE_EXPORT_PROCESS_REQUEST_ID_LINK);
        return element;
    }
    public WebElement state_Export_Action_Download(){

        element = getDriver().findElement(StateExports.OPERATION_STATE_EXPORT_ACTION_DOWNLOAD);
        return element;
    }

    public WebElement state_Export_Zip_File_Download_Link(){

        element = getDriver().findElement(StateExports.OPERATION_STATE_EXPORT_ZIP_FILE_DOWNLOAD_LINK);
        return element;
    }
    public WebElement state_Export_Refesh_Button(){

        element = getDriver().findElement(StateExports.OPERATION_STATE_EXPORT_REFRESH_BUTTON);
        return element;
    }
    public WebElement state_Export_Processing_Sign(){

        element = getDriver().findElement(StateExports.OPERATION_STATE_EXPORT_PROCESSING_SIGN);
        return element;
    }
}
