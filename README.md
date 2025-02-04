# Agumon Test Automation Project #

This is a selenium test automation project for Sauce Demo E-commerce Project. It currently based on selenium framework, cucumber as BDD, and we use maven as project build tool.

## You can run the project by three different ways ##

1. Run specific scenario file or a folder in src/test/resources/features/

2. Run CucumberRunner in src/test/java/com/agumon/uat/runner/

3. Run agumon-testng.xml to run multiple runner at once

3. Go to project folder in terminal, and Run mvn clean verify


#### Make sure that you run checkstyle and fix if it has any suggestion

mvn checkstyle:check