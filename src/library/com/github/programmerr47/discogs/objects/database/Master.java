package library.com.github.programmerr47.discogs.objects.database;

import library.JSONUtil;
import library.com.github.programmerr47.discogs.objects.summary.ArtistSummary;
import library.com.github.programmerr47.discogs.objects.summary.Image;
import library.com.github.programmerr47.discogs.objects.summary.Recording;
import library.com.github.programmerr47.discogs.objects.summary.Video;

import library.org.json.JSONObject;

import java.util.List;

/**
 * Class for representing Discogs master from their database.
 *
 * @author Michael Spitsin
 * @since 2014-07-27
 */
@SuppressWarnings("unused")
public class Master {
    public static final String ID_TAG = "id";
    public static final String TITLE_TAG = "title";
    public static final String RESOURCE_URL_TAG = "resource_url";
    public static final String VERSIONS_TAG = "versions_url";
    public static final String URI_TAG = "uri";
    public static final String MAIN_RELEASE_ID_TAG = "main_release";
    public static final String MAIN_RELEASE_URL_TAG = "main_release_url";
    public static final String YEAR_TAG = "year";
    public static final String DATA_QUALITY_TAG = "data_quality";
    public static final String STYLES_TAG = "styles";
    public static final String GENRES_TAG = "genres";
    public static final String VIDEOS_TAG = "videos";
    public static final String ARTISTS_TAG = "artists";
    public static final String IMAGES_TAG = "images";
    public static final String TRACK_LIST_TAG = "tracklist";

    private String id;
    private String title;
    private String resourceUrl;
    private String versionsUrl;
    private String uri;
    private String mainReleaseId;
    private String mainReleaseUrl;
    private String year;
    private String dataQuality;
    private List<String> styles;
    private List<String> genres;
    private List<Video> videos;
    private List<ArtistSummary> artists;
    private List<Image> images;
    private List<Recording> tracklist;

    private Master(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.resourceUrl = builder.resourceUrl;
        this.versionsUrl = builder.versionsUrl;
        this.uri = builder.uri;
        this.mainReleaseId = builder.mainReleaseId;
        this.mainReleaseUrl = builder.mainReleaseUrl;
        this.year = builder.year;
        this.dataQuality = builder.dataQuality;
        this.styles = builder.styles;
        this.genres = builder.genres;
        this.videos = builder.videos;
        this.artists = builder.artists;
        this.images = builder.images;
        this.tracklist = builder.tracklist;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public String getVersionsUrl() {
        return versionsUrl;
    }

    public String getUri() {
        return uri;
    }

    public String getMainReleaseId() {
        return mainReleaseId;
    }

    public String getMainReleaseUrl() {
        return mainReleaseUrl;
    }

    public String getYear() {
        return year;
    }

    public String getDataQuality() {
        return dataQuality;
    }

    public List<String> getStyles() {
        return styles;
    }

    public List<String> getGenres() {
        return genres;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public List<ArtistSummary> getArtists() {
        return artists;
    }

    public List<Image> getImages() {
        return images;
    }

    public List<Recording> getTracklist() {
        return tracklist;
    }

    public static class Builder {
        private String id;
        private String title;
        private String resourceUrl;
        private String versionsUrl;
        private String uri;
        private String mainReleaseId;
        private String mainReleaseUrl;
        private String year;
        private String dataQuality;
        private List<String> styles;
        private List<String> genres;
        private List<Video> videos;
        private List<ArtistSummary> artists;
        private List<Image> images;
        private List<Recording> tracklist;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setResourceUrl(String resourceUrl) {
            this.resourceUrl = resourceUrl;
            return this;
        }

        public Builder setVersionsUrl(String versionsUrl) {
            this.versionsUrl = versionsUrl;
            return this;
        }

        public Builder setUri(String uri) {
            this.uri = uri;
            return this;
        }

        public Builder setMainReleaseId(String mainReleaseId) {
            this.mainReleaseId = mainReleaseId;
            return this;
        }

        public Builder setMainReleaseUrl(String mainReleaseUrl) {
            this.mainReleaseUrl = mainReleaseUrl;
            return this;
        }

        public Builder setYear(String year) {
            this.year = year;
            return this;
        }

        public Builder setDataQuality(String dataQuality) {
            this.dataQuality = dataQuality;
            return this;
        }

        public Builder setStyles(List<String> styles) {
            this.styles = styles;
            return this;
        }

        public Builder setGenres(List<String> genres) {
            this.genres = genres;
            return this;
        }

        public Builder setVideos(List<Video> videos) {
            this.videos = videos;
            return this;
        }

        public Builder setArtists(List<ArtistSummary> artists) {
            this.artists = artists;
            return this;
        }

        public Builder setImages(List<Image> images) {
            this.images = images;
            return this;
        }

        public Builder setTracklist(List<Recording> tracklist) {
            this.tracklist = tracklist;
            return this;
        }

        public Master build() {
            return new Master(this);
        }
    }

    /**
     * Creates {@link Master} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of master or null, if json is null
     */
    public static Master getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setId(jsonObject.optString(ID_TAG, null))
                    .setTitle(jsonObject.optString(TITLE_TAG, null))
                    .setResourceUrl(jsonObject.optString(RESOURCE_URL_TAG, null))
                    .setVersionsUrl(jsonObject.optString(VERSIONS_TAG, null))
                    .setUri(jsonObject.optString(URI_TAG, null))
                    .setMainReleaseId(jsonObject.optString(MAIN_RELEASE_ID_TAG, null))
                    .setMainReleaseUrl(jsonObject.optString(MAIN_RELEASE_URL_TAG, null))
                    .setYear(jsonObject.optString(YEAR_TAG, null))
                    .setDataQuality(jsonObject.optString(DATA_QUALITY_TAG, null))
                    .setStyles(JSONUtil.getStringList(jsonObject.optJSONArray(STYLES_TAG)))
                    .setGenres(JSONUtil.getStringList(jsonObject.optJSONArray(GENRES_TAG)))
                    .setVideos(Video.getFromJSONArray(jsonObject.optJSONArray(VIDEOS_TAG)))
                    .setArtists(ArtistSummary.getFromJSONArray(jsonObject.optJSONArray(ARTISTS_TAG)))
                    .setImages(Image.getFromJSONArray(jsonObject.optJSONArray(IMAGES_TAG)))
                    .setTracklist(Recording.getFromJSONArray(jsonObject.optJSONArray(TRACK_LIST_TAG)))
                    .build();
        }
    }
}
