package activitytest.example.com.title;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/2/26 0026.
 */

public class RecommendContentFragment extends Fragment {
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        view=inflater.inflate(R.layout.recommend_content_frag,container,false);
        return view;
    }
    public void refresh(String recommendTitle,String recommendContent){
        View visibilityLayout=view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView recommendTitleText=(TextView)view.findViewById(R.id.recommend_title);
        TextView reconmmendContentText=(TextView)view.findViewById(R.id.recommend_content);
        recommendTitleText.setText(recommendTitle);//刷新标题
        reconmmendContentText.setText(recommendContent);//刷新内容

    }
}
