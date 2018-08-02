package com.example.nguyenanhphan.smarttravelver2.Common;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * @author Quốc Huy
 * @version 1.0.0
 * @description : Cung cấp 2 phương thức để hiển thị và xử lí popup confirm
 * phương thức 1: popup confirm có 2 button( yes/no) và cung cấp interface tương ứng để xử lí 2 button
 * phương thức 2: popup confirm
 * @desc Developer NEO Company.
 * @created ${Date}
 * @updated ${Date}
 * @modified by
 * @updated on ${Date}
 * @since 1.0
 */
public class Commons {
    ClickDialog clickDialog;

    /**
     * @param context
     * @param title
     * @param mes
     * @param titleButtonOne
     * @param titleButtonTwo
     * @param clickDialog
     */
    public static void ShowAlertDialogTwoButton(Context context, String title, String mes,
                                                String titleButtonOne, String titleButtonTwo,
                                                final ClickDialog clickDialog) {
        AlertDialog.Builder b = new AlertDialog.Builder(context);
        b.setCancelable(false);
        b.setTitle(title);
        b.setMessage(mes);
        b.setPositiveButton(titleButtonOne, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                clickDialog.onClickYesDialog();
            }
        });
        b.setNegativeButton(titleButtonTwo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                clickDialog.onClickNoDialog();
                dialog.dismiss();
            }
        });
        AlertDialog dialog = b.create();
//        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation_2;
        dialog.show();


    }

    public interface ClickDialog {
        public void onClickYesDialog();

        public void onClickNoDialog();
    }

    /**
     * @param context
     * @param title
     * @param message
     * @return
     */
    public static AlertDialog showDialog(final Context context, String title, String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        if (title != null && !title.isEmpty()) {
            alertDialogBuilder.setTitle(title);
        }

        alertDialogBuilder.setMessage(message);

        alertDialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        alertDialogBuilder.setCancelable(false);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        return alertDialog;
    }
}
