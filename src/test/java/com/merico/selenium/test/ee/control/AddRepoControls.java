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
}
