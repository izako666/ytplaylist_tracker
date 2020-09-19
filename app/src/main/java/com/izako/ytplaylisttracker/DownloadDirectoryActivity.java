package com.izako.ytplaylisttracker;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import net.rdrei.android.dirchooser.DirectoryChooserActivity;
import net.rdrei.android.dirchooser.DirectoryChooserConfig;
import net.rdrei.android.dirchooser.DirectoryChooserFragment;

public class DownloadDirectoryActivity extends Activity {
    private static final int REQUEST_DIRECTORY = 0;
    private static final String TAG = "Directory";
    private TextView daText;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       daText =  findViewById(R.id.sumText);
       daText.setText("yuhaye");
        findViewById(R.id.turnon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                daText =  findViewById(R.id.sumText);
                daText.setText("bruv");

                SharedPreferences settings = view.getContext().getSharedPreferences(MainActivity.PREF_NAME,0);
                SharedPreferences.Editor e = settings.edit();
                e.putString("playlisturl", ((EditText)findViewById(R.id.playlisturl)).getText().toString());
                System.out.println(e.toString());
                e.apply();




            }
        });

        // Set up click handler for "Choose Directory" button
        findViewById(R.id.directory)
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        daText.setText("nuh aye");
                       EditText txt =  findViewById(R.id.playlisturl);
                        SharedPreferences settings = v.getContext().getSharedPreferences(MainActivity.PREF_NAME,0);
                        txt.setText(settings.getString("playlisturl",null));

                        final Intent chooserIntent = new Intent(
                                DownloadDirectoryActivity.this,
                                DirectoryChooserActivity.class);

                        final DirectoryChooserConfig config = DirectoryChooserConfig.builder()
                                .newDirectoryName("DirChooserSample")
                                .allowReadOnlyDirectory(true)
                                .allowNewDirectoryNameModification(true)
                                .build();


                        chooserIntent.putExtra(
                                DirectoryChooserActivity.EXTRA_CONFIG,
                                config);

                        startActivityForResult(chooserIntent, REQUEST_DIRECTORY);
                    }
                });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_DIRECTORY) {
            Log.i(TAG, String.format("Return from DirChooser with result %d",
                    resultCode));

            if (resultCode == DirectoryChooserActivity.RESULT_CODE_DIR_SELECTED) {
                        System.out.println(data
                                .getStringExtra(DirectoryChooserActivity.RESULT_SELECTED_DIR));
            } else {
            }
        }
    }
}
