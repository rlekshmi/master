package com.mavenit.cucumberpracticenew;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources",
        dryRun = false,
        strict = false,
        plugin = {"json:target/cucumber.json"}

)

public class RunCukesTest {
}
