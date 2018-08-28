package com.gzn.customviewpractice.baseKnowledge;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PathView extends View {
    private Paint mPaint = new Paint();

    public PathView(Context context) {
        super(context);
        init();
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        test6(canvas);
    }

    /**
     * 填充类型
     * 关于这个FillType推荐一篇博客：https://www.jianshu.com/p/ce808a9e7e38
     *
     * @param canvas
     */
    private void test6(Canvas canvas) {
        mPaint.setStyle(Paint.Style.FILL);

        Path path = new Path();
        path.addRect(100, 100, 300, 300, Path.Direction.CW);
        path.addCircle(300, 300, 100, Path.Direction.CCW);
        path.setFillType(Path.FillType.EVEN_ODD);

        canvas.drawPath(path, mPaint);
    }

    private void test5(Canvas canvas) {
        Path ccw = new Path();
        Path cw = new Path();

        RectF rect=new RectF(100,200,500,500);
        float[] radii=new float[]{20,20,50,50,80,80,120,120};
        ccw.addRoundRect(rect, radii, Path.Direction.CCW);

        canvas.drawPath(ccw, mPaint);
    }

    private void test4(Canvas canvas) {
        Path CCWRectpath = new Path();
        RectF rectF1 = new RectF(50, 50, 240, 200);
        CCWRectpath.addRect(rectF1, Path.Direction.CCW);

        Path CCWRectpath2 = new Path();
//        RectF rectF2 = new RectF(290, 50, 480, 200);

//        CCWRectpath2.addRect(rectF2, Path.Direction.CW);
        CCWRectpath2.addCircle(800, 800, 400, Path.Direction.CW);
        canvas.drawPath(CCWRectpath, mPaint);
        canvas.drawPath(CCWRectpath2, mPaint);

        String text = "苦心者天不负，有志者事竟成";
        mPaint.setTextSize(35);
        mPaint.setColor(Color.BLUE);

        canvas.drawTextOnPath(text, CCWRectpath, 0, 18, mPaint);
        canvas.drawTextOnPath(text, CCWRectpath2, 0, 18, mPaint);
    }

    private void test3(Canvas canvas) {
        Path path = new Path();
        path.moveTo(10, 10);

        path.lineTo(100, 50);

        RectF rectF = new RectF(100, 100, 150, 150);
        //addXXX方法和XXXTo方法的最后一个参数foreMoveTo参数为true一样效果
        path.addArc(rectF, 0, 90);

        canvas.drawPath(path, mPaint);
    }

    private void test2(Canvas canvas) {
        Path path = new Path();
        path.moveTo(10, 10);

        RectF rectF = new RectF(100, 10, 200, 100);
        //foreMoveTo强制移动到圆弧的绘制的起点
        path.arcTo(rectF, 0, 90, true);

        canvas.drawPath(path, mPaint);
    }

    private void test1(Canvas canvas) {


        Path path = new Path();
        path.moveTo(100, 100);
        path.lineTo(300, 300);

        path.lineTo(100, 200);
//        path.close();
        canvas.drawPath(path, mPaint);
    }
}
