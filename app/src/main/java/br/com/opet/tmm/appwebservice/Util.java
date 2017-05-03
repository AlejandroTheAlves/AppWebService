package br.com.opet.tmm.appwebservice;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Diego on 26/04/2017.
 */

public class Util {

    public static String streamToString(InputStream is){
        BufferedReader br;
        StringBuilder sb = new StringBuilder();

        br = new BufferedReader(new InputStreamReader(is));
        String line;
        try {
            while((line = br.readLine()) != null){
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static Tempo JSONToTempo(String jsonFile){
        JSONObject mainObj;
        Tempo tempo = null;
        try {
            mainObj = new JSONObject(jsonFile);
            JSONObject cityObj = mainObj.getJSONObject("city");
            String nome_cidade = cityObj.getString("name");
            JSONArray listObj = mainObj.getJSONArray("list");
            JSONObject elementObj = (JSONObject) listObj.get(0);
            double temperatura = elementObj.getJSONObject("temp").getDouble("day");
            tempo = new Tempo();
            tempo.setCidade(nome_cidade);
            tempo.setTemperatura(temperatura);
        } catch (JSONException e) {
            e.printStackTrace();
        }finally {
            return tempo;
        }
    }

}
