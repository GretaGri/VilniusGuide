package com.example.android.vilniusguide;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ObjectFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private ObjectAdapter mAdapter;
    private List<Object> objectList = new ArrayList<>();
    private List<Object> mArchitectureObjectList = new ArrayList<>();
    private List<Object> mSculptureObjectList = new ArrayList<>();
    private List<Object> mWalksObjectList = new ArrayList<>();
    private List<Object> mCinemaObjectList = new ArrayList<>();
    private List<Object> mEatObjectList = new ArrayList<>();
    private List<Object> mShoppingObjectList = new ArrayList<>();
    private List<Object> mFavoritesList = new ArrayList<>();
    private int mPosition;

    public ObjectFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        objectList = Utils.getObjects(getContext());
        for (int position = 0; position < objectList.size();position++) {
            if (objectList.get(position).getCategory() == Utils.ARCHITECTURE) {
                mArchitectureObjectList.add(objectList.get(position));
            }
            else if (objectList.get(position).getCategory()==Utils.SCULPTURE){
                mSculptureObjectList.add(objectList.get(position));
            }
            else if (objectList.get(position).getCategory()==Utils.WALKS){
                mWalksObjectList.add(objectList.get(position));
            }
            else if (objectList.get(position).getCategory()==Utils.CINEMA){
                mCinemaObjectList.add(objectList.get(position));
            }
            else if (objectList.get(position).getCategory()==Utils.EAT){
                mEatObjectList.add(objectList.get(position));
            }
            else if (objectList.get(position).getCategory()==Utils.SHOPPING){
                mShoppingObjectList.add(objectList.get(position));
            }
        }
        for (int position = 0; position < objectList.size();position++) {
            if (objectList.get(position).getFavorite() == Utils.FAVORITE_STATE_TRUE) {
                mFavoritesList.add(objectList.get(position));
            }
            if (objectList.get(position).getFavorite() == Utils.FAVORITE_STATE_FALSE) {
                mFavoritesList.remove(objectList.get(position));
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recycler_view, container, false);
        mRecyclerView = rootView.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mPosition = getArguments().getInt("position");
        if (mPosition == 0) {
            objectList = mArchitectureObjectList;
        } else if (mPosition == 1) {
            objectList = mSculptureObjectList;
        } else if (mPosition == 2) {
            objectList = mWalksObjectList;
        } else if (mPosition == 3) {
            objectList = mCinemaObjectList;
        } else if (mPosition == 4) {
            objectList = mEatObjectList;
        } else if (mPosition == 5) {
            objectList = mShoppingObjectList;
        } else if (mPosition == 6) {
            objectList = mFavoritesList;
        }
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new ObjectAdapter(objectList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), mRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getActivity(),DetailsActivity.class);
                intent.putExtra("position",position);
                intent.putExtra("category",objectList.get(position).getCategory());
                intent.putExtra("picture",objectList.get(position).getPictureDescription());
                intent.putExtra("name", objectList.get(position).getName());
                intent.putExtra("mapLink",objectList.get(position).getMapLink());
                intent.putExtra("homeLink",objectList.get(position).getHomeLink());
                intent.putExtra("description",objectList.get(position).getDescription());
                intent.putExtra("resources",objectList.get(position).getResources());
                intent.putExtra("favorite",objectList.get(position).getFavorite());
               startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(getContext(), "Long click", Toast.LENGTH_SHORT).show();
                if (objectList.get(position).getFavorite() == Utils.FAVORITE_STATE_FALSE) {
                    objectList.get(position).setFavorite(Utils.FAVORITE_STATE_TRUE);
                    mAdapter.notifyDataSetChanged();
                } else {
                objectList.get(position).setFavorite(Utils.FAVORITE_STATE_FALSE);
                    for (int i = 0; i < objectList.size();i++) {
                        if (objectList.get(i).getFavorite() == Utils.FAVORITE_STATE_FALSE) {
                            mFavoritesList.remove(objectList.get(position));
                            mAdapter.notifyDataSetChanged();
                        }
                    }
            } }
        }));
        if (mFavoritesList.size() > 0) {
            SharedPreferences.Editor editor = getActivity().getSharedPreferences(Utils.MY_PREFS_NAME, getContext().MODE_PRIVATE).edit();
            editor.putInt("favorites", 1);
            editor.commit();
        }
        else {
            SharedPreferences.Editor editor = getActivity().getSharedPreferences(Utils.MY_PREFS_NAME, getContext().MODE_PRIVATE).edit();
        editor.putInt("favorites", 0);
        editor.commit();}

        return rootView ;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the current objectList

        super.onSaveInstanceState(savedInstanceState);
    }

}
