package com.example.teacher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.teacher.RegisterPackage.Register;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.android.volley.Request.Method.POST;

public class MainActivity extends AppCompatActivity {

    private EditText username, password;
    private Button login;
    private TextView textView, textreg;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    public static String type;

    String loginUrl = "http://192.168.31.119/EasyClass/Login.php";
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = (EditText) findViewById(R.id.userid);
        password = (EditText) findViewById(R.id.PasswordId);
        login = (Button) findViewById(R.id.loginviewid);
        textreg = (TextView) findViewById(R.id.textregId);
        radioGroup = (RadioGroup)findViewById(R.id.user_typeid);

        //textView = (TextView) findViewById(R.id.textId);

        //textView.setText("Number of attempts remaining : 5");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioId = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);
                type = radioButton.getText().toString().trim();
                String email = username.getText().toString().trim();
                String passw = password.getText().toString().trim();

                login(getApplicationContext(),email, passw);





//                else{
//                    counter--;
//                    textView.setText("Number of attempts remaining : " + counter);
//
//                    if(counter == 0)
//                        login.setEnabled(false);
//                }

            }


        });

        textreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }


        });


    }

    public void login(final Context context, final String email, final String pass){



        StringRequest stringRequest = new StringRequest(Request.Method.POST,loginUrl , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    String info[] = response.toString().trim().split("\n");
                    Toast.makeText(getApplicationContext(), info[0],Toast.LENGTH_SHORT).show();
                    if(info[0].equals("Welcome")){
                        Intent intent = new  Intent(context,SecondActivity.class);
                        SecondActivity.name = info[1];
                        startActivity(intent);
                    }
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(context,jsonObject.getString("message"),Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(context,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<>();
                params.put("Type",type);
                params.put("Email",email);
                params.put("Password",pass);

                return params;
            }
        };

        MySingleton.getInstance(context).addToRequestQueue(stringRequest);

    }



}
