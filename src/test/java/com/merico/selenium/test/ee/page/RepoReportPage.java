package com.merico.selenium.test.ee.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    	Utilities.movePageToLocation(driver, "600");
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
    	Utilities.movePageToLocation(driver, "600");
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
    
    @AutoIntercept
    public Boolean manpowerAllocation() {
    	Utilities.movePageToLocation(driver, "1400");
		Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.manpower_allocation_canvas_css));
		boolean flag = driver.findElement(By.cssSelector(RepoReportControls.manpower_allocation_canvas_css)).isEnabled();
		System.out.println("Manpower Allocation Displayed: " + flag);
		
		return flag;
    }
    
    @AutoIntercept
    public void developerStrengths() {
    	Utilities.movePageToLocation(driver, "900");
		Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Developer_Strengths_Selection_Css));
		driver.findElement(By.cssSelector(RepoReportControls.Developer_Strengths_Selection_Css)).click();
		Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public Boolean getHistogram4DeveloperStrengths() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Developer_Strengths_Histogram_Xpath));
    	boolean flag = driver.findElement(By.xpath(RepoReportControls.Developer_Strengths_Histogram_Xpath)).isEnabled();
    	System.out.println("Developer Strengths Histogram Displayed: " + flag);
    	
    	return flag;
    }
    
    @AutoIntercept
    public Boolean getPie4DeveloperStrengths() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Developer_Strengths_Pie_Css));
    	boolean flag = driver.findElement(By.cssSelector(RepoReportControls.Developer_Strengths_Pie_Css)).isEnabled();
    	System.out.println("Developer Strengths Pie Displayed: " + flag);
    	
    	return flag;
    }
    
    @AutoIntercept
    public void topicTags() {
    	Utilities.movePageToLocation(driver, "800");
    	Utilities.staticTimeDelay(1000);
    }
    
    @AutoIntercept
    public Boolean getTopicTags() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Topic_Tags_Canvas_Xpath));
    	boolean flag =  driver.findElement(By.xpath(RepoReportControls.Topic_Tags_Canvas_Xpath)).isEnabled();
    	System.out.println("Topic Tags Displayed: " + flag);
    	
    	return flag;
    }
    
    @AutoIntercept
    public void contributionPerspective() {
    	Utilities.movePageToLocation(driver, "500");
    	Utilities.staticTimeDelay(1000);
    }
    
    @AutoIntercept
    public Boolean getLeftContributionPerspective() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Contribution_Perspective_Canvas_Left_Xpath));
    	boolean flag =  driver.findElement(By.xpath(RepoReportControls.Contribution_Perspective_Canvas_Left_Xpath)).isEnabled();
    	System.out.println("Contribution Perspective Left Side Displayed: " + flag);
    	
    	return flag;
    }
    
    @AutoIntercept
    public Boolean getRightContributionPerspective() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Contribution_Perspective_Canvas_Right_Xpath));
    	boolean flag =  driver.findElement(By.xpath(RepoReportControls.Contribution_Perspective_Canvas_Right_Xpath)).isEnabled();
    	System.out.println("Contribution Perspective Right Side Displayed: " + flag);
    	
    	return flag;
    }
    
    @AutoIntercept
    public void codeContributionBySalary() {
    	Utilities.movePageToLocation(driver, "400");
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Code_Contribution_And_Salary_By_Salary_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Code_Contribution_And_Salary_By_Salary_Css)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void codeContributionByLevel() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Code_Contribution_And_Salary_By_Level_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Code_Contribution_And_Salary_By_Level_Css)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public Boolean getCodeContribution() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Code_Contribution_And_Salary_Canvas_Css));
    	boolean flag =  driver.findElement(By.cssSelector(RepoReportControls.Code_Contribution_And_Salary_Canvas_Css)).isEnabled();
    	System.out.println("Code Contribution Displayed: " + flag);
    	
    	return flag;
    }
    
    @AutoIntercept
    public void codeQualityDetailLink() {
    	Utilities.movePageToLocation(driver, "400");
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Code_Quality_Issues_Detail_Link_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Code_Quality_Issues_Detail_Link_Css)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void blockIssuesLink() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Block_Issue_Link_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Block_Issue_Link_Css)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void ctriticalIssuesLink() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Critical_Issues_Link_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Critical_Issues_Link_Css)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void majorIssuesLink() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Major_Issues_Link_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Major_Issues_Link_Css)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void minorIssuesLink() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Minor_Issues_Link_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Minor_Issues_Link_Css)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void infoIssuesLink() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Info_Issues_Link_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Info_Issues_Link_Css)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void backwardAnalysis() {
    	Utilities.waitForControlPresent(driver, By.linkText(RepoReportControls.analysis_task_list_link));
    	driver.findElement(By.linkText(RepoReportControls.analysis_task_list_link)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Backward_Analysis_Btn_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Backward_Analysis_Btn_Css)).click();
    	Utilities.waitForControlPresent(driver, By.name(RepoReportControls.Due_Date_Input_Name));
    	driver.findElement(By.name(RepoReportControls.Due_Date_Input_Name)).click();
    	Utilities.waitForControlPresent(driver, By.linkText(RepoReportControls.First_Commit_Btn_Link));
    	driver.findElement(By.linkText(RepoReportControls.First_Commit_Btn_Link)).click();
    	Utilities.staticTimeDelay(1000);
    	Utilities.waitForControlPresent(driver, By.linkText(RepoReportControls.Last_Commit_Btn_Link));
    	driver.findElement(By.linkText(RepoReportControls.Last_Commit_Btn_Link)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Before_End_Of_Selected_Day_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Before_End_Of_Selected_Day_Xpath)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Analysis_Date_Submit_Btn_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Analysis_Date_Submit_Btn_Css)).click();
    	Utilities.staticTimeDelay(2000);
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Cancel_Analysis_Link_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Cancel_Analysis_Link_Css)).click();
    	Utilities.staticTimeDelay(2000);
    	WebElement element = driver.findElement(By.cssSelector(RepoReportControls.Failed_Status_Link_Css));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
        Utilities.staticTimeDelay(1000);
    }
    
    @AutoIntercept
    public String getAbnomalAnalysisInfo() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Abnormal_Info_Box_Css));
    	String info =  driver.findElement(By.cssSelector(RepoReportControls.Abnormal_Info_Box_Css)).getText().trim();
    	System.out.println("Abnormal Info is : " + info);
    	
    	return info;
    }
    
    @AutoIntercept
    public void paginationJumper4AnalysisTaskListTable() {
    	Utilities.movePageToLocation(driver, "600");
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Analysis_Task_List_Page_Jumper_Input_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Analysis_Task_List_Page_Jumper_Input_Css)).clear();
    	driver.findElement(By.cssSelector(RepoReportControls.Analysis_Task_List_Page_Jumper_Input_Css)).sendKeys("2");
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public String getPaginationFocus4AnalysisTaskList() {
    	Utilities.waitForControlPresent(driver, By.linkText("2"));
    	String cssVal =  driver.findElement(By.linkText("2")).getCssValue("color").trim();
    	System.out.println("Pagination Focus Color Value is : " + cssVal);
    	
    	return cssVal;
    }
    
    @AutoIntercept
    public void fixedPagination4AnalysisTaskListTable() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Analysis_Task_List_Page_Jumper_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Analysis_Task_List_Page_Jumper_Css)).click();
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public int getTableRowNum4AnalysisTaskList() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Analysis_Task_List_Table_Tr_Css));
    	int rowNum =  driver.findElements(By.cssSelector(RepoReportControls.Analysis_Task_List_Table_Tr_Css)).size();
    	System.out.println("Row Number is : " + rowNum);
    	
    	return rowNum;
    }
    
    @AutoIntercept
    public void commitsSearch() {
    	Utilities.waitForControlPresent(driver, By.linkText(RepoReportControls.Commits_Link_Link));
    	driver.findElement(By.linkText(RepoReportControls.Commits_Link_Link)).click();
    	Utilities.waitForControlPresent(driver, By.id(RepoReportControls.Commits_Start_Date_Textbox_Id));
    	driver.findElement(By.id(RepoReportControls.Commits_Start_Date_Textbox_Id)).click();
    	driver.findElement(By.id(RepoReportControls.Commits_Start_Date_Textbox_Id)).sendKeys("2020-01-01");
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys("2020-12-31").perform();
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys(Keys.TAB).perform();
//    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Commits_Calendar_With_This_Year_Btn_Css));
//    	driver.findElement(By.cssSelector(RepoReportControls.Commits_Calendar_With_This_Year_Btn_Css)).click();
    	Utilities.staticTimeDelay(500);
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Commits_Contributor_Textbox_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Commits_Contributor_Textbox_Css)).click();
    	Utilities.staticTimeDelay(500);  	
    	builder.sendKeys("yanghui@meri.co").perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	builder.sendKeys(Keys.ESCAPE).perform();
    	Utilities.staticTimeDelay(1000);
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Commits_Search_Btn_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Commits_Search_Btn_Css)).click();
    	Utilities.staticTimeDelay(6000);
    }
    
    @AutoIntercept
    public String getSearchResult4CommitsReport() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Commits_Info_Contributor_Email_Xpath));
    	String email =  driver.findElement(By.xpath(RepoReportControls.Commits_Info_Contributor_Email_Xpath)).getText().trim();
    	System.out.println("Email for Commits Report is : " + email);
    	
    	return email;
    }
    
    @AutoIntercept
    public void commitsSearchByTitle() {
    	Utilities.waitForControlPresent(driver, By.id(RepoReportControls.Commits_Search_Title_Textbox_Id));
    	driver.findElement(By.id(RepoReportControls.Commits_Search_Title_Textbox_Id)).click();
    	driver.findElement(By.id(RepoReportControls.Commits_Search_Title_Textbox_Id)).sendKeys("merge");
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Commits_Search_Btn_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Commits_Search_Btn_Css)).click();
    	Utilities.staticTimeDelay(4000);
    }
    
    @AutoIntercept
    public String getSearchTitleResult4CommitsReport() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Commits_Info_Xpath));
    	String commitTitle =  driver.findElement(By.xpath(RepoReportControls.Commits_Info_Xpath)).getText().trim().toLowerCase();
    	System.out.println("Commit Title for Commits Report is : " + commitTitle);
    	
    	return commitTitle;
    }
    
    @AutoIntercept
    public void commitsSearchByTitleTooltip() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Commits_Info_Xpath));
    	WebElement element = driver.findElement(By.xpath(RepoReportControls.Commits_Info_Xpath));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();
	    Utilities.staticTimeDelay(100);
    }
    
    @AutoIntercept
    public void commitsDetail() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Commits_Detail_Btn_Link_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Commits_Detail_Btn_Link_Xpath)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String getDetailInfo4CommitsReport() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Commits_Detail_Page_Dev_Val_Xpath));
    	String devVal =  driver.findElement(By.xpath(RepoReportControls.Commits_Detail_Page_Dev_Val_Xpath)).getText().trim();
    	System.out.println("Detail Page Info for Commits Report is : " + devVal);
    	
    	return devVal;
    }
    
    @AutoIntercept
    public void commitsSortByDevVal() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Dev_Val_Col_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Dev_Val_Col_Xpath)).click();
    	Utilities.staticTimeDelay(5000);
    	WebElement element = driver.findElement(By.xpath(RepoReportControls.Dev_Val_Col_Xpath));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();
	    Utilities.staticTimeDelay(100);
    }
    
    @AutoIntercept
    public void moveToCommitTimeCol() {
    	Utilities.movePageToElement(driver, By.xpath(RepoReportControls.Commits_Submit_Time_Col_Xpath));
    }
    
    @AutoIntercept
    public void commitsSortByCommitTime() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Commits_Submit_Time_Col_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Commits_Submit_Time_Col_Xpath)).click();
    	Utilities.staticTimeDelay(5000);
    }
    
    @AutoIntercept
    public void hoverToCommitTimeCol() {
    	WebElement element = driver.findElement(By.xpath(RepoReportControls.Commits_Submit_Time_Col_Xpath));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();
	    Utilities.staticTimeDelay(100);
    }
    
    @AutoIntercept
    public String getCommitTableColTooltip4CommitsReport() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Commits_Info_Tooltip_Css));
    	String tooltipVal =  driver.findElement(By.cssSelector(RepoReportControls.Commits_Info_Tooltip_Css)).getText().trim();
    	System.out.println("Commit List Table Column Tooltip for Commits Report is : " + tooltipVal);
    	
    	return tooltipVal;
    }
    
    @AutoIntercept
    public void paginationJumper4CommitsListTable() {
    	Utilities.movePageToLocation(driver, "900");
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Analysis_Task_List_Page_Jumper_Input_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Analysis_Task_List_Page_Jumper_Input_Css)).clear();
    	driver.findElement(By.cssSelector(RepoReportControls.Analysis_Task_List_Page_Jumper_Input_Css)).sendKeys("2");
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public String getPaginationFocus4CommitsTaskList() {
    	Utilities.movePageToLocation(driver, "900");
    	Utilities.waitForControlPresent(driver, By.linkText("2"));
    	String cssVal =  driver.findElement(By.linkText("2")).getCssValue("color").trim();
    	System.out.println("Pagination Focus Color Value is : " + cssVal);
    	
    	return cssVal;
    }
    
    @AutoIntercept
    public void fixedPagination4CommitsTable() {
    	WebElement element = driver.findElement(By.cssSelector(RepoReportControls.Commits_List_Page_Jumper_Css));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();
	    Utilities.staticTimeDelay(100);
    	element.click();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public int getTableRowNum4CommitsList() {
    	Utilities.movePageToLocation(driver, "900");
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Analysis_Task_List_Table_Tr_Css));
    	int rowNum =  driver.findElements(By.cssSelector(RepoReportControls.Analysis_Task_List_Table_Tr_Css)).size();
    	System.out.println("Row Number is : " + rowNum);
    	
    	return rowNum;
    }
    
    @AutoIntercept
    public void contributorsSearch() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Commits_Contributor_Textbox_Css));
    	Actions builder = new Actions(driver);
    	WebElement element = driver.findElement(By.cssSelector(RepoReportControls.Calendar_Delete_Link_Css));
    	builder.moveToElement(element).perform();
    	element.click();
    	Utilities.staticTimeDelay(500);
    	
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Commits_Contributor_Textbox_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Commits_Contributor_Textbox_Css)).click();
    	Utilities.staticTimeDelay(500);
    	
    	builder.sendKeys("yanghui@meri.co").perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	builder.sendKeys(Keys.ESCAPE).perform();
    	Utilities.staticTimeDelay(1000);
    	
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.contributors_search_btn_css));
    	driver.findElement(By.cssSelector(RepoReportControls.contributors_search_btn_css)).click();
    	Utilities.staticTimeDelay(6000);
    }
    
    @AutoIntercept
    public void contributorsSearchByCalendar() {
    	Utilities.waitForControlPresent(driver, By.linkText(RepoReportControls.Contributors_Link_Link));
    	driver.findElement(By.linkText(RepoReportControls.Contributors_Link_Link)).click();
    	
    	Utilities.waitForControlPresent(driver, By.id(RepoReportControls.Contributors_Calendar_Start_Date_Textbox_Id));
    	Actions builder = new Actions(driver);
    	WebElement element = driver.findElement(By.cssSelector(RepoReportControls.Calendar_Delete_Link_Css));
    	builder.moveToElement(element).perform();
    	element.click();
    	Utilities.staticTimeDelay(500);
    	
    	Utilities.waitForControlPresent(driver, By.id(RepoReportControls.Contributors_Calendar_Start_Date_Textbox_Id));
    	driver.findElement(By.id(RepoReportControls.Contributors_Calendar_Start_Date_Textbox_Id)).click();
    	driver.findElement(By.id(RepoReportControls.Contributors_Calendar_Start_Date_Textbox_Id)).sendKeys("2020-01-01");
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys("2020-12-31").perform();
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys(Keys.TAB).perform();
    	Utilities.staticTimeDelay(500);
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.contributors_search_btn_css));
    	driver.findElement(By.cssSelector(RepoReportControls.contributors_search_btn_css)).click();
    	Utilities.staticTimeDelay(6000);
    }
    
    @AutoIntercept
    public String getSearchResult4ContributorsReport() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.contributors_table_contributor_css));
    	String contributor =  driver.findElement(By.cssSelector(RepoReportControls.contributors_table_contributor_css)).getText().trim();
    	System.out.println("Contributor for Commits Report is : " + contributor);
    	
    	return contributor;
    }
    
    @AutoIntercept
    public void contributorsDetail() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.contributors_detail_btn_link_xpath));
    	driver.findElement(By.xpath(RepoReportControls.contributors_detail_btn_link_xpath)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void contributorsDeleteContributorFlagAndSearch() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Contributors_Contributor_Delete_Flag_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Contributors_Contributor_Delete_Flag_Css)).click();
    	Utilities.staticTimeDelay(500);
    	
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.contributors_search_btn_css));
    	driver.findElement(By.cssSelector(RepoReportControls.contributors_search_btn_css)).click();
    	Utilities.staticTimeDelay(6000);
    }
    
    @AutoIntercept
    public void contributorsSortByDevEq() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.contributors_table_dev_eq_xpath));
    	driver.findElement(By.xpath(RepoReportControls.contributors_table_dev_eq_xpath)).click();
    	Utilities.staticTimeDelay(5000);
    	Actions builder = new Actions(driver);
    	WebElement element = driver.findElement(By.xpath(RepoReportControls.contributors_table_dev_eq_xpath));
	    builder.moveToElement(element).perform();
	    Utilities.staticTimeDelay(100);
    }
    
    @AutoIntercept
    public String getContributorsTableColTooltip4ContributorsReport() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Commits_Info_Tooltip_Css));
    	String tooltipVal =  driver.findElement(By.cssSelector(RepoReportControls.Commits_Info_Tooltip_Css)).getText().trim();
    	System.out.println("Contributors List Table Column Tooltip for Commits Report is : " + tooltipVal);
    	
    	return tooltipVal;
    }
    
    @AutoIntercept
    public void paginationJumper4ContributorsListTable() {
    	Utilities.movePageToLocation(driver, "900");
    	
    	WebElement element = driver.findElement(By.cssSelector(RepoReportControls.Contributors_List_Page_Jumper_Css));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();
	    Utilities.staticTimeDelay(100);
    	element.click();
    	builder.sendKeys(Keys.ARROW_UP).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(3000);
    	
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Analysis_Task_List_Page_Jumper_Input_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Analysis_Task_List_Page_Jumper_Input_Css)).clear();
    	driver.findElement(By.cssSelector(RepoReportControls.Analysis_Task_List_Page_Jumper_Input_Css)).sendKeys("2");
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public String getPaginationFocus4ContributorsTaskList() {
    	Utilities.movePageToLocation(driver, "900");
    	Utilities.waitForControlPresent(driver, By.linkText("2"));
    	String cssVal =  driver.findElement(By.linkText("2")).getCssValue("color").trim();
    	System.out.println("Pagination Focus Color Value is : " + cssVal);
    	
    	return cssVal;
    }
    
    @AutoIntercept
    public void fixedPagination4ContributorsTable() {
    	WebElement element = driver.findElement(By.cssSelector(RepoReportControls.Contributors_List_Page_Jumper_Css));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();
	    Utilities.staticTimeDelay(100);
    	element.click();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public int getTableRowNum4ContributorsList() {
    	Utilities.movePageToLocation(driver, "900");
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Analysis_Task_List_Table_Tr_Css));
    	int rowNum =  driver.findElements(By.cssSelector(RepoReportControls.Analysis_Task_List_Table_Tr_Css)).size();
    	System.out.println("Row Number is : " + rowNum);
    	
    	return rowNum;
    }
    
    @AutoIntercept
    public void repoLineChartDisplay4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.linkText(RepoReportControls.Metrics_Trends_Link_Link));
    	driver.findElement(By.linkText(RepoReportControls.Metrics_Trends_Link_Link)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Repo_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Repo_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Line_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Line_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void repoBarChartDisplay4MetricsTrends() {
//    	Utilities.movePageToLocation(driver, "-500");
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Repo_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Repo_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void devEqLineChartDisplay4MetricsTrends() {
//    	Utilities.movePageToLocation(driver, "-500");
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Dev_Eq_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Dev_Eq_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Line_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Line_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void devEqBarChartDisplay4MetricsTrends() {
//    	Utilities.movePageToLocation(driver, "-500");
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Dev_Eq_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Dev_Eq_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void slocLineChartDisplay4MetricsTrends() {
//    	Utilities.movePageToLocation(driver, "-500");
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Sloc_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Sloc_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Line_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Line_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void slocBarChartDisplay4MetricsTrends() {
//    	Utilities.movePageToLocation(driver, "-500");
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Sloc_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Sloc_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void numOfCommitsLineChartDisplay4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Num_Of_Commits_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Num_Of_Commits_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Line_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Line_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void numOfCommitsBarChartDisplay4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Num_Of_Commits_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Num_Of_Commits_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void cycleComplexityBarChartDisplay4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Cyclomatic_Complexity_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Cyclomatic_Complexity_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void docCoverageBarChartDisplay4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Doc_Coverage_label_css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Doc_Coverage_label_css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void coverageBarChartDisplay4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Test_Coverage_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Test_Coverage_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void velocityBarChartDisplay4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Velocity_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Velocity_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void reusabilityBarChartDisplay4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Reusability_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Reusability_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void modulatityBarChartDisplay4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Modulatity_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Modulatity_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void robustnessBarChartDisplay4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Robustness_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Robustness_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void blockerIssuesBarChartDisplay4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_trends_blocker_issues_label_css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_trends_blocker_issues_label_css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void criticalIssuesBarChartDisplay4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.metrics_trends_critical_issues_label_css));
    	driver.findElement(By.cssSelector(RepoReportControls.metrics_trends_critical_issues_label_css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void majorIssuesBarChartDisplay4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Major_Issues_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Major_Issues_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void minorIssuesBarChartDisplay4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Minor_Issues_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Minor_Issues_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void infoIssuesBarChartDisplay4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Info_Issues_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Info_Issues_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void guidesBarChartDisplay4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Guides_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Guides_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void guidesQuestionMark4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Guides_Question_Mark_Xpath));
    	WebElement element = driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Guides_Question_Mark_Xpath));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();
	    Utilities.staticTimeDelay(100);
    }
    
    @AutoIntercept
    public String getTooltip4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Guides_Tooltip_Css));
    	String tooltip = driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Guides_Tooltip_Css)).getText().trim();
    	System.out.println("Metrics Trends Guides Tooltip is: " + tooltip);
    	
    	return tooltip;
    }
    
    @AutoIntercept
    public void lastWeekDisplay4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Last_Week_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Last_Week_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_By_Day_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_By_Day_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void lastMonthDisplayByDay4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Last_Month_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Last_Month_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_By_Day_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_By_Day_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void lastMonthDisplayByWeek4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Last_Month_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Last_Month_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_By_Week_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_By_Week_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void lastYearDisplayByDay4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Last_Year_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Last_Year_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_By_Day_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_By_Day_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void lastYearDisplayByWeek4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Last_Year_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Last_Year_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_By_Week_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_By_Week_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void lastYearDisplayByMonth4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Last_Year_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Last_Year_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_By_Month_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_By_Month_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void allTimeDisplayByDay4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.metrics_trends_all_time_label_css));
    	driver.findElement(By.cssSelector(RepoReportControls.metrics_trends_all_time_label_css)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_By_Day_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_By_Day_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void allTimeDisplayByWeek4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.metrics_trends_all_time_label_css));
    	driver.findElement(By.cssSelector(RepoReportControls.metrics_trends_all_time_label_css)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_By_Week_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_By_Week_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void allTimeDisplayByMonth4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.metrics_trends_all_time_label_css));
    	driver.findElement(By.cssSelector(RepoReportControls.metrics_trends_all_time_label_css)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_By_Month_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_By_Month_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void allTimeDisplayByYear4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.metrics_trends_all_time_label_css));
    	driver.findElement(By.cssSelector(RepoReportControls.metrics_trends_all_time_label_css)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_By_Year_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_By_Year_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void customSelectDate4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.xpath("//span[contains(.,'开发当量')]"));
    	driver.findElement(By.xpath("//span[contains(.,'开发当量')]")).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Custom_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Custom_Label_Css)).click();
    	
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Date_Start_Time_Textbox_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Date_Start_Time_Textbox_Css)).click();
    	Actions builder = new Actions(driver);
    	builder.sendKeys("2020-01-01").perform();
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys("2020-12-31").perform();
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys(Keys.TAB).perform();
    	Utilities.staticTimeDelay(500);
    }
    
    @AutoIntercept
    public void customLineChartDisplayByDay4MetricsTrends() {
    	customSelectDate4MetricsTrends();
    	
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_By_Day_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_By_Day_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Line_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Line_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void customBarChartDisplayByDay4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void customLineChartDisplayByWeek4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_By_Week_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_By_Week_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Line_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Line_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void customBarChartDisplayByWeek4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_By_Week_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_By_Week_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void customLineChartDisplayByMonth4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_By_Month_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_By_Month_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Line_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Line_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void customBarChartDisplayByMonth4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_By_Month_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_By_Month_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void customLineChartDisplayByYear4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_By_Year_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_By_Year_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Line_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Line_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void customBarChartDisplayByYear4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_By_Year_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_By_Year_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void collapse4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Collapse_Link_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Collapse_Link_Css)).click();
    	Utilities.staticTimeDelay(1000);
    }
    
    @AutoIntercept
    public String getCollapseInfo4MetricTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Collapse_Link_Css));
    	String info = driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Collapse_Link_Css)).getText().trim();
    	System.out.println("Collapse Info is: " + info);
    	
    	return info;
    }
    
    @AutoIntercept
    public void contributors4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Contributors_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Contributors_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Contributors_Selection_Textbox_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Contributors_Selection_Textbox_Css)).click();
    	Actions builder = new Actions(driver);
    	builder.sendKeys("runjin@meri.co").perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	builder.sendKeys(Keys.ESCAPE).perform();
    	Utilities.staticTimeDelay(500);
    }
    
    @AutoIntercept
    public void contributorsLineChartDisplay4MetricsTrends() {
    	contributors4MetricsTrends();
    	
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Line_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Line_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void contributorsBarChartDisplay4MetricsTrends() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Label_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public Boolean getLineChartCanvasDiagram4MetricTrends() {
//    	Utilities.movePageToLocation(driver, "500");
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Metrics_Trends_Line_Chart_Canvas_Css));
    	boolean canvasDisplayed = driver.findElement(By.cssSelector(RepoReportControls.Metrics_Trends_Line_Chart_Canvas_Css)).isEnabled();
    	System.out.println("Metric Trends Diagram is Displayed: " + canvasDisplayed);
    	
    	return canvasDisplayed;
    }
    
    @AutoIntercept
    public Boolean getBarChartCanvasDiagram4MetricTrends() {
//    	Utilities.movePageToLocation(driver, "500");
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Canvas_xpath));
    	boolean canvasDisplayed = driver.findElement(By.xpath(RepoReportControls.Metrics_Trends_Bar_Chart_Canvas_xpath)).isEnabled();
    	System.out.println("Metric Trends Diagram is Displayed: " + canvasDisplayed);
    	
    	return canvasDisplayed;
    }
    
    @AutoIntercept
    public void branchHashCopy4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.linkText(RepoReportControls.Report_Problems_Link_Link));
    	driver.findElement(By.linkText(RepoReportControls.Report_Problems_Link_Link)).click();
    	Utilities.staticTimeDelay(2000);
    	
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Report_Problems_Info_Svg_Xpath));
    	WebElement element = driver.findElement(By.xpath(RepoReportControls.Report_Problems_Info_Svg_Xpath));
    	Actions builder = new Actions(driver);
    	builder.moveToElement(element).perform();
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Report_Problems_Info_Hash_Copy_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Report_Problems_Info_Hash_Copy_Css)).click();
    	Utilities.staticTimeDelay(500);
    }
    
    @AutoIntercept
    public String getBranchHashCopyTooltip4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Report_Problems_Info_Hash_Copy_Tooltip_Css));
    	String tooltip = driver.findElement(By.cssSelector(RepoReportControls.Report_Problems_Info_Hash_Copy_Tooltip_Css)).getText().trim();
    	System.out.println("Branch Hash is: " + tooltip);
    	
    	return tooltip;
    }
    
    @AutoIntercept
    public void selectBranch4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Report_Problems_Select_Branch_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Report_Problems_Select_Branch_Css)).click();
    	Actions builder = new Actions(driver);
    	for (int i = 0; i < 4; i++) {
    		builder.sendKeys(Keys.ARROW_DOWN).perform();
    	}
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(500);
    }
    
    @AutoIntercept
    public void branchCompare4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Report_Problems_Another_Branch_Checkbox_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Report_Problems_Another_Branch_Checkbox_Xpath)).click();
    	Utilities.staticTimeDelay(500);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.TAB).perform();
    	for (int i = 0; i < 6; i++) {
    		builder.sendKeys(Keys.ARROW_DOWN).perform();
    	}
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(500);
    }
    
    @AutoIntercept
    public void unCheckBranchCompare4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Report_Problems_Another_Branch_Checkbox_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Report_Problems_Another_Branch_Checkbox_Xpath)).click();
    	Utilities.staticTimeDelay(500);
    }
    
    @AutoIntercept
    public String getTotalIssuesNum4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Report_Problems_Total_Issues_Num_Label_Css));
    	String info = driver.findElement(By.cssSelector(RepoReportControls.Report_Problems_Total_Issues_Num_Label_Css)).getText().trim();
    	System.out.println("Total Issues Number Info is: " + info);
    	
    	return info;
    }
    
    @AutoIntercept
    public void newAnalysisRefresh4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Report_Problems_New_Analysis_Btn_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Report_Problems_New_Analysis_Btn_Xpath)).click();
    	Utilities.staticTimeDelay(1000);
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Report_Problems_New_Analysis_Refresh_Btn_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Report_Problems_New_Analysis_Refresh_Btn_Css)).click();
    	Utilities.staticTimeDelay(2000);
    	
    }
    
    @AutoIntercept
    public void newAnalysisDialogCancelBtn4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Report_Problems_New_Analysis_Cancel_Btn_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Report_Problems_New_Analysis_Cancel_Btn_Css)).click();
    	Utilities.staticTimeDelay(1000);
    }
    
    @AutoIntercept
    public String getNewAnalysisBranchRefresh4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Report_Problems_New_Analysis_Branch_Hash_Info_Css));
    	String info = driver.findElement(By.cssSelector(RepoReportControls.Report_Problems_New_Analysis_Branch_Hash_Info_Css)).getText().trim();
    	System.out.println("New Analysis Branch Refresh Info is: " + info);
    	
    	return info;
    }
    
    @AutoIntercept
    public void searchByAuthor4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Report_Problems_All_Authors_Dropdown_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Report_Problems_All_Authors_Dropdown_Xpath)).click();
    	Utilities.staticTimeDelay(500);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ENTER).perform();
    	builder.sendKeys(Keys.ESCAPE).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void clearAuthor4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.xpath("(//div[@class='ant-select-selector'])[3]"));
    	driver.findElement(By.xpath("(//div[@class='ant-select-selector'])[3]")).click();
    	Utilities.staticTimeDelay(500);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.BACK_SPACE).perform();
    	builder.sendKeys(Keys.ESCAPE).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String getSearchResultByAuthor4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Report_Problems_Author_Alone_Label_Xpath));
    	String author = driver.findElement(By.xpath(RepoReportControls.Report_Problems_Author_Alone_Label_Xpath)).getText().trim();
    	System.out.println("Search Result By Author is: " + author);
    	
    	return author;
    }
    
    @AutoIntercept
    public void searchByRule4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Report_Problems_All_Rules_Dropdown_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Report_Problems_All_Rules_Dropdown_Xpath)).click();
    	Utilities.staticTimeDelay(500);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ENTER).perform();
    	builder.sendKeys(Keys.ESCAPE).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void clearRule4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.xpath("(//div[@class='ant-select-selector'])[4]"));
    	driver.findElement(By.xpath("(//div[@class='ant-select-selector'])[4]")).click();
    	Utilities.staticTimeDelay(500);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.BACK_SPACE).perform();
    	builder.sendKeys(Keys.ESCAPE).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String getSearchResultByRule4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Report_Problems_Rule_Alone_Label_Xpath));
    	String rule = driver.findElement(By.xpath(RepoReportControls.Report_Problems_Rule_Alone_Label_Xpath)).getText().trim();
    	System.out.println("Search Result By Rule is: " + rule);
    	
    	return rule;
    }
    
    @AutoIntercept
    public void searchByType4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Report_Problems_All_Types_Dropdown_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Report_Problems_All_Types_Dropdown_Xpath)).click();
    	Utilities.staticTimeDelay(500);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ENTER).perform();
    	builder.sendKeys(Keys.ESCAPE).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void clearType4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.xpath("(//div[@class='ant-select-selector'])[5]"));
    	driver.findElement(By.xpath("(//div[@class='ant-select-selector'])[5]")).click();
    	Utilities.staticTimeDelay(500);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.BACK_SPACE).perform();
    	builder.sendKeys(Keys.ESCAPE).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String getSearchResultByType4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Report_Problems_Type_Alone_Label_Xpath));
    	String type = driver.findElement(By.xpath(RepoReportControls.Report_Problems_Type_Alone_Label_Xpath)).getText().trim();
    	System.out.println("Search Result By Type is: " + type);
    	
    	return type;
    }
    
    @AutoIntercept
    public void searchBySeverity4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Report_Problems_Severities_Dropdown_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Report_Problems_Severities_Dropdown_Xpath)).click();
    	Utilities.staticTimeDelay(500);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ENTER).perform();
    	builder.sendKeys(Keys.ESCAPE).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void clearSeverity4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.xpath("(//div[@class='ant-select-selector'])[6]"));
    	driver.findElement(By.xpath("(//div[@class='ant-select-selector'])[6]")).click();
    	Utilities.staticTimeDelay(500);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.BACK_SPACE).perform();
    	builder.sendKeys(Keys.ESCAPE).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String getSearchResultBySeverity4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Report_Problems_Severity_Alone_Label_Xpath));
    	String severity = driver.findElement(By.xpath(RepoReportControls.Report_Problems_Severity_Alone_Label_Xpath)).getText().trim();
    	System.out.println("Search Result By Severity is: " + severity);
    	
    	return severity;
    }
    
    @AutoIntercept
    public void searchByFile4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Report_Problems_Unix_Glob_Syntax_Textbox_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Report_Problems_Unix_Glob_Syntax_Textbox_Xpath)).click();
    	Utilities.staticTimeDelay(500);
    	Actions builder = new Actions(driver);
    	builder.sendKeys("*.js").perform();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void clearFile4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Report_Problems_Unix_Glob_Syntax_Textbox_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Report_Problems_Unix_Glob_Syntax_Textbox_Xpath)).click();
    	Utilities.staticTimeDelay(500);
    	Actions builder = new Actions(driver);
    	for (int i = 0; i < 4; i++)	{
    		builder.sendKeys(Keys.BACK_SPACE).perform();
    	}
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public String getSearchResultByFile4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Report_Problems_File_Alone_Label_Css));
    	String file = driver.findElement(By.cssSelector(RepoReportControls.Report_Problems_File_Alone_Label_Css)).getText().trim();
    	System.out.println("Search Result By File is: " + file);
    	
    	return file;
    }
    
    @AutoIntercept
    public String getSearchResultByFileDiagram4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Report_Problems_File_Diagram_Label_Xpath));
    	String file = driver.findElement(By.xpath(RepoReportControls.Report_Problems_File_Diagram_Label_Xpath)).getText().trim();
    	System.out.println("Search Result By File Diagram is: " + file);
    	
    	return file;
    }
    
    @AutoIntercept
    public Boolean getSearchResultByFileSource4ReportProblems() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Report_Problems_File_Source_Xpath));
    	boolean flag = driver.findElement(By.xpath(RepoReportControls.Report_Problems_File_Source_Xpath)).isEnabled();	
    	System.out.println("Source File Diagram Displayed: " + flag);
    	
    	return flag;
    }
    
    @AutoIntercept
    public void paginationJumper4ReportProblems() {
    	WebElement element = driver.findElement(By.xpath(RepoReportControls.Report_Problems_Page_Fixed_Jumper_Xpath));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();
	    Utilities.movePageToLocation(driver, "900");
	    Utilities.staticTimeDelay(100);
    	element.click();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(3000);
    	
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Report_Problems_Page_Jumper_Input_Textbox_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Report_Problems_Page_Jumper_Input_Textbox_Xpath)).clear();
    	driver.findElement(By.xpath(RepoReportControls.Report_Problems_Page_Jumper_Input_Textbox_Xpath)).sendKeys("2");
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public String getPaginationFocus4ReportProblems() {
//    	Utilities.movePageToLocation(driver, "900");
    	Utilities.waitForControlPresent(driver, By.linkText("2"));
    	String cssVal =  driver.findElement(By.linkText("2")).getCssValue("color").trim();
    	System.out.println("Pagination Focus Color Value is : " + cssVal);
    	
    	return cssVal;
    }
    
    @AutoIntercept
    public void fixedPagination4ReportProblems() {
    	WebElement element = driver.findElement(By.xpath(RepoReportControls.Report_Problems_Page_Fixed_Jumper_Xpath));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();
	    Utilities.staticTimeDelay(100);
    	element.click();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public int getTableRowNum4ReportProblems() {
//    	Utilities.movePageToLocation(driver, "900");
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Report_Problems_Page_Row_Count_Css));
    	int rowNum =  driver.findElements(By.cssSelector(RepoReportControls.Report_Problems_Page_Row_Count_Css)).size();
    	System.out.println("Row Number is : " + rowNum);
    	
    	return rowNum;
    }
    
    @AutoIntercept
    public void branchHashCopy4CodeDuplicates() {
    	Utilities.waitForControlPresent(driver, By.linkText(RepoReportControls.Code_Duplicates_Link_Link));
    	driver.findElement(By.linkText(RepoReportControls.Code_Duplicates_Link_Link)).click();
    	Utilities.staticTimeDelay(2000);
    	
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Code_Duplicates_Info_Svg_Xpath));
    	WebElement element = driver.findElement(By.xpath(RepoReportControls.Code_Duplicates_Info_Svg_Xpath));
    	Actions builder = new Actions(driver);
    	builder.moveToElement(element).perform();
    	Utilities.staticTimeDelay(500);
    	List<WebElement> elements = driver.findElements(By.cssSelector(RepoReportControls.Code_Duplicates_Info_Hash_Copy_Css));
    	elements.get(elements.size() - 1).click();
    	Utilities.staticTimeDelay(500);
    }
    
    @AutoIntercept
    public String getBranchHashCopyTooltip4CodeDuplicates() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Code_Duplicates_Info_Hash_Copy_Tooltip_Xpath));
    	String tooltip = driver.findElement(By.xpath(RepoReportControls.Code_Duplicates_Info_Hash_Copy_Tooltip_Xpath)).getText().trim();
    	System.out.println("Branch Hash is: " + tooltip);
    	
    	return tooltip;
    }
    
    @AutoIntercept
    public void selectBranch4CodeProblems() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Code_Duplicates_Select_Branch_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Code_Duplicates_Select_Branch_Css)).click();
    	Actions builder = new Actions(driver);
    	for (int i = 0; i < 4; i++) {
    		builder.sendKeys(Keys.ARROW_DOWN).perform();
    	}
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public String getGroup4CodeDuplicates() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Code_Duplicates_Group_Label_Xpath));
    	String group = driver.findElement(By.xpath(RepoReportControls.Code_Duplicates_Group_Label_Xpath)).getText().trim();
    	System.out.println("Group is: " + group);
    	
    	return group;
    }
    
    @AutoIntercept
    public Boolean getFile4CodeDuplicates() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Code_Duplicates_Code_File_Label_Xpath));
    	boolean flag = driver.findElement(By.xpath(RepoReportControls.Code_Duplicates_Code_File_Label_Xpath)).isEnabled();
    	System.out.println("File is Displayed: " + flag);
    	
    	return flag;
    }
    
    @AutoIntercept
    public Boolean getSource4CodeDuplicates() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Code_Duplicates_Source_Line_Xpath));
    	boolean flag = driver.findElement(By.xpath(RepoReportControls.Code_Duplicates_Source_Line_Xpath)).isEnabled();
    	System.out.println("Source is: " + flag);
    	
    	return flag;
    }
    
    @AutoIntercept
    public void selectFileToCompare4CodeDuplicates() {
    	Utilities.staticTimeDelay(1000);
    	driver.findElements(By.xpath(RepoReportControls.Code_Duplicates_File_Checkbox_Xpath)).get(0).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public String getCompareTooltip4CodeDuplicates() {
    	Utilities.waitForControlPresent(driver, By.xpath("(//div[@class='ant-tooltip-inner'])[1]"));
    	String tooltip = driver.findElement(By.xpath("(//div[@class='ant-tooltip-inner'])[1]")).getText().trim();
    	System.out.println("Compare Tooltip is: " + tooltip);
    	
    	return tooltip;
    }
    
    @AutoIntercept
    public void fixedPagination4CodeDuplicates() {
    	Utilities.movePageToLocation(driver, "1000");
    	WebElement element = driver.findElement(By.xpath(RepoReportControls.Code_Duplicates_Page_Fixed_Jumper_Xpath));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();
	    Utilities.staticTimeDelay(100);
    	element.click();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public int getTableRowNum4CodeDuplicates() {
    	Utilities.movePageToLocation(driver, "1000");
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Code_Duplicates_Page_Row_Count_Css));
    	int rowNum =  driver.findElements(By.cssSelector(RepoReportControls.Code_Duplicates_Page_Row_Count_Css)).size();
    	System.out.println("Row Number is : " + rowNum);
    	
    	return rowNum;
    }
    
    @AutoIntercept
    public void branchHashCopy4TestCoverage() {
    	Utilities.waitForControlPresent(driver, By.linkText(RepoReportControls.Test_Coverage_Link_Link));
    	driver.findElement(By.linkText(RepoReportControls.Test_Coverage_Link_Link)).click();
    	Utilities.staticTimeDelay(2000);
    	
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Test_Coverage_Info_Svg_Xpath));
    	WebElement element = driver.findElement(By.xpath(RepoReportControls.Test_Coverage_Info_Svg_Xpath));
    	Actions builder = new Actions(driver);
    	builder.moveToElement(element).perform();
    	Utilities.staticTimeDelay(500);
    	List<WebElement> elements = driver.findElements(By.cssSelector(RepoReportControls.Test_Coverage_Info_Hash_Copy_Css));
    	elements.get(elements.size() - 1).click();
    	Utilities.staticTimeDelay(500);
    }
    
    @AutoIntercept
    public String getHashCopyTooltip4TestCoverage() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Test_Coverage_Info_Hash_Copy_Tooltip_Xpath));
    	String tooltip = driver.findElement(By.xpath(RepoReportControls.Test_Coverage_Info_Hash_Copy_Tooltip_Xpath)).getText().trim();
    	System.out.println("Branch Hash is: " + tooltip);
    	
    	return tooltip;
    }
    
    @AutoIntercept
    public void selectBranch4TestCoverage() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Test_Coverage_Select_Branch_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Test_Coverage_Select_Branch_Css)).click();
    	Actions builder = new Actions(driver);
    	for (int i = 0; i < 4; i++) {
    		builder.sendKeys(Keys.ARROW_DOWN).perform();
    	}
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public Boolean getCanvas4TestCoverage() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Test_Coverage_Canvas_Xpath));
    	boolean flag = driver.findElement(By.xpath(RepoReportControls.Test_Coverage_Canvas_Xpath)).isEnabled();
    	System.out.println("Canvas is Displayed: " + flag);
    	
    	return flag;
    }
    
    @AutoIntercept
    public int getAllCanvas4TestCoverage() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Test_Coverage_All_Canvas_Css));
    	int count = driver.findElements(By.cssSelector(RepoReportControls.Test_Coverage_All_Canvas_Css)).size();
    	System.out.println("Canvas Count is: " + count);
    	
    	return count;
    }
    
    @AutoIntercept
    public void uncoveredFunctionsFileTooltip4TestCoverage() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.test_coverage_uncovered_functions_file_name_label_css));
    	WebElement element = driver.findElement(By.cssSelector(RepoReportControls.test_coverage_uncovered_functions_file_name_label_css));
    	Actions builder = new Actions(driver);
    	builder.moveToElement(element).perform();
    	Utilities.staticTimeDelay(100);
    }
    
    @AutoIntercept
    public String getUncoveredFunctionsFileTooltip4TestCoverage() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Test_Coverage_Tooltip_Css));
    	List<WebElement> elements = driver.findElements(By.cssSelector(RepoReportControls.Test_Coverage_Tooltip_Css));
    	String tooltip = elements.get(0).getText().trim();
    	System.out.println("Uncovered Funtions File Tooltip is: " + tooltip);
    	
    	return tooltip;
    }
    
    @AutoIntercept
    public void uncoveredFunctionsLoadMore4TestCoverage() {
    	WebElement element = driver.findElement(By.cssSelector(RepoReportControls.Test_Coverage_Uncovered_Functions_Load_More_Btn_Css));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();
	    Utilities.staticTimeDelay(100);
//	    Utilities.movePageToElement(driver, By.cssSelector(RepoReportControls.Test_Coverage_Uncovered_Functions_Load_More_Btn_Css));
//	    Utilities.movePageToLocation(driver, "50");
	    for (int i = 0; i < 2; i++) {
	    	builder.sendKeys(Keys.TAB).perform();
	    }
	    builder.sendKeys(Keys.ENTER).perform();
//    	element.click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public Boolean getUncoveredFunctionsItems4TestCoverage() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Test_Coverage_Uncovered_Functions_Items_Xpath));
    	boolean flag = driver.findElement(By.xpath(RepoReportControls.Test_Coverage_Uncovered_Functions_Items_Xpath)).isEnabled();
    	System.out.println("Uncovered Functions is Displayed: " + flag);
    	
    	return flag;
    }
    
    @AutoIntercept
    public void sortByRepoName4TestCoverage() {
    	Utilities.movePageToLocation(driver, "300");
    	for (int i = 0; i < 3; i++) {
    		Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Test_Coverage_Files_Table_Repo_Col_Xpath));
        	driver.findElement(By.xpath(RepoReportControls.Test_Coverage_Files_Table_Repo_Col_Xpath)).click();
        	Utilities.staticTimeDelay(1000);
    	}
    }
    
    @AutoIntercept
    public String getRepoColTooltip4TestCoverage() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Test_Coverage_Files_Table_Repo_Col_Xpath));
    	WebElement element = driver.findElement(By.xpath(RepoReportControls.Test_Coverage_Files_Table_Repo_Col_Xpath));
    	Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();

	    List<WebElement> elements = driver.findElements(By.cssSelector(RepoReportControls.Test_Coverage_Tooltip_Css));
    	int size = elements.size();
    	String tooltip = elements.get(size - 1).getText().trim();
    	System.out.println("Repo Column Tooltip is: " + tooltip);
    	
    	return tooltip;
    }
    
    @AutoIntercept
    public void sortByFilePath4TestCoverage() {
    	for (int i = 0; i < 3; i++) {
    		Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Test_Coverage_Files_Table_File_Path_Col_Xpath));
        	driver.findElement(By.xpath(RepoReportControls.Test_Coverage_Files_Table_File_Path_Col_Xpath)).click();
        	Utilities.staticTimeDelay(1000);
    	}
    }
    
    @AutoIntercept
    public String getFilePathColTooltip4TestCoverage() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Test_Coverage_Files_Table_File_Path_Col_Xpath));
    	WebElement element = driver.findElement(By.xpath(RepoReportControls.Test_Coverage_Files_Table_File_Path_Col_Xpath));
    	Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();

	    List<WebElement> elements = driver.findElements(By.cssSelector(RepoReportControls.Test_Coverage_Tooltip_Css));
    	int size = elements.size();
    	String tooltip = elements.get(size - 1).getText().trim();
    	System.out.println("File Path Column Tooltip is: " + tooltip);
    	
    	return tooltip;
    }
    
    @AutoIntercept
    public void sortByFileCoverage4TestCoverage() {
    	for (int i = 0; i < 3; i++) {
    		Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Test_Coverage_Files_Coverage_Col_Xpath));
        	driver.findElement(By.xpath(RepoReportControls.Test_Coverage_Files_Coverage_Col_Xpath)).click();
        	Utilities.staticTimeDelay(1000);
    	}
    }
    
    @AutoIntercept
    public String getFileCoverageColTooltip4TestCoverage() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Test_Coverage_Files_Coverage_Col_Xpath));
    	WebElement element = driver.findElement(By.xpath(RepoReportControls.Test_Coverage_Files_Coverage_Col_Xpath));
    	Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();

	    List<WebElement> elements = driver.findElements(By.cssSelector(RepoReportControls.Test_Coverage_Tooltip_Css));
    	int size = elements.size();
    	String tooltip = elements.get(size - 1).getText().trim();
    	System.out.println("File Coverage Column Tooltip is: " + tooltip);
    	
    	return tooltip;
    }
    
    @AutoIntercept
    public void fileCoverageLoadMore4TestCoverage() {
    	Utilities.movePageToLocation(driver, "1200");
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Test_Coverage_By_Files_Load_More_Btn_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Test_Coverage_By_Files_Load_More_Btn_Css)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public int getFileCoverageTableRowCount4TestCoverage() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Test_Coverage_By_Files_Table_Row_Xpath));
    	int rowCount = driver.findElements(By.xpath(RepoReportControls.Test_Coverage_By_Files_Table_Row_Xpath)).size();
    	System.out.println("File Coverage Table Row Count is: " + rowCount);
    	
    	return rowCount;
    }
    
    @AutoIntercept
    public void branchHashCopy4DocCoverage() {
    	Utilities.waitForControlPresent(driver, By.linkText(RepoReportControls.Doc_Coverage_Link_Link));
    	driver.findElement(By.linkText(RepoReportControls.Doc_Coverage_Link_Link)).click();
    	Utilities.staticTimeDelay(2000);
    	
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Test_Coverage_Info_Svg_Xpath));
    	WebElement element = driver.findElement(By.xpath(RepoReportControls.Test_Coverage_Info_Svg_Xpath));
    	Actions builder = new Actions(driver);
    	builder.moveToElement(element).perform();
    	Utilities.staticTimeDelay(500);
    	List<WebElement> elements = driver.findElements(By.cssSelector(RepoReportControls.Test_Coverage_Info_Hash_Copy_Css));
    	elements.get(elements.size() - 1).click();
    	Utilities.staticTimeDelay(500);
    }
    
    @AutoIntercept
    public void branchHashCopy4ComplexityFunctions() {
    	Utilities.waitForControlPresent(driver, By.linkText(RepoReportControls.Complexity_Functions_Link_Link));
    	driver.findElement(By.linkText(RepoReportControls.Complexity_Functions_Link_Link)).click();
    	Utilities.staticTimeDelay(2000);
    	
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Complexity_Functions_Branch_Collapse_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Complexity_Functions_Branch_Collapse_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Complexity_Functions_Hash_Copy_Btn_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Complexity_Functions_Hash_Copy_Btn_Xpath)).click();
    	Utilities.staticTimeDelay(500);
    }
    
    @AutoIntercept
    public String getHashCopyTooltip4ComplexityFunctions() {
    	List<WebElement> elements = driver.findElements(By.cssSelector(RepoReportControls.Complexity_Functions_Hash_Copy_Tooltip_Css));
    	int size = elements.size();
    	String tooltip = elements.get(size - 1).getText().trim();
    	System.out.println(tooltip);
    	
    	return tooltip;
    }
    
    @AutoIntercept
    public void sortBySignature4ComplexityFunctions() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Complexity_Functions_Branch_Collapse_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Complexity_Functions_Branch_Collapse_Css)).click();
    	Utilities.staticTimeDelay(1000);
    	for (int i = 0; i < 4; i++) {
    		Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Complexity_Functions_Signature_Col_Xpath));
        	driver.findElement(By.xpath(RepoReportControls.Complexity_Functions_Signature_Col_Xpath)).click();
        	Utilities.staticTimeDelay(2000);
    	}
    }
    
    @AutoIntercept
    public String getSignatureColTooltip4ComplexityFunctions() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Complexity_Functions_Signature_Col_Xpath));
    	WebElement element = driver.findElement(By.xpath(RepoReportControls.Complexity_Functions_Signature_Col_Xpath));
    	Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();
	    Utilities.staticTimeDelay(100);
	    WebElement element1 = driver.findElement(By.xpath(RepoReportControls.Complexity_Functions_Tooltip_Xpath));
    	
    	String tooltip = element1.getText().trim();
    	System.out.println("Signature Column Tooltip is: " + tooltip);
    	
    	return tooltip;
    }
    
    @AutoIntercept
    public void filterByLocation4ComplexityFunctions() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Complexity_Functions_Filter_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Complexity_Functions_Filter_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.name(RepoReportControls.Complexity_Functions_Filter_Textbox_Name));
    	driver.findElement(By.name(RepoReportControls.Complexity_Functions_Filter_Textbox_Name)).click();
    	driver.findElement(By.name(RepoReportControls.Complexity_Functions_Filter_Textbox_Name)).clear();
    	driver.findElement(By.name(RepoReportControls.Complexity_Functions_Filter_Textbox_Name)).sendKeys("*.ts");
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Complexity_Functions_Filter_Confirm_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Complexity_Functions_Filter_Confirm_Xpath)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void resetFilterByLocation4ComplexityFunctions() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Complexity_Functions_Filter_Label_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Complexity_Functions_Filter_Label_Css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Complexity_Functions_Filter_Reset_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Complexity_Functions_Filter_Reset_Xpath)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String getFilterByLocationResult4ComplexityFunctions() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Complexity_Functions_Table_Row_Col_Xpath));
    	String name = driver.findElement(By.xpath(RepoReportControls.Complexity_Functions_Table_Row_Col_Xpath)).getText().trim();
    	System.out.println("Filter Result By Location is: " + name);
    	
    	return name;
    }
    
    @AutoIntercept
    public void paginationJumper4ComplexityFunctions() {
    	WebElement element = driver.findElement(By.xpath(RepoReportControls.Complexity_Functions_Page_Fixed_Jumper_Xpath));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();
	    Utilities.movePageToLocation(driver, "900");
	    Utilities.staticTimeDelay(100);
    	element.click();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(3000);
    	
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Complexity_Functions_Page_Jumper_Input_Textbox_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Complexity_Functions_Page_Jumper_Input_Textbox_Xpath)).clear();
    	driver.findElement(By.xpath(RepoReportControls.Complexity_Functions_Page_Jumper_Input_Textbox_Xpath)).sendKeys("2");
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public String getPaginationFocus4ComplexityFunctions() {
//    	Utilities.movePageToLocation(driver, "900");
    	Utilities.waitForControlPresent(driver, By.linkText("2"));
    	String cssVal =  driver.findElement(By.linkText("2")).getCssValue("color").trim();
    	System.out.println("Pagination Focus Color Value is : " + cssVal);
    	
    	return cssVal;
    }
    
    @AutoIntercept
    public void fixedPagination4ComplexityFunctions() {
    	WebElement element = driver.findElement(By.xpath(RepoReportControls.Complexity_Functions_Page_Fixed_Jumper_Xpath));
	    Actions builder = new Actions(driver);
	    builder.moveToElement(element).perform();
	    Utilities.staticTimeDelay(100);
    	element.click();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public int getTableRowNum4ComplexityFunctions() {
//    	Utilities.movePageToLocation(driver, "900");
    	int rowNum =  driver.findElements(By.xpath(RepoReportControls.Complexity_Functions_Table_Row_Xpath)).size();
    	System.out.println("Row Number is : " + rowNum);
    	
    	return rowNum;
    }
    
    @AutoIntercept
    public void canvasDisplay4RankingList() {
    	Utilities.waitForControlPresent(driver, By.linkText(RepoReportControls.Ranking_List_Link_Link));
    	driver.findElement(By.linkText(RepoReportControls.Ranking_List_Link_Link)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public Boolean getAllCanvasDisplay4RankingList() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Ranking_List_Dev_Value_Canvas_Xpath));
    	boolean canvas4DevVal = driver.findElement(By.xpath(RepoReportControls.Ranking_List_Dev_Value_Canvas_Xpath)).isEnabled();
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Ranking_List_Dev_Eq_Canvas_Xpath));
    	boolean canvas4DevEq = driver.findElement(By.xpath(RepoReportControls.Ranking_List_Dev_Eq_Canvas_Xpath)).isEnabled();
    	System.out.println("Canvas Dev Val is Displayed: " + canvas4DevVal);
    	System.out.println("Canvas Dev Eq is Displayed: " + canvas4DevVal);
    	
    	return canvas4DevVal && canvas4DevEq;
    }
    
    @AutoIntercept
    public void canvasDisplayByDate4RankingList() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Ranking_List_Start_Date_Textbox_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Ranking_List_Start_Date_Textbox_Xpath)).click();
    	driver.findElement(By.xpath(RepoReportControls.Ranking_List_Start_Date_Textbox_Xpath)).clear();
    	driver.findElement(By.xpath(RepoReportControls.Ranking_List_Start_Date_Textbox_Xpath)).sendKeys("2020-01-01");
    	driver.findElement(By.xpath(RepoReportControls.Ranking_List_End_Date_Textbox_Xpath)).click();
    	driver.findElement(By.xpath(RepoReportControls.Ranking_List_End_Date_Textbox_Xpath)).clear();
    	driver.findElement(By.xpath(RepoReportControls.Ranking_List_End_Date_Textbox_Xpath)).sendKeys("2020-12-31");
    	
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys(Keys.TAB).perform();
    	Utilities.staticTimeDelay(1000);
    }
    
    @AutoIntercept
    public String getCanvasDisplayMsgByDate4RankingList() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Ranking_List_Alert_Msg_Label_Css));
    	String prompt = driver.findElement(By.cssSelector(RepoReportControls.Ranking_List_Alert_Msg_Label_Css)).getText().trim();
    	System.out.println("Ranking List Prompt Msg: " + prompt);
    	
    	return prompt;
    }
    
    @AutoIntercept
    public void contributorMainPage4RankingList() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Ranking_List_Contributor_Link_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Ranking_List_Contributor_Link_Xpath)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String getContributorInfo4RankingList() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Function_Page_Header_Xpath));
    	String info = driver.findElement(By.xpath(RepoReportControls.Function_Page_Header_Xpath)).getText().trim();
    	System.out.println("Contributor Header is: " + info);
    	
    	return info;
    }
    
    @AutoIntercept
    public void talentSearch4TalentSearch() {
    	Utilities.waitForControlPresent(driver, By.linkText(RepoReportControls.Talent_Search_Link_Link));
    	driver.findElement(By.linkText(RepoReportControls.Talent_Search_Link_Link)).click();
    	Utilities.staticTimeDelay(2000);

    	Actions builder = new Actions(driver);
    	for (int i = 0; i < 4; i++) {
    		builder.sendKeys(Keys.TAB).perform();
    	}
    	builder.sendKeys("远程过程调用").perform();
    	Utilities.staticTimeDelay(500);
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void talentSearchLonely4TalentSearch() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(RepoReportControls.Talent_Search_Close_Talent_Tag_Css));
    	driver.findElement(By.cssSelector(RepoReportControls.Talent_Search_Close_Talent_Tag_Css)).click();
    	Utilities.staticTimeDelay(2000);
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Talent_Search_Tech_Tag_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Talent_Search_Tech_Tag_Xpath)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String talentSearchResult4TalentSearch() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Talent_Search_Tech_Tag_Xpath));
    	String cssVal = driver.findElement(By.xpath(RepoReportControls.Talent_Search_Tech_Tag_Xpath)).getCssValue("background").trim();
    	System.out.println("Talent Search Tech Tag CSS Attribute is: " + cssVal);
    	
    	return cssVal;
    }
    
    @AutoIntercept
    public void viewIndividualDetail4TalentSearch() {
    	Utilities.movePageToLocation(driver, "300");
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Talent_Search_View_Individual_Detail_Info_Xpath));
    	driver.findElement(By.xpath(RepoReportControls.Talent_Search_View_Individual_Detail_Info_Xpath)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String getIndividualDetail4TalentSearch() {
    	Utilities.waitForControlPresent(driver, By.xpath(RepoReportControls.Function_Page_Header_Xpath));
    	String info = driver.findElement(By.xpath(RepoReportControls.Function_Page_Header_Xpath)).getText().trim();
    	System.out.println("Contributor Header is: " + info);
    	
    	return info;
    }
}
