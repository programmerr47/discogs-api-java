package library.com.github.programmerr47.discogs.objects.database;

import library.Constants;
import library.JSONUtil;
import library.com.github.programmerr47.discogs.objects.summary.ArtistSummary;
import library.com.github.programmerr47.discogs.objects.summary.Community;
import library.com.github.programmerr47.discogs.objects.summary.Format;
import library.com.github.programmerr47.discogs.objects.summary.Identifier;
import library.com.github.programmerr47.discogs.objects.summary.Image;
import library.com.github.programmerr47.discogs.objects.summary.LabelSummary;
import library.com.github.programmerr47.discogs.objects.summary.Recording;
import library.com.github.programmerr47.discogs.objects.summary.Video;

import library.org.json.JSONObject;

import java.util.List;

/**
 * Class for representing Discogs release from their database.
 *
 * @author Michael Spitsin
 * @since 2014-07-27
 */
@SuppressWarnings("unused")
public class Release {
    public static final String ID_TAG = "id";
    public static final String TITLE_TAG = "title";
    public static final String RESOURCE_URL_TAG = "resource_url";
    public static final String URI_TAG = "uri";
    public static final String STATUS_TAG = "status";
    public static final String DATA_QUALITY_TAG = "data_quality";
    public static final String MASTER_ID_TAG = "master_id";
    public static final String MASTER_URL_TAG = "master_url";
    public static final String COUNTRY_TAG = "country";
    public static final String YEAR_TAG = "year";
    public static final String RELEASED_TAG = "released";
    public static final String RELEASED_FORMATTED_TAG = "released_formatted";
    public static final String NOTES_TAG = "notes";
    public static final String STYLES_TAG = "styles";
    public static final String GENRES_TAG = "genres";
    public static final String ESTIMATED_WEIGHT_TAG = "estimated_weight";
    public static final String FORMAT_QUANTITY_TAG = "format_quantity";
    public static final String COMMUNITY_TAG = "community";
    public static final String LABELS_TAG = "labels";
    public static final String COMPANIES_TAG = "companies";
    public static final String EXTRA_ARTISTS_TAG = "extraartists";
    public static final String VIDEOS_TAG = "videos";
    public static final String ARTISTS_TAG = "artists";
    public static final String FORMATS_TAG = "formats";
    public static final String IMAGES_TAG = "images";
    public static final String IDENTIFIERS_TAG = "identifiers";
    public static final String TRACK_LIST_TAG = "tracklist";

    private String id;
    private String title;
    private String resourceUrl;
    private String uri;
    private String status;
    private String dataQuality;
    private String masterId;
    private String masterUrl;
    private String country;
    private int year;
    private String released;
    private String releasedFormatted;
    private String notes;
    private int estimatedWeight;
    private int formatQuantity;
    private List<String> styles;
    private List<String> genres;
    private Community community;
    private List<LabelSummary> labels;
    private List<LabelSummary> companies;
    private List<ArtistSummary> extraArtists;
    private List<ArtistSummary> artists;
    private List<Video> videos;
    private List<Format> formats;
    private List<Image> images;
    private List<Identifier> identifiers;
    private List<Recording> trackList;
    
