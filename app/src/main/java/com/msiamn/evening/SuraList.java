package com.msiamn.evening;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;

public class SuraList extends AppCompatActivity implements View.OnClickListener {
    Button loadSuraFatihaButton;
    Button loadAyatulKursi;
    Button loadSuraBakara;
    Button loadSuraYasin;
    Button loadSuraHashor;
    Button loadSuraMulk;
    Button loadSuraTaoba;
    Button loadAyateShefa;
    Button loadDurudeHajari;
    Button loadAhadnama;
    Button loadFourKalima;
    Button loadSayidulIstigfar;
    Button loadSatSalam;
    Button loadNamajSheshDoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sura_list);
        loadSuraFatihaButton = (Button) findViewById(R.id.load_sura_fatiha);
        loadAyatulKursi = (Button) findViewById(R.id.load_ayatul_kursi);
        loadSuraBakara = (Button) findViewById(R.id.load_sura_bakara);
        loadSuraYasin = (Button) findViewById(R.id.load_sura_yasin);
        loadSuraHashor = (Button) findViewById(R.id.load_sura_hashor);
        loadSuraMulk = (Button) findViewById(R.id.load_sura_mulk);
        loadSuraTaoba = (Button) findViewById(R.id.load_sura_taobah);
        loadAyateShefa = (Button) findViewById(R.id.load_ayate_shefa);
        loadDurudeHajari = (Button) findViewById(R.id.load_durude_hajari);
        loadAhadnama = (Button) findViewById(R.id.load_ahadnama);
        loadFourKalima = (Button) findViewById(R.id.load_four_kalema);
        loadSayidulIstigfar = (Button) findViewById(R.id.load_sayidul_istigfar);
        loadSatSalam = (Button) findViewById(R.id.load_sat_salam);
        loadNamajSheshDoa = (Button) findViewById(R.id.load_namaj_shesher_doa);

        loadSuraFatihaButton.setOnClickListener(this);
        loadAyatulKursi.setOnClickListener(this);
        loadSuraBakara.setOnClickListener(this);
        loadSuraYasin.setOnClickListener(this);
        loadSuraHashor.setOnClickListener(this);
        loadSuraMulk.setOnClickListener(this);
        loadSuraTaoba.setOnClickListener(this);
        loadAyateShefa.setOnClickListener(this);
        loadDurudeHajari.setOnClickListener(this);
        loadAhadnama.setOnClickListener(this);
        loadFourKalima.setOnClickListener(this);
        loadSayidulIstigfar.setOnClickListener(this);
        loadSatSalam.setOnClickListener(this);
        loadNamajSheshDoa.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(SuraList.this, DuaDescriptionActivity.class);
        String arabic = "";
        String bengaliPronounce = "";
        String bengali = "";
        String name = ((Button) v).getText().toString();
        String id = getResources().getResourceEntryName(v.getId());

        try {
            InputStream is1;
            InputStream is2;
            InputStream is3;

            is1 = getAssets().open(id + "_arabic.txt");
            is2 = getAssets().open(id + "_bangla_pronounce.txt");
            is3 = getAssets().open(id + "_bangla.txt");

            int size1 = is1.available();
            int size2 = is2.available();
            int size3 = is3.available();
            byte[] buffer1 = new byte[size1];
            byte[] buffer2 = new byte[size2];
            byte[] buffer3 = new byte[size3];
            is1.read(buffer1);
            is2.read(buffer2);
            is3.read(buffer3);
            is1.close();
            is2.close();
            is3.close();
            arabic = new String(buffer1);
            bengaliPronounce = new String(buffer2);
            bengali = new String(buffer3);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        Bundle bundle = new Bundle();

        bundle.putString("one", arabic);
        bundle.putString("two", name);
        bundle.putString("three", bengaliPronounce);
        bundle.putString("four", bengali);
        bundle.putString("five", id);

        i.putExtras(bundle);

        startActivity(i);
    }
}
