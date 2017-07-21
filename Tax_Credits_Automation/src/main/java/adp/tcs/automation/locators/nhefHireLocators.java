package adp.tcs.automation.locators;

import org.openqa.selenium.By;

/**
 * Created by BhuteSac on 10/16/2016.
 *
 */
public class nhefHireLocators {
    public static By NHEF_SUB_LINK = By.xpath("//a[@href='#/massprocess/newhire'][.='New Hire Employee File Upload (NHEF)']");
    public static By UPLOAD_BUTTON_LINK = By.xpath("//input[@id='NHEFfileInput']");
    public static By UPLOAD_MSG_ERROR = By.xpath("//div[.='File uploaded successfully. File Name is not valid. File name should contain only a-z, A-Z, 0-9, '-' and '_'.']");
    public static By UPLOAD_SUCCESS_MSG= By.xpath("//DIV[@class='adp-alert-title ng-binding ng-scope']");
    public static By HEADER_NAME =By.xpath("//*[@id=\"search\"]/input");
}
