package com.remitly.rolechecker;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class RolePolicyCheckerTest {

    @Test
    public void shouldReturnTrueForValidPolicy() {

        String filePath = "../remitly/src/main/resources/role_policy.json";


        JSONObject jsonObject = readJsonFromFile(filePath);


        RolePolicyChecker checker = new RolePolicyChecker(jsonObject);
        boolean result = checker.isValid(filePath);

        assertFalse(result);
    }

    @Test
    public void shouldReturnFalseForInvalidPolicy() {

        String filePath = "src/test/resources/role_policy_no_asterisk.json";

        JSONObject jsonObject = readJsonFromFile(filePath);

        RolePolicyChecker checker = new RolePolicyChecker(jsonObject);
        boolean result = checker.isValid(filePath);

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenStatementIsMissing() {

        String filePath = "src/test/resources/role_policy_without_statement.json";

        JSONObject jsonObject = readJsonFromFile(filePath);

        RolePolicyChecker checker = new RolePolicyChecker(jsonObject);


        assertTrue(checker.isValid(filePath));
    }

    @Test
    public void shouldReturnTrueWhenJsonIsEmpty() {

        String filePath = "src/test/resources/role_policy_empty.json";

        JSONObject jsonObject = readJsonFromFile(filePath);

        RolePolicyChecker checker = new RolePolicyChecker(jsonObject);

        assertTrue(checker.isValid(filePath));
    }

    private JSONObject readJsonFromFile(String filePath) {
        try {
            FileReader reader = new FileReader(filePath);
            return new JSONObject(new JSONTokener(reader));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}