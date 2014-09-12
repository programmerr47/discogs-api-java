package library.com.github.programmerr47.discogs.responseobjects.musicdatabase;

import library.com.github.programmerr47.discogs.utils.SearchType;
import library.org.json.JSONArray;
import library.org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for representing Discogs search result element.
 *
 * @author Michael Spitsin
 * @since 2014-07-27
 */
@SuppressWarnings("unused")
public class SearchResultItem {
    public static final String THUMB_TAG = "thumb";
    public static final String TITLE_TAG = "title";
    public static final String URI_TAG = "uri";
    public static final String RESOURCE_URL_TAG = "resource_url";
    public static final String TYPE_TAG = "type";
    public static final String ID_TAG = "id";

    private String id;
    private SearchType type;
    private String title;
    private String thumbUrl;
    private String uri;
    private String resourceUrl;

    private SearchResultItem(Builder builder) {
        this.id = builder.id;
        this.type = builder.type;
        this.title = builder.title;
        this.thumbUrl = builder.thumbUrl;
        this.uri = builder.uri;
        this.resourceUrl = builder.resourceUrl;
    }

    public String getId() {
        return id;
    }

    public SearchType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public String getUri() {
        return uri;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public static class Builder {
        private String id;
        private SearchType type;
        private String title;
        private String thumbUrl;
        private String uri;
        private String resourceUrl;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setType(SearchType type) {
            this.type = type;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setThumbUrl(String thumbUrl) {
            this.thumbUrl = thumbUrl;
            return this;
        }

        public Builder setUri(String uri) {
            this.uri = uri;
            return this;
        }

        public Builder setResourceUrl(String resourceUrl) {
            this.resourceUrl = resourceUrl;
            return this;
        }

        public SearchResultItem build() {
            return new SearchResultItem(this);
        }
    }

    /**
     * Creates {@link SearchResultItem} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of searchResult or null, if json is null
     */
    public static SearchResultItem getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setId(jsonObject.optString(ID_TAG, null))
                    .setThumbUrl(jsonObject.optString(THUMB_TAG, null))
                    .setTitle(jsonObject.optString(TITLE_TAG, null))
                    .setResourceUrl(jsonObject.optString(RESOURCE_URL_TAG, null))
                    .setType(SearchType.valueOf(jsonObject.optString(TYPE_TAG, null)))
                    .setUri(jsonObject.optString(URI_TAG, null))
                    .build();
        }
    }

    /**
     * Creates list of {@link SearchResultItem} objects from its JSON Counterpart.
     *
     * @param jsonArray - given JSON array
     * @return new instance of searchResultItem or null, if json is null
     */
    public static List<SearchResultItem> getFromJSONArray(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        } else {
            List<SearchResultItem> resultList = new ArrayList<SearchResultItem>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.optJSONObject(i);

                if (jsonObject != null) {
                    resultList.add(getFromJSONObject(jsonObject));
                }
            }

            return resultList;
        }
    }
}
