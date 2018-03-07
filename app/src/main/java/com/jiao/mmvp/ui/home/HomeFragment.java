package com.jiao.mmvp.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jiao.mmvp.R;
import com.jiao.mmvp.adapter.HomeAdapter;
import com.jiao.mmvp.contract.HomeContract;
import com.jiao.mmvp.model.bean.HomeListItemBean;
import com.jiao.mmvp.presenter.HomePresenter;
import com.jiao.mvplib.base.BasePresenter;
import com.jiao.mvplib.base.fragment.BaseListFragment;

import java.util.List;

import butterknife.BindView;

/**
 * @Description :
 * @Author : StriveJiao
 * @Date : 2018/3/7 11:08
 */

public class HomeFragment extends BaseListFragment<HomeContract.HomePresenter, HomeContract.IHomeModel> implements HomeContract.IHomeView, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.rv_home)
    RecyclerView rvHome;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private HomeAdapter mAdapter;

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return HomePresenter.newInstance();
    }

    @Override
    protected void onErrorViewClick(View view) {
        mPresenter.loadLatestList();
    }

    @Override
    protected void getData() {
        mPresenter.loadLatestList();
    }

    @Override
    protected void showLoading() {
        mAdapter.setEmptyView(loadingView);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        toolbar.setTitle("首页");
        mAdapter = new HomeAdapter(R.layout.item_home);
        rvHome.setAdapter(mAdapter);
        rvHome.setLayoutManager(new LinearLayoutManager(mActivity));
    }

    @Override
    public void updateContentList(List<HomeListItemBean> list) {
        if (mAdapter.getData().size() > 0) {
            mAdapter.addData(list);
            mAdapter.loadMoreComplete();
        } else {
            mAdapter = new HomeAdapter(R.layout.item_home, list);
            mAdapter.setOnLoadMoreListener(this, rvHome);
            mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    showToast(String.valueOf(position));
                }
            });
            rvHome.setAdapter(mAdapter);
        }
    }

    @Override
    public void itemNotifyChanged(int position) {
        mAdapter.notifyItemChanged(position);
    }

    @Override
    public void showNetworkError() {
        mAdapter.setEmptyView(errorView);
    }

    @Override
    public void showLoadMoreError() {
        mAdapter.loadMoreFail();
    }

    @Override
    public void showNoMoreData() {
        mAdapter.loadMoreEnd(false);
    }

    @Override
    public void onLoadMoreRequested() {
        mPresenter.loadMoreList();
    }
}
