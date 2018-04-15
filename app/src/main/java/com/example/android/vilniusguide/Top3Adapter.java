package com.example.android.vilniusguide;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.*;
import java.lang.Object;
import java.util.ArrayList;

/**
 * Created by Greta Grigutė on 2018-04-14.
 */

public class Top3Adapter extends PagerAdapter {

    private ArrayList<Top> top3;
    private LayoutInflater inflater;
    private Context mContext;

    //@param context is the context of the app.

    public Top3Adapter(Context context, ArrayList <Top> top3) {
        this.mContext = context;
        this.top3 = top3;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
    @Override
    public int getCount() {
        return top3.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View myImageLayout = inflater.inflate(R.layout.slide_top3, container, false);
        ImageView myImage =  myImageLayout.findViewById(R.id.imageDescription);
        myImage.setImageResource(top3.get(position).getPictureDescription());
        container.addView(myImageLayout, position);
        TextView place = myImageLayout.findViewById(R.id.place_name);
        place.setText(top3.get(position).getPlace());
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
