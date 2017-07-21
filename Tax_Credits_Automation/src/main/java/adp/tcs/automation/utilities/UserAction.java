package adp.tcs.automation.utilities;

import adp.tcs.automation.locators.EditPersonalInfo;
import adp.tcs.automation.pages.SearchSSNthroughHub;
import adp.tcs.automation.stepsfiles.BaseTempletSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by BhuteSac on 4/3/2016.
 */
public class UserAction extends BaseTempletSteps {

    
    SearchSSNthroughHub searchSSNumber = new SearchSSNthroughHub();
    String workSrtDate;

    public void enterData(By by, String data){

        WebElement webElement=getWebElementBy(by);
        webElement.sendKeys(data);
    }

    public void getWebElementClick(By by){
        WebElement webElement=getWebElementBy(by);
        webElement.click();
    }

    public WebElement getWebElementBy(By by){
        waitForLoad();
        WebElement webElement=getDriver().findElement(by);
        return webElement;
    }

    public void doubleClick(WebElement element)
    {
        Actions act = new Actions(getDriver());
        act.doubleClick(element).build().perform();
    }

    public void selectDropdownValues(String selectValue) throws InterruptedException {
       // Select dropdown = new Select(element);
       // dropdown.selectByVisibleText(selectValue);
        String dropValues = "//li//a[@class='ng-binding'][.='" + selectValue + "']";
        getDriver().findElement(By.xpath(dropValues)).click();
        Thread.sleep(1000);
    }

    public void selectDate(String selectDate, WebElement element)
    {
//Implicit Wait method
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//Click on textbox so that datepicker will come
        element.click();
//DatePicker is a table.So  we have to navigate to each cell
        WebElement datepicker = getDriver().findElement(EditPersonalInfo.PERSONAL_INFO_EMPLOYEE_CALENDER);
        List<WebElement> rows=datepicker.findElements(By.tagName("tr"));
        List<WebElement> columns=datepicker.findElements(By.tagName("td"));

        for (WebElement cell: columns){
//Select date
            if (cell.getText().equals(selectDate)){
                cell.findElement(By.linkText(selectDate)).click();
                break;
            }
        }
    }

    public void selectDropDown( WebElement element, String value){
        Select seldrp = new Select(element);
        seldrp.selectByVisibleText(value);
    }

    public void switchToFrame(String frameName)
    {
        getDriver().switchTo().frame(frameName);
    }

    public void switchToDefaultFrame()
    {
        getDriver().switchTo().defaultContent();
    }

    public void selectStateDropdownStateExportPage(String stateCode)
    {
        getDriver().findElement(By.xpath("//A[@tabindex='-1'][text()='"+stateCode+"']")).click();

    }

    public void selectCurrentMonthDate(String date)
    {
        ArrayList<WebElement> fromdate = searchSSNumber.search_SSN_Screened_Date_From();
        int dte_count = fromdate.size();
        for(int i=0; i<dte_count;i++){
            if(date.equalsIgnoreCase(fromdate.get(i).getText())){
                fromdate.get(i).click();
                break;
            }
        }
    }
}
