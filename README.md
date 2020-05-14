# This is the step by step document using selenium test framework

## **Preconditon** ##
1. JDK installed - JDK 1.8 preferred
2. Maven installed
3. Eclipse IDE installed
4. Add selenium-server-standalone-2.52.0.jar to maven local repository
      
     ```
     $ mvn install:install-file -Dfile=./lib/selenium-server-standalone-2.52.0.jar      -DgroupId=org.seleniumhq.selenium -DartifactId=selenium-server-standalone -Dversion=2.52.0 -Dpackaging=jar
     ```

## **How to install WebDriver** ##
1. Chrome - [Download address](https://sites.google.com/a/chromium.org/chromedriver/downloads)
      * Unzip *chromedriver_mac64.zip* file
      * Copy chromedriver file to /usr/local/bin
2. Safari - Open ./lib/SafariDriver.safariextz in Safari and install this extension to Safari
3. IE and Edge - Only required for Windows OS.
4. Phantomjs - Headless browser mode
      * [Install homebrew if you don't have it](http://brew.sh)
      * ```brew install phantomjs``` in the Mac OS
      * [Windows version download address](http://phantomjs.org/download.html)

## **How to create Maven project in Eclipse IDE** ##
1. Select File -> New -> Project...
2. Select Maven -> Maven Project
3. Input *Group Id* and *Artifact Id* and click *Finish* button

## **Update *pom.xml* in the project root directory as below** ##
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>Group Id</groupId>
  <artifactId>Artifact Id</artifactId>
  <version>Version Id</version>
  <packaging>jar</packaging>

  <name>tt</name>
  <url>http://maven.apache.org</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <springframework.version>4.1.5.RELEASE</springframework.version>
    <selenium.version>2.52.0</selenium.version>
  </properties>

  <dependencies>
    <dependency>
      <groupId>org.testng</groupId>
      <artifactId>testng</artifactId>
      <version>6.10</version>
      <scope>test</scope>
    </dependency>
	   
	<dependency>
      <groupId>com.meituan.qa</groupId>
      <artifactId>selenium-test-framework</artifactId>
      <version>1.0.0</version>
    </dependency>
  </dependencies>
  
  <build>
  	<plugins>
  		<plugin>
  			<groupId>org.apache.maven.plugins</groupId>
  			<artifactId>maven-compiler-plugin</artifactId>
  			<version>3.6.1</version>
  			<configuration>
  				<source>1.8</source>
  				<target>1.8</target>
  			</configuration>
  		</plugin>
  		
  		<plugin>
	        <groupId>org.apache.maven.plugins</groupId>
	        <artifactId>maven-surefire-plugin</artifactId>
	        <version>2.19.1</version>
	        <configuration>
	        		<suiteXmlFiles>
					<suiteXmlFile>testng.xml</suiteXmlFile>
				</suiteXmlFiles>
	        </configuration>
	        <executions>
	            <execution>
	                <phase>integration-test</phase>
	                <goals>
	                    <goal>test</goal>
	                </goals>
	                <configuration>
	                    <skip>false</skip>
	                </configuration>
	            </execution>
	        </executions>
       </plugin>
  	</plugins>
  </build>
</project>
```

## **Add *testng.xml* into the project root directory so that we can run tests with TestNG** ##
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Suite" parallel="false" thread-count="1">
  <!-- In order to improve the test efficiency, there is no listener when test execution on the server -->
  <listeners>
      <listener class-name="com.meituan.selenium.listener.LogSeperateTestListener"></listener>
  	<listener class-name="com.meituan.selenium.listener.ErrorSpecScreenshotListener"></listener>
  	<listener class-name="com.meituan.selenium.autoscreenshot.AutoScreenshotListener"></listener>
    </listeners>
  
  <test name="Create_TT_Test" preserve-order="true">
  	<groups>
  		<run>
  			<include name="BVT"></include>
  			<include name="ACCEPTANCE"></include>
  			<include name="COMPREHENSIVE"></include>
  			<exclude name="CURRENT_DEBUG"></exclude>
  			<exclude name="DEPRECATED"></exclude>
  		</run>
  	</groups>
      <classes>
      		<class name="com.meituan.selenium.test.tt.test.CreateTTPageTest" />
      </classes>
    </test>
</suite>
```
## **How to create *Source Folder* in the Eclipse** ##
1. Right click project name in the Package Explorer
2. Select *New -> Source Folder*
3. Input *Folder Name* as *src/main/java* and click *Finish* button
4. Repeat step 1,2,3 and create another three source folder - *src/test/java*, *src/main/resources* and *src/test/resources*

## **How to create *Package* in the Source Folder** ##
1. Right click *Source Folder* name in the Package Explorer
2. Select New -> Package
3. Input name as *com.tropo.selenium.test.portal.us.control* and click *Finish* button
4. Repeat step 1,2,3 and create another three package -  *com.tropo.selenium.test.portal.us.page*, *com.tropo.selenium.test.portal.us.test* and *com.tropo.selenium.test.portal.us.utils*

## **How to create *Class* in the Package** ##
1. Right click *Package* name in the Package Explorer
2. Select New -> Class
3. Input class name in the *name* textbox and click *Finish* button

## **How to config the tests as the parallel tests in the testng.xml** ##
1. Update suite tag in testng.xml file as below
```
<suite name="Suite" parallel="classes" thread-count="xx">
```

## **How to config tests using specific browser and execute remote tests in the *selenium-vars.properties* file** ##
1. Update webdriver.type or webdriver.isremote or webdriver.remote.host to specific value
```
#WebDriver type，InternetExplorerDriver，FirefoxDriver，ChromeDriver，SafariDriver，EdgeDriver，PhantomJSDriver
webdriver.type=ChromeDriver

#Whether to use RemoteWebDriver way to perform the test with the remote Server interaction
webdriver.isremote=false
#The address of the remote server, such as http://x.x.x.x
webdriver.remote.host=http://10.140.253.30
#The remote server port
webdriver.remote.port=4444
``` 

## **How to run the test suite** ##
1. Make sure change directory into the project root directory which includes pom.xml file
2. Run the command as below
```
mvn clean test
```