package com.merico.selenium.test.ee.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.merico.selenium.autoscreenshot.AutoIntercept;
import com.merico.selenium.page.Page;
import com.merico.selenium.test.ee.control.TeamViewControls;
import com.merico.selenium.test.ee.utils.Utilities;

public class TeamViewPage extends Page {
	public TeamViewPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isLoaded() {
        // No Ajax content, which can be considered to create the Page object has finished loading.
        return true;
    }
    
    private void navigateToTeams() {
    	Utilities.waitForControlPresent(driver, By.xpath(TeamViewControls.Teams_Link_Xpath));
    	driver.findElement(By.xpath(TeamViewControls.Teams_Link_Xpath)).click();
    	Utilities.staticTimeDelay(4000);
    }
    
    @AutoIntercept
    public void searchDeveloper() {
    	this.navigateToTeams();
    	
    	Utilities.waitForControlPresent(driver, By.cssSelector(TeamViewControls.Search_Teams_Member_Textbox_Css));
    	driver.findElement(By.cssSelector(TeamViewControls.Search_Teams_Member_Textbox_Css)).clear();
    	driver.findElement(By.cssSelector(TeamViewControls.Search_Teams_Member_Textbox_Css)).sendKeys("meric");
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public String getSearchCssStatus() {
    	Utilities.waitForControlPresent(driver, By.xpath(TeamViewControls.Team_Css_Search_Status_Xpath));
    	String rgb = driver.findElement(By.xpath(TeamViewControls.Team_Css_Search_Status_Xpath)).getCssValue("background-color").trim();
    	System.out.println(rgb);
    	
    	return rgb;
    }
    
    @AutoIntercept
    public void efficiencyAsc() {
    	driver.navigate().refresh();
    	Utilities.staticTimeDelay(13000);

    	Actions builder = new Actions(driver);
    	for (int i = 0; i < 12; i++) {
    		builder.sendKeys(Keys.TAB).perform();
    	}
    	builder.sendKeys(Keys.ENTER).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String getEfficiencyDataFlag() {
    	Utilities.waitForControlPresent(driver, By.xpath(TeamViewControls.Efficiency_Data_Flag_Xpath));
    	String dataFlag = driver.findElement(By.xpath(TeamViewControls.Efficiency_Data_Flag_Xpath)).getText().trim();
    	System.out.println(dataFlag);
    	
    	return dataFlag;
    }
    
    @AutoIntercept
    public void qualityAsc() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void qualityDesc() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String getQualityDataFlag() {
    	Utilities.waitForControlPresent(driver, By.xpath(TeamViewControls.Quality_Data_Flag_Xpath));
    	String dataFlag = driver.findElement(By.xpath(TeamViewControls.Quality_Data_Flag_Xpath)).getText().trim();
    	System.out.println(dataFlag);
    	
    	return dataFlag;
    }
    
    @AutoIntercept
    public void aTozSort() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void zToaSort() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String getCharSortDataFlag() {
    	Utilities.waitForControlPresent(driver, By.xpath(TeamViewControls.Char_Sort_Data_Xpath));
    	String dataFlag = driver.findElement(By.xpath(TeamViewControls.Char_Sort_Data_Xpath)).getText().trim();
    	System.out.println(dataFlag);
    	
    	return dataFlag;
    }
    
    @AutoIntercept
    public void timeRange4PastWeek() {
    	driver.navigate().refresh();
    	Utilities.staticTimeDelay(13000);

    	Actions builder = new Actions(driver);
    	for (int i = 0; i < 10; i++) {
    		builder.sendKeys(Keys.TAB).perform();
    	}
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_UP).perform();
    	builder.sendKeys(Keys.ARROW_UP).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void timeRange4PastTwoWeek() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void timeRange4PastThreeMonths() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void timeRange4PastOneYear() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String getRootNodeDataFlag() {
    	Utilities.waitForControlPresent(driver, By.xpath(TeamViewControls.Root_Node_Data_Xpath));
    	String dataFlag = driver.findElement(By.xpath(TeamViewControls.Root_Node_Data_Xpath)).getText().trim();
    	System.out.println(dataFlag);
    	
    	return dataFlag;
    }
    
    @AutoIntercept
    public void memberTooltip() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(TeamViewControls.Member_Css));
    	{
	    	WebElement element = driver.findElement(By.cssSelector(TeamViewControls.Member_Css));
	    	Actions builder = new Actions(driver);
	        builder.moveToElement(element).perform();
    	}
    }
    
    @AutoIntercept
    public void subGroupTooltip() {
    	driver.navigate().refresh();
    	Utilities.waitForControlPresent(driver, By.cssSelector(TeamViewControls.Sub_Group_Css));
    	{
	    	WebElement element = driver.findElement(By.cssSelector(TeamViewControls.Sub_Group_Css));
	    	Actions builder = new Actions(driver);
	        builder.moveToElement(element).perform();
    	}
    }
    
    @AutoIntercept
    public String getTooltipVal() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(TeamViewControls.Member_Tooltip_Css));
    	String dataFlag = driver.findElement(By.cssSelector(TeamViewControls.Member_Tooltip_Css)).getText().trim();
    	System.out.println(dataFlag);
    	
    	return dataFlag;
    }
    
    @AutoIntercept
    public void timeRangeOfPastWeek4TDV() {
    	driver.navigate().refresh();
    	Utilities.staticTimeDelay(2000);
    	
    	Utilities.waitForControlPresent(driver, By.cssSelector(TeamViewControls.root_node_css));
    	driver.findElement(By.cssSelector(TeamViewControls.root_node_css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(TeamViewControls.Productivity_Label_Xpath));
    	
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	for (int i = 0; i < 3; i++) {
    		builder.sendKeys(Keys.TAB).perform();
    	}
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_UP).perform();
    	builder.sendKeys(Keys.ARROW_UP).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void timeRangeOfPastTwoWeek4TDV() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void timeRangeOfPastThreeMonths4TDV() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void timeRangeOfPastOneYear4TDV() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String getProductivityLabelVal() {
    	Utilities.waitForControlPresent(driver, By.xpath(TeamViewControls.Productivity_Label_Xpath));
    	String val = driver.findElement(By.xpath(TeamViewControls.Productivity_Label_Xpath)).getText().trim();
    	System.out.println("Efficiency Label Value is: " + val);
    	
    	return val;
    }
    
    @AutoIntercept
    public void codeNumberOfProductivity4TDV() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void commitNumberOfProductivity4TDV() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void productivityStepByWeek4TDV() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(1000);
//    	builder.sendKeys(Keys.SHIFT, Keys.TAB).perform();
//    	Utilities.staticTimeDelay(500);
//    	builder.moveToElement(driver.findElement(By.cssSelector(TeamViewControls.Team_Productivity_Step_Css))).sendKeys("2");
//    	builder.sendKeys(driver.findElement(By.cssSelector(TeamViewControls.Team_Productivity_Step_Css)), "2");
//    	driver.findElement(By.cssSelector(TeamViewControls.Team_Productivity_Step_Css)).sendKeys("2");
//    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void productivityStepByMonth4TDV() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(1000);
    }
    
    @AutoIntercept
    public void productivityStepByQuarter4TDV() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(1000);
    }
    
    @AutoIntercept
    public void productivityStepByYear4TDV() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(1000);
    }
}
