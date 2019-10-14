package com.example.teacher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText username, password;
    private Button login;
    private TextView textView;

    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = (EditText) findViewById(R.id.userid);
        password = (EditText) findViewById(R.id.PasswordId);
        login = (Button) findViewById(R.id.loginviewid);
        textView = (TextView) findViewById(R.id.textId);

        textView.setText("Number of attempts remaining : 5");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernames = username.getText().toString();
                String passw = password.getText().toString();

                if(usernames.equals("admin" ) && passw.equals("1234")){
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }

                else if(usernames.equals("student" ) && passw.equals("5678")){
                    Intent intent = new Intent(MainActivity.this, SecondActivityStudent.class);
                    startActivity(intent);
                }

                else{
                    counter--;
                    textView.setText("Number of attempts remaining : " + counter);

                    if(counter == 0)
                        login.setEnabled(false);
                }

            }


        });


    }
}
