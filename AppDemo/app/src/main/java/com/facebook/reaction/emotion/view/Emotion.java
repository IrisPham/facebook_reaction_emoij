package com.facebook.reaction.emotion.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.facebook.reaction.emotion.utils.Util;

/**
 * Created by Android Studio on 2/6/2018.
 */

public class Emotion {

    private Context mContext;

    public static final int MINIMAL_SIZE = Util.dpToPx(28);

    public static final int NORMAL_SIZE = Util.dpToPx(40);

    public static final int CHOOSE_SIZE = Util.dpToPx(100);

    public static final int DISTANCE = Util.dpToPx(15);

    public static final int MAX_WIDTH_TITILE = Util.dpToPx(70);

    public int currentSize = NORMAL_SIZE;

    public int beginSize;

    public int endSize;

    public float currentX;

    public float currentY;

    public float beginY;

    public float endY;

    public Bitmap imageOrigin;

    public Bitmap imageTitle;

    public Paint emotionPaint;

    public Paint titlePanit;

    private float ratioWH;

    public Emotion(Context context, String title, int imageResource){
        this.mContext = context;

        imageOrigin = BitmapFactory.decodeResource(context.getResources(), imageResource);

        emotionPaint = new Paint(Paint.FILTER_BITMAP_FLAG);
        emotionPaint.setAntiAlias(true);

        generateTitleView(title);
    }

    private void generateTitleView(String title) {
    }

    public void setAlphaTitle(int alpha){
        titlePanit.setAlpha(alpha);
    }

    public void drawEmotion(Canvas canvas){
        canvas.drawBitmap(imageOrigin, null, new RectF(currentX, currentY, currentX + currentSize, currentY + currentSize),emotionPaint);
    }

    public void drawTitle(Canvas canvas){

    }

}
