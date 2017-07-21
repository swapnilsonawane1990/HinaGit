package adp.tcs.automation.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by garghina on 10/5/2016.
 */
public class CAKeyIn_ScreeningLocators {
    public static By CAandPOHKeyFromPaper_Link=By.xpath("//A[@href='#/dataEntry/pointOfHireCaKeyIn'][text()='CA/POH Key From Paper']");
    public static By TaxCredits_image=By.xpath("//SPAN[@class='company-name-first'][text()='Tax']");
    public static By CAKeyIn_RadioButton=By.xpath("//LABEL[@ng-class='labelCls'][text()='California_key_from_paper']");
    public static By CompanyName_Field=By.xpath("//INPUT[@id='companySearch']");
    public static By Company_Name_Dropdown=By.xpath("//*[contains(@id,'typeahead-')]/a[1]/strong ");
    public static By Unit_Field=By.xpath("//INPUT[@id='theInput']");
    public static By StartScreening_Button=By.xpath("//SPAN[@class='ng-scope'][text()='Start Screening']");
    public static By SSN_Field=By.xpath("//div[@class='question_title'][1]//span[2][text()='Social Security Number']/ancestor::div[1]/following::input[1]");
    public static By Hire_Date=By.xpath("//input[@placeholder='mm/dd/yyyy']");
    public static By Credit_Name_click=By.xpath(".//*[@id='credit_name']");
    public static By Continue_Button=By.xpath("//*[@id='continuebutton']");
    public static By CAAddress_Field=By.xpath("//*[@id='question']/div[2]/div[79]/input");
    public static By Zipcode_Field=By.xpath("//*[@id='question']/div[2]/div[86]/input");
    public static By CA_State_Forms=By.xpath("//*[@id='question']/div[2]/div[16]/div[1]/span[2]/b/u");
    public static By CA01_StateForm_CheckBox=By.xpath("//*[@id='question']/div[2]/div[23]/div[3]/input");
    public static By EDD_ReleaseForm_CheckBox=By.xpath("//*[@id='question']/div[2]/div[30]/div[3]/input");
    public static By T_4506_CheckBox=By.xpath("//*[@id='question']/div[2]/div[37]/div[3]/input");
    public static By SF_180_CheckBox=By.xpath("//*[@id='question']/div[2]/div[44]/div[3]/input");
    public static By FirstName_Field=By.xpath("//*[@id='question']/div[2]/div[58]/input");
    public static By Lastname_Field=By.xpath("//*[@id='question']/div[2]/div[72]/input");
    public static By Address_Field=By.xpath("//*[@id='question']/div[2]/div[79]/input");
    public static By ZipCode_Field=By.xpath("//*[@id='question']/div[2]/div[86]/input");
    public static By Military_TargetGroup_Checkbox=By.xpath("//*[@id='question']/div[2]/div[2]/div[3]/input");
    public static By EarnedIncomeCredit_TargetGroup_Checkbox=By.xpath("//*[@id='question']/div[2]/div[9]/div[3]/input");
    public static By Felony_TargetGroup_Checkbox=By.xpath("//*[@id='question']/div[2]/div[16]/div[3]/input");
    public static By GeneralAssistance_TargetGroup_Checkbox=By.xpath("//*[@id='question']/div[2]/div[23]/div[3]/input");
    public static By UnemployedFulltimeStudent_TargetGroup_Checkbox=By.xpath("//*[@id='question']/div[2]/div[30]/div[3]/input");
    public static By ScreeningCompleted_Message=By.xpath("//*[@id='question']/div[2]/div[9]/div[1]/span[2]/b");
}