package com.remitly.rolechecker;

import org.json.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RolePolicyChecker {

    private final JSONObject jsonObject;

    public RolePolicyChecker(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public boolean isValid(String filePath){

            try {
                JSONArray statementArray = jsonObject.getJSONObject("PolicyDocument").getJSONArray("Statement");
                JSONObject firstStatement = statementArray.getJSONObject(0);
                String resourceValue = firstStatement.getString("Resource");

                return !resourceValue.equals("*");

                } catch (JSONException e){
                    e.printStackTrace();
                    return true;
                }
    }

    public boolean isJsonFile(String filePath) {

            if (!filePath.endsWith(".json")) {
                return false;
            }
            try {
                String content = new String(Files.readAllBytes(Paths.get(filePath)));
                new JSONObject(content);
                return true;

            } catch (IOException | JSONException e) {
                return false;
            }
    }
    }


