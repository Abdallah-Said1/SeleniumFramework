package runner;

import io.cucumber.testng.CucumberOptions;
import testes.TestBase;

@CucumberOptions(features = "E://automation testing//Fproject//automationtestproject//src//test//java//features",
glue={"steps"},
plugin={"pretty","html:target/cucumber-html-report"})

 public class TestRunner extends TestBase{


}
