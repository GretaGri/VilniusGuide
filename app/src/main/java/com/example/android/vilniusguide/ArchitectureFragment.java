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

    public ArchitectureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recycler_view, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view);

        mAdapter = new ObjectAdapter(objectList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareObjectListData();

        return rootView ;
    }
    private void prepareObjectListData() {
        Object object = new Object(getString(R.string.arch_object_name_1),
                getString(R.string.arch_place_1), R.drawable.arch_kathedral_des_bw,
                getString(R.string.arch_official_link_1), getString(R.string.arch_description_1),
                getString(R.string.arch_resources_1), getString(R.string.arch_google_link_1),
                R.drawable.arch_kathedral_des_bw);
        objectList.add(object);

        object = new Object(getString(R.string.arch_object_name_1),
                getString(R.string.arch_place_1), R.drawable.arch_kathedral_des_bw,
                getString(R.string.arch_official_link_1), getString(R.string.arch_description_1),
                getString(R.string.arch_resources_1), getString(R.string.arch_google_link_1),
                R.drawable.arch_kathedral_des_bw);
        objectList.add(object);

        object = new Object(getString(R.string.arch_object_name_1),
                getString(R.string.arch_place_1), R.drawable.arch_kathedral_des_bw,
                getString(R.string.arch_official_link_1), getString(R.string.arch_description_1),
                getString(R.string.arch_resources_1), getString(R.string.arch_google_link_1),
                R.drawable.arch_kathedral_des_bw);
        objectList.add(object);

        object = new Object(getString(R.string.arch_object_name_1),
                getString(R.string.arch_place_1), R.drawable.arch_kathedral_des_bw,
                getString(R.string.arch_official_link_1), getString(R.string.arch_description_1),
                getString(R.string.arch_resources_1), getString(R.string.arch_google_link_1),
                R.drawable.arch_kathedral_des_bw);
        objectList.add(object);

        object = new Object(getString(R.string.arch_object_name_1),
                getString(R.string.arch_place_1), R.drawable.arch_kathedral_des_bw,
                getString(R.string.arch_official_link_1), getString(R.string.arch_description_1),
                getString(R.string.arch_resources_1), getString(R.string.arch_google_link_1),
                R.drawable.arch_kathedral_des_bw);
        objectList.add(object);

        mAdapter.notifyDataSetChanged();
    }
}
