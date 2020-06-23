package com.merico.selenium.test.ee.control;

import java.io.InputStream;
import java.util.Properties;

public class AddRepoControls {
    private static Properties props = null;
    static {
        try {
            props = new Properties();
            InputStream in = LoginControls.class.getClassLoader().getResourceAsStream("add-repo-control.properties");
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

    private AddRepoControls() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Add Repo Button
     */
    public static final String Add_Repo_Btn_Css = getProperty("add_repo_btn_css");

    /**
     * Repo Url TextBox
     */
    public static final String Repo_Url_TextBox_Css = getProperty("repo_url_textbox_css");
    
    /**
     * Account Access Radio Button
     */
    public static final String Account_Access_Radio_Btn_Css = getProperty("account_access_radio_btn_css");
    
    /**
     * Account TextBox
     */
    public static final String Account_Textbox_Css = getProperty("account_textbox_css");
    
    /**
     * Account Password TextBox
     */
    public static final String Pwd_Textbox_Css = getProperty("pwd_textbox_css");
    
    /**
     * Steps Button
     */
    public static final String Steps_Btn_Css = getProperty("steps_btn_css");
    
    /**
     * Cancel Steps Button
     */
    public static final String Cancel_Steps_Btn_Css = getProperty("cancel_steps_btn_css");
    
    /**
     * Collapse Group
     */
    public static final String Collapse_Header_4_Group_Css = getProperty("collapse_header_4_group_css");
    
    /**
     * Added Repo Name
     */
    public static final String Added_Repo_Name_Css = getProperty("added_repo_name_css");
    
    /**
     * Prompt Msg for Repo Existed
     */
    public static final String Repo_Exited_Prompt_Msg_Css = getProperty("repo_exited_prompt_msg_css");
    
    /**
     * Search TextBox By Git Addr
     */
    public static final String Search_By_Git_Addr_TextBox_Css = getProperty("search_by_git_addr_textbox_css");
    
    /**
     * Search By Project Group
     */
    public static final String Search_By_Project_Group_Css = getProperty("search_by_project_group_css");
    
    /**
     * Delete Flag in Name or Addr Search Box
     */
    public static final String Delete_Flag_In_Name_Or_Addr_Search_Box_Css = getProperty("delete_flag_in_name_or_addr_search_box_css");
    
    /**
     * Delete Repo Button
     */
    public static final String Delete_Repo_Btn_Css = getProperty("delete_repo_btn_css");
    
    /**
     * Confirm Yes Button for Del Repo
     */
    public static final String Confirm_Yes_Btn_4_Del_Repo_Css = getProperty("confirm_yes_btn_4_del_repo_css");
    
    /**
     * Confirm No Button for Del Repo
     */
    public static final String Confirm_No_Btn_4_Del_Repo_Css = getProperty("confirm_no_btn_4_del_repo_css");
    
    /**
     * Operating Toast for Close
     */
    public static final String Operating_Toast_Close_Css = getProperty("operating_toast_close_css");
    
    /**
     * Prompt Msg for No Data
     */
    public static final String No_data_Prompt_Msg_Css = getProperty("no_data_prompt_msg_css");
    
    /**
     * Sort By Dev Equivalent Descend
     */
    public static final String Sort_By_Dev_Equivalent_Descend_Css = getProperty("sort_by_dev_equivalent_descend_css");
    
    /**
     * Sort By Commits Descend
     */
    public static final String Sort_By_Commits_Descend_Css = getProperty("sort_by_commits_descend_css");
    
    /**
     * Sort By Contributor Descend
     */
    public static final String Sort_By_Contributors_Descend_Css = getProperty("sort_by_contributors_descend_css");
    
    /**
     * Sort By Update Time Stamp Descend
     */
    public static final String Sort_By_Update_Timestamp_Descend_Css = getProperty("sort_by_update_timestamp_descend_css");
    
    /**
     * Sort By Subscription Time Stamp Descend
     */
    public static final String Sort_By_Subscription_Timestamp_Descend_Css = getProperty("sort_by_subscription_timestamp_descend_css");
}
