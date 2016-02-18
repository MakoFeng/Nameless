package com.makofeng.nameless.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.makofeng.nameless.R;
import com.makofeng.nameless.model.Gank;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 冯浩 on 2016/2/18.
 */
public class GankListAdapter extends RecyclerView.Adapter<GankListAdapter.ViewHolder> {

    private Context context;
    private List<Gank> mGankList;

    public GankListAdapter(Context context) {
        this.context = context;
        mGankList = new ArrayList<>();
    }

    public void setData(List<Gank> meizhiList) {
        this.mGankList = meizhiList;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gank_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Gank gank = mGankList.get(position);

        if (position == 0) {
            holder.category.setVisibility(View.VISIBLE);
        }else {
            boolean theCategoryOfLastEqualsToThis = mGankList.get(
                    position - 1).type.equals(mGankList.get(position).type);

            if (theCategoryOfLastEqualsToThis) {
                holder.category.setVisibility(View.GONE);
            } else {
                holder.category.setVisibility(View.VISIBLE);
            }
        }


        holder.category.setText(gank.type);

        String text = " (via. " +
                gank.who +
                ")";

        SpannableString spannableString = new SpannableString(text);

        spannableString.setSpan(new TextAppearanceSpan(context, R.style.ViaTextAppearance), 0, text.length(),
                0);

        SpannableStringBuilder builder = new SpannableStringBuilder(gank.desc).append(spannableString);

        CharSequence gankText = builder.subSequence(0, builder.length());


        holder.gank.setText(gankText);


        holder.llGank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return mGankList == null ? 0 : mGankList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_category)
        TextView category;
        @Bind(R.id.tv_title)
        TextView gank;
        @Bind(R.id.ll_gank_parent)
        LinearLayout llGank;



        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
