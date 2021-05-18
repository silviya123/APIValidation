# APIValidation

Execute the test run below command: 

> gradlew clean test aggregate // runs all the runner class, and generate the report
(or)
> gradlew clean test --tests ApiTestRunner aggregate // runs only the specified runner class


aggregate command will generate the serenity html report(index.html) under: target/site/serenity

CI/CD execution:

1- Connect to github from jenkins, have HTML Publisher plugin installed
2- Add the batch command: gradlew clean test aggregate 
3- Post build access- Publish HTML reports, add HTML directory- target/site/serenity
and index page as: index.html
