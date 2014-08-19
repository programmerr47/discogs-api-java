package library.com.github.programmerr47.discogs.objects.summary;

import library.org.json.JSONObject;

/**
 * @author Michael Spitsin
 * @since 2014-07-27
 */
public class PaginationUrls {
    public static final String LAST_URL_TAG = "last";
    public static final String FIRST_URL_TAG = "first";
    public static final String PREV_URL_TAG = "prev";
    public static final String NEXT_URL_TAG = "next";

    private String lastUrl;
    private String firstUrl;
    private String nextUrl;
    private String prevUrl;

    private PaginationUrls(Builder builder) {
        this.lastUrl = builder.lastUrl;
        this.firstUrl = builder.firstUrl;
        this.nextUrl = builder.firstUrl;
        this.prevUrl = builder.prevUrl;
    }

    public String getLastUrl() {
        return lastUrl;
    }

    public String getFirstUrl() {
        return firstUrl;
    }

    public String getNextUrl() {
        return nextUrl;
    }

    public String getPrevUrl() {
        return prevUrl;
    }

    public static class Builder {
        private String lastUrl;
        private String firstUrl;
        private String nextUrl;
        private String prevUrl;

        public Builder setLastUrl(String lastUrl) {
            this.lastUrl = lastUrl;
            return this;
        }

        public Builder setFirstUrl(String firstUrl) {
            this.firstUrl = firstUrl;
            return this;
        }

        public Builder setNextUrl(String nextUrl) {
            this.nextUrl = nextUrl;
            return this;
        }

        public Builder setPrevUrl(String prevUrl) {
            this.prevUrl = prevUrl;
            return this;
        }

        public PaginationUrls build() {
            return new PaginationUrls(this);
        }
    }

    /**
     * Creates {@link PaginationUrls} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of paginationUrls or null, if json is null
     */
    public static PaginationUrls getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setFirstUrl(jsonObject.optString(FIRST_URL_TAG, null))
                    .setLastUrl(jsonObject.optString(LAST_URL_TAG, null))
                    .setNextUrl(jsonObject.optString(NEXT_URL_TAG, null))
                    .setPrevUrl(jsonObject.optString(PREV_URL_TAG, null))
                    .build();
        }
    }
}
