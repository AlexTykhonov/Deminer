package com.tae.deminer;

import android.content.Context;
import android.util.Log;

import com.tae.deminer.Util.Generator;
import com.tae.deminer.Util.PrintGrid;

public class GameEngine {

    public static GameEngine instance;
    private Context context;
    private static final int BOMB_NUMBER = 10;
    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;


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

}
