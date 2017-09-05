package com.example.zz.animationlearndemo.layout_anim;

import android.animation.Keyframe;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.zz.animationlearndemo.R;

/**
 * 类描述：ViewGroup 动画测试类
 * 创建人：zz
 * 创建时间：2017/9/4 15:44
 */
public class ViewGroupActivity extends Activity implements View.OnClickListener{

    private LinearLayout linearContainer;
    private Button buttonAddView;
    private Button buttonRemoveView;
    private int buttonIndex = 0;
    private LayoutTransition mTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_group);
        initView();

    }

    /**
     *
     */
    private void initView() {
        buttonAddView = ((Button) findViewById(R.id.button_addview));
        buttonRemoveView = ((Button) findViewById(R.id.button_removeview));
        linearContainer = ((LinearLayout) findViewById(R.id.linear_container));
        buttonAddView.setOnClickListener(this);
        buttonRemoveView.setOnClickListener(this);

        mTransition = new LayoutTransition();
        ObjectAnimator animatorIn = ObjectAnimator.ofFloat(null, "rotationY", 0, 60, 0);
        mTransition.setAnimator(LayoutTransition.APPEARING,animatorIn);                   //控件出现时的动画
        ObjectAnimator animatorOut = ObjectAnimator.ofFloat(null, "rotation", 0, 90, 0);
        mTransition.setAnimator(LayoutTransition.DISAPPEARING,animatorOut);              //控件消失时的动画

        PropertyValuesHolder leftValueHolder = PropertyValuesHolder.ofInt("left", 0, 100, 0);
        PropertyValuesHolder topValueHolder = PropertyValuesHolder.ofInt("top", 1,1);

        Keyframe keyframe0 = Keyframe.ofFloat(0, 0);
        Keyframe keyframe1 = Keyframe.ofFloat(0.3f, 30);
        Keyframe keyframe2 = Keyframe.ofFloat(0.6f, 60);
        Keyframe keyframe3 = Keyframe.ofFloat(0.9f, 90);
        Keyframe keyframe5 = Keyframe.ofFloat(1, 0);
        PropertyValuesHolder rotationKeyFrame = PropertyValuesHolder.ofKeyframe("rotation", keyframe0, keyframe1, keyframe2, keyframe3, keyframe5);


        ValueAnimator animatorOther = ObjectAnimator.ofPropertyValuesHolder(linearContainer,rotationKeyFrame,leftValueHolder, topValueHolder);
        mTransition.setAnimator(LayoutTransition.CHANGE_APPEARING,animatorOther);

        linearContainer.setLayoutTransition(mTransition);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_addview:
                addView();
                break;
            case R.id.button_removeview:
                removeView();
                break;
        }
    }

    /**
     * 移除View
     */
    private void removeView() {
       if(buttonIndex > 0 ){
           linearContainer.removeViewAt(0);
           buttonIndex--;
       }
    }

    /**
     * 添加view
     */
    private void addView() {
        buttonIndex++;
        Button button = new Button(this);
        button.setText("Button"+buttonIndex);
        button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        linearContainer.addView(button,0);
    }

}
