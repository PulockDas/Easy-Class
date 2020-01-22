package com.example.teacher.Teacher_3rd_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.teacher.Date_picker;
import com.example.teacher.MySingleton;
import com.example.teacher.R;
import com.example.teacher.SecondActivity;
import com.example.teacher.SecondActivityStudent;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class announcement extends AppCompatActivity implements View.OnClickListener {

    String[] allcourses;
    Spinner spinner;
    public String str;
    public Button button;
    public TextView course;
    public EditText editText, date;
    public String url = "http://192.168.31.119/EasyClass/Announcement.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);

        spinner = (Spinner) findViewById(R.id.courses);
        allcourses = getResources().getStringArray(R.array.courses);
        button = (Button) findViewById(R.id.annsub);
        editText = (EditText) findViewById(R.id.announce);
        course = (TextView) findViewById(R.id.courseid);
        date = (EditText) findViewById(R.id.dateShowid);
        //datePick = (TextView) findViewById(R.id.dateid);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.sample_view, R.id.textViewId, allcourses);
        spinner.setAdapter(adapter);

        //datePick.setOnClickListener(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String courses, announces, dates;

        courses = spinner.getSelectedItem().toString().trim();
        announces = editText.getText().toString().trim();
        dates = date.getText().toString().trim();

        anno(getApplicationContext(), courses, announces, dates);

        Intent intent = new Intent(announcement.this, SecondActivityStudent.class);
        startActivity(intent);

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
