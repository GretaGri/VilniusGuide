package com.example.android.vilniusguide;

import android.graphics.Movie;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Object> objects = new ArrayList<>();
    private RecyclerView recyclerView;
    private ObjectAdapter mAdapter;
    private TabLayout tabLayoutTop3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        // Create an adapter that knows which fragment should be shown on each page
        Top3Adapter adapterTop3 = new Top3Adapter(this,getSupportFragmentManager());

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPagerTop3 = findViewById(R.id.viewpager_top3);

        // Set the adapter onto the view pager
        viewPagerTop3.setAdapter(adapterTop3);

        // Give the TabLayout the ViewPager
        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
        tabLayoutTop3 = findViewById(R.id.tabs_dots);
        tabLayoutTop3.setupWithViewPager(viewPagerTop3);

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
        setupTabIcons();
    }

    private void setupTabIcons() {
        tabLayoutTop3.getTabAt(0).setIcon(R.drawable.ic_dot_navigation_empty_white_18dp);
        tabLayoutTop3.getTabAt(1).setIcon(R.drawable.ic_dot_navigation_empty_white_18dp);
        tabLayoutTop3.getTabAt(2).setIcon(R.drawable.ic_dot_navigation_empty_white_18dp);
        tabLayoutTop3.setSelectedTabIndicatorColor(getResources().getColor(R.color.tabIndicatorInv));

        tabLayoutTop3.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                tabLayoutTop3.getTabAt(position).setIcon(R.drawable.ic_dot_navigation_full_white_18dp);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                tabLayoutTop3.getTabAt(position).setIcon(R.drawable.ic_dot_navigation_empty_white_18dp);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                tabLayoutTop3.getTabAt(position).setIcon(R.drawable.ic_dot_navigation_full_white_18dp);
            }
        });
    }
}