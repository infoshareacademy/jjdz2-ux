package com.sionach.ux.console;


import com.sionach.ux.filemanagment.ReadFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

//    public static void choosePage(){
//        System.out.println("Proszę wybrać stronę do zbadania");
//    }

//    public static void menuMainOptions(){
//        System.out.println("Wybierz jedną z opcji");
//        System.out.println("1. Identyfikacja podobnych stron");
//        System.out.println("2. Analiza kolorów na stronie");
//        System.out.println("3. Analiza routingu strony");
//        System.out.println("4. Analiza pod kątem kryteriów dostępności");
//        System.out.println("5. Wyjście");
//    }

    public ReadFiles file = new ReadFiles("test");

    public static void main(String[] args) {

        int menuLevel = 1;
        int input;
        Scanner reader = new Scanner(System.in);

        //Creating Menu
        List<Menu> menu = new ArrayList<>();
        menu.add(new Menu(0, 1, "8. Poziom wyżej"));
        menu.add(new Menu(1, 1, "Proszę wybrać stronę do zbadania"));
        menu.add(new Menu(1, 9, "9. Wyjście"));
        menu.add(new Menu(2, 1, "1. Identyfikacja podobnych stron"));
        menu.add(new Menu(2, 2, "2. Analiza kolorów na stronie"));
        menu.add(new Menu(2, 3, "3. Analiza routingu strony"));
        menu.add(new Menu(2, 4, "4. Analiza pod kątem kryteriów dostępności"));


        printMenu(menuLevel, menu);
        input = reader.nextInt();

//        int input = 0;
//        while(true) {

//            menuMainOptions();
//
//            switch (input){
//                case 1:
//                    filesInResources();
//                    break;
//                case 2:
//
//                    break;
//
//                case 3:
//
//                    break;
//
//                case 4:
//
//                    break;
//
//                case 5:
//                    System.out.println("Zamknięcie aplikacji.");
//                    break;
//
//                default:
//                    System.out.println("Błędna opcja. Proszę wybrać jeszcze raz.");
//            }
//        }
    }



    public static void printMenu(int menuLevel, List<Menu> menu) {
        menu.stream()
                .filter(item -> item.getLevel() == menuLevel)
                .map(Menu::getMessage)
                .forEach(System.out::println);
    }

    public static void filesInResources(){
        String defaultPath = "src/main/resources/";
        try {
            Files.walk(Paths.get(defaultPath))
                    .filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
