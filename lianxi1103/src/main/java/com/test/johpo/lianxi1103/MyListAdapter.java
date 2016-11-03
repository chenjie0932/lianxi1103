package com.test.johpo.lianxi1103;


import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by johpo on 2016/11/3 0003.
 */
public class MyListAdapter extends BaseAdapter {


    private  MainActivity mainActivity;
    private   ArrayList<Bean> al;


    public MyListAdapter(MainActivity mainActivity, ArrayList<Bean> al) {
        this.mainActivity=mainActivity;
        this.al=al;
    }

    @Override
    public int getCount() {
        return al.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       view= View.inflate(mainActivity,R.layout.listitem,null);
        ImageView  iv1=(ImageView) view.findViewById(R.id.iv1);
        TextView tv1=(TextView) view.findViewById(R.id.tv1);

        iv1.setImageResource(al.get(i).id);
        tv1.setText(al.get(i).name);
        return view;

    }
}
