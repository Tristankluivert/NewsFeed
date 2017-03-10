package com.ostap_kozak.newsfeed;

import java.net.URL;

/**
 * Created by ostapkozak on 27/02/2017.
 */

public class News {

    private String mTitle;
    private String mDescription;
    private String mUrl;
    private String mImageUrl;
    private String mTimePublication;

    public News(String title, String description, String url, String imageUrl, String timePublication) {
        this.mTitle = title;
        this.mDescription = description;
        this.mUrl = url;
        this.mImageUrl = imageUrl;
        this.mTimePublication = timePublication;
    }

    public String getTitle() { return mTitle;}
    public String getDescription() { return mDescription;}
    public String getUrl() { return mUrl;}
    public String getImageUrl() { return mImageUrl;}
    public String getTime() { return mTimePublication; }



}
