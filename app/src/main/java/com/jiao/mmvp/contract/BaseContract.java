package com.jiao.mmvp.contract;

import com.jiao.mvplib.base.BasePresenter;
import com.jiao.mvplib.base.IBaseModel;
import com.jiao.mvplib.base.IBaseView;

import java.util.List;

/**
 * @Description : 协议基类
 * @Author : StriveJiao
 * @Date : 2018/3/7 11:09
 */

public interface BaseContract {
    abstract class BaseMyPresenter<M extends IBaseModel, V extends IBaseMyView, T>
            extends BasePresenter<M, V> {
        /**
         * 加载最新的list
         */
        public abstract void loadLatestList();

        /**
         * 加载更多list
         */
        public abstract void loadMoreList();

        /**
         * item点击事件
         *
         * @param position position
         * @param item     item
         */
        public abstract void onItemClick(int position, T item);
    }


    interface IBaseMyView<L> extends IBaseView {
        /**
         * 更新界面list
         *
         * @param list list
         */
        void updateContentList(List<L> list);

        /**
         * 点击事件后，刷新item
         *
         * @param position position
         */
        void itemNotifyChanged(int position);

        /**
         * 显示网络错误
         */
        void showNetworkError();

        /**
         * 显示加载更多错误
         */
        void showLoadMoreError();

        /**
         * 显示没有更多数据
         */
        void showNoMoreData();
    }
}
