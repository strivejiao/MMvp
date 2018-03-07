package com.jiao.mmvp.ui.book;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jiao.mmvp.R;
import com.jiao.mmvp.adapter.BookAdapter;
import com.jiao.mmvp.contract.BookContract;
import com.jiao.mmvp.model.bean.BookItemBean;
import com.jiao.mmvp.presenter.BookPresenter;
import com.jiao.mvplib.base.BasePresenter;
import com.jiao.mvplib.base.fragment.BaseListFragment;

import java.util.List;

import butterknife.BindView;

/**
 * @Description :
 * @Author : StriveJiao
 * @Date : 2018/3/7 16:13
 */

public class BookFragment extends BaseListFragment<BookContract.BookPresenter, BookContract.IBookModel> implements BookContract.IBookView {
    @BindView(R.id.rv_book)
    RecyclerView rvBook;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private BookAdapter mAdapter;

    public static BookFragment newInstance() {
        Bundle args = new Bundle();
        BookFragment fragment = new BookFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return BookPresenter.newInstance();
    }

    @Override
    public void updateContentList(List<BookItemBean> list) {
        if (mAdapter.getData().size() == 0) {
            mAdapter = new BookAdapter(R.layout.item_book, list);
            mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                @Override
                public void onLoadMoreRequested() {
                    mPresenter.loadMoreBookList();
                }
            });
            mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    showToast(String.valueOf(position));
                }
            });
            rvBook.setAdapter(mAdapter);
        } else {
            mAdapter.addData(list);
            mAdapter.loadMoreComplete();
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
        mAdapter.loadMoreEnd();
    }

    @Override
    protected void onErrorViewClick(View view) {
        mPresenter.loadLatestBookList();
    }

    @Override
    protected void getData() {
        mPresenter.loadLatestBookList();
    }

    @Override
    protected void showLoading() {
        mAdapter.setEmptyView(loadingView);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_book;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        toolbar.setTitle("书库");
        mAdapter = new BookAdapter(R.layout.item_book);
        rvBook.setAdapter(mAdapter);
        rvBook.setLayoutManager(new LinearLayoutManager(mActivity));
    }
}
