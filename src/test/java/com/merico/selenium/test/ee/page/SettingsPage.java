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
    public String name2 = Utilities.getRandomString(11);
    public String name3 = Utilities.getRandomString(8);
    public String mailSurface = "@addmember.com";
    public String email = name + mailSurface;
    public String email2 = name2 + mailSurface;
    public String email3 = name3 + mailSurface;
    public String departmentName = "Child One";
    
    public String tagName = "Tag Test";
    
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
    public void enterIntoPersonnel() {
    	Utilities.waitForControlPresent(driver, By.linkText(SettingsControls.personnel_link_link));
    	driver.findElement(By.linkText(SettingsControls.personnel_link_link)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void addMember4Personnel(String name, String email) {
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
    public void searchAddedMember4Personnel(String email) {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_search_textbox_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_search_textbox_css)).click();
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_search_textbox_css)).clear();
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_search_textbox_css)).sendKeys(email);
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void searchAddedMembers4Personnel() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_search_textbox_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_search_textbox_css)).click();
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_search_textbox_css)).clear();
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_search_textbox_css)).sendKeys("@addmember.com");
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
    	Utilities.staticTimeDelay(8000);
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
    
    @AutoIntercept
    public void adminPrivilegeFilter4Personnel() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_privilege_filter_col_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_table_privilege_filter_col_xpath)).click();
    	Utilities.staticTimeDelay(1000);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_privilege_filter_admin_checkbox_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_table_privilege_filter_admin_checkbox_xpath)).click();
    	Utilities.staticTimeDelay(500);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_privilege_filter_confirm_btn_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_table_privilege_filter_confirm_btn_xpath)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void userPrivilegeFilter4Personnel() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_privilege_filter_col_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_table_privilege_filter_col_xpath)).click();
    	Utilities.staticTimeDelay(1000);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_privilege_filter_admin_checkbox_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_table_privilege_filter_admin_checkbox_xpath)).click();
    	Utilities.staticTimeDelay(500);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_privilege_filter_user_checkbox_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_table_privilege_filter_user_checkbox_xpath)).click();
    	Utilities.staticTimeDelay(500);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_privilege_filter_confirm_btn_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_table_privilege_filter_confirm_btn_xpath)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public void resetPrivilegeFilter4Personnel() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_privilege_filter_col_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_table_privilege_filter_col_xpath)).click();
    	Utilities.staticTimeDelay(1000);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_privilege_filter_reset_btn_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_table_privilege_filter_reset_btn_xpath)).click();
    	Utilities.staticTimeDelay(2000);
    }
    
    @AutoIntercept
    public String getPrivilegeFilter4Personnel() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_privilege_filter_cell_xpath));
    	String role = driver.findElement(By.xpath(SettingsControls.personnel_members_table_privilege_filter_cell_xpath)).getText().trim();
    	System.out.println("Privilege Filter Role is: " + role);
    	
    	return role;
    }
    
    @AutoIntercept
    public void batchEnableMembers4Personnel(String name, String email) {
    	Utilities.movePageToLocation(driver, "-300");
    	
    	this.addMember4Personnel(name, email);
    	this.addMember4Personnel(name2, email2);
    	this.searchAddedMembers4Personnel();
    	
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_table_first_col_all_checkbox_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_table_first_col_all_checkbox_css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_batch_enable_btn_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_batch_enable_btn_xpath)).click();
    	Utilities.staticTimeDelay(9000);
    }
    
    @AutoIntercept
    public void batchDisableMembers4Personnel() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_batch_disable_btn_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_batch_disable_btn_xpath)).click();
    	Utilities.staticTimeDelay(9000);
    }
    
    @AutoIntercept
    public void changeDepartment4Personnel() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_change_department_btn_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_change_department_btn_xpath)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_change_department_auto_depart_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_change_department_auto_depart_xpath)).click();
    	Utilities.staticTimeDelay(1000);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_change_department_dialog_confirm_btn_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_change_department_dialog_confirm_btn_xpath)).click();
    	Utilities.staticTimeDelay(9000);
    }
    
    @AutoIntercept
    public String getDepartmentInfo4Personnel() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_table_fifth_col_department_xpath));
    	String department = driver.findElement(By.xpath(SettingsControls.personnel_members_table_fifth_col_department_xpath)).getText().trim();
    	System.out.println("Department is: " + department);
    	
    	return department;
    }
    
    @AutoIntercept
    public void mergeMembers4Personnel() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_merge_btn_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_merge_btn_xpath)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_merge_move_up_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_merge_move_up_xpath)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_merge_move_down_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_merge_move_down_xpath)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_merge_dialog_confirm_btn_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_merge_dialog_confirm_btn_xpath)).click();
    	
    	WebElement element = driver.findElement(By.xpath(SettingsControls.personnel_members_edit_dialog_confirm_btn_xpath));
    	Actions builder = new Actions(driver);
    	builder.moveToElement(element).perform();
    	Utilities.staticTimeDelay(500);
    	element.click();
    	Utilities.staticTimeDelay(11000);
    }
    
    @AutoIntercept
    public int getMergedMembersRows4Personnel() {
    	int rowCount = driver.findElements(By.xpath(SettingsControls.personnel_members_table_tr_xpath)).size();
    	System.out.println("Merged Members Rows are: " + rowCount);
    	
    	return rowCount;
    }
    
    @AutoIntercept
    public void addRowMember4Personnel(String name, String email) {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_three_dots_btn_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_three_dots_btn_css)).click();
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_import_from_csv_dropdown_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_import_from_csv_dropdown_xpath)).click();
    	Utilities.staticTimeDelay(2000);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_import_member_add_row_btn_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_import_member_add_row_btn_xpath)).click();
    	Utilities.staticTimeDelay(2000);
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_import_member_add_row_name_field_css));
    	WebElement nameFieldElement = driver.findElement(By.cssSelector(SettingsControls.personnel_members_import_member_add_row_name_field_css));
    	Actions builder = new Actions(driver);
    	builder.doubleClick(nameFieldElement).perform();
    	builder.sendKeys(name).perform();
    	
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys(Keys.TAB).perform();
    	Utilities.staticTimeDelay(500);
    	
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_import_member_add_row_email_field_css));
    	WebElement emailFieldElement = driver.findElement(By.cssSelector(SettingsControls.personnel_members_import_member_add_row_email_field_css));
    	builder.doubleClick(emailFieldElement).perform();
    	builder.sendKeys(email).perform();
    	builder.sendKeys(Keys.TAB).perform();
    	
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_members_import_member_dialog_confirm_btn_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_members_import_member_dialog_confirm_btn_xpath)).click();
    	Utilities.staticTimeDelay(11000);
    }
    
    @AutoIntercept
    public void backSpace4SearchBox4Personnel(int loop) {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_members_search_textbox_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_members_search_textbox_css)).click();
    	Actions builder = new Actions(driver);
    	for (int i = 0; i < loop; i++) {
    		builder.sendKeys(Keys.BACK_SPACE).perform();
    	}
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void addDepartment4Personnel(String departmentName) {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_department_auto_node_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_department_auto_node_css)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_department_selected_node_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_department_selected_node_css)).click();
    	Utilities.staticTimeDelay(500);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_department_add_department_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_department_add_department_xpath)).click();
    	Utilities.staticTimeDelay(1000);
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_department_add_department_name_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_department_add_department_name_css)).click();
    	driver.findElement(By.cssSelector(SettingsControls.personnel_department_add_department_name_css)).clear();
    	driver.findElement(By.cssSelector(SettingsControls.personnel_department_add_department_name_css)).sendKeys(departmentName);
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_department_add_department_head_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_department_add_department_head_css)).click();
    	
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(500);

    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(500);
    	
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_department_add_dialog_confirm_btn_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_department_add_dialog_confirm_btn_xpath)).click();
    	Utilities.staticTimeDelay(7000);
    }
    
    @AutoIntercept
    public String getAddedDepartmentName4Personnel() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_department_auto_child_node_xpath));
    	String departmentName = driver.findElement(By.xpath(SettingsControls.personnel_department_auto_child_node_xpath)).getText().trim();
    	System.out.println("Added Department is: " + departmentName);
    	
    	return departmentName;
    }
    
    @AutoIntercept
    public void editDepartment4Personnel(String departmentName) {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_department_auto_child_node_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_department_auto_child_node_xpath)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_department_selected_node_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_department_selected_node_css)).click();
    	Utilities.staticTimeDelay(500);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_department_edit_department_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_department_edit_department_xpath)).click();
    	Utilities.staticTimeDelay(1000);
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_department_add_department_name_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_department_add_department_name_css)).click();
    	driver.findElement(By.cssSelector(SettingsControls.personnel_department_add_department_name_css)).clear();
    	driver.findElement(By.cssSelector(SettingsControls.personnel_department_add_department_name_css)).sendKeys(departmentName + " Updated");
    	Utilities.staticTimeDelay(1000);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_department_add_dialog_confirm_btn_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_department_add_dialog_confirm_btn_xpath)).click();
    	Utilities.staticTimeDelay(7000);
    }
    
    @AutoIntercept
    public String getEditedDepartmentName4Personnel() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_department_auto_child_node_edit_xpath));
    	String departmentName = driver.findElement(By.xpath(SettingsControls.personnel_department_auto_child_node_edit_xpath)).getText().trim();
    	System.out.println("Added Department is: " + departmentName);
    	
    	return departmentName;
    }
    
    @AutoIntercept
    public void deleteDepartment4Personnel() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_department_selected_node_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_department_selected_node_css)).click();
    	Utilities.staticTimeDelay(500);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.personnel_department_delete_department_xpath));
    	driver.findElement(By.xpath(SettingsControls.personnel_department_delete_department_xpath)).click();
    	Utilities.staticTimeDelay(1000);
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.personnel_department_del_department_dialog_confirm_btn_css));
    	driver.findElement(By.cssSelector(SettingsControls.personnel_department_del_department_dialog_confirm_btn_css)).click();
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public void addNotificationGroup4Personnel() {
    	Utilities.waitForControlPresent(driver, By.linkText(SettingsControls.notification_settings_link_link));
    	driver.findElement(By.linkText(SettingsControls.notification_settings_link_link)).click();
    	Utilities.staticTimeDelay(4000);
    	
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.notification_settings_selection_dropdown_css));
    	driver.findElement(By.cssSelector(SettingsControls.notification_settings_selection_dropdown_css)).click();
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(500);
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.notification_settings_add_notification_group_btn_css));
    	driver.findElement(By.cssSelector(SettingsControls.notification_settings_add_notification_group_btn_css)).click();
    	Utilities.staticTimeDelay(3000);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.notification_settings_repo_dropdown_xpath));
    	driver.findElement(By.xpath(SettingsControls.notification_settings_repo_dropdown_xpath)).click();
    	Utilities.staticTimeDelay(1000);
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(500);
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.notification_settings_decline_percent_textbox_css));
    	driver.findElement(By.cssSelector(SettingsControls.notification_settings_decline_percent_textbox_css)).click();
    	builder.sendKeys(Keys.ARROW_UP).perform();
    	Utilities.staticTimeDelay(1000);
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.notification_settings_recipients_dropdown_css));
    	driver.findElement(By.cssSelector(SettingsControls.notification_settings_recipients_dropdown_css)).click();
    	Utilities.staticTimeDelay(1000);
    	builder.sendKeys(Keys.ENTER).perform();
    	builder.sendKeys(Keys.ESCAPE).perform();
    	Utilities.staticTimeDelay(500);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.notification_settings_delete_btn_xpath));
    	driver.findElement(By.xpath(SettingsControls.notification_settings_delete_btn_xpath)).click();
    	Utilities.staticTimeDelay(7000);
    }
    
    @AutoIntercept
    public void searchByRule4RuleSettings() {
    	Utilities.waitForControlPresent(driver, By.linkText(SettingsControls.rule_settings_link_link));
    	driver.findElement(By.linkText(SettingsControls.rule_settings_link_link)).click();
    	Utilities.staticTimeDelay(4000);
    	
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.rule_settings_rule_search_textbox_css));
    	driver.findElement(By.cssSelector(SettingsControls.rule_settings_rule_search_textbox_css)).click();
    	driver.findElement(By.cssSelector(SettingsControls.rule_settings_rule_search_textbox_css)).clear();
    	driver.findElement(By.cssSelector(SettingsControls.rule_settings_rule_search_textbox_css)).sendKeys("Array");
    	Utilities.staticTimeDelay(4000);
    }
    
    @AutoIntercept
    public String getRuleSearchResult4RuleSettings() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.rule_settings_rule_lonely_label_css));
    	String rule = driver.findElement(By.cssSelector(SettingsControls.rule_settings_rule_lonely_label_css)).getText().trim();
    	System.out.println("Rule is: " + rule);
    	
    	return rule;
    }
    
    @AutoIntercept
    public void clearRuleSearch4RuleSettings() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.rule_settings_rule_close_lable_css));
    	driver.findElement(By.cssSelector(SettingsControls.rule_settings_rule_close_lable_css)).click();
    	Utilities.staticTimeDelay(4000);
    }
    
    @AutoIntercept
    public void searchByType4RuleSettings() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.rule_settings_all_type_dropdown_xpath));
    	
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.TAB).perform();
    	for (int i = 0; i < 4; i++) {
    		builder.sendKeys(Keys.ARROW_DOWN).perform();
    	}
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(4000);
    }
    
    @AutoIntercept
    public String getTypeSearchResult4RuleSettings() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.rule_settings_type_lonely_label_css));
    	String type = driver.findElement(By.cssSelector(SettingsControls.rule_settings_type_lonely_label_css)).getText().trim();
    	System.out.println("Type is: " + type);
    	
    	return type;
    }
    
    @AutoIntercept
    public void clearTypeSearch4RuleSettings() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.rule_settings_clear_type_xpath));
    	WebElement element = driver.findElement(By.xpath(SettingsControls.rule_settings_clear_type_xpath));
    	
    	Actions builder = new Actions(driver);
    	builder.moveToElement(element).perform();
    	Utilities.staticTimeDelay(1000);
