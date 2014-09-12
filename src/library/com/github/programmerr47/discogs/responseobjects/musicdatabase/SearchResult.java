package library.com.github.programmerr47.discogs.responseobjects.musicdatabase;

import library.com.github.programmerr47.discogs.responseobjects.summary.Pagination;

import library.org.json.JSONObject;

import java.util.List;

/**
 * Class for representing Discogs search result.
 *
 * @author Michael Spitsin
 * @since 2014-07-04
 */
@SuppressWarnings("unused")
public class SearchResult {
    public static final String PAGINATION_TAG = "pagination";
    public static final String ITEMS_TAG = "results";

    private Pagination pagination;
    private List<SearchResultItem> items;

    private SearchResult(Builder builder) {
        this.pagination = builder.pagination;
        this.items = builder.items;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public List<SearchResultItem> getItems() {
        return items;
    }

    public static class Builder {
        private Pagination pagination;
        private List<SearchResultItem> items;

        public Builder setPagination(Pagination pagination) {
            this.pagination = pagination;
            return this;
        }

        public Builder setItems(List<SearchResultItem> items) {
            this.items = items;
            return this;
        }

        public SearchResult build() {
            return new SearchResult(this);
        }
    }

    /**
     * Creates {@link SearchResult} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of search result or null, if json is null
     */
    public static SearchResult getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setPagination(Pagination.getFromJSONObject(jsonObject.optJSONObject(PAGINATION_TAG)))
                    .setItems(SearchResultItem.getFromJSONArray(jsonObject.optJSONArray(ITEMS_TAG)))
                    .build();
        }
    }
}
