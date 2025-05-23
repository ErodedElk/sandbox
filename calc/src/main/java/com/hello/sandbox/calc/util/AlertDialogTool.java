package com.hello.sandbox.calc.util;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.hello.sandbox.calc.R;


public class AlertDialogTool {

    public static AlertDialog buildCustomBottomPopupDialog(Context context, View v) {
        return buildCustomStylePopupDialogGravity(context, v, Gravity.BOTTOM, R.style.DialogBottomPopup, true);
    }
    public static AlertDialog buildCustomStylePopupDialogGravity(Context context, View v, int gravity, int anim) {
        return buildCustomStylePopupDialogGravity(context, v, gravity, anim, true);
    }
    public static AlertDialog buildCustomStylePopupDialogGravity(Context context, View v, int gravity, int anim, boolean cancelable) {
        AlertDialog dialog = new AlertDialog.Builder(context, R.style.WhiteRoundDialog)
                .setView(v)
                .setCancelable(cancelable)
                .create();

        Window window = dialog.getWindow();
        window.setGravity(gravity);
        window.getDecorView().setPadding(0, 0, 0, 0);

        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        window.setAttributes(lp);
        window.setWindowAnimations(anim);

        return dialog;
    }
    public static AlertDialog.Builder buildBottomPopupDialogBuilder(Context context) {
        return new AlertDialog.Builder(context, R.style.WhiteRoundDialog);
    }
    public static AlertDialog buildBottomPopupDialog(AlertDialog.Builder builder) {
        AlertDialog dialog = builder.create();

        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.getDecorView().setPadding(0, 0, 0, 0);

        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        window.setAttributes(lp);
        window.setWindowAnimations(R.style.DialogBottomPopup);

        return dialog;
    }

}
