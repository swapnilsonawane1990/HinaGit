package adp.tcs.automation.locators;

import org.openqa.selenium.By;

/**
 * Created by BhuteSac on 10/7/2016.
 */
public class WebInWalmartScreening {

    public static By FIRST_NAME_WALMART = By.xpath("//div[@class='question_title'][1]//span[2][text()='First Name']/ancestor::div[1]/following::input[1]");
    public static By MIDDLE_NAME_WALMART = By.xpath("//div[@class='question_title'][1]//span[2][text()='Middle Initial']/ancestor::div[1]/following::input[1]");
    public static By LAST_NAME_WALMART = By.xpath("//div[@class='question_title'][1]//span[2][text()='Last Name']/ancestor::div[1]/following::input[1]");
    public static By TELEPHONE_NUMBER_WALMART = By.xpath("//input[@type='tel']");
    public static By SSN_FIRST_WALMART = By.xpath("//div[@class='question_title'][1]//span[2][text()='Social Security Number']/ancestor::div[1]/following::input[1]");
    public static By AGE_YES_WALMART = By.xpath("//input[@id='AgeCheck_YES']");
    public static By AGE_NO_WALMART = By.xpath("//input[@id='AgeCheck_NO']");
    public static By CONFIRM_SSN_WALMART = By.xpath("//div[@class='question_title'][1]//span[2][text()='Confirm Social Security Number']/ancestor::div[1]/following::input[1]");
    public static By DOB_WALMART = By.xpath("//div[4]/div[5]/div/div/div[6]/div[2]/div[2]/div[51]/input");
    public static By AGE_YES_CCTW_YES = By.xpath("//input[@id='CCWTW_YES']");
    public static By AGE_NO_CCWTW_NO = By.xpath("//input[@id='CCWTW_NO']");

    //TANF
    public static By TANF_ASSIT_9M_YES = By.xpath("//input[@id='TANF_WOTCAsstAny9M_YES']");
    public static By TANF_ASSIT_9M_NO = By.xpath("//input[@id='TANF_WOTCAsstAny9M_NO']");
    public static By TANF_ASSIT_18LATM_YES = By.xpath("//input[@id='TANF_WOTCAsstLast18M_YES']");
    public static By TANF_ASSIT_18LATM_NO = By.xpath("//input[@id='TANF_WOTCAsstLast18M_NO']");
    public static By TANF_ASSIT_18ANYM_YES = By.xpath("//input[@id='TANF_WOTCAsstAny18M_YES']");
    public static By TANF_ASSIT_18ANYM_NO = By.xpath("//input[@id='TANF_WOTCAsstAny18M_NO']");
    public static By TANF_WOTC_ELIGIBLE_YES = By.xpath("//input[@id='TANF_WOTCNotEligible_YES']");
    public static By TANF_WOTC_ELIGIBLE_NO = By.xpath("//input[@id='TANF_WOTCNotEligible_YES']");
    public static By TANF_PAYMENT_CHKBOX = By.xpath("//*[@id=\"question\"]/div[2]/div[37]/div[3]/input");

//food Stamps
public static By FOOD_STAMP_QUE1_YES = By.xpath("//input[@id='FoodStamps_6_YES']");
    public static By FOOD_STAMP_QUE1_NO = By.xpath("//input[@id='FoodStamps_6_NO']");
    public static By FOOD_STAMP_QUE2_YES = By.xpath("//input[@id='FoodStamps_3M_of_5M_YES']");
    public static By FOOD_STAMP_QUE2_NO = By.xpath("//input[@id='FoodStamps_3M_of_5M_NO']");


//hire page
    public static final By HIRE_INFO_GAVE_INFO_DATE = By.xpath("//*[@id='question']//div[2]/input");
    public static By HOURLY_WAGES_WALMART = By.xpath("(//INPUT[@type='text'])[5]");
    public static By HOURLY_WAGES = By.xpath("//*[@id=\"question\"]/div[2]/div[44]/div[4]/div/select");
    public static By JOB_OFFER_DATE_WALMART = By.xpath("//div/div[6]/div[2]/div[2]/div[16]/input");
    public static By JOB_HIRE_DATE_WALMART = By.xpath("//div/div[6]/div[2]/div[2]/div[23]/input");
    public static By JOB_START_DATE_WALMART = By.xpath("//div/div[6]/div[2]/div[2]/div[30]/input");
    public static By JOB_POSITION_WALMART = By.xpath("//div/div[6]/div[2]/div[2]/div[44]/div[4]/div/select");

    //last Page

    public static By DONE_BUTTON_WALMART = By.xpath("//button[@class='dynamic-button'][.='Done']");

















}
