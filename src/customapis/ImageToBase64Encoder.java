package customapis;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.logging.Logger;

import com.provar.core.model.base.api.ValueScope;
import com.provar.core.testapi.ITestExecutionContext;
import com.provar.core.testapi.annotations.*;

@TestApi(title = "Image to Base64 Encoder",
        summary = "Encodes an image from a given URL to Base64 format",
        remarks = "",
        iconBase = "",
        defaultApiGroups = {"Custom"})
@TestApiParameterGroups(parameterGroups = {
        @TestApiParameterGroup(groupName = "inputs", title = "Inputs"),
        @TestApiParameterGroup(groupName = "result", title = "Result"),
})
public class ImageToBase64Encoder {

    @TestApiParameter(seq = 1,
            summary = "The URL of the image to encode.",
            remarks = "Provide a valid image URL.",
            mandatory = true,
            parameterGroup = "inputs")
    public String imageUrl;

    @TestApiParameter(seq = 10,
            summary = "The name that the result will be stored under.",
            remarks = "This is the output variable where the Base64 string will be stored.",
            mandatory = true,
            parameterGroup = "result")
    public String resultName;

    @TestApiParameter(seq = 11,
            summary = "The lifespan of the result.",
            remarks = "Defines the scope of the output variable.",
            mandatory = true,
            parameterGroup = "result",
            defaultValue = "Test")
    public ValueScope resultScope;

    /**
     * Used to write to the test execution log.
     */
    @TestLogger
    public Logger testLogger;

    /**
     * Provides access to facilities, mainly to set and get variable values.
     */
    @TestExecutionContext
    public ITestExecutionContext testExecutionContext;

    @TestApiExecutor
    public void execute() {
        try {
            // Log the input URL
            testLogger.info("Fetching image from URL: " + imageUrl);

            // Establish connection to the URL
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            // Check if the connection is successful
            if (connection.getResponseCode() != 200) {
                throw new Exception("Failed to fetch image. HTTP Response Code: " + connection.getResponseCode());
            }

            // Read image as input stream
            InputStream inputStream = connection.getInputStream();
            byte[] imageBytes = inputStream.readAllBytes();
            inputStream.close();

            // Encode image bytes to Base64
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            testLogger.info("Image successfully encoded to Base64.");

            // Store the result in the execution context
            testExecutionContext.setValue(resultName, base64Image, resultScope);
            testLogger.info("Base64 string stored under result name: " + resultName);

        } catch (Exception e) {
            testLogger.severe("Error occurred while encoding image to Base64: " + e.getMessage());
            throw new RuntimeException("Failed to encode image to Base64. Please check the provided URL and try again.", e);
        }
    }
}
