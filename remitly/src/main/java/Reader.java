import org.json.*;

import java.io.FileReader;
import java.io.IOException;


public class Reader {
    public static boolean readJson(String filePath){

        try {

            try (FileReader reader = new FileReader(filePath)) {

                JSONObject jsonObject = new JSONObject(new JSONTokener(reader));
                JSONArray statementArray = jsonObject.getJSONObject("PolicyDocument").getJSONArray("Statement");
                JSONObject firstStatement = statementArray.getJSONObject(0);
                String resourceValue = firstStatement.getString("Resource");

                return !resourceValue.equals("*");
            }
        } catch (IOException | JSONException e){
            e.printStackTrace();

            return true;
        }
    }

}
