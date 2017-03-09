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

    public News(String title, String description, String url, String imageUrl) {
        this.mTitle = title;
        this.mDescription = description;
        this.mUrl = url;
        this.mImageUrl = imageUrl;
    }

    public String getTitle() { return mTitle;}
    public String getDescrption() { return mDescription;}
    public String getUrl() { return mUrl;}
    public String getImageUrl() { return mImageUrl;}



}
