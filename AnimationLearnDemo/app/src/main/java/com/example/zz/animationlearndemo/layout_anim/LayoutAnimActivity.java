package com.example.zz.animationlearndemo.layout_anim;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import com.example.zz.animationlearndemo.adapter.GridAdapter;
import com.example.zz.animationlearndemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：LayoutAnim测试类
 * 创建人：zz
 * 创建时间：2017/9/4 11:56
 */
public class LayoutAnimActivity extends Activity implements View.OnClickListener{

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private Button buttonAdd;
    private Button buttonChange;

    private boolean isListView = true;                          //ListView 与GridView的区分
    private GridView gridView;
    private GridAdapter gridAdapter;
    private int dataCount = 5;                                 //数据源的个数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_anim);
        initView();
    }

    /**
     * 初始化UI
     */
    private void initView() {
        buttonChange = ((Button) findViewById(R.id.button_change));
        buttonChange.setOnClickListener(this);
        buttonAdd = ((Button) findViewById(R.id.button_add));
        buttonAdd.setOnClickListener(this);
        listView = ((ListView) findViewById(R.id.listview_id));
        gridView = ((GridView) findViewById(R.id.gridview_id));
    }

    /**
     * 添加数据源
     * @return
     */
    private List<String> getData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < dataCount; i++) {
            list.add("测试数据"+i);
        }
        return list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_add:
                if(isListView){
                adapter.addAll(getData());
                }else {

                }
                break;
            case R.id.button_change:
                if(isListView){
                    //是ListView
                    isListView = false;
                    operateGridView();
                }else {
                 isListView = true;
                    operateListView();
                }
                break;
        }
    }

    /**
     * ListView 操作
     */
    private void operateListView() {
        gridView.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);
        dataCount = 5;
        adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.list_item,getData());
        listView.setAdapter(adapter);

        Animation animationSlide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left);
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(animationSlide);
        layoutAnimationController.setOrder(LayoutAnimationController.ORDER_NORMAL);
        layoutAnimationController.setDelay(1);
        listView.setLayoutAnimation(layoutAnimationController);
        listView.startLayoutAnimation();

    }

    /**
     * GridView操作
     */
    private void operateGridView() {
      gridView.setVisibility(View.VISIBLE);
      listView.setVisibility(View.GONE);
        dataCount = 20;
      gridAdapter = new GridAdapter(getData(),getApplicationContext());
      gridView.setAdapter(gridAdapter);
    }
}
