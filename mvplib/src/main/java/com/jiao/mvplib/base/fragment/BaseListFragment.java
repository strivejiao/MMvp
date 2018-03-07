package com.jiao.mvplib.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiao.mvplib.R;
import com.jiao.mvplib.base.BasePresenter;
import com.jiao.mvplib.base.IBaseModel;

/**
 * @Description :列表 fragment 基类
 * @Author : StriveJiao
 * @Date : 2018/3/6 20:52
 */

public abstract class BaseListFragment<P extends BasePresenter, M extends IBaseModel> extends BaseMvpFragment<P, M> {
    /**
     * 网络异常View
     */
    protected View errorView;

    /**
     * 没有内容view
     */
    protected View emptyView;

    /**
     * loadingView
     */
    protected View loadingView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        errorView = inflater.inflate(R.layout.view_network_error, container, false);
        emptyView = inflater.inflate(R.layout.view_empty, container, false);
        loadingView = inflater.inflate(R.layout.view_loading, container, false);
        errorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoading();
                onErrorViewClick(v);
            }
        });
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
        showLoading();
    }

    /**
     * 网络异常view被点击时触发，由子类实现
     *
     * @param view view
     */
    protected abstract void onErrorViewClick(View view);

    /**
     * 获取数据，由子类实现
     */
    protected abstract void getData();

    /**
     * 显示加载中view，由子类实现
     */
    protected abstract void showLoading();

}
