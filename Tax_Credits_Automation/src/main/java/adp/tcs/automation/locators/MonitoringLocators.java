package adp.tcs.automation.locators;

import org.openqa.selenium.By;

/**
 * Created by thorasa on 09/30/2016.
 */
public class MonitoringLocators {
	
	public static By DATA_ENTRY_LINK = By.xpath("//a[text()='Data Entry']");
    public static By MONITORING_LINK = By.xpath("//a[text()='Monitoring']");
    public static By UNIQUE_ID_TEXT_FIELD_ON_MONITORING = By.xpath("//input[@placeholder='Unique Id']");
    public static By SEARCH_BUTTON_ON_MONITORING = By.xpath("//button[2]/span");
    public static By SEARCH_RESULT_ERROR_DISCRIPTION_FIELD = By.xpath("//table[@id='datatable_docufree_searchResult']//tr[1]/td[8]");

}