//    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.rule_settings_rule_close_lable_css));
    	driver.findElement(By.cssSelector(SettingsControls.rule_settings_rule_close_lable_css)).click();
    	Utilities.staticTimeDelay(4000);
    }
    
    @AutoIntercept
    public void searchBySeverities4RuleSettings() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.rule_settings_all_severities_dropdown_xpath));
    	
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.TAB).perform();
    	for (int i = 0; i < 2; i++) {
    		builder.sendKeys(Keys.ARROW_DOWN).perform();
    	}
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(4000);
    }
    
    @AutoIntercept
    public String getSeveritiesSearchResult4RuleSettings() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.rule_settings_severities_lonely_label_css));
    	String severities = driver.findElement(By.cssSelector(SettingsControls.rule_settings_severities_lonely_label_css)).getText().trim();
    	System.out.println("Severities is: " + severities);
    	
    	return severities;
    }
    
    @AutoIntercept
    public void fixedPaging4RuleSettings() {
    	driver.navigate().refresh();
    	Utilities.staticTimeDelay(5000);
    	
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.rule_settings_paging_fixed_jumper_css));
    	WebElement element = driver.findElement(By.cssSelector(SettingsControls.rule_settings_paging_fixed_jumper_css));
    	
    	Actions builder = new Actions(driver);
    	builder.moveToElement(element).perform();
    	Utilities.staticTimeDelay(500);
    	element.click();
    	builder.sendKeys(Keys.ARROW_DOWN).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(5000);
    }
    
    @AutoIntercept
    public int getFixedPagingRows4RuleSettings() {
    	int rows = driver.findElements(By.cssSelector(SettingsControls.rule_settings_page_row_count_css)).size();
    	System.out.println("Rows Count is: " + rows);
    	
    	return rows;
    }
    
    @AutoIntercept
    public void navigateToSkillTags() {
    	Utilities.waitForControlPresent(driver, By.linkText(SettingsControls.skill_tags_link_link));
    	driver.findElement(By.linkText(SettingsControls.skill_tags_link_link)).click();
    	Utilities.staticTimeDelay(8000);
    }
    
    @AutoIntercept
    public void sortByLanguage4SkillTags() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.skill_tags_language_col_xpath));
    	driver.findElement(By.xpath(SettingsControls.skill_tags_language_col_xpath)).click();
    	Utilities.staticTimeDelay(4000);
    }
    
    @AutoIntercept
    public String getLanguage4SkillTags() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.skill_tags_language_cell_xpath));
    	String language = driver.findElement(By.xpath(SettingsControls.skill_tags_language_cell_xpath)).getText().trim();
    	System.out.println("Language is: " + language);
    	
    	return language;
    }
    
    @AutoIntercept
    public void sortByTags4SkillTags() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.skill_tags_tags_col_xpath));
    	driver.findElement(By.xpath(SettingsControls.skill_tags_tags_col_xpath)).click();
    	Utilities.staticTimeDelay(4000);
    }
    
    @AutoIntercept
    public String getTags4SkillTags() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.skill_tags_tags_cell_xpath));
    	String tags = driver.findElement(By.xpath(SettingsControls.skill_tags_tags_cell_xpath)).getText().trim();
    	System.out.println("Tags is: " + tags);
    	
    	return tags;
    }
    
    @AutoIntercept
    public void filterByToolsSource4SkillTags() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.skill_tags_tools_source_col_filter_css));
    	driver.findElement(By.cssSelector(SettingsControls.skill_tags_tools_source_col_filter_css)).click();
    	Utilities.staticTimeDelay(2000);
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.skill_tags_tools_source_input_textbox_css));
    	driver.findElement(By.cssSelector(SettingsControls.skill_tags_tools_source_input_textbox_css)).click();
    	driver.findElement(By.cssSelector(SettingsControls.skill_tags_tools_source_input_textbox_css)).clear();
    	driver.findElement(By.cssSelector(SettingsControls.skill_tags_tools_source_input_textbox_css)).sendKeys("lz");
    	Utilities.waitForControlPresent(driver, By.linkText(SettingsControls.skill_tags_input_toast_confirm_link));
    	driver.findElement(By.linkText(SettingsControls.skill_tags_input_toast_confirm_link)).click();
    	Utilities.staticTimeDelay(4000);
    }
    
    @AutoIntercept
    public void filterResetByToolsSource4SkillTags() {
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.skill_tags_tools_source_col_filter_css));
    	driver.findElement(By.cssSelector(SettingsControls.skill_tags_tools_source_col_filter_css)).click();
    	Utilities.staticTimeDelay(2000);
    	Utilities.waitForControlPresent(driver, By.linkText(SettingsControls.skill_tags_input_toast_reset_link));
    	driver.findElement(By.linkText(SettingsControls.skill_tags_input_toast_reset_link)).click();
    	Utilities.staticTimeDelay(4000);
    }
    
    @AutoIntercept
    public String getToolsSource4SkillTags() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.skill_tags_tools_source_cell_xpath));
    	String toolsSource = driver.findElement(By.xpath(SettingsControls.skill_tags_tools_source_cell_xpath)).getText().trim();
    	System.out.println("Tools Source is: " + toolsSource);
    	
    	return toolsSource;
    }
    
    @AutoIntercept
    public void filterByLanguage4SkillTags() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.skill_tags_language_filter_btn_xpath));
    	driver.findElement(By.xpath(SettingsControls.skill_tags_language_filter_btn_xpath)).click();
    	Utilities.staticTimeDelay(2000);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.skill_tags_go_language_checkbox_xpath));
    	driver.findElement(By.xpath(SettingsControls.skill_tags_go_language_checkbox_xpath)).click();
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.skill_tags_language_toast_confirm_btn_css));
    	driver.findElement(By.cssSelector(SettingsControls.skill_tags_language_toast_confirm_btn_css)).click();
    	Utilities.staticTimeDelay(4000);
    }
    
    @AutoIntercept
    public void filterResetByLanguage4SkillTags() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.skill_tags_language_filter_btn_xpath));
    	driver.findElement(By.xpath(SettingsControls.skill_tags_language_filter_btn_xpath)).click();
    	Utilities.staticTimeDelay(2000);
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.skill_tags_language_toast_reset_btn_css));
    	driver.findElement(By.cssSelector(SettingsControls.skill_tags_language_toast_reset_btn_css)).click();
    	Utilities.staticTimeDelay(4000);
    }
    
    @AutoIntercept
    public void filterByTags4SkillTags() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.skill_tags_tags_col_filter_xpath));
    	driver.findElement(By.xpath(SettingsControls.skill_tags_tags_col_filter_xpath)).click();
    	Utilities.staticTimeDelay(2000);
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.skill_tags_tag_input_textbox_css));
    	driver.findElement(By.cssSelector(SettingsControls.skill_tags_tag_input_textbox_css)).click();
    	driver.findElement(By.cssSelector(SettingsControls.skill_tags_tag_input_textbox_css)).clear();
    	driver.findElement(By.cssSelector(SettingsControls.skill_tags_tag_input_textbox_css)).sendKeys("css");
    	Utilities.staticTimeDelay(2000);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.skill_tags_tag_checkbox_xpath));
    	driver.findElement(By.xpath(SettingsControls.skill_tags_tag_checkbox_xpath)).click();
    	Utilities.staticTimeDelay(1000);
    	Utilities.waitForControlPresent(driver, By.linkText(SettingsControls.skill_tags_input_toast_confirm_link));
    	driver.findElement(By.linkText(SettingsControls.skill_tags_input_toast_confirm_link)).click();
    	Utilities.staticTimeDelay(4000);
    }
    
    @AutoIntercept
    public void filterResetByTags4SkillTags() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.skill_tags_tags_col_filter_xpath));
    	driver.findElement(By.xpath(SettingsControls.skill_tags_tags_col_filter_xpath)).click();
    	Utilities.staticTimeDelay(2000);
    	Utilities.waitForControlPresent(driver, By.linkText(SettingsControls.skill_tags_input_toast_reset_link));
    	driver.findElement(By.linkText(SettingsControls.skill_tags_input_toast_reset_link)).click();
    	Utilities.staticTimeDelay(8000);
    }
    
    @AutoIntercept
    public void newTags4SkillTags(String tagName) {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.skill_tags_new_tag_node_xpath));
    	driver.findElement(By.xpath(SettingsControls.skill_tags_new_tag_node_xpath)).click();
    	Utilities.staticTimeDelay(2000);
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.skill_tags_tree_first_node_xpath));
    	driver.findElement(By.xpath(SettingsControls.skill_tags_tree_first_node_xpath)).click();
    	Utilities.staticTimeDelay(500);
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.skill_tags_plus_btn_css));
    	driver.findElement(By.cssSelector(SettingsControls.skill_tags_plus_btn_css)).click();
    	Utilities.staticTimeDelay(1000);
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.skill_tags_tag_name_textbox_css));
    	driver.findElement(By.cssSelector(SettingsControls.skill_tags_tag_name_textbox_css)).click();
    	driver.findElement(By.cssSelector(SettingsControls.skill_tags_tag_name_textbox_css)).clear();
    	driver.findElement(By.cssSelector(SettingsControls.skill_tags_tag_name_textbox_css)).sendKeys(tagName);
    	Utilities.staticTimeDelay(500);
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.skill_tags_tag_name_dialog_confirm_btn_css));
    	driver.findElement(By.cssSelector(SettingsControls.skill_tags_tag_name_dialog_confirm_btn_css)).click();
    	Utilities.staticTimeDelay(8000);
    }
    
    @AutoIntercept
    public String getNewTagName4SkillTags() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.skill_tags_new_added_tag_node_xpath));
    	String newTagName = driver.findElement(By.xpath(SettingsControls.skill_tags_new_added_tag_node_xpath)).getText().trim();
    	System.out.println("New Tag is: " + newTagName);
    	
    	return newTagName;
    }
    //.ant-btn-two-chinese-chars
    @AutoIntercept
    public void editTags4SkillTags(String tagName) {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.skill_tags_new_added_tag_node_xpath));
    	driver.findElement(By.xpath(SettingsControls.skill_tags_new_added_tag_node_xpath)).click();
    	Utilities.staticTimeDelay(500);
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.skill_tags_edit_btn_css));
    	driver.findElement(By.cssSelector(SettingsControls.skill_tags_edit_btn_css)).click();
    	Utilities.staticTimeDelay(1000);
    	Actions builder = new Actions(driver);
    	for (int i = 0; i < tagName.length(); i++) {
    		builder.sendKeys(Keys.BACK_SPACE).perform();
    	}
    	builder.sendKeys(tagName + " Updated").perform();
    	Utilities.staticTimeDelay(500);
    	
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(8000);
    }
    
    @AutoIntercept
    public void deleteTags4SkillTags() {
    	Utilities.waitForControlPresent(driver, By.xpath(SettingsControls.skill_tags_new_added_tag_node_xpath));
    	driver.findElement(By.xpath(SettingsControls.skill_tags_new_added_tag_node_xpath)).click();
    	Utilities.staticTimeDelay(500);
    	Actions builder = new Actions(driver);
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys(Keys.TAB).perform();
    	builder.sendKeys(Keys.ENTER).perform();
    	Utilities.staticTimeDelay(1000);
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.skill_tags_delete_confirm_btn_css));
    	driver.findElement(By.cssSelector(SettingsControls.skill_tags_delete_confirm_btn_css)).click();
    	Utilities.staticTimeDelay(7000);
    	Utilities.waitForControlPresent(driver, By.cssSelector(SettingsControls.skill_tags_cancel_btn_css));
    	driver.findElement(By.cssSelector(SettingsControls.skill_tags_cancel_btn_css)).click();
    	Utilities.staticTimeDelay(2000);
    }
}
