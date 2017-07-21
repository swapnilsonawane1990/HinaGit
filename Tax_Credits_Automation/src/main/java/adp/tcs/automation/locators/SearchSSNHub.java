package adp.tcs.automation.locators;

import org.openqa.selenium.By;

/**
 * Created by bhutesac on 4/1/2016.
 */
public class SearchSSNHub {

    public static By SEARCH_SSN_PROCESS_TAB = By.xpath("//*[@id='adpProcess_navItem_label']");
    public static By SEARCH_SSN_PROCESS_TAX_CREDIT_TAB = By.xpath("//span[.='Tax Credits']");
    public static By SEARCH_SSN_PROCESS_TAX_CREDIT_OPERATIONS_TAB = By.xpath("//span[@class='revitMegaItemText'][.='Operations']");
    public static By SEARCH_SSN_THE_HUB_LINK = By.xpath("//div[1]/div[2]/div//div[2]/div[1]/div/form[2]/div[5]//div[2]/div[1]/div/ul/li[1]/span");
    public static By SEARCH_SSN_INPUTBOX = By.xpath("//*[@id='ssnAndNameInput']");
    public static By SEARCH_SSN_SEARCH_BUTTON = By.xpath("//*[@id='table-search-button']");
    public static By SEARCH_SSN_SEARCH_RESULT_TEXT = By.xpath("//*[@id='datatable']/tbody/tr[1]/td[2]/p");
    public static By DOUBLE_CLICK_ONE_SSN_RECORD = By.id("applicant-popover-0");
    public static By SEARCH_SSN_RESET_BUTTON = By.xpath("//span[@class='ng-scope'][.='RESET']");
    public static By SEARCH_SSN_EXPORT_TO_EXCEL_BUTTON = By.xpath("//span[@class='ng-scope'][.='Export to Excel']");
    public static By SEARCH_SSN_RESET_CHECK = By.xpath("//td[@class='dataTables_empty']");

    public static By SEARCH_SSN_HOME_PAGE = By.xpath("//a[@class='menu-label'][.='Home']");
    public static By SEARCH_SSN_SHOW_ADVANCE_SEARCH_LINK = By.xpath("//a[.='Show Advanced Search']");
    public static By SEARCH_SSN_SHOW_ADVANCE_SEARCH_CLIENT_TEXTBOX = By.xpath("//input[@name='clientSearch']");
    public static By SEARCH_SSN_SHOW_ADVANCE_SEARCH_COMPANY_TEXTBOX = By.xpath("//input[@name='companySearch']");
    public static By SEARCH_SSN_SHOW_ADVANCE_SEARCH_SCREENED_DATEFROM_TEXTBOX = By.xpath("//input[@id='screeningDateFromSearch']");
    public static By SEARCH_SSN_SHOW_ADVANCE_SEARCH_SCREENED_DATETO_TEXTBOX = By.xpath("//input[@id='screeningDateTo']");
    public static By SEARCH_SSN_SHOW_ADVANCE_SEARCH_HIREDATE_TEXTBOX = By.xpath("//input[@id='hireDateSearch']");
    public static By SEARCH_SSN_SHOW_ADVANCE_SEARCH_WORKSTARTFROM_TEXTBOX = By.xpath("//input[@id='workStartFromDate']");
    public static By SEARCH_SSN_SHOW_ADVANCE_SEARCH_WORKSTARTTO_TEXTBOX = By.xpath("//input[@id='workStartToDate']");
    public static By SEARCH_SSN_SHOW_ADVANCE_SEARCH_CREATEDBY_TEXTBOX = By.xpath("//input[@id='createdByUserNameSearch']");
    public static By SEARCH_SSN_SHOW_ADVANCE_SEARCH_MODIFIED_BY_USER_NAME_TEXTBOX = By.xpath("//input[@id='modifiedByUserNameSearch']");
//select status method is defind on BackOfficActions class
public static By SEARCH_SSN_SHOW_ADVANCE_SEARCH_RETRO_PROJECT_DROPDOWN = By.xpath("//*[@id=\'table-filters-box\']/div[2]/table/tbody/tr[1]/td[6]/div[12]/adp-dropdown/button/span[2]");
    public static By SEARCH_SSN_SHOW_ADVANCE_SEARCH_SEARCH_BUTTON = By.xpath("//span[@class='ng-scope'][.='SEARCH']");
    public static By SEARCH_SSN_SHOW_ADVANCE_COMPANY_RESULT = By.xpath("//*[@id=\'dataTable_Search\']/tbody/tr[1]/td[5]/p");
    public static By SEARCH_SSN_SHOW_ADVANCE_AREA_RESULT = By.xpath("//*[@id=\'dataTable_Search\']/tbody/tr[1]/td[8]/p");
    public static By SEARCH_SSN_SHOW_ADVANCE_CLIENTNAME_AUTOPOP = By.xpath("//a[@class='ng-scope ng-binding']");

    public static By SEARCH_SSN_SHOW_HIDE_ADVANCE_SEARCH = By.xpath("//a[.='Hide Advanced Search']");

    public static By SEARCH_SSN_SHOW_AREA_DROPDOWN = By.xpath("//*[@id=\'table-filters-box\']/div[2]/table/tbody/tr[1]/td[1]/div[2]/adp-select/button/span[2]");

public static By SEARCH_SSN_SHOW_ADVANCE_AREA_DROPDOWN_WOTC_VALUE = By.xpath("//*[@id=\'table-filters-box\']/div[2]/table/tbody/tr[1]/td[1]/div[2]/adp-select/ul/li[1]/a");

