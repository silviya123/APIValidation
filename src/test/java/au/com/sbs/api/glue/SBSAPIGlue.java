package au.com.sbs.api.glue;

import au.com.sbs.api.steps.SBSAPISteps;
import au.com.sbs.api.utilities.Utilities;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SBSAPIGlue {

    @Steps
    SBSAPISteps sbiAPISteps;

    Response response;
    JsonPath jsonPathEvaluator;

    @Given("^the request for archiveAudio is send$")
    public void theRequestForArchiveAudioIsSend() {
        SerenityRest.given()
                .baseUri(Utilities.getBaseURL())
                .when().get("/language/greek/location/NSW/sublocation/Sydney/");
    }

    @When("^the response returns status code as (\\d+)$")
    public void theResponseReturnsStatusCodeAs(int status) {
        assertEquals(SerenityRest.then().extract().statusCode(), status);
    }

    @Then("^fetch all the mpThree audio files and validate the expected values are returned$")
    public void fetchAllTheAudioFilesAndValidateTheExpectedValuesAreReturned() {
        response = SerenityRest.then().extract().response();
        jsonPathEvaluator = response.jsonPath();
        List<String> mp3Audios = jsonPathEvaluator.getList("archiveAudio.mp3");
        for (String mp3 : mp3Audios) {
            System.out.println(mp3);
        }
        assertEquals(true, mp3Audios.size() == 8);
    }

    @And("^fetch the program and validate it is \"([^\"]*)\" for all the dates$")
    public void fetchTheProgramAndValidateItIsForAllTheDates(String programName) throws Throwable {
        List<String> programsFetched = jsonPathEvaluator.getList("program");
        boolean programFlag = sbiAPISteps.validateFetchedDetails(programName, programsFetched);
        assertEquals(true, programFlag);
    }

    @And("^fetch the channelName and validate it is \"([^\"]*)\"$")
    public void fetchTheChannelNameAndValidateItIs(String channel) {
        List<String> channelName = jsonPathEvaluator.getList("channelName");
        boolean channelFlag = sbiAPISteps.validateFetchedDetails(channel, channelName);
        assertEquals(true, channelFlag);
    }

    @And("^fetch the onDigitalRadio flag and verify it is \"([^\"]*)\"$")
    public void fetchTheOnDigitalRadioFlagAndVerifyItIs(String onDigitalFlag) {
        List<String> onDigitalRadio = jsonPathEvaluator.getList("onDigitalRadio");
        boolean digitalFlag = sbiAPISteps.validateFetchedDetails(onDigitalFlag, onDigitalRadio);
    }

    @And("^verify \"([^\"]*)\" is present for all the audioTracks$")
    public void verifyIsPresentForAllTheAudioTracks(String path) {
        boolean pathflag = true;
        List<String> pathList = jsonPathEvaluator.getList(path);
        assertEquals(false, pathList.contains(null));
    }

    @And("^verify the response time is less than (\\d+) seconds$")
    public void verifyTheResponseTimeIsLessThanSeconds(long seconds) {
        SerenityRest.then().time(Matchers.lessThan(seconds));
    }


}
