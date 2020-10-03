package com.tae.deminer.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.tae.deminer.GameEngine;
import com.tae.deminer.R;

public class Cell extends BaseCell implements View.OnClickListener {

    public Cell(Context context, int position) {
        super(context);
        setPosition(position);
        setOnClickListener(this);
    }

    // every button to be square
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    @Override
    public void onClick(View v) {
        GameEngine.getInstance().click(getXpos(),getYpos());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e ("Minesweeper", "CeLL* onDraw");
        drawButton(canvas);
        if(isFlagged()) {
            drawFlag(canvas);
        } else if (isRevealed()&&isBomb()&&!isClicked()) {
            drawBomb(canvas);
        } else if (isClicked()) {
            if (getValue()==-1) {
                drawBombExploded(canvas);
             } else drawNumber(canvas);
        } else drawButton(canvas);
    }

    private void drawButton (Canvas canvas) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.button);
        drawable.setBounds(0,0, getWidth(),getHeight());
        drawable.draw(canvas);
    }

    private void drawBomb (Canvas canvas) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.bomb_normal);
        drawable.setBounds(0,0, getWidth(),getHeight());
        drawable.draw(canvas);
    }

    private void drawBombExploded (Canvas canvas) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.bomb_exploded);
        drawable.setBounds(0,0, getWidth(),getHeight());
        drawable.draw(canvas);
    }
    private void drawFlag (Canvas canvas) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.flag);
        drawable.setBounds(0,0, getWidth(),getHeight());
        drawable.draw(canvas);
    }

    private void drawNumber (Canvas canvas) {
        Drawable drawable = null;
        switch (getValue()) {
            case 0: drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_0);
            break;
            case 1:drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_1);
            break;
            case 2:drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_2);
            break;
            case 3:drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_3);
            break;
            case 4: drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_4);
            break;
            case 5:drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_5);
            break;
            case 6:drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_6);
            break;
            case 7:drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_7);
            break;
            case 8:drawable = ContextCompat.getDrawable(getContext(), R.drawable.number_8);
            break;

        }
        drawable.setBounds(0,0, getWidth(),getHeight());
        drawable.draw(canvas);
    }
}
