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
}
