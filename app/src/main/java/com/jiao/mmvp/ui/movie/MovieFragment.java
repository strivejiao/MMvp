package com.jiao.mmvp.ui.movie;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jiao.mmvp.R;
import com.jiao.mmvp.adapter.HomeAdapter;
import com.jiao.mmvp.adapter.MovieAdapter;
import com.jiao.mmvp.contract.MovieContract;
import com.jiao.mmvp.model.bean.MovieItemBean;
import com.jiao.mmvp.presenter.MoviePresenter;
import com.jiao.mmvp.ui.home.HomeFragment;
import com.jiao.mvplib.base.BasePresenter;
import com.jiao.mvplib.base.fragment.BaseListFragment;

import java.util.List;

import butterknife.BindView;

/**
 * @Description : 影视
 * @Author : StriveJiao
 * @Date : 2018/3/7 15:13
 */

public class MovieFragment extends BaseListFragment<MovieContract.MoviePresenter, MovieContract.IMovieModel> implements MovieContract.IMovieView {

    @BindView(R.id.rv_movie)
    RecyclerView rvMovie;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private MovieAdapter mAdapter;

    public static MovieFragment newInstance() {
        Bundle args = new Bundle();
        MovieFragment fragment = new MovieFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return MoviePresenter.newInstance();
    }

    @Override
    protected void onErrorViewClick(View view) {

    }

    @Override
    protected void getData() {
        mPresenter.loadMovieList();
    }

    @Override
    protected void showLoading() {
        mAdapter.setEmptyView(loadingView);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_movie;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        toolbar.setTitle("影视");
        mAdapter = new MovieAdapter(R.layout.item_movie);
        rvMovie.setAdapter(mAdapter);
        rvMovie.setLayoutManager(new LinearLayoutManager(mActivity));
    }

    @Override
    public void updateContentList(List<MovieItemBean> list) {
        mAdapter = new MovieAdapter(R.layout.item_movie, list);
        rvMovie.setAdapter(mAdapter);
    }

    @Override
    public void itemNotifyChanged(int position) {

    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void showLoadMoreError() {

    }

    @Override
    public void showNoMoreData() {

    }
}
