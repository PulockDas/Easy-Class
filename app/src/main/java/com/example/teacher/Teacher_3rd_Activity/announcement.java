package com.example.teacher.Teacher_3rd_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.teacher.MySingleton;
import com.example.teacher.R;
import com.example.teacher.SecondActivity;
import com.example.teacher.SecondActivityStudent;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class announcement extends AppCompatActivity implements View.OnClickListener {

    public String str;
    public Button button;
    public EditText editText, course, date;
    public String url = "http://192.168.31.119/EasyClass/Announcement.php";

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
            String courses = course.getText().toString().trim();
            String announces = editText.getText().toString().trim();
            String dates = date.getText().toString().trim();

            anno(getApplicationContext(), courses, announces, dates);
        }
    }

    public void anno(final Context context, final String courses, final String anno, final String dates){



        StringRequest stringRequest = new StringRequest(Request.Method.POST,url , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    Toast.makeText(getApplicationContext(), response.toString().trim(),Toast.LENGTH_SHORT).show();
                    if(response.toString().trim().equals("Thanks")){
                        course.setText(null);
                        date.setText(null);
                        editText.setText(null);

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
                params.put("Name",SecondActivity.name);
                params.put("Course",courses);
                params.put("Date",dates);
                params.put("Anno",anno);

                return params;
            }
        };

        MySingleton.getInstance(context).addToRequestQueue(stringRequest);
    }
}
