package com.tae.deminer.Util;

import java.util.Random;

public class Generator {

    public static int [][] generate (int bombnumber, final int width, final int height) {
        //generator randoms
        Random r = new Random();
        int[][] grid = new int[width][height];

        for (int x = 0; x < width; x++) {
            grid[x] = new int[height];
        }

        while (bombnumber > 0) {
            int x = r.nextInt(width);
            int y = r.nextInt(height);
            if (grid[x][y] != -1) {
                grid[x][y] = -1;
                bombnumber--;
            }
        }
        return grid = calculateNeighbours (grid,width,height);
    }

        private static int [][] calculateNeighbours (int [][] grid, final int width, final int height ) {
        for (int x= 0;x<width;x++) {
            for (int y=0; y<height;y++) {
                grid[x][y] = getNeighbourNumber(grid, x, y, width, height);
            }
        }
        return grid;
    }

    private static int getNeighbourNumber (final int grid[][],final int x, final int y, final int width, final int height ) {
        // we check if position is a bomb
        if (grid[x][y] == -1) {
            return -1;
        }
        // счетчик bomb
        int count = 0;
        if (isMineAt(grid, x-1, y+1, width, height)) count++; // top left
        if (isMineAt(grid, x, y+1, width, height)) count++;     // top
        if (isMineAt(grid, x+1, y+1, width, height)) count++; // top right
        if (isMineAt(grid, x-1, y, width, height)) count++; // left
        if (isMineAt(grid, x+1, y, width, height)) count++; //right
        if (isMineAt(grid, x-1, y-1, width, height)) count++; // bottom left
        if (isMineAt(grid, x, y-1, width, height)) count++; //bottom
        if (isMineAt(grid, x+1, y-1, width, height)) count++; // bottom right
     return count;
    }

    //проверяем есть ли край карт
    private static boolean isMineAt (int grid [][], final int x, final int y, final int width, final int height)
        {
            if (x>0&& y>0&& x<width && y<height) {
                if (grid[x][y]==-1) {
                    return true;
                }
            } return false;

        }


}

