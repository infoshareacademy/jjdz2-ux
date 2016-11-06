package com.sionach.ux.console;

import com.sionach.ux.accessibility.*;
import com.sionach.ux.color.ClipColors;
import com.sionach.ux.filemanagment.ReadFiles;
import com.sionach.ux.keyWords.*;
import com.sionach.ux.routing.LinkMenagement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
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

                        KeyWords keyWords = new KeyWords();
                        System.out.println("Lista słów kluczowych po których można znaleść strony podobne do podanej:\n");
                        System.out.println(keyWords.extractKeyWords(htmlInString));
                        break;
                    case 2:
                        ClipColors clipColors = new ClipColors();
                        clipColors.ClipColorsFromData(htmlInString,cssFile);
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
                        CaseOfHtml5 caseOfHtml5 = new CaseOfHtml5();
                        SettingsInHeadElement settingsInHeadElement = new SettingsInHeadElement();
                        HeadlinesInHtml headlinesInHtml = new HeadlinesInHtml();
                        DeprecatedTagsInHtml deprecatedTagsInHtml = new DeprecatedTagsInHtml();
                        AltAndTitleInImage altAndTitleInImage = new AltAndTitleInImage();
                        LinksInHtml linksInHtml = new LinksInHtml();

                        List<String> altAndTitleInImageRaport = altAndTitleInImage.ImageAltTitle(htmlInString);
                        List<String> settingsInHeadRaport = settingsInHeadElement.checkHeadSettings(htmlInString);
                        List<String> deprecatedTagsRaport = new ArrayList<>();
                        try {
                            deprecatedTagsRaport = deprecatedTagsInHtml.findDeprecatedTags(htmlInString);
                        } catch (FileNotFoundException e) {
                            System.out.println("Nie znaleziono pliku z deprecjonowanymi elementami\n");
                            e.printStackTrace();
                        }

                        caseOfHtml5.CheckIfHtml5(htmlInString);
                        for (String item : deprecatedTagsRaport) {
                            System.out.println(item);
                        }

                        System.out.println("\nRaport sekcji HEAD");
                        for (String item : settingsInHeadRaport) {
                            System.out.println(item);
                        }

                        System.out.println("\n");

                        System.out.println(headlinesInHtml.checkHeadlinesInHtml(htmlInString));
                        System.out.println(headlinesInHtml.checkNoOccurrancesH1(htmlInString));

                        System.out.println("\n");

                        for (String item : altAndTitleInImageRaport) {
                            System.out.println(item);
                        }

                        System.out.println("\n");

                        System.out.println(linksInHtml.checkNumberOfLinks(htmlInString));

                        System.out.println("\n");
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
