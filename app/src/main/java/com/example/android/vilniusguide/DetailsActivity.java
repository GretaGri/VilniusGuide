package com.example.android.vilniusguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

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
        picture = intent.getIntExtra("picture", 0);
        name = intent.getStringExtra("name");
        mapLink = intent.getStringExtra("mapLink");
        homeLink = intent.getStringExtra("homeLink");
        description = intent.getStringExtra("description");
        resources = intent.getStringExtra("resources");

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

        if (!homeLink.equals(getString(R.string.no_link))){
            officialLink.setVisibility(View.VISIBLE);
            officialLink.setText(Html.fromHtml(homeLink));
            officialLink.setMovementMethod(LinkMovementMethod.getInstance());
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

            }
        });
    }
}
