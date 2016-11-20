package com.sionach.ux.color;

import com.sionach.ux.filemanagment.ReadFiles;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;
import java.util.stream.Collectors;

@Stateless
public class ClipColors {

    @PersistenceContext
    EntityManager entityManager;

    private Set<String> distinctHex = new HashSet<>();

    public Set<String> getDistinctHex() {
        return distinctHex;
    }

    public void ClipColorsFromData(String htmlInString, ReadFiles cssFile) {

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

        distinctColorsHexRgbRgba = colorsHexRgbRgbaOnPageWithDuplicates.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

        distinctColorsNames = colorsNamesOnPageWithDuplicates.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

        for (String item : distinctColorsNames) {
            try {
                convertColorToHex.nameToHex(item);
                this.distinctHex.add(convertColorToHex.getColorHex());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        for (String item : distinctColorsHexRgbRgba) {
            try {
                convertColorToHex.checkColorFormatAndConvert(item);
                this.distinctHex.add(convertColorToHex.getColorHex());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        for (String singleHex : distinctHex){
            entityManager.persist(singleHex);
        }

    }

}
