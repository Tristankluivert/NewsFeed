package com.ostap_kozak.newsfeed;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by ostapkozak on 03/03/2017.
 */

public class Utils {


    public static ArrayList<News> extractNewsFromJson(String jsonString) {

        // Initializes news array list to start populating it.
        ArrayList<News> news = new ArrayList<>();


        try {
            JSONObject root = new JSONObject(jsonString);
            JSONArray articles = root.getJSONArray("articles"); // Article array is an array of json objects that represent news articles

            for (int i = 0; i < articles.length(); i++) {
                JSONObject newsArticle = articles.getJSONObject(i);
                String title = newsArticle.getString("title");
                String description = newsArticle.getString("description");
                String url = newsArticle.getString("url");
                String urlImage = newsArticle.getString("urlToImage");

                news.add(new News(title, description, createUrl(url), createUrl(urlImage)));
            }
        } catch (JSONException exception) {
            exception.printStackTrace();
        }

        return news;
    }


    /** Returns a URL object from the given string URL **/
    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
