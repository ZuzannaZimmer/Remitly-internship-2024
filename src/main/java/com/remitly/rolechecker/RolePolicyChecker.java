package com.remitly.rolechecker;

import org.json.*;

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

}

