package com.example.zz.animationlearndemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zz.animationlearndemo.anim_ui.AlphaActivity;
import com.example.zz.animationlearndemo.anim_ui.RotationActivity;
import com.example.zz.animationlearndemo.anim_ui.ScaleActivity;
import com.example.zz.animationlearndemo.anim_ui.SetAnimActivity;
import com.example.zz.animationlearndemo.anim_ui.TranslateActivity;
import com.example.zz.animationlearndemo.animator.BounceObjActivity;
import com.example.zz.animationlearndemo.animator.XmlObjActivity;
import com.example.zz.animationlearndemo.layout_anim.LayoutAnimActivity;
import com.example.zz.animationlearndemo.layout_anim.ListViewAnimActivity;
import com.example.zz.animationlearndemo.layout_anim.ViewGroupActivity;
import com.example.zz.animationlearndemo.valueanim.ValueAnimActivity;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button buttonAlpha;
    private Button buttonScale;
    private Button buttonRotation;
    private Button buttonTranslate;
    private Button buttonSet;
    private Button buttonValue;
    private Button buttonObjAnimator;
    private Button buttonXMLProperty;
    private Button buttonLayoutAnim;
    private Button buttonViewGroup;
    private Button buttonListAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化UI
     */
    private void initView() {
        buttonAlpha = ((Button) findViewById(R.id.button_alpha));
        buttonAlpha.setOnClickListener(this);
        buttonScale = ((Button) findViewById(R.id.button_scale));
        buttonScale.setOnClickListener(this);
        buttonRotation = ((Button) findViewById(R.id.button_rotation));
        buttonRotation.setOnClickListener(this);
        buttonTranslate = ((Button) findViewById(R.id.button_translate));
        buttonTranslate.setOnClickListener(this);
        buttonSet = ((Button) findViewById(R.id.button_set));
        buttonSet.setOnClickListener(this);
        buttonValue = ((Button) findViewById(R.id.button_value));
        buttonValue.setOnClickListener(this);
        buttonObjAnimator = ((Button) findViewById(R.id.button_obj_animator));
        buttonObjAnimator.setOnClickListener(this);
        buttonXMLProperty = ((Button) findViewById(R.id.button_xml_property));
        buttonXMLProperty.setOnClickListener(this);
        buttonLayoutAnim = ((Button) findViewById(R.id.layout_anim));
        buttonLayoutAnim.setOnClickListener(this);
        buttonViewGroup = ((Button) findViewById(R.id.button_viewgroup));
        buttonViewGroup.setOnClickListener(this);
        buttonListAnim = ((Button) findViewById(R.id.button_listanim));
        buttonListAnim.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
      switch (v.getId()){
          case R.id.button_alpha:
              startActivity(new Intent(getApplicationContext(), AlphaActivity.class));
              break;
          case R.id.button_scale:
              startActivity(new Intent(getApplicationContext(), ScaleActivity.class));
              break;
          case R.id.button_rotation:
              startActivity(new Intent(getApplicationContext(), RotationActivity.class));
              break;
          case R.id.button_translate:
              startActivity(new Intent(getApplicationContext(), TranslateActivity.class));
              break;
          case R.id.button_set:
              startActivity(new Intent(getApplicationContext(), SetAnimActivity.class));
              break;
          case R.id.button_value:
              startActivity(new Intent(getApplicationContext(), ValueAnimActivity.class));
              break;
          case R.id.button_obj_animator:
              startActivity(new Intent(getApplicationContext(), BounceObjActivity.class));
              break;
          case R.id.button_xml_property:
              startActivity(new Intent(getApplicationContext(), XmlObjActivity.class));
              break;
          case R.id.layout_anim:
              startActivity(new Intent(getApplicationContext(), LayoutAnimActivity.class));
              break;
          case R.id.button_viewgroup:
              startActivity(new Intent(getApplicationContext(), ViewGroupActivity.class));
              break;
          case R.id.button_listanim:
              startActivity(new Intent(getApplicationContext(), ListViewAnimActivity.class));
              break;
      }
    }
}
