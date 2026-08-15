package org.skypro.skyshop.search;

import org.skypro.skyshop.Exception.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    private final Map<String, List<Searchable>> searchables;

    public SearchEngine() {
        this.searchables = new TreeMap<>();
    }

    public void add(Searchable element) {
        if (element != null && element.getSearchTerm() != null) {
            searchables.computeIfAbsent(element.getSearchTerm(), k -> new ArrayList<>()).add(element);
        }
    }

    public List<Searchable> search(String searchTerm) {
        List<Searchable> result = new LinkedList<>();
        if (searchTerm == null || searchTerm.isEmpty()) {
            return result;
        }
        for (Map.Entry<String, List<Searchable>> entry : searchables.entrySet()) {
            String key = entry.getKey();
            if (key.contains(searchTerm)) {
                result.addAll(entry.getValue());
            }
        }
        return result;
    }

    public Searchable findBestElement(String search) {
        try {
            if (search == null || search.isEmpty()) {
                throw new BestResultNotFound("Поисковый запрос не может быть пустым");
            }
            Searchable bestElement = null;
            int maxCount = 0;
            for (List<Searchable> list : searchables.values()) {
                for (Searchable searchable : list) {
                    if (searchable == null || searchable.getSearchTerm() == null) {
                        continue;
                    }
                    String term = searchable.getSearchTerm();
                    int count = 0;
                    int index = term.indexOf(search);
                    while (index != -1) {
                        count++;
                        index = term.indexOf(search, index + search.length());
                    }
                    if (count > maxCount) {
                        maxCount = count;
                        bestElement = searchable;
                    }
                }
            }
            if (bestElement == null) {
                throw new BestResultNotFound(search + " - такого объекта нет");
            }
            return bestElement;
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}



