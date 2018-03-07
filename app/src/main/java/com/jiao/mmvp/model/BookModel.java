package com.jiao.mmvp.model;

import android.support.annotation.NonNull;

import com.jiao.mmvp.contract.BookContract;
import com.jiao.mmvp.model.bean.BookListBean;
import com.jiao.mvplib.base.IModelCallBack;
import com.jiao.vhttp.http.VHttp;
import com.jiao.vhttp.http.callback.ACallback;

/**
 * @Description : 书籍
 * @Author : StriveJiao
 * @Date : 2018/3/7 16:17
 */

public class BookModel implements BookContract.IBookModel {
    private static IModelCallBack mListener;

    @NonNull
    public static BookModel newInstance(IModelCallBack listener) {
        mListener = listener;
        return new BookModel();

    }

    @Override
    public void getBookListWithTag(String tag, int start, int count) {
        VHttp.CONFIG().baseUrl("Https://api.douban.com/");
        VHttp.GET("v2/book/search?tag=" + tag + "&start=" + start + "&count=" + count).request(new ACallback<BookListBean>() {
            @Override
            public void onSuccess(BookListBean bookListBean) {

                if (bookListBean != null) {
                    mListener.onSuccess(bookListBean);
                }
            }

            @Override
            public void onFail(int i, String s) {
                mListener.onFail(i, s);
            }
        });
    }
}
