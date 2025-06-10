package com.example.projekpemanasan;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private EditText etAwal, etTujuan;
    private Button btnJalur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etAwal = findViewById(R.id.etAwal);
        etTujuan = findViewById(R.id.etTujuan);
        btnJalur = findViewById(R.id.btnJalur);

        btnJalur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String asal = etAwal.getText().toString();
                String tujuan = etTujuan.getText().toString();
                DisplayJalur(asal, tujuan);
            }
        });
    }

    private void DisplayJalur(String asal, String tujuan) {
        try {
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + asal + "/" + tujuan);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
