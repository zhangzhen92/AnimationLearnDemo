package com.example.zz.animationlearndemo.anim_ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.zz.animationlearndemo.R;

/**
 * 类描述：rotation 旋转动画Activity
 * 创建人：zz
 * 创建时间：2017/8/29 17:05
 */
public class RotationActivity extends Activity implements View.OnClickListener{

    private RelativeLayout relativeMove;
    private Button buttonRotationXml;
    private Button buttonRotationJava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation);
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

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_rxml:
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotation_anim);
                relativeMove.startAnimation(animation);
                break;
            case R.id.button_rjava:
                RotateAnimation rotateAnimation = new RotateAnimation(0, 720, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setDuration(1000);
                relativeMove.setAnimation(rotateAnimation);
                break;
        }
    }
}
