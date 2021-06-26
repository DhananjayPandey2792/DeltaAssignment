package testrunner;

import java.io.File;

import org.junit.AfterClass;

import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import commonLib.ObjectDeclaration;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = false, monochrome = true, strict = true, features = "src/test/java/features", glue = "stepdefinition", plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, tags = {
				"@testAPI" })

public class TestRunner extends ObjectDeclaration {
	

	
	}


