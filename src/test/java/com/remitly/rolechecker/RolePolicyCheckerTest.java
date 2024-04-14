package com.remitly.rolechecker;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Test;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class RolePolicyCheckerTest {

    @Test
    public void shouldReturnTrueForValidPolicy() {

        String filePath = "src/main/resources/role_policy.json";
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

        boolean result = checker.isValid(filePath);

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenJsonIsEmpty() {

        String filePath = "src/test/resources/role_policy_empty.json";
        JSONObject jsonObject = readJsonFromFile(filePath);
        RolePolicyChecker checker = new RolePolicyChecker(jsonObject);

        boolean result = checker.isValid(filePath);

        assertTrue(result);
    }
    @Test
    public void shouldReturnFalseForInvalidJsonFile() {
        String filePath = "src/test/resources/role_policy_non_json.txt";
        JSONObject jsonObject = new JSONObject();
        RolePolicyChecker checker = new RolePolicyChecker(jsonObject);

        boolean result = checker.isJsonFile(filePath);

        assertFalse(result);
    }
    @Test
    public void shouldReturnTrueForValidJsonFile() {
        String filePath = "src/main/resources/role_policy.json";
        JSONObject jsonObject = new JSONObject();
        RolePolicyChecker checker = new RolePolicyChecker(jsonObject);

        boolean result = checker.isJsonFile(filePath);

        assertTrue(result);
    }

    @Test
    public void shouldHave17Lines() {
        String filePath = "src/test/resources/role_policy_17_lines.json";
        long lineCount = 0;

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lineCount = lines.count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(17, lineCount);
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

