package com.example.zz.animationlearndemo.animator;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zz.animationlearndemo.R;
import com.example.zz.animationlearndemo.widget.MyTextView;
import com.example.zz.animationlearndemo.widget.ObjPointView;

/**
 * 类描述：自定义 属性动画
 * 创建人：zz
 * 创建时间：2017/9/1 11:29
 */
public class BounceObjActivity extends Activity implements View.OnClickListener{

    private Button buttonMove;
    private ObjPointView pointView;
    private TextView textView;
    private Button buttonProperty;
    private MyTextView myTextView;
    private Button buttonChangeChar;
    private ImageView iv;
    private Button buttonShaddle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bounce_obj);
        initView();
    }

    /**
     * 初始化UI
     */
    private void initView() {
        textView = ((TextView) findViewById(R.id.textview_obj_property));
        buttonMove = ((Button) findViewById(R.id.button_move));
        buttonMove.setOnClickListener(this);
        pointView = ((ObjPointView) findViewById(R.id.obj_point_view));
        buttonProperty = ((Button) findViewById(R.id.button_property));
        buttonProperty.setOnClickListener(this);
        myTextView = ((MyTextView) findViewById(R.id.my_textview));
        buttonChangeChar = ((Button) findViewById(R.id.button_changechar));
        buttonChangeChar.setOnClickListener(this);
        iv = ((ImageView) findViewById(R.id.imageview_id));
        buttonShaddle = ((Button) findViewById(R.id.button_shaddle));
        buttonShaddle.setOnClickListener(this);
    }

    /**
     * 设置使用propertyValueHolder  使TextView添加动画
     */
    private void textPropertyMove() {
        PropertyValuesHolder rotationValuesHolder = PropertyValuesHolder.ofFloat("rotation", 0, 180, 0);
        PropertyValuesHolder colorValueHolder = PropertyValuesHolder.ofInt("backgroundColor", 0xffffffff, 0xffff00ff, 0xffffff00, 0xffffffff);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(textView, rotationValuesHolder, colorValueHolder);
        animator.setDuration(2000).setInterpolator(new BounceInterpolator());
        animator.start();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_move:
                ObjectAnimator animator = ObjectAnimator.ofInt(pointView, "pointRadius", 20, 200);
                animator.setInterpolator(new BounceInterpolator());
                animator.setDuration(2000).start();
                break;
            case R.id.button_property:
                textPropertyMove();
                break;
            case R.id.button_changechar:
                PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofObject("CharText", new CharEvaluator(), new Character('A'), new Character('Z'));
                ObjectAnimator animator1 = ObjectAnimator.ofPropertyValuesHolder(myTextView, propertyValuesHolder);
                animator1.setDuration(2000).setInterpolator(new BounceInterpolator());
                animator1.start();
                break;
            case R.id.button_shaddle:
                shaddleImg();
                break;
        }
    }

    /**
     * 左右摇摆的imageView
     */
    private void shaddleImg() {
        Keyframe keyframe = Keyframe.ofFloat(0, 0);
        Keyframe keyframe0 = Keyframe.ofFloat(0.1f, 0);
        Keyframe keyframe1 = Keyframe.ofFloat(0.2f, 20);
        Keyframe keyframe2 = Keyframe.ofFloat(0.3f, -20);
        Keyframe keyframe3 = Keyframe.ofFloat(0.4f, 10);
        Keyframe keyframe5 = Keyframe.ofFloat(0.6f, 10);
        Keyframe keyframe6 = Keyframe.ofFloat(0.7f, 10);
        Keyframe keyframe7 = Keyframe.ofFloat(0.8f, -20);
        Keyframe keyframe9 = Keyframe.ofFloat(1, 0);


        Keyframe scaleFrame0 = Keyframe.ofFloat(0, 0);
        Keyframe scaleFrame1 = Keyframe.ofFloat(0.3f, 0.7f);
        Keyframe scaleFrame2 = Keyframe.ofFloat(0.5f, 1);
        Keyframe scaleFrame3 = Keyframe.ofFloat(0.7f, 1.3f);
        Keyframe scaleFrame4 = Keyframe.ofFloat(1, 1);
        PropertyValuesHolder scale = PropertyValuesHolder.ofKeyframe("scaleX", scaleFrame0, scaleFrame1, scaleFrame2, scaleFrame3, scaleFrame4);

        PropertyValuesHolder rotataion = PropertyValuesHolder.ofKeyframe("rotation", keyframe,keyframe0, keyframe1, keyframe2, keyframe3, keyframe5, keyframe6, keyframe7,keyframe9);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(iv, rotataion,scale);
        animator.setDuration(2000);
        animator.start();



    }


    class CharEvaluator implements TypeEvaluator<Character>{

        @Override
        public Character evaluate(float fraction, Character startValue, Character endValue) {
            int result = (int)(startValue + fraction * ((int)endValue - (int)startValue));
            return (char)result;
        }
    }
}
