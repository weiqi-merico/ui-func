package com.merico.selenium.test.ee.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.merico.selenium.autoscreenshot.AutoIntercept;
import com.merico.selenium.page.Page;
import com.merico.selenium.test.ee.control.TeamViewControls;
import com.merico.selenium.test.ee.utils.Utilities;

public class TeamViewPage extends Page {
	public TeamViewPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isLoaded() {
        // No Ajax content, which can be considered to create the Page object has finished loading.
        return true;
    }
    
    private void navigateToTeams() {
    	Utilities.waitForControlPresent(driver, By.xpath(TeamViewControls.Teams_Link_Xpath));
    	driver.findElement(By.xpath(TeamViewControls.Teams_Link_Xpath)).click();
    	Utilities.staticTimeDelay(4000);
    }
    
    @AutoIntercept
    public void searchDeveloper() {
    	this.navigateToTeams();
    	
    	Utilities.waitForControlPresent(driver, By.cssSelector(TeamViewControls.Search_Teams_Member_Textbox_Css));
    	driver.findElement(By.cssSelector(TeamViewControls.Search_Teams_Member_Textbox_Css)).clear();
    	driver.findElement(By.cssSelector(TeamViewControls.Search_Teams_Member_Textbox_Css)).sendKeys("meric");
    	Utilities.staticTimeDelay(3000);
    }
    
    @AutoIntercept
    public String getSearchCssStatus() {
    	Utilities.waitForControlPresent(driver, By.xpath(TeamViewControls.Team_Css_Search_Status_Xpath));
    	String rgb = driver.findElement(By.xpath(TeamViewControls.Team_Css_Search_Status_Xpath)).getCssValue("background-color").trim();
    	System.out.println(rgb);
    	
    	return rgb;
    }
}
