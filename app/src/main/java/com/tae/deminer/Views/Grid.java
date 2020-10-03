package com.tae.deminer.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import com.tae.deminer.GameEngine;

public class Grid  extends GridView {

    public Grid(Context context, AttributeSet attributeSet) {
        super (context, attributeSet);
        GameEngine.getInstance().createGrid(context);
        setNumColumns(GameEngine.WIDTH);
        setAdapter(new GridApater());
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    private class GridApater extends BaseAdapter {

        @Override
        public int getCount() {
            return GameEngine.getInstance().WIDTH*GameEngine.getInstance().HEIGHT;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return GameEngine.getInstance().getCellAt(position);
        }
    }

}
