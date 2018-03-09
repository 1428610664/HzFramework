package com.hz.hzframework.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * ============================================================
 * 
 * 版 权 ： 百变美金 版权所有 (c) 2015
 * 
 * 作 者 : 周章成
 * 
 * 版 本 ： 3.7
 * 
 * 创建日期 ： 2015-4-8 上午11:13:03
 * 
 * 描 述 ：工具类。
 * 	文件存储
 * 
 * 修订历史 ：
 * 
 * ============================================================
 **/
public class PreferencesUtils {

    public static String PREFERENCE_NAME = "jdx";

    /**
     * put string preferences
     * 
     * @param key The name of the preference to modify
     * @param value The new value for the preference
     * @return True if the new values were successfully written to persistent storage.
     */
    public static boolean putString(String key, String value) {
        SharedPreferences settings =  SystemConfig.getContext().getSharedPreferences(PREFERENCE_NAME,  SystemConfig.getContext().MODE_PRIVATE);
        Editor editor = settings.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    /**
     * get string preferences
     * 
     * @param key The name of the preference to retrieve
     * @return The preference value if it exists, or null. Throws ClassCastException if there is a preference with this
     *         name that is not a string
     * @see #getString( SystemConfig.getContext(), String, String)
     */
    public static String getString(String key) {
        return getString( key, null);
    }

    /**
     * get string preferences
     * 
     * @param key The name of the preference to retrieve
     * @param defaultValue Value to return if this preference does not exist
     * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
     *         this name that is not a string
     */
    public static String getString(String key, String defaultValue) {
        SharedPreferences settings =  SystemConfig.getContext().getSharedPreferences(PREFERENCE_NAME,  SystemConfig.getContext().MODE_PRIVATE);
        return settings.getString(key, defaultValue);
    }

    /**
     * put int preferences
     * 
     * @param key The name of the preference to modify
     * @param value The new value for the preference
     * @return True if the new values were successfully written to persistent storage.
     */
    public static boolean putInt(String key, int value) {
        SharedPreferences settings =  SystemConfig.getContext().getSharedPreferences(PREFERENCE_NAME,  SystemConfig.getContext().MODE_PRIVATE);
        Editor editor = settings.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    /**
     * get int preferences
     * 
     * @param key The name of the preference to retrieve
     * @return The preference value if it exists, or -1. Throws ClassCastException if there is a preference with this
     *         name that is not a int
     * @see #getInt( SystemConfig.getContext(), String, int)
     */
    public static int getInt(String key) {
        return getInt( key, 0);
    }

    /**
     * get int preferences
     * 
     * @param key The name of the preference to retrieve
     * @param defaultValue Value to return if this preference does not exist
     * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
     *         this name that is not a int
     */
    public static int getInt(String key, int defaultValue) {
        SharedPreferences settings =  SystemConfig.getContext().getSharedPreferences(PREFERENCE_NAME,  SystemConfig.getContext().MODE_PRIVATE);
        return settings.getInt(key, defaultValue);
    }

    /**
     * put long preferences
     * 
     * @param key The name of the preference to modify
     * @param value The new value for the preference
     * @return True if the new values were successfully written to persistent storage.
     */
    public static boolean putLong(String key, long value) {
        SharedPreferences settings =  SystemConfig.getContext().getSharedPreferences(PREFERENCE_NAME,  SystemConfig.getContext().MODE_PRIVATE);
        Editor editor = settings.edit();
        editor.putLong(key, value);
        return editor.commit();
    }

    /**
     * get long preferences
     * 
     * @param key The name of the preference to retrieve
     * @return The preference value if it exists, or -1. Throws ClassCastException if there is a preference with this
     *         name that is not a long
     * @see #getLong( SystemConfig.getContext(), String, long)
     */
    public static long getLong( String key) {
        return getLong(  key, -1);
    }

    /**
     * get long preferences
     * 
     * @param key The name of the preference to retrieve
     * @param defaultValue Value to return if this preference does not exist
     * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
     *         this name that is not a long
     */
    public static long getLong(String key, long defaultValue) {
        SharedPreferences settings =  SystemConfig.getContext().getSharedPreferences(PREFERENCE_NAME,  SystemConfig.getContext().MODE_PRIVATE);
        return settings.getLong(key, defaultValue);
    }

    /**
     * put float preferences
     * 
     * @param key The name of the preference to modify
     * @param value The new value for the preference
     * @return True if the new values were successfully written to persistent storage.
     */
    public static boolean putFloat(String key, float value) {
        SharedPreferences settings =  SystemConfig.getContext().getSharedPreferences(PREFERENCE_NAME,  SystemConfig.getContext().MODE_PRIVATE);
        Editor editor = settings.edit();
        editor.putFloat(key, value);
        return editor.commit();
    }

    /**
     * get float preferences
     * 
     * @param key The name of the preference to retrieve
     * @return The preference value if it exists, or -1. Throws ClassCastException if there is a preference with this
     *         name that is not a float
     * @see #getFloat( SystemConfig.getContext(), String, float)
     */
    public static float getFloat(  String key) {
        return getFloat(  key, -1);
    }

    /**
     * get float preferences
     * 
     * @param defaultValue Value to return if this preference does not exist
     * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
     *         this name that is not a float
     */
    public static float getFloat(String key, float defaultValue) {
        SharedPreferences settings =  SystemConfig.getContext().getSharedPreferences(PREFERENCE_NAME,  SystemConfig.getContext().MODE_PRIVATE);
        return settings.getFloat(key, defaultValue);
    }

    /**
     * put boolean preferences
     * 
     * @param key The name of the preference to modify
     * @param value The new value for the preference
     * @return True if the new values were successfully written to persistent storage.
     */
    public static boolean putBoolean(String key, boolean value) {
        SharedPreferences settings =  SystemConfig.getContext().getSharedPreferences(PREFERENCE_NAME,  SystemConfig.getContext().MODE_PRIVATE);
        Editor editor = settings.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    /**
     * get boolean preferences, default is false
     * 
     * @param key The name of the preference to retrieve
     * @return The preference value if it exists, or false. Throws ClassCastException if there is a preference with this
     *         name that is not a boolean
     * @see #getBoolean( SystemConfig.getContext(), String, boolean)
     */
    public static boolean getBoolean(  String key) {
        return getBoolean(  key, false);
    }

    /**
     * get boolean preferences
     * 
     * @param key The name of the preference to retrieve
     * @param defaultValue Value to return if this preference does not exist
     * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
     *         this name that is not a boolean
     */
    public static boolean getBoolean(String key, boolean defaultValue) {
        SharedPreferences settings =  SystemConfig.getContext().getSharedPreferences(PREFERENCE_NAME,  SystemConfig.getContext().MODE_PRIVATE);
        return settings.getBoolean(key, defaultValue);
    }
    
    public static void clearData(){
    	SharedPreferences settings =  SystemConfig.getContext().getSharedPreferences(PREFERENCE_NAME,  SystemConfig.getContext().MODE_PRIVATE);
    	Editor edit = settings.edit();
    	edit.clear();
    	edit.commit();
    }
}
