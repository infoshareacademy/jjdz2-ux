package com.sionach.ux.color;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Stateless
public class ClipColors {

    public Set<String> ClipColorsFromData(String url) {

        DistHex distHex = new DistHex();

        CssFromHtmlUrl cssFromHtmlUrl = new CssFromHtmlUrl();
        List<String> totalCssList = cssFromHtmlUrl.GetTotalCssListFromUrl(url);

        List<String> colorsList = ExtractColorsFromData.extractHexRgbRgbaColors(totalCssList);
        colorsList.addAll(ExtractColorsFromData.extractNamesColors(totalCssList));

        ConvertColorToHex convertColorToHex = new ConvertColorToHex();
        List<String> colorHex = new ArrayList<>();
        for (String s : colorsList) {
            colorHex.add(convertColorToHex.checkColorFormatAndConvert(s));
        }

        Set<String> distinctColorsHex = new HashSet<>(colorHex);

        distHex.setDistinctHex(distinctColorsHex);

        return distHex.getDistinctHex();

    }

}
