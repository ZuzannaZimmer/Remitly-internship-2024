package com.remitly.rolechecker;

import com.remitly.rolechecker.RolePolicyChecker;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Test;

import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RolePolicyCheckerTest {

    String jsonString = "{\n" +
            "  \"PolicyName\": \"root\",\n" +
            "  \"PolicyDocument\": {\n" +
            "    \"Version\": \"2012-10-17\",\n" +
            "    \"Statement\": [\n" +
            "      {\n" +
            "        \"Sid\": \"IamListAccess\",\n" +
            "        \"Effect\": \"Allow\",\n" +
            "        \"Action\": [\n" +
            "          \"iam:ListRoles\",\n" +
            "          \"iam:ListUsers\"\n" +
            "        ],\n" +
            "        \"Resource\": \"*\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";




    @Test
    void isPolicyDocumentInJSONObject(){
        try {
            String filePath = "../remitly/src/main/resources/role_policy.json";
            FileReader reader = new FileReader(filePath);
            JSONObject jsonObject = new JSONObject(new JSONTokener(reader));

            RolePolicyChecker checker = new RolePolicyChecker(jsonObject);

            assertTrue(jsonObject.has("PolicyDocument"), "PolicyDocument should exist in the JSON file");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void isStatementArrayEmpty(){

        String filePath = "../remitly/src/main/resources/role_policy.json";
        FileReader reader = new FileReader(filePath);
        JSONObject jsonObject = new JSONObject(new JSONTokener(reader));

        RolePolicyChecker checker = new RolePolicyChecker(jsonObject);
        JSONArray statementArray = jsonObject.getJSONObject("PolicyDocument").getJSONArray("Statement");


    }

    }






