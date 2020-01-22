package com.example.teacher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.teacher.Teacher_3rd_Activity.*;

public class SecondActivity extends AppCompatActivity {

    public static String name ;
    TextView Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Name =(TextView) findViewById(R.id.name);
        Name.setText(name);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.teacher_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intent2;
        switch (item.getItemId()) {
            case R.id.routine:
                intent2 = new Intent(SecondActivity.this, Routine.class);
                startActivity(intent2);
                return true;

            case R.id.updateid:
                intent2 = new Intent(SecondActivity.this, announcement.class);
                startActivity(intent2);
                return true;

            case R.id.seepostid:
                intent2 = new Intent(SecondActivity.this, SecondActivityStudent.class);
                startActivity(intent2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
