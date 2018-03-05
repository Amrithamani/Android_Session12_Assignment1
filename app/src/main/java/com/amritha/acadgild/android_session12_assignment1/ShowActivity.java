package com.amritha.acadgild.android_session12_assignment1;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);//getting the layout


        /**
         * Getting the references to the textview object of the show layout
         */
        TextView tv_edittext_preference1 = (TextView) findViewById(R.id.tv_edittext_preference1);

        TextView tv_edittext_preference2 = (TextView) findViewById(R.id.tv_edittext_preference2);

        TextView tv_checkbox_preference = (TextView) findViewById(R.id.tv_checkbox_preference);

        TextView tv_listview_preference = (TextView) findViewById(R.id.tv_listview_preference);


        /**
         * Getting the shared preference object that points to preferences resource available in this context
         */

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        /**
         * Getting the values stored in the shared object via preference activity
         */
        String username = sp.getString("etp_edittext_preference1", "No text data");
        String password = sp.getString("etp_edittext_preference2", "No text data");

        Boolean checkbox = sp.getBoolean("cbp_checkbox_preference", true);

        String list = sp.getString("lp_list_preference", "None Selected");

        /** Setting the values on textview objects to display in the ShowActivity */

        tv_edittext_preference1.setText("UserName Preference: " + username);

        tv_edittext_preference2.setText("Password Preference: " + password);

        tv_checkbox_preference.setText("CheckBox Preference " + Boolean.toString(checkbox));

        tv_listview_preference.setText("List Preference " + list);

    }
}
