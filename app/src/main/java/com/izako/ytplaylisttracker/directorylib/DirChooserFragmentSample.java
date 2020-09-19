package com.izako.ytplaylisttracker.directorylib;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.izako.ytplaylisttracker.R;

import net.rdrei.android.dirchooser.DirectoryChooserConfig;
import net.rdrei.android.dirchooser.DirectoryChooserFragment;

public class DirChooserFragmentSample extends Activity implements DirectoryChooserFragment.OnFragmentInteractionListener {
    private DirectoryChooserFragment mDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DirectoryChooserConfig config = DirectoryChooserConfig.builder()
                .newDirectoryName("DialogSample")
                .build();
        mDialog = DirectoryChooserFragment.newInstance(config);


        findViewById(R.id.directory)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mDialog.show(getFragmentManager(), null);
                    }
                });
    }

    @Override
    public void onSelectDirectory(@NonNull String path) {
        Log.i(this.getClass().getName(), "path");
        mDialog.dismiss();
    }

    @Override
    public void onCancelChooser() {

        mDialog.dismiss();
    }
}
