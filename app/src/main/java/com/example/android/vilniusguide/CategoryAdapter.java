package com.example.android.vilniusguide;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Greta Grigutė on 2018-04-14.
 */

public class CategoryAdapter extends FragmentPagerAdapter {
    //Context of the app
    private Context mContext;
    private Bundle mBundle;
    private Fragment mFragment;


    //@param fm is the fragment manager that will keep each fragment's state in the adapter
    //across swipes.
    //@param context is the context of the app.

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
           switch (position){
            case 0:
                mBundle = new Bundle();
                mBundle.putInt("position",0);
                mFragment = new ObjectFragment();
                mFragment.setArguments(mBundle);
                return mFragment;
            case 1:
                mBundle = new Bundle();
                mBundle.putInt("position",1);
                mFragment = new ObjectFragment();
                mFragment.setArguments(mBundle);
                return mFragment;
            case 2:
                mBundle = new Bundle();
                mBundle.putInt("position",2);
                mFragment = new ObjectFragment();
                mFragment.setArguments(mBundle);
                return mFragment;
            case 3:
                mBundle = new Bundle();
                mBundle.putInt("position",3);
                mFragment = new ObjectFragment();
                mFragment.setArguments(mBundle);
                return mFragment;
            case 4:
                mBundle = new Bundle();
                mBundle.putInt("position",4);
                mFragment = new ObjectFragment();
                mFragment.setArguments(mBundle);
                return mFragment;
            case 5:
                mBundle = new Bundle();
                mBundle.putInt("position",5);
                mFragment = new ObjectFragment();
                mFragment.setArguments(mBundle);
                return mFragment;
            case 6:
                mBundle = new Bundle();
                mBundle.putInt("position",6);
                int favorite;
                SharedPreferences prefs = mContext.getSharedPreferences(Utils.MY_PREFS_NAME, mContext.MODE_PRIVATE);
                favorite = prefs.getInt("favorites", 0); //0 is the default value.

                if (favorite==0){mFragment = new FavoritesFragment();
                }
                else {mFragment = new ObjectFragment();
                    mFragment.setArguments(mBundle);}
                return mFragment;

// Supply a default return statement
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 7;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        String tabTitles[] = new String[] { mContext.getString(R.string.category_name_arch),
                mContext.getString(R.string.category_name_sculpt),
                mContext.getString(R.string.category_name_walks),
                mContext.getString(R.string.category_name_cinema),
                mContext.getString(R.string.category_name_eat),
                mContext.getString(R.string.category_name_shop),
                mContext.getString(R.string.category_name_favour),
        };
        return tabTitles[position];
    }
}
