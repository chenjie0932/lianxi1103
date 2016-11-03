package com.test.johpo.lianxi1103;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  private GridView gv;
    private ListView listview;
   private ListView lv;
   private List<Bean> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gv=(GridView) findViewById(R.id.gv);
        listview=(ListView) findViewById(R.id.lv);

        initData();

        gv.setAdapter(new MyGridViewAdapter(this,al));
        listview.setAdapter(new MyGridViewAdapter(this,al));

    }


private void initData() {
    al=new ArrayList<>();

    al.add(new Bean(R.drawable.gv1,"作家协会"));
    al.add(new Bean(R.drawable.gv2,"作家协会"));
    al.add(new Bean(R.drawable.gv3,"作家协会"));
    al.add(new Bean(R.drawable.gv4,"作家协会"));
    al.add(new Bean(R.drawable.gv5,"作家协会"));
    al.add(new Bean(R.drawable.gv6,"作家协会"));
    al.add(new Bean(R.drawable.gv7,"作家协会"));
    al.add(new Bean(R.drawable.gv8,"作家协会1234"));
    al.add(new Bean(R.drawable.gv9,"作家协会"));
    al.add(new Bean(R.drawable.gv10,"作家协会"));
    al.add(new Bean(R.drawable.gv11,"作家协会"));
    al.add(new Bean(R.drawable.gv12,"作家协会"));
    al.add(new Bean(R.drawable.gv13,"作家协会"));
    al.add(new Bean(R.drawable.gv14,"作家协会"));
    al.add(new Bean(R.drawable.gv13,"作家协会"));
    al.add(new Bean(R.drawable.gv14,"作家协会"));
    }




}
