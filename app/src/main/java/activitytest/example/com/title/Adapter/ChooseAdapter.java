package activitytest.example.com.title.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import activitytest.example.com.title.R;
import activitytest.example.com.title.shitilei.Choose;

/**
 * Created by Administrator on 2017/4/23 0023.
 */

public class ChooseAdapter extends ArrayAdapter<Choose> {
    private int resourceId;
    public ChooseAdapter(Context context, int textViewResourceId, List<Choose> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Choose choose=getItem(position);//获取当前项的Choose实例
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView chooseImage=(ImageView)view.findViewById(R.id.choose_image);
        TextView chooseName=(TextView)view.findViewById(R.id.choose_name);
        chooseImage.setImageResource(choose.getImageId());
        chooseName.setText(choose.getChoose());
        return view;
    }
}
