package com.example.apps.com.sistempakar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HasilDiagnosaActivity extends AppCompatActivity {

    @BindView(R.id.persen) TextView persen;
    @BindView(R.id.penyakit) TextView penyakit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_diagnosa);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        penyakit.setText(intent.getStringExtra("penyakit"));
        persen.setText(intent.getStringExtra("persen")+"%");
    }
}
