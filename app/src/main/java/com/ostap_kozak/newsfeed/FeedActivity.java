package com.ostap_kozak.newsfeed;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class FeedActivity extends AppCompatActivity {
    private List<News> news = new ArrayList<>();

    private final String URL = "https://newsapi.org/v1/articles?source=google-news&sortBy=top&apiKey=5fdf8e4518634a28be9c18dde43e5c59";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        news = Utils.extractNewsFromJson(response);
                        createAdapter();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(FeedActivity.this, "Connection failed", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(stringRequest);
    }


    public void createAdapter() {
        RecyclerView newsRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_news);

        NewsAdapter newsAdapter = new NewsAdapter(this, news);

        newsRecyclerView.setAdapter(newsAdapter);

        // Set layout manager to position the items
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ItemClickSupport.addTo(newsRecyclerView).setOnItemClickListener(
                new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(news.get(position).getUrl()));
                        startActivity(intent);

                    }
                }
        );
    }



}
