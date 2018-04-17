package com.example.android.vilniusguide;


import android.graphics.Movie;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArchitectureFragment extends Fragment {
    private RecyclerView recyclerView;
    private ObjectAdapter mAdapter;
    private List<Object> objectList = new ArrayList<>();
 //   private boolean objectListPrepared = false;

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
        recyclerView = rootView.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        objectList = Utils.getObjects(getContext());
        mAdapter = new ObjectAdapter(objectList);
        recyclerView.setAdapter(mAdapter);
        prepareObjectListData();
        return rootView ;
    }
    private void prepareObjectListData() {
    objectList = Utils.getObjects(getContext());
        mAdapter.notifyDataSetChanged();
    }
}
