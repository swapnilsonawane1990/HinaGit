package adp.tcs.automation.locators;

import org.openqa.selenium.By;

/**
 * Created by BhuteSac on 4/14/2016.
 */
public class EditPersonalInfo {

    public static By EDIT_BUTTON_ON_PERSONAL_INFO = By.xpath("//span[@class='ng-scope'][.='Edit']");
    public static By PERSONAL_INFO_ESIGN_TEXTBOX = By.xpath("//input[@name='signatureDate']");
    public static By PERSONAL_INFO_FIRST_NAME_TEXTBOX = By.xpath("//input[@name='employeeTabFirstName']");
    public static By PERSONAL_INFO_MIDDLE_NAME_TEXTBOX = By.xpath("//input[@name='employeeTabMiddleName']");
    public static By PERSONAL_INFO_LAST_NAME_TEXTBOX = By.xpath("//input[@name='employeeTabLastName']");
    public static By PERSONAL_INFO_SSN_TEXTBOX = By.xpath("//input[@name='employeeTabSSN']");
    public static By PERSONAL_INFO_BIRTH_DATE_TEXTBOX = By.xpath("//input[@name='birthDate']");
    public static By PERSONAL_INFO_PHONE_NUMBER_TEXTBOX = By.xpath("//input[@name='employeeTabPhone']");
    public static By PERSONAL_INFO_EMAIL_TEXTBOX = By.xpath("//input[@name='employeeTabEmail']");
    public static By PERSONAL_INFO_ADDRESS_LINE_TEXTBOX = By.xpath("//*[@id='ng-app']/div[2]/div[2]/div/div[2]/div/div/div[3]/form/div[2]/div[2]/div[2]/input");
    public static By PERSONAL_INFO_EMPLOYEE_CITY_TEXTBOX = By.xpath("//input[@name='employeeTabCity']");

    public static By PERSONAL_INFO_EMPLOYEE_COUNTRY_TEXTBOX = By.xpath("//input[@name='employeeTabCounty']");
    public static By PERSONAL_INFO_EMPLOYEE_STATE_DROPDOWN_ARROW = By.xpath("//*[@id='ng-app'']/div[2]/div[2]/div/div[2]/div/div/div[3]/form/div[2]/div[2]/div[4]/adp-dropdown/button/span[2]");
    public static By PERSONAL_INFO_EMPLOYEE_ZIPCODE_TEXTBOX = By.xpath("//input[@name='employeeTabPostalCode']");
    public static By PERSONAL_INFO_EMPLOYEE_COMPANYNAME_TEXTBOX = By.xpath("//input[@name='companySearch']");

