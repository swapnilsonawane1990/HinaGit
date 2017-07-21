package adp.tcs.automation.locators;

import org.openqa.selenium.By;

/**
 * Created by BhuteSac on 6/7/2016.
 */
public class EditMoreDetails {



    public static By EDIT_SSN_MORE_DETAILS_LINK = By.xpath("(//SPAN[@class='ng-scope'])[3]");
    public static By EDIT_SSN_MORE_DETAILS_STATUS_DROPDOWN = By.xpath("//*[@id='status-tab']/div[1]/adp-select/button/span[2]");

    public static By EDIT_SSN_MORE_DETAILS_REVIEW_STATUS = By.xpath("//*[@id='status-tab']/div[1]/adp-select/ul/li[14]/a");
    public static By PERSONAL_INFO_MORE_DETAIL_BACK_BUTON = By.xpath("//span[@class='ng-binding ng-scope'][.='Back']");

    public static By PERSONAL_INFO_MORE_DETAIL_SAVE_BUTTON = By.xpath("//*[@id='status-tab']/div[4]/div/button");

    public static By PERSONAL_INFO_MORE_DETAIL_PSN_DATE_EDIT = By.xpath("//input[@name='psnDate']");
    public static By PERSONAL_INFO_MORE_DETAIL_RESUBMIT_DATE_EDIT = By.xpath("//input[@name='resubmitDate']");
    public static By PERSONAL_INFO_MORE_DETAIL_START_DATE_EDIT = By.xpath("//input[@name='stateDate']");
    public static By PERSONAL_INFO_MORE_DETAIL_INVALID_DATE_EDIT = By.xpath("//input[@name='invalidationDate']");
    public static By PERSONAL_INFO_MORE_DETAIL_VERIFICATION_DATE_EDIT = By.xpath("//input[@name='verificationRcvd']");
    public static By PERSONAL_INFO_MORE_DETAIL_APPEAL_SENT_DATE_EDIT = By.xpath("//input[@name='appealSentDate']");
    public static By PERSONAL_INFO_MORE_DETAIL_DENIED_DATE_EDIT = By.xpath("//input[@name='dateDenied']");
    public static By PERSONAL_INFO_MORE_DETAIL_CERT_EFFECTIVE_SENT_DATE_EDIT = By.xpath("//input[@name='certEffectiveEnd']");

    public static By PERSONAL_INFO_MORE_DETAIL_NEED_LETTER_DATE_EDIT = By.xpath("//input[@name='needLetterRcvd']");
    public static By PERSONAL_INFO_MORE_DETAIL_SURE_POPUP_EDIT = By.xpath("(//SPAN[@class='ng-scope'][text()='Yes'])[3]");











}
