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
    
    public String name = Utilities.getRandomString(10);
    public String email = name + "@addmember.com";
    
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
    
    @AutoIntercept
    public void addMember4Personnel() {
    	Utilities.waitForControlPresent(driver, By.linkText(SettingsControls.personnel_link_link));
    	driver.findElement(By.linkText(SettingsControls.personnel_link_link)).click();
    	Utilities.staticTimeDelay(2000);
    	
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_add_member_btn_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_add_member_btn_css)).click();
    	Utilities.waitForControlPresent(driver, By.id(SettingsControls.personnel_add_member_dialog_name_textbox_id));
    	driver.findElement(By.id(SettingsControls.personnel_add_member_dialog_name_textbox_id)).click();
    	driver.findElement(By.id(SettingsControls.personnel_add_member_dialog_name_textbox_id)).clear();
    	driver.findElement(By.id(SettingsControls.personnel_add_member_dialog_name_textbox_id)).sendKeys(name);
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_add_member_dialog_emails_textbox_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_add_member_dialog_emails_textbox_css)).click();

    	Actions builder = new Actions(driver);
    	builder.sendKeys(email).perform();

    	builder.sendKeys(Keys.TAB).perform();
    	Utilities.staticTimeDelay(500);
    	
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_add_member_confirm_btn_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_add_member_confirm_btn_css)).click();
    	Utilities.staticTimeDelay(10000);
    	
//    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_toast_close_css));
//    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_toast_close_css)).click();
    }
    
    @AutoIntercept
    public void searchAddedMember4Personnel() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_search_textbox_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_search_textbox_css)).click();
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_search_textbox_css)).clear();
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_search_textbox_css)).sendKeys(email);
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public String getAddedMember4Personnel() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_second_col_cell_xpath));
    	String email = driver.findElement(By.xpath(SettingsControls.personnel_members_table_second_col_cell_xpath)).getText().trim();
    	System.out.println("Added Member Email is: " + email);
    	
    	return email;
    }
    
    @AutoIntercept
    public void editMember4Personnel() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_edit_link_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_edit_link_css)).click();
    	Utilities.staticTimeDelay(1000);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_add_member_dialog_privilege_dropdown_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_add_member_dialog_privilege_dropdown_xpath)).click();
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_UP).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(500);
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_add_member_confirm_btn_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_add_member_confirm_btn_css)).click();
    	Utilities.staticTimeDelay(10000);
//    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_toast_close_css));
//    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_toast_close_css)).click();
//    	Utilities.staticTimeDelay(1000);
    }
    
    @AutoIntercept
    public String getEditMemberPrivilege4Personnel() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_fourth_col_cell_xpath));
    	String privilege = driver.findElement(By.xpath(SettingsControls.personnel_members_table_fourth_col_cell_xpath)).getText().trim();
    	System.out.println("Privilege After Editing Member is: " + privilege);
    	
    	return privilege;
    }
    
    @AutoIntercept
    public void enableMember4Personnel() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_disable_link_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_disable_link_css)).click();
    	Utilities.staticTimeDelay(1000);
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_confirm_btn_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_confirm_btn_css)).click();
    	Utilities.staticTimeDelay(6000);
//    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_toast_close_css));
//    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_toast_close_css)).click();
//    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String getEnableMemberStatus4Personnel() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_third_col_cell_xpath));
    	String status = driver.findElement(By.xpath(SettingsControls.personnel_members_table_third_col_cell_xpath)).getText().trim();
    	System.out.println("Status After Enabling Member is: " + status);
    	
    	return status;
    }
    
    @AutoIntercept
    public void resetMember4Personnel() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_reset_link_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_reset_link_css)).click();
    	Utilities.staticTimeDelay(1000);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_reset_confirm_btn_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_reset_confirm_btn_xpath)).click();
    	Utilities.staticTimeDelay(12000);
//    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_toast_close_css));
//    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_toast_close_css)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_reset_password_copy_flag_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_reset_password_copy_flag_css)).click();
    	Utilities.staticTimeDelay(500);
    }
    
    @AutoIntercept
    public void resetMemberOk4Personnel() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_reset_password_confirm_btn_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_reset_password_confirm_btn_css)).click();
    	Utilities.staticTimeDelay(1000);
    }
    
    @AutoIntercept
    public String getResetMemberPasswordCopyTooltip4MetricsComparison() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.number_of_dev_tooltip_css));
    	String info = driver.findElement(By.cssSelector(SettingsControls.number_of_dev_tooltip_css)).getText().trim();
    	System.out.println("Tooltip Info is: " + info);
    	
    	return info;
    }
    
    @AutoIntercept
    public void deleteMember4Personnel() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_delete_link_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_delete_link_css)).click();
    	Utilities.staticTimeDelay(500);
    	Actions builder = new Actions(driver);
    	for (int i = 0; i < 4; i++) {
    		builder.sendKeys(Keys.TAB).perform();
    	}
    	Utilities.staticTimeDelay(1500);
    	builder.sendKeys(Keys.ENTER).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(6000);
