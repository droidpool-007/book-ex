package com.bookex.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by faasos on 7/8/15.
 */
public class Utils {
    //private static final String TAG = Constants.TAG;
    //public static CustomProgressDialog sProgressDialog;
    private static Typeface sBoldFont = null;
    private static Typeface sRegularFont = null;

    public static boolean isInternetConnected(Context ctx) {
        ConnectivityManager connectivityMgr = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityMgr != null) {
            NetworkInfo networkInfo = connectivityMgr.getActiveNetworkInfo();
            if(networkInfo != null && networkInfo.isConnected()) {
                return true;
            }
        }
        return false;
    }

    /*public static void showProgressDialog(final Activity activity) {
        try {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    hideProgressDialog();
                    if (sProgressDialog == null) {
                        sProgressDialog = CustomProgressDialog.getInstance(activity);
                    }
                    if (activity != null && !activity.isFinishing()) {
                        sProgressDialog.show();
                    }
                }
            });
        } catch (Exception e) {
            Log.e(Constants.TAG, "showProgressDialog", e);
        }
    }

    public static void hideProgressDialog() {
        try {
            if (sProgressDialog != null && sProgressDialog.isShowing()) {
                try {
                    sProgressDialog.dismiss();
                } catch (Exception e) {
                    Log.e(Constants.TAG, "hideProgressDialog", e);
                }
                sProgressDialog = null;
            }
        } catch (Exception e) {
            Log.e(Constants.TAG, "hideProgressDialog", e);
        }
    }*/

    public static Typeface getRegularFont(Context context) {
        if (sRegularFont == null) {
            sRegularFont = Typeface.createFromAsset(context.getAssets(), "TitilliumWeb-Regular.ttf");
        }
        return sRegularFont;
    }

    public static Typeface getBoldFont(Context context) {
        if (sBoldFont == null) {
            sBoldFont = Typeface.createFromAsset(context.getAssets(), "TitilliumWeb-SemiBold.ttf");
        }
        return sBoldFont;
    }
}