package com.merico.selenium.test.ee.control;

import java.io.InputStream;
import java.util.Properties;

import com.merico.selenium.test.ee.utils.Utilities;

public class TeamViewControls {
	private static Properties props = null;
    static {
        try {
            props = new Properties();
            InputStream in = TeamViewControls.class.getClassLoader().getResourceAsStream("teams-control.properties");
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

    private TeamViewControls() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * Team Link
     */
    public static final String Teams_Link_Xpath = getProperty("teams_link_xpath");
    
    /**
     * Search Team Member Textbox
     */
    public static final String Search_Teams_Member_Textbox_Css = getProperty("search_teams_member_textbox_css");
    
    /**
     * Team Css Search Status
     */
    public static final String Team_Css_Search_Status_Xpath = getProperty("team_css_search_status_xpath");
    
    /**
     * Filter Box
     */
    public static final String Filter_Box_Id = getProperty("filter_box_id");
    
    /**
     * No Data Flag
     */
    public static final String Efficiency_Data_Flag_Xpath = getProperty("efficiency_data_flag_xpath");
    
    /**
     * Quality Data Flag
     */
    public static final String Quality_Data_Flag_Xpath = getProperty("quality_data_flag_xpath");
    
    /**
     * Char Sort Data
     */
    public static final String Char_Sort_Data_Xpath = getProperty("char_sort_data_xpath");
    
    /**
     * Root Node Data
     */
    public static final String Root_Node_Data_Xpath = getProperty("root_node_data_xpath");
    
    /**
     * Member
     */
    public static final String Member_Css = getProperty("member_css");
    
    /**
     * Member Tooltip
     */
    public static final String Member_Tooltip_Css = getProperty("member_tooltip_css");
    
    /**
     * Sub Group
     */
    public static final String Sub_Group_Css = getProperty("sub_group_css");
    
    /**
     * Sub Group Tooltip
     */
    public static final String Sub_Group_Tooltip_Css = getProperty("sub_group_tooltip_css");
    
    /**
     * Root Node
     */
    public static final String root_node_css = getProperty("root_node_css");
    
    /**
     * Productivity Label
     */
    public static final String Productivity_Label_Xpath = Utilities.utf8Char(getProperty("productivity_label_xpath"));
    
    /**
     * Quality Label
     */
    public static final String Quality_Label_Xpath = Utilities.utf8Char(getProperty("quality_label_xpath"));
    
    /**
     * Code Number Label
     */
    public static final String Code_Number_Laber_Xpath = Utilities.utf8Char(getProperty("code_number_laber_xpath"));
    
    /**
     * Team Productivity Step By Day
     */
    public static final String Team_Productivity_Step_Css = getProperty("team_productivity_step_css");
    
    /**
     * Team Member Search Box
     */
    public static final String Team_Member_Search_Box_Css = getProperty("team_member_search_box_css");
    
    /**
     * Team Member Primary Email
     */
    public static final String Team_Member_Primary_Email_Css = getProperty("team_member_primary_email_css");
    
    /**
     * Team Member Email
     */
    public static final String Team_Member_Email_Css = getProperty("team_member_email_css");
    
    /**
     * Team Member Close
     */
    public static final String Team_Member_Close_Css = getProperty("team_member_close_css");
    
    /**
     * Efficiency Data Flag for Team Detail View
     */
    public static final String Efficiency_Data_Flag_4_Tdv_Xpath = getProperty("efficiency_data_flag_4_tdv_xpath");
    
    /**
     * Quality Data Head Flag for Team Detail View
     */
    public static final String Quality_Data_Head_Flag_4_Tdv_Xpath = getProperty("quality_data_head_flag_4_tdv_xpath");
    
    /**
     * Quality No Data Flag for Team Detail View
     */
    public static final String Quality_No_data_Flag_4_Tdv_Xpath = getProperty("quality_no_data_flag_4_tdv_xpath");
    
    /**
     * Paging Right Angle Bracket
     */
    public static final String Paging_Right_Angle_Bracket_Css = getProperty("paging_right_angle_bracket_css");
    
    /**
     * Paing Left Angle Bracket
     */
    public static final String Paging_Left_Angle_Bracket_Css = getProperty("paging_left_angle_bracket_css");
    
    /**
     * Paging Selection Box
     */
    public static final String Paging_Selection_Box_Css = getProperty("paging_selection_box_css");
    
    /**
     * Paging Input Box
     */
    public static final String Paging_Input_Box_Css = getProperty("paging_input_box_css");
    
    /**
     * Paging Total Items
     */
    public static final String Paging_Total_Items_Xpath = getProperty("paging_total_items_xpath");
    
    /**
     * Developer Name for Team Dev View
     */
    public static final String Developer_Name_4_Tdevv_Css = getProperty("developer_name_4_tdevv_css");
    
    /**
     * Developer Email for Team Dev View
     */
    public static final String Developer_Email_4_Tdevv_Css = getProperty("developer_email_4_tdevv_css");
    
    /**
     * Main Code Repo
     */
    public static final String Main_Code_Repo_4_Tdevv_Css = getProperty("main_code_repo_4_tdevv_css");
    
    /**
     * Top Skills
     */
    public static final String Top_Skills_4_Tdevv_Css = getProperty("top_skills_4_tdevv_css");
    
    /**
     * Developer Productivity Label
     */
    public static final String Dev_Productivity_Label_Css = getProperty("dev_productivity_label_css");
}
