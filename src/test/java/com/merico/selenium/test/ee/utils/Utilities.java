package com.merico.selenium.test.ee.utils;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.base.Function;
import com.merico.selenium.page.PageUrlMapping;
import com.merico.selenium.support.ActionWait;
import com.merico.selenium.test.ee.page.LoginPage;


public class Utilities {
	/**
	 * 字符串格式转换
	 * @param iso8859Str
	 * @return UTF-8 String
	 */
	public static String utf8Char(String iso8859Str){
		String utf8Str = null;
		try {
			utf8Str = new String(iso8859Str.getBytes("ISO8859-1"),"UTF-8");
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return utf8Str;
	}

	/**
	 * Generate random string function
	 * @param length - The length of generated string  
	 * @return Random string
	 */
	public static String getRandomString(int length) { 
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";     
	    Random random = new Random();     
	    StringBuilder sb = new StringBuilder();     
	    for (int i = 0; i < length; i++) {     
	        int number = random.nextInt(base.length());     
	        sb.append(base.charAt(number));     
	    }     
	    return sb.toString();     
	 }     
	
	/**
	 * Switch to the new window with specified title 
	 * @param driver
	 * @param windowTitle
	 * @return return boolean. If true, switch successfully; false, switch failed
	 */
	public static boolean switchToWindow(WebDriver driver,String windowTitle){  
	    boolean flag = false;  
	    try {  
	        String currentHandle = driver.getWindowHandle();  
	        Set<String> handles = driver.getWindowHandles();  
	        for (String s : handles) {  
	            if (s.equals(currentHandle))  
	                continue;  
	            else {  
	                driver.switchTo().window(s);  
	                if (driver.getTitle().contains(windowTitle)) {  
	                    flag = true;  
	                    break;  
	                } 
	                else  
	                    continue;  
	            }  
	        }  
	    } 
	    catch (NoSuchWindowException e) { 
	        flag = false;  
	    }  
	    return flag;  
	}  
	
	/**
	 * To maximize the browser window
	 * @param driver
	 */
	public static void newBrowserWindow(WebDriver driver){
		String currentHandle = driver.getWindowHandle();  
		for(String winHandle : driver.getWindowHandles()){   
			if (winHandle.equals(currentHandle))  
                continue;  
            else {  
            	driver.switchTo().window(winHandle);     
            	driver.manage().window().maximize();
            }
        }     
	}
	
	/**
	 * Generate the day of date format string with "YYYY-MM-dd"
	 * @return the day of date format string(yyyy-MM-dd)
	 */
	public static String generateDateFormatStr(){
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		return date;
	}
	
	/**
	 * Generate Date Format String
	 * @param intervalDay Interval the number of days (Please input zero for current day)
	 * @return Date Format String (yyyy-MM-dd)
	 */
	public static String randomDateFormatStr(int intervalDay){
		Calendar strDate = Calendar.getInstance();  
	    strDate.add(Calendar.DATE, intervalDay);  
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	    return sdf.format(strDate.getTime());  
	}
	
	/**
	 * Generate Date and Time Format String
	 * @param intervalDay Interval the number of days (Please input zero for current day)
	 * @return Date and Time Format String (yyyy-MM-dd HH:mm:ss)
	 */
	public static String generateDateAndTimeFormatStr(int intervalDay){
		Calendar strDate = Calendar.getInstance();  
	    strDate.add(Calendar.DATE, intervalDay);  
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    return sdf.format(strDate.getTime());  
	}
	
	/**
	 * Process a single none JavaScript Alert pop-up
	 * @param driver
	 * @return Whether handle for pop-up Windows
	 */
	public static boolean nonJSWindow(WebDriver driver){
	    try{
	        // Location of the window
	        driver.switchTo().window(driver.getWindowHandles().iterator().next());
	        return true;
	    }catch(Exception e){
	        System.out.println(e.getMessage());
	        return false;
	    }
	}
	
	/**
	 * Waiting for the control elements
	 * @param driver
	 * @param by
	 */
	public static void waitForControlPresent(WebDriver driver, final By by) {
		ActionWait<WebDriver> waiter = new ActionWait<WebDriver>(driver);
		waiter.until(new Function<WebDriver, Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return driver.findElement(by).isDisplayed();
			}
		});
	}
	
	/**
	 * Static time delay
	 * @param millis MS
	 */
	public static void staticTimeDelay(long millis){
		try{
			Thread.sleep(millis);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Close the current TAB page
	 * @param driver
	 * @param pageTitle After closing the current page, to locate the page title attribute values
	 */
	public static void closeTab(WebDriver driver,String pageTitle) {
		String js = "window.close();";
		((JavascriptExecutor) driver).executeScript(js);
		Utilities.switchToWindow(driver, pageTitle);
	}
	
	/**
	 * Moving the scroll bar to the up
	 * @param driver
	 */
	public static void movePageToTop(WebDriver driver) {
		String js = "window.scrollBy(0,-2000)";
		((JavascriptExecutor) driver).executeScript(js, "");
		staticTimeDelay(2000);
	}
	
	/**
	 * Moving the scroll bar to the up
	 * @param driver
	 */
	public static void movePageToLocation(WebDriver driver, String y) {
		String js = "window.scrollBy(0, " + y + ")";
		((JavascriptExecutor) driver).executeScript(js, "");
		staticTimeDelay(2000);
	}
	
	/**
	 * Moving the scroll bar to the bottom
	 * @param driver
	 */
	public static void movePageToBottom(WebDriver driver) {
		String js = "document.body.scrollTop = document.body.scrollHeight;";
		((JavascriptExecutor) driver).executeScript(js);
		staticTimeDelay(1000);
	}
	
	/**
	 * Moving the scroll bar to the element
	 * @param driver
	 */
	public static void movePageToElement(WebDriver driver, final By by) {
		WebElement element  = driver.findElement(by);
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(false);",element);
	}
	
	/**
	 * Get domain name for Web URL
	 * @return Domain Name
	 */
	public static String getDomainName() {
		String targetUrl = PageUrlMapping.getAbsoluteUrl(LoginPage.class);
		Pattern p = Pattern.compile("(?<=http://|\\.)[^.]*?\\.(com|eu|net)",Pattern.CASE_INSENSITIVE);
		Matcher matcher = p.matcher(targetUrl);
		matcher.find();
		String domainName = matcher.group().trim();
		
		return domainName;
	}
}
