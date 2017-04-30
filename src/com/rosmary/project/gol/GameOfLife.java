package com.rosmary.project.gol;

import com.rosmary.project.GameOfLifeUI;
/**
 * Created by Rosemary on 4/16/17.
 */
public class GameOfLife implements GameOfLifeUI{

    private String mDataFile;
    private Generation mGeneration;
    public boolean worldIsOccupied;

    public GameOfLife(int dataInt){
        this.mDataFile = getDataFile(dataInt);
    }

    public boolean isWorldIsOccupied() {
        return worldIsOccupied;
    }

    private void setWorldIsOccupied(boolean worldIsOccupied) {
        this.worldIsOccupied = worldIsOccupied;
    }

    public Generation getmGeneration() {
        return mGeneration;
    }

    public void setmGeneration(Generation mGeneration) {
        this.mGeneration = mGeneration;
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
        displayGeneration();
    }


    public void getNextGeneration(){
        mGeneration.setWorld(mGeneration.getNextWorld());
        setWorldIsOccupied(mGeneration.mNextWorldIsOccupied);
    }

    @Override
    public void displayGeneration() {
        //variables start at one to prevent print out of border padding booleans
        for(int row = 1; row <= Generation.ROWS; row++){
            for(int column = 1; column <= Generation.COLUMNS; column ++){
                if(mGeneration.getWorld()[row][column]){
                    System.out.print(Generation.OCCUPIED);
                }else {
                    System.out.print(Generation.VACANT);
                }
            }
            System.out.println();
        }
    }

    /**
     * message displayed when no more worlds are available, when all spots are vacant, then game is finished
     */
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

}
