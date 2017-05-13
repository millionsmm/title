package activitytest.example.com.title.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import activitytest.example.com.title.R;

/**
 * Created by Administrator on 2017/4/15 0015.
 */

public class ShoppingFragment extends android.support.v4.app.Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.shopping_fragment,container,false);
        return view;
    }
}
