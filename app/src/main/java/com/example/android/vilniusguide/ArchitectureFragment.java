package com.example.android.vilniusguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArchitectureFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private ObjectAdapter mAdapter;
    private List<Object> objectList = new ArrayList<>();
    private List<Object> mArchitectureObjectList = new ArrayList<>();
    private List<Object> mSculptureObjectList = new ArrayList<>();
    private List<Object> mWalksObjectList = new ArrayList<>();
    private List<Object> mCinemaObjectList = new ArrayList<>();
    private List<Object> mEatObjectList = new ArrayList<>();
    private List<Object> mShoppingObjectList = new ArrayList<>();
    private int mPosition;

    public ArchitectureFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recycler_view, container, false);
        mRecyclerView = rootView.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
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
        }

        mAdapter = new ObjectAdapter(objectList);
        mRecyclerView.setAdapter(mAdapter);
        return rootView ;
    }
//    private void prepareObjectListData() {
 //   objectList = Utils.getObjects(getContext());
/*
    private void getCategoryList(){
    for (int position = 0; position < objectList.size();position++){
        if (objectList.get(position).getCategory()==Utils.ARCHITECTURE){
            mArchitectureObjectList.add(objectList.get(position));
            objectList = mArchitectureObjectList;
        }
        else if (objectList.get(position).getCategory()==Utils.SCULPTURE){
          mSculptureObjectList.add(objectList.get(position));
          objectList = mSculptureObjectList;
        }
        else if (objectList.get(position).getCategory()==Utils.CINEMA){
            mWalksObjectList.add(objectList.get(position));
            objectList = mCinemaObjectList;
        }
        else if (objectList.get(position).getCategory()==Utils.CINEMA){
            mCinemaObjectList.add(objectList.get(position));
            objectList = mCinemaObjectList;
        }
        else if (objectList.get(position).getCategory()==Utils.EAT){
            mEatObjectList.add(objectList.get(position));
            objectList = mEatObjectList;
        }
        else if (objectList.get(position).getCategory()==Utils.SHOPPING){
            mShoppingObjectList.add(objectList.get(position));
            objectList = mShoppingObjectList;
        }
    }
 */    //   mAdapter.notifyDataSetChanged();
    }

