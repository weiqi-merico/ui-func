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
    
    /**
     * Commits Link
     */
    public static final String Commits_Link_Link = Utilities.utf8Char(getProperty("commits_link_link"));
    
    /**
     * Commits Start Date Textbox
     */
    public static final String Commits_Start_Date_Textbox_Id = getProperty("commits_start_date_textbox_id");
    
    /**
     * Commits Calendar with This Year Button
     */
    public static final String Commits_Calendar_With_This_Year_Btn_Css = getProperty("commits_calendar_with_this_year_btn_css");
    
    /**
     * Commits Contributor Textbox
     */
    public static final String Commits_Contributor_Textbox_Css = getProperty("commits_contributor_textbox_css");
    
    /**
     * Commits Search Title Textbox
     */
    public static final String Commits_Search_Title_Textbox_Id = getProperty("commits_search_title_textbox_id");
    
    /**
     * Commits Search Button
     */
    public static final String Commits_Search_Btn_Css = getProperty("commits_search_btn_css");
    
    /**
     * Commits Info
     */
    public static final String Commits_Info_Xpath = getProperty("commits_info_xpath");
    
    /**
     * Commits Info Tooltip
     */
    public static final String Commits_Info_Tooltip_Css = getProperty("commits_info_tooltip_css");
    
    /**
     * Commits Info Contributor Email
     */
    public static final String Commits_Info_Contributor_Email_Xpath = getProperty("commits_info_contributor_email_xpath");
    
    /**
     * Dev Val Column
     */
    public static final String Dev_Val_Col_Xpath = Utilities.utf8Char(getProperty("dev_val_col_xpath"));
    
    /**
     * Commits Submit Time Column
     */
    public static final String Commits_Submit_Time_Col_Xpath = Utilities.utf8Char(getProperty("commits_submit_time_col_xpath"));
    
    /**
     * Commits Detail Button Link
     */
    public static final String Commits_Detail_Btn_Link_Xpath = getProperty("commits_detail_btn_link_xpath");
    
    /**
     * Commits Detail Page Dev Val
     */
    public static final String Commits_Detail_Page_Dev_Val_Xpath = getProperty("commits_detail_page_dev_val_xpath");
    
    /**
     * Commits List Page Jumper
     */
    public static final String Commits_List_Page_Jumper_Xpath = Utilities.utf8Char(getProperty("commits_list_page_jumper_xpath"));
    
    /**
     * Contributor Link
     */
    public static final String Contributors_Link_Link = Utilities.utf8Char(getProperty("contributors_link_link"));
    
    /**
     * Calendar Delete Link
     */
    public static final String Calendar_Delete_Link_Css = getProperty("calendar_delete_link_css");
    
    /**
     * Contributors Calendar Start Date Textbox
     */
    public static final String Contributors_Calendar_Start_Date_Textbox_Id = getProperty("contributors_calendar_start_date_textbox_id");
    
    /**
     * Contributors Search Button
     */
    public static final String contributors_search_btn_css = getProperty("contributors_search_btn_css");
    
    /**
     * Contributors Export Data Button Button
     */
    public static final String Contributors_Export_Data_Btn_Css = getProperty("contributors_export_data_btn_css");
    
    /**
     * Contributors Detail Button Link
     */
    public static final String contributors_detail_btn_link_xpath = getProperty("contributors_detail_btn_link_xpath");
    
    /**
     * Contributors Table Contributor
     */
    public static final String contributors_table_contributor_css = getProperty("contributors_table_contributor_css");
    
    /**
     * Contributors Table Dev Val
     */
    public static final String contributors_table_dev_val_xpath = Utilities.utf8Char(getProperty("contributors_table_dev_val_xpath"));
    
    /**
     * Contributors Table Dev Eq
     */
    public static final String contributors_table_dev_eq_xpath = Utilities.utf8Char(getProperty("contributors_table_dev_eq_xpath"));
    
    /**
     * Contributors Contributor Delete Flag
     */
    public static final String Contributors_Contributor_Delete_Flag_Css = getProperty("contributors_contributor_delete_flag_css");
    
    public static final String Contributors_List_Page_Jumper_Css = getProperty("contributors_list_page_jumper_css");
    
    public static final String Metrics_Trends_Link_Link = Utilities.utf8Char(getProperty("metrics_trends_link_link"));
    
    public static final String Metrics_Trends_Collapse_Link_Css = getProperty("metrics_trends_collapse_link_css");
    
    public static final String Metrics_Trends_Contributors_Selection_Textbox_Css = getProperty("metrics_trends_contributors_selection_textbox_css");
    
    public static final String Metrics_Trends_Contributors_Label_Css = getProperty("metrics_trends_contributors_label_css");
    
    public static final String Metrics_Trends_Repo_Label_Css = getProperty("metrics_trends_repo_label_css");
    
    public static final String Metrics_Trends_Dev_Eq_Label_Css = getProperty("metrics_trends_dev_eq_label_css");
    
    public static final String Metrics_Trends_Sloc_Label_Css = getProperty("metrics_trends_sloc_label_css");
    
    public static final String Group_Metrics_Trends_Sloc_Label_Xpath = Utilities.utf8Char(getProperty("group_metrics_trends_sloc_label_xpath"));
    
    public static final String Metrics_Trends_Num_Of_Commits_Label_Css = getProperty("metrics_trends_num_of_commits_label_css");
    
    public static final String Group_Metrics_Trends_Num_Of_Commits_Label_Xpath = Utilities.utf8Char(getProperty("group_metrics_trends_num_of_commits_label_xpath"));
    
    public static final String Metrics_Trends_Cyclomatic_Complexity_Label_Css = getProperty("metrics_trends_cyclomatic_complexity_label_css");
    
    public static final String Metrics_Trends_Doc_Coverage_label_css = getProperty("metrics_trends_doc_coverage_label_css");
    
    public static final String Metrics_Trends_Test_Coverage_Label_Css = getProperty("metrics_trends_test_coverage_label_css");
    
    public static final String Metrics_Trends_Velocity_Label_Css = getProperty("metrics_trends_velocity_label_css");
    
    public static final String Metrics_Trends_Reusability_Label_Css = getProperty("metrics_trends_reusability_label_css");
    
    public static final String Metrics_Trends_Modulatity_Label_Css = getProperty("metrics_trends_modulatity_label_css");
    
    public static final String Metrics_Trends_Robustness_Label_Css = getProperty("metrics_trends_robustness_label_css");
    
    public static final String Metrics_trends_blocker_issues_label_css = getProperty("metrics_trends_blocker_issues_label_css");
    
    public static final String metrics_trends_critical_issues_label_css = getProperty("metrics_trends_critical_issues_label_css");
    
    public static final String Metrics_Trends_Major_Issues_Label_Css = getProperty("metrics_trends_major_issues_label_css");
    
    public static final String Metrics_Trends_Minor_Issues_Label_Css = getProperty("metrics_trends_minor_issues_label_css");
    
    public static final String Metrics_Trends_Info_Issues_Label_Css = getProperty("metrics_trends_info_issues_label_css");
    
    public static final String Metrics_Trends_Guides_Label_Css = getProperty("metrics_trends_guides_label_css");
    
    public static final String Metrics_Trends_Guides_Question_Mark_Xpath = getProperty("metrics_trends_guides_question_mark_xpath");
    
    public static final String Group_Metrics_Trends_Guides_Question_Mark_Xpath = getProperty("group_metrics_trends_guides_question_mark_xpath");
    
    public static final String Metrics_Trends_Guides_Tooltip_Css = getProperty("metrics_trends_guides_tooltip_css");
    
    public static final String Metrics_Trends_Last_Week_Label_Css = getProperty("metrics_trends_last_week_label_css");
    
    public static final String Group_Metrics_Trends_Last_Week_Label_Css = getProperty("group_metrics_trends_last_week_label_css");
    
    public static final String Metrics_Trends_Last_Month_Label_Css = getProperty("metrics_trends_last_month_label_css");
    
    public static final String Group_Metrics_Trends_Last_Month_Label_Css = getProperty("group_metrics_trends_last_month_label_css");
    
    public static final String Metrics_Trends_Last_Year_Label_Css = getProperty("metrics_trends_last_year_label_css");
    
    public static final String Group_Metrics_Trends_Last_Year_Label_Css = getProperty("group_metrics_trends_last_year_label_css");
    
    public static final String metrics_trends_all_time_label_css = getProperty("metrics_trends_all_time_label_css");
    
    public static final String Metrics_Trends_Custom_Label_Css = getProperty("metrics_trends_custom_label_css");
    
    public static final String Metrics_Trends_By_Day_Label_Css = getProperty("metrics_trends_by_day_label_css");
    
    public static final String Group_Metrics_Trends_By_Day_Label_Css = getProperty("group_metrics_trends_by_day_label_css");
    
    public static final String Metrics_Trends_By_Week_Label_Css = getProperty("metrics_trends_by_week_label_css");
    
    public static final String Group_Metrics_Trends_By_week_Label_Css = getProperty("group_metrics_trends_by_week_label_css");
    
    public static final String Metrics_Trends_By_Month_Label_Css = getProperty("metrics_trends_by_month_label_css");
    
    public static final String Group_Metrics_Trends_By_Month_Label_Css = getProperty("group_metrics_trends_by_month_label_css");
    
    public static final String Metrics_Trends_By_Year_Label_Css = getProperty("metrics_trends_by_year_label_css");
    
    public static final String Group_Metrics_Trends_By_Year_Label_Css = getProperty("group_metrics_trends_by_year_label_css");
    
    public static final String Metrics_Trends_Date_Start_Time_Textbox_Css = getProperty("metrics_trends_date_start_time_textbox_css");
    
    public static final String Metrics_Trends_Date_End_Time_Textbox_Xpath = Utilities.utf8Char(getProperty("metrics_trends_date_end_time_textbox_xpath"));
    
    public static final String Metrics_Trends_Line_Chart_Label_Xpath = Utilities.utf8Char(getProperty("metrics_trends_line_chart_label_xpath"));
    
    public static final String Metrics_Trends_Bar_Chart_Label_Xpath = Utilities.utf8Char(getProperty("metrics_trends_bar_chart_label_xpath"));
    
    public static final String Metrics_Trends_Line_Chart_Canvas_Css = getProperty("metrics_trends_line_chart_canvas_css");
    
    public static final String Metrics_Trends_Bar_Chart_Canvas_xpath = getProperty("metrics_trends_bar_chart_canvas_xpath");
    
    public static final String Report_Problems_Link_Link = Utilities.utf8Char(getProperty("report_problems_link_link"));
    
    public static final String Report_Problems_Info_Svg_Xpath = getProperty("report_problems_info_svg_xpath");
    
    public static final String Report_Problems_Info_Hash_Copy_Css = getProperty("report_problems_info_hash_copy_css");
    
    public static final String Report_Problems_Info_Hash_Copy_Tooltip_Css = getProperty("report_problems_info_hash_copy_tooltip_css");
    
    public static final String Report_Problems_Select_Branch_Xpath = getProperty("report_problems_select_branch_xpath");
    
    public static final String Report_Problems_Another_Branch_Checkbox_Xpath = getProperty("report_problems_another_branch_checkbox_xpath");
    
    public static final String Report_Problems_Another_Branch_Dropdown_Xpath = getProperty("report_problems_another_branch_dropdown_xpath");
    
    public static final String Report_Problems_New_Analysis_Btn_Xpath = getProperty("report_problems_new_analysis_btn_xpath");
    
    public static final String Report_Problems_New_Analysis_Refresh_Btn_Css = getProperty("report_problems_new_analysis_refresh_btn_css");
    
    public static final String Report_Problems_New_Analysis_Selection_Box_Css = getProperty("report_problems_new_analysis_selection_box_css");
    
    public static final String Report_Problems_New_Analysis_Branch_Hash_Info_Css = getProperty("report_problems_new_analysis_branch_hash_info_css");
    
    public static final String Report_Problems_New_Analysis_Cancel_Btn_Css = getProperty("report_problems_new_analysis_cancel_btn_css");
    
    public static final String Report_Problems_New_Analysis_Submit_Btn_Xpath = getProperty("report_problems_new_analysis_submit_btn_xpath");
    
    public static final String Report_Problems_Total_Issues_Num_Label_Css = getProperty("report_problems_total_issues_num_label_css");
    
    public static final String Report_Problems_All_Authors_Dropdown_Xpath = Utilities.utf8Char(getProperty("report_problems_all_authors_dropdown_xpath"));
    
    public static final String Report_Problems_All_Rules_Dropdown_Xpath = Utilities.utf8Char(getProperty("report_problems_all_rules_dropdown_xpath"));
    
    public static final String Report_Problems_All_Types_Dropdown_Xpath = Utilities.utf8Char(getProperty("report_problems_all_types_dropdown_xpath"));
    
    public static final String Report_Problems_Severities_Dropdown_Xpath = Utilities.utf8Char(getProperty("report_problems_severities_dropdown_xpath"));
    
    public static final String Report_Problems_Unix_Glob_Syntax_Textbox_Xpath = getProperty("report_problems_unix_glob_syntax_textbox_xpath");
    
    public static final String Report_Problems_Rule_Alone_Label_Xpath = getProperty("report_problems_rule_alone_label_xpath");
    
    public static final String Report_Problems_Severity_Alone_Label_Xpath = getProperty("report_problems_severity_alone_label_xpath");
    
    public static final String Report_Problems_Type_Alone_Label_Xpath = getProperty("report_problems_type_alone_label_xpath");
    
    public static final String Report_Problems_Author_Alone_Label_Xpath = getProperty("report_problems_author_alone_label_xpath");
    
    public static final String Report_Problems_File_Alone_Label_Css = getProperty("report_problems_file_alone_label_css");
    
    public static final String Report_Problems_File_Diagram_Label_Xpath = getProperty("report_problems_file_diagram_label_xpath");
    
    public static final String Report_Problems_File_Source_Xpath = getProperty("report_problems_file_source_xpath");
    
    public static final String Report_Problems_Page_Fixed_Jumper_Xpath = getProperty("report_problems_page_fixed_jumper_xpath");
    
    public static final String Group_Report_Problems_Page_Fixed_Jumper_Xpath = getProperty("group_report_problems_page_fixed_jumper_xpath");
    
    public static final String Report_Problems_Page_Jumper_Input_Textbox_Xpath = getProperty("report_problems_page_jumper_input_textbox_xpath");
    
    public static final String Report_Problems_Page_Row_Count_Css = getProperty("report_problems_page_row_count_css");
    
    public static final String Code_Duplicates_Link_Link = Utilities.utf8Char(getProperty("code_duplicates_link_link"));
    
    public static final String Code_Duplicates_Info_Hash_Copy_Css = getProperty("code_duplicates_info_hash_copy_css");
    
    public static final String Code_Duplicates_Info_Hash_Copy_Tooltip_Xpath = Utilities.utf8Char(getProperty("code_duplicates_info_hash_copy_tooltip_xpath"));
    
    public static final String Code_Duplicates_Select_Branch_Xpath = getProperty("code_duplicates_select_branch_xpath");
    
    public static final String Code_Duplicates_Group_Label_Xpath = getProperty("code_duplicates_group_label_xpath");
    
    public static final String Code_Duplicates_Info_Svg_Xpath = getProperty("code_duplicates_info_svg_xpath");
    
    public static final String Code_Duplicates_Code_File_Label_Xpath = getProperty("code_duplicates_code_file_label_xpath");
    
    public static final String Code_Duplicates_Source_Line_Xpath = getProperty("code_duplicates_source_line_xpath");
    
    public static final String Code_Duplicates_File_Checkbox_Xpath = getProperty("code_duplicates_file_checkbox_xpath");
    
    public static final String Code_Duplicates_Page_Fixed_Jumper_Xpath = getProperty("code_duplicates_page_fixed_jumper_xpath");
    
    public static final String Group_Code_Duplicates_Page_Fixed_Jumper_Xpath = getProperty("group_code_duplicates_page_fixed_jumper_xpath");
    
    public static final String Code_Duplicates_Page_Row_Count_Css = getProperty("code_duplicates_page_row_count_css");
    
    public static final String Test_Coverage_Link_Link = Utilities.utf8Char(getProperty("test_coverage_link_link"));
    
    public static final String Test_Coverage_Select_Branch_Xpath = getProperty("test_coverage_select_branch_xpath");
    
    public static final String Test_Coverage_Info_Svg_Xpath = getProperty("test_coverage_info_svg_xpath");
    
    public static final String Test_Coverage_Info_Hash_Copy_Css = getProperty("test_coverage_info_hash_copy_css");
    
    public static final String Test_Coverage_Info_Hash_Copy_Tooltip_Xpath = Utilities.utf8Char(getProperty("test_coverage_info_hash_copy_tooltip_xpath"));
    
    public static final String Test_Coverage_Canvas_Xpath = getProperty("test_coverage_canvas_xpath");
    
    public static final String Test_Coverage_All_Canvas_Css = getProperty("test_coverage_all_canvas_css");
    
    public static final String test_coverage_uncovered_functions_file_name_label_css = getProperty("test_coverage_uncovered_functions_file_name_label_css");
    
    public static final String Test_Coverage_Tooltip_Css = getProperty("test_coverage_tooltip_css");
    
    public static final String Test_Coverage_Uncovered_Functions_Load_More_Btn_Css = getProperty("test_coverage_uncovered_functions_load_more_btn_css");
    
    public static final String Test_Coverage_Uncovered_Functions_Items_Xpath = getProperty("test_coverage_uncovered_functions_items_xpath");
    
    public static final String Test_Coverage_By_Files_Load_More_Btn_Css = getProperty("test_coverage_by_files_load_more_btn_css");
    
    public static final String Test_Coverage_By_Files_Table_Row_Xpath = getProperty("test_coverage_by_files_table_row_xpath");
    
    public static final String Test_Coverage_Files_Table_Repo_Col_Xpath = Utilities.utf8Char(getProperty("test_coverage_files_table_repo_col_xpath"));
    
    public static final String Test_Coverage_Files_Table_File_Path_Col_Xpath = Utilities.utf8Char(getProperty("test_coverage_files_table_file_path_col_xpath"));
    
    public static final String Test_Coverage_Files_Coverage_Col_Xpath = Utilities.utf8Char(getProperty("test_coverage_files_coverage_col_xpath"));
    
    public static final String Doc_Coverage_Link_Link = Utilities.utf8Char(getProperty("doc_coverage_link_link"));
    
    public static final String Complexity_Functions_Link_Link = Utilities.utf8Char(getProperty("complexity_functions_link_link"));
    
    public static final String Complexity_Functions_Branch_Collapse_Css = getProperty("complexity_functions_branch_collapse_css");
    
    public static final String Complexity_Functions_Hash_Copy_Btn_Xpath = getProperty("complexity_functions_hash_copy_btn_xpath");
    
    public static final String Complexity_Functions_Hash_Copy_Tooltip_Css = getProperty("complexity_functions_hash_copy_tooltip_css");
    
    public static final String Complexity_Functions_Signature_Col_Xpath = Utilities.utf8Char(getProperty("complexity_functions_signature_col_xpath"));
    
    public static final String Complexity_Functions_Tooltip_Xpath = getProperty("complexity_functions_tooltip_xpath");
    
    public static final String Complexity_Functions_Filter_Label_Css = getProperty("complexity_functions_filter_label_css");
    
    public static final String Complexity_Functions_Table_Row_Col_Xpath = getProperty("complexity_functions_table_row_col_xpath");
    
    public static final String Complexity_Functions_Filter_Textbox_Name = getProperty("complexity_functions_filter_textbox_name");
    
    public static final String Complexity_Functions_Filter_Confirm_Xpath = getProperty("complexity_functions_filter_confirm_xpath");
    
    public static final String Complexity_Functions_Filter_Reset_Xpath = getProperty("complexity_functions_filter_reset_xpath");
    
    public static final String Complexity_Functions_Page_Fixed_Jumper_Xpath = getProperty("complexity_functions_page_fixed_jumper_xpath");
    
    public static final String Complexity_Functions_Page_Jumper_Input_Textbox_Xpath = getProperty("complexity_functions_page_jumper_input_textbox_xpath");
    
    public static final String Complexity_Functions_Table_Row_Xpath = getProperty("complexity_functions_table_row_xpath");
    
    public static final String Ranking_List_Link_Link = Utilities.utf8Char(getProperty("ranking_list_link_link"));
    
    public static final String Ranking_List_Start_Date_Textbox_Xpath = Utilities.utf8Char(getProperty("ranking_list_start_date_textbox_xpath"));
    
    public static final String Ranking_List_End_Date_Textbox_Xpath = Utilities.utf8Char(getProperty("ranking_list_end_date_textbox_xpath"));
    
    public static final String Ranking_List_Alert_Msg_Label_Css = getProperty("ranking_list_alert_msg_label_css");
    
    public static final String Ranking_List_Contributor_Link_Xpath = getProperty("ranking_list_contributor_link_xpath");
    
    public static final String Ranking_List_Dev_Value_Canvas_Xpath = getProperty("ranking_list_dev_value_canvas_xpath");
    
    public static final String Ranking_List_Dev_Eq_Canvas_Xpath = getProperty("ranking_list_dev_eq_canvas_xpath");
    
    public static final String Talent_Search_Link_Link = Utilities.utf8Char(getProperty("talent_search_link_link"));
    
    public static final String Talent_Search_Searching_Textbox_Id = getProperty("talent_search_searching_textbox_id");
    
    public static final String Talent_Search_Tech_Tag_Xpath = Utilities.utf8Char(getProperty("talent_search_tech_tag_xpath"));
    
    public static final String Talent_Search_Canvas_Xpath = getProperty("talent_search_canvas_xpath");
    
    public static final String Talent_Search_Close_Talent_Tag_Css = getProperty("talent_search_close_talent_tag_css");
    
    public static final String Talent_Search_View_Individual_Detail_Info_Xpath = Utilities.utf8Char(getProperty("talent_search_view_individual_detail_info_xpath"));
    
    public static final String Team_Robustness_Link_Link = Utilities.utf8Char(getProperty("team_robustness_link_link"));
    
    public static final String Team_Robustness_Contributors_Num_Label_Xpath = getProperty("team_robustness_contributors_num_label_xpath");
    
    public static final String Team_Robustness_Avg_Label_Xpath = getProperty("team_robustness_avg_label_xpath");
    
    public static final String Team_Robusstness_Flag_Label_Xpath = getProperty("team_robusstness_flag_label_xpath");
    
    public static final String Team_Robustness_Canvas_Xpath = getProperty("team_robustness_canvas_xpath");
    
    public static final String Members_Link_Link = Utilities.utf8Char(getProperty("members_link_link"));
    
    public static final String Members_Dev_Select_Dropdown_Xpath = Utilities.utf8Char(getProperty("members_dev_select_dropdown_xpath"));
    
    public static final String Members_Add_Btn_Css = getProperty("members_add_btn_css");
    
    public static final String Members_Close_Toast_Css = getProperty("members_close_toast_css");
    
    public static final String Members_Email_Info_Label_Xpath = getProperty("members_email_info_label_xpath");
    
    public static final String Members_Authorized_Info_Label_Xpath = getProperty("members_authorized_info_label_xpath");
    
    public static final String Members_Remove_Btn_Css = getProperty("members_remove_btn_css");
    
    public static final String Members_Remove_Btn_Cancel_Btn_Css = getProperty("members_remove_btn_cancel_btn_css");
    
    public static final String Members_Remove_Btn_Confirm_Btn_Css = getProperty("members_remove_btn_confirm_btn_css");
    
    public static final String Members_Invite_Members_Btn_Css = getProperty("members_invite_members_btn_css");
    
    public static final String Members_Invite_Members_Textbox_Css = getProperty("members_invite_members_textbox_css");
    
    public static final String Members_Team_Leader_Dropdown_Xpath = Utilities.utf8Char(getProperty("members_team_leader_dropdown_xpath"));
    
    public static final String Members_Invite_Btn_Css = getProperty("members_invite_btn_css");
    
    public static final String Members_Invite_Email_Info_Css = getProperty("members_invite_email_info_css");
    
    public static final String Members_Invited_Info_Label_Css = getProperty("members_invited_info_label_css");
    
    public static final String Members_Invite_Cancel_Btn_Css = getProperty("members_invite_cancel_btn_css");
    
    public static final String Members_Invite_Cancel_Cancel_Btn_Xpath = getProperty("members_invite_cancel_cancel_btn_xpath");
    
    public static final String Members_Invite_Cancel_Confirm_Btn_Css = getProperty("members_invite_cancel_confirm_btn_css");
    
    public static final String Members_Invite_Close_Btn_Css = getProperty("members_invite_close_btn_css");
    
    public static final String Project_Group_Top_Node_View_Report_Xpath = Utilities.utf8Char(getProperty("project_group_top_node_view_report_xpath"));
    
    public static final String Group_Metrics_Comparison_Link_Link = Utilities.utf8Char(getProperty("group_metrics_comparison_link_link"));
    
    public static final String Group_Metrics_Comparison_Repo_Comparison_Tab_Xpath = Utilities.utf8Char(getProperty("group_metrics_comparison_repo_comparison_tab_xpath"));
    
    public static final String Group_Metrics_Comparison_Project_Group_Comparison_Tab_Xpath = Utilities.utf8Char(getProperty("group_metrics_comparison_project_group_comparison_tab_xpath"));
    
    public static final String Group_Metrics_Comparison_Start_Date_Css = getProperty("group_metrics_comparison_start_date_css");
    
    public static final String Group_Metrics_Comparison_Time_Question_Mark_Xpath = getProperty("group_metrics_comparison_time_question_mark_xpath");
    
    public static final String Group_Metrics_Comparison_Tooltip_Css = getProperty("group_metrics_comparison_tooltip_css");
    
    public static final String Group_Metrics_Comparison_Table_Xpath = getProperty("group_metrics_comparison_table_xpath");
    
    public static final String Group_Metrics_Comparison_Two_Col_Contents_Css = getProperty("group_metrics_comparison_two_col_contents_css");
    
    public static final String Group_Metrics_Comparison_Close_First_Tab_Css = getProperty("group_metrics_comparison_close_first_tab_css");
    
    public static final String Group_Metrics_Comparison_Close_Second_Tab_Css = getProperty("group_metrics_comparison_close_second_tab_css");
    
    public static final String Group_Metrics_Comparison_Export_Data_Btn_Xpath = Utilities.utf8Char(getProperty("group_metrics_comparison_export_data_btn_xpath"));
    
    public static final String Group_Metrics_Comparison_Export_Data_Error_Msg_Xpath = getProperty("group_metrics_comparison_export_data_error_msg_xpath");
    
    public static final String industry_metrics_link_link = Utilities.utf8Char(getProperty("industry_metrics_link_link"));
    
    public static final String industry_metrics_efficiency_tab_xpath = Utilities.utf8Char(getProperty("industry_metrics_efficiency_tab_xpath"));
    
    public static final String industry_metrics_quality_tab_xpath = Utilities.utf8Char(getProperty("industry_metrics_quality_tab_xpath"));
    
    public static final String industry_metrics_efficiency_start_date_input_css = getProperty("industry_metrics_efficiency_start_date_input_css");
    
    public static final String industry_metrics_repo_info_repo_name_xpath = getProperty("industry_metrics_repo_info_repo_name_xpath");
    
    public static final String industry_metrics_repo_info_language_css = getProperty("industry_metrics_repo_info_language_css");
    
    public static final String industry_metrics_industry_info_repo_num_css = getProperty("industry_metrics_industry_info_repo_num_css");
    
    public static final String industry_metrics_industry_info_language_css = getProperty("industry_metrics_industry_info_language_css");
    
    public static final String industry_metrics_acc_dev_eq_chat_label_xpath = Utilities.utf8Char(getProperty("industry_metrics_acc_dev_eq_chat_label_xpath"));
    
    public static final String industry_metrics_acc_dev_equ_table_label_xpath = Utilities.utf8Char(getProperty("industry_metrics_acc_dev_equ_table_label_xpath"));
    
    public static final String industry_metrics_acc_dev_equ_table_rows_to_cols_xpath = Utilities.utf8Char(getProperty("industry_metrics_acc_dev_equ_table_rows_to_cols_xpath"));
    
    public static final String industry_metrics_acc_dev_equ_step_by_1_week = Utilities.utf8Char(getProperty("industry_metrics_acc_dev_equ_step_by_1_week"));
    
    public static final String industry_metrics_acc_dev_equ_recharts_css = getProperty("industry_metrics_acc_dev_equ_recharts_css");
    
    public static final String industry_metrics_tooltip_css = getProperty("industry_metrics_tooltip_css");
    
    public static final String efficiency_report_link_link = Utilities.utf8Char(getProperty("efficiency_report_link_link"));
    
    public static final String efficiency_report_data_range_selection_textbox_css = getProperty("efficiency_report_data_range_selection_textbox_css");
    
    public static final String efficiency_report_start_date_input_css = getProperty("efficiency_report_start_date_input_css");
    
    public static final String efficiency_report_acc_dev_eq_chart_label_xpath = Utilities.utf8Char(getProperty("efficiency_report_acc_dev_eq_chart_label_xpath"));
    
    public static final String efficiency_report_acc_dev_eq_table_label_xpath = Utilities.utf8Char(getProperty("efficiency_report_acc_dev_eq_table_label_xpath"));
    
    public static final String efficiency_report_acc_dev_eq_table_row_to_col_xpath = Utilities.utf8Char(getProperty("efficiency_report_acc_dev_eq_table_row_to_col_xpath"));
    
    public static final String efficiency_report_acc_dev_eq_table_header_contributor_xpath = getProperty("efficiency_report_acc_dev_eq_table_header_contributor_xpath");
    
    public static final String efficiency_report_acc_dev_eq_table_header_date_xpath = getProperty("efficiency_report_acc_dev_eq_table_header_date_xpath");
    
    public static final String efficiency_report_cells_xpath = getProperty("efficiency_report_cells_xpath");
    
    public static final String efficiency_report_tooltip_css = getProperty("efficiency_report_tooltip_css");
    
    public static final String efficiency_report_new_dev_eq_trend_question_mark_xpath = getProperty("efficiency_report_new_dev_eq_trend_question_mark_xpath");
    
    public static final String efficiency_report_new_dev_eq_trend_outlier_xpath = Utilities.utf8Char(getProperty("efficiency_report_new_dev_eq_trend_outlier_xpath"));
    
    public static final String efficiency_report_new_dev_eq_chart_label_xpath = Utilities.utf8Char(getProperty("efficiency_report_new_dev_eq_chart_label_xpath"));
    
    public static final String efficiency_report_new_dev_eq_table_label_xpath = Utilities.utf8Char(getProperty("efficiency_report_new_dev_eq_table_label_xpath"));
    
    public static final String efficiency_report_new_dev_eq_table_row_to_col_xpath = Utilities.utf8Char(getProperty("efficiency_report_new_dev_eq_table_row_to_col_xpath"));
    
    public static final String efficiency_report_new_dev_eq_table_header_contributor_xpath = getProperty("efficiency_report_new_dev_eq_table_header_contributor_xpath");
    
    public static final String efficiency_report_new_dev_eq_table_header_date_xpath = getProperty("efficiency_report_new_dev_eq_table_header_date_xpath");
    
    public static final String efficiency_report_dev_eq_per_rank_chart_label_xpath = Utilities.utf8Char(getProperty("efficiency_report_dev_eq_per_rank_chart_label_xpath"));
    
    public static final String efficiency_report_dev_eq_per_rank_table_label_xpath = Utilities.utf8Char(getProperty("efficiency_report_dev_eq_per_rank_table_label_xpath"));
    
    public static final String efficiency_report_dev_eq_per_rank_table_row_to_col_xpath = Utilities.utf8Char(getProperty("efficiency_report_dev_eq_per_rank_table_row_to_col_xpath"));
    
    public static final String efficiency_report_dev_eq_per_rank_table_header_contributor_xpath = getProperty("efficiency_report_dev_eq_per_rank_table_header_contributor_xpath");
    
    public static final String efficiency_report_dev_eq_per_rank_table_header_date_xpath = getProperty("efficiency_report_dev_eq_per_rank_table_header_date_xpath");
    
    public static final String efficiency_report_dev_eq_ratio_chart_label_xpath = Utilities.utf8Char(getProperty("efficiency_report_dev_eq_ratio_chart_label_xpath"));
    
    public static final String efficiency_report_dev_eq_ratio_table_label_xpath = Utilities.utf8Char(getProperty("efficiency_report_dev_eq_ratio_table_label_xpath"));
    
    public static final String efficiency_report_dev_eq_ratio_table_row_to_col_xpath = Utilities.utf8Char(getProperty("efficiency_report_dev_eq_ratio_table_row_to_col_xpath"));
    
    public static final String efficiency_report_dev_eq_ratio_table_header_contributor_xpath = getProperty("efficiency_report_dev_eq_ratio_table_header_contributor_xpath");
    
    public static final String efficiency_report_dev_eq_ratio_table_header_dev_eq_xpath = getProperty("efficiency_report_dev_eq_ratio_table_header_dev_eq_xpath");
    
    public static final String efficiency_report_efficiency_boxplot_chart_label_xpath = Utilities.utf8Char(getProperty("efficiency_report_efficiency_boxplot_chart_label_xpath"));
    
    public static final String efficiency_report_efficiency_boxplot_table_label_xpath = Utilities.utf8Char(getProperty("efficiency_report_efficiency_boxplot_table_label_xpath"));
    
    public static final String efficiency_report_efficiency_boxplot_table_row_to_col_xpath = Utilities.utf8Char(getProperty("efficiency_report_efficiency_boxplot_table_row_to_col_xpath"));
    
    public static final String efficiency_report_efficiency_boxplot_table_header_contributor_xpath = getProperty("efficiency_report_efficiency_boxplot_table_header_contributor_xpath");
    
    public static final String efficiency_report_efficiency_boxplot_table_header_date_xpath = getProperty("efficiency_report_efficiency_boxplot_table_header_date_xpath");
    
    public static final String efficiency_report_dev_eq_pareto_chart_label_xpath = Utilities.utf8Char(getProperty("efficiency_report_dev_eq_pareto_chart_label_xpath"));
    
    public static final String efficiency_report_dev_eq_pareto_table_label_xpath = Utilities.utf8Char(getProperty("efficiency_report_dev_eq_pareto_table_label_xpath"));
    
    public static final String efficiency_report_dev_eq_pareto_table_row_to_col_xpath = Utilities.utf8Char(getProperty("efficiency_report_dev_eq_pareto_table_row_to_col_xpath"));
    
    public static final String efficiency_report_dev_eq_pareto_table_header_contributor_xpath = getProperty("efficiency_report_dev_eq_pareto_table_header_contributor_xpath");
    
    public static final String efficiency_report_dev_eq_pareto_table_header_dev_eq_xpath = getProperty("efficiency_report_dev_eq_pareto_table_header_dev_eq_xpath");
    
    public static final String efficiency_report_acc_dev_eq_recharts_css = getProperty("efficiency_report_acc_dev_eq_recharts_css");
    
    public static final String efficiency_report_new_dev_eq_trend_recharts_css = getProperty("efficiency_report_new_dev_eq_trend_recharts_css");
    
    public static final String efficiency_report_dev_eq_per_rank_recharts_css = getProperty("efficiency_report_dev_eq_per_rank_recharts_css");
    
    public static final String efficiency_report_dev_eq_ratio_canvas_xpath = getProperty("efficiency_report_dev_eq_ratio_canvas_xpath");
    
    public static final String efficiency_report_effi_boxplot_canvas_xpath = getProperty("efficiency_report_effi_boxplot_canvas_xpath");
    
    public static final String efficiency_report_dev_eq_pareto_recharts_css = getProperty("efficiency_report_dev_eq_pareto_recharts_css");
    
    public static final String group_efficiency_report_acc_dev_eq_chart_label_xpath = Utilities.utf8Char(getProperty("group_efficiency_report_acc_dev_eq_chart_label_xpath"));
    
    public static final String group_efficiency_report_acc_dev_eq_table_label_xpath = Utilities.utf8Char(getProperty("group_efficiency_report_acc_dev_eq_table_label_xpath"));
    
    public static final String group_efficiency_report_acc_dev_eq_table_row_to_col_xpath = Utilities.utf8Char(getProperty("group_efficiency_report_acc_dev_eq_table_row_to_col_xpath"));
    
    public static final String group_efficiency_report_acc_dev_eq_table_header_project_group_xpath = getProperty("group_efficiency_report_acc_dev_eq_table_header_project_group_xpath");
    
    public static final String group_efficiency_report_acc_dev_eq_table_header_date_xpath = getProperty("group_efficiency_report_acc_dev_eq_table_header_date_xpath");
    
    public static final String group_efficiency_report_new_dev_eq_trend_question_mark_xpath = getProperty("group_efficiency_report_new_dev_eq_trend_question_mark_xpath");
    
    public static final String group_efficiency_report_new_dev_eq_trend_outlier_xpath = Utilities.utf8Char(getProperty("group_efficiency_report_new_dev_eq_trend_outlier_xpath"));
    
    public static final String group_efficiency_report_new_dev_eq_chart_label_xpath = Utilities.utf8Char(getProperty("group_efficiency_report_new_dev_eq_chart_label_xpath"));
    
    public static final String group_efficiency_report_new_dev_eq_table_label_xpath = Utilities.utf8Char(getProperty("group_efficiency_report_new_dev_eq_table_label_xpath"));
    
    public static final String group_efficiency_report_new_dev_eq_table_row_to_col_xpath = Utilities.utf8Char(getProperty("group_efficiency_report_new_dev_eq_table_row_to_col_xpath"));
    
    public static final String group_efficiency_report_new_dev_eq_table_header_project_group_xpath = getProperty("group_efficiency_report_new_dev_eq_table_header_project_group_xpath");
    
    public static final String group_efficiency_report_new_dev_eq_table_header_date_xpath = getProperty("group_efficiency_report_new_dev_eq_table_header_date_xpath");
    
    public static final String group_efficiency_report_dev_eq_per_capita_trend_question_mark_xpath = getProperty("group_efficiency_report_dev_eq_per_capita_trend_question_mark_xpath");
    
    public static final String group_efficiency_report_dev_eq_per_capita_trend_outlier_xpath = Utilities.utf8Char(getProperty("group_efficiency_report_dev_eq_per_capita_trend_outlier_xpath"));
    
    public static final String group_efficiency_report_dev_eq_per_capita_trend_chart_label_xpath = Utilities.utf8Char(getProperty("group_efficiency_report_dev_eq_per_capita_trend_chart_label_xpath"));
    
    public static final String group_efficiency_report_dev_eq_per_capita_trend_table_label_xpath = Utilities.utf8Char(getProperty("group_efficiency_report_dev_eq_per_capita_trend_table_label_xpath"));
    
    public static final String group_efficiency_report_dev_eq_per_capita_trend_table_row_to_col_xpath = Utilities.utf8Char(getProperty("group_efficiency_report_dev_eq_per_capita_trend_table_row_to_col_xpath"));
    
    public static final String group_efficiency_report_dev_eq_per_capita_trend_table_header_project_group_xpath = getProperty("group_efficiency_report_dev_eq_per_capita_trend_table_header_project_group_xpath");
    
    public static final String group_efficiency_report_dev_eq_per_capita_trend_table_header_date_xpath = getProperty("group_efficiency_report_dev_eq_per_capita_trend_table_header_date_xpath");
    
    public static final String group_efficiency_report_dev_eq_per_capita_trend_recharts_css = getProperty("group_efficiency_report_dev_eq_per_capita_trend_recharts_css");
    
    public static final String group_efficiency_report_dev_eq_per_rank_recharts_css = getProperty("group_efficiency_report_dev_eq_per_rank_recharts_css");
    
    public static final String group_efficiency_report_dev_eq_per_rank_chart_label_xpath = Utilities.utf8Char(getProperty("group_efficiency_report_dev_eq_per_rank_chart_label_xpath"));
    
    public static final String group_efficiency_report_dev_eq_per_rank_table_label_xpath = Utilities.utf8Char(getProperty("group_efficiency_report_dev_eq_per_rank_table_label_xpath"));
    
    public static final String group_efficiency_report_dev_eq_per_rank_table_row_to_col_xpath = Utilities.utf8Char(getProperty("group_efficiency_report_dev_eq_per_rank_table_row_to_col_xpath"));
    
    public static final String group_efficiency_report_dev_eq_per_rank_table_header_project_group_xpath = getProperty("group_efficiency_report_dev_eq_per_rank_table_header_project_group_xpath");
    
    public static final String group_efficiency_report_dev_eq_per_rank_table_header_dev_eq_xpath = getProperty("group_efficiency_report_dev_eq_per_rank_table_header_dev_eq_xpath");
    
    public static final String group_efficiency_report_dev_eq_ratio_recharts_xpath = getProperty("group_efficiency_report_dev_eq_ratio_recharts_xpath");
    
    public static final String group_efficiency_report_dev_eq_ratio_chart_label_xpath = Utilities.utf8Char(getProperty("group_efficiency_report_dev_eq_ratio_chart_label_xpath"));
    
    public static final String group_efficiency_report_dev_eq_ratio_table_label_xpath = Utilities.utf8Char(getProperty("group_efficiency_report_dev_eq_ratio_table_label_xpath"));
    
    public static final String group_efficiency_report_dev_eq_ratio_table_row_to_col_xpath = Utilities.utf8Char(getProperty("group_efficiency_report_dev_eq_ratio_table_row_to_col_xpath"));
    
    public static final String group_efficiency_report_dev_eq_ratio_table_header_contributor_xpath = getProperty("group_efficiency_report_dev_eq_ratio_table_header_contributor_xpath");
    
    public static final String group_efficiency_report_dev_eq_ratio_table_header_dev_eq_xpath = getProperty("group_efficiency_report_dev_eq_ratio_table_header_dev_eq_xpath");
    
    public static final String group_efficiency_report_efficiency_boxplot_chart_xpath = getProperty("group_efficiency_report_efficiency_boxplot_chart_xpath");
    
    public static final String group_efficiency_report_efficiency_boxplot_chart_label_xpath = Utilities.utf8Char(getProperty("group_efficiency_report_efficiency_boxplot_chart_label_xpath"));
    
    public static final String group_efficiency_report_efficiency_boxplot_table_label_xpath = Utilities.utf8Char(getProperty("group_efficiency_report_efficiency_boxplot_table_label_xpath"));
    
    public static final String group_efficiency_report_efficiency_boxplot_table_row_to_col_xpath = Utilities.utf8Char(getProperty("group_efficiency_report_efficiency_boxplot_table_row_to_col_xpath"));
    
    public static final String group_efficiency_report_efficiency_boxplot_table_header_contributor_xpath = getProperty("group_efficiency_report_efficiency_boxplot_table_header_contributor_xpath");
    
    public static final String group_efficiency_report_efficiency_boxplot_table_header_date_xpath = getProperty("group_efficiency_report_efficiency_boxplot_table_header_date_xpath");
}
