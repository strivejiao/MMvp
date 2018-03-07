package com.jiao.mmvp;

import com.jiao.mvplib.app.MMvpApplication;
import com.jiao.vhttp.http.VHttp;
import com.jiao.vhttp.http.interceptor.HttpLogInterceptor;

/**
 * @Description :
 * @Author : StriveJiao
 * @Date : 2018/3/7 9:51
 */

public class MyApplication extends MMvpApplication {

    public static MyApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        init();
    }

    private void init() {
        VHttp.init(this);
        VHttp.CONFIG()
                .log(true)
                .interceptor(new HttpLogInterceptor().setLevel(HttpLogInterceptor.Level.BODY));
    }
}
