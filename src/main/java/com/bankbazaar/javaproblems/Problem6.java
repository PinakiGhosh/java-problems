package com.bankbazaar.javaproblems;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;


public class Problem6 {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        ClassLoader classLoader = gson.getClass().getClassLoader();
        try {
            InputStream inputStream = classLoader.getResourceAsStream("javaproblems.json");
            String result = new String(inputStream.readAllBytes());
            JsonObject jsonObject = JsonParser.parseString(result).getAsJsonObject();
            Set<String> keys = jsonObject.keySet();

            for(String key: keys)
            {
                System.out.println(key);
            }
        }
        catch (NullPointerException e)
        {
            System.out.println("File not found");
        }
        }
    }
