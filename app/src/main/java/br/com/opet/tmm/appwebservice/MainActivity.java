package br.com.opet.tmm.appwebservice;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    TextView textInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInfo = (TextView) findViewById(R.id.textInfo);
        executeTask();
    }

    public void executeTask(){
        new APIConnection().execute();
    }

    private class APIConnection extends AsyncTask<Void,Void,Tempo>{
        @Override
        public void onPreExecute(){
        }

        @Override
        public Tempo doInBackground(Void... params){
            HttpURLConnection con = null;
            try {
                URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q=Curitiba&mode=json&units=metric&cnt=1&appid=440b84a8027be4fcf90f9b83e4b45aa9");
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setDoInput(true);

                String resultado = Util.streamToString(con.getInputStream());
                Tempo tempo = Util.JSONToTempo(resultado);
                return tempo;
            }
            catch (Exception e){
                e.printStackTrace();
            }finally {
                con.disconnect();
            }

            return null;
        }

        @Override
        public void onPostExecute(Tempo tempo){
            String info = "Cidade: " + tempo.getCidade();
            info += "\nTemperatura: " + tempo.getTemperatura();
            textInfo.setText(info);
        }
    }
}
