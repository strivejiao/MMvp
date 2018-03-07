package com.jiao.mvplib.widget;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * @Description : loading
 * @Author : StriveJiao
 * @Date : 2018/3/6 19:46
 */

public class LoadingDialog extends ProgressDialog {
    public LoadingDialog(Context context) {
        this(context, 0);
    }

    public LoadingDialog(Context context, int theme) {
        super(context, theme);
        setCanceledOnTouchOutside(false);
    }
}
