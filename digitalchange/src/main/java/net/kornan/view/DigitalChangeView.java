package net.kornan.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import net.kornan.digitalchange.R;

import java.text.DecimalFormat;

/**
 * 数字改变动画
 * Created by KORNAN on 2016/2/4.
 */
public class DigitalChangeView extends TextView implements IDigitalChange {

    private final static String FORMAT_FLOAT_STRING = "##0";

    enum NumberType {
        FLOAT, INT
    }

    enum PlayingState {
        STOPPED, RUNNING
    }

    private NumberType numberType = NumberType.FLOAT;
    private PlayingState mPlayingState = PlayingState.STOPPED;
    private long duration = 1000;
    private float number;
    private float fromNumber = 0.00f;
    private DecimalFormat format;
    private EndListener mEndListener = null;

    public DigitalChangeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DigitalChangeView);
        fromNumber = typedArray.getFloat(R.styleable.DigitalChangeView_defaultValue, 0.00f);
        typedArray.recycle();

    }

    private void setDecimalFormat(int digit) {
        if (digit == 0) {
            format = new DecimalFormat(FORMAT_FLOAT_STRING);
        } else if (digit > 0) {
            String str = FORMAT_FLOAT_STRING + ".";
            for (int i = 0; i < digit; i++) {
                str += "0";
            }
            format = new DecimalFormat(str);
        } else {
            format = new DecimalFormat("##0.00");
        }
    }

    @Override
    public void start() {
        if (!isRunning()) {
            mPlayingState = PlayingState.RUNNING;
            if (numberType == NumberType.INT)
                runInt();
            else
                runFloat();
        }
    }

    @Override
    public void setNumber(float number) {
        this.number = number;
        numberType = NumberType.FLOAT;

    }

    public void setNumber(float number, int digit) {
        this.number = number;
        numberType = NumberType.FLOAT;
        setDecimalFormat(digit);
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
        numberType = NumberType.INT;
    }

    private void runInt() {

        ValueAnimator valueAnimator = ValueAnimator.ofInt((int) fromNumber,
                (int) number);
        valueAnimator.setDuration(duration);

        valueAnimator
                .addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        setText(valueAnimator.getAnimatedValue().toString());
                        if (valueAnimator.getAnimatedFraction() >= 1) {
                            mPlayingState = PlayingState.STOPPED;
                            fromNumber = number;
                            if (mEndListener != null)
                                mEndListener.onEndFinish();
                        }
                    }
                });
        valueAnimator.start();
    }

    private void runFloat() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(fromNumber, number);
        valueAnimator.setDuration(duration);

        valueAnimator
                .addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        setText(format.format(Float.parseFloat(valueAnimator
                                .getAnimatedValue().toString())));
                        if (valueAnimator.getAnimatedFraction() >= 1) {
                            mPlayingState = PlayingState.STOPPED;
                            fromNumber = number;
                            if (mEndListener != null)
                                mEndListener.onEndFinish();
                        }
                    }
                });

        valueAnimator.start();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setDecimalFormat(-1);
    }


    @Override
    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public boolean isRunning() {
        return mPlayingState == PlayingState.RUNNING;
    }

    public void setOnEndListener(EndListener callback) {
        mEndListener = callback;
    }

    public interface EndListener {
        void onEndFinish();
    }

}
