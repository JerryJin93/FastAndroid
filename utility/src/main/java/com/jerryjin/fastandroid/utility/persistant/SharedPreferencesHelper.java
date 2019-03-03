package com.jerryjin.fastandroid.utility.persistant;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.jerryjin.fastandroid.utility.text.StringMan;

import java.lang.ref.WeakReference;
import java.util.Set;

public class SharedPreferencesHelper {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private WeakReference<Context> contextWeakReference;

    private SharedPreferencesHelper() {

    }

    public static SharedPreferencesHelper getInstance(Context context) {
        SharedPreferencesHelperHolder.instance.initContext(context);
        return SharedPreferencesHelperHolder.instance;
    }

    public SharedPreferencesHelper with(String fileName) {
        Context context = contextWeakReference.get();
        if (context != null) {
            initSharedPreferences(context, fileName);
        }
        return this;
    }

    private void initContext(Context context) {
        contextWeakReference = new WeakReference<>(context);
    }

    private void initSharedPreferences(Context context, String fileName) {
        sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    public SharedPreferencesHelper putBoolean(String key, boolean value) {
        validateEditor();
        editor
                .putBoolean(key, value)
                .apply();
        return this;
    }

    public SharedPreferencesHelper putInt(String key, int value) {
        validateEditor();
        editor
                .putInt(key, value)
                .apply();
        return this;
    }

    public int[] getInts(String[] keys) {
        validateEditor();
        int[] values = new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            values[i] = sharedPreferences.getInt(keys[i], 0);
        }
        return values;
    }

    public SharedPreferencesHelper putInts(IRandomKeys randomKeys, int... values) {
        String[] keys = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            keys[i] = StringMan.getRandomString(5);
        }
        for (int i = 0; i < values.length; i++) {
            putInt(keys[i], values[i]);
        }
        if (randomKeys != null) {
            randomKeys.onSaved(keys);
        }
        return this;
    }

    public SharedPreferencesHelper putLong(String key, long value) {
        validateEditor();
        editor
                .putLong(key, value)
                .apply();
        return this;
    }

    public SharedPreferencesHelper putString(String key, String value) {
        validateEditor();
        editor
                .putString(key, value)
                .apply();
        return this;
    }

    public SharedPreferencesHelper putStringSet(String key, Set<String> values) {
        validateEditor();
        editor
                .putStringSet(key, values)
                .apply();
        return this;
    }

    public SharedPreferencesHelper remove(String key) {
        validateEditor();
        editor
                .remove(key)
                .apply();
        return this;
    }

    @SuppressLint("CommitPrefEdits")
    private void validateEditor() {
        if (editor == null) {
            editor = sharedPreferences.edit();
        }
    }

    public interface IRandomKeys {
        void onSaved(String[] keys);
    }

    private static class SharedPreferencesHelperHolder {
        private static final SharedPreferencesHelper instance = new SharedPreferencesHelper();
    }
}
