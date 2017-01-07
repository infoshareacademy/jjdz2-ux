package com.sionach.ux.keyWords;

public class KeyWordsLinks {
    String keyword;

    public String getKeyword() {
        return keyword;
    }

    public String getKeywordUrl() {
        return keywordUrl;
    }

    String keywordUrl;

    public KeyWordsLinks(String keyword, String keywordUrl) {
        this.keyword = keyword;
        this.keywordUrl = keywordUrl;
    }
}
