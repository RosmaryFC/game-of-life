package com.rosmary.project.gol;

import com.rosmary.project.ZerothGenerationProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Rosemary on 4/16/17.
 */
class Generation implements ZerothGenerationProvider {
    private String mDataFile;
    static final char VACANT = '.';
    static final char OCCUPIED = 'X';
    static final int ROWS = 25;
    static final int COLUMNS = 75;
    private boolean[][] mWorld;
    private boolean[][] mNextWorld;
    boolean mNextWorldIsOccupied;

    boolean[][] getWorld() {
        return mWorld;
    }

    //Todo: world already being set in providezeroth generation method - possibly delete
    public void setWorld(boolean[][] mWorld) {
        this.mWorld = mWorld;
    }

    //todo: if next world is empty, then next world should not be returned, or should be returned null;
     boolean[][] getNextWorld() {
        mNextWorld = new boolean[ROWS + 2][COLUMNS + 2];
         int numOccupants = 0;
        for(int row = 1 ; row <= ROWS; row++){
            for(int column = 1; column <= COLUMNS; column++){
                // returns int num neighbors
                int numNeighbors = checkNeighbors(row, column, mWorld);
                if(!mWorld[row][column]){ // if vacant
                    if(numNeighbors == 3){
                        mNextWorld[row][column] = true;
                        numOccupants++;
                    }
                }else{ // if occupied
                    if(numNeighbors == 2 || numNeighbors == 3){
                        mNextWorld[row][column] = true;
                        numOccupants++;
                    }
                }

            }
        }

         mNextWorldIsOccupied = numOccupants > 0;

        return mNextWorld;
    }

    //todo: when getting next world, it is also being set - possibly delete
    public void setNextWorld(boolean[][] mNextWorld) {
        this.mNextWorld = mNextWorld;
    }

    Generation(String dataFile){
        this.mDataFile = new File(dataFile).getAbsolutePath();
        provideZerothGeneration();
    }

    @Override
    public boolean[][] provideZerothGeneration() {
        mWorld = new boolean[ROWS + 2][COLUMNS + 2];
        int numOccupants = 0;

        Scanner input;
        try {
            input = new Scanner(new File(mDataFile));
            String scanLine;
            int row = 1;
            while(input.hasNextLine()){
                scanLine = input.nextLine();
                int column = 1;
                for (char c: scanLine.toCharArray()) {
                    if (c != VACANT) {
                        mWorld[row][column] = true;
                        numOccupants++;
                    }
                    else{
                        mWorld[row][column] = false;
                    }
                    column++;
                }
//                System.out.println(row + " " + scanLine);
                row++;
            }
            input.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//todo: test code - can be removed
//        System.out.println("COLUMNS: " + mWorld[0].length);
//        System.out.println("ROWS: " + mWorld.length);
//        for (boolean[] arr: mWorld){
//            System.out.println(Arrays.toString(arr));
//        }

        mNextWorldIsOccupied = numOccupants > 0;
        return mWorld;
    }

    private int checkNeighbors(int row, int column, boolean[][] world){
        int numNeighbors = 0;

        ArrayList<Boolean> neighbors = new ArrayList<>();
        //top 3 rows
        neighbors.add(world[row - 1][column - 1]);
        neighbors.add(world[row - 1][column]);
        neighbors.add(world[row - 1][column + 1]);

        //middle side rows
        neighbors.add(world[row][column - 1]);
        neighbors.add(world[row][column + 1]);

        //bottom 3 rows
        neighbors.add(world[row + 1][column - 1]);
        neighbors.add(world[row + 1][column]);
        neighbors.add(world[row + 1][column + 1]);

        for(boolean neighbor : neighbors){
            if(neighbor){
                numNeighbors++;
            }
        }
        return numNeighbors;
    }

}
