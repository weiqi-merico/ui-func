package com.merico.selenium.test.ee.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.merico.selenium.autoscreenshot.AutoIntercept;
import com.merico.selenium.page.Page;
import com.merico.selenium.test.ee.control.SettingsControls;
import com.merico.selenium.test.ee.utils.Utilities;

public class SettingsPage extends Page {
	public SettingsPage(WebDriver driver) {
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
    public void navigateToSettings() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.settings_link_xpath));
    	driver.findElement(By.xpath(SettingsControls.settings_link_xpath)).click();
    	Utilities.staticTimeDelay(4000);
    }
    
    @AutoIntercept
    public void tooltip4MetricsComparison() {
    	Utilities.waitForControlPresent(driver, By.linkText(SettingsControls.metrics_comparison_link_link));
    	driver.findElement(By.linkText(SettingsControls.metrics_comparison_link_link)).click();
    	Utilities.staticTimeDelay(2000);
    	
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.department_comparison_tab_xpath));
    	Actions builder = new Actions(driver);
    	WebElement element = driver.findElement(By.xpath(SettingsControls.number_of_dev_question_mark_xpath));
    	builder.moveToElement(element).perform();
    	Utilities.staticTimeDelay(500);
    }
    
    @AutoIntercept
    public String getNumOfDevTooltip4MetricsComparison() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.number_of_dev_tooltip_css));
    	String info = driver.findElement(By.cssSelector(SettingsControls.number_of_dev_tooltip_css)).getText().trim();
    	System.out.println("Tooltip Info is: " + info);
    	
    	return info;
    }
    
    @AutoIntercept
    public void departmentComparison4MetricsComparison() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.department_comparison_tab_xpath));
    	driver.findElement(By.xpath(SettingsControls.department_comparison_tab_xpath)).click();
    	
    	Actions builder = new Actions(driver);
    	for (int i = 0; i < 3; i++) {
    		builder.sendKeys(Keys.TAB).perform();
    	}
    	Utilities.staticTimeDelay(500);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(3000);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void memberComparison4MetricsComparison() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.member_comparison_tab_xpath));
    	driver.findElement(By.xpath(SettingsControls.member_comparison_tab_xpath)).click();
    	Utilities.staticTimeDelay(2000);
 
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys(Keys.TAB).perform();
    	Utilities.staticTimeDelay(500);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(3000);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void delComparison4MetricsComparison() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.metrics_comparison_close_second_tab_css));
    	driver.findElement(By.cssSelector(SettingsControls.metrics_comparison_close_second_tab_css)).click();
    	Utilities.staticTimeDelay(1000);
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.metrics_comparison_close_first_tab_css));
    	driver.findElement(By.cssSelector(SettingsControls.metrics_comparison_close_first_tab_css)).click();
    	Utilities.staticTimeDelay(1000);
    }
    
    @AutoIntercept
    public int getComparisonCount4MetricsComparison() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.metrics_comparison_two_col_contents_css));
    	int repoCount = driver.findElements(By.cssSelector(SettingsControls.metrics_comparison_two_col_contents_css)).size();
    	System.out.println("Comparison's Count is: " + repoCount);
    	
    	return repoCount;
    }
    
    @AutoIntercept
    public void errExportData4MetricsComparison() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.metrics_comparison_export_data_btn_xpath));
    	driver.findElement(By.xpath(SettingsControls.metrics_comparison_export_data_btn_xpath)).click();
    	Utilities.staticTimeDelay(500);
    }
    
    @AutoIntercept
    public String getErrExportDataMsg4MetricsComparison() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.metrics_comparison_export_data_error_msg_xpath));
    	String info = driver.findElement(By.xpath(SettingsControls.metrics_comparison_export_data_error_msg_xpath)).getText().trim();
    	System.out.println("Export Data Error Msg is: " + info);
    	
    	return info;
    }
}
