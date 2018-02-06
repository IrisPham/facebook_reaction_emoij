package com.facebook.reaction.emotion.utils;

import android.content.res.Resources;

/**
 * Created by Android Studio on 2/6/2018.
 */

public class Util {
    /*
    * Convert dp to pixel
    * */
    public static int dpToPx(int dp){
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
