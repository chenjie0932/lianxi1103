package com.test.johpo.lianxi1103;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by johpo on 2016/11/3 0003.
 */
public class MyListView extends ListView {
    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpce = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expandSpce );
    }

}
