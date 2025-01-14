package com.testRunnerPOC;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C://Users//fselvakumar//New Eclipse 2024//Framework_API_POC//src//test//java//com//featurePOC//HotelBooking.feature", glue = {
		"com.stepDefPOC" }, plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"json:target/cucumber.json","html:target/cucumber-reports.html" })
public class RunnerPOC {

	public static void main(String[] args) {

	}
}
