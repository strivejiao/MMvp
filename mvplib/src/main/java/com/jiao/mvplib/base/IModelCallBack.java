package com.jiao.mvplib.base;

/**
 * @Description : Model回调Presenter基类
 * @Author : StriveJiao
 * @Date : 2018/3/5 11:13
 */

public interface IModelCallBack {
    void onSuccess(Object result);

    void onFail(int errorCode, String errorMsg);
}