    public static By PERSONAL_INFO_EMPLOYEE_UNIT_TEXTBOX = By.xpath("//input[@id='theInput']");
    public static By PERSONAL_INFO_HIREDATE_TEXTBOX = By.xpath("//input[@name='hireDate']");
    public static By PERSONAL_INFO_EMPLOYEE_STARTDATE_TEXTBOX = By.xpath("//input[@name='startDate']");
    public static By PERSONAL_INFO_EMPLOYEE_WAGES_TEXTBOX = By.xpath("//input[@name='employerTabHireWageField']");
    public static By PERSONAL_INFO_EMPLOYEE_GIVEINFODATS_TEXTBOX = By.xpath("//input[@name='gaveInfoDate']");
    public static By PERSONAL_INFO_EMPLOYEE_OFFERDATE_TEXTBOX = By.xpath("//input[@name='offerDate']");
    public static By PERSONAL_INFO_EMPLOYEE_SIGNATUREDATE_DATE = By.xpath("//input[@name='signatureDate']");
    public static By PERSONAL_INFO_EMPLOYEE_SAVE_BUTTON = By.xpath("//div[@class='employee-button-div']//span[@class='ng-binding ng-scope'][.='Save']");
    public static By PERSONAL_INFO_EMPLOYEE_BACK_BUTTON = By.xpath("//*[@id=\'ng-app\']/div[2]/div[2]/div/div[1]/div/button/span");
    public static By PERSONAL_INFO_EMPLOYEE_STATE_DROPDOWN_CONST = By.xpath("//*[@id=\'ng-app\']/div[2]/div[2]/div/div[2]/div/div/div[3]/form/div[2]/div[2]/div[4]/adp-dropdown/ul/li");
    public static By PERSONAL_INFO_EMPLOYEE_POSITION_DROPDOWN_ARROW = By.xpath("//form/div[6]/div/div[1]/div/div/span");
    public static By PERSONAL_INFO_EMPLOYEE_POSITION_DROPDOWN = By.xpath("//div[@placeholder='Select Position']/span/span[2]/span");
    public static By PERSONAL_INFO_EMPLOYEE_POSITION_DROPDOWN_CONST = By.xpath("//form/div[6]/div[1]/div[1]//ul/li//a/div");
    public static By PERSONAL_INFO_EMPLOYEE_COMPANY_NAME_SELECT = By.xpath("//*[contains(@id,'typeahead-')]/a[1]/strong");
    public static By PERSONAL_INFO_EMPLOYEE_RECORD_SAVE_SUCCESS_MSG = By.xpath("//div[contains(@class,'adp-alert-success')]/div[@class='adp-alert-content']/span[@class='ng-scope']");
    public static By PERSONAL_INFO_EMPLOYEE_EMPLYOEE_STATE_DROPDOWN = By.xpath("//ul[@class='adp-dropdown-menu adp-dropdown-open']");
    public static By PERSONAL_INFO_EMPLOYEE_EMPLYOEE_STATE_DROPDOWN_ARROW = By.xpath("//*[@name='employeeTabState']//button[@class='adp-dropdown-button']//span[@class='fa fa-chevron-down']");
    public static By PERSONAL_INFO_EMPLOYEE_EMPLYOEE_POSITION_DROPDOWN_ARROW = By.xpath("//*[@name='jobTitle']//button[@class='adp-dropdown-button']//span[@class='fa fa-chevron-down']");
    public static By PERSONAL_INFO_EMPLOYEE_HIRE_DATE_INPUT = By.xpath("//input[@name='hireDate']");
    public static By PERSONAL_INFO_EMPLOYEE_CALENDER = By.xpath("//div[@class='datepick-popup']");
    public static By PERSONAL_INFO_EMPLOYEE_START_DATE_INPUT = By.xpath("//input[@name='startDate']");
    public static By PERSONAL_INFO_EMPLOYEE_JOB_TITLE = By.xpath("//*[@name='jobTitle']//button[@class='adp-dropdown-button']");
    public static By PERSONAL_INFO_EMPLOYEE_STATE_TEXT = By.xpath("//*[@name='employeeTabState']//button[@class='adp-dropdown-button']");
    public static String PERSONAL_INFO_FIELDS_CONST = "//form/div[2]/div";
    public static String PERSONAL_INFO_STATE_FIELD_LIST = "//form/div[2]/div[2]/div[4]//ul/li//a/div";
    public static String EMPLOYEE_POSITION_DROPDOWN_CONST ="//form/div[6]/div[1]/div[1]//ul/li//a/div";
    public static By SCREENING_METHOD = By.xpath("//input[@ng-model='screeningMethod']");
    public static By EMPLOYEE_INFO_UNIT_SEARCH_ICON = By.xpath("//i[@class='fa fa-search popup_help']");
    public static By EMPL_SIGNATURE = By.xpath("//input[@ng-model='employeeTab.signatureDate']");
    
    public static By UNIT_SEARCH_POPUP_UNIT_NAME = By.xpath("//input[@id='unitHelpSearchName']");
    public static By UNIT_SEARCH_POPUP_ZIP_CODE = By.xpath("//input[@id='unitHelpSearchZip']");
    public static By UNIT_SEARCH_POPUP_CITY = By.xpath("//input[@id='unitHelpSearchCity']");
    public static By UNIT_SEARCH_POPUP_UNIT_CODE = By.xpath("//input[@id='unitHelpSearchCode']");
    public static By UNIT_SEARCH_POPUP_ADDRESS = By.xpath("//input[@id='unitHelpSearchAddr']");
    public static By UNIT_SEARCH_POPUP_STATE = By.xpath("//select[@id='unitHelpSearchState']");
    public static By UNIT_SEARCH_POPUP_SEARCH_BTN = By.xpath("//button[@id='unit_help_btn']");
    public static By UNIT_SEARCH_POPUP_RESET_BTN = By.xpath("//button[@id='unit_help_btn_reset']");
    public static By UNIT_SEARCH_POPUP_RESULT_FIRST_ROW = By.xpath("//table[@id='unitHelpTable']/tbody/tr[1]/td[2]");


