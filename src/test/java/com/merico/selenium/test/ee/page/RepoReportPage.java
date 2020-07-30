package com.merico.selenium.test.ee.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.merico.selenium.autoscreenshot.AutoIntercept;
import com.merico.selenium.page.Page;
import com.merico.selenium.test.ee.control.RepoReportControls;
import com.merico.selenium.test.ee.utils.Utilities;

public class RepoReportPage extends Page {
	public RepoReportPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isLoaded() {
        // No Ajax content, which can be considered to create the Page object has finished loading.
        return true;
    }
    
    @AutoIntercept
    public void searchRepoByNameOrGitAddr(String repoUrl) {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Search_By_Git_Addr_Textbox_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Search_By_Git_Addr_Textbox_Css)).click();
    	driver.findElement(By.cssSelector(RepoReportControls.Search_By_Git_Addr_Textbox_Css)).sendKeys(repoUrl);
        Utilities.staticTimeDelay(3000);
        Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.View_Report_Btn_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.View_Report_Btn_Xpath)).click();
    	Utilities.staticTimeDelay(5000);
    }
    
    @AutoIntercept
    public String getGeneralReportHeader() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.General_Report_Header_Name_Xpath));
    	String reportName = driver.findElement(By.xpath(RepoReportControls.General_Report_Header_Name_Xpath)).getText().trim();
    	System.out.println(reportName);
    	
    	return reportName;
    }
    
    @AutoIntercept
    public void analysisRecently() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.General_Report_Header_Name_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.General_Report_Header_Name_Xpath)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Collapse_Flag_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Collapse_Flag_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Hash_Copy_Btn_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Hash_Copy_Btn_Xpath)).click();
    	Utilities.staticTimeDelay(500);
    }
    
    @AutoIntercept
    public String getHashCopyTooltip() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Hash_Copy_Tooltip_Css));
    	String tooltip = driver.findElement(By.cssSelector(RepoReportControls.Hash_Copy_Tooltip_Css)).getText().trim();
    	System.out.println(tooltip);
    	
    	return tooltip;
    }
    
    @AutoIntercept
    public void accumulationDevEq() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Collapse_Flag_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Collapse_Flag_Css)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Accumulation_Dev_Eq_Tab_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Accumulation_Dev_Eq_Tab_Css)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void dailyDevEq() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Daily_Dev_Eq_Tab_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Daily_Dev_Eq_Tab_Css)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public Boolean getDevEqCanvas() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Dev_Eq_Canvas_Css));
    	boolean flag = driver.findElement(By.cssSelector(RepoReportControls.Dev_Eq_Canvas_Css)).isDisplayed();
    	System.out.println("Dev Eq Canvas is Existed? " + flag);
    	
    	return flag;
    }
    
    @AutoIntercept
    public void modularity4Radar() {
		Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Modularity_Label_Xpath));
		WebElement element = driver.findElement(By.xpath(RepoReportControls.Modularity_Label_Xpath));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();
	    Utilities.staticTimeDelay(500);
    }
    
    @AutoIntercept
    public Boolean getRadarTooltip() {
//    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Radar_Tooltip_Xpath));
    	boolean flag = driver.findElement(By.xpath(RepoReportControls.Radar_Tooltip_Xpath)).isDisplayed();
    	System.out.println("Tooltip Displayed: " + flag);
    	
    	return flag;
    }
}
