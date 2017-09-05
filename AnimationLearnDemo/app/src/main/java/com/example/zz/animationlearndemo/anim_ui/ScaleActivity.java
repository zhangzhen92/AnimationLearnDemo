package com.example.zz.animationlearndemo.anim_ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.example.zz.animationlearndemo.R;

/**
 * 类描述：Scale动画Activity
 * 创建人：zz
 * 创建时间：2017/8/29 17:05
 */
public class ScaleActivity extends Activity {

    private RelativeLayout relativeMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);
        initView();
    }

    /**
     * 初始化UI
     */
    private void initView() {
        relativeMove = ((RelativeLayout) findViewById(R.id.relative_move));
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_anim);
        relativeMove.startAnimation(animation);
    }
}
