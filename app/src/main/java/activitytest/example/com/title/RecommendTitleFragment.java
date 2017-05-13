package activitytest.example.com.title;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/2/26 0026.
 */

public class RecommendTitleFragment extends Fragment {
    private boolean isTwoPane;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view=inflater.inflate(R.layout.recommend_title_frag,container,false);
        RecyclerView recommendTitleRecyclerView=(RecyclerView)view.findViewById(R.id.recommend_title_recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recommendTitleRecyclerView.setLayoutManager(layoutManager);
        RecommendAdapter adapter=new RecommendAdapter(getRecommend());
        recommendTitleRecyclerView.setAdapter(adapter);
        return view;
    }

    /**
     * 获取推荐内容由此方法修改
     */
    private List<Recommend> getRecommend(){
        List<Recommend> recommendList=new ArrayList<>();
        for (int i=1;i<=50;i++){
            Recommend recommend=new Recommend();
            recommend.setTitle("这是推荐标题"+i);
            recommend.setContent(getRandomLengthContent("这是推荐内容"+i+"。"));
            recommendList.add(recommend);
        }
        return recommendList;
    }
    private String getRandomLengthContent(String content){
        Random random=new Random();
        int length=random.nextInt(20)+1;
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<length;i++){
            builder.append(content);
        }
        return builder.toString();
    }
    /**
     *
     */
    @Override
    public void onActivityCreated(Bundle saveInstanceState){
        super.onActivityCreated(saveInstanceState);
        if (false){
            isTwoPane=true;//可以找到recommend_content_layout布局时，为双页模式
        }else {
            isTwoPane=false;//找不到recommend_content_layout布局时，为单页模式
        }
    }
    class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.ViewHolder>{
        private List<Recommend> mrecommendList;
        class ViewHolder extends RecyclerView.ViewHolder{
            TextView recommendTitleText;
            public ViewHolder(View view){
                super(view);
                recommendTitleText=(TextView)view.findViewById(R.id.recommend_title);
            }
        }
        public RecommendAdapter(List<Recommend> recommendList){
            mrecommendList=recommendList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend_item,parent,false);
            final ViewHolder holder=new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Recommend recommend=mrecommendList.get(holder.getAdapterPosition());
                    if (false){
                        //如果是双页模式，则刷新NewsContentFragment中的内容
                        RecommendContentFragment recommendContentFragment=(RecommendContentFragment)getFragmentManager().findFragmentById(R.id.recommend_content_fragment);
                        recommendContentFragment.refresh(recommend.getTitle(),recommend.getContent());
                    }else {
                        //如果是单页模式，则直接启动RecommendContentActivity
                        RecommendContentActivity.actionStart(getActivity(),recommend.getTitle(),recommend.getContent());
                    }
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Recommend recommend=mrecommendList.get(position);
            holder.recommendTitleText.setText(recommend.getTitle());
        }

        @Override
        public int getItemCount() {
            return mrecommendList.size();
        }
    }


}
