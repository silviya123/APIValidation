package au.com.sbs.api.utilities;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class Utilities {
    /**
     * getBaseURL static method which return the test base url
     * @author  Smilu Thomas
     */
    public static String getBaseURL() {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        return variables.getProperty("endpoint.url");
    }

}
