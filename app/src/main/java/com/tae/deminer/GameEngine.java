package com.tae.deminer;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.tae.deminer.Util.Generator;
import com.tae.deminer.Util.PrintGrid;
import com.tae.deminer.Views.Cell;

public class GameEngine {

    public static GameEngine instance;
    private Context context;
    public static final int BOMB_NUMBER = 10;
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;

    private Cell[][] minseweepergrid = new Cell[WIDTH][HEIGHT];


    public static GameEngine getInstance () {
        if (instance == null) {
            instance = new GameEngine();
        }
        return  instance;
    }

    private GameEngine() {
    }

    public void createGrid (Context context) {
    // create the grid and store it

        Log.e("GameEngine","createGrid is working");
        this.context = context;

        int [][] GeneratedGrid = Generator.generate(BOMB_NUMBER, WIDTH, HEIGHT);
        PrintGrid.print(GeneratedGrid, WIDTH,HEIGHT);
    }

    private void setGrid (final Context context, final int [][]grid) {
    for (int x=0;x<WIDTH;x++) {
        for (int y=0;y<HEIGHT;y++) {
            if (minseweepergrid[x][y]==null) minseweepergrid[x][y]= new Cell (context,y*WIDTH+x);
        }
    }
    }

    public View getCellAt(int position) {
        return null;
    }
}
