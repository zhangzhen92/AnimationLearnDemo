package com.example.zz.animationlearndemo.anim_ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.zz.animationlearndemo.R;

/**
 * 动画合集
 */
public class SetAnimActivity extends Activity implements View.OnClickListener{

    private RelativeLayout relativeMove;
    private  Button buttonRotationJava;
    private Button buttonRotationXml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_anim);
        initView();
    }


    /**
     * 初始化UI
     */
    private void initView() {
        buttonRotationXml = ((Button) findViewById(R.id.button_rxml));
        buttonRotationJava = ((Button) findViewById(R.id.button_rjava));
        relativeMove = ((RelativeLayout) findViewById(R.id.relative_move));
        buttonRotationJava.setOnClickListener(this);
        buttonRotationXml.setOnClickListener(this);
        relativeMove.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_rxml:
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.set_anim);
                relativeMove.startAnimation(animation);
                break;
            case R.id.button_rjava:
                 javaMove();
                break;
            case R.id.relative_move:
                javaMove();
                break;
        }
    }

    private void javaMove() {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 720, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(2000);
        animationSet.setInterpolator(new BounceInterpolator());
        relativeMove.startAnimation(animationSet);
    }
}
