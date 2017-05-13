package activitytest.example.com.title.Fragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import activitytest.example.com.title.R;

/**
 * Created by Administrator on 2017/4/27 0027.
 */

public class SettingsFragment extends PreferenceFragment{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.addPreferencesFromResource(R.xml.preferences);

    }

}
