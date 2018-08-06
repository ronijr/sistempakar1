package com.example.apps.com.sistempakar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DataDiriActivity extends AppCompatActivity {
    @BindView(R.id.nama) EditText nama;
    @BindView(R.id.umur) EditText umur;
    @BindView(R.id.lakilaki) RadioButton male;
    @BindView(R.id.perempuan) RadioButton female;
    @BindView(R.id.next) Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_diri);
        ButterKnife.bind(this);
        inisialisasiView();
    }

    private void inisialisasiView(){
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFormProfile();
            }
        });
    }

    private void setFormProfile(){
        if(TextUtils.isEmpty(nama.getText().toString().trim()) || TextUtils.isEmpty(umur.getText().toString().trim())){
            Toast.makeText(getApplicationContext(),"Isi dengan lengkap data diri anda",Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("nama",nama.getText().toString().trim());
            intent.putExtra("umur",umur.getText().toString().trim());
            if(male.isChecked()){
                intent.putExtra("jk","Laki-laki");
            } else {
                intent.putExtra("jk","Perempuan");
            }
            startActivity(intent);
        }
    }
}
