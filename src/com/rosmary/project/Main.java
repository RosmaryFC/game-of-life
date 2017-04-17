package com.rosmary.project;

import com.rosmary.project.gol.GameOfLife;

import java.util.Scanner;

/**
 * new games of life will be created and initialized
 */

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("Welcome to the Game Of Life, choose a number 1 - 5");
        GameOfLife gameOfLife = new GameOfLife(1);
        gameOfLife.initialize();

//        Scanner input = new Scanner(System.in);
//        int dataInt = input.nextInt();
//        //todo: create loop for when user does not type correct input
//        GameOfLife gameOfLife = new GameOfLife(dataInt);
//
//        input.close();
    }


}
