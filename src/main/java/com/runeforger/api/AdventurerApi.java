package com.runeforger.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.InputStreamReader;
import clojure.tools.reader.reader_types.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URL;

public class AdventurerApi {
    public void getAdventurer(String uuid){
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

                // Aqui você pode usar uma biblioteca como Jackson para parsear a resposta JSON
                // e criar um objeto Adventurer a partir dela.
            } else {
                // Tratar erro na chamada à API
            }
        } catch (IOException e) {
            // Tratar exceção
        }
    }
}
