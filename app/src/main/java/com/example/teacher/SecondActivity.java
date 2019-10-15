package com.example.teacher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.teacher.Teacher_3rd_Activity.CancelClass;
import com.example.teacher.Teacher_3rd_Activity.Extra_Class;
import com.example.teacher.Teacher_3rd_Activity.Routine;

public class SecondActivity extends AppCompatActivity {

    private Button exams;
    private Button routine;
    private Button extra_class;
    private Button cancel_class;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        exams = (Button) findViewById(R.id.pick_date);
        routine = (Button) findViewById(R.id.change_time);
        extra_class = (Button) findViewById(R.id.extraClass);
        cancel_class = (Button) findViewById(R.id.cancelClass);



        exams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(SecondActivity.this, Date_picker.class);
                startActivity(intent2);
            }
        });

        routine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(SecondActivity.this, Routine.class);
                startActivity(intent2);
            }
        });

        extra_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(SecondActivity.this, Extra_Class.class);
                startActivity(intent2);
            }
        });

        cancel_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(SecondActivity.this, CancelClass.class);
                startActivity(intent2);
            }
        });
    }
}
