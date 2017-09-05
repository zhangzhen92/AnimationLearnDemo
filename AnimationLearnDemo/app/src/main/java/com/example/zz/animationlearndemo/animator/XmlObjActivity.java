package com.example.zz.animationlearndemo.animator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zz.animationlearndemo.R;
/**
 * 类描述：XMl实现属性动画
 * 创建人：zz
 * 创建时间：2017/9/1 17:51
 */
public class XmlObjActivity extends Activity {

    private TextView textView;
    private boolean menuIsOpen = false;
    private Button buttonItem1;
    private Button buttonItem2;
    private Button buttonItem3;
    private int radius = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_obj);
        initView();
    }

    /**
     * 初始化UI
     */
    private void initView() {
        textView = ((TextView) findViewById(R.id.textview_id));
        ValueAnimator animator = (ValueAnimator) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.value_animator);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = ((int) animation.getAnimatedValue());
                textView.layout(currentValue,textView.getTop(),textView.getRight() + currentValue,textView.getBottom());
            }
        });
       animator.start();
        Button buttonMenu = (Button) findViewById(R.id.button_menu);
        buttonItem1 = ((Button) findViewById(R.id.button_item1));
        buttonItem2 = ((Button) findViewById(R.id.button_item2));
        buttonItem3 = ((Button) findViewById(R.id.button_item3));
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!menuIsOpen){
                    doOpenMenu(buttonItem1,0,3,radius);
                    doOpenMenu(buttonItem2,1,3,radius);
                    doOpenMenu(buttonItem3,2,3,radius);
                    menuIsOpen = true;
                }else {
                    doCloseMenu(buttonItem1,0,3,radius);
                    doCloseMenu(buttonItem2,1,3,radius);
                    doCloseMenu(buttonItem3,2,3,radius);
                    menuIsOpen = false;
                }
            }
        });
    }

    /**
     * 关闭菜单动画
     */
    private void doCloseMenu(final View view, int index, int total, int radius) {
        if(view.getVisibility() == View.GONE){
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.toRadians(90  /  (total -1 ) * index);
        float x = -radius * (float) Math.sin(degree);
        float y =-radius * (float) Math.cos(degree);
        ObjectAnimator translationY = ObjectAnimator.ofFloat(view, "translationY", y, 0);
        ObjectAnimator translationX = ObjectAnimator.ofFloat(view, "translationX", x, 0);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha", 1, 0);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(translationX,translationY,alpha);
        set.setInterpolator(new AccelerateDecelerateInterpolator());
        set.setDuration(1000);
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
             view.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

    /**
     * 开启菜单动画
     */
    private void doOpenMenu(final View view, int index, int total, int radius) {
        if(view.getVisibility() == View.GONE){
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.toRadians(90  /  (total -1 ) * index);
        float x = radius * (float) Math.sin(degree);
        float y =radius * (float) Math.cos(degree);
        ObjectAnimator translationY = ObjectAnimator.ofFloat(view, "translationY", 0, -y);
        ObjectAnimator translationX = ObjectAnimator.ofFloat(view, "translationX", 0, -x);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha", 0, 1);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(translationX,translationY,alpha);
        set.setInterpolator(new BounceInterpolator());
        set.setDuration(2000);
        set.start();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),view.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