    public static By SEARCH_SSN_SHOW_ADVANCE_AREA_DROPDOWN_CA_VALUE = By.xpath("//*[@id=\'table-filters-box\']/div[2]/table/tbody/tr[1]/td[1]/div[2]/adp-select/ul/li[1]/a");
    public static By SEARCH_SSN_SHOW_ADVANCE_AREA_DROPDOWN_POH_VALUE = By.xpath("//*[@id=\'table-filters-box\']/div[2]/table/tbody/tr[1]/td[1]/div[2]/adp-select/ul/li[1]/a");


    public static By SEARCH_SSN_SHOW_ADVANCE_SEARCH_APPLICATION_STATUS = By.xpath("//*[@id='table-filters-box']/div[2]/table/tbody/tr[2]/td[1]/div/adp-dropdown/button/span[2]");

    public static By SEARCH_SSN_HIRE_DATE_EDIT_PAGE = By.xpath("//table/tbody/tr[3]/td[5]/div[2]");
    public static By SEARCH_SSN_ADVANCE_SEARCH_HIRED_ELIG_REC = By.xpath("//p[@class='search-result-width'][.='Screened eligible']");
    public static By SEARCH_SSN_ADVANCE_SEARCH_SCREENED_INELIG_REC = By.xpath("//p[@class='search-result-width'][.='Screened Ineligible']");

    public static By SEARCH_SSN_ADVANCE_SEARCH_SCREENING_DATE_FROM = By.xpath("//div[@class='datepick-popup']//tr/td");

    public static By SEARCH_SSN_ADVANCE_SEARCH_SCREENING_TO = By.xpath("//*[@id='ng-app']/div[2]/div/div[2]/div/table/tbody/tr[4]/td[3]/a");

    public static By SEARCH_SSN_ADVANCE_SEARCH_SCREENING_DATE = By.xpath("//*[@id='ng-app']/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr[3]/td[5]/div[2]");

    public static By SEARCH_SSN_ADVANCE_SEARCH_SCREENING_DATE_ON_EDIT= By.xpath("//table[@class='employee_info_table']//tr[3]/td[1]/div[2]");

    public static By SEARCH_SSN_ADVANCE_SEARCH_HIRE_DATE_ON_EDIT= By.xpath("//table[@class='employee_info_table']//tr[3]/td[5]/div[2]");

    public static By SEARCH_SSN_ADVANCE_SEARCH_CONFIRMATION_NUM_TEXTBOX= By.xpath("//*[@id='table-filters-box']/div[2]/table/tbody/tr[3]/td[2]/div/input");


    public static By SEARCH_SSN_CONFIRMATION_NUM_EDIT_PAGE = By.xpath("//table[@class='employee_info_table']//tr[2]/td[5]/div[2]");


    public static By SEARCH_SSN_ADVANCE_SEARCH_WORK_DATE_ON_EDIT= By.xpath("//table[@class='employee_info_table']//tr[3]/td[6]/div[2]");


    public static By SEARCH_SSN_DATE_PICKER_PREV_BUTTON = By.xpath("//a[@class='datepick-cmd datepick-cmd-prev ']");
    public static By SEARCH_SSN_NEXT_BUTTON = By.xpath("//a[@class='next'][.='Next']");
    
    public static By HUB_SEARCH_RESULT_HEADER = By.xpath("//TR[1]//TH");
    
    public static String HUB_SEARCH_RESULT_DATA = "//TR[1]//TH";
    
    public static String HUB_SEARCH_RESULT_CONST_PATH = "//div[@id='datatable_wrapper']//table/tbody/tr";
    
    public static By HUB_SEARCH_DEATILS_NAME = By.xpath("//div[@class='personal-info-container']//div[@class='employee-name']/span");
    public static String HUB_SEARCH_DEATILS_INFO = "//div[@class='personal-info-container']//div[@class='info-label']//div[@class='info-block']";
    public static String HUB_SEARCH_COMPANY_DEATILS_INFO = "//div[@class='left-container']//table[@class='employee_info_table']/tbody/tr";
    
    public static By RECORD_STATUS_DROPDOWN_BTN= By.xpath("//div[@class='status-tile ng-scope']//button[@class='adp-select-trigger']");
    public static String RECORD_STATUS_DROPDOWN_lIST_CONST = "//ul[@class='adp-select-menu adp-select-alternate adp-select-open']/li";
    
    public static By RECORD_STATUS_DROPDOWN_SELECTED_VALUE= By.xpath("//div[@class='status-tile ng-scope']//button[@class='adp-select-trigger']/span[1]");
    public static By SAVE_BTN_RECORD_DETAILS_PAGE= By.xpath("//i[@class='fa fa-save']");
    public static By TARGET_GROUP_ICON= By.xpath("//*[@id='pokerchip-area']//td/div[1]");

  //changed Page navigation locators
    public static By SELECT_OPERATION_TAB = By.xpath("//a[contains(.,'Operations') and @class='ng-binding']");
    public static By THE_HUB_LINK = By.xpath("//*[@id=\"frmOperations\"]/div[5]//ul/li[1]/span");

}
