package com.example.teacher.Teacher_3rd_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.teacher.R;
import com.example.teacher.SecondActivity;
import com.example.teacher.SecondActivityStudent;

public class announcement extends AppCompatActivity implements View.OnClickListener {

    public String str;
    public Button button;
    public EditText editText, course, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);

        button = (Button) findViewById(R.id.annsub);
        editText = (EditText) findViewById(R.id.announce);
        course = (EditText) findViewById(R.id.courseid);
        date = (EditText) findViewById(R.id.dateid);


        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.annsub) {
            String anno = editText.getText().toString();
            Intent intent = new Intent(announcement.this, SecondActivityStudent.class);
            str = editText.getText().toString();
            intent.putExtra("value",str);
            startActivity(intent);
            finish();
        }
    }
}