//    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_delete_confirm_btn_xpath));
//    	driver.findElement(By.xpath(SettingsControls.personnel_members_delete_confirm_btn_xpath)).click();
//    	Utilities.staticTimeDelay(500);
//    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_toast_close_css));
//    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_toast_close_css)).click();
//    	Utilities.staticTimeDelay(1500);
    }
    
    @AutoIntercept
    public String getMemberNoDataDesc4MetricsComparison() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_no_data_desc_xpath));
    	String desc = driver.findElement(By.xpath(SettingsControls.personnel_members_no_data_desc_xpath)).getText().trim();
    	System.out.println("No Data Description is: " + desc);
    	
    	return desc;
    }
    
    @AutoIntercept
    public void fixedPagingJumper4Personnel() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_search_textbox_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_search_textbox_css)).click();
    	Actions builder = new Actions(driver);
    	for (int i = 0; i < 24; i++) {
    		builder.sendKeys(Keys.BACK_SPACE).perform();
    	}
    	Utilities.staticTimeDelay(1000);
    	
    	WebElement element = driver.findElement(By.cssSelector(SettingsControls.personnel_members_paging_fixed_jumper_css));
    	builder.moveToElement(element).perform();
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_paging_fixed_jumper_css));
    	element.click();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public int getfixedPagingRowCount4Personnel() {
    	int rowCount = driver.findElements(By.xpath(SettingsControls.personnel_members_table_tr_xpath)).size();
    	System.out.println("Table Table Row is: " + rowCount);
    	
    	return rowCount;
    }
    

    @AutoIntercept
    public void paginationJumper4Personnel() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_paging_jumper_input_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_paging_jumper_input_css)).clear();
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_paging_jumper_input_css)).sendKeys("2");
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public String getPaginationFocus4Personnel() {
    	Utilities.waitForControlPresent(driver, By.linkText("2"));
    	String cssVal =  driver.findElement(By.linkText("2")).getCssValue("color").trim();
    	System.out.println("Pagination Focus Color Value is : " + cssVal);
    	
    	return cssVal;
    }
    
    @AutoIntercept
    public void pagingToOnePage4Personnel() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_paging_jumper_input_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_paging_jumper_input_css)).clear();
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_paging_jumper_input_css)).sendKeys("1");
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(3000);
    	
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_add_member_btn_css));
    	WebElement element = driver.findElement(By.cssSelector(SettingsControls.personnel_add_member_btn_css));
    	builder.moveToElement(element).perform();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void sortByName4Personnel() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_name_col_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_table_name_col_xpath)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String getSortNameVal4Personnel() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_second_row_second_col_cell_xpath));
    	String val =  driver.findElement(By.xpath(SettingsControls.personnel_members_second_row_second_col_cell_xpath)).getText().trim();
    	System.out.println("Sort Value By Name is : " + val);
    	
    	return val;
    }
    
    @AutoIntercept
    public void enableStatusFilter4Personnel() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_status_filter_col_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_table_status_filter_col_xpath)).click();
    	Utilities.staticTimeDelay(1000);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_status_filter_enable_radiobtn_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_table_status_filter_enable_radiobtn_xpath)).click();
    	Utilities.staticTimeDelay(500);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_status_filter_confirm_btn_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_table_status_filter_confirm_btn_xpath)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void disableStatusFilter4Personnel() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_status_filter_col_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_table_status_filter_col_xpath)).click();
    	Utilities.staticTimeDelay(1000);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_status_filter_disable_radiobtn_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_table_status_filter_disable_radiobtn_xpath)).click();
    	Utilities.staticTimeDelay(500);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_status_filter_confirm_btn_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_table_status_filter_confirm_btn_xpath)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void resetStatusFilter4Personnel() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_status_filter_col_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_table_status_filter_col_xpath)).click();
    	Utilities.staticTimeDelay(1000);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_status_filter_reset_btn_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_table_status_filter_reset_btn_xpath)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String getEnableStatusFilter4Personnel() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_enable_filter_status_cell_xpath));
    	String status = driver.findElement(By.xpath(SettingsControls.personnel_members_table_enable_filter_status_cell_xpath)).getText().trim();
    	System.out.println("Enalble Filter Status is: " + status);
    	
    	return status;
    }
}
