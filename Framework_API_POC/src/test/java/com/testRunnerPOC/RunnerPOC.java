package com.testRunnerPOC;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//java//com//featurePOC//HotelBooking.feature", glue = {
		"com.stepDefPOC" }, plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:target/cucumber-reports.html", "json:target/cucumber-reports/Cucumber.json" })
public class RunnerPOC {

	public static void main(String[] args) {

	}
}
