package library.com.github.programmerr47.discogs.responseobjects.usercollection;

import library.Constants;
import library.org.json.JSONObject;

/**
 * @author Michael Spitsin
 * @since 2014-09-11
 */
@SuppressWarnings("unused")
public class CollectionFolder {
    private static final String ID_TAG = "id";
    private static final String COUNT_TAG = "count";
    private static final String NAME_TAG = "name";
    private static final String RESOURCE_URL_TAG = "resource_url";

    private String id;
    private int size;
    private String name;
    private String resourceUrl;

    public CollectionFolder(String id, int size, String name, String resourceUrl) {
        this.id = id;
        this.size = size;
        this.name = name;
        this.resourceUrl = resourceUrl;
    }

    public String getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    private static class Builder {
        private String id;
        private int size;
        private String name;
        private String resourceUrl;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setResourceUrl(String resourceUrl) {
            this.resourceUrl = resourceUrl;
            return this;
        }

        public CollectionFolder build() {
            return new CollectionFolder(id, size, name, resourceUrl);
        }
    }

    /**
     * Creates {@link CollectionFolder} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of folder of user collection or null, if json is null
     */
    public static CollectionFolder getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setId(jsonObject.optString(ID_TAG, null))
                    .setSize(jsonObject.optInt(COUNT_TAG, Constants.NO_ID))
                    .setName(jsonObject.optString(NAME_TAG, null))
                    .setResourceUrl(jsonObject.optString(RESOURCE_URL_TAG, null))
                    .build();
        }
    }
}
