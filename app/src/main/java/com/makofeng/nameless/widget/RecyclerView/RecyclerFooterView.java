package com.makofeng.nameless.widget.RecyclerView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.makofeng.nameless.R;


public class RecyclerFooterView extends RelativeLayout {

    public RecyclerFooterView(Context context) {
        super(context);
        init(context);
    }

    public RecyclerFooterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public RecyclerFooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {

        inflate(context, R.layout.recycler_footer_view, this);
    }
}