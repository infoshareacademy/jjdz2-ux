package com.sionach.ux.color;

import com.sionach.ux.filemanagment.ReadFiles;

import javax.ejb.Stateless;
import java.util.*;
import java.util.stream.Collectors;

@Stateless
public class ClipColors {
    
    public Set<String> ClipColorsFromData(String htmlInString, ReadFiles cssFile) {

        ConvertColorToHex convertColorToHex = new ConvertColorToHex();
        CssListFromHtml cssFromHtml = new CssListFromHtml();
        List<String> cssFromHtmlHead = cssFromHtml.codeHeadList(htmlInString);
        List<String> cssFromHtmlInHtmlTags = cssFromHtml.codeInlineList(htmlInString);

        //TODO
        List<String> colorsHexRgbRgbaFromCss = ExtractColorsFromData.extractHexRgbRgbaColors(cssFile.readFileToList(""));
        List<String> colorsHexRgbRgbaFromHtmlHead = ExtractColorsFromData.extractHexRgbRgbaColors(cssFromHtmlHead);
        List<String> colorsHexRgbRgbaFromHtmlInHtmlTags = ExtractColorsFromData.extractHexRgbRgbaColors(cssFromHtmlInHtmlTags);
        //TODO
        List<String> colorNamesFromCss = ExtractColorsFromData.extractNamesColors(cssFile.readFileToList(""));
        List<String> colorNamesFromHtmlHead = ExtractColorsFromData.extractNamesColors(cssFromHtmlHead);
        List<String> colorNamesFromHtmlInHtmlTags = ExtractColorsFromData.extractNamesColors(cssFromHtmlInHtmlTags);

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

        for (String item : distinctColorsNames) {
            try {
                convertColorToHex.nameToHex(item);
                distinctHex.add(convertColorToHex.getColorHex());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        for (String item : distinctColorsHexRgbRgba) {
            try {
                convertColorToHex.checkColorFormatAndConvert(item);
                distinctHex.add(convertColorToHex.getColorHex());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        //System.out.println("Użyte kolory na stronie to:\n");
        //distinctHex.forEach(System.out::println);
        return distinctHex;
    }
}
