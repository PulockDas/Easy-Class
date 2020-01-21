package com.example.teacher.RegisterPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.teacher.MainActivity;
import com.example.teacher.MySingleton;
import com.example.teacher.R;
import com.example.teacher.SecondActivity;
import com.example.teacher.SecondActivityStudent;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    private EditText emailview;
    private EditText userview;
    private EditText passwordview;
    private RadioGroup user_type;
    private RadioButton radioButton;
    private Button reg;
    private String type2;
    private String user_name;
    private String email;
    private String passw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailview = (EditText)findViewById(R.id.emailid);
        userview = (EditText)findViewById(R.id.userid);
        passwordview = (EditText)findViewById(R.id.PasswordId);
        user_type = (RadioGroup) findViewById(R.id.typeid);
        reg = (Button) findViewById(R.id.regviewid);
        //radioButton = (RadioButton) findViewById(R.id.id);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioId = user_type.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);
                type2 = radioButton.getText().toString().trim();
                user_name = userview.getText().toString().trim();
                email = emailview.getText().toString().trim();
                passw = passwordview.getText().toString().trim();
                regiBack(getApplicationContext(),email, passw,type2,user_name);
            }
        });
    }

    public void regiBack(final Context context, final String email, final String pass,final String type2, final String user_name){



        StringRequest stringRequest = new StringRequest(Request.Method.POST, MainActivity.regurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    String info[] = response.toString().trim().split("\n");
                    Toast.makeText(getApplicationContext(), info[0],Toast.LENGTH_SHORT).show();
                    if(info[0].equals("successfull") && type2.equals("Teacher")){

                        Intent intent = new  Intent(context, SecondActivity.class);
                        startActivity(intent);
                    }
                    else if(info[0].equals("successfull") && type2.equals("Student")){

                        Intent intent = new  Intent(context, SecondActivityStudent.class);
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
                params.put("Type",type2);
                params.put("Name",user_name);
                params.put("Email",email);
                params.put("Password",pass);
                return params;
            }
        };

        MySingleton.getInstance(context).addToRequestQueue(stringRequest);

    }

}
