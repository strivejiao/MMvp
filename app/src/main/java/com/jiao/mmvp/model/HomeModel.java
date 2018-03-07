package com.jiao.mmvp.model;

import android.support.annotation.NonNull;

import com.jiao.mmvp.contract.HomeContract;
import com.jiao.mmvp.model.bean.HomeListBean;
import com.jiao.mvplib.base.IModelCallBack;
import com.jiao.vhttp.http.VHttp;
import com.jiao.vhttp.http.callback.ACallback;

/**
 * @Description :
 * @Author : StriveJiao
 * @Date : 2018/3/7 11:18
 */

public class HomeModel implements HomeContract.IHomeModel {

    private static IModelCallBack mListener;

    @NonNull
    public static HomeModel newInstance(IModelCallBack listener) {
        mListener = listener;
        return new HomeModel();

    }

    @Override
    public void getDailyList(String date) {
        VHttp.CONFIG().baseUrl("http://news-at.zhihu.com");
        VHttp.GET("/api/4/news/before/" + date).request(new ACallback<HomeListBean>() {
            @Override
            public void onSuccess(HomeListBean homeListBean) {
                if (homeListBean != null) {
                    mListener.onSuccess(homeListBean);
                } else {
                    mListener.onFail(0, "访问异常");
                }
            }

            @Override
            public void onFail(int i, String s) {
                mListener.onFail(i, s);
            }
        });
    }

    @Override
    public void getDailyList() {
        VHttp.CONFIG().baseUrl("http://news-at.zhihu.com");
        VHttp.GET("/api/4/news/latest").request(new ACallback<HomeListBean>() {
            @Override
            public void onSuccess(HomeListBean homeListBean) {
                if (homeListBean != null) {
                    mListener.onSuccess(homeListBean);
                } else {
                    mListener.onFail(0, "访问异常");
                }
            }

            @Override
            public void onFail(int i, String s) {
                mListener.onFail(i, s);
            }
        });
    }
}
