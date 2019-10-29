package com.company;
import java.util.Scanner;  // Import the Scanner class

import static java.lang.Math.random;


public class Main {

/*  function questions and answers

    public static boolean lancement_Jeu(){

        class MyClass {
            public static void main(String[] args) {
                Scanner myObj = new Scanner(System.in);  // Create a Scanner object
                System.out.println("Enter username");

                String userName = myObj.nextLine();  // Read user input
                System.out.println("Username is: " + userName);  // Output user input
            }
        }*/

    // init
    public static void FonctionInit(char tableau[][]) {

        int n = tableau.length;
        int m = tableau[0].length;
        int row;
        for (row = 0; row < n; row = row + 1) {
            int col;
            for (col = 0; col < m; col = col + 1) {
                tableau[row][col] = '~';
            }

        }

        CreateShip (5,tableau);
        CreateShip (4,tableau);
        CreateShip (3,tableau);
        CreateShip (3,tableau);
        CreateShip (2,tableau);

    }


    // function GetRandom
    public static int GetRandom(int N) {
        int Random_local = (int) (Math.random() * (N));
        return Random_local;
    }


    // create ship
    public static void CreateShip(int N, char tab[][]) {

    do {

        // alea
        //horizontal or vertical
        int col;
        int row;
        boolean isShipPossible = true;

        int HorV = GetRandom(10);
        if (HorV == 0) {

            row = GetRandom(10);
            col = GetRandom(10 - N);
        } else {
            row = GetRandom(10 - N);
            col = GetRandom(10);
        }

        int taille;
        for (taille = 0; taille <= N; taille = taille + 1) {

            if ((tab[row][col + taille] == '#')||(tab [row + taille][col] = '#'){
                isShipPossible = false;
            }

        }

        if (isShipPossible == true) {
            // write
            // display condition about the presence of a #

            for (taille = 0; taille <= N; taille = taille + 1) {

                if (HorV == 0) {
                    tab[row][col + taille] = '#';
                } else {
                    tab[row + taille][col] = '#';
                }
            }
        }
    }
    while(isShipPossible == false);
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


        




