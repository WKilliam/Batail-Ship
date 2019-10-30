package com.company;
import java.util.Scanner;  // Import the Scanner class


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
                line=line+tableau[y][x]+" ";
            }
            line = line + "|";
            System.out.println(line);
        }

    }

        // function that takes a string as a parameter and checks if the first character is between A and J
        // if it is not the case, it returns -1
            static int getInputColIndex(String s){
            if(s.length() > 0){
                char first = s.toLowerCase().charAt(0);
                    if(first >= 'a' && first <= 'j') {
                     return (first-'a');
            }
        }
                return -1;
    }
    // function that takes a string as a parameter and checks if second and third characters are between '1' and '10'
    // if it is not the case, it returns -1
        static int getInputRowIndex(String s){
        if(s.length() > 1){
            char second = s.toLowerCase().charAt(1);
                if(second >= '1' && second <= '9') {
                    if(s.length() > 2) {
                        char third = s.toLowerCase().charAt(2);
                            if (third == '0') {
                                return Integer.parseInt(s.substring(1, 3))-1;
                    }
                }
                else{
                    return (second-'0'-1);
                }
            }
        }
        return -1;
    }

    public static void shoot(int colonne, int ligne, char tab[][]){
        if (tab[ligne][colonne] == '#'){
            // hit the ship
            tab [ligne][colonne] = 'X';
        }
        if (tab[ligne][colonne] == '~'){
            // hit the ship
            tab [ligne][colonne] = 'Y';
        }
    }

    public static void playerTurn(char tab[][]){

        int colIdx;
        int rowIdx;
        do {
            Scanner sc = new Scanner(System.in);
            // Get input from user
            System.out.println("Entrez des coordonnées : ");
            String input = sc.next();
            // get column index
            colIdx = getInputColIndex(input);
            // get row index
            rowIdx = getInputRowIndex(input);

            if (colIdx != -1 && rowIdx != -1) {
                // Here i got valid position for ROW and COLUMN indexes
                // here colIdx and rowIdx contains valid values
                // call the shoot function
                shoot(colIdx, rowIdx, tab);

            } else {
                System.out.println("erreur de saisie");
            }
        }while( colIdx==-1 || rowIdx == -1);


    }



    public static void main(String[] args) {



       char tab1[][]= new char [10][10];


        FonctionInit(tab1);

        while(true){

            FonctionAffichageX(tab1);
            playerTurn(tab1);
        }

    }
}


        




