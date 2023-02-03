package com.runeforger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.runeforger.models.Adventurer;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;


import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URL;

public class AdventurerApi {
    public static void getAdventurer(String uuid){
        String url = "http://localhost:3000/api/adventurer/" + uuid;

        try {
            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                ObjectMapper mapper = new ObjectMapper();
                Adventurer[] adventurers = mapper.readValue(response.toString(), Adventurer[].class);
                System.out.println(adventurers[0].getNick());
                System.out.println("OK");
            } else {
                System.out.println("Erro api");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
