package com.aplication.vlineupss;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.aplication.vlineupss.databinding.ActivityMainBinding;
import com.aplication.vlineupss.utils.NetworkUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Leader extends AppCompatActivity implements View.OnClickListener {
    EditText angkaLeader;
    TextView Nama, Kemenangan;
    Button btnFecth;
    private ActivityMainBinding binding;
    String gameName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader);



        angkaLeader = findViewById(R.id.AngkaLeader);
        Nama = findViewById(R.id.namaPlayer);
        Kemenangan = findViewById(R.id.kemenangan);
        btnFecth = findViewById(R.id.btn_fet);

        btnFecth.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btn_fet){
            gameName = angkaLeader.getText().toString();
            try {
                getData();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

    }
    public void getData( ) throws MalformedURLException {
        Uri uri = Uri.parse("https://ap.api.riotgames.com/val/ranked/v1/leaderboards/by-act/a16955a5-4ad0-f761-5e9e-389df1c892fb?size=100&startIndex=0&api_key=RGAPI-e02770d5-6087-46b9-8bb9-60ae2cf3624c")
                .buildUpon().build();
        URL url = new URL(uri.toString());
        new DOTask().execute(url);


    }
    class DOTask extends AsyncTask<URL, Void,String> {

        @Override
        protected String doInBackground(URL... urls) {
            URL url = urls [0];
            String data = null;
            try {
                data = NetworkUtils.makeHTTPRequest(url);
            }catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                parseJson(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        public void parseJson(String data) throws JSONException {
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(data);
            }catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray cityArray = jsonObject.getJSONArray("players");

            for (int i=0; i<cityArray.length();i++){
                JSONObject cityo = cityArray.getJSONObject(i);
                String cityn = cityo.get("leaderboardRank").toString();
                if (cityn.equals(gameName)){
                    String population = cityo.get("gameName").toString();
                    String kemenangan = cityo.get("rankedRating").toString();
                    Nama.setText(population);
                    Kemenangan.setText(kemenangan);
                    break;
                }
                else {
                    Nama.setText("notfound");
                    Kemenangan.setText("notfound");
                }


            }
        }
    }

}