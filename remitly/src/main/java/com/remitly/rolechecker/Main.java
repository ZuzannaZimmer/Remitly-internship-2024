package com.remitly.rolechecker;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {

            String filePath = "remitly/src/main/resources/role_policy.json";

            FileReader reader = new FileReader(filePath);
            JSONObject jsonObject = new JSONObject(new JSONTokener(reader));

            RolePolicyChecker check = new RolePolicyChecker(jsonObject);

            boolean result = check.isValid(filePath);

            System.out.println(result);

        } catch (IOException e){
            e.printStackTrace();
        }


    }
}
