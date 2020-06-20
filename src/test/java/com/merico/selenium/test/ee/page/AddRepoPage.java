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
        Utilities.staticTimeDelay(4000);
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
    	Utilities.staticTimeDelay(5000);
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
    
    public String getNoDataPromptMsg() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(AddRepoControls.No_data_Prompt_Msg_Css));
    	String noDataPromptMsg = driver.findElement(By.cssSelector(AddRepoControls.No_data_Prompt_Msg_Css)).getText().trim();
        return noDataPromptMsg;
    }
}

