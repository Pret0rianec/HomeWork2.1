package org.skypro.skyshop.search;
import java.util.*;

public final class Article implements Searchable, Comparable<Article> {
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
    public int compareTo(Article o) {
        if(this.titleArticle == null && o.titleArticle == null) return 0;
        if(this.titleArticle == null) return -1;
        if(o.titleArticle == null) return 1;
        return this.titleArticle.compareTo(o.titleArticle);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Article article = (Article) obj;
        return Objects.equals(titleArticle, article.titleArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(titleArticle);
    }

    @Override
    public String toString() {
        return getTitleArticle() + System.lineSeparator() + getTextArticle();
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getTypeContent() {
        return "ARTICLE";
    }

    @Override
    public String getStringRepresentation() {
        return toString();
    }

    public String getName() {
        return getTitleArticle();
    }
}
