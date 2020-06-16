package com.merico.selenium.test.ee.control;

import java.io.InputStream;
import java.util.Properties;

import com.merico.selenium.test.ee.utils.Utilities;

public class ProjectGroupControls {
	private static Properties props = null;
    static {
        try {
            props = new Properties();
            InputStream in = LoginControls.class.getClassLoader().getResourceAsStream("project-group-control.properties");
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
    public static String Project_Group_Link_LinkText = Utilities.utf8Char(getProperty("project_group_link_linktext"));
    
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
     * Tree Node Trigger Left
     */
    public static String Treenode_Trigger_Left_Css = getProperty("treenode_trigger_left_css");
    
    /**
     * Tree Node Trigger Right
     */
    public static String Treenode_Trigger_Right_Css = getProperty("treenode_trigger_right_css");
    
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
     * Toast
     */
    public static String Operating_Toast_Close_Css = getProperty("operating_toast_close_css");
}
