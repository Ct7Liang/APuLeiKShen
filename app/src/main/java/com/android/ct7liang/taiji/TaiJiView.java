package com.android.ct7liang.taiji;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/8/11.]
 *
 */

public class TaiJiView extends View {

    private int centerX;
    private int centerY;

    public TaiJiView(Context context) {
        super(context);
    }

    public TaiJiView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

//        centerX = width/2;
//        centerY = height/2;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        centerX = w/2;
        centerY = h/2;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);

//        // 画布置为金黄色
//        canvas.drawColor(Color.parseColor("#FFFE3B"));
//        // 画一个白色的圆
//        canvas.drawCircle(centerX, centerY , centerX - 100, paint);
//        // 将白色的圆 分为 左黑 右白
//        paint.setColor(Color.BLACK);
//        RectF rectF = new RectF(100, centerY - centerX + 100, centerX + centerX - 100, centerY + centerX -100);
//        canvas.drawArc(rectF, 90, 180, true, paint);
//
//        canvas.drawCircle(centerX, centerY - (centerX - 100)/2, (centerX - 100)/2, paint);
//
//        paint.setColor(Color.WHITE);
//        canvas.drawCircle(centerX, centerY + (centerX - 100)/2, (centerX - 100)/2, paint);
//
//        canvas.drawCircle(centerX, centerY - (centerX - 100)/2, (centerX - 100)/8, paint);
//
//        paint.setColor(Color.BLACK);
//        canvas.drawCircle(centerX, centerY + (centerX - 100)/2, (centerX - 100)/8, paint);

        canvas.translate(centerX, centerY);

        // 画布置为金黄色
        canvas.drawColor(Color.parseColor("#FFFE3B"));
        // 画一个白色的圆
        canvas.drawCircle(0, 0 , centerX - 100, paint);
        // 将白色的圆 分为 左黑 右白
        paint.setColor(Color.BLACK);
        RectF rectF = new RectF(100 - centerX, 100 - centerX, centerX - 100, centerX -100);
        canvas.drawArc(rectF, 90, 180, true, paint);

        canvas.drawCircle(0, - (centerX - 100)/2, (centerX - 100)/2, paint);

        paint.setColor(Color.WHITE);
        canvas.drawCircle(0, (centerX - 100)/2, (centerX - 100)/2, paint);

        canvas.drawCircle(0, - (centerX - 100)/2, (centerX - 100)/8, paint);

        paint.setColor(Color.BLACK);
        canvas.drawCircle(0, (centerX - 100)/2, (centerX - 100)/8, paint);
    }
}