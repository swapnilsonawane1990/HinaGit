package adp.tcs.automation.locators;

import org.openqa.selenium.By;

/**
 * Created by vermavik on 01st July 2016.
 */
public class MassProcessHub {

    public static By LABEL_FOR_OPERATIONS = By.xpath("//a [@class='menu-label'][.='operations']");
    public static By LABEL_PSN_UPDATE_DOL_COM = By.xpath("//li[3]/a[contains(text(),'PSN Update')]");
    public static By PSN_DOL_COMBO_PAGE_FROM_START_DATE = By.xpath("//input[@name='startFromDate']");
    public static By PSN_DOL_COMBO_PAGE_TO_START_DATE = By.xpath("//input[@name='startToDate']");
    public static By PSN_DOL_COMBO_PAGE_CALENDER = By.xpath("//div[@class='datepick-popup']//tr/td");
    public static By PSN_DOL_COMBO_PAGE_SSN_TEXTBOX = By.xpath("//input[@name='ssn']");
    public static By PSN_DOL_COMBO_PAGE_COUNT_BUTTON = By.xpath("//button [@adp-button='primary'][@ng-click='count(massProcessingInputRequest)']");
    public static By PSN_DOL_COMBO_PAGE_PSN_DATE = By.xpath("//input[@name='actionCriteriaPSNDate']");
    public static By PSN_DOL_COMBO_PAGE_DOL_FORM_DATE = By.xpath("//input[@name='dolFormGenerationDate']");
    public static By PSN_DOL_COMBO_PAGE_UPDATE_BUTTON = By.xpath("//button [@adp-button='primary'][@ng-click='update(massProcessingInputRequest)']");
    public static By PSN_DOL_COMBO_PAGE_PROCESS_ID_NUMBER = By.xpath("//a [@data-toggle='modal'][@ng-click='toggleModal(processId)']");
    public static By PSN_DOL_COMBO_PAGE_DOWNLOAD_LINK = By.xpath("//button [@adp-button='link'][@action-type='download']");
    public static By PSN_DOL_COMBO_PAGE_DOWNLOAD_PSN_XLS_REPORT = By.xpath("//*[@id=\"processRequestModal\"]/div[2]/div[2]/div[1]/div/a");
    public static By PSN_DOL_COMBO_PAGE_DOWNLOAD_PSN_PDF_REPORT = By.xpath("//*[@id=\"processRequestModal\"]/div[2]/div[2]/div[2]/div/a");
    public static By PSN_DOL_COMBO_PAGE_DOWNLOAD_FREE_STATE_PDF_REPORT = By.xpath("//*[@id=\"processRequestModal\"]/div[2]/div[2]/div[3]/div/a");
    public static By PSN_DOL_COMBO_PAGE_DOWNLOAD_DOL_FORMS_ZIP = By.xpath("//*[@id=\"processRequestModal\"]/div[2]/div[2]/div[4]/div/a");
    public static By PSN_DOL_COMBO_PAGE_REFRESH_BUTTON = By.xpath("//*[@id=\"processRequestModal\"]/div/div/div[3]/button");
    public static By PSN_DOL_COMBO_PAGE_ACTION_LABEL = By.xpath("//h3 [.='Action']");
    public static By PSN_DOL_COMBO_PAGE_CLOSE_DOWNLOAD_POP_UP = By.xpath("//*[@id=\"processRequestModal\"]/div/div/div[1]/button");
    public static By POPOVER_POPUP = By.xpath("//div[@class='popover right in']//div[@class='popover-content']");
    
    
}
