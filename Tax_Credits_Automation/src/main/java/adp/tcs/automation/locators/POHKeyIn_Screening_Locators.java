package adp.tcs.automation.locators;

import org.openqa.selenium.By;

/**
 * Created by garghina on 10/10/2016.
 */
public class POHKeyIn_Screening_Locators {
    public static By CAandPOHKeyFromPaper_Link=By.xpath("//A[@href='#/dataEntry/pointOfHireCaKeyIn'][text()='CA/POH Key From Paper']");
    public static By TaxCredits_image=By.xpath("//SPAN[@class='company-name-first'][text()='Tax']");
    public static By POHKeyIn_RadioButton=By.xpath("//LABEL[@ng-class='labelCls'][text()='POH - Key from Paper by State']");
    public static By CompanyName_Field=By.xpath("//INPUT[@id='companySearch']");
    public static By Company_Name_Dropdown=By.xpath("//*[contains(@id,'typeahead-')]/a[1]/strong ");
    public static By Unit_Field=By.xpath("//INPUT[@id='theInput']");
    public static By StartScreening_Button=By.xpath("//SPAN[@class='ng-scope'][text()='Start Screening']");
    public static By POH_Credit_Dropdown=By.xpath("//SELECT[@tabindex='']");
    public static By SSN_Field=By.xpath("//div[@class='question_title'][1]//span[2][text()='SSN']/ancestor::div[1]/following::input[1]");
    public static By Hire_Date=By.xpath("//input[@placeholder='mm/dd/yyyy']");
    public static By Credit_Name_Select=By.xpath("//SELECT[@tabindex='']");
    public static By Continue_Button=By.xpath("//*[@id='continuebutton']");
    public static By POHAddress_Field=By.xpath("//*[@id='question']/div[2]/div[51]/input");
    public static By Zipcode_Field=By.xpath("//*[@id='question']/div[2]/div[58]/input");
    public static By POH_State_Form_Only=By.xpath("//*[@id='questions']/h2");
    public static By FirstName_Field=By.xpath("//*[@id='question']/div[2]/div[30]/input");
    public static By Lastname_Field=By.xpath("//*[@id='question']/div[2]/div[44]/input");
    public static By Address_Field=By.xpath("//*[@id='question']/div[2]/div[51]/input");
    public static By ZipCode_Field=By.xpath("//*[@id='question']/div[2]/div[86]/input");
    public static By POH_AZ_TANF_TEXT=By.xpath("//H2[@data-bind='style: { fontFamily: $root.fontFamily() }, text: title'][text()='Arizona TANF']");
    public static By AZ_First_Question=By.xpath("//*[@id='question']/div[2]/div[2]/div[3]/input");
    public static By AZ_Second_question=By.xpath("//*[@id='question']/div[2]/div[9]/div[3]/input");
    public static By AZ_Third_question=By.xpath("//*[@id='question']/div[2]/div[16]/div[3]/input");
    public static By Extra_Info_SSN=By.xpath("//*[@id='question']/div[2]/div[30]/input");
    public static By Extra_Info_Date=By.xpath("//input[@placeholder='mm/dd/yyyy']");
    public static By Extra_Info_NameAndTelephone=By.xpath("//*[@id='question']/div[2]/div[44]/input");
    public static By ScreeningCompleted_Message=By.xpath("//*[@id='question']/div[2]/div[9]/div[1]/span[2]/b");
}
