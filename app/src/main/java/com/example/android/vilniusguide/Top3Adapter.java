package com.example.android.vilniusguide;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Greta Grigutė on 2018-04-14.
 */

public class Top3Adapter extends FragmentPagerAdapter {
    //Context of the app
    private Context mContext;


    //@param fm is the fragment manager that will keep each fragment's state in the adapter
    //across swipes.
    //@param context is the context of the app.

    public Top3Adapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {

            Bundle bundle = new Bundle();
            bundle.putString("data", "Data you want to send");
            // fragment
            final Top3Fragment obj = new Top3Fragment();
            obj.setArguments(bundle);
            return new Top3Fragment();

        } else if (position == 1) {
            return new SculptureFragment();
        } else if (position == 2) {
            return new WalksFragment();
        } else  {
            return new FavoritesFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }


}
