package com.makofeng.nameless.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.makofeng.nameless.R;
import com.makofeng.nameless.utils.AndroidUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageGalleryAdapter extends PagerAdapter {

    private static final String TAG = "ImageGalleryAdapter";

    private final List<String> mImages;

    private Context mContext;

    public ImageGalleryAdapter(List<String> images, Context mContext) {
        this.mImages = images;
        this.mContext = mContext;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.gallery_image, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.iv);

        String image = mImages.get(position);

        int width = AndroidUtils.getScreenWidth(mContext);

        Picasso.with(imageView.getContext())
                .load(image)
                .resize(width, 0)
                .into(imageView);

        container.addView(view, 0);

        return view;
    }

    @Override
    public int getCount() {
        return mImages.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
