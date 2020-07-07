package com.merico.selenium.test.ee.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.merico.selenium.autoscreenshot.AutoIntercept;
import com.merico.selenium.page.Page;
import com.merico.selenium.test.ee.control.AddRepoControls;
import com.merico.selenium.test.ee.utils.Utilities;

public class AddRepoPage extends Page {
    public AddRepoPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isLoaded() {
        // No Ajax content, which can be considered to create the Page object has finished loading.
        return true;
    }

    @AutoIntercept
    public void addRepoDirectly(String repoUrl) {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Add_Repo_Btn_Css));
    	driver.findElement(By.cssSelector(AddRepoControls.Add_Repo_Btn_Css)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Repo_Url_TextBox_Css));
        driver.findElement(By.cssSelector(AddRepoControls.Repo_Url_TextBox_Css)).click();
        driver.findElement(By.cssSelector(AddRepoControls.Repo_Url_TextBox_Css)).sendKeys(repoUrl);
        driver.findElement(By.cssSelector(AddRepoControls.Steps_Btn_Css)).click();
        Utilities.staticTimeDelay(6000);
        driver.findElement(By.cssSelector(AddRepoControls.Steps_Btn_Css)).click();
        Utilities.staticTimeDelay(6000);
        driver.findElement(By.cssSelector(AddRepoControls.Steps_Btn_Css)).click();
        Utilities.staticTimeDelay(6000);
    }
    
    @AutoIntercept
    public void addRepoWithSecret(String repoUrl, String accountName, String pwd) {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Add_Repo_Btn_Css));
    	driver.findElement(By.cssSelector(AddRepoControls.Add_Repo_Btn_Css)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Repo_Url_TextBox_Css));
        driver.findElement(By.cssSelector(AddRepoControls.Repo_Url_TextBox_Css)).click();
        driver.findElement(By.cssSelector(AddRepoControls.Repo_Url_TextBox_Css)).sendKeys(repoUrl);
        driver.findElement(By.cssSelector(AddRepoControls.Account_Access_Radio_Btn_Css)).click();
        driver.findElement(By.cssSelector(AddRepoControls.Account_Textbox_Css)).click();
        driver.findElement(By.cssSelector(AddRepoControls.Account_Textbox_Css)).sendKeys(accountName);
        driver.findElement(By.cssSelector(AddRepoControls.Pwd_Textbox_Css)).sendKeys(pwd);
        driver.findElement(By.cssSelector(AddRepoControls.Steps_Btn_Css)).click();
        Utilities.staticTimeDelay(6000);
        driver.findElement(By.cssSelector(AddRepoControls.Steps_Btn_Css)).click();
        Utilities.staticTimeDelay(4000);
        driver.findElement(By.cssSelector(AddRepoControls.Steps_Btn_Css)).click();
        Utilities.staticTimeDelay(6000);
    }
    
    @AutoIntercept
    public String getAddedRepoName() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Added_Repo_Name_Css));
    	String addedRepoName = driver.findElement(By.cssSelector(AddRepoControls.Added_Repo_Name_Css)).getText().trim();
    	return addedRepoName;
    }
    
    @AutoIntercept
    public void addExistedRepoDirectly(String repoUrl) {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Add_Repo_Btn_Css));
    	driver.findElement(By.cssSelector(AddRepoControls.Add_Repo_Btn_Css)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Repo_Url_TextBox_Css));
        driver.findElement(By.cssSelector(AddRepoControls.Repo_Url_TextBox_Css)).click();
        driver.findElement(By.cssSelector(AddRepoControls.Repo_Url_TextBox_Css)).sendKeys(repoUrl);
        driver.findElement(By.cssSelector(AddRepoControls.Steps_Btn_Css)).click();
        Utilities.staticTimeDelay(1000);
    }
    
    @AutoIntercept
    public void addExistedRepoWithSecret(String repoUrl, String accountName, String pwd) {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Add_Repo_Btn_Css));
    	driver.findElement(By.cssSelector(AddRepoControls.Add_Repo_Btn_Css)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Repo_Url_TextBox_Css));
        driver.findElement(By.cssSelector(AddRepoControls.Repo_Url_TextBox_Css)).click();
        driver.findElement(By.cssSelector(AddRepoControls.Repo_Url_TextBox_Css)).sendKeys(repoUrl);
        driver.findElement(By.cssSelector(AddRepoControls.Account_Access_Radio_Btn_Css)).click();
        driver.findElement(By.cssSelector(AddRepoControls.Account_Textbox_Css)).click();
        driver.findElement(By.cssSelector(AddRepoControls.Account_Textbox_Css)).sendKeys(accountName);
        driver.findElement(By.cssSelector(AddRepoControls.Pwd_Textbox_Css)).sendKeys(pwd);
        driver.findElement(By.cssSelector(AddRepoControls.Steps_Btn_Css)).click();
        Utilities.staticTimeDelay(1000);
    }
    
    @AutoIntercept
    public String getRepoExistedErrPromptMsg() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Repo_Exited_Prompt_Msg_Css));
    	String errPromptMsg = driver.findElement(By.cssSelector(AddRepoControls.Repo_Exited_Prompt_Msg_Css)).getText().trim();
    	return errPromptMsg;
    }
    
    @AutoIntercept
    public void cancelAddRepo() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Cancel_Steps_Btn_Css));
    	driver.findElement(By.cssSelector(AddRepoControls.Cancel_Steps_Btn_Css)).click();
        Utilities.staticTimeDelay(1000);
    }
    
    private void searchRepoByNameOrGitAddr(String repoUrl) {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Search_By_Git_Addr_TextBox_Css));
    	driver.findElement(By.cssSelector(AddRepoControls.Search_By_Git_Addr_TextBox_Css)).click();
    	driver.findElement(By.cssSelector(AddRepoControls.Search_By_Git_Addr_TextBox_Css)).sendKeys(repoUrl);
        Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void searchNonExistedRepoByNameOrGitAddr(String repoUrl) {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Search_By_Git_Addr_TextBox_Css));
    	driver.findElement(By.cssSelector(AddRepoControls.Search_By_Git_Addr_TextBox_Css)).click();
    	driver.findElement(By.cssSelector(AddRepoControls.Search_By_Git_Addr_TextBox_Css)).sendKeys(repoUrl);
    	Utilities.staticTimeDelay(7000);
    }
    
    @AutoIntercept
    public void searchRepoByProjectGroup(String repoUrl) {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Delete_Flag_In_Name_Or_Addr_Search_Box_Css));
    	driver.findElement(By.cssSelector(AddRepoControls.Delete_Flag_In_Name_Or_Addr_Search_Box_Css)).click();
        Utilities.staticTimeDelay(5000);
        
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Search_By_Project_Group_Css));
    	driver.findElement(By.cssSelector(AddRepoControls.Search_By_Project_Group_Css)).click();
    	Actions builder = new Actions(driver);
    	builder.sendKeys("Merico").perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(7000);
    }
    
    @AutoIntercept
    public void sortByDevEquivalent() {
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.BACK_SPACE).perform();
    	builder.sendKeys(Keys.TAB).perform();
    	Utilities.staticTimeDelay(5000);
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Sort_By_Dev_Equivalent_Descend_Css));
        driver.findElement(By.cssSelector(AddRepoControls.Sort_By_Dev_Equivalent_Descend_Css)).click();
        Utilities.staticTimeDelay(7000);
    }
    
    @AutoIntercept
    public void sortByCommits() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Sort_By_Commits_Descend_Css));
        driver.findElement(By.cssSelector(AddRepoControls.Sort_By_Commits_Descend_Css)).click();
        Utilities.staticTimeDelay(7000);
    }
    
    @AutoIntercept
    public void sortByContributors() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Sort_By_Contributors_Descend_Css));
        driver.findElement(By.cssSelector(AddRepoControls.Sort_By_Contributors_Descend_Css)).click();
        Utilities.staticTimeDelay(7000);
    }
    
    @AutoIntercept
    public void sortByUpdateTimestamps() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Sort_By_Update_Timestamp_Descend_Css));
        driver.findElement(By.cssSelector(AddRepoControls.Sort_By_Update_Timestamp_Descend_Css)).click();
        Utilities.staticTimeDelay(7000);
    }
    
    @AutoIntercept
    public void sortBySubscriptionTimestamps() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Sort_By_Subscription_Timestamp_Descend_Css));
        driver.findElement(By.cssSelector(AddRepoControls.Sort_By_Subscription_Timestamp_Descend_Css)).click();
        Utilities.staticTimeDelay(7000);
    }
    
    @AutoIntercept
    public void allRepoTab() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.All_Repo_Tab_Css));
    	driver.findElement(By.cssSelector(AddRepoControls.All_Repo_Tab_Css)).click();
    	Utilities.staticTimeDelay(7000);
    }
    
    @AutoIntercept
    public void waitingRepoTab() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Waiting_Repo_Tab_Css));
    	driver.findElement(By.cssSelector(AddRepoControls.Waiting_Repo_Tab_Css)).click();
    	Utilities.staticTimeDelay(7000);
    }
    
    @AutoIntercept
    public void underwayRepoTab() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Underway_Repo_Tab_Css));
    	driver.findElement(By.cssSelector(AddRepoControls.Underway_Repo_Tab_Css)).click();
    	Utilities.staticTimeDelay(7000);
    }
    
    @AutoIntercept
    public void finishedRepoTab() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Finished_Repo_Tab_Css));
    	driver.findElement(By.cssSelector(AddRepoControls.Finished_Repo_Tab_Css)).click();
    	Utilities.staticTimeDelay(7000);
    }
    
    @AutoIntercept
    public void abnormalRepoTab() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Abnormal_Repo_Tab_Css));
    	driver.findElement(By.cssSelector(AddRepoControls.Abnormal_Repo_Tab_Css)).click();
    	Utilities.staticTimeDelay(7000);
    }
    
    @AutoIntercept
    public String getRepoStatus() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Repo_Status_Css));
    	String repoStatus = driver.findElement(By.cssSelector(AddRepoControls.Repo_Status_Css)).getText().trim();
    	
    	return repoStatus;
    }
    
    @AutoIntercept
    public void analysisParameterConfig() {
    	this.underwayRepoTab();
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Analasys_Para_Config_Btn_Css));
    	driver.findElement(By.cssSelector(AddRepoControls.Analasys_Para_Config_Btn_Css)).click();
    	Utilities.staticTimeDelay(7000);
    }
    
    @AutoIntercept
    public String getAnalysisParaConfigPageTitle() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Analysis_Para_Config_Page_Title_Css));
    	
    	String analysisParaConfigPageTitle = driver.findElement(By.cssSelector(AddRepoControls.Analysis_Para_Config_Page_Title_Css)).
    			getText().trim();
    	
    	return analysisParaConfigPageTitle;
    }

    @AutoIntercept
    public void viewReport() {
    	Utilities.staticTimeDelay(1000);
    	driver.navigate().back();
    	Utilities.waitForControlPresent(driver, By.xpath(AddRepoControls.View_Report_Btn_Xpath));
    	driver.findElement(By.xpath(AddRepoControls.View_Report_Btn_Xpath)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public String getViewReportPageTitle() {
    	Utilities.waitForControlPresent(driver, By.xpath(AddRepoControls.View_Report_Page_Title_Xpath));
    	
    	String viewReportPageTitle = driver.findElement(By.xpath(AddRepoControls.View_Report_Page_Title_Xpath)).
    			getText().trim();
    	
    	return viewReportPageTitle;
    }
    
    @AutoIntercept
    public void stopAnalysis() {
    	Utilities.staticTimeDelay(1000);
    	driver.navigate().back();
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Stop_Analysis_Btn_Css));
    	driver.findElement(By.cssSelector(AddRepoControls.Stop_Analysis_Btn_Css)).click();
    	Utilities.staticTimeDelay(5000);
    }
    
    @AutoIntercept
    public void delAddedRepo(String repoUrl) {
    	this.searchRepoByNameOrGitAddr(repoUrl);
        Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Delete_Repo_Btn_Css));
        driver.findElement(By.cssSelector(AddRepoControls.Delete_Repo_Btn_Css)).click();
        Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Confirm_Yes_Btn_4_Del_Repo_Css));
        driver.findElement(By.cssSelector(AddRepoControls.Confirm_Yes_Btn_4_Del_Repo_Css)).click();
        Utilities.staticTimeDelay(1000);
        Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Operating_Toast_Close_Css));
        driver.findElement(By.cssSelector(AddRepoControls.Operating_Toast_Close_Css)).click();
        Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String getNoDataPromptMsg() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.No_data_Prompt_Msg_Css));
    	String noDataPromptMsg = driver.findElement(By.cssSelector(AddRepoControls.No_data_Prompt_Msg_Css)).getText().trim();
        return noDataPromptMsg;
    }
    
    @AutoIntercept
    public void reanalysisRepo() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Reanalysis_Btn_Css));
        driver.findElement(By.cssSelector(AddRepoControls.Reanalysis_Btn_Css)).click();
        Utilities.staticTimeDelay(1000);
        Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Operating_Toast_Close_Css));
        driver.findElement(By.cssSelector(AddRepoControls.Operating_Toast_Close_Css)).click();
        Utilities.staticTimeDelay(5000);
    }
    
    @AutoIntercept
    public void clickDelFlag() {
    	Utilities.staticTimeDelay(1000);
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Delete_Flag_In_Name_Or_Addr_Search_Box_Css));
    	driver.findElement(By.cssSelector(AddRepoControls.Delete_Flag_In_Name_Or_Addr_Search_Box_Css)).click();
        Utilities.staticTimeDelay(5000);   
    }
    
    @AutoIntercept
    public int getFinishedRepoTabNum() {
    	Utilities.waitForControlPresent(driver, By.xpath(AddRepoControls.finished_repo_tab_num_xpath));
        String numberStr = driver.findElement(By.xpath(AddRepoControls.finished_repo_tab_num_xpath)).getAttribute("title").trim();
        System.out.println("Number is: " + numberStr);
        int number = Integer.parseInt(numberStr);
        return number;
    }
    
    @AutoIntercept
    public void allSelect() {
    	this.clickMulitiSelectBtn();
    	
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.All_Selection_Btn_Css));
    	driver.findElement(By.cssSelector(AddRepoControls.All_Selection_Btn_Css)).click();
    }
    
    @AutoIntercept
    public void cacelAllSelect() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Cancel_All_Selection_Btn_Css));
    	driver.findElement(By.cssSelector(AddRepoControls.Cancel_All_Selection_Btn_Css)).click();
    }
    
    @AutoIntercept
    public void clickMulitiSelectBtn() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Multi_Selection_Btn_Css));
    	driver.findElement(By.cssSelector(AddRepoControls.Multi_Selection_Btn_Css)).click();
    	
    	Utilities.staticTimeDelay(500);
    }
    
    @AutoIntercept
    public void clickCacelMulitiSelectBtn() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.Cancel_Multi_Selection_Btn_Css));
    	driver.findElement(By.cssSelector(AddRepoControls.Cancel_Multi_Selection_Btn_Css)).click();
    	
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String getMultiSelectionCheckboxLabelInfo() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.First_Item_Selection_Checkbox_Css));
    	String labelInfo = driver.findElement(By.cssSelector(AddRepoControls.First_Item_Selection_Checkbox_Css)).getText().trim();
    	
    	return labelInfo;
    }
}

