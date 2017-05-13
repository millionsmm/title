package activitytest.example.com.title.Activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import activitytest.example.com.title.Fragment.SettingsFragment;



public class SettingsActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getFragmentManager().beginTransaction().replace(android.R.id.content,new SettingsFragment()).commit();





    }





}
