package com.rosmary.project.gol;

import com.rosmary.project.ZerothGenerationProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Rosemary on 4/16/17.
 */
class Generation implements ZerothGenerationProvider {
    String mDataFile;
    static final char VACANT = '.';
    static final char OCCUPIED = 'X';
    static final int ROWS = 25;
    static final int COLUMNS = 75;
    boolean[][] mWorld;

    Generation(String dataFile){
        this.mDataFile = new File(dataFile).getAbsolutePath();
        provideZerothGeneration();
    }


    @Override
    public boolean[][] provideZerothGeneration() {
        mWorld = new boolean[ROWS + 2][COLUMNS + 2];

        Scanner input;
        try {
            input = new Scanner(new File(mDataFile));
            String scanLine;
            int row = 1;
            while(input.hasNextLine()){
                scanLine = input.nextLine();
                int column = 1;
                for (char c: scanLine.toCharArray()) {
                    mWorld[row][column] = c != VACANT;
                    column++;
                }
                System.out.println(row + " " + scanLine);
                row++;
            }
            input.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("COLUMNS: " + mWorld[0].length);
        System.out.println("ROWS: " + mWorld.length);
        for (boolean[] arr: mWorld){
            System.out.println(Arrays.toString(arr));
        }

        return mWorld;
    }
}
