package org.skypro.skyshop.search;

public final class Article implements Searchable {
    private final String titleArticle;
    private final String textArticle;

    public Article(String titleArticle, String textArticle) {
        this.titleArticle = titleArticle;
        this.textArticle = textArticle;
    }

    public String getTitleArticle() {
        return titleArticle;
    }

    public String getTextArticle() {
        return textArticle;
    }

    @Override
    public String toString() {
        return getTitleArticle() + System.lineSeparator() + getTextArticle();
    }

    @Override
    public String getSearchTerm() {return toString();}

    @Override
    public String getTypeContent() {return "ARTICLE";}
    @Override
    public String getStringRepresentation() {return toString();}

    public String getName() {return getTitleArticle();}
}
