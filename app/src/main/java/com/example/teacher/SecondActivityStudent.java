package com.example.teacher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.android.volley.Request.Method.POST;

public class SecondActivityStudent extends AppCompatActivity {

    WebView webView;
    String body;
    String middle;

    String url = "http://192.168.31.119/EasyClass/getAnnouncement.php";
    public  String notification = "<!DOCTYPE html>\n"+
            "<html>"+
            "<body>";


      String last = "</body>"+
            "</html>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_student);

        getNotification();

        webView = findViewById(R.id.noti);

    }

    public void getNotification(){
        StringRequest stringRequest = new StringRequest(POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    String str[] = response.toString().trim().split("\n");

                    for(int i=0; i<str.length; i++){

                        String element[] = str[i].split("-");
                        middle += "<div style=background:Gray;text-align:center;border-radius:25px;padding:10px;margin-top:10px>"+
                                "<div style = text-align:left;padding:15px>"+
                                element[0]+" > "+element[1]+"<br>"+
                                "IICT<br>"+
                                element[2]+
                                "</div style = margin-bottom:10px>"+
                                element[3]+
                                "</div>";
                    }
                     String html = notification+middle+last;
                    webView.loadDataWithBaseURL(null, html, "text/html","utf-8",null);

                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(getApplicationContext(),jsonObject.getString("message"),Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<>();
                return params;
            }
        };

        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }
}
