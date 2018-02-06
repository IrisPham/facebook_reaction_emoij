package com.facebook.reaction.emotion.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import com.facebook.reaction.emotion.R;
import com.facebook.reaction.emotion.utils.CommonDimen;

/**
 * Created by Android Studio on 2/6/2018.
 */

public class ReactionView  extends View{

    /*
     * "Begin": là trạng thái các thành phần bắt đầu xuất hiện
     * "NORMAL": là trạng thái các kích thước emotion tương tự nhau, nằm ngay ngắn trong box
     * "CHOOSING": là trạng thái emotion được chọn phóng to, emotion còn lại thu nhỏ + box thu nhỏ lại
     * "END": là trạng thái emotion được chọn sẽ bắn vút lên, các emtion còn lại sẽ sụp xuống và biến mất hoàn toàn
    * */
    enum StateDraw{
        BEGIN,
        NORMAL,
        CHOOSING,
        END
    }

    public static final long DURATION_ANIMATION = 200;
    public static final long DURATION_BEGINNING_EACH_ITEM = 300;
    public static final long DURATION_BEGINNING_ANIMATION = 900;

    private Board mBroad;

    private Emotion[] mEmotion = new Emotion[6];

    private StateDraw mStateDraw = StateDraw.BEGIN;
    private int mCurrentPosition = 0;

    public ReactionView(Context context) {
        super(context);
        init();
    }

    public ReactionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ReactionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mBroad = new Board(getContext());
        setLayerType(LAYER_TYPE_SOFTWARE, mBroad.boardPaint);

        mEmotion[0] = new Emotion(getContext(), "Like", R.drawable.like);
        mEmotion[1] = new Emotion(getContext(),"Love", R.drawable.love);
        mEmotion[2] = new Emotion(getContext(),"Haha", R.drawable.haha);
        mEmotion[3] = new Emotion(getContext(),"Wow", R.drawable.wow);
        mEmotion[4] = new Emotion(getContext(), "Cry", R.drawable.cry);
        mEmotion[5] = new Emotion(getContext(),"Angry", R.drawable.angry);

        //BEGIN: Đoạn này để đặt các thành phần vào vị trí ban đầu để xem kết quả thui,
        //chứ các thành phần ban đầu sẽ bị ẩn đi, vì chưa click like mà :D
        for (int i = 0; i < mEmotion.length; i++) {
            mEmotion[i].currentY = Board.BASE_LINE - Emotion.NORMAL_SIZE;
            mEmotion[i].currentX = i == 0 ? Board.BOARD_X + CommonDimen.DIVIDE : mEmotion[i - 1].currentX + mEmotion[i - 1].currentSize + CommonDimen.DIVIDE;
        }
        //END

        initElement();

    }

    private void initElement(){

    }

    @Override
    protected void onDraw(Canvas canvas) {
        mBroad.drawBoard(canvas);
        for (Emotion emotion : mEmotion) {
            emotion.drawEmotion(canvas);
        }
    }

    private void beforeAnimateBeginning(){

    }

    private void beforeAnimateChoosing(){

    }

    private void beforeAnimatieNormalBack(){

    }

    /*
    * Tính toán chu kì chọn và kết thúc
    * @param thời gian nội suy
    * */
    private void calculateInSessionChoosingAndEnding(float interpolatedTime){

    }

    /*
    * Tính toán chu kì bắt đầu
    * @param thời gian nội suy
    * */
    private void calculateInSeesionBeginning(float interpolatedTime){

    }

    private int calculateSize(int position, float interpolatedTime){
        return 0;
    }

    /*
    * Tính toán tọa độ X
    * */
    private void calculateCoordinateX(){

    }

    private void show(){

    }

    private void selected(int position){

    }

    private void backNormal(){

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }

    class ChooseEmotionAnimation extends Animation{

        public ChooseEmotionAnimation() {
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            //super.applyTransformation(interpolatedTime, t);
        }
    }

    class BeginningAnimation extends Animation{

        public BeginningAnimation() {
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            //super.applyTransformation(interpolatedTime, t);
        }
    }
}
