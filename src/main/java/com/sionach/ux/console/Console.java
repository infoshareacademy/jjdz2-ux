package com.sionach.ux.console;

import com.sionach.ux.color.ConverStringListToNamesHexTableList;
import com.sionach.ux.color.ExtractColorsFromData;
import com.sionach.ux.filemanagment.ReadFiles;
import com.sionach.ux.keyWords.*;
import com.sionach.ux.routing.LinkMenagement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Console {


    private static final String DEFAULTPATCH = "src/main/resources/";

    public static void main(String[] args) {

        int input = 0;
        int tempChoice;
        Scanner reader = new Scanner(System.in);

        List<String> folderList = foldersInResources();

        while(true){
            System.out.println("Wybierz stronę");
            for (String item : folderList) {
                    System.out.format("%s %s\n", folderList.indexOf(item) + 1, item);
            }
            System.out.println("(1) wmh.pl");
            System.out.println("(2) infoshareacademy.com");
            System.out.println("3 Wyjście z programu");
            input = reader.nextInt();
            if(input == 3){
                break;
            }
            tempChoice = input;
            while(true){
                ReadFiles htmlFile = new ReadFiles("index.html");
                ReadFiles cssFile = new ReadFiles("style.css");
                htmlFile.setDefaultPatch(DEFAULTPATCH + folderList.get(tempChoice-1) + "/");
                cssFile.setDefaultPatch(DEFAULTPATCH + folderList.get(tempChoice-1) + "/");



                ExtractColorsFromData colors = new ExtractColorsFromData();

                System.out.println("\n1 Identyfikacja podobnych stron");
                System.out.println("2 Analiza kolorów na stronie");
                System.out.println("3 Analiza routingu strony");
                System.out.println("4 Analiza pod kątem kryteriów dostępności");
                System.out.println("5 Poziom wyżej\n");
                input = reader.nextInt();
                if(input == 5){
                    break;
                }
                switch (input){
                    case 1:
                        String htmlString = htmlFile.readFileToString();

                        KeywordsFromAnchor anchor = new KeywordsFromAnchor();
                        KeywordsFromAttributes attributes = new KeywordsFromAttributes();
                        KeywordsFromBolded bolded = new KeywordsFromBolded();
                        KeywordsFromHeadlines headlines = new KeywordsFromHeadlines();
                        KeywordsFromMetadata metadata = new KeywordsFromMetadata();

                        List<String> anchorList = anchor.keywordsAnchor(htmlString);
                        List<String> attributesList = attributes.attributesKeywords(htmlString);
                        List<String> boldedList = bolded.boldedKeywords(htmlString);
                        List<String> headlinesList = headlines.headlineKeywords(htmlString);
                        List<String> metadataList = metadata.MetadataKeywords(htmlString);

                        List<List<String>> keyWords = Arrays.asList(anchorList, attributesList, boldedList, headlinesList, metadataList);
//
                        System.out.println("Lista słów kluczowych po których można znaleść strony podobne do podanej:\n");

                        keyWords.stream()
                                .flatMap(Collection::stream)
                                .collect(Collectors.toSet())
                                .forEach(System.out::println);
                        break;
                    case 2:
//                        List<String> myColors = colors.extractHexRgbRgbaColors(cssFile.readFileToList());
//                        ConverStringListToNamesHexTableList converter = new ConverStringListToNamesHexTableList();
//                        System.out.println(converter.convertToNamesHexTableList(myColors));

//                        colors.extractNamesColors(cssFile.readFileToList());
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