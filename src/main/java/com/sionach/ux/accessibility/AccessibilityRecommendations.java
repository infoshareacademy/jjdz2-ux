package com.sionach.ux.accessibility;

import com.sun.org.apache.xerces.internal.impl.xs.util.LSInputListImpl;

import javax.ejb.Stateless;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by drzalek on 27.11.16.
 */
@Stateless
public class AccessibilityRecommendations {

    private String domainUrl;

    public void setDomainUrl(String domainUrl) {
        this.domainUrl = domainUrl;
    }

    private SettingsInHeadElement settingsInHeadElement = new SettingsInHeadElement();

    private LinksInHtml linksInHtml = new LinksInHtml();

    private DeprecatedTagsInHtml deprecatedTagsInHtml = new DeprecatedTagsInHtml();

    private HeadlinesInHtml headlinesInHtml = new HeadlinesInHtml();

    public List<String> checkHeadlinesInBodyHtml(){
        List<String> headlinesRecommendations = new ArrayList<>();
        headlinesInHtml.setDomainUrl(domainUrl);
        if(headlinesInHtml.checkNoH1Occurance()==0)
            headlinesRecommendations.add("Na Twopjej stronie brakuje nagłówka rzędu pierwszego H1, zaleca się użycie H1 dokładnie raz na stronie");
        else if(headlinesInHtml.checkNoH1Occurance()>1)
            headlinesRecommendations.add("Nagłówek pierwszego rzędu H1 występuje więcej niż raz na Twojej stronie. H1 powinno występować tylko raz w jednym dokumencie HTML");
        else
            headlinesRecommendations.add("Nagłówek rzędu pierwszego H1 występuje poprawnie tylko jeden raz na Twojej stronie");

        if(headlinesInHtml.checkNoHeadlinesOccurance()==0)
            headlinesRecommendations.add("Na Twojej stronie brakuje nagłówków H1-H6, dodaj nagłówki na swojej stronie aby poprawić widoczność strony w sieci i przejrzystość witryny");
        else
            headlinesRecommendations.add("Twoja strona ma prawidłowo ustawiony przynajmniej jeden nagłówek H1-H6");

        return headlinesRecommendations;
    }

    public List<String> checkDeprecatedTags(){
        List<String> deprecatedTagsList = new ArrayList<>();
        deprecatedTagsInHtml.setDomainUrl(domainUrl);
        try {
            if(deprecatedTagsInHtml.deprecatedHtmlTagsList().size()==0){
                deprecatedTagsList.add("Strona nie posiada zdeprecjonowanych elementów");
            }else{
                deprecatedTagsList = deprecatedTagsInHtml.deprecatedHtmlTagsList().stream().collect(Collectors.toList());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return deprecatedTagsList;
    }

    public String checkLinksInHtml(){
        linksInHtml.setDomainUrl(domainUrl);
        if(linksInHtml.noOfLinksInHtml() > 100)
            return "Liczba linków w Twojej witrynie jest zbyt duża i wynosi: "+linksInHtml.noOfLinksInHtml()+". Zalecana maksymalna liczbalinków to 100.";
        else
            return "Liczba linków w Twojej witrynie jest prawidłowa (nie większa niż 100) i wynosi: "+linksInHtml.noOfLinksInHtml();
    }

    public List<String> checkHeadParameters(){
        List<String> recomendationsList = new ArrayList<>();

        settingsInHeadElement.setDomainAddress(domainUrl);

        int descriptionOccurance = settingsInHeadElement.checkNoDescriptionOccurance();
        int descriptionLength = settingsInHeadElement.checkDescriptionLength();
        int metaKeywordsOccurance = settingsInHeadElement.checkMetaKeywordsOccurance();
        int titleOccurance = settingsInHeadElement.checkNoTitleOccurance();
        int titleLength = settingsInHeadElement.checkTitleLength();
        int relCanonicalOccurance = settingsInHeadElement.checkNoRelCanonicalOccurance();
        boolean isRelCanonical = settingsInHeadElement.checkRelCanonical();
        boolean htmlLang = settingsInHeadElement.checkHtmlLang();
        //boolean metaCharset = settingsInHeadElement.
        if(descriptionOccurance==0)
            recomendationsList.add("Brak opisu Twojej witryny w sekcji HEAD");
        else if(descriptionOccurance>1)
            recomendationsList.add("Opis Twojej witryny w sekcji HEAD występuje więcej niż raz");

        if(descriptionLength<150)
            recomendationsList.add("Długość opisu Twojej witryny w sekcji HEAD jest za mała i wynosi "+descriptionLength+" znaków, optymalna długość to 150-160 znaków");
        else if(descriptionLength>160)
            recomendationsList.add("Długość opisu Twojej witryny w sekcji HEAD jest za duża i wynosi "+descriptionLength+" znaków, optymalna długość to 150-160 znaków");
        else
            recomendationsList.add("Opis Twojej witryny w sekcji HEAD jest prawidłowy");

        if(metaKeywordsOccurance!=0)
            recomendationsList.add("Obecnie nie zaleca się stosowania METAKEYWORDS w sekcji HEAD");

        if(titleOccurance==0)
            recomendationsList.add("Brak tytułu Twojej witryny (tag TITLE) w sekcji HEAD");
        else if(titleOccurance>1)
            recomendationsList.add("Tytuł Twojej witryny w sekcji HEAD (tag TITLE) występuje więcej niż jeden.");

        if(titleLength<50)
            recomendationsList.add("Tytuł Twojej witryny w sekcji HEAD (tag TITLE) jest za krótki i wynosi "+titleLength+" znaków, optymalna długość znacznika TITLE to 50-60 znaków");
        else if(titleLength>60)
            recomendationsList.add("Tytuł Twojej witryny w sekcji HEAD (tag TITLE) jest za długi i wynosi "+titleLength+" znaków, optymalna długość znacznika TITLE to 50-60 znaków");
        else
            recomendationsList.add("Tytuł Twojej witryny w sekcji HEAD (tag TITLE) jest prawidłowy");

        if(relCanonicalOccurance==0)
            recomendationsList.add("Twoja witryna nie posiada ustawionego kanonicznego adresu.");
        else if(relCanonicalOccurance>1)
            recomendationsList.add("Twoja witryna posiada więcej niż jeden adres kanoniczny");
        else{
            if(isRelCanonical)
                recomendationsList.add("Adres kanoniczny Twojej witryny jest ustawiony poprawnie");
            else
                recomendationsList.add("Adres kanoniczny Twojej witryny nie jest prawidłowym adresem URL");
        }

        if(!htmlLang)
            recomendationsList.add("Język witryny w tagu HTML nie jest prawidłowo ustawiony");
        else
            recomendationsList.add("Język witryny w tagu HTML jest ustawiony poprawnie");


        return recomendationsList;
    }


}
