package com.merico.selenium.test.ee.page;

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
    	String commitTitle =  driver.findElement(By.xpath(RepoReportControls.Commits_Info_Xpath)).getText().trim();
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
}
