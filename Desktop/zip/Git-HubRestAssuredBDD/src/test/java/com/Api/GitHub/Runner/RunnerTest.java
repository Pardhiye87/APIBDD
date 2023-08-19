package com.Api.GitHub.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
			features= {"com.Api.GitHub.FeatureFiles"},
			glue= {"com.Api.GitHub.Steps"},
			dryRun=false
		)
public class RunnerTest extends AbstractTestNGCucumberTests{

}
