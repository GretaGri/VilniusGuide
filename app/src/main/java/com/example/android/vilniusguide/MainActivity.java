package com.example.android.vilniusguide;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPagerTop3;
    private int currentPage = 0;
    private ArrayList<Top> top3 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        // Create an adapter that knows which fragment should be shown on each page
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());

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
        // Save the user's current page state
        savedInstanceState.putInt(Utils.STATE_CURRENT_PAGE, currentPage);

        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);


        // Restore state members from saved instance
        currentPage = savedInstanceState.getInt(Utils.STATE_CURRENT_PAGE);
    }

    private void init() {
        top3 = Utils.getTop3(this);

        // Find the view pager that will allow the user to swipe between fragments
        viewPagerTop3 = findViewById(R.id.viewpager_top3);

        // Set the adapter onto the view pager
        viewPagerTop3.setAdapter(new Top3Adapter(MainActivity.this, top3));

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

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        if (menu instanceof MenuBuilder) {
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_application:
                Intent intentAboutApp = new Intent(this, AboutApplicationActivity.class);
                this.startActivity(intentAboutApp);
                return true;
            case R.id.favorites:
                Intent intentFavorites = new Intent(this, FavoritesActivity.class);
                this.startActivity(intentFavorites);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}