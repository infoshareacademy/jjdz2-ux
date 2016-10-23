package com.sionach.ux.console;

import com.sionach.ux.accessibility.*;
import com.sionach.ux.color.ConvertColorToHex;
import com.sionach.ux.color.ExtractColorsFromData;
import com.sionach.ux.csslists.CssListFromHtml;
import com.sionach.ux.filemanagment.ReadFiles;
import com.sionach.ux.keyWords.*;
import com.sionach.ux.routing.LinkMenagement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Console {

    private static final String DEFAULTPATCH = "src/main/resources/";

    public static void main(String[] args) {

        int input = 0;
        int tempChoice;
        Scanner reader = new Scanner(System.in);

        List<String> folderList = foldersInResources();

        while(true){
            System.out.println("\nWybierz stronę");
            for (String item : folderList) {
                    System.out.format("%s %s\n", folderList.indexOf(item) + 1, item);
            }
            System.out.println("3 Wyjście z programu\n");
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

                String htmlInString = htmlFile.readFileToString();

                ExtractColorsFromData colors = new ExtractColorsFromData();
                CssListFromHtml cssFromHtml = new CssListFromHtml();

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

                        KeywordsFromAnchor anchor = new KeywordsFromAnchor();
                        KeywordsFromAttributes attributes = new KeywordsFromAttributes();
                        KeywordsFromBolded bolded = new KeywordsFromBolded();
                        KeywordsFromHeadlines headlines = new KeywordsFromHeadlines();
                        KeywordsFromMetadata metadata = new KeywordsFromMetadata();

                        List<String> anchorList = anchor.keywordsAnchor(htmlInString);
                        List<String> attributesList = attributes.attributesKeywords(htmlInString);
                        List<String> boldedList = bolded.boldedKeywords(htmlInString);
                        List<String> headlinesList = headlines.headlineKeywords(htmlInString);
                        List<String> metadataList = metadata.MetadataKeywords(htmlInString);

                        List<List<String>> keyWords = Arrays.asList(anchorList, attributesList, boldedList, headlinesList, metadataList);
//
                        System.out.println("Lista słów kluczowych po których można znaleść strony podobne do podanej:\n");

                        keyWords.stream()
                                .flatMap(Collection::stream)
                                .collect(Collectors.toSet())
                                .forEach(System.out::println);
                        break;
                    case 2:
                        ConvertColorToHex convertColorToHex = new ConvertColorToHex();

                        List<String> cssFromHtmlHead = cssFromHtml.codeHeadList(htmlInString);
                        List<String> cssFromHtmlInHtmlTags = cssFromHtml.codeInlineList(htmlInString);

                        List<String> colorsHexRgbRgbaFromCss = colors.extractHexRgbRgbaColors(cssFile.readFileToList());
                        List<String> colorsHexRgbRgbaFromHtmlHead = colors.extractHexRgbRgbaColors(cssFromHtmlHead);
                        List<String> colorsHexRgbRgbaFromHtmlInHtmlTags = colors.extractHexRgbRgbaColors(cssFromHtmlInHtmlTags);
                        List<String> colorNamesFromCss = colors.extractNamesColors(cssFile.readFileToList());
                        List<String> colorNamesFromHtmlHead = colors.extractNamesColors(cssFromHtmlHead);
                        List<String> colorNamesFromHtmlInHtmlTags = colors.extractNamesColors(cssFromHtmlInHtmlTags);

                        List<List<String>> colorsHexRgbRgbaOnPageWithDuplicates = Arrays.asList(colorsHexRgbRgbaFromCss,
                                colorsHexRgbRgbaFromHtmlHead,
                                colorsHexRgbRgbaFromHtmlInHtmlTags);

                        List<List<String>> colorsNamesOnPageWithDuplicates = Arrays.asList(colorNamesFromCss,
                                colorNamesFromHtmlHead,
                                colorNamesFromHtmlInHtmlTags);

                        Set<String> distinctColorsHexRgbRgba;
                        Set<String> distinctColorsNames;

                        Set<String> distinctHex = new HashSet<>();

                        distinctColorsHexRgbRgba = colorsHexRgbRgbaOnPageWithDuplicates.stream()
                                .flatMap(Collection::stream)
                                .collect(Collectors.toSet());

                        distinctColorsNames = colorsNamesOnPageWithDuplicates.stream()
                                .flatMap(Collection::stream)
                                .collect(Collectors.toSet());

                        for(String item: distinctColorsNames){
                            try {
                                convertColorToHex.nameToHex(item);
                                distinctHex.add(convertColorToHex.getColorHex());
                            } catch (IllegalArgumentException e){
                                e.printStackTrace();
                            }
                        }

                        for(String item : distinctColorsHexRgbRgba){
                            try {
                                convertColorToHex.checkColorFormatAndConvert(item);
                                distinctHex.add(convertColorToHex.getColorHex());
                            } catch (IllegalArgumentException e){
                                e.printStackTrace();
                            }
                        }

                        System.out.println("Użyte kolory na stronie to:\n");
                        for(String item : distinctHex){
                            System.out.println(item);
                        }

                        break;
                    case 3:
                        String baseUrl;
                        System.out.println("Podaj link bazowy - domena.pl");
                        baseUrl = reader.next();
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
                            System.out.println("Nie znaleziono pliku z deprecjonowanymi elementami\n" );
                            e.printStackTrace();
                        }

                        caseOfHtml5.CheckIfHtml5(htmlInString);
                        for(String item : deprecatedTagsRaport){
                            System.out.println(item);
                        }

                        System.out.println("\nRaport sekcji HEAD");
                        for(String item: settingsInHeadRaport){
                            System.out.println(item);
                        }

                        System.out.println("\n");

                        System.out.println(headlinesInHtml.checkHeadlinesInHtml(htmlInString));
                        System.out.println(headlinesInHtml.checkNoOccurrancesH1(htmlInString));

                        System.out.println("\n");

                        for(String item : altAndTitleInImageRaport){
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
}
