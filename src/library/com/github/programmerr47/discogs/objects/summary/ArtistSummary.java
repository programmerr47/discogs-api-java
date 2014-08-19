package library.com.github.programmerr47.discogs.objects.summary;

import library.org.json.JSONArray;
import library.org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for representing Discogs artist with short information from their database.
 *
 * @author Michael Spitsin
 * @since 2014-07-25
 */
public class ArtistSummary {
    public static final String ID_TAG = "id";
    public static final String NAME_TAG = "name";
    public static final String RESOURCE_URL_TAG = "resource_url";

    private String id;
    private String name;
    private String resourceUrl;

    private ArtistSummary(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.resourceUrl = builder.resourceUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public static class Builder {
        private String id;
        private String name;
        private String resourceUrl;

        public Builder setId(String id) {
            this.id = id;
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

        public ArtistSummary build() {
            return new ArtistSummary(this);
        }
    }

    /**
     * Creates {@link ArtistSummary} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of artistSummary or null, if json is null
     */
    public static ArtistSummary getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setId(jsonObject.optString(ID_TAG, null))
                    .setName(jsonObject.optString(NAME_TAG, null))
                    .setResourceUrl(jsonObject.optString(RESOURCE_URL_TAG, null))
                    .build();
        }
    }

    /**
     * Creates list of {@link ArtistSummary} objects from its JSON Counterpart.
     *
     * @param jsonArray - given JSON array
     * @return new instance of artistSummary or null, if json is null
     */
    public static List<ArtistSummary> getFromJSONArray(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        } else {
            List<ArtistSummary> resultList = new ArrayList<ArtistSummary>();
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
