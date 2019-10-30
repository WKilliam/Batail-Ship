package com.company;
import java.util.Scanner;  // Import the Scanner class

import static java.lang.Math.random;


public class Main {



    // init
    public static void FonctionInit(char tableau1[][]) {

        int n = tableau1.length;
        int m = tableau1[0].length;
        int row;
        for (row = 0; row < n; row = row + 1) {
            int col;
            for (col = 0; col < m; col = col + 1) {
                tableau1[row][col] = '~';
            }

        }

        CreateShip(5, tableau1);
        CreateShip(4, tableau1);
        CreateShip(3, tableau1);
        CreateShip(3, tableau1);
        CreateShip(2, tableau1);

    }

    // function GetRandom
    public static int GetRandom(int N) {
        int Random_local = (int) (Math.random() * (N));
        return Random_local;
    }


    // create ship
    public static void CreateShip(int N, char tab[][]) {

        boolean isShipPossible;

        do {

            // alea
            //horizontal or vertical
            int col;
            int row;


            int HorV = GetRandom(2);
            if (HorV == 0) {

                row = GetRandom(10);
                col = GetRandom(10 - (N-1));
            } else {
                row = GetRandom(10 - (N-1));
                col = GetRandom(10);
            }

            // check possible

            isShipPossible = true;

            int size;
            for (size = 0; size < N; size = size + 1) {

                if (HorV == 0) // horizontal
                {
                    if (tab[row][col + size] == '#') {
                        isShipPossible = false;
                    }
                } else { // vertical
                    if (tab[row + size][col] == '#') {
                        isShipPossible = false;
                    }
                }

            }

            if (isShipPossible == true) {
                // write
                // display condition about the presence of a #

                for (size = 0; size < N; size = size + 1) {

                    if (HorV == 0) {
                        tab[row][col + size] = '#';
                    } else {
                        tab[row + size][col] = '#';
                    }
                }
            }
        } while (isShipPossible == false);
    }
    
// print the table

    public static void FonctionAffichageX(char tableau[][]) {


        int y;
        System.out.println("    A B C D E F G H I J");

        for (y=0;y<=9;y=y+1){
            String line ="";
            int x;
            if(y<=8){
                line = line +" ";
            }
            line = line + (y+1) + "| ";

            for (x=0;x<=9;x=x+1){
                line=line+tableau[x][y]+" ";
            }
            line = line + "|";
            System.out.println(line);
        }

    }


    public static void main(String[] args) {


        char tab1[][]= new char [10][10];


        FonctionInit(tab1);
        FonctionAffichageX(tab1);


    }
}


        




