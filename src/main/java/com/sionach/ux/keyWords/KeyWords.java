package com.sionach.ux.keyWords;

import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Stateless
public class KeyWords {

    public Set<String> extractKeyWords(String htmlCode) {

        KeywordsFromAnchor keywordsFromAnchor = new KeywordsFromAnchor();
        KeywordsFromAttributes keywordsFromAttributes = new KeywordsFromAttributes();
        KeywordsFromBolded keywordsFromBolded = new KeywordsFromBolded();
        KeywordsFromHeadlines keywordsFromHeadlines = new KeywordsFromHeadlines();
        KeywordsFromMetadata keywordsFromMetadata = new KeywordsFromMetadata();

        List<List<String>> keyWords = Arrays.asList(
                keywordsFromAnchor.keywordsAnchor(htmlCode),
                keywordsFromAttributes.attributesKeywords(htmlCode),
                keywordsFromBolded.boldedKeywords(htmlCode),
                keywordsFromHeadlines.headlineKeywords(htmlCode),
                keywordsFromMetadata.MetadataKeywords(htmlCode));

        return keyWords.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }
}
