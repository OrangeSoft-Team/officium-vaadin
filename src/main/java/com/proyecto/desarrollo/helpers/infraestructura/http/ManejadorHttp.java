package com.proyecto.desarrollo.helpers.infraestructura.http;

import org.apache.commons.io.IOUtils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class ManejadorHttp {


//    public static void realizar_peticion_post(JSONObject datos_enviar , URL url) throws IOException, ParseException {
//
//        try {
//            URLConnection con = url.openConnection();
//            HttpURLConnection http = (HttpURLConnection) con;
//            http.setRequestMethod("POST"); // PUT is another valid option
//            http.setDoOutput(true);
//
//            byte[] out = datos_enviar.toString().getBytes("utf-8");
//
//
//            int length = out.length;
//
//            http.setFixedLengthStreamingMode(length);
//            http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
//            http.connect();
//            try (OutputStream os = http.getOutputStream()) {
//                os.write(out);
//            }
////            String result = IOUtils.toString(http.getInputStream(), StandardCharsets.UTF_8);
////            System.out.println(result);
////            JSONParser parser = new JSONParser();
////            JSONObject json = (JSONObject) parser.parse(result);
////            return json;
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            throw e;
//        }
//    }

    public static String realizar_peticion_post_inicio_sesion(JSONObject datos_enviar , URL url) throws IOException, ParseException {

        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
// Enable output for the connection.
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setRequestProperty("Accept", "application/json");
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


    public static String realizar_peticion_post(JSONObject datos_enviar , URL url) throws IOException, ParseException {

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
// Enable output for the connection.
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setRequestProperty("Accept", "application/json");
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

    public static String realizar_peticion_put(JSONObject datos_enviar , URL url) throws IOException, ParseException {

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
// Enable output for the connection.
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setRequestProperty("Accept", "application/json");
// Set HTTP request method.
        conn.setRequestMethod("PUT");

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


    public static String realizar_peticion_get(URL url) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuffer response = new StringBuffer();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        String res = response.toString();
        System.out.println(res);

        return res;

//        json.forEach(item -> {
//            JSONObject item_jsonobj = (JSONObject) item;
//            String qq = item_jsonobj.get("uuid").toString();
//            System.out.println(qq);
//        });

    }




}
