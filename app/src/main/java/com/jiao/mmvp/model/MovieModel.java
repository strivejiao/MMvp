package com.jiao.mmvp.model;

import android.support.annotation.NonNull;

import com.jiao.mmvp.contract.MovieContract;
import com.jiao.mmvp.model.bean.MovieListBean;
import com.jiao.mvplib.base.IModelCallBack;
import com.jiao.vhttp.http.VHttp;
import com.jiao.vhttp.http.callback.ACallback;

/**
 * @Description : 影视
 * @Author : StriveJiao
 * @Date : 2018/3/7 15:15
 */

public class MovieModel implements MovieContract.IMovieModel {
    private static IModelCallBack mListener;

    @NonNull
    public static MovieModel newInstance(IModelCallBack listener) {
        mListener = listener;
        return new MovieModel();
    }

    @Override
    public void getMovieList() {
        VHttp.CONFIG().baseUrl("Https://api.douban.com/");
        VHttp.GET("v2/movie/in_theaters").request(new ACallback<MovieListBean>() {
            @Override
            public void onSuccess(MovieListBean movieListBean) {

                if (movieListBean != null) {
                    mListener.onSuccess(movieListBean);
                }
            }

            @Override
            public void onFail(int i, String s) {
                mListener.onFail(i, s);
            }
        });
    }
}
