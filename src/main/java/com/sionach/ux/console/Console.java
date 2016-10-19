package com.sionach.ux.console;


import com.sionach.ux.filemanagment.ReadFiles;
import com.sionach.ux.routing.LinkMenagement;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Console {

    private static final String DEFAULTPATCH = "src/main/resources/";
//    public ReadFiles file = new ReadFiles("test");


    public static void main(String[] args) {

        int input = 0;
        Scanner reader = new Scanner(System.in);

//        int menuLevel = 1;
//        List<String> folder;
//        int page = 0;
//
//        //Creating Menu
//        List<Menu> menu = new ArrayList<>();
//        menu.add(new Menu(1, 0, "Proszę wybrać stronę do zbadania"));
//        menu.add(new Menu(1, 9, "9. Wyjście"));
//        menu.add(new Menu(2, 1, "1. Identyfikacja podobnych stron"));
//        menu.add(new Menu(2, 2, "2. Analiza kolorów na stronie"));
//        menu.add(new Menu(2, 3, "3. Analiza routingu strony"));
//        menu.add(new Menu(2, 4, "4. Analiza pod kątem kryteriów dostępności"));
//        menu.add(new Menu(2, 5, "5. Poziom wyżej"));
//
//        while(true) {
////            if (menuLevel == 1) {
////                folder = foldersInResources();
////                for (String item : folder) {
////                    System.out.format("%s %s\n", folder.indexOf(item) + 1, item);
////                }
////                page = reader.nextInt();
////                menuLevel = 2;
////            } else {
////                System.out.println(page);
////                printMenu(menuLevel, menu);
////                input = reader.nextInt();
////                switch (input) {
////                    case 1:
////
////                }
////            }
//
//            printMenu(menuLevel, menu);
//
//        }
//        input = reader.nextInt();

        List<String> folderList = foldersInResources();

        while(true){
            System.out.println("Wybierz stronę");
            for (String item : folderList) {
                    System.out.format("%s %s\n", folderList.indexOf(item) + 1, item);
            }
            System.out.println("3 Wyjście z programu");
            input = reader.nextInt();
            if(input == 3){
                break;
            }
            while(true){
                filesInResources(folderList.get(input-1));
                System.out.println("5 Poziom wyżej");
                input = reader.nextInt();
                if(input == 5){
                    break;
                }
            }
        }
    }



    public static void menuOptionHandler(int option, int menuLevel){

    }


    public static void printMenu(int menuLevel, List<Menu> menu) {
        menu.stream()
                .filter(item -> item.getLevel() == menuLevel)
                .map(Menu::getMessage)
                .forEach(System.out::println);
    }

    public static List<String> foldersInResources(){
        try {
             return Files.walk(Paths.get(DEFAULTPATCH))
                    .filter(Files::isDirectory)
                    .map(Path::getFileName)
                     .map(p -> p.toString())
                    .skip(1)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void filesInResources(String option){
        String defaultPath = DEFAULTPATCH;
        try {
            Files.walk(Paths.get(defaultPath + option + "/"))
                    .filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
