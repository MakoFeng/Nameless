package com.makofeng.nameless.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.makofeng.nameless.R;
import com.makofeng.nameless.model.Meizhi;
import com.makofeng.nameless.utils.DateUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 冯浩 on 2015/12/22.
 */
public class MeizhiAdapter extends RecyclerView.Adapter<MeizhiAdapter.MeizhiViewHolder> {


    private Context context;
    private List<Meizhi> meizhiList;

    public MeizhiAdapter(Context context) {
        this.context = context;
        meizhiList=new ArrayList<>();
    }

    public void setData(List<Meizhi> meizhiList){
        this.meizhiList = meizhiList;
        notifyDataSetChanged();
    }


    public void addItems(List<Meizhi> list) {

        for(Meizhi itemModel : list) {
            meizhiList.add(itemModel);
        }

        notifyDataSetChanged();
    }


    @Override
    public MeizhiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.meizhi_item, parent, false);
        MeizhiViewHolder meizhiViewHolder = new MeizhiViewHolder(view);
        return meizhiViewHolder;
    }

    @Override
    public void onBindViewHolder(MeizhiViewHolder holder, int position) {

        String date= DateUtils.toDate(meizhiList.get(position).publishedAt);

        holder.tvName.setText(date);

        Picasso.with(context).load(meizhiList.get(position).url).fit().centerCrop().into(holder.ivImg);
    }

    @Override
    public int getItemCount() {
        return meizhiList == null ? 0 : meizhiList.size();
    }

    class MeizhiViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.iv_img)
        ImageView ivImg;

        public MeizhiViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }
}
