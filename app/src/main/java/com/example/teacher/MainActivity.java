package com.example.teacher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText username, password;
    private Button login;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = (EditText) findViewById(R.id.userid);
        password = (EditText) findViewById(R.id.PasswordId);
        login = (Button) findViewById(R.id.PasswordId);
        textView = (TextView) findViewById(R.id.textId);

        login.setOnClickListener(new View.OnClickListener(){
            public void onclick(View view){
                String usernames = username.getText().toString();
                String passw = password.getText().toString();

                if(usernames.equals("admin" && passw.equals("1234"))){


                }

            }


        });


    }
}
