package adp.tcs.automation.pages;

import adp.tcs.automation.stepsfiles.BaseTempletSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by bhutesac on 4/1/2016.
 */
public class BackOfficActions extends BaseTempletSteps {


    public void selectStatusOnAdvanceSearch(String status)
    {
        //label[@class='ng-binding'][.='status']
        WebElement element =getDriver().findElement(By.xpath("//label[@class='ng-binding'][.='"+ status +"']"));
        element.click();
    }

    public void selectStatusOnAdvSearchApplicationStatus(String status)
    {
        //label[@class='ng-binding'][.='status']
        WebElement element =getDriver().findElement(By.xpath("//a[@class='ng-binding'][.='"+ status +"']"));
        if(status.equalsIgnoreCase("Hired Records")){}
        else {
            element.click();
        }
    }



    public void selectStatusOnAdvSearchStatus(String status)
    {
        WebElement element =getDriver().findElement(By.xpath("//LABEL[@ng-class='labelCls'][text()='"+ status +"']"));
        element.click();
    }



    public List<WebElement> selectStatusOnAdvStatusResult(String status)
    {
       List<WebElement> element =getDriver().findElements(By.xpath("//P[@class='search-result-width'][text()='"+ status +"']"));
        return element;

    }


    public void selectStatusOnMoreDetails(String status)
    {
        WebElement element =getDriver().findElement(By.xpath("//A[@tabindex='-1'][text()='"
                +status +
        "']"));
        element.click();

    }

    public String statusOnMoreDetailsAfterEdit(String status)
    {
       WebElement element =getDriver().findElement(By.xpath("//span[@class='adp-select-trigger-text'][.='"+ status +"']"));
        String statusValue = element.getText();
        return statusValue;

    }




    public WebElement checkForTargetGroup(String status)
    {
        WebElement element =getDriver().findElement(By.xpath("//span[@class='ng-binding'][.='  "+ status +"']"));
        return element;
    }

    public void updateForTargetGroup(String status)
    {
        WebElement element =getDriver().findElement(By.xpath("//LABEL[@ng-class='labelCls'][text()='"+ status +"']"));
        element.click();
    }

    public WebElement updateForTargetResult(String status)
    {
        WebElement element =getDriver().findElement(By.xpath("//LABEL[@ng-class='labelCls'][text()='"+ status +"']"));
        return element;
    }

}

