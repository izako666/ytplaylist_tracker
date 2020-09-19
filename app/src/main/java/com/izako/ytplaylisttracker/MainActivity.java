package com.izako.ytplaylisttracker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_DIRECTORY = 0;
    private static final String TAG = "Directory";
    private TextView daText;
    public static final String PREF_NAME = "yt_tracker_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent t = new Intent(MainActivity.this, DownloadDirectoryActivity.class);
        startActivity(t);
    }

    @Override
    protected void onResume() {
        SharedPreferences preferences =  this.getBaseContext().getSharedPreferences(PREF_NAME,0);

        EditText text = findViewById(R.id.playlisturl);
        text.setText(preferences.getString("playlisturl", null));

       TextView view =  findViewById(R.id.sumText);
       view.setText("test");
        super.onResume();
    }
}

