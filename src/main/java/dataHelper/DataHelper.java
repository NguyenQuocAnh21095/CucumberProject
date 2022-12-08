package dataHelper;

import io.restassured.path.json.JsonPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataHelper {
    private static Integer randomStringLength = 1;


    public String getLocatorsData(String pathInJson) throws IOException {
        String dataPayload = new String(Files.readAllBytes(Paths.get("src/main/resources/locators.json")));
        String value = JsonPath.with(dataPayload).get(pathInJson);
        if (value == null) {
            throw new RuntimeException("Couldn't find field and value in locators.json for input " + pathInJson + "Please refer exact path of your web element from locators.json. The standard format should be (pageName.webElement) e.g loginPage.password");
        } else {
            return value;
        }
    }
}