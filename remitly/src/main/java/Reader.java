import org.json.*;

import java.io.FileReader;
import java.io.IOException;


public class Reader {
    public static boolean readJson(String filePath){
        try {
            //create Reader object to read json file
            FileReader reader = new FileReader(filePath);

            try {
                JSONObject jsonObject = new JSONObject(new JSONTokener(reader));

                //find JSONArray from Statement key
                JSONArray statementArray = jsonObject.getJSONObject("PolicyDocument").getJSONArray("Statement");

                //find first object JSONObject from array (index 0)
                JSONObject firstStatement = statementArray.getJSONObject(0);

                //find "Resource" key's value
                String resourceValue = firstStatement.getString("Resource");


                if (resourceValue.equals("*")) {
                    return false;
                } else {
                    return true;
                }
            } finally {
                reader.close();
            }
        }catch (IOException | JSONException e){
            e.printStackTrace();
            return true;
        }
    }

}
