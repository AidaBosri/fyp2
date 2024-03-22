package com.example.finalproject;

import java.io.*;
import java.net.URL;

public class HttpURLConnection {

    public String sendGetRequest(String url) {
        String response = "";
        try {
            URL obj = new URL(url);
            java.net.HttpURLConnection con = (java.net.HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder responseBuilder = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                responseBuilder.append(inputLine);
            }
            in.close();

            response = responseBuilder.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    public static void main(String[] args) {
        String url = "http://192.168.1.128/finalproject/DbConnection.php";
        HttpURLConnection example = new HttpURLConnection();
        String response = example.sendGetRequest(url);
        System.out.println(response);
    }
}