package library.com.github.programmerr47.discogs.objects.database;

import library.JSONUtil;
import library.com.github.programmerr47.discogs.objects.summary.ArtistSummary;
import library.com.github.programmerr47.discogs.objects.summary.Image;

import library.org.json.JSONObject;

import java.util.List;

/**
 * Class for representing Discogs artist from their database.
 *
 * @author Michael Spitsin
 * @since 2014-07-25
 */
@SuppressWarnings("unused")
public class Artist {
    //TODO add members
    public static final String ID_TAG = "id";
    public static final String NAME_TAG = "name";
    public static final String RESOURCE_URL_TAG = "resource_url";
    public static final String RELEASES_URL_TAG = "releases_url";
    public static final String URI_TAG = "uri";
    public static final String REAL_NAME_TAG = "realname";
    public static final String PROFILE_TAG = "profile";
    public static final String DATA_QUALITY_TAG = "data_quality";
    public static final String NAME_VARIATIONS_TAG = "namevariations";
    public static final String ALIASES_TAG = "aliases";
    public static final String URLS_TAG = "urls";
    public static final String IMAGES_TAG = "images";

    private String id;
    private String name;
    private String resourceUrl;
    private String releasesUrl;
    private String uri;
    private String realName;
    private String profile;
    private String dataQuality;
    private List<String> nameVariations;
    private List<ArtistSummary> aliases;
    private List<String> urls;
    private List<Image> images;

    private Artist(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.resourceUrl = builder.resourceUrl;
        this.releasesUrl = builder.releasesUrl;
        this.uri = builder.uri;
        this.realName = builder.realName;
        this.profile = builder.realName;
        this.dataQuality = builder.dataQuality;
        this.nameVariations = builder.nameVariations;
        this.aliases = builder.aliases;
        this.urls = builder.urls;
        this.images = builder.images;
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

    public String getReleasesUrl() {
        return releasesUrl;
    }

    public String getUri() {
        return uri;
    }

    public String getRealName() {
        return realName;
    }

    public String getProfile() {
        return profile;
    }

    public String getDataQuality() {
        return dataQuality;
    }

    public List<String> getNameVariations() {
        return nameVariations;
    }

    public List<ArtistSummary> getAliases() {
        return aliases;
    }

    public List<String> getUrls() {
        return urls;
    }

    public List<Image> getImages() {
        return images;
    }

    public static class Builder {
        private String id;
        private String name;
        private String resourceUrl;
        private String releasesUrl;
        private String uri;
        private String realName;
        private String profile;
        private String dataQuality;
        private List<String> nameVariations;
        private List<ArtistSummary> aliases;
        private List<String> urls;
        private List<Image> images;

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

        public Builder setReleasesUrl(String releasesUrl) {
            this.releasesUrl = releasesUrl;
            return this;
        }

        public Builder setUri(String uri) {
            this.uri = uri;
            return this;
        }

        public Builder setRealName(String realName) {
            this.realName = realName;
            return this;
        }

        public Builder setProfile(String profile) {
            this.profile = profile;
            return this;
        }

        public Builder setDataQuality(String dataQuality) {
            this.dataQuality = dataQuality;
            return this;
        }

        public Builder setNameVariations(List<String> nameVariations) {
            this.nameVariations = nameVariations;
            return this;
        }

        public Builder setAliases(List<ArtistSummary> aliases) {
            this.aliases = aliases;
            return this;
        }

        public Builder setUrls(List<String> urls) {
            this.urls = urls;
            return this;
        }

        public Builder setImages(List<Image> images) {
            this.images = images;
            return this;
        }

        public Artist build() {
            return new Artist(this);
        }
    }

    /**
     * Creates {@link Artist} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of artist or null, if json is null
     */
    public static Artist getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setId(jsonObject.optString(ID_TAG, null))
                    .setName(jsonObject.optString(NAME_TAG, null))
                    .setResourceUrl(jsonObject.optString(RESOURCE_URL_TAG, null))
                    .setReleasesUrl(jsonObject.optString(RELEASES_URL_TAG, null))
                    .setUri(jsonObject.optString(URI_TAG, null))
                    .setProfile(jsonObject.optString(PROFILE_TAG, null))
                    .setRealName(jsonObject.optString(REAL_NAME_TAG, null))
                    .setDataQuality(jsonObject.optString(DATA_QUALITY_TAG, null))
                    .setNameVariations(JSONUtil.getStringList(jsonObject.optJSONArray(NAME_VARIATIONS_TAG)))
                    .setUrls(JSONUtil.getStringList(jsonObject.optJSONArray(URLS_TAG)))
                    .setAliases(ArtistSummary.getFromJSONArray(jsonObject.optJSONArray(ALIASES_TAG)))
                    .setImages(Image.getFromJSONArray(jsonObject.optJSONArray(IMAGES_TAG)))
                    .build();
        }
    }
}
