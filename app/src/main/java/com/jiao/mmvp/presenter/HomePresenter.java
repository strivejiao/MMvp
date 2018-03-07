package com.jiao.mmvp.presenter;

import android.support.annotation.NonNull;

import com.jiao.mmvp.contract.HomeContract;
import com.jiao.mmvp.model.HomeModel;
import com.jiao.mmvp.model.bean.HomeListBean;
import com.jiao.mmvp.model.bean.HomeListItemBean;
import com.jiao.mvplib.base.IModelCallBack;

/**
 * @Description :
 * @Author : StriveJiao
 * @Date : 2018/3/7 11:21
 */

public class HomePresenter extends HomeContract.HomePresenter implements IModelCallBack {

    private String mDate;

    @NonNull
    public static HomePresenter newInstance() {
        return new HomePresenter();
    }

    @Override
    public HomeContract.IHomeModel getModel() {
        return HomeModel.newInstance(this);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void loadLatestList() {
        mIModel.getDailyList();
    }

    @Override
    public void loadMoreList() {
        mIModel.getDailyList(mDate);
    }

    @Override
    public void onItemClick(int position, HomeListItemBean item) {

    }

    @Override
    public void onSuccess(Object result) {
        HomeListBean data = (HomeListBean) result;
        if (mDate != null && data.date.equals(mDate)) {
            return;
        }
        mDate = data.date;
        if (data.stories != null && data.stories.size() > 0) {
            mIView.updateContentList(data.stories);
        } else {
            mIView.showNoMoreData();
        }
    }

    @Override
    public void onFail(int errorCode, String errorMsg) {
        if (mDate != null) {
            mIView.showLoadMoreError();
        } else {
            mIView.showNetworkError();
        }
    }
}
