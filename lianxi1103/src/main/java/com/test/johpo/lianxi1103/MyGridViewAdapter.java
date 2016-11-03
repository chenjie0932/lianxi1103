package com.test.johpo.lianxi1103;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by johpo on 2016/11/3 0003.
 */
public class MyGridViewAdapter extends BaseAdapter {


    private  MainActivity mainActivity;
    private  List<Bean> al;

    public MyGridViewAdapter(MainActivity mainActivity, List<Bean> al) {
    this.mainActivity=mainActivity;
    this.al=al;
    }
    public int getCount() {
        return al.size();
    }

    @Override
    public Object getItem(int i) {
        return al.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= View.inflate(mainActivity,R.layout.gridviewitem,null);
        ImageView iv2=(ImageView) view.findViewById(R.id.iv2);
        TextView tv2=(TextView) view.findViewById(R.id.tv2);
        iv2.setImageResource(al.get(i).id);
        tv2.setText(al.get(i).name);
        return view;
    }
}
