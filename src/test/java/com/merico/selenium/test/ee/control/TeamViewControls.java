package com.merico.selenium.test.ee.control;

import java.io.InputStream;
import java.util.Properties;

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
}
