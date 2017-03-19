package com.ostap_kozak.newsfeed;

import android.os.SystemClock;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
                String timePublication = newsArticle.getString("publishedAt");

                news.add(new News(title, description, url, urlImage, timePublication));
            }
        } catch (JSONException exception) {
            exception.printStackTrace();
        }

        return news;
    }


    public static Date stringToDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return convertedDate;
    }


    public static String convertNewsTimePublication(String newsTime) {
        Date systemDate = new Date();
        Date newsDate = stringToDate(newsTime);
        Date date = new Date(systemDate.getTime() - newsDate.getTime());

        SimpleDateFormat day_format = new SimpleDateFormat("dd");
        SimpleDateFormat hour_format = new SimpleDateFormat("HH");
        SimpleDateFormat minute_format = new SimpleDateFormat("mm");

        int day = Integer.parseInt(day_format.format(date));
        int hour = Integer.parseInt(hour_format.format(date));
        int minute = Integer.parseInt(minute_format.format(date));

        if (day > 0) { return Integer.toString(day) + " day ago"; }
        if (hour > 0) { return Integer.toString(hour) + " hours ago"; }
        return Integer.toString(minute) + "minutes ago";
    }
}
