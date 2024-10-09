package com.aakash.simpleuserlist.utils;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import com.aakash.simpleuserlist.R;


public class LoadingDialog {

    private final Dialog dialog;


    public LoadingDialog(Context context) {
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_loading);
        dialog.setCancelable(false);


    }


    public void show() {
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    public void dismiss() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
