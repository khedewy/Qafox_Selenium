package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CheckOutData {
    public String firstName, lastName,company,addressOne,addressTow,city,postCode, country,region;

    public void testData() throws IOException, ParseException {
        String srcFile = System.getProperty("user.dir") + "/src/test/java/data/checkoutData.json";
        File file = new File(srcFile);

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(file));

        for (Object object : jsonArray) {
            JSONObject person = (JSONObject) object;

            firstName = (String) person.get("firstName");
            lastName = (String) person.get("lastName");
            company = (String) person.get("company");
            addressOne = (String) person.get("addressOne");
            addressTow = (String) person.get("addressTow");
            city = (String) person.get("city");
            postCode = (String) person.get("postCode");
            country = (String) person.get("country");
            region = (String) person.get("region");
        }
    }
}
