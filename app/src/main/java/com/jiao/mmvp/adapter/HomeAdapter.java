package com.jiao.mmvp.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jiao.mmvp.R;
import com.jiao.mmvp.model.bean.HomeListItemBean;

import java.util.List;

/**
 * @Description : 首页Adapter
 * @Author : StriveJiao
 * @Date : 2018/3/4 18:06
 */

public class HomeAdapter extends BaseCompatAdapter<HomeListItemBean, BaseViewHolder> {


    public HomeAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    public HomeAdapter(@LayoutRes int layoutResId, @Nullable List<HomeListItemBean> data) {
        super(layoutResId, data);
    }

    public HomeAdapter(@Nullable List<HomeListItemBean> data) {
        super(data);
    }


    @Override
    protected void convert(BaseViewHolder helper, HomeListItemBean item) {
        helper.setText(R.id.tv_item_title, item.title);
        Glide.with(mContext).load(item.images[0]).crossFade().into((ImageView) helper.getView(R
                .id.iv_item_image));
    }
}
