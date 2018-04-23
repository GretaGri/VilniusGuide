package com.example.android.vilniusguide;

/**
 * Created by Greta Grigutė on 2018-04-13.
 */

public class Object {
    private int mCategory;
    private String mName;
    private String mPlace;
    private int mPictureList;
    private String mHomeLink;
    private String mDescription;
    private String mResources;
    private String mMapLink;
    private int mPictureDescription;
    private boolean mFavorite;

    public Object(int category, String name, String place, int pictureList, String homeLink, String description, String resources, String mapLink, int pictureDescription, boolean favorite) {
        this.mCategory = category;
        this.mName = name;
        this.mPlace = place;
        this.mPictureList = pictureList;
        this.mHomeLink = homeLink;
        this.mDescription = description;
        this.mResources = resources;
        this.mMapLink = mapLink;
        this.mPictureDescription = pictureDescription;
        this.mFavorite = favorite;
    }

    public int getCategory() {
        return mCategory;
    }

    public String getName() {
        return mName;
    }

    public String getPlace() {
        return mPlace;
    }

    public String getHomeLink() {
        return mHomeLink;
    }

    public int getPictureList() {
        return mPictureList;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getResources() {
        return mResources;
    }

    public String getMapLink() {
        return mMapLink;
    }

    public int getPictureDescription() {
        return mPictureDescription;
    }

    public boolean getFavorite() {
        return mFavorite;
    }

    public void setFavorite(boolean favorite) {
        this.mFavorite = favorite;
    }
}
