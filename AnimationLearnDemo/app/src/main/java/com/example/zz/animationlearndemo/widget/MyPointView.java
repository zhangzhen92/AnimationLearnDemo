package com.example.zz.animationlearndemo.widget;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

import com.example.zz.animationlearndemo.bean.RedPoint;

/**
 * 类描述：
 * 创建人：zz
 * 创建时间： 2017/8/31 17:20
 */


public class MyPointView extends View{
    private RedPoint mPoint;
    private Paint mPaint;

    public MyPointView(Context context) {
        super(context);
        init();
    }

    public MyPointView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
    }

    public MyPointView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mPoint != null){
            canvas.drawCircle(300,300,mPoint.getRadius(),mPaint);
        }
    }


    public void doAnimataion(){
        ValueAnimator pointAnimator = ValueAnimator.ofObject(new PointEvaluator(), new RedPoint(20), new RedPoint(200));
        pointAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mPoint = (RedPoint) animation.getAnimatedValue();
                invalidate();
            }
        });
        pointAnimator.setEvaluator(new PointEvaluator());
        pointAnimator.setInterpolator(new BounceInterpolator());
        pointAnimator.setDuration(3000);
        pointAnimator.start();


    }


    /**
     * 自定义计算方式
     */
    class PointEvaluator implements TypeEvaluator<RedPoint>{

        @Override
        public RedPoint evaluate(float fraction, RedPoint startValue, RedPoint endValue) {
            int startInt = startValue.getRadius();
            int endInt = endValue.getRadius();
            int currentInt = (int) (startInt + fraction * (endInt - startInt));
            return new RedPoint(currentInt);
        }
    }
}
