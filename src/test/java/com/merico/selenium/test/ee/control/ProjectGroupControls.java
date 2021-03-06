package com.merico.selenium.test.ee.control;

import java.io.InputStream;
import java.util.Properties;

import com.merico.selenium.test.ee.utils.Utilities;

public class ProjectGroupControls {
	private static Properties props = null;
    static {
        try {
            props = new Properties();
            InputStream in = ProjectGroupControls.class.getClassLoader().getResourceAsStream("project-group-control.properties");
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

    private ProjectGroupControls() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * Project Group Navigation bar
     */
    public static String Project_Group_Link_Xpath = getProperty("project_group_link_xpath");
    
    /**
     * Add Project Group Button
     */
    public static String Add_Project_Group_Btn_Css = getProperty("add_project_group_btn_css");
    
    /**
     * Project Group Name TextBox
     */
    public static String Project_Group_Name_Id = getProperty("project_group_name_id");
    
    /**
     * Project Group Description TextBox
     */
    public static String Project_Group_Description_Id = getProperty("project_group_description_id");
    
    /**
     * Project Group Confirm Button
     */
    public static String Project_Group_Confirm_Btn_Css = getProperty("project_group_confirm_btn_css");
    
    /**
     * Search TextBox
     */
    public static String Search_Textbox_Css = getProperty("search_textbox_css");
    
    /**
     * Search Result Item Link
     */
    public static String Search_Item_Link_Css = getProperty("search_item_link_css");
    
    /**
     * Project Group Tree Node
     */
    public static String Project_Group_Treenode_Css = getProperty("project_group_treenode_css");
    
    /**
     * Batch Checkbox
     */
    public static String Batch_Checkbox_Css = getProperty("batch_checkbox_css");
    
    /**
     * Batch Move Button
     */
    public static String Batch_Move_Btn_Css = getProperty("batch_move_btn_css");
    
    /**
     * Batch Delete Button
     */
    public static String Batch_Del_Btn_Css = getProperty("batch_del_btn_css");
    
    /**
     * Tree Node Trigger Left
     */
    public static String Treenode_Trigger_Left_Css = getProperty("treenode_trigger_left_css");
    
    /**
     * Tree Node Trigger Right
     */
    public static String Treenode_Trigger_Right_Css = getProperty("treenode_trigger_right_css");
    
    /**
     * Tree Node Item Checkbox Right
     */
    public static String Treenode_Item_Checkbox_Right_Css = getProperty("treenode_item_checkbox_right_css");
    
    /**
     * Tree Node Focus Button
     */
    public static String Treenode_Focus_Btn_Right_Css = getProperty("treenode_focus_btn_right_css");
    
    /**
     * Tree Node Unfocus Button
     */
    public static String Treenode_Unfocus_Btn_Right_Css = getProperty("treenode_unfocus_btn_right_css");
    
    /**
     * All Project Group Tab
     */
    public static String All_Project_Group_Tab_Css = getProperty("all_project_group_tab_css");
    
    /**
     * Focus Project Group Tab
     */
    public static String Focus_Project_Group_Tab_Css = getProperty("focus_project_group_tab_css");
    
    /**
     * Add Sub Project Group
     */
    public static String Add_Sub_Project_Group_Xpath = Utilities.utf8Char(getProperty("add_sub_project_group_xpath"));
    
    /**
     * Edit Project Group
     */
    public static String Edit_Project_Group_Xpath = Utilities.utf8Char(getProperty("edit_project_group_xpath"));
    
    /**
     * Move Project Group
     */
    public static String Move_Project_Group_Xpath = Utilities.utf8Char(getProperty("move_project_group_xpath"));
    
    /**
     * Delete Project Group
     */
    public static String Del_Project_Group_Xpath = Utilities.utf8Char(getProperty("del_project_group_xpath"));
    
    /**
     * Delete project Group TextBox
     */
    public static String Del_Project_Group_Textbox_Css = getProperty("del_project_group_textbox_css");
    
    /**
     * Delete Project Group Confirm Button
     */
    public static String Del_Project_Group_Confirm_Btn_Css = getProperty("del_project_group_confirm_btn_css");
    
    /**
     * Move Input Textbox
     */
    public static String Move_Input_Textbox_Id = getProperty("move_input_textbox_id");
    
    /**
     * Move Project Group Confirm Button
     */
    public static String Move_Project_Group_Confirm_Btn_Css = getProperty("move_project_group_confirm_btn_css");
    
    /**
     * Toast
     */
    public static String Operating_Toast_Close_Css = getProperty("operating_toast_close_css");
}
