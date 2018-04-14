package com.example.android.vilniusguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Greta Grigutė on 2018-04-14.
 */

public class CategoryAdapter extends FragmentPagerAdapter {
    //Context of the app
    private Context mContext;


    //@param fm is the fragment manager that will keep each fragment's state in the adapter
    //across swipes.
    //@param context is the context of the app.

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ArchitectureFragment();
        } else if (position == 1) {
            return new SculptureFragment();
        } else if (position == 2) {
            return new WalksFragment();
        } else if (position == 3) {
            return new CinemaFragment();
        } else if (position == 4) {
            return new EatFragment();
        } else if (position == 5) {
            return new ShoppingFragment();
        } else  {
            return new FavoritesFragment();
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
