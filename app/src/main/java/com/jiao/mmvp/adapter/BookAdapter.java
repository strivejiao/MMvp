package com.jiao.mmvp.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jiao.mmvp.R;
import com.jiao.mmvp.model.bean.BookItemBean;

import java.util.List;

/**
 * @Description :
 * @Author : StriveJiao
 * @Date : 2018/3/6 17:25
 */

public class BookAdapter extends BaseCompatAdapter<BookItemBean, BaseViewHolder> {
    public BookAdapter(@LayoutRes int layoutResId, @Nullable List<BookItemBean> data) {
        super(layoutResId, data);
    }

    public BookAdapter(@Nullable List<BookItemBean> data) {
        super(data);
    }

    public BookAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, BookItemBean item) {
        helper.setText(R.id.tv_item_title, "《" + item.getTitle() + "》");
        helper.setText(R.id.tv_item_author, "作者：" + item.getAuthorsString());
        helper.setText(R.id.tv_item_publisher, "出版社：" + item.getPublisher());
        helper.setText(R.id.tv_item_pubdate, "出版日期：" + item.getPubdate());
        helper.setText(R.id.tv_item_rate, "评分：" + item.getRating().getAverage());
        Glide.with(mContext).load(item.getImage()).crossFade(300).into((ImageView) helper.getView
                (R.id.iv_item_image));
    }
}
