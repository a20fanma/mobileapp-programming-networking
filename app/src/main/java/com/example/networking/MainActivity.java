package com.example.networking;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String TAG = "==>";

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    private final String JSON_FILE = "mountains.json";

    RecyclerView mountainRecyclerView;
    private MountainAdapter adapter;
    private ArrayList<Mountain> mountainArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonFile(this, this).execute(JSON_FILE); /* Läser in en textfil */
        new JsonTask(this).execute(JSON_URL); /*Läser in en URL*/

        mountainRecyclerView = findViewById(R.id.recycler_view);
        mountainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MountainAdapter(this, mountainArrayList);
        mountainRecyclerView.setAdapter(adapter);
        mountainRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

    }

    @Override
    public void onPostExecute(String json) { /*Exekveras den lästa textfilen*/
        Log.d("MainActivity", json);
        Gson gson = new Gson();
        Type type = new TypeToken<List<Mountain>>() {}.getType();
        List<Mountain> listOfMountains = gson.fromJson(json, type);
        Log.d(TAG,"number of elemenets"+listOfMountains.size());
        Log.d(TAG,"element 0"+listOfMountains.get(0).toString());
    }

}
