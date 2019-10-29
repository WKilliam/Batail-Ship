package com.company;
import java.util.Scanner;  // Import the Scanner class



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
        /*int x;
        int yy;
        int y = 1;
        for (x = 1; x <= 10; x = x + 1){
            System.out.println("X");
            for (yy=2;yy <=9 ; yy=yy+1){
                System.out.println(y* 10);*/


           /* //System.out.println("X");
            for (y = 1; y <= 10; y = y + 1) {
                System.out.println("Y");*/


    public static void main(String[] args) {

        char tab1[][]= new char [10][10];

        FonctionAffichageX(tab1);

        /*
        int Tableau[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        char tableauCaractere[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};

        for (int i = 0; i < tableauCaractere.length; i++) {
            System.out.println("À l'emplacement " + i + " du tableau nous avons = " + tableauCaractere[i]);
        }*/
    }
}



