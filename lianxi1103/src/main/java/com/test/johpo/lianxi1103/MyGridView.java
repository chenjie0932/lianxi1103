package com.test.johpo.lianxi1103;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by johpo on 2016/11/3 0003.
 */
public class MyGridView extends GridView {
    public MyGridView (Context context) {
        super(context);
    }

    public MyGridView (Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGridView (Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpce = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpce );
    }



}
