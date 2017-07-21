package adp.tcs.automation.pages;

import adp.tcs.automation.locators.CallInScreening;
import adp.tcs.automation.locators.StandAloneSreening;
import adp.tcs.automation.stepsfiles.BaseTempletSteps;
import adp.tcs.automation.utilities.WndowAction;
import org.openqa.selenium.WebElement;

/**
 * Created by BhuteSac on 10/6/2016.
 */
public class StandAlonePage extends BaseTempletSteps {

    WebElement element = null;

    WndowAction windowAct = new WndowAction();
    private CallInScreening callInScreening;



    public WebElement stand_Alone_NAME_DURING_SERIVE(){

        element = getDriver().findElement(StandAloneSreening.STAND_ALONE_NAME_DURING_SERIVE);
        return element;
    }

    public WebElement stand_Alone_BIRTH_PLACE(){

        element = getDriver().findElement(StandAloneSreening.STAND_ALONE_BIRTH_PLACE);
        return element;
    }

    public WebElement STAND_ALONE_BRANCH_SERVICE(){

        element = getDriver().findElement(StandAloneSreening.STAND_ALONE_BRANCH_SERVICE);
        return element;
    }

    public WebElement stand_ALONE_DATE_ENTERED(){

        element = getDriver().findElement(StandAloneSreening.STAND_ALONE_DATE_ENTERED);
        return element;
    }

    public WebElement stand_ALONE_DATE_RESEASED(){

        element = getDriver().findElement(StandAloneSreening.STAND_ALONE_DATE_RESEASED);
        return element;
    }
    public WebElement stand_ALONE_SERVICE_STATUS_SELECT(){

        element = getDriver().findElement(StandAloneSreening.STAND_ALONE_SERVICE_STATUS_SELECT);
        return element;
    }
    public WebElement stand_ALONE_SERVICE_NUMBER(){

        element = getDriver().findElement(StandAloneSreening.STAND_ALONE_SERVICE_NUMBER);
        return element;
    }

    public WebElement sf150_Continue_Button(){

        element = getDriver().findElement(StandAloneSreening.STAND_ALONE_SF150_CONTINUE_BUTTON);
        return element;
    }

    public WebElement stand_ALONE_RESERVE_COMPONAME(){

        element = getDriver().findElement(StandAloneSreening.STAND_ALONE_RESERVE_COMPONAME);
        return element;
    }

    public WebElement stand_ALONE_NATIONAL_GUARD(){

        element = getDriver().findElement(StandAloneSreening.STAND_ALONE_NATIONAL_GUARD);
        return element;
    }

    public WebElement stand_ALONE_RETIRED_FROM_MILITORY(){

        element = getDriver().findElement(StandAloneSreening.STAND_ALONE_RETIRED_FROM_MILITORY);
        return element;
    }



    public void militoryServiceSF180()
    {
        try {
        stand_Alone_NAME_DURING_SERIVE().sendKeys(getExcelData().get("SA_NAME_DURING_SERVICE"));
        stand_Alone_BIRTH_PLACE().sendKeys(getExcelData().get("SA_BIRTH_PLACE"));
        waitForLoad();
        selectDropdown(STAND_ALONE_BRANCH_SERVICE(),getExcelData().get("SA_BRANCH_SERVICE"));
       // stand_ALONE_DATE_ENTERED().sendKeys(getExcelData().get("SA_DATE_ENTERED"));
      //  stand_ALONE_DATE_RESEASED().sendKeys(getExcelData().get("SA_DATE_RESEASED"));
        selectDropdown(stand_ALONE_SERVICE_STATUS_SELECT(),getExcelData().get("SA_SERVICE_STATUS_SELECT"));
        waitForLoad();
        stand_ALONE_SERVICE_NUMBER().sendKeys(getExcelData().get("SA_SERVICE_NUMBER"));
        waitForLoad();
            sf150_Continue_Button().click();
            waitForLoad();
            selectDropdown(stand_ALONE_RESERVE_COMPONAME(),getExcelData().get("RESERVE_COMPONANT"));
            selectDropdown(stand_ALONE_NATIONAL_GUARD(),getExcelData().get("SA_BRANCH_SERVICE"));
            sf150_Continue_Button().click();
            waitForLoad();
            stand_ALONE_RETIRED_FROM_MILITORY().click();
            sf150_Continue_Button().click();
            waitForLoad();
        } catch (Exception e) {
            verifyTest("Faliure in militoryServiceSF180 page",false);
            e.printStackTrace();
        }

    }

}
