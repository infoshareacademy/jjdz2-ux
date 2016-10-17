package com.sionach.ux.console;


import com.sionach.ux.filemanagment.ReadFiles;

import java.util.Scanner;

public class Console {


    public static void mainMenu(){
        System.out.println("Wybierz jedną z opcji");
        System.out.println("1. Identyfikacja podobnych stron");
        System.out.println("2. Analiza kolorów na stronie");
        System.out.println("3. Analiza routingu strony");
        System.out.println("4. Analiza pod kątem kryteriów dostępności");
        System.out.println("5. Wyjście");
    }

    public ReadFiles file = new ReadFiles("test");

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        int input = 0;
        while(input != 5) {
            mainMenu();
            input = reader.nextInt();

            switch (input){
                case 1:


                    break;
                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:
                    System.out.println("Zamknięcie aplikacji.");
                    break;

                default:
                    System.out.println("Błędna opcja. Proszę wybrać jeszcze raz.");
            }
        }
    }
}
