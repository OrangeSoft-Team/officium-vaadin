package com.proyecto.desarrollo.helpers.infraestructura.http;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class ManejadorHttpSpring {

    public static String realizar_peticion_post(JSONObject datos_enviar , URL url, String token) throws IOException, ParseException {

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // Enable output for the connection.
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization",token);
        // Set HTTP request method.
        conn.setRequestMethod("POST");

        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
        writer.write(datos_enviar.toString());
        writer.close();

        int respCode = conn.getResponseCode(); // New items get NOT_FOUND on PUT
        if (respCode == HttpURLConnection.HTTP_OK || respCode == HttpURLConnection.HTTP_NOT_FOUND) {
            System.out.println("entre");
            StringBuilder response = new StringBuilder();
            String line;

            // Read input data stream.
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();


            String res = response.toString();
            System.out.println(res);

            return res;

        } else {
            System.out.println(respCode);
            throw new IOException();
        }
    }

    public static String realizar_peticion_put(JSONObject datos_enviar , URL url, String token) throws IOException, ParseException {

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // Set HTTP request method.
        conn.setRequestProperty("Authorization",token);
        conn.setRequestMethod("PUT");
        /*Si no se tiene que enviar ningun dato, no se habilita la salida de datos*/
        if (datos_enviar !=null) {
            // Enable output for the connection.
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setRequestProperty("Accept", "application/json");
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
            writer.write(datos_enviar.toString());
            writer.close();
        }

        int respCode = conn.getResponseCode(); // New items get NOT_FOUND on PUT
        if (respCode == HttpURLConnection.HTTP_OK || respCode == HttpURLConnection.HTTP_NOT_FOUND) {
            System.out.println("entre");
            StringBuilder response = new StringBuilder();
            String line;

            // Read input data stream.
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();


            String res = response.toString();
            System.out.println(res);

            return res;

        } else {
            System.out.println(respCode);
            throw new IOException();
        }
    }


    public static String realizar_peticion_get(URL url, String token) throws IOException, ParseException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();;
        // Set HTTP request method.
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization",token);
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuffer response = new StringBuffer();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        String res = response.toString();
        System.out.println(res);

        return res;
    }


}
