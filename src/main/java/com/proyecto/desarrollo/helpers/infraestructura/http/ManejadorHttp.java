package com.proyecto.desarrollo.helpers.infraestructura.http;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class ManejadorHttp {
    public static JSONObject realizar_peticion_post(JSONObject datos_enviar , URL url) throws IOException, ParseException {

        try {
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection) con;
            http.setRequestMethod("POST"); // PUT is another valid option
            http.setDoOutput(true);

            byte[] out = datos_enviar.toString().getBytes("utf-8");


            int length = out.length;

            http.setFixedLengthStreamingMode(length);
            http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            http.connect();
            try (OutputStream os = http.getOutputStream()) {
                os.write(out);
            }
            String result = IOUtils.toString(http.getInputStream(), StandardCharsets.UTF_8);
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(result);
            return json;
        }
        catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
