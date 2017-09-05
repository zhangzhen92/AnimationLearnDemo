package com.example.zz.animationlearndemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.zz.animationlearndemo.bean.RedPoint;

/**
 * 类描述：
 * 创建人：zz
 * 创建时间： 2017/9/1 11:35
 */


public class ObjPointView extends View{
    private Paint mPaint;
    private RedPoint mRedPoint;

    public ObjPointView(Context context) {
        super(context);
        init();
    }

    public ObjPointView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ObjPointView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mRedPoint != null){
            canvas.drawCircle(300,300,mRedPoint.getRadius(),mPaint);
        }
    }

    /**
     * 初始化操作
     */
    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
    }


    /**
     * 自定义属性动画（pointRadius）
     * @param radius
     */
    public void setPointRadius(int radius){
       if(mRedPoint == null){
           mRedPoint = new RedPoint(radius);
       }else {
           mRedPoint.setRadius(radius);
       }
        invalidate();
    }
}
