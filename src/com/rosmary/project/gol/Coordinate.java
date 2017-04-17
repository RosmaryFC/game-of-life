package com.rosmary.project.gol;

/**
 * Created by Rosemary on 4/16/17.
 */
class Coordinate {

    private int row;
    private int column;


    Coordinate (int row, int column){
        this.row = row;
        this.column = column;
    }

    protected void setRow(int row){
        this.row = row;
    }

    protected int getRow(){
        return this.row;
    }

    protected void setColumn(int column){
        this.column = column;
    }

    protected int getColumn(){
        return column;
    }
}
