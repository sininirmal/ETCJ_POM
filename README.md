# ETCJ_POM

Prerequisites:
1) Jdk 
2) Maven ( I have used Eclipse to create Java Maven project)
3) TestNG plugIN 
4) Maven dependencies TestNG, Selenium, Rest Assured etc -> already added in pom.xml 


Implementation:
This Framework is designed using Page Object model and has 3 parts of implementation:
1) API automation using Rest Assured and TestNG framework
2) UI automation using selenium TestNG framework 
3) Jenkins pipeline creation


Test Location:ETCJ_POM\src\test\java\encoretickets\tests\CheckOutTest.java   ==> Run it as TestNG test
TestNG report location :ETCJ_POM/test-output/index.html JenkinsFile location : ETCJ_POM\Jenkinsfile

I have created methods to randomly select the date and time from the API response and pass it over to the UI. Details of this can be seen in ETCJ_POM\src\test\java\encoretickets\tests\CheckOutTest.java => apiTest()
UI elements are automated based on the random date and time we get from API, But seat selection I have clicked on specific coordinates using Dimension to get the HTML canvas/visible area length. Page wise locators and methods are available in ETCJ_POM\src\main\java\encoretickets\pages.
To automate the seat selection based on the seat details from API response needs more time, as we need to find the exact location of each row and the radio buttons and then instruct to click on each element based on for loop and tooltip contents.

I hope this can be done in 2 ways:
Method 1:
1) Get the seat details from API response and pass it over to the UI test method.
2) Get the coordinates of HTML canvas for each Circle , Row and seat number
3) Click on the seat coordinate based on the seat response from API
Method 2:
1) Get the seat details from API response and pass it over to the UI test method.
2) Select the circle location based on API response3) Loop the coordinates through the circle till the Tooltip contents are matched with the seat details received from API response

Improvements:
1) Reusable methods needs to moved to a common folder to access through different pages/tests
2) TestNg and surefire reports are created as part of this report. We can think of better detailed report as part of improvement to this framework





