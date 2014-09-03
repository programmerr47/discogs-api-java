package library.com.github.programmerr47.discogs.objects.summary;

import library.Constants;
import library.org.json.JSONObject;

/**
 * Class for representing Discogs release with short information from their database.
 *
 * @author Michael Spitsin
 * @since 2014-08-17
 */
@SuppressWarnings("unused")
public class ReleaseSummary {
    public static final String ID_TAG = "id";
    public static final String RESOURCE_URL_TAG = "resource_url";
    public static final String DESCRIPTION_TAG = "description";
    public static final String CATALOG_NUMBER_TAG = "catalog_number";
    public static final String YEAR_TAG = "year";

    private String id;
    private String resourceUrl;
    private String description;
    private String catalogNumber;
    private int year;

    private ReleaseSummary(Builder builder) {
        this.id = builder.id;
        this.resourceUrl = builder.resourceUrl;
        this.description = builder.description;
        this.catalogNumber = builder.catalogNumber;
        this.year = builder.year;
    }

    @SuppressWarnings("unused")
    public String getId() {
        return id;
    }

    @SuppressWarnings("unused")
    public String getResourceUrl() {
        return resourceUrl;
    }

    @SuppressWarnings("unused")
    public String getDescription() {
        return description;
    }

    @SuppressWarnings("unused")
    public String getCatalogNumber() {
        return catalogNumber;
    }

    @SuppressWarnings("unused")
    public int getYear() {
        return year;
    }

    public static class Builder {
        private String id;
        private String resourceUrl;
        private String description;
        private String catalogNumber;
        private int year;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setResourceUrl(String resourceUrl) {
            this.resourceUrl = resourceUrl;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setCatalogNumber(String catalogNumber) {
            this.catalogNumber = catalogNumber;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public ReleaseSummary build() {
            return new ReleaseSummary(this);
        }
    }

    /**
     * Creates {@link ReleaseSummary} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of releaseSummary or null, if json is null
     */
    public static ReleaseSummary getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setId(jsonObject.optString(ID_TAG, null))
                    .setResourceUrl(jsonObject.optString(RESOURCE_URL_TAG, null))
                    .setDescription(jsonObject.optString(DESCRIPTION_TAG, null))
                    .setCatalogNumber(jsonObject.optString(CATALOG_NUMBER_TAG, null))
                    .setYear(jsonObject.optInt(YEAR_TAG, Constants.NO_ID))
                    .build();
        }
    }
}
