package com.example.zz.animationlearndemo.layout_anim;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.zz.animationlearndemo.R;
import com.example.zz.animationlearndemo.adapter.ListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：ListView 中item设置animation动画效果
 * 创建人：zz
 * 创建时间：2017/9/5 13:45
 */
public class ListViewAnimActivity extends Activity {


    private ListView listViewId;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_anim);
        initView();
    }

    /**
     * 初始化UI
     */
    private void initView() {
        listViewId = ((ListView) findViewById(R.id.listview_id));
        List<String> datas = new ArrayList<>();
        datas.add("https://static.oschina.net/uploads/cooperation/www_news_sidebar_2_CUiJV.jpg");
        datas.add("http://static.firefoxchina.cn/img/201709/8_59adf8999b3250.jpg");
        datas.add("http://n.sinaimg.cn/ent/transform/20170905/WTP7-fykqmrv9993584.jpg");
        datas.add("http://static.firefoxchina.cn/img/201708/12_59a3c08d463650.jpg");
        datas.add("http://gma.alicdn.com/bao/uploaded/i1/13988885/TB2TmFZagsSMeJjSsphXXXuJFXa_!!0-saturn_solar.jpg_60x60.jpg");
        adapter = new ListAdapter(30,listViewId,getApplicationContext(),datas);
        listViewId.setAdapter(adapter);
    }
}
