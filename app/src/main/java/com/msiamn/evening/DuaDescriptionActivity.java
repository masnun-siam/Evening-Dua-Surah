package com.msiamn.evening;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
import java.net.URL;

public class DuaDescriptionActivity extends AppCompatActivity {

    public String name = "";
    public String arabic = "";
    public String bengaliPronounce = "";
    public String bengali = "";
    public String id = "";

    Uri url;
    MediaPlayer player;
    Context context;
    TextView descriptionPageName;
    TextView descriptionPageArabic;
    TextView descriptionPageBanglaPronounce;
    TextView getDescriptionPageBanglaMeaning;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua_description);
        descriptionPageName = (TextView) findViewById(R.id.descriptionPageName);
        descriptionPageArabic = (TextView) findViewById(R.id.descriptionPageArabic);
        descriptionPageBanglaPronounce = (TextView) findViewById(R.id.bangla_pronounce);
        getDescriptionPageBanglaMeaning = (TextView) findViewById(R.id.bangla_meaning);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        arabic = bundle.getString("two");
        name = bundle.getString("one");
        bengaliPronounce = bundle.getString("three");
        bengali = bundle.getString("four");
        id = bundle.getString("five");


        descriptionPageName.setText(arabic);
        descriptionPageArabic.setText(name);
        descriptionPageBanglaPronounce.setText(bengaliPronounce);
        getDescriptionPageBanglaMeaning.setText(bengali);

        url = Uri.parse("android.resource://" + getPackageName() + "/raw/" + id);
    }


    public void play(View v) {
        if (player == null) {

            player = MediaPlayer.create(this, url);

            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }

    public void pause(View v) {
        if (player != null) {
            player.pause();
        }
    }

    public void stop(View v) {
        stopPlayer();

    }

    @SuppressLint("ShowToast")
    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
            Toast.makeText(this, "Dua Stopped.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}
