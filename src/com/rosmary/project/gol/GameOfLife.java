package com.rosmary.project.gol;

import com.rosmary.project.GameOfLifeUI;
import com.rosmary.project.ZerothGenerationProvider;

/**
 * Created by Rosemary on 4/16/17.
 */
public class GameOfLife implements GameOfLifeUI{

    private String mDataFile;
    private Generation mGeneration;

    public GameOfLife(int dataInt){
        this.mDataFile = getDataFile(dataInt);
    }

    private static String getDataFile(int dataInt) {
        switch(dataInt){
            case 1:
                return "resources/life1.dat";
            case 2:
                return "resources/life2.dat";
            case 3:
                return "resources/life3.dat";
            case 4:
                return "resources/life4.dat";
            case 5:
                return "resources/life5.dat";
            default:
                return "Input Not Valid";
        }
    }

    public void initialize(){
        mGeneration = new Generation(mDataFile);
    }

    public void getNextGeneration(Generation currentGeneration){

    }

    @Override
    public void displayGeneration(boolean[][] world) {
        

    }

    @Override
    public void displayMessage(String message) {

    }


}
