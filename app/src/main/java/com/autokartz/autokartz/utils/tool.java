package com.autokartz.autokartz.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by user on 1/3/2018.
 */

public class tool {

    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;

    public static void setSharedPreference(String preference, String value, Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
        editor.putString(preference, value);
        editor.commit();
    }

    public static String getSharedPreference(String preference, Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(preference, null);
    }

    public static void clearAllSharedPreferences(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    public static void removeSharedPreference(String preference, Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
        editor.remove(preference);
        editor.commit();
    }
}
