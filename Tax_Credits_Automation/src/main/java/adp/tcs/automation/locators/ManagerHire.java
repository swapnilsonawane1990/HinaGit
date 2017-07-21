package adp.tcs.automation.locators;

import org.openqa.selenium.By;

/**
 * Created by bhutesac on 7/21/2016.
 */
public class ManagerHire {

    public static By PROCESS_TAB_FOR_MANAGER_HIRE = By.xpath("//SPAN[@id='pracProcess_navItem_label']");
    public static By TAX_CREDIT_TAB_FOR_MANAGER_HIRE = By.xpath("(//SPAN[text()='Tax Credits'])[1]");
    public static By HIRING_COMPLIANCE_TAB_FOR_MANAGER_HIRE = By.xpath("//SPAN[@class='revitMegaItemText'][text()='Hiring Compliance']");

   // frameid AND NAME : managerHireIFrame_iframe
    //*[@id="ssnSearch"]
   public static By SSN_SEARCH_MANAGER_HIRE_TEXTBOX = By.xpath("//INPUT[@id='ssnSearch']");
    public static By SSN_SEARCH_MANAGER_HIRE_BUTTON = By.xpath("//button[@class='btn btn-primary'][.='Search']");
    public static By MANAGER_HIRE_BUTTON = By.xpath("//button[.='Hire']");
    public static By MANAGER_HIRE_JOB_TYPE_DROPDOWN = By.xpath("//select[@id='inputJobType']");
    public static By MANAGER_HIRE_HOURLY_WAGES_DROPDOWN = By.xpath("//input[@id='inputHourlyWage']");
    public static By MANAGER_HIRE_SUBMIT_BUTTON = By.xpath("//button[@class='btn btn-primary float-right'][.='Submit']");
    public static By APPLICANT_HIRE_MESSAGE = By.xpath("//div[3]/div[2]/div/div[2]/div/div[1]/div[2]/span");
    public static By MANAGER_HIRE_BACK_BUTTON = By.xpath("html/body/div[3]/div[2]/div/div[1]/button");
    public static By MANAGER_HIRE_LOGOUT_BUTTON = By.xpath("//SPAN[@class='dijitReset dijitInline dijitIcon fa fa-sign-out']");
    public static By MANAGER_HIRE_LOGOUT_OK_BUTTON = By.xpath("//SPAN[@id='revit_form_Button_1']");
    public static By MANAGER_HIRE_OFFER_DATE = By.xpath("//INPUT[@id='offerDate']");
    public static By MANAGER_HIRE_GAVE_DATE = By.xpath("//INPUT[@id='inputAcknowledgeDate']");
    public static By MANAGER_HIRE_HIRE_DATE = By.xpath("//INPUT[@id='inputHireDate']");
    public static By MANAGER_HIRE_START_DATE = By.xpath("//INPUT[@id='inputStartDate']");
    public static By MANAGER_HIRE_APPLICATION_STATUS = By.xpath("//select[@id='applicantStatus']");
    public static By MANAGER_UPDATE_HIRE_BUTTON = By.xpath("//button[@class='btn btn-primary'][.='Update Hire']");
    public static By MANAGER_LOGOUT_BUTTON = By.xpath("//SPAN[@class='dijitReset dijitInline dijitIcon fa fa-sign-out']");
    public static By MANAGER_LOGOUT_OK_BUTTON = By.xpath("//SPAN[@id='revit_form_Button_1']");
    public static By MANAGER_GAVE_INFO_DATE = By.xpath("//input[@id='inputAcknowledgeDate']");

   //Smart Complianace Managwer Hire

   public static By MANAGER_SMART_COMPLIANCE_BUTTON = By.xpath("//IMG[@src='/services/cfolanding/images/notificationspage_button.png']");
    //Window Switch
    public static By MANAGER_SMART_COMPLIANCE_TOUR_SKIP_LINK = By.xpath("//a[@ng-click='vm.close()'][contains(text(),'Skip for later')]");
    public static By MANAGER_SMART_COMPLIANCE_PROCESS_TAB = By.xpath("//a[.=' PROCESSES ']");
    public static By MANAGER_SMART_COMPLIANCE_TAX_SERVICE_SUBTAB = By.xpath("//li[text()='TAX CREDITS']");
    public static By MANAGER_SMART_COMPLIANCE_HIRE_PAGE = By.xpath("(//DIV[@class='workspaces__action-item ng-scope'])[1]");
    public static By MANAGER_SMART_COMPLIANCE_HIRING_COMPLIANCE = By.xpath("//h4[.='Hiring Compliance']");

    public static By MANAGER_SMART_COMPLIANCE_SEARCH_TEXTBOX = By.xpath("//*[@id=\"sc-page-view\"]/workspaces/div/section[3]/div[1]/div[2]/input");
    
    public static By CLIENT_LOGOUT_BUTTON = By.xpath("//a[text()='Log Out']");
    public static By CLIENT_USER_AVATAR_LINK = By.xpath("/html/body/div[1]/sc-header/div/div[2]/div/div[2]/sc-user-hub/div/user-avatar/div");


}
