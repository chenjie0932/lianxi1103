package com.test.johpo.xianmuer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by johpo on 2016/11/1 0001.
 */
public class MyView extends View {
    public float currentX=40;
    public float currentY=50;
    //定义，创建画笔
    Paint paint=new Paint();

    public MyView(Context context, AttributeSet set) {
        super(context);

    }
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        //设置画笔的颜色
        paint.setColor(Color.BLACK);
        //绘制一个小圆
        canvas.drawCircle(currentX, currentY, 30, paint);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //当前组建的currentX，currentY的两个属性
        this.currentX=event.getX();
        this.currentY=event.getY();
        //通知该组件重回
        this.invalidate();
        //返回true表名处理方法已经处理该事件
        return true;
    }
}
