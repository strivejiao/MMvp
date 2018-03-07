package com.jiao.mmvp.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.animation.ScaleInAnimation;
import com.jiao.mmvp.R;
import com.jiao.mmvp.model.bean.MovieItemBean;

import java.util.List;

/**
 * @Description :
 * @Author : StriveJiao
 * @Date : 2018/3/6 14:23
 */

public class MovieAdapter extends BaseQuickAdapter<MovieItemBean,BaseViewHolder>{

    public MovieAdapter(@LayoutRes int layoutResId, @Nullable List<MovieItemBean> data) {
        super(layoutResId, data);
        init();
    }

    public MovieAdapter(@Nullable List<MovieItemBean> data) {
        super(data);
        init();
    }

    public MovieAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
        init();
    }

    @Override
    protected void convert(BaseViewHolder helper, MovieItemBean item) {
        helper.setText(R.id.tv_movie_title, item.title);
        helper.setText(R.id.tv_movie_directors, item.getDirectorsString());
        helper.setText(R.id.tv_movie_actors, item.getActorsString());
        helper.setText(R.id.tv_movie_genres, item.getGenresString());
        helper.setText(R.id.tv_movie_rating_rate, String.valueOf(item.rating.getAverage()));
        Glide.with(mContext).load(item.images.getLarge()).crossFade(300).placeholder(R
                .mipmap.img_default_movie).into((ImageView) helper.getView(R.id.iv_moive_photo));
    }

    private void init() {
        openLoadAnimation(new ScaleInAnimation(0.8f));
        isFirstOnly(false);
    }

}
