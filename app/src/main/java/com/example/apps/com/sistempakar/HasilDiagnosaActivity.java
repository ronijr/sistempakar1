package com.example.apps.com.sistempakar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HasilDiagnosaActivity extends AppCompatActivity {

    @BindView(R.id.persen1) TextView persen1;
    @BindView(R.id.penyakit1) TextView penyakit1;
    @BindView(R.id.deskripsi1) TextView desk1;
    @BindView(R.id.solusi1)TextView solusi1;

    @BindView(R.id.persen2) TextView persen2;
    @BindView(R.id.penyakit2) TextView penyakit2;
    @BindView(R.id.deskripsi2) TextView desk2;
    @BindView(R.id.solusi2)TextView solusi2;

    @BindView(R.id.persen3) TextView persen3;
    @BindView(R.id.penyakit3) TextView penyakit3;
    @BindView(R.id.deskripsi3) TextView desk3;
    @BindView(R.id.solusi3)TextView solusi3;

    @BindView(R.id.persen4) TextView persen4;
    @BindView(R.id.penyakit4) TextView penyakit4;
    @BindView(R.id.deskripsi4) TextView desk4;
    @BindView(R.id.solusi4)TextView solusi4;

    @BindView(R.id.persen5) TextView persen5;
    @BindView(R.id.penyakit5) TextView penyakit5;
    @BindView(R.id.deskripsi5) TextView desk5;
    @BindView(R.id.solusi5)TextView solusi5;

    @BindView(R.id.layout1) LinearLayout layout1;
    @BindView(R.id.layout2) LinearLayout layout2;
    @BindView(R.id.layout3) LinearLayout layout3;
    @BindView(R.id.layout4) LinearLayout layout4;
    @BindView(R.id.layout5) LinearLayout layout5;

    @BindView(R.id.nama) TextView nama;
    @BindView(R.id.jk) TextView jk;
    @BindView(R.id.umur) TextView umur;
    @BindView(R.id.exit) ImageButton exit;
    @BindView(R.id.btnBack) Button btnPeriksaUlang;

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_diagnosa);
        ButterKnife.bind(this);
        intent = getIntent();
        inisialisasiView();

    }

    @SuppressLint("SetTextI18n")
    private void inisialisasiView(){
        nama.setText(intent.getStringExtra("nama"));
        jk.setText(intent.getStringExtra("jk"));
        umur.setText(intent.getStringExtra("umur")+" Tahun");
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                finishAffinity();
            }
        });
        btnPeriksaUlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if(intent.getStringExtra("code1") != null){
            layout1.setVisibility(View.VISIBLE);
            persen1.setText(intent.getStringExtra("persen1")+"%");
            penyakit1.setText(intent.getStringExtra("penyakit1"));
            desk1.setText(getString(R.string.desk1));
            solusi1.setText(getString(R.string.solusi1));
        }else{
            layout1.setVisibility(View.GONE);
        }

        if(intent.getStringExtra("code2") != null){
            layout2.setVisibility(View.VISIBLE);
            persen2.setText(intent.getStringExtra("persen2")+"%");
            penyakit2.setText(intent.getStringExtra("penyakit2"));
            desk2.setText(getString(R.string.desk2));
            solusi2.setText(getString(R.string.solusi2));
        }else{
            layout2.setVisibility(View.GONE);
        }


        if(intent.getStringExtra("code3") != null){
            layout3.setVisibility(View.VISIBLE);
            persen3.setText(intent.getStringExtra("persen3")+"%");
            penyakit3.setText(intent.getStringExtra("penyakit3"));
            desk3.setText(getString(R.string.desk3));
            solusi3.setText(getString(R.string.solusi3));
        }else{
            layout3.setVisibility(View.GONE);
        }

        if(intent.getStringExtra("code4") != null){
            layout4.setVisibility(View.VISIBLE);
            persen4.setText(intent.getStringExtra("persen4")+"%");
            penyakit4.setText(intent.getStringExtra("penyakit4"));
            desk4.setText(getString(R.string.desk4));
            solusi4.setText(getString(R.string.solusi4));
        }else{
            layout4.setVisibility(View.GONE);
        }


        if(intent.getStringExtra("code5") != null){
            layout5.setVisibility(View.VISIBLE);
            persen5.setText(intent.getStringExtra("persen5")+"%");
            penyakit5.setText(intent.getStringExtra("penyakit5"));
            desk5.setText(getString(R.string.desk5));
            solusi5.setText(getString(R.string.solusi5));
        }else{
            layout5.setVisibility(View.GONE);
        }
    }
}
