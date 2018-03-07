package com.jiao.mmvp.contract;

import com.jiao.mmvp.model.bean.BookItemBean;
import com.jiao.mvplib.base.BasePresenter;
import com.jiao.mvplib.base.IBaseModel;


/**
 * @Description : 书籍
 * @Author : StriveJiao
 * @Date : 2018/3/7 16:11
 */

public interface BookContract {
    abstract class BookPresenter extends BasePresenter<IBookModel, IBookView> {
        /**
         * 加载最新的book list
         */
        public abstract void loadLatestBookList();

        /**
         * 加载更多book list
         */
        public abstract void loadMoreBookList();

    }

    interface IBookModel extends IBaseModel {
        /**
         * 根据tag获取图书
         *
         * @param tag   搜索关键字
         * @param start 从多少开始，如从"0"开始
         * @param count 一次请求的数目 最多100
         * @return Observable
         */
        void getBookListWithTag(String tag, int start, int count);
    }

    interface IBookView extends BaseContract.IBaseMyView<BookItemBean> {

    }
}
