package adp.tcs.automation.locators;

import org.openqa.selenium.By;

/**
 * Created by BhuteSac on 7/26/2016.
 */
public class StateExports {

    public static By OPERATION_STATE_EXPORT_SUBTAB = By.xpath("//A[@href='#/stateautomation/stateexport'][text()='State Export']");
    public static By OPERATION_STATE_EXPORT_STATE_DROPDOWN = By.xpath("(//SPAN[@class='fa fa-chevron-down'])[1]");
    public static By OPERATION_STATE_EXPORT_PSN_FROM_DATE = By.xpath("//input[@name='psnFromDate']");
    //input[@name='startToDate']
    public static By OPERATION_STATE_EXPORT_PSN_TO_DATE = By.xpath("//input[@name='psnToDate']");
    public static By OPERATION_STATE_EXPORT_GIVE_INFO_FROM_DATE = By.xpath("//input[@name='gaveInfoFromDate']");
    public static By OPERATION_STATE_EXPORT_OFFER_FROM_DATE = By.xpath("//input[@name='offerFromDate']");
    public static By OPERATION_STATE_EXPORT_HIRE_FROM_DATE = By.xpath("//input[@name='hireFromDate']");
    public static By OPERATION_STATE_EXPORT_START_FROM_DATE = By.xpath("//input[@name='startFromDate']");
    public static By OPERATION_STATE_EXPORT_GIVE_INFO_TO_DATE = By.xpath("//input[@name='gaveInfoToDate']");
    public static By OPERATION_STATE_EXPORT_OFFER_TO_DATE = By.xpath("//input[@name='offerToDate']");
    public static By OPERATION_STATE_EXPORT_HIRE_TO_DATE = By.xpath("//input[@name='hireToDate']");
    public static By OPERATION_STATE_EXPORT_START_TO_DATE = By.xpath("//input[@name='startToDate']");
    public static By OPERATION_STATE_EXPORT_EXPORT_BUTTON = By.xpath("//SPAN[@class='ng-scope'][text()='EXPORT']");
    public static By OPERATION_STATE_EXPORT_PROCESS_REQUEST_ID_LINK = By.xpath("//form/div[2]/div/div[4]/div/p/a/b");
    public static By OPERATION_STATE_EXPORT_ACTION_DOWNLOAD = By.xpath("//span//i[@class='fa fa-download']");
    public static By OPERATION_STATE_EXPORT_ZIP_FILE_DOWNLOAD_LINK = By.xpath("//a[contains(text(),'STATE EXPORT FILES ZIP')]");

    public static By OPERATION_STATE_EXPORT_PROCESSING_SIGN = By.xpath("//*[@id=\"processRequestModal\"]/div//div[2]/table/tbody/tr[2]/td[2][contains(text(),'Processing')]");
    public static By OPERATION_STATE_EXPORT_REFRESH_BUTTON = By.xpath("//button[@class='btn btn-primary'][contains(text(),'Refresh')]");
}
