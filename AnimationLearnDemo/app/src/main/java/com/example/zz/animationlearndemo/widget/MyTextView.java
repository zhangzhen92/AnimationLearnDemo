package com.example.zz.animationlearndemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 类描述：实现自动从A-Z切换的TextView
 * 创建人：zz
 * 创建时间： 2017/9/1 14:23
 */


public class MyTextView extends TextView{
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 设置文本内容
     * @param charText
     */
    public void setCharText(Character charText){
        setText(String.valueOf(charText));
    }
}
