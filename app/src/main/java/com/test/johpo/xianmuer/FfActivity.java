package com.test.johpo.xianmuer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;

public class FfActivity extends AppCompatActivity {
    private int imageX = 0;//计算图片的X轴
    private int imageY = 0;//计算图片的Y轴
    private SurfaceHolder holder = null;
    private int screeWidth = 0;
    private int screeHeight = 0;
    private int imageWidth = 0;
    private int imageHeight = 0;
    private Bitmap bitmap = null;

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.screeWidth = super.getWindowManager().getDefaultDisplay().getWidth();
        this.screeWidth = super.getWindowManager().getDefaultDisplay().getHeight();
        this.bitmap = BitmapFactory.decodeResource(super.getResources(), R.mipmap.s);
        this.imageWidth = this.bitmap.getWidth();
        this.imageHeight = this.bitmap.getHeight();
        this.imageX = (this.screeWidth - this.imageWidth) / 2;
        this.imageY = (this.screeHeight - this.imageHeight) / 2;
        setContentView(new MySurfaceView(this));

    }

    private class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {


        public MySurfaceView(Context context) {
            super(context);
            FfActivity.this.holder = super.getHolder();
            FfActivity.this.holder.addCallback(this);
            super.setFocusable(true);//获得焦点，进行触摸事件
        }

        @Override
        public void surfaceCreated(SurfaceHolder surfaceHolder) {

            FfActivity.this.setImage(1, 350, 500);

        }

        @Override
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

        }
    }

    public void setImage(float scale, int width, int height) {//改变之后修改图片

        Canvas canvas =  FfActivity.this.holder.lockCanvas();//获取画布
        Paint paint = new Paint();
        canvas.drawRect(0, 0,  FfActivity.this.screeWidth,  FfActivity.this.screeHeight, paint);
        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);//等量缩放
        Bitmap target = Bitmap.createBitmap( FfActivity.this.bitmap, 0, 0, width, height, matrix, true);
        this.imageWidth = target.getWidth();
        this.imageHeight = target.getHeight();
        this.imageX = (this.screeWidth - this.imageWidth) / 2;
        this.imageY = (this.screeHeight - this.imageHeight) / 2;
        canvas.translate(this.imageX, this.imageY);//平移到指定位置
        canvas.drawBitmap(this.bitmap, matrix, paint);
        FfActivity.this.holder.unlockCanvasAndPost(canvas);//解锁，并提交图像

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int pointerCount = event.getPointerCount();
        if (pointerCount == 2) {
            float pointA = event.getY(0);
            float pointB = event.getY(1);
            if (pointA < pointB) {
                float temp = pointA;
                pointA = pointB;
                pointB = temp;
            }
            if (!(event.getAction() == MotionEvent.ACTION_UP)) {
                float scale = this.getScale(pointA, pointB);
                FfActivity.this.setImage(scale, 350, 500);
            }
        }

        return super.onTouchEvent(event);
    }

    public float getScale(float pointA, float pointB) {

        float scale = pointA / pointB;
        return scale;
    }
}
