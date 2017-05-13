package activitytest.example.com.title.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import activitytest.example.com.title.Activity.CollectActivity;
import activitytest.example.com.title.Activity.MessageActivity;
import activitytest.example.com.title.Activity.MyCareActivity;
import activitytest.example.com.title.Activity.MyThemeActivity;
import activitytest.example.com.title.Activity.SignActivity;
import activitytest.example.com.title.Activity.SettingsActivity;
import activitytest.example.com.title.Adapter.ChooseAdapter;
import activitytest.example.com.title.R;
import activitytest.example.com.title.shitilei.Choose;

/**
 * Created by Administrator on 2017/4/15 0015.
 */

public class PersonalFragment extends android.support.v4.app.Fragment {
    private List<Choose> chooseList=new ArrayList<>();
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.personal_fragment,container,false);
        initChoose();
        ChooseAdapter adapter=new ChooseAdapter(getContext(),R.layout.personal_choose_item,chooseList);
        ListView listView=(ListView)view.findViewById(R.id.personal_list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Choose choose=chooseList.get(position);
                switch (choose.getChoose()){
                    case "消息中心":
                        Intent intent =new Intent(getActivity(), MessageActivity.class);
                        startActivity(intent);
                        break;
                    case "我的收藏":
                        Intent intent1=new Intent(getActivity(), CollectActivity.class);
                        startActivity(intent1);
                        break;
                    case "我的主题":
                        Intent intent2=new Intent(getActivity(), MyThemeActivity.class);
                        startActivity(intent2);
                        break;
                    case "我的关注":
                        Intent intent3=new Intent(getActivity(), MyCareActivity.class);
                        startActivity(intent3);
                        break;
                    case "签到":
                        Intent intent4=new Intent(getActivity(), SignActivity.class);
                        startActivity(intent4);
                        break;
                    case "设置":
                        Intent intent5=new Intent(getActivity(), SettingsActivity.class);
                        startActivity(intent5);
                        break;



                    default:
                        break;
                }
            }
        });
        return view;
    }
    private void initChoose(){
        Choose message=new Choose("消息中心",R.drawable.message);
        chooseList.add(message);
        Choose collect=new Choose("我的收藏",R.drawable.star);
        chooseList.add(collect);
        Choose theme=new Choose("我的主题",R.drawable.theme);
        chooseList.add(theme);
        Choose care=new Choose("我的关注",R.drawable.usercare);
        chooseList.add(care);
        Choose regist=new Choose("签到",R.drawable.regist);
        chooseList.add(regist);
        Choose setting=new Choose("设置",R.drawable.set);
        chooseList.add(setting);
    }
}
