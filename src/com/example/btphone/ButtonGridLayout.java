package com.example.btphone;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;


public class ButtonGridLayout extends ViewGroup {
	private static int COLUMNS;
	private static int NUM_CHILDREN;
	private static int ROWS;
	private int mButtonHeight;
	private int mButtonWidth;
	private View[] mButtons;
	private int mHeight;
	private int mHeightInc;
	private int mWidth;
	private int mWidthInc;
	private int mPaddingLeft = 0;
	private int mPaddingRight = 0;
	private int mPaddingTop = 0;
	private int mPaddingBottom = 0;

	public ButtonGridLayout(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public ButtonGridLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.DialpadLayout, defStyle, 0);

		COLUMNS = a.getInt(R.styleable.DialpadLayout_columns, 3);
		ROWS = a.getInt(R.styleable.DialpadLayout_rows, 3);
		NUM_CHILDREN = (ROWS * COLUMNS);
		mButtons = new View[NUM_CHILDREN];
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		View[] buttons = mButtons;
		for (int i = 0; i < NUM_CHILDREN; i++) {
			buttons[i] = getChildAt(i);
			buttons[i].measure(0, 0);
		}
		View child = buttons[2];
		mButtonWidth = child.getMeasuredWidth();
		mButtonHeight = child.getMeasuredHeight();
		mWidthInc = ((mButtonWidth + mPaddingLeft) + mPaddingRight);
		mHeightInc = ((mButtonHeight + mPaddingTop) + mPaddingBottom);
		mWidth = (COLUMNS * mWidthInc);
		mHeight = (ROWS * mHeightInc);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		View[] buttons = mButtons;
		int paddingLeft = mPaddingLeft;
		int buttonWidth = mButtonWidth;
		int buttonHeight = mButtonHeight;
		int widthInc = mWidthInc;
		int heightInc = mHeightInc;

		int i = 0;
		int y = mPaddingTop;
		for (int row = 0; row < ROWS; row++) {
			int x = paddingLeft;
			for (int col = 0; col < COLUMNS; col++) {

				buttons[i].layout(x, y, (x + buttonWidth), (y + buttonHeight));
				x += widthInc;
				i++;
			}
			y += heightInc;
		}
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int width = resolveSize(mWidth, widthMeasureSpec);
		int height = resolveSize(mHeight, heightMeasureSpec);
		setMeasuredDimension(width, height);
	}
}
