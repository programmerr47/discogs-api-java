package library.com.github.programmerr47.discogs.objects.summary;

import library.Constants;
import library.org.json.JSONObject;

/**
 * Class for representing Discogs search result header.
 *
 * @author Michael Spitsin
 * @since 2014-07-27
 */
@SuppressWarnings("unused")
public class Pagination {
    public static final String PER_PAGE_TAG = "per_page";
    public static final String PAGE_COUNT_TAG = "pages";
    public static final String CURRENT_PAGE_TAG = "page";
    public static final String ITEM_COUNT_TAG = "items";
    public static final String URLS_TAG = "urls";
    
    private int perPageItemCount;
    private int pageCount;
    private int itemCount;
    private int currentPage;
    private PaginationUrls urls;
    
    private Pagination(Builder builder) {
        this.perPageItemCount = builder.perPageItemCount;
        this.pageCount = builder.pageCount;
        this.itemCount = builder.itemCount;
        this.currentPage = builder.currentPage;
        this.urls = builder.urls;
    }

    public int getPerPageItemCount() {
        return perPageItemCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getItemCount() {
        return itemCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public PaginationUrls getUrls() {
        return urls;
    }

    public static class Builder {
        private int perPageItemCount;
        private int pageCount;
        private int itemCount;
        private int currentPage;
        private PaginationUrls urls;

        public Builder setPerPageItemCount(int perPageItemCount) {
            this.perPageItemCount = perPageItemCount;
            return this;
        }

        public Builder setPageCount(int pageCount) {
            this.pageCount = pageCount;
            return this;
        }

        public Builder setItemCount(int itemCount) {
            this.itemCount = itemCount;
            return this;
        }

        public Builder setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
            return this;
        }

        public Builder setUrls(PaginationUrls urls) {
            this.urls = urls;
            return this;
        }

        public Pagination build() {
            return new Pagination(this);
        }
    }

    /**
     * Creates {@link Pagination} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of pagination or null, if json is null
     */
    public static Pagination getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setCurrentPage(jsonObject.optInt(CURRENT_PAGE_TAG, Constants.NO_ID))
                    .setItemCount(jsonObject.optInt(ITEM_COUNT_TAG, Constants.NO_ID))
                    .setPageCount(jsonObject.optInt(PAGE_COUNT_TAG, Constants.NO_ID))
                    .setPerPageItemCount(jsonObject.optInt(PER_PAGE_TAG, Constants.NO_ID))
                    .setUrls(PaginationUrls.getFromJSONObject(jsonObject.optJSONObject(URLS_TAG)))
                    .build();
        }
    }
}
