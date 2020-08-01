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
    public void back() {
    	Utilities.staticTimeDelay(1000);
    	driver.navigate().back();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void searchRepoByNameOrGitAddr(String repoUrl) {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Search_By_Git_Addr_Textbox_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Search_By_Git_Addr_Textbox_Css)).click();
    	driver.findElement(By.cssSelector(RepoReportControls.Search_By_Git_Addr_Textbox_Css)).sendKeys(repoUrl);
        Utilities.staticTimeDelay(3000);
        Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.View_Report_Btn_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.View_Report_Btn_Xpath)).click();
    	Utilities.staticTimeDelay(8000);
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
//    	driver.findElement(By.cssSelector(RepoReportControls.Accumulation_Dev_Eq_Tab_Css)).click();
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
    public void modularityLabel4Radar() {
		Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Modularity_Label_Xpath));
		WebElement element = driver.findElement(By.xpath(RepoReportControls.Modularity_Label_Xpath));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();
	    Utilities.staticTimeDelay(100);
    }
    
    @AutoIntercept
    public void codebaseGrowthLabel4Radar() {
		Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Codebase_Growth_Label_Xpath));
		WebElement element = driver.findElement(By.xpath(RepoReportControls.Codebase_Growth_Label_Xpath));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();
	    Utilities.staticTimeDelay(100);
    }
    
    @AutoIntercept
    public void teamRobustnessLabel4Radar() {
		Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Team_Robustness_Label_Xpath));
		WebElement element = driver.findElement(By.xpath(RepoReportControls.Team_Robustness_Label_Xpath));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();
	    Utilities.staticTimeDelay(100);
    }
    
    @AutoIntercept
    public void teamRobustnessDetailPage4Radar() {
		Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Team_Robustness_Detail_Link_Css));
		driver.findElement(By.cssSelector(RepoReportControls.Team_Robustness_Detail_Link_Css)).click();
		Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void codebaseDrynessLabel4Radar() {
		Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Codebase_Dryness_Label_Xpath));
		WebElement element = driver.findElement(By.xpath(RepoReportControls.Codebase_Dryness_Label_Xpath));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();
	    Utilities.staticTimeDelay(100);
    }
    
    @AutoIntercept
    public void codebaseDrynessDetailPage4Radar() {
		Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Codebase_Dryness_Detail_Link_Css));
		driver.findElement(By.cssSelector(RepoReportControls.Codebase_Dryness_Detail_Link_Css)).click();
		Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void testCoverageLabel4Radar() {
		Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Test_Coverage_Label_Xpath));
		WebElement element = driver.findElement(By.xpath(RepoReportControls.Test_Coverage_Label_Xpath));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();
	    Utilities.staticTimeDelay(100);
    }
    
    @AutoIntercept
    public void testCoverageDetailPage4Radar() {
		Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Test_Coverage_Detail_Link_Css));
		driver.findElement(By.cssSelector(RepoReportControls.Test_Coverage_Detail_Link_Css)).click();
		Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void docCoverageLabel4Radar() {
		Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Doc_Coverage_Label_Xpath));
		WebElement element = driver.findElement(By.xpath(RepoReportControls.Doc_Coverage_Label_Xpath));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();
	    Utilities.staticTimeDelay(100);
    }
    
    @AutoIntercept
    public void docCoverageDetailPage4Radar() {
		Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Doc_Coverage_Detail_Link_Css));
		driver.findElement(By.cssSelector(RepoReportControls.Doc_Coverage_Detail_Link_Css)).click();
		Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public Boolean getRadarTooltip() {
    	boolean flag = driver.findElement(By.xpath(RepoReportControls.Radar_Tooltip_Xpath)).isEnabled();
    	System.out.println("Tooltip Displayed: " + flag);
    	
    	return flag;
    }
    
    @AutoIntercept
    public String getFunctionPageHeader() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Function_Page_Header_Xpath));
		String headerName = driver.findElement(By.xpath(RepoReportControls.Function_Page_Header_Xpath)).getText().trim();
		System.out.println("Function Page Header Name is: " + headerName);
		
		return headerName;
    }
    
    @AutoIntercept
    public void topContributorsAllTimeTab() {
    	Utilities.movePageToLocation(driver, "500");
		Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Top_Contributors_All_Time_Tab_Xpath));
		driver.findElement(By.xpath(RepoReportControls.Top_Contributors_All_Time_Tab_Xpath)).click();
		Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void topContributorsPastYearTab() {
		Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Top_Contributors_Past_Year_Tab_Xpath));
		driver.findElement(By.xpath(RepoReportControls.Top_Contributors_Past_Year_Tab_Xpath)).click();
		Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void topContributorsPastMonthTab() {
		Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Top_Contributors_Past_Month_Tab_Xpath));
		driver.findElement(By.xpath(RepoReportControls.Top_Contributors_Past_Month_Tab_Xpath)).click();
		Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void topContributorsPastWeekTab() {
		Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Top_Contributors_Past_Week_Tab_Xpath));
		driver.findElement(By.xpath(RepoReportControls.Top_Contributors_Past_Week_Tab_Xpath)).click();
		Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String getTopContributorsFirstLine() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Top_Contributors_List_Item_First_Css));
		String firstLine = driver.findElement(By.cssSelector(RepoReportControls.Top_Contributors_List_Item_First_Css)).getText().trim();
		System.out.println("Top Contributors First Line is: " + firstLine);
		
		return firstLine;
    }
    
    @AutoIntercept
    public void topContributorsDetailLink() {
		Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Top_Contributors_Details_Link_Css));
		driver.findElement(By.cssSelector(RepoReportControls.Top_Contributors_Details_Link_Css)).click();
		Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void topCommitsAllTimeTab() {
    	Utilities.movePageToLocation(driver, "500");
		Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Top_Commits_All_Time_Tab_Xpath));
		driver.findElement(By.xpath(RepoReportControls.Top_Commits_All_Time_Tab_Xpath)).click();
		Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void topCommitsPastYearTab() {
		Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Top_Commits_Past_Year_Tab_Xpath));
		driver.findElement(By.xpath(RepoReportControls.Top_Commits_Past_Year_Tab_Xpath)).click();
		Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void topCommitsPastMonthTab() {
		Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Top_Commits_Past_Month_Tab_Xpath));
		driver.findElement(By.xpath(RepoReportControls.Top_Commits_Past_Month_Tab_Xpath)).click();
		Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void topCommitsPastWeekTab() {
		Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Top_Commits_Past_Week_Tab_Xpath));
		driver.findElement(By.xpath(RepoReportControls.Top_Commits_Past_Week_Tab_Xpath)).click();
		Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String getTopCommitsFirstLine() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.top_commits_list_item_first_css));
		String firstLine = driver.findElement(By.cssSelector(RepoReportControls.top_commits_list_item_first_css)).getText().trim();
		System.out.println("Top Commits First Line is: " + firstLine);
		
		return firstLine;
    }
    
    @AutoIntercept
    public void topCommitsDetailLink() {
		Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Top_Commits_Details_Link_Css));
		driver.findElement(By.cssSelector(RepoReportControls.Top_Commits_Details_Link_Css)).click();
		Utilities.staticTimeDelay(2000);
    }
}
