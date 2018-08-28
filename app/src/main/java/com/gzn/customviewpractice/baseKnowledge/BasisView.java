package com.gzn.customviewpractice.baseKnowledge;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class BasisView extends View {

    private Paint paint = new Paint();
    Rect rect = null;
    int mX=0;
    int mY=0;
    public BasisView(Context context) {
        super(context);
        init();
    }

    public BasisView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BasisView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        paint.setStyle(Paint.Style.STROKE);
        rect = new Rect(100, 10, 300, 100);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mX= (int) event.getX();
        mY= (int) event.getY();

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            invalidate();
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            mY=-1;
            mX = -1;
        }

        postInvalidate();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        test9(canvas);


    }

    private void test9(Canvas canvas) {
        if (rect.contains(mX, mY)) {
            paint.setColor(Color.RED);

        } else {
            paint.setColor(Color.GREEN);
        }

        canvas.drawRect(rect, paint);
    }

    private void test8(Canvas canvas) {
        RectF rectF = new RectF(100, 100, 500, 300);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectF, 0, 90, true, paint);

        RectF rectF2 = new RectF(100, 400, 500, 700);
        canvas.drawArc(rectF2, 0, 90, false, paint);
    }

    private void test7(Canvas canvas) {
        RectF rect = new RectF(100, 100, 300, 400);
        paint.setColor(Color.RED);

        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawOval(rect, paint);
    }
    private void test6(Canvas canvas) {
        RectF rect = new RectF(100, 100, 300, 400);
        paint.setColor(Color.RED);

        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawRoundRect(rect,50,50, paint);
    }

    /**
     * 绘制矩形
     * @param canvas
     */
    private void test5(Canvas canvas) {
        Rect rect = new Rect(100, 100, 300, 400);
        paint.setColor(Color.RED);

        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawRect(rect, paint);
    }


    /**
     * 绘制点
     * @param canvas
     */
    private void test4(Canvas canvas) {
        paint.setStrokeWidth(30);
//        canvas.drawPoint(300, 300, paint);

        float[] pts=new float[]{11f,100f,200f,300f,500f,600f,700f,800f};

//        canvas.drawPoints(pts, paint);

//        canvas.drawPoints(pts, 1, 4, paint);
//
        canvas.drawPoints(pts, 6, 2, paint);
    }

    /**
     * 绘制直线和多条直线
     * @param canvas
     */
    private void test3(Canvas canvas) {
        //绘制背景色
        canvas.drawARGB(0xbb, 0xef, 0xab, 0xcd);
        //绘制直线
        Paint paint=new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);//直线的粗细和画笔的style是没有关系的
        paint.setStrokeWidth(2);
//        canvas.drawLine(0, 0, 300, 400, paint);

        //绘制多条线段的时候，是每两个点形成一条直线
        float[] pts=new float[]{11f,100f,200f,300f,500f,600f,700f,800f};
//        canvas.drawLines(pts, paint);
        //下面这行代码的第二个参数是指跳过几个参数，后面一个参数是指：参与绘制的参数一共有几个
        canvas.drawLines(pts, 1, 4, paint);



    }

    /**
     * 对比FILL、STROKE、FILL_AND_STROKE
     * 结果就是后两者比FILL多了一个描边的宽度
     * @param canvas
     */
    private void test2(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(0xFFFF0000);
        //设置填充样式
        paint.setStyle(Paint.Style.FILL);
        //设置宽度
        paint.setStrokeWidth(50);
        canvas.drawCircle(200, 100, 100, paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(200, 700, 100, paint);

        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(200, 400, 100, paint);
    }

    /**
     * 绘制两个圆
     * @param canvas
     */
    private void test1(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(0xFFFF0000);
        //设置填充样式
        paint.setStyle(Paint.Style.FILL);
        //设置宽度
        paint.setStrokeWidth(50);
        canvas.drawCircle(200, 300, 150, paint);
        paint.setColor(0x7EFFFF00);
        //设置抗锯齿
        paint.setAntiAlias(true);
        canvas.drawCircle(200, 300, 100, paint);
    }
}
