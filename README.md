# ETCJ_POM

This Framework is created using Page Object model and has 3 parts of implementation:

1)API automation using Rest Assured and TestNG framework
2)UI automation using selenium TestNG frameork 
3)Jenkins pipeline creation

I have created methods to randomly select the date and time from the API response and pass it over to to UI. Details of this can be seen in ETCJ_POM\src\test\java\encoretickets\tests\CheckOutTest.java => apiTest()

UI elements are automated based on the random date and time we get from API, But seat selection I have clicked on specific place using coordinates of HTML canvas.
To automate the seat selection based on the seat details from API response needs more time, as we need to find the exact location of each row and the radio buttons and then instruct to click on each element based on for loop and tooltip contents.

Page wise locators and methods are available in ETCJ_POM\src\main\java\encoretickets\pages

TestNG file location :ETCJ_POM/test-output/index.html
JenkinsFile location : ETCJ_POM\Jenkinsfile




