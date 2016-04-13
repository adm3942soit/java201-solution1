package accenture.trainings.spring.security;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.HttpMethod;

/**
 * Created by Oxana on 08.11.2015.
 */
public class MyStepdefs extends AbstractSteps{


    @When("^I performs operation \"([^\"]*)\"$")
    public void iPerformsOperation(String httpMethod) throws Throwable {
        HttpMethod m = HttpMethod.valueOf(httpMethod.toUpperCase());
        String finalUrl = getFinalUrl();
        serverResponse = doHttpMethod(m, finalUrl);

    }

    @Then("^I see \"([^\"]*)\" in response$")
    public void iSeeInResponse(String arg0) throws Throwable {
        String resp = serverResponse.getBody();
        System.out.println("resp = " + resp);
        assert(resp.contains(arg0));// Write code here that turns the phrase above into concrete actions

    }

    @And("^Password is \"([^\"]*)\"$")
    public void passwordIs(String arg0) throws Throwable {
        //params.add("password", arg0);
    }

    @And("^User name is \"([^\"]*)\"$")
    public void userNameIs(String arg0) throws Throwable {
       // params.add("username", arg0);
    }

    @Given("^I am on the start page$")
    public void iAmOnTheStartPage() throws Throwable {
        params.clear();
        url="http://localhost:"+port+"/";//admin
    }
}
