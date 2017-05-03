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

    private class APIConnection extends AsyncTask<Void,Void,String>{
        @Override
        public void onPreExecute(){
        }

        @Override
        public String doInBackground(Void... params){
            HttpURLConnection con = null;
            try {
                URL url = new URL("http://www.pudim.com.br");
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setDoInput(true);

                String resultado = Util.streamToString(con.getInputStream());
                return resultado;
            }
            catch (Exception e){
                e.printStackTrace();
            }finally {
                con.disconnect();
            }

            return null;
        }

        @Override
        public void onPostExecute(String s){
            textInfo.setText(s);
        }
    }
}
