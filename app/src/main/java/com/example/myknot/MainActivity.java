package com.example.myknot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    String title,imgurl,succes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //To send context of Mainactivity to the dialogbox class
        swipedialogbox swipe=new swipedialogbox(this);


        // To create request object by using volley
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://backend-test-zypher.herokuapp.com/testData";


        // To send POST request for the given URL
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.POST, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // To get the value of the object from JSON
                            title = response.getString("title");
                            imgurl = response.getString("imageURL");
                            succes = response.getString("success_url");

                            swipe.method(title,imgurl,succes);
                           // textView.setText(title);

                            // To load image
                           // Glide.with(MainActivity.this).load(imgurl).into(img);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        // To add the request to the request queue
        queue.add(request);




    }
}