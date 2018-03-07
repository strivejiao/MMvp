package com.jiao.mmvp.presenter;

import android.support.annotation.NonNull;

import com.jiao.mmvp.contract.BookContract;
import com.jiao.mmvp.model.BookModel;
import com.jiao.mmvp.model.bean.BookListBean;
import com.jiao.mvplib.base.IModelCallBack;

/**
 * @Description : 书籍
 * @Author : StriveJiao
 * @Date : 2018/3/7 16:18
 */

public class BookPresenter extends BookContract.BookPresenter implements IModelCallBack {
    private int start = 0;
    private int count = 10;
    private String tag = "文学";

    @NonNull
    public static BookPresenter newInstance() {
        return new BookPresenter();
    }

    @Override
    public void onSuccess(Object result) {
        BookListBean data = (BookListBean) result;
        if (data.getBooks() != null && data.getBooks().size() > 0) {
            mIView.updateContentList(data.getBooks());
            start += data.getBooks().size();
        }
    }

    @Override
    public void onFail(int errorCode, String errorMsg) {
        if (start == 0) {
            mIView.showNetworkError();
        } else {
            mIView.showLoadMoreError();
        }
    }

    @Override
    public BookContract.IBookModel getModel() {
        return BookModel.newInstance(this);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void loadLatestBookList() {
        start = 0;
        mIModel.getBookListWithTag(tag, start, count);
    }

    @Override
    public void loadMoreBookList() {
        mIModel.getBookListWithTag(tag, start, count);
    }
}
