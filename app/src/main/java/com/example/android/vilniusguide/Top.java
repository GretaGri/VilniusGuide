package com.example.android.vilniusguide;

/**
 * Created by Greta Grigutė on 2018-04-15.
 */

public class Top {
    private String mPlace;
    private int mPictureDescription;

    public Top(String place, int pictureDescription) {
        this.mPlace = place;
        this.mPictureDescription = pictureDescription;
    }

    public String getPlace() {
        return mPlace;
    }

    public int getPictureDescription() {
        return mPictureDescription;
    }
}
