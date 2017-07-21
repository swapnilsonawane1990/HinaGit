package adp.tcs.automation.locators;

import org.openqa.selenium.By;

/**
 * Created by bhutesac on 9/28/2016.
 */
public class IndividualPsnDolCom {

    public static By PSN_UPDATE_SUB_MENU = By.xpath("//li[@resource-security-access='adpPSNUpdate']/a");
    public static By PSN_UPDATE_NUMBER_OF_RECORDS_TOPROCEED_TEXTBOX = By.xpath("//*[@id=\"ng-app\"]/div/div[2]/div/div/div[2]/form/div[2]/div[1]/div/div[3]/span/input");
    public static By DOL_FORM_NUMBER_OF_RECORDS_TEXTBOX = By.xpath("//input[@name='numberOfRecordsToProcess']");
    public static By DOL_FORM_COM_FORM_PDF_REPORT = By.xpath("//a[contains(text(), 'COM FORM PDF REPORT')]");
    public static By GENERATE_DOL_SUB_MENU = By.xpath("//li[@resource-security-access='adpGenerateDOL']/a");
    public static By GENERATE_COM_SUB_MENU = By.xpath("//li[@resource-security-access='adpGenerateCOM']/a");



}
