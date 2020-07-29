package com.merico.selenium.test.ee.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    	Utilities.staticTimeDelay(2000);
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
}
