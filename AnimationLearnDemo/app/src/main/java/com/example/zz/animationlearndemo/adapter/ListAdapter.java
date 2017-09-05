package com.example.zz.animationlearndemo.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zz.animationlearndemo.R;

import java.util.List;

/**
 * 类描述：ListView 适配器
 * 创建人：zz
 * 创建时间： 2017/9/5 13:47
 */


public class ListAdapter extends BaseAdapter {
    private final Animation animation;
    private int mLength;
    private List<String> datas;
    private LayoutInflater inflater;
    private Context mContext;
    private ListView mListView;
    private boolean isScrollDown = false;
    private int mFirstposition,mFirstTop;

    public ListAdapter(int length,ListView listView, Context context, List<String> datas) {
        animation = AnimationUtils.loadAnimation(context, R.anim.list_item_anim);
        this.mLength = length;
        this.inflater = LayoutInflater.from(context);
        this.datas = datas;
        this.mContext = context;
        this.mListView = listView;
        mListView.setOnScrollListener(onScrollListener);
    }


    AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener(){

        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {

        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            View firstChildView = mListView.getChildAt(0);
            if(firstChildView == null) return;
            int top = firstChildView.getTop();
            isScrollDown = mFirstTop > top || firstVisibleItem > mFirstposition;      //判断是否是下滑整个item还是一定尺寸
            mFirstposition = firstVisibleItem;
            mFirstTop = top;
        }
    };

    @Override
    public int getCount() {
        return mLength;
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position % datas.size());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.listview_item,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(position+"");
        if(!TextUtils.isEmpty(datas.get(position % datas.size()))){
            Glide.with(mContext).load(datas.get(position % datas.size())).into(viewHolder.imageView);
        }
        for (int i = 0; i < mListView.getChildCount(); i++) {
            View childAt = mListView.getChildAt(i);
            childAt.clearAnimation();                                     //移除下滑是每个item的动画只让最下面的item有动画
        }
        if(isScrollDown){
            convertView.startAnimation(animation);
        }
        return convertView;
    }


    class ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(View convertView) {
            imageView = ((ImageView) convertView.findViewById(R.id.imageview_id));
            textView = ((TextView) convertView.findViewById(R.id.textview_position));
        }
    }
}
