package com.example.android.vilniusguide;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPagerTop3 ;
    private int currentPage = 0;
    static final String STATE_CURRENT_PAGE = "currentPage";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        // Create an adapter that knows which fragment should be shown on each page
        CategoryAdapter adapter = new CategoryAdapter(this,getSupportFragmentManager());

        //Create a string ArrayList with ten words numbers from 1 to 10 with english and miwok translations.
        final ArrayList<Object> objects = new ArrayList<>();
        objects.add(new Object(getString(R.string.arch_object_name_1),
                getString(R.string.arch_place_1), R.drawable.arch_kathedral_des_bw,
                getString(R.string.arch_official_link_1), getString(R.string.arch_description_1),
                getString(R.string.arch_resources_1), getString(R.string.arch_google_link_1),
                R.drawable.arch_kathedral_des_bw));

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.viewpager);

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
        TabLayout tabLayout = findViewById(R.id.tabs_navigation);
        tabLayout.setupWithViewPager(viewPager);

        init();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(STATE_CURRENT_PAGE, currentPage);

        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);


        // Restore state members from saved instance
        currentPage = savedInstanceState.getInt(STATE_CURRENT_PAGE);
    }

    private void init() {
final ArrayList <Top> top3 = new ArrayList<>();
        top3.add(new Top((getString(R.string.arch_object_name_1)),R.drawable.arch_kathedral_des_bw));
        top3.add(new Top((getString(R.string.arch_object_name_2)),R.drawable.arch_kathedral_des_bw));
        top3.add(new Top((getString(R.string.arch_object_name_3)),R.drawable.arch_kathedral_des_bw));


        // Find the view pager that will allow the user to swipe between fragments
        viewPagerTop3 = findViewById(R.id.viewpager_top3);

        // Set the adapter onto the view pager
        viewPagerTop3.setAdapter(new Top3Adapter(MainActivity.this,top3));

        CircleIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(viewPagerTop3);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                viewPagerTop3.setCurrentItem(currentPage++, true);
                if (currentPage == top3.size()) {
                    currentPage = 0;
                }
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 4500);
    }

}