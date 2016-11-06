package com.sionach.ux.accessibility;

import javax.ejb.Stateless;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by allic on 04/11/2016.
 */
@Stateless
public class AccessibilityClip {

    public void Accessibility(String htmlInString) {

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
    }

}
