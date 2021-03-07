package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ArrayAdapter;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.MenuInflater;

import com.example.myapplication3.R;


public class MainActivity extends AppCompatActivity {
    //TextView txtShow;
    //EditText inputbox;
    //String url_address = "http://193.226.17.162/interog.asp?lecture=";

    // This class is used to instantiate menu XML files into Menu objects.
    // The items and submenus will be added to this Menu.
   /* @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create the url structure, we access 'http://193.226.17.162/interog.asp?lecture=' + no
        String url_address = "http://193.226.17.162/interog.asp?lecture=";
        Spinner spinner = (Spinner)findViewById(R.id.spinner1);
        // specify a spinnerAdapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.lecture_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //populate the spinner with a list of lectures
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                //an item on the list has been selected
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            WebView webView = (WebView)findViewById(R.id.wv);
            position = position +1;

            //layout a WebView to display justified text.
            // I want to set the background of the WebView to be transparent to appear like a textView
            webView.setBackgroundColor(Color.TRANSPARENT);
            webView.loadUrl("javascript:document.body.style.color=\"white\";");
            webView.loadUrl(url_address+position); // load web page
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });}
}