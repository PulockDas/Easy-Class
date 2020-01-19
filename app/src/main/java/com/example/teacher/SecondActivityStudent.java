package com.example.teacher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivityStudent extends AppCompatActivity {

    TextView textView;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_student);


        textView = (TextView) findViewById(R.id.secactst);
        str = getIntent().getExtras().getString("value");
        textView.setText(str);

    }
}
