package org.skypro.skyshop.search;

import org.skypro.skyshop.Exception.BestResultNotFound;

public class SearchEngine {
    private Searchable[] searchables;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public void add(Searchable element) {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = element;
                return;
            }
        }
    }

    public Searchable[] search(String searchTerm) {
        Searchable[] result = new Searchable[5];
        int count = 0;
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(searchTerm)) {
                result[count] = searchable;
                count++;
                if (count == 5) {
                    break;
                }
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
            for (Searchable searchable : searchables) {
                if (searchable == null) {
                    continue;
                }
                String term = searchable.getSearchTerm();
                if (term == null) {
                    continue;
                }
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


