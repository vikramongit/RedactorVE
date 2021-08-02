package com.vikram.redactorve;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DeveloperDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_details);
    }
     public void getplayUrlFromIntent(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://bit.ly/3oVfy9s"));
        startActivity(i);
    }
   public void getytUrlFromIntent(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://bit.ly/3oX7l4E"));
        startActivity(i);
    }
     public void getfbUrlFromIntent(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://bit.ly/3hZAMS8"));
        startActivity(i);
    }
     public void getgitUrlFromIntent(View view) {
         Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://bit.ly/3c0kbtA"));
        startActivity(i);
    }
     public void getinstaUrlFromIntent(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://bit.ly/34kxv7T"));
        startActivity(i);
    }
     public void gettwitUrlFromIntent(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://bit.ly/3fP9if7"));
        startActivity(i);
    }

}