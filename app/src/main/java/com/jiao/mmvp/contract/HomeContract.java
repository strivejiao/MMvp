package com.jiao.mmvp.contract;

import com.jiao.mmvp.model.bean.HomeListItemBean;
import com.jiao.mvplib.base.IBaseModel;

/**
 * @Description :首页
 * @Author : StriveJiao
 * @Date : 2018/3/7 11:13
 */

public interface HomeContract {

    abstract class HomePresenter extends BaseContract.BaseMyPresenter<IHomeModel, IHomeView, HomeListItemBean> {

    }

    interface IHomeModel extends IBaseModel {

        void getDailyList(String date);

        void getDailyList();
    }


    interface IHomeView extends BaseContract.IBaseMyView<HomeListItemBean> {

    }
}
