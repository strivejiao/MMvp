package com.jiao.mmvp.presenter;

import android.support.annotation.NonNull;

import com.jiao.mmvp.contract.MovieContract;
import com.jiao.mmvp.model.MovieModel;
import com.jiao.mmvp.model.bean.MovieListBean;
import com.jiao.mvplib.base.IModelCallBack;

/**
 * @Description : 影视
 * @Author : StriveJiao
 * @Date : 2018/3/7 15:26
 */

public class MoviePresenter extends MovieContract.MoviePresenter implements IModelCallBack {

    @NonNull
    public static MoviePresenter newInstance() {
        return new MoviePresenter();
    }

    @Override
    public void onSuccess(Object result) {
        MovieListBean data = (MovieListBean) result;
        if (data.subjects != null && data.subjects.size() > 0) {
            mIView.updateContentList(data.subjects);
        }
    }

    @Override
    public void onFail(int errorCode, String errorMsg) {

    }

    @Override
    public MovieContract.IMovieModel getModel() {
        return MovieModel.newInstance(this);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void loadMovieList() {
        mIModel.getMovieList();
    }
}
