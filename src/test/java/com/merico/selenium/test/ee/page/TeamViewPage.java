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
    	System.out.println("Productivity Label Value is: " + val);
    	
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
    
    @AutoIntercept
    public void qualityStepByMonth4TDV() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(1000);
    }
    
    @AutoIntercept
    public void qualityStepByQuarter4TDV() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(1000);
    }
    
    @AutoIntercept
    public void qualityStepByYear4TDV() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(1000);
    }
    
    @AutoIntercept
    public String getQualityLabelVal() {
    	Utilities.waitForControlPresent(driver, By.xpath(TeamViewControls.Quality_Label_Xpath));
    	String val = driver.findElement(By.xpath(TeamViewControls.Quality_Label_Xpath)).getText().trim();
    	System.out.println("Quality Label Value is: " + val);
    	
    	return val;
    }
    
    @AutoIntercept
    public void searchTeamMember4TDV() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(TeamViewControls.Team_Member_Search_Box_Css));
    	WebElement element = driver.findElement(By.cssSelector(TeamViewControls.Team_Member_Search_Box_Css));
    	element.click();
    	element.sendKeys("wei.qi");
    	Utilities.staticTimeDelay(4000);
    	Utilities.movePageToLocation(driver, "500");
    }
    
    @AutoIntercept
    public void closeTeamMemberFlag4TDV() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(TeamViewControls.Team_Member_Close_Css));
    	driver.findElement(By.cssSelector(TeamViewControls.Team_Member_Close_Css)).click();
    	Utilities.staticTimeDelay(6000);
    }
    
    @AutoIntercept
    public String getTeamMember() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(TeamViewControls.Team_Member_Email_Css));
    	String teamMember = driver.findElement(By.cssSelector(TeamViewControls.Team_Member_Email_Css)).getText().trim();
    	System.out.println("Team Member Email is: " + teamMember);
    	
    	return teamMember;
    }
    
    @AutoIntercept
    public void teamMemberSortByEfficiencyAsc4TDV() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(1000);
    }
    
    @AutoIntercept
    public String getEfficiencyDataFlag4TDV() {
    	Utilities.waitForControlPresent(driver, By.xpath(TeamViewControls.Efficiency_Data_Flag_4_Tdv_Xpath));
    	String dataFlag = driver.findElement(By.xpath(TeamViewControls.Efficiency_Data_Flag_4_Tdv_Xpath)).getText().trim();
    	System.out.println("Efficiency Data Flag for Team Detail View: " + dataFlag);
    	
    	return dataFlag;
    }
    
    @AutoIntercept
    public void teamMemberSortByQualityDesc4TDV() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(6000);
    }
    
    @AutoIntercept
    public void teamMemberSortByQualityAsc4TDV() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(6000);
    }
    
    @AutoIntercept
    public void teamMemberSortByAtoZ4TDV() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(6000);
    }
    
    @AutoIntercept
    public void teamMemberSortByZtoA4TDV() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(6000);
    }
    
    @AutoIntercept
    public String getQualityDataFlag4TDV() {
    	Utilities.waitForControlPresent(driver, By.xpath(TeamViewControls.Quality_Data_Head_Flag_4_Tdv_Xpath));
    	String dataFlag = driver.findElement(By.xpath(TeamViewControls.Quality_Data_Head_Flag_4_Tdv_Xpath)).getText().trim();
    	System.out.println("Quality Data Head Flag for Team Detail View: " + dataFlag);
    	
    	return dataFlag;
    }
    
    @AutoIntercept
    public String getQualityNoDataFlag4TDV() {
    	Utilities.waitForControlPresent(driver, By.xpath(TeamViewControls.Quality_No_data_Flag_4_Tdv_Xpath));
    	String dataFlag = driver.findElement(By.xpath(TeamViewControls.Quality_No_data_Flag_4_Tdv_Xpath)).getText().trim();
    	System.out.println("Quality No Data Flag for Team Detail View: " + dataFlag);
    	
    	return dataFlag;
    }
    
    @AutoIntercept
    public void pagingRightAngleBracket4TDV() {
    	Utilities.movePageToBottom(driver);
    	Utilities.waitForControlPresent(driver, By.cssSelector(TeamViewControls.Paging_Right_Angle_Bracket_Css));
    	driver.findElement(By.cssSelector(TeamViewControls.Paging_Right_Angle_Bracket_Css)).click();
    	Utilities.movePageToLocation(driver, "-10");
    	Utilities.staticTimeDelay(6000);
    }
    
    @AutoIntercept
    public void pagingLeftAngleBracket4TDV() {
    	Utilities.movePageToBottom(driver);
    	Utilities.waitForControlPresent(driver, By.cssSelector(TeamViewControls.Paging_Left_Angle_Bracket_Css));
    	driver.findElement(By.cssSelector(TeamViewControls.Paging_Left_Angle_Bracket_Css)).click();
    	Utilities.movePageToLocation(driver, "-10");
    	Utilities.staticTimeDelay(6000);
    }
    
    @AutoIntercept
    public void pagingToPageTwo4TDV() {
    	Utilities.movePageToBottom(driver);
    	Utilities.waitForControlPresent(driver, By.linkText("2"));
    	driver.findElement(By.linkText("2")).click();
    	Utilities.movePageToLocation(driver, "-10");
    	Utilities.staticTimeDelay(6000);
    }
    
    @AutoIntercept
    public void pagingToPageOne4TDV() {
    	Utilities.movePageToBottom(driver);
    	Utilities.waitForControlPresent(driver, By.linkText("2"));
    	driver.findElement(By.linkText("1")).click();
    	Utilities.movePageToLocation(driver, "-10");
    	Utilities.staticTimeDelay(6000);
    }
    
    @AutoIntercept
    public void pagingSwitchPage4TDV() {
    	Utilities.movePageToBottom(driver);
    	Utilities.waitForControlPresent(driver, By.cssSelector(TeamViewControls.Paging_Selection_Box_Css));
    	driver.findElement(By.cssSelector(TeamViewControls.Paging_Selection_Box_Css)).click();
    	Utilities.staticTimeDelay(500);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(6000);
    }
    
    @AutoIntercept
    public int getPagingTotalItems4TDV() {
    	Utilities.waitForControlPresent(driver, By.xpath(TeamViewControls.Paging_Total_Items_Xpath));
    	int totalPagingItemsNum = driver.findElements(By.xpath(TeamViewControls.Paging_Total_Items_Xpath)).size();
    	System.out.println("Total Paging Items Number is: " + totalPagingItemsNum);
    	
    	return totalPagingItemsNum;
    }
    
    @AutoIntercept
    public void pagingInputPage4TDV() {
    	Utilities.movePageToBottom(driver);
    	Utilities.waitForControlPresent(driver, By.cssSelector(TeamViewControls.Paging_Input_Box_Css));
    	WebElement element = driver.findElement(By.cssSelector(TeamViewControls.Paging_Input_Box_Css));
    	element.click();
    	element.sendKeys("10000");
    	
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(6000);
    	Utilities.movePageToBottom(driver);
    	builder.sendKeys(Keys.TAB);
    	builder.sendKeys("1");
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.movePageToLocation(driver, "-10");
    	Utilities.staticTimeDelay(6000);
    }
    
    @AutoIntercept
    public void DeveloperName4TDevV() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(TeamViewControls.Team_Member_Search_Box_Css));
    	WebElement element = driver.findElement(By.cssSelector(TeamViewControls.Team_Member_Search_Box_Css));
    	element.click();
    	element.sendKeys("yanghui");
    	Utilities.staticTimeDelay(4000);
    	Utilities.movePageToLocation(driver, "500");
    	Utilities.waitForControlPresent(driver, By.cssSelector(TeamViewControls.Team_Member_Primary_Email_Css));
    	driver.findElement(By.cssSelector(TeamViewControls.Team_Member_Primary_Email_Css)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String getDeveloperName4TDevV() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(TeamViewControls.Developer_Name_4_Tdevv_Css));
    	String devName = driver.findElement(By.cssSelector(TeamViewControls.Developer_Name_4_Tdevv_Css)).getText().trim();
    	System.out.println(devName);
    	
    	return devName;
    }
    
    @AutoIntercept
    public String getDeveloperEmail4TDevV() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(TeamViewControls.Developer_Email_4_Tdevv_Css));
    	String email = driver.findElement(By.cssSelector(TeamViewControls.Developer_Email_4_Tdevv_Css)).getText().trim();
    	System.out.println(email);
    	
    	return email;
    }
    
    @AutoIntercept
    public String getMainCodeRepo4TDevV() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(TeamViewControls.Main_Code_Repo_4_Tdevv_Css));
    	String mainCodeRepo = driver.findElement(By.cssSelector(TeamViewControls.Main_Code_Repo_4_Tdevv_Css)).getText().trim();
    	System.out.println(mainCodeRepo);
    	
    	return mainCodeRepo;
    }
    
    @AutoIntercept
    public String getTopSkills4TDevV() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(TeamViewControls.Top_Skills_4_Tdevv_Css));
    	String topSkills = driver.findElement(By.cssSelector(TeamViewControls.Top_Skills_4_Tdevv_Css)).getText().trim();
    	System.out.println(topSkills);
    	
    	return topSkills;
    }
    
    @AutoIntercept
    public void timeRange4PastWeek4TDevv() {
    	Actions builder = new Actions(driver);
    	for (int i = 0; i < 4; i++) {
    		builder.sendKeys(Keys.TAB).perform();
    	}
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_UP).perform();
    	builder.sendKeys(Keys.ARROW_UP).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void timeRange4PastTwoWeek4TDevv() {
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void timeRange4PastThreeMonths4TDevv() {
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void timeRange4PastOneYear4TDevv() {
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String getDevProductivityLabel4TDevV() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(TeamViewControls.Dev_Productivity_Label_Css));
    	String devProdLabel = driver.findElement(By.cssSelector(TeamViewControls.Dev_Productivity_Label_Css)).getText().trim();
    	System.out.println(devProdLabel);
    	
    	return devProdLabel;
    }
    
    @AutoIntercept
    public void devproductivityStepByWeek4TDV() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(1000);
    }
    
    @AutoIntercept
    public void devproductivityStepByMonth4TDV() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(1000);
    }
    
    @AutoIntercept
    public void devproductivityStepByQuarter4TDV() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(1000);
    }
    
    @AutoIntercept
    public void devproductivityStepByYear4TDV() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(1000);
    }
    
    @AutoIntercept
    public void codeLineOfProductivity4TDevv() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void commitNumberOfProductivity4TDevv() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(2000);
    }
}
