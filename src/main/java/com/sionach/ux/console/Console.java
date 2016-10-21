package com.sionach.ux.console;

import com.sionach.ux.filemanagment.ReadFiles;
import com.sionach.ux.routing.LinkMenagement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Console {

    private static final String DEFAULTPATCH = "src/main/resources/";
//    public ReadFiles file = new ReadFiles("test");


    public static void main(String[] args) {

        int input = 0;
        int tempChoice;
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
            tempChoice = input;
            while(true){
                ReadFiles htmlFile = new ReadFiles("index.html");
                htmlFile.setDefaultPatch(DEFAULTPATCH + folderList.get(tempChoice-1) + "/");
                filesInResources(folderList.get(tempChoice-1));
                System.out.println("1 Identyfikacja podobnych stron");
                System.out.println("2 Analiza kolorów na stronie");
                System.out.println("3 Analiza routingu strony");
                System.out.println("4 Analiza pod kątem kryteriów dostępności");
                System.out.println("5 Poziom wyżej");
                input = reader.nextInt();
                if(input == 5){
                    break;
                }
                switch (input){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        String baseUrl;
                        System.out.println("Podaj link bazowy - domena.pl");
                        baseUrl = reader.next();
                        LinkMenagement links = new LinkMenagement(htmlFile.readFileToString(), baseUrl);
                        System.out.println("Linki wewnętrzne:");
                        System.out.println(links.getInnerLinks());
                        System.out.println("Linki zewnętrzne:");
                        System.out.println(links.getOuterLinks());
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Błąd, wybierz opcje z listy");
                }
            }
        }
    }



//    public static void menuOptionHandler(int option, int menuLevel){
//
//    }


//    public static void printMenu(int menuLevel, List<Menu> menu) {
//        menu.stream()
//                .filter(item -> item.getLevel() == menuLevel)
//                .map(Menu::getMessage)
//                .forEach(System.out::println);
//    }

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

    public static List<String> filesInResources(String option){
        try {
            return Files.walk(Paths.get(DEFAULTPATCH + option + "/"))
                    .filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .map(p -> p.toString())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
