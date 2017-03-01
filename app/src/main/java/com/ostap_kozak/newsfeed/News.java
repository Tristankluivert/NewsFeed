package com.ostap_kozak.newsfeed;

/**
 * Created by ostapkozak on 27/02/2017.
 */

public class News {

    private String mTitle;
    private String mDescription;
    private String mUrl;
    private int mImage;

    public News(String title, String description, String url, int image) {
        this.mTitle = title;
        this.mDescription = description;
        this.mUrl = url;
        this.mImage = image;
    }

    public String getTitle() { return mTitle;}
    public String getDescrption() { return mDescription;}
    public String getUrl() { return mUrl;}
    public int getImage() { return mImage;}



}
