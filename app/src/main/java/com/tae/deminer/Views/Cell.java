package com.tae.deminer.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.core.content.ContextCompat;

import com.tae.deminer.R;

public class Cell extends BaseCell {

    public Cell(Context context, int position) {
        super(context);
        setPosition(position);
    }

    // every button to be square
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e ("Minesweeper", "CeLL* onDraw");
        drawButton(canvas);
    }

    private void drawButton (Canvas canvas) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.btn);
        drawable.setBounds(0,0, getWidth(),getHeight());
        drawable.draw(canvas);
    }

}
