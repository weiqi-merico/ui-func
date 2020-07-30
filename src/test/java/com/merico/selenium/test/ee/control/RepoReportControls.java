package com.merico.selenium.test.ee.control;

import java.io.InputStream;
import java.util.Properties;

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
    public static final String codebase_dryness_label_xpath = getProperty("codebase_dryness_label_xpath");
    
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
}
