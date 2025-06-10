package com.example.projekpemanasan;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {
    int count = 0;
    TextView textview;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);

        textview = findViewById(R.id.text2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            super.onBackPressed();
        }
    }

    public void ShowToast(View view) {
        Toast.makeText(this, "Subhanallah 33x\n" + "Alhamdulillah 33x \n" + "Allahuakbar 33x", Toast.LENGTH_LONG).show();
    }

    public void CountUp(View view) {
        count++;
        textview.setText(String.valueOf(count));
        textview.setTextColor(Color.BLACK);

        if (count > 32) {
            count = 0;
            textview.setText(String.valueOf(count));
            textview.setTextColor(Color.BLACK);
            Toast.makeText(this, "Anda sudah mencapai angka ke 33", Toast.LENGTH_LONG).show();
        }
    }

    public void CountDown(View view) {
        count--;
        textview.setText(String.valueOf(count));
        textview.setTextColor(Color.BLACK);

        if (count < 0) {
            count = 0;
            textview.setText(String.valueOf(count));
            textview.setTextColor(Color.BLACK);
            Toast.makeText(this, "Anda sudah mencapai angka paling kecil", Toast.LENGTH_LONG).show();
        }
    }
}
