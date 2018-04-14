package com.example.android.vilniusguide;

/**
 * Created by Greta Grigutė on 2018-04-13.
 */

public class Object {

    private String mName;
    private String mPlace;
    private int mPictureList;
    private String mHomeLink;
    private String mDescription;
    private String mResources;
    private String mMapLink;
    private int mPictureDescription;

    public Object (String name, String place, int pictureList) {
        this.mName = name;
        this.mPlace = place;
        this.mPictureList = pictureList;
    }
    public Object (String name, int pictureDescription) {
        this.mName = name;
        this.mPictureDescription = pictureDescription;
    }

    public Object (String name, String place, int pictureList, String homeLink, String description, String resources, String mapLink, int pictureDescription){
        this.mName = name;
        this.mPlace = place;
        this.mPictureList = pictureList;
        this.mHomeLink = homeLink;
        this.mDescription =  description;
        this.mResources = resources;
        this.mMapLink = mapLink;
        this.mPictureDescription = pictureDescription;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getPlace() {
        return mPlace;
    }

    public void setPlace(String place) {
        this.mPlace = place;
    }

    public String getHomeLink() {
        return mHomeLink;
    }

    public void setHomeLink(String homeLink) {
        this.mHomeLink = homeLink;
    }

    public int getPictureList() {
        return mPictureList;
    }

    public void setPictureList(int pictureList) {
        this.mPictureList = pictureList;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getResources() {
        return mResources;
    }

    public void setResources(String resources) {
        this.mResources = resources;
    }

    public String getMapLink() {
        return mMapLink;
    }

    public void setMapLink(String mapLink) {
        this.mMapLink = mapLink;
    }

    public int getPictureDescription() {
        return mPictureDescription;
    }

    public void setPictureDescription(int pictureDescription) {
        this.mPictureDescription = pictureDescription;
    }
}
