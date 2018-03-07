package com.jiao.mvplib.base;

import android.support.annotation.NonNull;

/**
 * @Description : View基类
 * @Author : StriveJiao
 * @Date : 2018/3/5 11:09
 */

public interface IBaseView {
    /**
     * 初始化presenter
     * <p>
     * 此方法返回的presenter对象不可为空
     */
    @NonNull
    BasePresenter initPresenter();

    /**
     * 显示toast消息
     *
     * @param msg 要显示的toast消息字符串
     */
    void showToast(String msg);

}
