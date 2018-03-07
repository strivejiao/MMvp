package com.jiao.mvplib.base.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.jiao.mvplib.base.BasePresenter;
import com.jiao.mvplib.base.IBaseModel;
import com.jiao.mvplib.base.IBaseView;
import com.jiao.mvplib.base.activity.BaseActivity;
import com.jiao.mvplib.utils.ToastUtils;

/**
 * @Description :mvp fragment基类
 * @Author : StriveJiao
 * @Date : 2018/3/6 20:45
 */

public abstract class BaseMvpFragment<P extends BasePresenter, M extends IBaseModel> extends BaseFragment implements IBaseView {
    public P mPresenter;
    public M mIModel;

    /**
     * 在监听器之前把数据准备好
     */
    public void initData() {
        super.initData();

        mPresenter = (P) initPresenter();
        if (mPresenter != null) {
            mIModel = (M) mPresenter.getModel();
            if (mIModel != null) {
                mPresenter.attachMV(mIModel, this);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachMV();
        }
    }

    @Override
    public void showToast(String msg) {
        ToastUtils.showToast(msg);
    }

    public void startNewActivity(@NonNull Class<?> clz) {
        ((BaseActivity) mActivity).startActivity(clz);
    }

    public void startNewActivity(@NonNull Class<?> clz, Bundle bundle) {
        ((BaseActivity) mActivity).startActivity(clz, bundle);
    }

    public void startNewActivityForResult(@NonNull Class<?> clz, Bundle bundle, int requestCode) {
        ((BaseActivity) mActivity).startActivityForResult(clz, bundle, requestCode);
    }

    public Activity getBindActivity() {
        return mActivity;
    }
}
