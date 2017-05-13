package activitytest.example.com.title;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Created by Administrator on 2017/2/26 0026.
 */

public class RecommendContentActivity extends AppCompatActivity {
    public static void actionStart(Context context,String recommendTitle,String recommendContent){
        Intent intent=new Intent(context,RecommendContentActivity.class);
        intent.putExtra("recommend_title",recommendTitle);
        intent.putExtra("recommend_content",recommendContent);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.recommend_content);
        String recommendTitle=getIntent().getStringExtra("recommend_title");//获取传入的推荐标题
        String recommendContent=getIntent().getStringExtra("recommend_content");//获取传入的推荐内容
        RecommendContentFragment recommendContentFragment=(RecommendContentFragment)getFragmentManager().findFragmentById(R.id.recommend_content_fragment);
        recommendContentFragment.refresh(recommendTitle,recommendContent);//刷新RecommendContentFragment界面
    }
}
