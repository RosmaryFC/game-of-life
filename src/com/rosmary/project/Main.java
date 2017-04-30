package com.rosmary.project;

import com.rosmary.project.gol.GameOfLife;

import java.util.Scanner;

/**
 * new games of life will be created and initialized
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to the Game Of Life, choose a number 1 - 5");

        Scanner input = new Scanner (System.in);
        int numChosen = input.nextInt();
        GameOfLife gameOfLife = new GameOfLife(numChosen);
        int generation = 0;
        System.out.println("Generation: " + generation);
        gameOfLife.initialize();

        System.out.println("Would you like to see the next Generation? Type 'y' and press Enter");
        while(input.next().equals("y") ){
            gameOfLife.getNextGeneration();
            generation++;

            if(gameOfLife.worldIsOccupied){
                System.out.println("Generation: " + generation);
                gameOfLife.displayGeneration();
                System.out.println("Would you like to see the next Generation? Type 'y' and press Enter");
            }else{
                gameOfLife.displayMessage("World Is Vacant");
                break;
            }
        }

        System.out.print("Thank you for playing.");
        input.close();
    }


}
