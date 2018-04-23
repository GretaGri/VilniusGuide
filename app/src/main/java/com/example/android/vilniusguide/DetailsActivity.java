package com.example.android.vilniusguide;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {
    private int category;
    private int picture;
    private String name;
    private String mapLink;
    private String homeLink;
    private String description;
    private String resources;

    private ImageView itemPicture;
    private TextView heading;
    private ImageButton goTo;
    private ImageButton favorite;
    private TextView officialLink;
    private TextView details;
    private Button more;
    private Button share;
    private boolean favoriteSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        itemPicture = findViewById(R.id.imageView);
        heading = findViewById(R.id.heading);
        goTo = findViewById(R.id.buttonGoToPlace);
        favorite = findViewById(R.id.buttonFavorite);
        officialLink = findViewById(R.id.officialLink);
        details = findViewById(R.id.details);
        more = findViewById(R.id.buttonMore);
        share = findViewById(R.id.buttonShare);

        // Get necessary values from category fragment
        Intent intent = getIntent();
        category = intent.getIntExtra(Utils.CATEGORY, 0);
        picture = intent.getIntExtra(Utils.PICTURE, 0);
        name = intent.getStringExtra(Utils.NAME);
        mapLink = intent.getStringExtra(Utils.MAP_LINK);
        homeLink = intent.getStringExtra(Utils.HOME_LINK);
        description = intent.getStringExtra(Utils.DESCRIPTION);
        resources = intent.getStringExtra(Utils.RESOURCES);
        favoriteSelected = intent.getBooleanExtra(Utils.FAVORITE, false);

        // Set resources
        itemPicture.setImageResource(picture);
        heading.setText(name);

        goTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(mapLink));
                startActivity(i);
            }
        });

        if (!homeLink.equals(getString(R.string.no_link))) {
            officialLink.setVisibility(View.VISIBLE);
            if (category == Utils.SHOPPING || category == Utils.EAT || category == Utils.CINEMA) {
                ;
                Drawable img = this.getResources().getDrawable(R.drawable.ic_call_black_18dp);
                officialLink.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null);
                officialLink.setAutoLinkMask(Linkify.PHONE_NUMBERS);
                officialLink.setText(homeLink);
            } else {
                Drawable img = this.getResources().getDrawable(R.drawable.ic_link_black_18dp);
                officialLink.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null);
                officialLink.setText(Html.fromHtml(homeLink));
                officialLink.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        details.setText(description);

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(resources));
                startActivity(i);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, getString(R.string.email_text) + mapLink);

                startActivity(Intent.createChooser(sharingIntent, getResources().getText(R.string.share)));
            }
        });
        if (favoriteSelected) {
            favorite.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
        }

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!favoriteSelected) {
                    Toast.makeText(DetailsActivity.this, R.string.selected_as_favorite, Toast.LENGTH_SHORT).show();
                    favorite.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
                    favoriteSelected = true;
                    SharedPreferences.Editor editor = DetailsActivity.this.getSharedPreferences(Utils.MY_PREFS_NAME, DetailsActivity.MODE_PRIVATE).edit();
                    editor.putBoolean(name, true);
                    editor.apply();
                } else {
                    Toast.makeText(DetailsActivity.this, R.string.removed_from_favorites, Toast.LENGTH_SHORT).show();
                    favorite.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite_border_black_24dp));
                    favoriteSelected = false;
                    SharedPreferences.Editor editor = DetailsActivity.this.getSharedPreferences(Utils.MY_PREFS_NAME, DetailsActivity.MODE_PRIVATE).edit();
                    editor.putBoolean(name, false);
                    editor.apply();
                }
            }
        });
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
