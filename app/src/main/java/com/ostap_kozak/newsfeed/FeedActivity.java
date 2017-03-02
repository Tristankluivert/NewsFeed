package com.ostap_kozak.newsfeed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        final List<News> news = new ArrayList<>();
        news.add(new News("Fake News", "Decorators can also be used for adding consistent spacing around " +
                "items displayed in a grid layout or staggered grid. Copy over this SpacesItemDecoration.java" +
                " decorator into your project and apply to a RecyclerView using the addItemDecoration method." +
                " Refer to this staggered grid tutorial for a more detailed outline.", "3", R.mipmap.ic_launcher));
        news.add(new News("Lels", "Description", "6", R.mipmap.ic_launcher));
        news.add(new News("Fake News", "Description", "3", R.mipmap.ic_launcher));
        news.add(new News("Lels", "Description", "6", R.mipmap.ic_launcher));
        news.add(new News("Fake News", "Description", "3", R.mipmap.ic_launcher));
        news.add(new News("Lels", "Description", "6", R.mipmap.ic_launcher));
        news.add(new News("Fake News", "Description", "3", R.mipmap.ic_launcher));
        news.add(new News("Lels", "Description", "6", R.mipmap.ic_launcher));

        RecyclerView newsRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_news);

        NewsAdapter newsAdapter = new NewsAdapter(this, news);

        newsRecyclerView.setAdapter(newsAdapter);

        // Set layout manager to position the items
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ItemClickSupport.addTo(newsRecyclerView).setOnItemClickListener(
                new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        Toast.makeText(FeedActivity.this, news.get(position).getTitle(), Toast.LENGTH_SHORT).show();

                    }
                }
        );

    }
}
