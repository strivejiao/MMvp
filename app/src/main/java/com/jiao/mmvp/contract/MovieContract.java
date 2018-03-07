package com.jiao.mmvp.contract;

import com.jiao.mmvp.model.bean.MovieItemBean;
import com.jiao.mvplib.base.BasePresenter;
import com.jiao.mvplib.base.IBaseModel;
import com.jiao.mvplib.base.IBaseView;

import java.util.List;

/**
 * @Description : 影视
 * @Author : StriveJiao
 * @Date : 2018/3/7 15:13
 */

public interface MovieContract {

    abstract class MoviePresenter extends BasePresenter<IMovieModel, IMovieView> {
        /**
         * 加载最新的最热电影
         */
        public abstract void loadMovieList();
    }

    interface IMovieModel extends IBaseModel {
        /**
         * 获取最热电影
         *
         * @return 最热电影
         */
        void getMovieList();
    }

    interface IMovieView extends BaseContract.IBaseMyView<MovieItemBean> {

    }
}
