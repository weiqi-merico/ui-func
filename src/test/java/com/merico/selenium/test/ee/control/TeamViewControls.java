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
     * Code Number Label
     */
    public static final String Code_Number_Laber_Xpath = Utilities.utf8Char(getProperty("code_number_laber_xpath"));
    
    /**
     * Team Productivity Step By Day
     */
    public static final String Team_Productivity_Step_Css = getProperty("team_productivity_step_css");
}
