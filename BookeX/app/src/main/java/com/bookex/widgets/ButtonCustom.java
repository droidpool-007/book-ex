package com.bookex.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.bookex.R;

import com.bookex.utils.Utils;

/**
 * Created by Poonam on 8/20/15.
 */
public class ButtonCustom extends TextViewCustom {

  private int isBold = 0;

  public ButtonCustom(Context context) { super(context); }

  public ButtonCustom(Context context, AttributeSet attrs) {
    super(context, attrs);
    checkIsBold(context, attrs);
  }

  public ButtonCustom(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    checkIsBold(context, attrs);
  }

  protected void checkIsBold(Context context, AttributeSet attrs) {
    TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.TextViewCustom);
    if (a != null) {
      isBold = a.getInt(R.styleable.TextViewCustom_isBold, 0);
      a.recycle();
    }

    if (isBold == 0) {
      setTypeface(Utils.getRegularFont(context));
    } else {
      setTypeface(Utils.getBoldFont(context));
    }
  }
}
