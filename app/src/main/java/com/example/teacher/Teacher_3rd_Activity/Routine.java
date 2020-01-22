package com.example.teacher.Teacher_3rd_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.teacher.R;
import com.example.teacher.SecondActivity;

import uk.co.senab.photoview.PhotoViewAttacher;

public class Routine extends AppCompatActivity {
    ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);

        imageView = (ImageView) findViewById(R.id.image);
        PhotoViewAttacher photoView = new PhotoViewAttacher(imageView);

        photoView.update();
    }
}
