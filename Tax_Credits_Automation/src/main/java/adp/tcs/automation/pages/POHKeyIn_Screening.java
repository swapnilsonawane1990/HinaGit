package adp.tcs.automation.pages;

import adp.tcs.automation.locators.POHKeyIn_Screening_Locators;
import adp.tcs.automation.locators.POHKeyIn_Screening_Locators;
import adp.tcs.automation.stepsfiles.BaseTempletSteps;
import org.openqa.selenium.WebElement;

/**
 * Created by garghina on 10/10/2016.
 */
public class POHKeyIn_Screening extends BaseTempletSteps {
    POHKeyIn_Screening_Locators PohKeyIn_screening_locators=new POHKeyIn_Screening_Locators();

    public WebElement CAandPOHKeyFromPaper_Link(){
        WebElement element = getDriver().findElement(POHKeyIn_Screening_Locators.CAandPOHKeyFromPaper_Link);
        return element;
    }
    public WebElement TaxCredits_image(){
        WebElement element = getDriver().findElement(POHKeyIn_Screening_Locators.TaxCredits_image);
        return element;
    }
    public WebElement POHKeyIn_RadioButton() {
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.POHKeyIn_RadioButton);
        return element;
    }

    public WebElement CompanyName_Field(){
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.CompanyName_Field);
        return element;
    }
    public WebElement Company_Name_Dropdown(){
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.Company_Name_Dropdown);
        return element;
    }
    public WebElement Unit_Field(){
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.Unit_Field);
        return element;
    }
    public WebElement StartScreening_Button(){
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.StartScreening_Button);
        return element;
    }
    public WebElement SSN_Field(){
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.SSN_Field);
        return element;
    }
    public WebElement Hire_Date(){
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.Hire_Date);
        return element;
    }
    public WebElement Credit_Name_Select(){
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.Credit_Name_Select);
        return element;
    }
    public WebElement POHAddress_Field(){
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.POHAddress_Field);
        return element;
    }
    public WebElement Zipcode_Field(){
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.Zipcode_Field);
        return element;
    }
    public WebElement POH_State_Form_Only(){
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.POH_State_Form_Only);
        return element;
    }
    public WebElement Continue_Button(){
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.Continue_Button);
        return element;
    }
    public WebElement FirstName_Field(){
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.FirstName_Field);
        return element;
    }
    public WebElement Lastname_Field(){
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.Lastname_Field);
        return element;
    }
    public WebElement Address_Field(){
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.Address_Field);
        return element;
    }
    public WebElement ZipCode_Field(){
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.ZipCode_Field);
        return element;
    }
    public WebElement POH_AZ_TANF_TEXT(){
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.POH_AZ_TANF_TEXT);
        return element;
    }
    public WebElement AZ_First_Question(){
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.AZ_First_Question);
        return element;
    }
    public WebElement AZ_Second_question(){
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.AZ_Second_question);
        return element;
    }
    public WebElement AZ_Third_question(){
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.AZ_Third_question);
        return element;
    }
    public WebElement Extra_Info_SSN(){
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.Extra_Info_SSN);
        return element;
    }
    public WebElement Extra_Info_Date(){
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.Extra_Info_Date);
        return element;
    }
    public WebElement Extra_Info_NameAndTelephone(){
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.Extra_Info_NameAndTelephone);
        return element;
    }
    public WebElement ScreeningCompleted_Message(){
        WebElement element=getDriver().findElement(POHKeyIn_Screening_Locators.ScreeningCompleted_Message);
        return element;
    }
}
