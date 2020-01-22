package com.example.teacher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class Date_picker extends AppCompatActivity {

    private DatePicker date_picker;
    private Button select;

    public static String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);

        date_picker = (DatePicker) findViewById(R.id.date_pick);
        select = (Button) findViewById(R.id.select);


        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date = currentDate();
            }
        });


    }

    String currentDate(){
        StringBuilder stringBuilder = new StringBuilder();
        //stringBuilder.append("Current Date : ");
        stringBuilder.append(date_picker.getDayOfMonth() + "/");
        stringBuilder.append(date_picker.getMonth()+"/");
        stringBuilder.append(date_picker.getYear());

        return stringBuilder.toString().trim();
    }
}
