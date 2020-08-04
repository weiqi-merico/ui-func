package com.merico.selenium.test.ee.control;

import java.io.InputStream;
import java.util.Properties;

import com.merico.selenium.test.ee.utils.Utilities;

public class RepoReportControls {
	private static Properties props = null;
    static {
        try {
            props = new Properties();
            InputStream in = ProjectGroupControls.class.getClassLoader().getResourceAsStream("repo-report-control.properties");
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

    private RepoReportControls() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * Search By Git or Address Textbox
     */
    public static final String Search_By_Git_Addr_Textbox_Css = getProperty("search_by_git_addr_textbox_css");
    
    /**
     * View Report Button
     */
    public static final String View_Report_Btn_Xpath = getProperty("view_report_btn_xpath");
    
    /**
     * Collapse Flag
     */
    public static final String Collapse_Flag_Css = getProperty("collapse_flag_css");
    
    /**
     * Hash Copy Button
     */
    public static final String Hash_Copy_Btn_Xpath = getProperty("hash_copy_btn_xpath");
    
    /**
     * Hash Copy Tooltip
     */
    public static final String Hash_Copy_Tooltip_Css = getProperty("hash_copy_tooltip_css");
    
    /**
     * General Report Header Name
     */
    public static final String General_Report_Header_Name_Xpath = getProperty("general_report_header_name_xpath");
    
    /**
     * Accumulation Dev Eq Tab
     */
    public static final String Accumulation_Dev_Eq_Tab_Css = getProperty("accumulation_dev_eq_tab_css");
    
    /**
     * Daily Dev Eq Tab
     */
    public static final String Daily_Dev_Eq_Tab_Css = getProperty("daily_dev_eq_tab_css");
    
    /**
     * Dev Eq Canvas
     */
    public static final String Dev_Eq_Canvas_Css = getProperty("dev_eq_canvas_css");
    
    /**
     * Modularity Label
     */
    public static final String Modularity_Label_Xpath = getProperty("modularity_label_xpath");
    
    /**
     * Codebase Growth Label
     */
    public static final String Codebase_Growth_Label_Xpath = getProperty("codebase_growth_label_xpath");
    
    /**
     * Team Robustness Label
     */
    public static final String Team_Robustness_Label_Xpath = getProperty("team_robustness_label_xpath");
    
    /**
     * Team Robustness Detail Link
     */
    public static final String Team_Robustness_Detail_Link_Css = getProperty("team_robustness_detail_link_css");
    
    /**
     * Codebase Dryness Label
     */
    public static final String Codebase_Dryness_Label_Xpath = getProperty("codebase_dryness_label_xpath");
    
    /**
     * Codebase Dryness Detail Link
     */
    public static final String Codebase_Dryness_Detail_Link_Css = getProperty("codebase_dryness_detail_link_css");
    
    /**
     * Test Coverage Label
     */
    public static final String Test_Coverage_Label_Xpath = getProperty("test_coverage_label_xpath");
    
    /**
     * Test Coverage Detail Link
     */
    public static final String Test_Coverage_Detail_Link_Css = getProperty("test_coverage_detail_link_css");
    
    /**
     * Doc Coverage Label
     */
    public static final String Doc_Coverage_Label_Xpath = getProperty("doc_coverage_label_xpath");
    
    /**
     * Doc Coverage Detail Link
     */
    public static final String Doc_Coverage_Detail_Link_Css = getProperty("doc_coverage_detail_link_css"); 
    
    /**
     * Radar Tooltip
     */
    public static final String Radar_Tooltip_Xpath = getProperty("radar_tooltip_xpath");
    
    /**
     * Function Page Header
     */
    public static final String Function_Page_Header_Xpath = getProperty("function_page_header_xpath");
    
    /**
     * Top Contributors Header
     */
    public static final String Top_Contributors_Header_Css = getProperty("top_contributors_header_css");
    
    /**
     * Top Contributors Details Link
     */
    public static final String Top_Contributors_Details_Link_Css = getProperty("top_contributors_details_link_css");
    
    /**
     * Top Contributors All Time Tab
     */
    public static final String Top_Contributors_All_Time_Tab_Xpath = getProperty("top_contributors_all_time_tab_xpath");
    
    /**
     * Top Contributors Past Year Tab
     */
    public static final String Top_Contributors_Past_Year_Tab_Xpath = getProperty("top_contributors_past_year_tab_xpath");
    
    /**
     * Top Contributors Past Month Tab
     */
    public static final String Top_Contributors_Past_Month_Tab_Xpath = getProperty("top_contributors_past_month_tab_xpath");
    
    /**
     * Top Contributors Past Week Tab
     */
    public static final String Top_Contributors_Past_Week_Tab_Xpath = getProperty("top_contributors_past_week_tab_xpath");
    
    /**
     * Top Contributors List Item First Item
     */
    public static final String Top_Contributors_List_Item_First_Css = getProperty("top_contributors_list_item_first_css");
    
    /**
     * Contributor Profile Header Title
     */
    public static final String Contributor_Profile_Header_Xpath = getProperty("contributor_profile_header_xpath");
    
    /**
     * Top Commits Header
     */
    public static final String Top_Commits_Header_Css = getProperty("top_commits_header_css");
    
    /**
     * Top Commits Details Link
     */
    public static final String Top_Commits_Details_Link_Css = getProperty("top_commits_details_link_css");
    
    /**
     * Top Commits All Time Tab
     */
    public static final String Top_Commits_All_Time_Tab_Xpath = getProperty("top_commits_all_time_tab_xpath");
    
    /**
     * Top Commits Past Year Tab
     */
    public static final String Top_Commits_Past_Year_Tab_Xpath = getProperty("top_commits_past_year_tab_xpath");
    
    /**
     * Top Commits Past Month Tab
     */
    public static final String Top_Commits_Past_Month_Tab_Xpath = getProperty("top_commits_past_month_tab_xpath");
    
    /**
     * Top Commits Past Week Tab
     */
    public static final String Top_Commits_Past_Week_Tab_Xpath = getProperty("top_commits_past_week_tab_xpath");
    
    /**
     * Top Commit List Item First Item
     */
    public static final String top_commits_list_item_first_css = getProperty("top_commits_list_item_first_css");
    
    /**
     * Manpower Allocation
     */
    public static final String manpower_allocation_canvas_css = getProperty("manpower_allocation_canvas_css");
    
    /**
     * Developer Strengths Header Title
     */
    public static final String Developer_Strengths_Header_Css = getProperty("developer_strengths_header_css");
    
    /**
     * Developer Strengths Selection
     */
    public static final String Developer_Strengths_Selection_Css = getProperty("developer_strengths_selection_css");
    
    /**
     * Developer Strengths Histogram
     */
    public static final String Developer_Strengths_Histogram_Xpath = getProperty("developer_strengths_histogram_xpath");
    
    /**
     * Developer Strengths Pie
     */
    public static final String Developer_Strengths_Pie_Css = getProperty("developer_strengths_pie_css");
    
    /**
     * Topic Tags Header Title
     */
    public static final String Topic_Tags_Header_Css = getProperty("topic_tags_header_css");
    
    /**
     * Topic Tags Canvas
     */
    public static final String Topic_Tags_Canvas_Xpath = getProperty("topic_tags_canvas_xpath");
    
    /**
     * Contribution Perspective Canvas Left side
     */
    public static final String Contribution_Perspective_Canvas_Left_Xpath = getProperty("contribution_perspective_canvas_left_xpath");
    
    /**
     * Contribution Perspective Canvas Right side
     */
    public static final String Contribution_Perspective_Canvas_Right_Xpath = getProperty("contribution_perspective_canvas_right_xpath");
    
    /**
     * Code Contribution And Salary Canvas
     */
    public static final String Code_Contribution_And_Salary_Canvas_Css = getProperty("code_contribution_and_salary_canvas_css");
    
    /**
     * Code Contribution And Salary By Salary Button
     */
    public static final String Code_Contribution_And_Salary_By_Salary_Css = getProperty("code_contribution_and_salary_by_salary_css");
    
    /**
     * Code Contribution And Salary By Level Button
     */
    public static final String Code_Contribution_And_Salary_By_Level_Css = getProperty("code_contribution_and_salary_by_level_css");
    
    /**
     * Code Quality Issues Detail Link
     */
    public static final String Code_Quality_Issues_Detail_Link_Css = getProperty("code_quality_issues_detail_link_css");
    
    /**
     * Block Issue Link
     */
    public static final String Block_Issue_Link_Css = getProperty("block_issue_link_css");
    
    /**
     * Critical Issues Link
     */
    public static final String Critical_Issues_Link_Css = getProperty("critical_issues_link_css");
    
    /**
     * Major Issues Link
     */
    public static final String Major_Issues_Link_Css = getProperty("major_issues_link_css");
    
    /**
     * Minor Issues Link
     */
    public static final String Minor_Issues_Link_Css = getProperty("minor_issues_link_css");
    
    /**
     * Info Issues Link
     */
    public static final String Info_Issues_Link_Css = getProperty("info_issues_link_css");
    
    /**
     * Analysis Task List Link
     */
    public static final String analysis_task_list_link = Utilities.utf8Char(getProperty("analysis_task_list_link"));
    
    /**
     * Backward Analysis Button
     */
    public static final String Backward_Analysis_Btn_Css = getProperty("backward_analysis_btn_css");
    
    /**
     * Due Date Input
     */
    public static final String Due_Date_Input_Name = getProperty("due_date_input_name");
    
    /**
     * First Commit Button
     */
    public static final String First_Commit_Btn_Link = Utilities.utf8Char(getProperty("first_commit_btn_link"));
    
    /**
     * Last Commit Button
     */
    public static final String Last_Commit_Btn_Link = Utilities.utf8Char(getProperty("last_commit_btn_link"));
    
    /**
     * Before End Of Selected Day
     */
    public static final String Before_End_Of_Selected_Day_Xpath = getProperty("before_end_of_selected_day_xpath");
    
    /**
     * Analysis Date Submit Button
     */
    public static final String Analysis_Date_Submit_Btn_Css = getProperty("analysis_date_submit_btn_css");
    
    /**
     * Cancel Analysis Link
     */
    public static final String Cancel_Analysis_Link_Css = getProperty("cancel_analysis_link_css");
    
    /**
     * Failed Status Link
     */
    public static final String Failed_Status_Link_Css = getProperty("failed_status_link_css");
    
    /**
     * Abnormal Info box
     */
    public static final String Abnormal_Info_Box_Css = getProperty("abnormal_info_box_css");
    
    /**
     * Analysis Task List Page Jummper
     */
    public static final String Analysis_Task_List_Page_Jumper_Css = getProperty("analysis_task_list_page_jumper_css");
    
    /**
     * Analysis Task List Page Jumper Input
     */
    public static final String Analysis_Task_List_Page_Jumper_Input_Css = getProperty("analysis_task_list_page_jumper_input_css");
    
    /**
     * Analysis Task List Table Table Row
     */
    public static final String Analysis_Task_List_Table_Tr_Css = getProperty("analysis_task_list_table_tr_css");
}
