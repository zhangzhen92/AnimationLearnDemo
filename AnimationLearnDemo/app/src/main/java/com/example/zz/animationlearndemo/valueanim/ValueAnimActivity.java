package com.example.zz.animationlearndemo.valueanim;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zz.animationlearndemo.R;

/**
 * 类描述：ValueAnimation
 * 创建人：zz
 * 创建时间：2017/8/30 16:14
 */
public class ValueAnimActivity extends Activity implements View.OnClickListener{

    private Button buttonMove;
    private TextView textView;
    private RelativeLayout relaiveCenter;
    private ValueAnimator animatorCenter;
    private Button buttonMovePoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_anim);
        initView();
    }

    /**
     * 初始化UI
     */
    private void initView() {
        buttonMove = ((Button) findViewById(R.id.button_move));
        textView = ((TextView) findViewById(R.id.textview_id));
        buttonMove.setOnClickListener(this);
        textView.setOnClickListener(this);
        relaiveCenter = ((RelativeLayout) findViewById(R.id.relative_center));
        relaiveCenter.setOnClickListener(this);
        buttonMovePoint = ((Button) findViewById(R.id.point_move));
        buttonMovePoint.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_move:
                tvMove();
                centerAnimation();
                break;
            case R.id.textview_id:
                Toast.makeText(getApplicationContext(),"响应事件",Toast.LENGTH_SHORT).show();
                break;
            case R.id.relative_center:
                animatorCenter.removeAllListeners();
                break;
            case R.id.point_move:
                startActivity(new Intent(getApplicationContext(),BoundPointActivity.class));
                break;
        }
    }

    /**
     * TextView 移动
     */
    private void tvMove() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 400,50,400);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = (int)animation.getAnimatedValue();
                textView.layout(currentValue,currentValue,textView.getWidth()+currentValue,textView.getHeight()+currentValue);
            }
        });
        animator.start();    //TODO start需要放在listener监听之下，否则监听无法检测到开始动画的状态

        //----------------------修改背景颜色-----------------------------------------------
        ValueAnimator animatorColor = ValueAnimator.ofInt(0xffffff00,0xff0000ff);
        animatorColor.setEvaluator(new ArgbEvaluator());
        animatorColor.setDuration(2000);
        animatorColor.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = ((int) animation.getAnimatedValue());
               textView.setBackgroundColor(currentValue);
            }
        });
        animatorColor.start();


        //-----------------修改文本的内容，使用ValueAnimator.ofObj来控制传入字符---------------
        ValueAnimator animatorText = ValueAnimator.ofObject(new CharacterEvaluator(), new Character('A'), new Character('Z'));
        animatorText.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Character currentResult  = (Character) animation.getAnimatedValue();
                textView.setText(String.valueOf(currentResult));
            }
        });
        animatorText.setInterpolator(new AccelerateInterpolator());
        animatorText.setDuration(2000);
        animatorText.start();

    }


    class CharacterEvaluator implements TypeEvaluator<Character>{

        @Override
        public Character evaluate(float fraction, Character startValue, Character endValue) {
            int startInt = startValue;
            int endInt = endValue;
            int currentValue = (int) (startInt + fraction*(endInt - startInt));
            return (char)currentValue;
        }
    }


    /**
     * 中间位置上下移动
     */
    public void centerAnimation(){
        animatorCenter = ValueAnimator.ofInt(0, 400);
        animatorCenter.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currenValue = (int)animation.getAnimatedValue();
                relaiveCenter.layout(relaiveCenter.getLeft(),currenValue,relaiveCenter.getRight(),relaiveCenter.getHeight()+currenValue);
            }
        });
        animatorCenter.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.i("123321","start");
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.i("123321","repeat");
            }
        });
        animatorCenter.setRepeatCount(ValueAnimator.INFINITE);
        animatorCenter.setRepeatMode(ValueAnimator.REVERSE);
        animatorCenter.setDuration(2000);
        animatorCenter.setEvaluator(new MyEvaluator());
        animatorCenter.start();
    }


    /**
     * 设置进度计算方式
     */
    class MyEvaluator implements TypeEvaluator<Integer>{

        @Override
        public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
            return (int)(endValue -  fraction * (endValue - startValue));
        }
    }
}
