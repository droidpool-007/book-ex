package com.bookex.widgets;

/**
 * Created by daily on 08/07/15.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class TextInputLayoutFaasos extends TextInputLayout {

    private boolean mIsHintSet;
    private CharSequence mHint;

    public TextInputLayoutFaasos(Context context) {
        super(context);
    }

    public TextInputLayoutFaasos(Context context, AttributeSet attrs) {

        super(context, attrs);

    }

    // Since hint will be nullify on EditText once on parent addView, store hint value locally
    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (child instanceof EditText) {
            mHint = ((EditText) child).getHint();
        }
        super.addView(child, index, params);
    }

    /*We have to reset the previous hint so that equals check pass
    In case that hint is changed programmatically*/
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!mIsHintSet && ViewCompat.isLaidOut(this)) {
            setHint(null);
            CharSequence currentEditTextHint = getEditText().getHint();
            if (currentEditTextHint != null && currentEditTextHint.length() > 0) {
                mHint = currentEditTextHint;
            }
            setHint(mHint);
            mIsHintSet = true;
        }
    }


}