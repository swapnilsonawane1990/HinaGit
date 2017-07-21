package adp.tcs.automation.locators;

import org.openqa.selenium.By;

/**
 * Created by BhuteSac on 7/25/2016.
 */

public class MassProcessing {
    public static By OPERATION_TAB = By.xpath("//A[@class='menu-label'][text()='operations']");
    public static By OPERATION_ESIGN_MASS_PRINT_QUEUE_TAB = By.xpath("//li[@resource-security-access='adpEsignMassPrint']/a");
    public static By ESIGN_MASS_PRINT_START_FROM_DATE_FIELD = By.xpath("//input[@name='startFromDate']");
    public static By ESIGN_MASS_PRINT_START_TO_DATE_FIELD = By.xpath("//input[@name='startToDate']");
    public static By ESIGN_MASS_PRINT_SSN_FIELD = By.xpath("//input[@name='ssn']");
    public static By ESIGN_MASS_PRINT_CLIENT_ID_FIELD = By.xpath("//input[@id='clientSearch']");
    public static By ESIGN_MASS_PRINT_COMPANY_ID_FIELD = By.xpath("//input[@id='companySearch']");
    public static By ESIGN_MASS_PRINT_STATE_FIELD = By.xpath("(//SPAN[@class='fa fa-chevron-down'])[2]");
    public static By ESIGN_MASS_PRINT_COUNT_BUTTON = By.xpath("//*[@id='ng-app']/div/div[2]/div/div/div[2]/form/div[1]/div[3]/div[2]/div/button[2]/span");
    public static By ESIGN_MASS_PRINT_NUMBER_OF_RECORDS_PROCEED_FIELD = By.xpath("(//INPUT[@adp-textbox='text'])[9]");
    public static By ESIGN_MASS_PRINT_UPDATE_BUTTON = By.xpath("//*[@id='ng-app']/div/div[2]/div/div/div[2]/form/div[2]/div[2]/div[2]/div/button/span");
    public static By ESIGN_MASS_PRINT_REQUEST_ID_LINK = By.xpath("//*[@id='ng-app']/div/div[2]/div/div/div[2]/form/div[2]/div[2]/div[1]/div/p/a/b");
    public static By ESIGN_MASS_PRINT_ACTION_DOWNLOAD = By.xpath("//span//i[@class='fa fa-download']");

    
    public static String startFromDate="//input[@adp-textbox='text'][@name='startFromDate']";

    public static By ESIGN_MASS_PRINT_ACTION_DOWNLOAD_ZIP_FILE = By.xpath("//a[contains(text(),'MASS PRINT FORMS ZIP')]");
    public static By ESIGN_MASS_PRINT_PROCESS_REQUEST_POPUP_CLOSE = By.xpath("//button[@type='button'][@class='close']");
    public static By ESIGN_MASS_PRINT_ACTION_DOWNLOAD_ZIP_FILE_SINGLE = By.xpath("//a[@ng-click='downloadFile(downloadProcessName, processId)']");

}
