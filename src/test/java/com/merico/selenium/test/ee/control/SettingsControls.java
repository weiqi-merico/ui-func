package com.merico.selenium.test.ee.control;

import java.io.InputStream;
import java.util.Properties;

import com.merico.selenium.test.ee.utils.Utilities;

public class SettingsControls {
	private static Properties props = null;
    static {
        try {
            props = new Properties();
            InputStream in = ProjectGroupControls.class.getClassLoader().getResourceAsStream("settings-control.properties");
            props.load(in);
        } catch (Exception e) {
            throw new RuntimeException("Failed to initiate the configuration file", e);
        }
    }

    /**
     * Get configuration value
     *
     * @param propertyName
     * @return string
     */
    private static String getProperty(String propertyName) {
        return props.getProperty(propertyName);
    }

    private SettingsControls() {
        // TODO Auto-generated constructor stub
    }
    
    public static final String settings_link_xpath = getProperty("settings_link_xpath");
    
    public static final String metrics_comparison_link_link = Utilities.utf8Char(getProperty("metrics_comparison_link_link"));
    
    public static final String department_comparison_tab_xpath = Utilities.utf8Char(getProperty("department_comparison_tab_xpath"));
    
    public static final String member_comparison_tab_xpath = Utilities.utf8Char(getProperty("member_comparison_tab_xpath"));
    
    public static final String number_of_dev_question_mark_xpath = getProperty("number_of_dev_question_mark_xpath");
    
    public static final String number_of_dev_tooltip_css = getProperty("number_of_dev_tooltip_css");
    
    public static final String metrics_comparison_two_col_contents_css = getProperty("metrics_comparison_two_col_contents_css");
    
    public static final String metrics_comparison_close_first_tab_css = getProperty("metrics_comparison_close_first_tab_css");
    
    public static final String metrics_comparison_close_second_tab_css = getProperty("metrics_comparison_close_second_tab_css");
    
    public static final String metrics_comparison_export_data_btn_xpath = Utilities.utf8Char(getProperty("metrics_comparison_export_data_btn_xpath"));
    
    public static final String metrics_comparison_export_data_error_msg_xpath = getProperty("metrics_comparison_export_data_error_msg_xpath");
    
    public static final String personnel_link_link = Utilities.utf8Char(getProperty("personnel_link_link"));
    
    public static final String personnel_add_member_btn_css = getProperty("personnel_add_member_btn_css");
    
    public static final String personnel_add_member_dialog_name_textbox_id = getProperty("personnel_add_member_dialog_name_textbox_id");
    
    public static final String personnel_add_member_dialog_emails_textbox_css = getProperty("personnel_add_member_dialog_emails_textbox_css");
    
    public static final String personnel_add_member_dialog_privilege_dropdown_xpath = getProperty("personnel_add_member_dialog_privilege_dropdown_xpath");
    
    public static final String personnel_add_member_confirm_btn_css = getProperty("personnel_add_member_confirm_btn_css");
    
    public static final String personnel_members_toast_close_css = getProperty("personnel_members_toast_close_css");
    
    public static final String personnel_members_search_textbox_css = getProperty("personnel_members_search_textbox_css");
    
    public static final String personnel_members_search_del_xpath = getProperty("personnel_members_search_del_xpath");
    
    public static final String personnel_members_table_second_col_cell_xpath = getProperty("personnel_members_table_second_col_cell_xpath");
    
    public static final String personnel_members_table_third_col_cell_xpath = getProperty("personnel_members_table_third_col_cell_xpath");
    
    public static final String personnel_members_table_fourth_col_cell_xpath = getProperty("personnel_members_table_fourth_col_cell_xpath");
    
    public static final String personnel_members_edit_link_css = getProperty("personnel_members_edit_link_css");
    
    public static final String personnel_members_reset_link_css = getProperty("personnel_members_reset_link_css");
    
    public static final String personnel_members_disable_link_css = getProperty("personnel_members_disable_link_css");
    
    public static final String personnel_members_delete_link_css = getProperty("personnel_members_delete_link_css");
    
    public static final String personnel_members_confirm_btn_css = getProperty("personnel_members_confirm_btn_css");
    
    public static final String personnel_members_reset_confirm_btn_xpath = Utilities.utf8Char(getProperty("personnel_members_reset_confirm_btn_xpath"));
    
    public static final String personnel_members_delete_confirm_btn_xpath = Utilities.utf8Char(getProperty("personnel_members_delete_confirm_btn_xpath"));
    
    public static final String personnel_members_reset_password_copy_flag_css = getProperty("personnel_members_reset_password_copy_flag_css");
    
    public static final String personnel_members_reset_password_confirm_btn_css = getProperty("personnel_members_reset_password_confirm_btn_css");
    
    public static final String personnel_members_no_data_desc_xpath = getProperty("personnel_members_no_data_desc_xpath");
    
    public static final String personnel_members_table_tr_xpath = getProperty("personnel_members_table_tr_xpath");
    
    public static final String personnel_members_table_name_col_xpath = Utilities.utf8Char(getProperty("personnel_members_table_name_col_xpath"));
    
    public static final String personnel_members_second_row_second_col_cell_xpath = getProperty("personnel_members_second_row_second_col_cell_xpath");
    
    public static final String personnel_members_table_status_filter_col_xpath = getProperty("personnel_members_table_status_filter_col_xpath");
    
    public static final String personnel_members_table_status_filter_enable_radiobtn_xpath = getProperty("personnel_members_table_status_filter_enable_radiobtn_xpath");
    
    public static final String personnel_members_table_status_filter_disable_radiobtn_xpath = getProperty("personnel_members_table_status_filter_disable_radiobtn_xpath");
    
    public static final String personnel_members_table_status_filter_reset_btn_xpath = Utilities.utf8Char(getProperty("personnel_members_table_status_filter_reset_btn_xpath"));
    
    public static final String personnel_members_table_status_filter_confirm_btn_xpath = Utilities.utf8Char(getProperty("personnel_members_table_status_filter_confirm_btn_xpath"));
    
    public static final String personnel_members_table_privilege_filter_col_xpath = getProperty("personnel_members_table_privilege_filter_col_xpath");
    
    public static final String personnel_members_table_privilege_filter_admin_checkbox_xpath = getProperty("personnel_members_table_privilege_filter_admin_checkbox_xpath");
    
    public static final String personnel_members_table_privilege_filter_user_checkbox_xpath = getProperty("personnel_members_table_privilege_filter_user_checkbox_xpath");
    
    public static final String personnel_members_table_privilege_filter_reset_btn_xpath = Utilities.utf8Char(getProperty("personnel_members_table_privilege_filter_reset_btn_xpath"));
    
    public static final String personnel_members_table_privilege_filter_confirm_btn_xpath = Utilities.utf8Char(getProperty("personnel_members_table_privilege_filter_confirm_btn_xpath"));
    
    public static final String personnel_members_table_privilege_filter_cell_xpath = getProperty("personnel_members_table_privilege_filter_cell_xpath");
    
    public static final String personnel_members_table_enable_filter_status_cell_xpath = getProperty("personnel_members_table_enable_filter_status_cell_xpath");
    
    public static final String personnel_members_paging_fixed_jumper_css = getProperty("personnel_members_paging_fixed_jumper_css");
    
    public static final String personnel_members_paging_jumper_input_css = getProperty("personnel_members_paging_jumper_input_css");
}
