package com.amritha.acadgild.android_session12_assignment1;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private static int prefs = R.xml.preferences;//storing the preferencex xml in integer

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            getClass().getMethod("getFragmentManager");
            AddResourceApi11AndGreater();
        } catch (NoSuchMethodException e) {
        }

    }


    @TargetApi(11)
    protected void AddResourceApi11AndGreater() {
        getFragmentManager().beginTransaction().replace(android.R.id.content,
                new PF()).commit();//Getting the fragment Manager and Committing
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

    }

    @TargetApi(11)
    public static class PF extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(SettingsActivity.prefs); //outer class
            // private members seem to be visible for inner class, and
            // making it static made things so much easier

        }

        @Override
        public void onResume() {
            super.onResume();
            getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);//registering shared preferences

        }

        @Override
        public void onPause() {
            getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
            super.onPause();//unregister shared preferences
        }

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            Log.e("key= ", key);//getting the key
            Toast.makeText(getActivity(), key + "  is changed. ", Toast.LENGTH_LONG).show();
        }
    }
}
