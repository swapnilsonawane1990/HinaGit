package adp.tcs.automation.pages;

import adp.tcs.automation.locators.CAKeyIn_ScreeningLocators;
import adp.tcs.automation.stepsfiles.BaseTempletSteps;
import org.openqa.selenium.WebElement;

/**
 * Created by garghina on 10/6/2016.
 */
public class CAKeyIn_Screening extends BaseTempletSteps {
    CAKeyIn_ScreeningLocators caKeyIn_screeningLocators=new CAKeyIn_ScreeningLocators();

    public WebElement CAandPOHKeyFromPaper_Link(){
        WebElement element = getDriver().findElement(caKeyIn_screeningLocators.CAandPOHKeyFromPaper_Link);
        return element;
    }
    public WebElement TaxCredits_image(){
        WebElement element = getDriver().findElement(caKeyIn_screeningLocators.TaxCredits_image);
        return element;
    }
    public WebElement CAKeyIn_RadioButton() {
    WebElement element=getDriver().findElement(caKeyIn_screeningLocators.CAKeyIn_RadioButton);
        return element;
    }

    public WebElement CompanyName_Field(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.CompanyName_Field);
        return element;
    }
    public WebElement Company_Name_Dropdown(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.Company_Name_Dropdown);
        return element;
    }
    public WebElement Unit_Field(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.Unit_Field);
        return element;
    }
    public WebElement StartScreening_Button(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.StartScreening_Button);
        return element;
    }
    public WebElement SSN_Field(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.SSN_Field);
        return element;
    }
    public WebElement Hire_Date(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.Hire_Date);
        return element;
    }
    public WebElement Credit_Name_click(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.Credit_Name_click);
        return element;
    }
    public WebElement CAAddress_Field(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.CAAddress_Field);
        return element;
    }
    public WebElement Zipcode_Field(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.Zipcode_Field);
        return element;
    }
    public WebElement CA_State_Forms(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.CA_State_Forms);
        return element;
    }
    public WebElement Continue_Button(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.Continue_Button);
        return element;
    }
    public WebElement CA01_StateForm_CheckBox(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.CA01_StateForm_CheckBox);
        return element;
    }
    public WebElement EDD_ReleaseForm_CheckBox(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.EDD_ReleaseForm_CheckBox);
        return element;
    }
    public WebElement T_4506_CheckBox(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.T_4506_CheckBox);
        return element;
    }
    public WebElement SF_180_CheckBox(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.SF_180_CheckBox);
        return element;
    }
    public WebElement FirstName_Field(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.FirstName_Field);
        return element;
    }
    public WebElement Lastname_Field(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.Lastname_Field);
        return element;
    }
    public WebElement Address_Field(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.Address_Field);
        return element;
    }
    public WebElement ZipCode_Field(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.ZipCode_Field);
        return element;
    }
    public WebElement Military_TargetGroup_Checkbox(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.Military_TargetGroup_Checkbox);
        return element;
    }
    public WebElement EarnedIncomeCredit_TargetGroup_Checkbox(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.EarnedIncomeCredit_TargetGroup_Checkbox);
        return element;
    }
    public WebElement Felony_TargetGroup_Checkbox(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.Felony_TargetGroup_Checkbox);
        return element;
    }
    public WebElement GeneralAssistance_TargetGroup_Checkbox(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.GeneralAssistance_TargetGroup_Checkbox);
        return element;
    }
    public WebElement UnemployedFulltimeStudent_TargetGroup_Checkbox(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.UnemployedFulltimeStudent_TargetGroup_Checkbox);
        return element;
    }
    public WebElement ScreeningCompleted_Message(){
        WebElement element=getDriver().findElement(caKeyIn_screeningLocators.ScreeningCompleted_Message);
        return element;
    }
}