    public static By RECORD_STATUS_DROPDOWN_BTN= By.xpath("//div[@class='status-tile ng-scope']//button[@class='adp-select-trigger']");
    public static String RECORD_STATUS_DROPDOWN_lIST_CONST = "//ul[@class='adp-select-menu adp-select-alternate adp-select-open']/li/a";
    
    public static By RECORD_STATUS_DROPDOWN_SELECTED_VALUE= By.xpath("//div[@class='status-tile-item ng-scope']//button[@class='adp-select-trigger']/span[1]");// Modified by Saurab, replaced "@class='status-tile ng-scope"
    public static By SAVE_BTN_RECORD_DETAILS_PAGE= By.xpath("//i[@class='fa fa-save']");
    public static By TARGET_GROUP_ICON= By.xpath("//*[@id='pokerchip-area']//td/div[1]");
    
    public static By ADD_NOTES_TEXT_AREA= By.xpath("//textarea[@placeholder='Add Notes']");
    
    public static By ADD_NOTES_USER= By.xpath("//div[@class='notes-history']//tbody/tr[2]/td[1]");
    public static By ADD_NOTES_DATE= By.xpath("//div[@class='notes-history']//tbody/tr[2]/td[2]");
    public static By ADD_NOTES_TEXT= By.xpath("//div[@class='notes-history']//tbody/tr[2]/td[3]");
    

    
    public static String TARGET_GROUPS_CONST_VALUES = "//div[@class='employee-tile-targetgrp ng-scope']/div";
    public static By TARGET_GROUPS_IS_PRESENT =  By.xpath("//div[@class='employee-tile-targetgrp ng-scope']/div");
    public static By MORE_DETAILS_LINK_ON_TARGET_GROUP= By.xpath("//*[@id='ng-app']/div/div[2]/div/div[4]/div[1]/div/div[5]/div/div/div/button/span");
    public static String ALL_TARGET_GROUPS_CONST_VALUES_ON_MORE_DETAILS = "//*[@id='status-tab']/div[3]/div[2]/div";
    public static By ALL_TARGET_GROUPS_CONST_VALUES_ON_MORE_DETAILS_PRESENT = By.xpath("//div[@class='employee-tile-targetgrp ng-scope']/div");
    public static By SAVE_BTN_ON_TARGET_GROUP_MORE_DETAILS= By.xpath("//*[@id='status-tab']/div[4]/div/button/span");
    
    public static By CONFIRMATION_POP_UP_TEXT= By.xpath("//*[@id='tgChangedModal']//div[@class='modal-body']");
    public static By CONFIRMATION_POP_UP_SAVE_BTN= By.xpath("(//BUTTON[@adp-button='primary'])[4]");

    public static String SAVED_NOTES_CONST_PATH = "//div[@class='notes-history']//tbody/tr";
    
    public static By CONFIRMATION_POP_UP_YES_BTN= By.xpath("//div[@class='modal fade in'][@aria-hidden='false']//button[@data-ng-click='updateDetails()']");

    public static By DATA_SAVED_TEXT_ON_MORE_DETAILS= By.xpath("//div[@class='employee-detail-error-container']//div[@class='adp-alert-content']/span");
    public static By BACK_ON_MORE_DETAILS= By.xpath("//i[@class='fa fa-chevron-left']");
    
    public static By SUCCESSFUL_MSG_TEXT= By.xpath("//div[@class='adp-alert-content']/span");

    public static By INFORMATION_MSG_TEXT= By.xpath("//div[@class='adp-alert-content']/div");
    
    public static By EXPORT_TO_EXCEL_BTN_ON_HUB_SEARCH_PAGE = By.xpath("//button/span[text()='Export to Excel']");
    public static By EXPORT_TO_EXCEL_POP_MSG = By.xpath("//div[@class='modal-content']/div[3]");
    public static By EXPORT_TO_EXCEL_POP_SUBMIT_BTN = By.xpath("//div[@class='modal-footer']/button/span[text()='Submit']");
    public static By EXPORT_TO_EXCEL_POP_REQUEST_ID_MSG = By.xpath("//div[@class='adp-alert-content']/span");
    public static By EXPORT_TO_EXCEL_POP_UP_CLOSE_BTN = By.xpath("//*[@id='exportWarningModal']//button");

    public static By MASS_SEND_MAIL_BTN_ON_HUB_SEARCH_PAGE = By.xpath("//button/span[text()='MASS SEND FAX / EMAIL']");

