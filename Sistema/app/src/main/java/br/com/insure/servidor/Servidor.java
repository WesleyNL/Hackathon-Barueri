package br.com.insure.servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import br.com.insure.enums.Models;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Jefferson on 27/11/2016.
 */
public class Servidor {

    public static Response requestGET(Models model, String endPoint) {
        return requestGET(model, endPoint, new GETParametros());
    }

    public static Response requestGET(Models model, GETParametros parametros) {
        return requestGET(model, "", parametros);
    }

    public static Response requestGET(Models model, String endPoint, GETParametros parametros) {
        String url = "http://localhost:1337/" + model.name();

        if (endPoint.length() > 0)
            url += "/" + endPoint;

        url += "?" + parametros.toString();
        Response response = new Response();

        URL obj = null;
        HttpURLConnection con = null;
        BufferedReader in = null;

        StringBuffer stringBuffer = new StringBuffer();
        String inputLine;

        response.setMessageResponse("");
        response.setCodeResponse(0);

        try {
            obj = new URL(url);
            con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            while ((inputLine = in.readLine()) != null) {
                stringBuffer.append(inputLine);
            }
            response.setMessageResponse(stringBuffer.toString());
            response.setCodeResponse(con.getResponseCode());

            in.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return response;
    }

    public static Response requestPOST(Models model, String endPoint, String postParametros) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        Response response = new Response();
        okhttp3.Response r;

        String url = "http://localhost:1337/" + model.name().toLowerCase() + "/" + endPoint;

        RequestBody body = RequestBody.create(JSON, postParametros);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try {
            r = client.newCall(request).execute();
            response.setMessageResponse(r.body().string());
            response.setCodeResponse(r.code());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return response;
    }
}
