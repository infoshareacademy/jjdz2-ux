package com.sionach.ux.console;

import com.sionach.ux.accessibility.AccessibilityClip;
import com.sionach.ux.color.ClipColors;
import com.sionach.ux.filemanagment.ReadFiles;
import com.sionach.ux.keyWords.KeyWordsClip;
import com.sionach.ux.routing.LinkMenagement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Console {

    private static final String DEFAULTPATCH = "src/main/resources/";
    private static final Logger LOGGER = LogManager.getLogger(Console.class);

    public static void main(String[] args) {

        int input = 0;
        int tempChoice;
        Scanner reader = new Scanner(System.in);

        LOGGER.debug("Creating folder list");
        List<String> folderList = foldersInResources();
        LOGGER.debug("Folders found: {}", folderList);

        LOGGER.debug("Entering Menu");
        while (true) {
            System.out.println("\nWybierz stronę");
            for (String item : folderList) {
                System.out.format("%s %s\n", folderList.indexOf(item) + 1, item);
            }
            System.out.println("3 Wyjście z programu\n");
            input = reader.nextInt();
            LOGGER.debug("User choosed option number: {}", input);
            if (input == 3) {
                break;
            }
            tempChoice = input;
            while (true) {
                ReadFiles htmlFile = new ReadFiles(); //"index.html"
                ReadFiles cssFile = new ReadFiles(); //"style.css"

                htmlFile.setDefaultPatch(DEFAULTPATCH + folderList.get(tempChoice - 1) + "/"); //
                cssFile.setDefaultPatch(DEFAULTPATCH + folderList.get(tempChoice - 1) + "/");

                String htmlInString = htmlFile.readFileToString("index.html");

                System.out.println("\n1 Identyfikacja podobnych stron");
                System.out.println("2 Analiza kolorów na stronie");
                System.out.println("3 Analiza routingu strony");
                System.out.println("4 Analiza pod kątem kryteriów dostępności");
                System.out.println("5 Poziom wyżej\n");
                input = reader.nextInt();
                if (input == 5) {
                    break;
                }
                switch (input) {
                    case 1:
                        KeyWordsClip keyWordsClip = new KeyWordsClip();
                        keyWordsClip.KeyWordsFromData(htmlInString);
                        System.out.println(keyWordsClip.getKeyWords());
                        break;
                    case 2:
                        ClipColors clipColors = new ClipColors();
                        clipColors.ClipColorsFromData(htmlInString,cssFile);
                        System.out.println("Użyte kolory na stronie to:\n");
                        System.out.println(clipColors.getDistinctHex());
                        break;
                    case 3:
                        String baseUrl;
                        if(tempChoice == 1){
                            baseUrl = "wmh.pl";
                        } else {
                            baseUrl = "infoshareacademy.com";
                        }
                        LinkMenagement links = new LinkMenagement(htmlInString, baseUrl);
                        System.out.println("Linki wewnętrzne:");
                        System.out.println(links.getInnerLinks());
                        System.out.println("Linki zewnętrzne:");
                        System.out.println(links.getOuterLinks());
                        break;
                    case 4:
                        AccessibilityClip accessibilityClip = new AccessibilityClip();
                        accessibilityClip.Accessibility(htmlInString);
                        break;

                    default:
                        System.out.println("Błąd, wybierz opcje z listy");
                }
            }
        }
    }

    public static List<String> foldersInResources() {
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
}
