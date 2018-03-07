package com.jiao.mvplib.base.activity;

import com.jiao.mvplib.base.BasePresenter;
import com.jiao.mvplib.base.IBaseModel;
import com.jiao.mvplib.base.IBaseView;
import com.jiao.mvplib.utils.ToastUtils;

/**
 * @Description : mvp Activity基类
 * @Author : StriveJiao
 * @Date : 2018/3/6 20:16
 */

public abstract class BaseMvpActivity<P extends BasePresenter, M extends IBaseModel> extends BaseActivity implements IBaseView {

    /**
     * presenter 具体的presenter由子类确定
     */
    protected P mPresenter;

    /**
     * model 具体的model由子类确定
     */
    private M mIModel;

    @Override
    protected void initData() {
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
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachMV();
        }
    }

    @Override
    public void showToast(String msg) {
        ToastUtils.showToast(msg);
    }
}
