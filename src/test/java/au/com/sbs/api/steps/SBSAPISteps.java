package au.com.sbs.api.steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class SBSAPISteps extends ScenarioSteps {

    /**
     * validate the fields for each file, if they are all having the same value
     * @author  Smilu Thomas
     */

    @Step
    @Title("Validate the details fetched")
    public boolean validateFetchedDetails(String expectedData, List<String> fetchedData) {
        boolean validationFlag = true;
        for (String fetchedValue : fetchedData) {
            if (!(fetchedValue.contains(expectedData))) {
                validationFlag = false;
                break;
            }
        }
        return validationFlag;
    }


}