    private Release(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.resourceUrl = builder.resourceUrl;
        this.uri = builder.uri;
        this.status = builder.status;
        this.dataQuality = builder.dataQuality;
        this.masterId = builder.masterId;
        this.masterUrl = builder.masterUrl;
        this.country = builder.country;
        this.year = builder.year;
        this.released = builder.released;
        this.releasedFormatted = builder.releasedFormatted;
        this.notes = builder.notes;
        this.estimatedWeight = builder.estimatedWeight;
        this.formatQuantity = builder.formatQuantity;
        this.styles = builder.styles;
        this.genres = builder.genres;
        this.community = builder.community;
        this.labels = builder.labels;
        this.companies = builder.companies;
        this.extraArtists = builder.extraArtists;
        this.artists = builder.artists;
        this.videos = builder.videos;
        this.formats = builder.formats;
        this.images = builder.images;
        this.identifiers = builder.identifiers;
        this.trackList = builder.trackList;
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

    public String getUri() {
        return uri;
    }

    public String getStatus() {
        return status;
    }

    public String getDataQuality() {
        return dataQuality;
    }

    public String getMasterId() {
        return masterId;
    }

    public String getMasterUrl() {
        return masterUrl;
    }

    public String getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    public String getReleased() {
        return released;
    }

    public String getReleasedFormatted() {
        return releasedFormatted;
    }

    public String getNotes() {
        return notes;
    }

    public int getEstimatedWeight() {
        return estimatedWeight;
    }

    public int getFormatQuantity() {
        return formatQuantity;
    }

    public List<String> getStyles() {
        return styles;
    }

    public List<String> getGenres() {
        return genres;
    }

    public Community getCommunity() {
        return community;
    }

    public List<LabelSummary> getLabels() {
        return labels;
    }

    public List<LabelSummary> getCompanies() {
        return companies;
    }

    public List<ArtistSummary> getExtraArtists() {
        return extraArtists;
    }

    public List<ArtistSummary> getArtists() {
        return artists;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public List<Format> getFormats() {
        return formats;
    }

    public List<Image> getImages() {
        return images;
    }

    public List<Identifier> getIdentifiers() {
        return identifiers;
    }

    public List<Recording> getTrackList() {
        return trackList;
    }

    public static class Builder {
        private String id;
        private String title;
        private String resourceUrl;
        private String uri;
        private String status;
        private String dataQuality;
        private String masterId;
        private String masterUrl;
        private String country;
        private int year;
        private String released;
        private String releasedFormatted;
        private String notes;
        private int estimatedWeight;
        private int formatQuantity;
        private List<String> styles;
        private List<String> genres;
        private Community community;
        private List<LabelSummary> labels;
        private List<LabelSummary> companies;
        private List<ArtistSummary> extraArtists;
        private List<ArtistSummary> artists;
        private List<Video> videos;
        private List<Format> formats;
        private List<Image> images;
        private List<Identifier> identifiers;
        private List<Recording> trackList;

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

        public Builder setUri(String uri) {
            this.uri = uri;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setDataQuality(String dataQuality) {
            this.dataQuality = dataQuality;
            return this;
        }

        public Builder setMasterId(String masterId) {
            this.masterId = masterId;
            return this;
        }

        public Builder setMasterUrl(String masterUrl) {
            this.masterUrl = masterUrl;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Builder setReleased(String released) {
            this.released = released;
            return this;
        }

        public Builder setReleasedFormatted(String releasedFormatted) {
            this.releasedFormatted = releasedFormatted;
            return this;
        }

        public Builder setNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public Builder setEstimatedWeight(int estimatedWeight) {
            this.estimatedWeight = estimatedWeight;
            return this;
        }

        public Builder setFormatQuantity(int formatQuantity) {
            this.formatQuantity = formatQuantity;
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

        public Builder setCommunity(Community community) {
            this.community = community;
            return this;
        }

        public Builder setLabels(List<LabelSummary> labels) {
            this.labels = labels;
            return this;
        }

        public Builder setCompanies(List<LabelSummary> companies) {
            this.companies = companies;
            return this;
        }

        public Builder setExtraArtists(List<ArtistSummary> extraArtists) {
            this.extraArtists = extraArtists;
            return this;
        }

        public Builder setArtists(List<ArtistSummary> artists) {
            this.artists = artists;
            return this;
        }

        public Builder setVideos(List<Video> videos) {
            this.videos = videos;
            return this;
        }

        public Builder setFormats(List<Format> formats) {
            this.formats = formats;
            return this;
        }

        public Builder setImages(List<Image> images) {
            this.images = images;
            return this;
        }

        public Builder setIdentifiers(List<Identifier> identifiers) {
            this.identifiers = identifiers;
            return this;
        }

        public Builder setTrackList(List<Recording> trackList) {
            this.trackList = trackList;
            return this;
        }

        public Release build() {
            return new Release(this);
        }
    }

    /**
     * Creates {@link Release} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of release or null, if json is null
     */
    public static Release getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setId(jsonObject.optString(ID_TAG, null))
                    .setTitle(jsonObject.optString(TITLE_TAG, null))
                    .setResourceUrl(jsonObject.optString(RESOURCE_URL_TAG, null))
                    .setUri(jsonObject.optString(URI_TAG, null))
                    .setStatus(jsonObject.optString(STATUS_TAG, null))
                    .setDataQuality(jsonObject.optString(DATA_QUALITY_TAG, null))
                    .setMasterId(jsonObject.optString(MASTER_ID_TAG, null))
                    .setMasterUrl(jsonObject.optString(MASTER_URL_TAG, null))
                    .setCountry(jsonObject.optString(COUNTRY_TAG, null))
                    .setReleased(jsonObject.optString(RELEASED_TAG, null))
                    .setReleasedFormatted(jsonObject.optString(RELEASED_FORMATTED_TAG, null))
                    .setNotes(jsonObject.optString(NOTES_TAG, null))
                    .setYear(jsonObject.optInt(YEAR_TAG, Constants.NO_ID))
                    .setEstimatedWeight(jsonObject.optInt(ESTIMATED_WEIGHT_TAG, Constants.NO_ID))
                    .setFormatQuantity(jsonObject.optInt(FORMAT_QUANTITY_TAG, Constants.NO_ID))
                    .setStyles(JSONUtil.getStringList(jsonObject.optJSONArray(STYLES_TAG)))
                    .setGenres(JSONUtil.getStringList(jsonObject.optJSONArray(GENRES_TAG)))
                    .setCommunity(Community.getFromJSONObject(jsonObject.optJSONObject(COMMUNITY_TAG)))
                    .setLabels(LabelSummary.getFromJSONArray(jsonObject.optJSONArray(LABELS_TAG)))
                    .setCompanies(LabelSummary.getFromJSONArray(jsonObject.optJSONArray(COMPANIES_TAG)))
                    .setExtraArtists(ArtistSummary.getFromJSONArray(jsonObject.optJSONArray(EXTRA_ARTISTS_TAG)))
                    .setArtists(ArtistSummary.getFromJSONArray(jsonObject.optJSONArray(ARTISTS_TAG)))
                    .setVideos(Video.getFromJSONArray(jsonObject.optJSONArray(VIDEOS_TAG)))
                    .setFormats(Format.getFromJSONArray(jsonObject.optJSONArray(FORMATS_TAG)))
                    .setImages(Image.getFromJSONArray(jsonObject.optJSONArray(IMAGES_TAG)))
                    .setIdentifiers(Identifier.getFromJSONArray(jsonObject.optJSONArray(IDENTIFIERS_TAG)))
                    .setTrackList(Recording.getFromJSONArray(jsonObject.optJSONArray(TRACK_LIST_TAG)))
                    .build();
        }
    }
}
