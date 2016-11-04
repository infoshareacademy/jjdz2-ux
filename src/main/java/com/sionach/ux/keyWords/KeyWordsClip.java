package com.sionach.ux.keyWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by allic on 04/11/2016.
 */
public class KeyWordsClip {

    List<List<String>> keyWords = new ArrayList<>();

    public List<List<String>> getKeyWords() {
        return keyWords;
    }

    public void KeyWordsFromData (String htmlInString){
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

        this.keyWords = Arrays.asList(anchorList, attributesList, boldedList, headlinesList, metadataList);

        System.out.println("Lista słów kluczowych po których można znaleść strony podobne do podanej:\n");

        keyWords.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());

    }



}
