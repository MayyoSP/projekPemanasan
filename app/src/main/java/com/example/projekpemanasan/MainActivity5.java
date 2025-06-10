package com.example.projekpemanasan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity5 extends AppCompatActivity {

    private TextInputEditText labelName;
    private RadioGroup radioGroup;
    private TextInputEditText labelName2;
    private Button button;
    private LinearLayout layout;
    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        labelName = findViewById(R.id.label_name);
        radioGroup = findViewById(R.id.radio_group);
        button = findViewById(R.id.button);
        layout = findViewById(R.id.output_container);
        labelName2 = findViewById(R.id.label_name2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = labelName.getText().toString().trim();
                String number = labelName2.getText().toString().trim();
                int GenderID = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(GenderID);
                String Gender = selectedRadioButton != null ? selectedRadioButton.getText().toString() : "Not selected";

                String output = "Data " + i + "\nNama : " + nama + "\nGender : " + Gender + "\nNumber : " + number + "\n";
                i++;

                TextView outputTextView = new TextView(MainActivity5.this);
                outputTextView.setTextSize(18);
                outputTextView.setText(output);

                layout.addView(outputTextView);
            }
        });
    }
}

