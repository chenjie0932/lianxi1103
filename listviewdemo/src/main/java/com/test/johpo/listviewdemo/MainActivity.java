package com.test.johpo.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView lv;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button btn_hide;
    private ArrayList<Data> al;
    private  ArrayList<Data> al1= new ArrayList<Data>();
    private MyAdapter ma;
    private boolean isHide = false;
    private boolean isChecked=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        ma = new MyAdapter(this,al,isHide
            );
        lv.setAdapter(ma);
    }

    private void initData() {
        al = new ArrayList<Data>();
        al.add(new Data("fucking month exam1",false));
        al.add(new Data("fucking month exam2",false));
        al.add(new Data("fucking month exam3",false));
        al.add(new Data("fucking month exam4",false));
        al.add(new Data("fucking month exam5",false));
        al.add(new Data("fucking month exam6",false));
        al.add(new Data("fucking month exam7",false));
        al.add(new Data("fucking month exam8",false));
        al.add(new Data("fucking month exam9",false));
        al.add(new Data("fucking month exam10",false));


    }

    private void initView() {
        lv = (ListView) findViewById(R.id.lv);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        btn_hide= (Button) findViewById(R.id.btn_hide);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        btn_hide.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                chose();
                break;
            case R.id.b2:
                unChose();
                break;
            case R.id.b3:
                delete();
                break;
            case R.id.btn_hide:
              isHide = isHide==true?false:true;

                hide(isHide);
                break;


            default:
                break;
        }
        ma.notifyDataSetChanged();
    }
    private void chose() {
        if (!isChecked) {
            for (int i = 0; i < al.size(); i++) {
                if (al.get(i).isChecked()==false) {
                    al.get(i).setChecked(true);
                }
            }
            isChecked=true;
        }else if(isChecked){
            for (int i = 0; i < al.size(); i++) {
                if (al.get(i).isChecked()==true) {
                    al.get(i).setChecked(false);
                }
            }
            isChecked=false;
        }

    }
    private void unChose() {
        for (int i = 0; i < al.size(); i++) {
            al.get(i).setChecked(!al.get(i).isChecked());
        }
    }

    private void delete() {
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i).isChecked()) {
                al1.add(al.get(i));
            }
        }
        al.removeAll(al1);
    }
    private void hide(boolean isHide) {
        Button btn = (Button)findViewById(R.id.btn_hide);
        if(isHide)
            btn.setText("取消隐藏");
        else
            btn.setText("隐藏已选");

        ma.setHide(isHide);
        ma.check();
    }

}

