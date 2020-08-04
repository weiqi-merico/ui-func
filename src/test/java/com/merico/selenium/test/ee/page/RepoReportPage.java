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
}
