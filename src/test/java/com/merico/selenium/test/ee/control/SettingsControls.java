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
    
    public static final String personnel_members_table_first_col_all_checkbox_css = getProperty("personnel_members_table_first_col_all_checkbox_css");
    
    public static final String personnel_members_batch_enable_btn_xpath = Utilities.utf8Char(getProperty("personnel_members_batch_enable_btn_xpath"));
    
    public static final String personnel_members_batch_disable_btn_xpath = Utilities.utf8Char(getProperty("personnel_members_batch_disable_btn_xpath"));
    
    public static final String personnel_members_change_department_btn_xpath = Utilities.utf8Char(getProperty("personnel_members_change_department_btn_xpath"));
    
    public static final String personnel_members_merge_btn_xpath = Utilities.utf8Char(getProperty("personnel_members_merge_btn_xpath"));
    
    public static final String personnel_members_export_btn_xpath = getProperty("personnel_members_export_btn_xpath");
    
    public static final String personnel_members_three_dots_btn_css = getProperty("personnel_members_three_dots_btn_css");
    
    public static final String personnel_members_import_from_csv_dropdown_xpath = Utilities.utf8Char(getProperty("personnel_members_import_from_csv_dropdown_xpath"));
    
    public static final String personnel_members_import_from_gitlab_dropdown_xpath = getProperty("personnel_members_import_from_gitlab_dropdown_xpath");
    
    public static final String personnel_members_change_department_auto_depart_xpath = getProperty("personnel_members_change_department_auto_depart_xpath");
    
    public static final String personnel_members_change_department_dialog_confirm_btn_xpath = Utilities.utf8Char(getProperty("personnel_members_change_department_dialog_confirm_btn_xpath"));
    
    public static final String personnel_members_table_fifth_col_department_xpath = getProperty("personnel_members_table_fifth_col_department_xpath");
    
    public static final String personnel_members_merge_move_up_xpath = getProperty("personnel_members_merge_move_up_xpath");
    
    public static final String personnel_members_merge_move_down_xpath = getProperty("personnel_members_merge_move_down_xpath");
    
    public static final String personnel_members_merge_dialog_confirm_btn_xpath = Utilities.utf8Char(getProperty("personnel_members_merge_dialog_confirm_btn_xpath"));
    
    public static final String personnel_members_edit_dialog_confirm_btn_xpath = Utilities.utf8Char(getProperty("personnel_members_edit_dialog_confirm_btn_xpath"));
    
    public static final String personnel_members_import_member_add_row_btn_xpath = Utilities.utf8Char(getProperty("personnel_members_import_member_add_row_btn_xpath"));
    
    public static final String personnel_members_import_member_add_row_name_field_css = getProperty("personnel_members_import_member_add_row_name_field_css");
    
    public static final String personnel_members_import_member_add_row_email_field_css = getProperty("personnel_members_import_member_add_row_email_field_css");
    
    public static final String personnel_members_import_member_dialog_confirm_btn_xpath = getProperty("personnel_members_import_member_dialog_confirm_btn_xpath");
    
    public static final String personnel_department_auto_node_css = getProperty("personnel_department_auto_node_css");
    
    public static final String personnel_department_selected_node_css = getProperty("personnel_department_selected_node_css");
    
    public static final String personnel_department_add_department_xpath = Utilities.utf8Char(getProperty("personnel_department_add_department_xpath"));
    
    public static final String personnel_department_edit_department_xpath = Utilities.utf8Char(getProperty("personnel_department_edit_department_xpath"));
    
    public static final String personnel_department_delete_department_xpath = Utilities.utf8Char(getProperty("personnel_department_delete_department_xpath"));
    
    public static final String personnel_department_add_department_name_css = getProperty("personnel_department_add_department_name_css");
    
    public static final String personnel_department_add_department_head_css = getProperty("personnel_department_add_department_head_css");
    
    public static final String personnel_department_add_parent_department_xpath = getProperty("personnel_department_add_parent_department_xpath");
    
    public static final String personnel_department_add_dialog_confirm_btn_xpath = Utilities.utf8Char(getProperty("personnel_department_add_dialog_confirm_btn_xpath"));
    
    public static final String personnel_department_auto_child_node_xpath = getProperty("personnel_department_auto_child_node_xpath");
    
    public static final String personnel_department_auto_child_node_edit_xpath = getProperty("personnel_department_auto_child_node_edit_xpath");
    
    public static final String personnel_department_del_department_dialog_confirm_btn_css = getProperty("personnel_department_del_department_dialog_confirm_btn_css");
    
    public static final String notification_settings_link_link = Utilities.utf8Char(getProperty("notification_settings_link_link"));
    
    public static final String notification_settings_selection_dropdown_css = getProperty("notification_settings_selection_dropdown_css");
    
    public static final String notification_settings_add_notification_group_btn_css = getProperty("notification_settings_add_notification_group_btn_css");
    
    public static final String notification_settings_repo_dropdown_xpath = getProperty("notification_settings_repo_dropdown_xpath");
    
    public static final String notification_settings_decline_percent_textbox_css = getProperty("notification_settings_decline_percent_textbox_css");
    
    public static final String notification_settings_recipients_dropdown_css = getProperty("notification_settings_recipients_dropdown_css");
    
    public static final String notification_settings_add_notification_group_btn_two_css = getProperty("notification_settings_add_notification_group_btn_two_css");
    
    public static final String notification_settings_delete_btn_xpath = Utilities.utf8Char(getProperty("notification_settings_delete_btn_xpath"));
    
    public static final String rule_settings_link_link = Utilities.utf8Char(getProperty("rule_settings_link_link"));
    
    public static final String rule_settings_list_cpp_xpath = getProperty("rule_settings_list_cpp_xpath");
    
    public static final String rule_settings_rule_search_textbox_css = getProperty("rule_settings_rule_search_textbox_css");
    
    public static final String rule_settings_all_type_dropdown_xpath = Utilities.utf8Char(getProperty("rule_settings_all_type_dropdown_xpath"));
    
    public static final String rule_settings_all_severities_dropdown_xpath = Utilities.utf8Char(getProperty("rule_settings_all_severities_dropdown_xpath"));
    
    public static final String rule_settings_rule_number_label_css = getProperty("rule_settings_rule_number_label_css");
    
    public static final String rule_settings_rule_close_lable_css = getProperty("rule_settings_rule_close_lable_css");
    
    public static final String rule_settings_paging_fixed_jumper_css = getProperty("rule_settings_paging_fixed_jumper_css");
    
    public static final String rule_settings_rule_lonely_label_css = getProperty("rule_settings_rule_lonely_label_css");
    
    public static final String rule_settings_type_lonely_label_css = getProperty("rule_settings_type_lonely_label_css");
    
    public static final String rule_settings_severities_lonely_label_css = getProperty("rule_settings_severities_lonely_label_css");
    
    public static final String rule_settings_clear_type_xpath = getProperty("rule_settings_clear_type_xpath");
    
    public static final String rule_settings_clear_severities_xpath = getProperty("rule_settings_clear_severities_xpath");
    
    public static final String rule_settings_page_row_count_css = getProperty("rule_settings_page_row_count_css");
    
    public static final String skill_tags_link_link = Utilities.utf8Char(getProperty("skill_tags_link_link"));
    
    public static final String skill_tags_new_tag_btn_css = getProperty("skill_tags_new_tag_btn_css");
    
    public static final String skill_tags_search_tag_textbox_css = getProperty("skill_tags_search_tag_textbox_css");
    
    public static final String skill_tags_close_lable_css = getProperty("skill_tags_close_lable_css");
    
    public static final String skill_tags_tree_first_node_xpath = Utilities.utf8Char(getProperty("skill_tags_tree_first_node_xpath"));
    
    public static final String skill_tags_plus_btn_css = getProperty("skill_tags_plus_btn_css");
    
    public static final String skill_tags_edit_btn_css = getProperty("skill_tags_edit_btn_css");
    
    public static final String skill_tags_delete_btn_css = getProperty("skill_tags_delete_btn_css");
    
    public static final String skill_tags_delete_confirm_btn_css = getProperty("skill_tags_delete_confirm_btn_css");
    
    public static final String skill_tags_tag_name_textbox_css = getProperty("skill_tags_tag_name_textbox_css");
    
    public static final String skill_tags_tag_name_dialog_confirm_btn_css = getProperty("skill_tags_tag_name_dialog_confirm_btn_css");
    
    public static final String skill_tags_new_added_tag_node_xpath = getProperty("skill_tags_new_added_tag_node_xpath");
    
    public static final String skill_tags_new_tag_node_xpath = Utilities.utf8Char(getProperty("skill_tags_new_tag_node_xpath"));
    
    public static final String skill_tags_cancel_btn_css = getProperty("skill_tags_cancel_btn_css");
    
    public static final String skill_tags_language_col_xpath = Utilities.utf8Char(getProperty("skill_tags_language_col_xpath"));
    
    public static final String skill_tags_language_cell_xpath = getProperty("skill_tags_language_cell_xpath");
    
    public static final String skill_tags_tags_col_xpath = Utilities.utf8Char(getProperty("skill_tags_tags_col_xpath"));
    
    public static final String skill_tags_tags_cell_xpath = getProperty("skill_tags_tags_cell_xpath");
    
    public static final String skill_tags_language_filter_btn_xpath = getProperty("skill_tags_language_filter_btn_xpath");
    
    public static final String skill_tags_go_language_checkbox_xpath = getProperty("skill_tags_go_language_checkbox_xpath");
    
    public static final String skill_tags_language_toast_confirm_btn_css = getProperty("skill_tags_language_toast_confirm_btn_css");
    
    public static final String skill_tags_language_toast_reset_btn_css = getProperty("skill_tags_language_toast_reset_btn_css");
    
    public static final String skill_tags_tools_source_col_filter_css = getProperty("skill_tags_tools_source_col_filter_css");
    
    public static final String skill_tags_tools_source_input_textbox_css = getProperty("skill_tags_tools_source_input_textbox_css");
    
    public static final String skill_tags_input_toast_confirm_link = Utilities.utf8Char(getProperty("skill_tags_input_toast_confirm_link"));
    
    public static final String skill_tags_input_toast_reset_link = Utilities.utf8Char(getProperty("skill_tags_input_toast_reset_link"));
    
    public static final String skill_tags_tools_source_cell_xpath = getProperty("skill_tags_tools_source_cell_xpath");
    
    public static final String skill_tags_tags_col_filter_xpath = getProperty("skill_tags_tags_col_filter_xpath");
    
    public static final String skill_tags_tag_input_textbox_css = getProperty("skill_tags_tag_input_textbox_css");
    
    public static final String skill_tags_tag_checkbox_xpath = getProperty("skill_tags_tag_checkbox_xpath");
    
    public static final String skill_tags_paging_fixed_jumper_css = getProperty("skill_tags_paging_fixed_jumper_css");
    
    public static final String skill_tags_paging_input_jumper_css = getProperty("skill_tags_paging_input_jumper_css");
    
    public static final String skill_tags_table_tr_xpath = getProperty("skill_tags_table_tr_xpath");
    
    public static final String system_integration_link_link = Utilities.utf8Char(getProperty("system_integration_link_link"));
    
    public static final String system_integration_copy_gitlab_addr_css = getProperty("system_integration_copy_gitlab_addr_css");
    
    public static final String system_integration_copy_gitlab_addr_tooltip_css = getProperty("system_integration_copy_gitlab_addr_tooltip_css");
    
    public static final String system_integration_gitlab_addr_textbox_css = getProperty("system_integration_gitlab_addr_textbox_css");
    
    public static final String system_integration_app_id_textbox_css = getProperty("system_integration_app_id_textbox_css");
    
    public static final String system_integration_secret_textbox_css = getProperty("system_integration_secret_textbox_css");
    
    public static final String system_integration_save_btn_css = getProperty("system_integration_save_btn_css");
    
    public static final String system_integration_toast_close_css = getProperty("system_integration_toast_close_css");
    
    public static final String system_integration_integrate_btn_css = getProperty("system_integration_integrate_btn_css");
    
    public static final String system_configurations_link_link = Utilities.utf8Char(getProperty("system_configurations_link_link"));
    
    public static final String system_configurations_toast_msg_css = getProperty("system_configurations_toast_msg_css");
    
    public static final String system_configurations_basic_settings_site_url_id = getProperty("system_configurations_basic_settings_site_url_id");
    
    public static final String system_configurations_basic_settings_system_time_zone_css = getProperty("system_configurations_basic_settings_system_time_zone_css");
    
    public static final String system_configurations_basic_settings_workdays_mon_xpath = Utilities.utf8Char(getProperty("system_configurations_basic_settings_workdays_mon_xpath"));
    
    public static final String system_configurations_basic_settings_team_ranks_css = getProperty("system_configurations_basic_settings_team_ranks_css");
    
    public static final String system_configurations_basic_settings_allow_notification_xpath = Utilities.utf8Char(getProperty("system_configurations_basic_settings_allow_notification_xpath"));
    
    public static final String system_configurations_basic_settings_save_btn_xpath = Utilities.utf8Char(getProperty("system_configurations_basic_settings_save_btn_xpath"));
    
    public static final String system_configurations_basic_settings_reset_btn_xpath = Utilities.utf8Char(getProperty("system_configurations_basic_settings_reset_btn_xpath"));
    
    public static final String system_configurations_smtp_settings_smtp_email_id = getProperty("system_configurations_smtp_settings_smtp_email_id");
    
    public static final String system_configurations_smtp_settings_smtp_password_id = getProperty("system_configurations_smtp_settings_smtp_password_id");
    
    public static final String system_configurations_smtp_settings_smtp_smtp_id = getProperty("system_configurations_smtp_settings_smtp_smtp_id");
    
    public static final String system_configurations_smtp_settings_use_secure_connection_xpath = Utilities.utf8Char(getProperty("system_configurations_smtp_settings_use_secure_connection_xpath"));
    
    public static final String system_configurations_smtp_settings_save_btn_xpath = Utilities.utf8Char(getProperty("system_configurations_smtp_settings_save_btn_xpath"));
    
    public static final String system_configurations_oauth_settings_oauth_site_url_id = getProperty("system_configurations_oauth_settings_oauth_site_url_id");
    
    public static final String system_configurations_oauth_settings_appid_id = getProperty("system_configurations_oauth_settings_appid_id");
    
    public static final String system_configurations_oauth_settings_secret_id = getProperty("system_configurations_oauth_settings_secret_id");
    
    public static final String system_configurations_oauth_settings_save_btn_xpath = Utilities.utf8Char(getProperty("system_configurations_oauth_settings_save_btn_xpath"));
    
    public static final String system_configurations_ldap_settings_url_id = getProperty("system_configurations_ldap_settings_url_id");
    
    public static final String system_configurations_ldap_settings_bind_dn_id = getProperty("system_configurations_ldap_settings_bind_dn_id");
    
    public static final String system_configurations_ldap_settings_bind_credentials_id = getProperty("system_configurations_ldap_settings_bind_credentials_id");
    
    public static final String system_configurations_ldap_settings_ca_cert_id = getProperty("system_configurations_ldap_settings_ca_cert_id");
    
    public static final String system_configurations_ldap_settings_search_base_id = getProperty("system_configurations_ldap_settings_search_base_id");
    
    public static final String system_configurations_ldap_settings_search_filter_id = getProperty("system_configurations_ldap_settings_search_filter_id");
    
    public static final String system_configurations_ldap_settings_email_attr_id = getProperty("system_configurations_ldap_settings_email_attr_id");
    
    public static final String system_configurations_ldap_settings_save_btn_xpath = Utilities.utf8Char(getProperty("system_configurations_ldap_settings_save_btn_xpath"));
    
    public static final String system_configurations_ldap_settings_test_conn_btn_xpath = Utilities.utf8Char(getProperty("system_configurations_ldap_settings_test_conn_btn_xpath"));
    
    public static final String system_configurations_function_switchs_save_btn_xapth = Utilities.utf8Char(getProperty("system_configurations_function_switchs_save_btn_xapth"));
    
    public static final String system_configurations_schedule_settings_weekly_id = getProperty("system_configurations_schedule_settings_weekly_id");
    
    public static final String system_configurations_schedule_settings_daily_id = getProperty("system_configurations_schedule_settings_daily_id");
    
    public static final String system_configurations_schedule_settings_weekly_reanalysis_id = getProperty("system_configurations_schedule_settings_weekly_reanalysis_id");
    
    public static final String system_configurations_schedule_settings_daily_reanalysis_id = getProperty("system_configurations_schedule_settings_daily_reanalysis_id");
    
    public static final String system_configurations_schedule_settings_save_btn_xpath = Utilities.utf8Char(getProperty("system_configurations_schedule_settings_save_btn_xpath"));
    
    public static final String system_configurations_analysis_settings_scala_textbox_id = getProperty("system_configurations_analysis_settings_scala_textbox_id");
    
    public static final String system_configurations_analysis_settings_save_btn_xpath = Utilities.utf8Char(getProperty("system_configurations_analysis_settings_save_btn_xpath"));
}
