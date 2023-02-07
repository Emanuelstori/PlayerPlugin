package com.runeforger.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.runeforger.models.Adventurer;

import java.io.*;


import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URL;
import java.util.List;

public class AdventurerApi {
    public static Adventurer getAdventurer(String uuid){
        String url = "http://localhost:3000/api/adventurer/nick/" + uuid;

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
                System.out.println("Usa o mapper");
                Adventurer adventurer = mapper.readValue(response.toString(), Adventurer.class);
                System.out.println(adventurer.getNick());
                return adventurer;
            } else {
                System.out.println("Erro api");
                return null;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Adventurer loginAdventurer(String nick, String password) {
        try {
            URL apiUrl = new URL("http://localhost:3000/api/adventurer/login/");
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            ObjectMapper mapper = new ObjectMapper();

            JsonObject json = new JsonObject();
            json.addProperty("nick", nick);
            json.addProperty("password", password);

            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.write(json.toString().getBytes());
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                Adventurer adventurers = mapper.readValue(response.toString(), new TypeReference<Adventurer>() {});


                return adventurers;
            } else {
                System.out.println("Erro na API");
                return null;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Adventurer registerAdventurer(String uuid, String nick, String password, String display_nick, String permission) {
        try {
            URL apiUrl = new URL("http://localhost:3000/api/adventurer/register/");
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            ObjectMapper mapper = new ObjectMapper();

            JsonObject json = new JsonObject();
            json.addProperty("uuid", uuid);
            json.addProperty("nick", nick);
            json.addProperty("display_nick", display_nick);
            json.addProperty("password", password);
            json.addProperty("permission", permission);

            System.out.println(json.toString());

            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.write(json.toString().getBytes());
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                Adventurer adventurer = mapper.readValue(response.toString(), new TypeReference<Adventurer>() {});


                return adventurer;
            } else {
                System.out.println("Erro na API");
                return null;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
