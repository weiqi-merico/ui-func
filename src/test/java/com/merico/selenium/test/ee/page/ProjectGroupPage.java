package com.merico.selenium.test.ee.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.merico.selenium.autoscreenshot.AutoIntercept;
import com.merico.selenium.page.Page;
import com.merico.selenium.test.ee.control.ProjectGroupControls;
import com.merico.selenium.test.ee.data.TestDataProvider;
import com.merico.selenium.test.ee.utils.Utilities;

public class ProjectGroupPage extends Page {
	public ProjectGroupPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isLoaded() {
        // No Ajax content, which can be considered to create the Page object has finished loading.
        return true;
    }
    
    @AutoIntercept
    public void navigateProjectGroup() {
    	Utilities.waitForControlPresent(driver, By.xpath(ProjectGroupControls.Project_Group_Link_Xpath));
    	driver.findElement(By.xpath(ProjectGroupControls.Project_Group_Link_Xpath)).click();
    	Utilities.staticTimeDelay(4000);
    }
    
    private void addProjectGroupDialog() {
    	Utilities.waitForControlPresent(driver, By.id(ProjectGroupControls.Project_Group_Name_Id));
    	driver.findElement(By.id(ProjectGroupControls.Project_Group_Name_Id)).clear();
    	driver.findElement(By.id(ProjectGroupControls.Project_Group_Name_Id)).sendKeys(TestDataProvider.projectGroupName);
    	driver.findElement(By.id(ProjectGroupControls.Project_Group_Description_Id)).clear();
    	driver.findElement(By.id(ProjectGroupControls.Project_Group_Description_Id)).sendKeys(Utilities.getRandomString(100));
    	driver.findElement(By.cssSelector(ProjectGroupControls.Project_Group_Confirm_Btn_Css)).click();
    	Utilities.staticTimeDelay(2000);
    	this.closeToast();
        Utilities.staticTimeDelay(1000);
    }
    
    @AutoIntercept
    public void addProjectGroup() {
    	this.navigateProjectGroup();
    	
    	Utilities.waitForControlPresent(driver, By.cssSelector(ProjectGroupControls.Add_Project_Group_Btn_Css));
    	driver.findElement(By.cssSelector(ProjectGroupControls.Add_Project_Group_Btn_Css)).click();
    	
    	this.addProjectGroupDialog();
    }
    
    public String getSearchResultItem() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(ProjectGroupControls.Search_Textbox_Css));
    	driver.findElement(By.cssSelector(ProjectGroupControls.Search_Textbox_Css)).clear();
    	driver.findElement(By.cssSelector(ProjectGroupControls.Search_Textbox_Css)).sendKeys(TestDataProvider.projectGroupName);
    	Utilities.staticTimeDelay(2000);
    	Utilities.waitForControlPresent(driver, By.cssSelector(ProjectGroupControls.Search_Item_Link_Css));
    	String searchResult = driver.findElement(By.cssSelector(ProjectGroupControls.Search_Item_Link_Css)).getText().trim();
    	
    	return searchResult;
    }
    
    private void hover4MoreBtn() {
    	Utilities.staticTimeDelay(1000);
    	int tree_node_num = driver.findElements(By.cssSelector(ProjectGroupControls.Project_Group_Treenode_Css)).size();
   	
    	{
    	      WebElement element = driver.findElement(By.cssSelector(ProjectGroupControls.Treenode_Trigger_Left_Css + 
    	    		  tree_node_num + ProjectGroupControls.Treenode_Trigger_Right_Css));
    	      Actions builder = new Actions(driver);
    	      builder.moveToElement(element).perform();
    	}
    }
    
    private void closeToast() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(ProjectGroupControls.Operating_Toast_Close_Css));
        driver.findElement(By.cssSelector(ProjectGroupControls.Operating_Toast_Close_Css)).click();
    }
    
    @AutoIntercept
    public void addSubProjectGroup() {
    	this.hover4MoreBtn();
    	
    	Utilities.staticTimeDelay(1000);
    	driver.findElement(By.xpath(ProjectGroupControls.Add_Sub_Project_Group_Xpath)).click();
    	
    	this.addProjectGroupDialog();
    }
    
    @AutoIntercept
    public void editProjectGroup() {
    	this.hover4MoreBtn();
    	
    	Utilities.staticTimeDelay(1000);
    	driver.findElement(By.xpath(ProjectGroupControls.Edit_Project_Group_Xpath)).click();
    	
    	this.addProjectGroupDialog();
    }
    
    @AutoIntercept
    public void delProjectGroup() {
    	this.hover4MoreBtn();
    	Utilities.staticTimeDelay(1000);
    	driver.findElement(By.xpath(ProjectGroupControls.Del_Project_Group_Xpath)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(ProjectGroupControls.Del_Project_Group_Textbox_Css));
    	driver.findElement(By.cssSelector(ProjectGroupControls.Del_Project_Group_Textbox_Css)).clear();
    	driver.findElement(By.cssSelector(ProjectGroupControls.Del_Project_Group_Textbox_Css)).sendKeys(
    			TestDataProvider.projectGroupName + TestDataProvider.projectGroupName);
    	driver.findElement(By.cssSelector(ProjectGroupControls.Del_Project_Group_Confirm_Btn_Css)).click();
    	Utilities.staticTimeDelay(2000);
    	this.closeToast();
        Utilities.staticTimeDelay(1000);
    }
}
