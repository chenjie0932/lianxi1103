package com.test.johpo.xianmuer;

import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button bt;
    private ImageView iv;
    private TextView tV;
    private ImageView iV02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button) findViewById(R.id.bt);
        iv = (ImageView) findViewById(R.id.iv);
        tV = (TextView) findViewById(R.id.textView01_id);
        iV02 = (ImageView) findViewById(R.id.imageView02_id);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, OtherActivity.class));
            }
        });
        iv.setOnTouchListener(new View.OnTouchListener() {
            private float x;
            private float y;
            // 用来操作图片的模型
            private Matrix oldMatrix = new Matrix();
            private Matrix newMatrix = new Matrix();

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) { // 判断操作类型
                    case MotionEvent.ACTION_DOWN:
                        //按下时记住x,y的坐标
                        x = event.getX();
                        y = event.getY();
                        oldMatrix.set(iv.getImageMatrix());
                        break;
                    case MotionEvent.ACTION_MOVE://移动时
                        //用另一个模型记住按下时的位置
                        newMatrix.set(oldMatrix);
                        //移动模型
                        newMatrix.setTranslate(event.getX() - x, event.getY() - y);
                        break;
                    case MotionEvent.ACTION_UP:





                }
                //把图片放入移动后的模型中
                iv.setImageMatrix(newMatrix);
                return true;
            }
        });
    }
    }

