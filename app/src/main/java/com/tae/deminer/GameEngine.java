package com.tae.deminer;

import android.content.Context;

public class GameEngine {

    public static GameEngine instance;


    private Context context;


    public static GameEngine instance () {
        if (instance == null) {
            instance = new GameEngine();
        }
        return  instance;
    }

    private GameEngine() {
    }

    public void createGrid (Context context) {
    // create the grid and store it
        this.context = context;
    }

}
