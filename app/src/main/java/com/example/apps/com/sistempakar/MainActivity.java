package com.example.apps.com.sistempakar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.submit) Button submit;
    @BindView(R.id.g01) CheckBox g01;
    @BindView(R.id.g02) CheckBox g02;
    @BindView(R.id.g03) CheckBox g03;
    @BindView(R.id.g04) CheckBox g04;
    @BindView(R.id.g05) CheckBox g05;
    @BindView(R.id.g06) CheckBox g06;
    @BindView(R.id.g07) CheckBox g07;
    @BindView(R.id.g08) CheckBox g08;
    @BindView(R.id.g09) CheckBox g09;
    @BindView(R.id.g010) CheckBox g10;
    @BindView(R.id.g011) CheckBox g11;
    @BindView(R.id.g012) CheckBox g12;
    @BindView(R.id.g013) CheckBox g13;
    @BindView(R.id.g014) CheckBox g14;
    @BindView(R.id.g015) CheckBox g15;
    @BindView(R.id.g016) CheckBox g16;
    @BindView(R.id.g017) CheckBox g17;
    @BindView(R.id.g018) CheckBox g18;
    @BindView(R.id.g019) CheckBox g19;
    @BindView(R.id.g020) CheckBox g20;
    @BindView(R.id.g021) CheckBox g21;
    @BindView(R.id.g022) CheckBox g22;
    @BindView(R.id.g023) CheckBox g23;

    Database database;
    Diagnosa modeldiagnosa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        database= new Database(this);
        modeldiagnosa=new Diagnosa();
        inisialisasiView();
    }

    private void inisialisasiView(){

        setDiagnosa();


    }

    private void setDiagnosa(){

        //Penyakit 1
        database.addDiagnosa(new Diagnosa("G01",0.6,0.4,"P1","Halusinasi Suara"));
        database.addDiagnosa(new Diagnosa("G02",0.6,0.2,"P1","Halusinasi Pembauan atau Pengecapan Rasa"));
        database.addDiagnosa(new Diagnosa("G03",0.8,0.4,"P1","Merasa dikejar-kejar yang beraneka ragam"));
        database.addDiagnosa(new Diagnosa("G04",0.4,0.2,"P1","Halusinasi Visual"));

        //Penyakit 2
        database.addDiagnosa(new Diagnosa("G05",0.4,0.2,"P2","Pemalu dan senang menyendiri"));
        database.addDiagnosa(new Diagnosa("G06",0.8,0.4,"P2","Perilaku menunjukan hampa tujuan dan hampa perasaan"));
        database.addDiagnosa(new Diagnosa("G07",0.4,0.2,"P2","Senyum sendiri atau sikap tinggi hati"));
        database.addDiagnosa(new Diagnosa("G08",0.6,0.4,"P2","Proses pikir mengalami disorganisasi dan pembicaraan tidak menentu"));
        database.addDiagnosa(new Diagnosa("G09",0.8,0.2,"P2","Adanya suatu preokupasi yang dangkal dan bersifat dibuat-buat"));

        //Penyakit 3
        database.addDiagnosa(new Diagnosa("G10",0.8,0.4,"P3","Berkurangnya reaktivitas terhadap lingkungan"));
        database.addDiagnosa(new Diagnosa("G11",0.8,0.6,"P3","Gaduh gelisah(aktivitas motorik yang tak bertujuan"));
        database.addDiagnosa(new Diagnosa("G12",0.8,0.4,"P3","Menampilkan dan mempertahankan posisi tubuh tertentu yang tidak wajar"));
        database.addDiagnosa(new Diagnosa("G13",0.8,0.6,"P3","Perlawanan terhadap semua perintah"));
        database.addDiagnosa(new Diagnosa("G14",0.6,0.2,"P3","Mempertahankan posisi tubuh yang kaku untuk melawan upaya menggerakan dirinya"));

        //Penyakit 4
        database.addDiagnosa(new Diagnosa("G15",0.6,0.2,"P4","Perlambatan psikomotorik"));
        database.addDiagnosa(new Diagnosa("G16",0.6,0.4,"P4","Sikap pasif dan ketidak inisiatif"));
        database.addDiagnosa(new Diagnosa("G17",0.8,0.6,"P4","Memilik riwayat satu episode psikotik yang jelas di masa lalu"));
        database.addDiagnosa(new Diagnosa("G18",0.8,0.4,"P4","Aktifitas menurut dan efek yang menumpul"));



        //Penyakit 5
        database.addDiagnosa(new Diagnosa("G19",0.4,0.2,"P5","Perubahan perilaku pribadi yang bermakna"));
        database.addDiagnosa(new Diagnosa("G20",0.6,0.2,"P5","Kehilangan minat yang mencolok"));
        database.addDiagnosa(new Diagnosa("G21",0.4,0.2,"P5","Tidak berbuat sesuatu"));
        database.addDiagnosa(new Diagnosa("G22",0.4,0.2,"P5","Tanpa tujuan hidup"));
        database.addDiagnosa(new Diagnosa("G23",0.6,0.4,"P5","Penarikan diri secara sosial"));

        g01.setText(database.getDiagnosa("G01").getName());
        g02.setText(database.getDiagnosa("G02").getName());
        g03.setText(database.getDiagnosa("G03").getName());
        g04.setText(database.getDiagnosa("G04").getName());
        g05.setText(database.getDiagnosa("G05").getName());
        g06.setText(database.getDiagnosa("G06").getName());
        g07.setText(database.getDiagnosa("G07").getName());
        g08.setText(database.getDiagnosa("G08").getName());
        g09.setText(database.getDiagnosa("G09").getName());
        g10.setText(database.getDiagnosa("G10").getName());
        g11.setText(database.getDiagnosa("G11").getName());
        g12.setText(database.getDiagnosa("G12").getName());
        g13.setText(database.getDiagnosa("G13").getName());
        g14.setText(database.getDiagnosa("G14").getName());
        g15.setText(database.getDiagnosa("G15").getName());
        g16.setText(database.getDiagnosa("G16").getName());
        g17.setText(database.getDiagnosa("G17").getName());
        g18.setText(database.getDiagnosa("G18").getName());
        g19.setText(database.getDiagnosa("G19").getName());
        g20.setText(database.getDiagnosa("G20").getName());
        g21.setText(database.getDiagnosa("G21").getName());
        g22.setText(database.getDiagnosa("G22").getName());
        g23.setText(database.getDiagnosa("G23").getName());

        final List<Diagnosa> diagnosa = new ArrayList<>();
        final AdapterDiagnosa adapterDiagnosa = new AdapterDiagnosa(this, database.getAllDiagnosa(),null);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> objects = new ArrayList<>();
                String penyakit=null;
                String akhir=null;
                   if(g01.isChecked() && g02.isChecked() && g03.isChecked() && g04.isChecked()){
                       double cf1p1 = 0,cf2p1 =0;
                       double cf3p1 = 0,cf4p1= 0;
                       cf1p1 = Math.floor((database.getDiagnosa("G01").getMb() * database.getDiagnosa("G01").getMd()) *100)/100;
                       cf2p1 = Math.floor((database.getDiagnosa("G02").getMb() * database.getDiagnosa("G02").getMd())*100)/100;
                       cf3p1 = Math.floor((database.getDiagnosa("G03").getMb() * database.getDiagnosa("G03").getMd() * 100)) / 100;
                       cf4p1 = Math.floor((database.getDiagnosa("G04").getMb() * database.getDiagnosa("G04").getMd()) * 100) /100;

                       double cfpp1_2 = cf1p1 + cf2p1 * (1 - cf1p1);
                       double cfpp1_3 = cfpp1_2 + cf3p1 * (1 - cfpp1_2);
                       double cfpp2_4 = cfpp1_3 + cf4p1 * (1 - cfpp1_3);
                       cfpp2_4 = Math.floor(cfpp2_4 * 100) / 100;
                       double persen = cfpp2_4 * 100;
                       akhir = String.valueOf(Math.round(persen));
                       penyakit = "Skizofrenia Paranoid";
                   }else if(g05.isChecked() && g06.isChecked() && g07.isChecked() && g08.isChecked() && g09.isChecked()){
                       double cf1p2 = 0,cf2p2 =0;
                       double cf3p2 = 0,cf4p2= 0;
                       double cf5p2;
                       cf1p2 = Math.floor((database.getDiagnosa("G05").getMb() * database.getDiagnosa("G05").getMd()) *100)/100;
                       cf2p2 = Math.floor((database.getDiagnosa("G06").getMb() * database.getDiagnosa("G06").getMd())*100)/100;
                       cf3p2 = Math.floor((database.getDiagnosa("G07").getMb() * database.getDiagnosa("G07").getMd() * 100)) / 100;
                       cf4p2 = Math.floor((database.getDiagnosa("G08").getMb() * database.getDiagnosa("G08").getMd()) * 100) /100;
                       cf5p2 = Math.floor((database.getDiagnosa("G09").getMb() * database.getDiagnosa("G09").getMd()) * 100) /100;

                       double cfpp2_1 = cf1p2 + cf2p2 * (1 - cf1p2);
                       double cfpp2_2 = cfpp2_1 + cf3p2 * (1 - cfpp2_1);
                       double cfpp2_3 = cfpp2_2 + cf4p2 * (1 - cfpp2_2);
                       double cfpp2_4 = cfpp2_3 + cf5p2 * (1 - cfpp2_3);
                       cfpp2_4 = Math.floor(cfpp2_4 * 100) / 100;
                       double persen = cfpp2_4 * 100;
                       akhir = String.valueOf(Math.round(persen));
                       penyakit = "Skizofrenia Hiberfrenik";
                   } else if(g10.isChecked() && g11.isChecked() && g12.isChecked() && g13.isChecked() && g14.isChecked()){
                       double cf1p3 = 0,cf2p3 =0;
                       double cf3p3 = 0,cf4p3= 0;
                       double cf5p3;
                       cf1p3 = Math.floor((database.getDiagnosa("G10").getMb() * database.getDiagnosa("G10").getMd()) *100)/100;
                       cf2p3 = Math.floor((database.getDiagnosa("G11").getMb() * database.getDiagnosa("G11").getMd())*100)/100;
                       cf3p3 = Math.floor((database.getDiagnosa("G12").getMb() * database.getDiagnosa("G12").getMd() * 100)) / 100;
                       cf4p3 = Math.floor((database.getDiagnosa("G13").getMb() * database.getDiagnosa("G13").getMd()) * 100) /100;
                       cf5p3 = Math.floor((database.getDiagnosa("G14").getMb() * database.getDiagnosa("G14").getMd()) * 100) /100;

                       double cfpp3_1 = cf1p3 + cf2p3 * (1 - cf1p3);
                       double cfpp3_2 = cfpp3_1 + cf3p3 * (1 - cfpp3_1);
                       double cfpp3_3 = cfpp3_2 + cf4p3 * (1 - cfpp3_2);
                       double cfpp3_4 = cfpp3_3 + cf5p3 * (1 - cfpp3_3);
                       cfpp3_4 = Math.floor(cfpp3_4 * 100) / 100;
                       double persen = cfpp3_4 * 100;
                       akhir = String.valueOf(Math.round(persen));
                       penyakit = "Skizofrenia Katatonik";
                   }else if(g10.isChecked() && g11.isChecked() && g12.isChecked() && g13.isChecked() && g14.isChecked()){
                       double cf1p4 = 0,cf2p4 =0;
                       double cf3p4 = 0,cf4p4= 0;
                       double cf5p4;
                       cf1p4 = Math.floor((database.getDiagnosa("G15").getMb() * database.getDiagnosa("G15").getMd()) *100)/100;
                       cf2p4 = Math.floor((database.getDiagnosa("G16").getMb() * database.getDiagnosa("G16").getMd())*100)/100;
                       cf3p4 = Math.floor((database.getDiagnosa("G17").getMb() * database.getDiagnosa("G17").getMd() * 100)) / 100;
                       cf4p4 = Math.floor((database.getDiagnosa("G18").getMb() * database.getDiagnosa("G18").getMd()) * 100) /100;

                       double cfpp4_1 = cf1p4 + cf2p4 * (1 - cf1p4);
                       double cfpp4_2 = cfpp4_1 + cf3p4 * (1 - cfpp4_1);
                       double cfpp4_3 = cfpp4_2 + cf4p4 * (1 - cfpp4_2);
                       cfpp4_3 = Math.floor(cfpp4_3 * 100) / 100;
                       double persen = cfpp4_3 * 100;
                       akhir = String.valueOf(Math.round(persen));
                       penyakit = "Skizofrenia Residual";
                   }else if(g19.isChecked() && g20.isChecked() && g21.isChecked() && g22.isChecked() && g23.isChecked()){
                       double cf1p5 = 0,cf2p5 =0;
                       double cf3p5 = 0,cf4p5= 0;
                       double cf5p5;
                       cf1p5 = Math.floor((database.getDiagnosa("G19").getMb() * database.getDiagnosa("G19").getMd()) *100)/100;
                       cf2p5 = Math.floor((database.getDiagnosa("G20").getMb() * database.getDiagnosa("G20").getMd())*100)/100;
                       cf3p5 = Math.floor((database.getDiagnosa("G21").getMb() * database.getDiagnosa("G21").getMd() * 100)) / 100;
                       cf4p5 = Math.floor((database.getDiagnosa("G22").getMb() * database.getDiagnosa("G22").getMd()) * 100) /100;
                       cf5p5 = Math.floor((database.getDiagnosa("G22").getMb() * database.getDiagnosa("G22").getMd()) * 100) /100;

                       double cfpp5_1 = cf1p5 + cf2p5 * (1 - cf1p5);
                       double cfpp5_2 = cfpp5_1 + cf3p5 * (1 - cfpp5_1);
                       double cfpp5_3 = cfpp5_2 + cf4p5 * (1 - cfpp5_2);
                       double cfpp5_4 = cfpp5_3 + cf4p5 * (1 - cfpp5_3);
                       cfpp5_4 = Math.floor(cfpp5_4 * 100) / 100;
                       double persen = cfpp5_4 * 100;
                       akhir = String.valueOf(Math.round(persen));
                           penyakit = "Skizofrenia Simplek";
                   } else {
                       akhir = "0";
                       penyakit = "Tidak diketahui";
                   }




                Intent intent = new Intent(MainActivity.this, HasilDiagnosaActivity.class);
                intent.putExtra("persen",akhir);
                intent.putExtra("penyakit",penyakit);
                startActivity(intent);
            }
        });

    }

}
