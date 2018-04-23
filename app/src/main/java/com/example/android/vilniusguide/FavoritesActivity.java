package com.example.android.vilniusguide;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FavoritesActivity extends AppCompatActivity {
    boolean favorite;
    private RecyclerView mRecyclerView;
    private ObjectAdapter mAdapter;
    private List<Object> objectList = new ArrayList<>();
    private List<Object> mFavoritesList = new ArrayList<>();
    private TextView mNoFavorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorites_empty);

        mNoFavorites = findViewById(R.id.no_favorites);
        mRecyclerView = findViewById(R.id.recycler_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        objectList = Utils.getObjects(this);

        for (int position = 0; position < objectList.size(); position++) {
            SharedPreferences prefs = this.getSharedPreferences(Utils.MY_PREFS_NAME, FavoritesActivity.MODE_PRIVATE);
            favorite = prefs.getBoolean(objectList.get(position).getName(), false);
            objectList.get(position).setFavorite(favorite);
        }

        for (int position = 0; position < objectList.size(); position++) {
            if (objectList.get(position).getFavorite() == Utils.FAVORITE_STATE_TRUE) {
                mFavoritesList.add(objectList.get(position));
            }
            if (objectList.get(position).getFavorite() == Utils.FAVORITE_STATE_FALSE) {
                mFavoritesList.remove(objectList.get(position));
            }
        }

        objectList = mFavoritesList;

        if (objectList.size() > 0) {
            mNoFavorites.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);

            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());
            mAdapter = new ObjectAdapter(objectList);
            mRecyclerView.setAdapter(mAdapter);
            mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, mRecyclerView, new RecyclerTouchListener.ClickListener() {
                @Override
                public void onClick(View view, int position) {
                    Intent intent = new Intent(FavoritesActivity.this, DetailsActivity.class);
                    intent.putExtra(Utils.CATEGORY, objectList.get(position).getCategory());
                    intent.putExtra(Utils.PICTURE, objectList.get(position).getPictureDescription());
                    intent.putExtra(Utils.NAME, objectList.get(position).getName());
                    intent.putExtra(Utils.MAP_LINK, objectList.get(position).getMapLink());
                    intent.putExtra(Utils.HOME_LINK, objectList.get(position).getHomeLink());
                    intent.putExtra(Utils.DESCRIPTION, objectList.get(position).getDescription());
                    intent.putExtra(Utils.RESOURCES, objectList.get(position).getResources());
                    intent.putExtra(Utils.FAVORITE, objectList.get(position).getFavorite());
                    startActivity(intent);
                }

                @Override
                public void onLongClick(View view, int position) {
                    Toast.makeText(FavoritesActivity.this, R.string.removed_from_favorites, Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = FavoritesActivity.this.getSharedPreferences(Utils.MY_PREFS_NAME, FavoritesActivity.MODE_PRIVATE).edit();
                    editor.putBoolean(objectList.get(position).getName(), false);
                    editor.apply();
                    mFavoritesList.remove(objectList.get(position));
                    mAdapter.notifyDataSetChanged();
                    //Put the state of the object removed as favorite in shared pref.
                    if (mFavoritesList.size() == 0) {
                        mRecyclerView.setVisibility(View.GONE);
                        mNoFavorites.setVisibility(View.VISIBLE);
                    }
                }
            }));
        } else {
            mRecyclerView.setVisibility(View.GONE);
            mNoFavorites.setVisibility(View.VISIBLE);
        }
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