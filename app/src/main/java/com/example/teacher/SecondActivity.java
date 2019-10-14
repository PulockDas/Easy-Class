package com.example.teacher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class SecondActivity extends AppCompatActivity {

    private Button exams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        exams = (Button) findViewById(R.id.pick_date);

        exams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(SecondActivity.this, Date_picker.class);
                startActivity(intent2);
            }
        });
    }
}
