package com.example.android.vilniusguide;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Greta Grigutė on 2018-04-16.
 */

public class Utils {
    // For saving instance state
    public static final String STATE_CURRENT_PAGE = "currentPage";

    //For describing category
    private static final int ARCHITECTURE = 1;
    private static final int SCULPTURE = 2;
    private static final int WALKS = 3;
    private static final int CINEMA = 4;
    private static final int EAT = 5;
    private static final int SHOPPING = 6;

    //Arraylist for top3 objects
    public static final ArrayList<Top> top3 = new ArrayList<>();
    //Create a string ArrayList with all objects.
    public static final ArrayList<Object> objects = new ArrayList<>();
    // Create a list of top 3 objects

    public static ArrayList<Top> getTop3(Context context) {
        if (top3.size() == 0)
            Top3Data(context);
        return top3;
    }

    private static void Top3Data(Context context) {
        top3.add(new Top(context.getString(R.string.arch_object_name_1), R.drawable.arch_1_cathedral_des_bw));
        top3.add(new Top(context.getString(R.string.arch_object_name_2), R.drawable.arch_2_sts_bartholomews_church_des_bw));
        top3.add(new Top(context.getString(R.string.arch_object_name_3), R.drawable.arch_3_bernardine_church1_des_bw));
    }

    public static ArrayList<Object> getObjects(Context context) {
        if (objects.size() == 0)
            ObjectData(context);
        return objects;
    }

    private static void ObjectData(Context context) {
        objects.add(new Object(ARCHITECTURE,
                context.getString(R.string.arch_object_name_1),
                context.getString(R.string.arch_place_1),
                R.drawable.arch_1_cathedral_des_bw,
                context.getString(R.string.arch_official_link_1),
                context.getString(R.string.arch_description_1),
                context.getString(R.string.arch_resources_1),
                context.getString(R.string.arch_google_link_1),
                R.drawable.arch_1_cathedral_des_bw));
        objects.add(new Object(ARCHITECTURE,
                context.getString(R.string.arch_object_name_2),
                context.getString(R.string.arch_place_2),
                R.drawable.arch_2_sts_bartholomews_church_des_bw,
                context.getString(R.string.no_link),
                context.getString(R.string.arch_description_2),
                context.getString(R.string.arch_resources_2),
                context.getString(R.string.arch_google_link_2),
                R.drawable.arch_2_sts_bartholomews_church_des_bw));
        objects.add(new Object(ARCHITECTURE,
                context.getString(R.string.arch_object_name_3),
                context.getString(R.string.arch_place_3),
                R.drawable.arch_3_bernardine_church1_des_bw,
                context.getString(R.string.arch_official_link_3),
                context.getString(R.string.arch_description_3),
                context.getString(R.string.arch_resources_3),
                context.getString(R.string.arch_google_link_3),
                R.drawable.arch_3_bernardine_church1_des_bw));
        objects.add(new Object(ARCHITECTURE,
                context.getString(R.string.arch_object_name_4),
                context.getString(R.string.arch_place_4),
                R.drawable.arch_4_jonu_church_des_bw,
                context.getString(R.string.arch_official_link_4),
                context.getString(R.string.arch_description_4),
                context.getString(R.string.arch_resources_4),
                context.getString(R.string.arch_google_link_4),
                R.drawable.arch_4_jonu_church_des_bw));
        objects.add(new Object(ARCHITECTURE,
                context.getString(R.string.arch_object_name_5),
                context.getString(R.string.arch_place_5),
                R.drawable.arch_5_annas_church_des_bw,
                context.getString(R.string.arch_official_link_5),
                context.getString(R.string.arch_description_5),
                context.getString(R.string.arch_resources_5),
                context.getString(R.string.arch_google_link_5),
                R.drawable.arch_5_annas_church_des_bw));
        objects.add(new Object(ARCHITECTURE,
                context.getString(R.string.arch_object_name_6),
                context.getString(R.string.arch_place_6),
                R.drawable.arch_1_cathedral_des_bw,
                context.getString(R.string.arch_official_link_6),
                context.getString(R.string.arch_description_6),
                context.getString(R.string.arch_resources_6),
                context.getString(R.string.arch_google_link_6),
                R.drawable.arch_1_cathedral_des_bw));
        objects.add(new Object(ARCHITECTURE,
                context.getString(R.string.arch_object_name_7),
                context.getString(R.string.arch_place_7),
                R.drawable.arch_7_russian_church_des_bw,
                context.getString(R.string.no_link),
                context.getString(R.string.arch_description_7),
                context.getString(R.string.arch_resources_7),
                context.getString(R.string.arch_google_link_7),
                R.drawable.arch_7_russian_church_des_bw));
        objects.add(new Object(ARCHITECTURE,
                context.getString(R.string.arch_object_name_8),
                context.getString(R.string.arch_place_8),
                R.drawable.arch_8_grand_dukes_palace_des_bw,
                context.getString(R.string.arch_official_link_8),
                context.getString(R.string.arch_description_8),
                context.getString(R.string.arch_resources_8),
                context.getString(R.string.arch_google_link_8),
                R.drawable.arch_8_grand_dukes_palace_des_bw));
        objects.add(new Object(ARCHITECTURE,
                context.getString(R.string.arch_object_name_9),
                context.getString(R.string.arch_place_9),
                R.drawable.arch_9_town_hall_des_bw,
                context.getString(R.string.arch_official_link_9),
                context.getString(R.string.arch_description_9),
                context.getString(R.string.arch_resources_9),
                context.getString(R.string.arch_google_link_9),
                R.drawable.arch_9_town_hall_des_bw));
        objects.add(new Object(ARCHITECTURE,
                context.getString(R.string.arch_object_name_10),
                context.getString(R.string.arch_place_10),
                R.drawable.arch_10_bastion_des_bw,
                context.getString(R.string.arch_official_link_10),
                context.getString(R.string.arch_description_10),
                context.getString(R.string.arch_resources_10),
                context.getString(R.string.arch_google_link_10),
                R.drawable.arch_10_bastion_des_bw));

    }
}


