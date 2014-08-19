package library.com.github.programmerr47.discogs.objects.database;

import library.JSONUtil;
import library.com.github.programmerr47.discogs.objects.summary.Image;
import library.com.github.programmerr47.discogs.objects.summary.LabelSummary;

import library.org.json.JSONObject;

import java.util.List;

/**
 * Class for representing Discogs label from their database.
 *
 * @author Michael Spitsin
 * @since 2014-07-25
 */
public class Label {
    public static final String ID_TAG = "id";
    public static final String NAME_TAG = "name";
    public static final String PROFILE_TAG = "profile";
    public static final String RESOURCE_URL_TAG = "resource_url";
    public static final String RELEASES_URL_TAG = "releases_url";
    public static final String URI_TAG = "uri";
    public static final String DATA_QUALITY_TAG = "data_quality";
    public static final String CONTACT_INFO = "contact_info";
    public static final String PARENT_LABEL_TAG = "parent_label";
    public static final String SUBLABELS_TAG = "sublabels";
    public static final String URLS_TAG = "urls";
    public static final String IMAGES_TAG = "images";

    private String id;
    private String name;
    private String profile;
    private String resourceUrl;
    private String releasesUrl;
    private String uri;
    private String dataQuality;
    private String contactInfo;
    private LabelSummary parentLabel;
    private List<LabelSummary> subLabels;
    private List<String> urls;
    private List<Image> images;

    private Label(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.profile = builder.profile;
        this.resourceUrl = builder.resourceUrl;
        this.releasesUrl = builder.releasesUrl;
        this.uri = builder.uri;
        this.dataQuality = builder.dataQuality;
        this.contactInfo = builder.contactInfo;
        this.parentLabel = builder.parentLabel;
        this.subLabels = builder.subLabels;
        this.urls = builder.urls;
        this.images = builder.images;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProfile() {
        return profile;
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

    public String getDataQuality() {
        return dataQuality;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public LabelSummary getParentLabel() {
        return parentLabel;
    }

    public List<LabelSummary> getSubLabels() {
        return subLabels;
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
        private String profile;
        private String resourceUrl;
        private String releasesUrl;
        private String uri;
        private String dataQuality;
        private String contactInfo;
        private LabelSummary parentLabel;
        private List<LabelSummary> subLabels;
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

        public Builder setProfile(String profile) {
            this.profile = profile;
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

        public Builder setDataQuality(String dataQuality) {
            this.dataQuality = dataQuality;
            return this;
        }

        public Builder setContactInfo(String contactInfo) {
            this.contactInfo = contactInfo;
            return this;
        }

        public Builder setParentLabel(LabelSummary parentLabel) {
            this.parentLabel = parentLabel;
            return this;
        }

        public Builder setSubLabels(List<LabelSummary> subLabels) {
            this.subLabels = subLabels;
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

        public Label build() {
            return new Label(this);
        }
    }

    /**
     * Creates {@link Label} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of label or null, if json is null
     */
    public static Label getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setId(jsonObject.optString(ID_TAG, null))
                    .setName(jsonObject.optString(NAME_TAG, null))
                    .setResourceUrl(jsonObject.optString(RESOURCE_URL_TAG, null))
                    .setUri(jsonObject.optString(URI_TAG, null))
                    .setContactInfo(jsonObject.optString(CONTACT_INFO, null))
                    .setDataQuality(jsonObject.optString(DATA_QUALITY_TAG, null))
                    .setProfile(jsonObject.optString(PROFILE_TAG, null))
                    .setReleasesUrl(jsonObject.optString(RELEASES_URL_TAG, null))
                    .setUrls(JSONUtil.getStringList(jsonObject.optJSONArray(URLS_TAG)))
                    .setParentLabel(LabelSummary.getFromJSONObject(jsonObject.optJSONObject(PARENT_LABEL_TAG)))
                    .setSubLabels(LabelSummary.getFromJSONArray(jsonObject.optJSONArray(SUBLABELS_TAG)))
                    .setImages(Image.getFromJSONArray(jsonObject.optJSONArray(IMAGES_TAG)))
                    .build();
        }
    }
}
