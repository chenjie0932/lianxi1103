package com.test.johpo.listviewdemo;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johpo on 2016/11/2 0002.
 */
public class MyAdapter extends BaseAdapter{
    private MainActivity mainActivity;
    private ArrayList<Data> al;
    private boolean isHide;

    private List<Data> list = new ArrayList<>();//当前展示的数据
    private List<Data> listAll;

    public MyAdapter(MainActivity mainActivity, ArrayList<Data> al ,boolean isHide) {
        // TODO Auto-generated constructor stub
        this.mainActivity=mainActivity;
        this.al=al;
        this.isHide = isHide;

    }
       public void setHide(boolean isHide){
        this.isHide = isHide;
    }
    public void check() {
        list.clear();
        list.addAll(listAll);

        if(isHide){
            List<Data> listDel = new ArrayList<>();
//            for(Data data:list){//取出已选的数据
//                if(data.isCheck)
//                    listDel.add(data);
//            }
            for(int i=0;i<list.size();i++){//取出已选的数据 存储在listDel
                Data data = list.get(i);
                if(data.isCheck)
                    listDel.add(data);
            }
            for(Data data:listDel)//删除全部已选的数据 list
                list.remove(data);

        }
        super.notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return al.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = View.inflate(mainActivity, R.layout.item, null);
        TextView tv = (TextView) view.findViewById(R.id.show_tv);
        final CheckBox cb = (CheckBox) view.findViewById(R.id.show_cb);

        tv.setText(al.get(position).getName());

        cb.setChecked(al.get(position).isChecked());

        cb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (cb.isChecked()==true) {
                    al.get(position).setChecked(true);
                }else{
                    al.get(position).setChecked(false);
                }
            }
        });

        return view;
    }
}
