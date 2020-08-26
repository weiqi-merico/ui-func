package com.merico.selenium.test.ee.control;

import java.io.InputStream;
import java.util.Properties;

import com.merico.selenium.test.ee.utils.Utilities;

public class SettingsControls {
	private static Properties props = null;
    static {
        try {
            props = new Properties();
            InputStream in = ProjectGroupControls.class.getClassLoader().getResourceAsStream("settings-control.properties");
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

    private SettingsControls() {
        // TODO Auto-generated constructor stub
    }
    
    public static final String settings_link_xpath = getProperty("settings_link_xpath");
    
    public static final String metrics_comparison_link_link = Utilities.utf8Char(getProperty("metrics_comparison_link_link"));
    
    public static final String department_comparison_tab_xpath = Utilities.utf8Char(getProperty("department_comparison_tab_xpath"));
    
    public static final String member_comparison_tab_xpath = Utilities.utf8Char(getProperty("member_comparison_tab_xpath"));
    
    public static final String number_of_dev_question_mark_xpath = getProperty("number_of_dev_question_mark_xpath");
    
    public static final String number_of_dev_tooltip_css = getProperty("number_of_dev_tooltip_css");
}
