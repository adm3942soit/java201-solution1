package accenture.trainings.spring.security;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Ignore;
import org.junit.runner.RunWith;

/**
 * Created by Oxana on 08.11.2015.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features="classpath:springXMLsecurity.feature",
        glue = {"accenture.trainings.spring.security"})
public class CucumberTest {
}