    public static By SELECT_ALL_RECORD_HUB_SEARCH_PAGE = By.xpath("//*[@id='massSendFormsSelectAll']");

    public static By ENTER_EMAIL_ADDRESS_ON_MASS_FORM_SEND = By.xpath("//*[@placeholder='Enter e-mail address']");
    public static By ENTER_MSG_ON_MASS_FORM_SEND = By.xpath("//textarea[@placeholder='Add personalized message']");


    public static By SEND_FORM_BY_FAX_REDIO_BTN_ON_MASS_FORM_SEND = By.xpath("//*[@id='massSendFormsModal']/div/div/div[2]/div[2]/div[1]/adp-radio/label");
    public static By SEND_TO_FIELD_ON_MASS_FORM_SEND = By.xpath("//input[@placeholder='Send to']");
    public static By AREA_CODE_ON_MASS_FORM_SEND = By.xpath("//input[@placeholder='Area Code (999)']");
    public static By FAX_NUMBER_ON_MASS_FORM_SEND = By.xpath("//input[@placeholder='Fax Number (9999999)']");
    
    public static By MASS_FORM_REQUEST_ID_MSG = By.xpath("//*[@class='employee-detail-error-container']//div[2]/span");

    public static By SEND_FORM_BTN_ON_MASS_FORM_SEND = By.xpath("//button/span[text()='SEND FORMS']");
    
    public static By PROCESSING_QUEUE_lINK = By.xpath("//div[@id='clientOperationsPortlet_pane']/ul/li/span/span[2][contains(text(),'Processing Queue')]");
    public static By PROCESSING_ID_FIELD_ON_PROCESSING_QUEUE= By.xpath("//*[@id='processID']");
    public static By SEARCH_BTN_ON_PROCESSING_QUEUE= By.xpath("//*[@id='searchProcessButton']");
    
    public static By STATUS_COL_ON_PROCESSING_QUEUE_RESULT = By.xpath("//*[@id='processQueueGrid_row_0_cell_7']/span");
    
    
    public static String DOCUMENTS_lIST_CONST = "//div[@class='documents_container']/div";

    public static By EMPL_DATA_UPDATED_SUCCESSFULLY_MSG= By.xpath("//div[@class='adp-alert-content']/span");
    public static By BACK_BTN_EDIT_DETAILS_PAGE= By.xpath("//button/span[text()='Back']");
    //public static By HOME_PAGE_LINK = By.xpath("//*[@id=\"menu\"]/li[2]/a");
    public static By HOME_PAGE_LINK = By.xpath("//a[text()='Home']");
    public static By HOME_PAGE_STATUS = By.xpath("//P[@class='search-result-width'][text()='K']");
    
    
    public static By DOCUFREE_RECEIVED_DATE = By.xpath("//table[@class='docufree_request-table']//tr[1]/th[1]");
    public static By DOCUFREE_MATCH_DATE = By.xpath("//table[@class='docufree_request-table']//tr[1]/th[2]");
    public static By DOCUFREE_UNIQUE_ID = By.xpath("//table[@class='docufree_request-table']//tr[1]/th[3]");
    public static By DOCUFREE_IMAGE_PATH = By.xpath("//table[@class='docufree_request-table']//tr[1]/th[4]");
    public static By DOCUFREE_DOCUMENT_STATUS = By.xpath("//table[@class='docufree_request-table']//tr[1]/th[5]");
    
    public static By DOCUFREE_RECEIVED_DATE_VALUE = By.xpath("//tr[@data-ng-repeat='docufreeRequest in docufreeRequestList'][1]/td[1]");
    public static By DOCUFREE_MATCH_DATE_VALUE = By.xpath("//tr[@data-ng-repeat='docufreeRequest in docufreeRequestList'][1]/td[2]");
    public static By DOCUFREE_UNIQUE_ID_VALUE = By.xpath("//tr[@data-ng-repeat='docufreeRequest in docufreeRequestList'][1]/td[3]");
    public static By DOCUFREE_IMAGE_PATH_VALUE = By.xpath("//tr[@data-ng-repeat='docufreeRequest in docufreeRequestList'][1]/td[4]");
    public static By DOCUFREE_DOCUMENT_STATUS_VALUE = By.xpath("//tr[@data-ng-repeat='docufreeRequest in docufreeRequestList'][1]/td[5]");
    
    public static String DOCUFREE_TABLE_CONST = "//tr[@data-ng-repeat='docufreeRequest in docufreeRequestList']";
    
}
