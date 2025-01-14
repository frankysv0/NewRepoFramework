package com.testRunnerPOC;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//java//com//featurePOC//HotelBooking.feature", glue = {
		"com.stepDefPOC" }, plugin = {"html:target/cucumber-reports.html", "json:target/report.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"json:target/cucumber.json"})
public class RunnerPOC {

	public static void main(String[] args) {

	}
}