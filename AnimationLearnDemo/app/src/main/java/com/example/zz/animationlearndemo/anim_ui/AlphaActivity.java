package com.example.zz.animationlearndemo.anim_ui;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.zz.animationlearndemo.R;

/**
 * 类描述：alpha透明度Activity
 * 创建人：zz
 * 创建时间：2017/8/29 17:04
 */
public class AlphaActivity extends Activity implements View.OnClickListener{

    private RelativeLayout relativeMove;
    private Animation alphaAnim;
    private Button buttonView;
    private Button buttonProperty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha);
        initView();
    }

    /**
     * 初始化UI
     */
    private void initView() {
        relativeMove = ((RelativeLayout) findViewById(R.id.relative_move));
        buttonView = ((Button) findViewById(R.id.button_view));
        buttonProperty = ((Button) findViewById(R.id.button_property));
        buttonView.setOnClickListener(this);
        buttonProperty.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
      switch (v.getId()){
          case R.id.button_view:
              alphaAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha_anim);
              relativeMove.startAnimation(alphaAnim);
              break;
          case R.id.button_property:
              ObjectAnimator animator = ObjectAnimator.ofFloat(relativeMove, "alpha", 0, 1);
              animator.setDuration(2000).start();
              break;
      }
    }
}
