package com.example.zz.animationlearndemo.valueanim;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zz.animationlearndemo.R;
import com.example.zz.animationlearndemo.widget.MyPointView;

/**
 * 类描述：抖动的圆点
 * 创建人：zz
 * 创建时间：2017/8/31 16:47
 */
public class BoundPointActivity extends Activity {

    private Button buttonId;
    private MyPointView pointView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_point);
        initView();
    }

    private void initView() {
        buttonId = ((Button) findViewById(R.id.button_id));
        pointView = ((MyPointView) findViewById(R.id.mypoint_view));
        buttonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointView.doAnimataion();
            }
        });
    }
}
