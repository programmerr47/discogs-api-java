package library.com.github.programmerr47.discogs.responseobjects.useridentity;

import library.Constants;
import library.org.json.JSONObject;

/**
 * @author Michael Spitsin
 * @since 2014-09-11
 */
@SuppressWarnings("unused")
public class User {
    private static final String PROFILE_TAG = "profile";
    private static final String WANTLIST_URL_TAG = "wantlist_url";
    private static final String RANK_TAG = "rank";
    private static final String NUM_PENDING_TAG = "num_pending";
    private static final String ID_TAG = "num_for_sale";
    private static final String NUM_FOR_SALE_TAG = "num_for_sale";
    private static final String HOME_PAGE_TAG = "home_page";
    private static final String LOCATION_TAG = "location";
    private static final String COLLECTION_FOLDERS_URL_TAG = "collection_folders_url";
    private static final String USERNAME_TAG = "username";
    private static final String COLLECTION_FIELDS_URL_TAG = "collection_fields_url";
    private static final String RELEASES_CONTRIBUTED_TAG = "releases_contributed";
    private static final String REGISTERED_TAG = "registered";
    private static final String RATING_AVG_TAG = "rating_avg";
    private static final String NUM_COLLECTION_TAG = "num_collection";
    private static final String RELEASES_RATED_TAG = "releases_rated";
    private static final String NUM_LISTS_TAG = "num_lists";
    private static final String NAME_TAG = "name";
    private static final String NUM_WANTLIST_TAG = "num_wantlist";
    private static final String INVENTORY_URL_TAG = "inventory_url";
    private static final String AVATAR_URL_TAG = "avatar_url";
    private static final String URI_TAG = "uri";
    private static final String RESOURCE_URL_TAG = "resource_url";
    private static final String EMAIL_TAG = "email";

    private String profileInfo;
    private String wantlistUrl;
    private int rank;
    private int numPending;
    private String id;
    private int numForSale;
    private String homePageUrl;
    private String locationInfo;
    private String foldersCollectionUrl;
    private String username;
    private String fieldsCollectionUrl;
    private int releasesContributedCount;
    private String registeredDate;
    private double ratingAvg;
    private int numCollection;
    private int ratedReleasesCount;
    private int numLists;
    private String name;
    private int numWantlist;
    private String inventoryUrl;
    private String avatarUrl;
    private String uri;
    private String resourceUrl;
    private String email;

    public User(Builder builder) {
        this.profileInfo = builder.profileInfo;
        this.wantlistUrl = builder.wantlistUrl;
        this.rank = builder.rank;
        this.numPending = builder.numPending;
        this.id = builder.id;
        this.numForSale = builder.numForSale;
        this.homePageUrl = builder.homePageUrl;
        this.locationInfo = builder.locationInfo;
        this.foldersCollectionUrl = builder.foldersCollectionUrl;
        this.username = builder.username;
        this.fieldsCollectionUrl = builder.fieldsCollectionUrl;
        this.releasesContributedCount = builder.releasesContributedCount;
        this.registeredDate = builder.registeredDate;
        this.ratingAvg = builder.ratingAvg;
        this.numCollection = builder.numCollection;
        this.ratedReleasesCount = builder.ratedReleasesCount;
        this.numLists = builder.numLists;
        this.name = builder.name;
        this.numWantlist = builder.numWantlist;
        this.inventoryUrl = builder.inventoryUrl;
        this.avatarUrl = builder.avatarUrl;
        this.uri = builder.uri;
        this.resourceUrl = builder.resourceUrl;
        this.email = builder.email;
    }

    public String getProfileInfo() {
        return profileInfo;
    }

    public String getWantlistUrl() {
        return wantlistUrl;
    }

    public int getRank() {
        return rank;
    }

    public int getNumPending() {
        return numPending;
    }

    public String getId() {
        return id;
    }

    public int getNumForSale() {
        return numForSale;
    }

    public String getHomePageUrl() {
        return homePageUrl;
    }

    public String getLocationInfo() {
        return locationInfo;
    }

    public String getFoldersCollectionUrl() {
        return foldersCollectionUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getFieldsCollectionUrl() {
        return fieldsCollectionUrl;
    }

    public int getReleasesContributedCount() {
        return releasesContributedCount;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public double getRatingAvg() {
        return ratingAvg;
    }

    public int getNumCollection() {
        return numCollection;
    }

    public int getRatedReleasesCount() {
        return ratedReleasesCount;
    }

    public int getNumLists() {
        return numLists;
    }

    public String getName() {
        return name;
    }

    public int getNumWantlist() {
        return numWantlist;
    }

    public String getInventoryUrl() {
        return inventoryUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getUri() {
        return uri;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public String getEmail() {
        return email;
    }

    public static class Builder {

        private String profileInfo;
        private String wantlistUrl;
        private int rank;
        private int numPending;
        private String id;
        private int numForSale;
        private String homePageUrl;
        private String locationInfo;
        private String foldersCollectionUrl;
        private String username;
        private String fieldsCollectionUrl;
        private int releasesContributedCount;
        private String registeredDate;
        private double ratingAvg;
        private int numCollection;
        private int ratedReleasesCount;
        private int numLists;
        private String name;
        private int numWantlist;
        private String inventoryUrl;
        private String avatarUrl;
        private String uri;
        private String resourceUrl;
        private String email;

        public Builder setProfileInfo(String profileInfo) {
            this.profileInfo = profileInfo;
            return this;
        }

        public Builder setWantlistUrl(String wantlistUrl) {
            this.wantlistUrl = wantlistUrl;
            return this;
        }

        public Builder setRank(int rank) {
            this.rank = rank;
            return this;
        }

        public Builder setNumPending(int num_pending) {
            this.numPending = numPending;
            return this;
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setNumForSale(int numForSale) {
            this.numForSale = numForSale;
            return this;
        }

        public Builder setHomePageUrl(String homePageUrl) {
            this.homePageUrl = homePageUrl;
            return this;
        }

        public Builder setLocationInfo(String locationInfo) {
            this.locationInfo = locationInfo;
            return this;
        }

        public Builder setFoldersCollectionUrl(String foldersCollectionUrl) {
            this.foldersCollectionUrl = foldersCollectionUrl;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setFieldsCollectionUrl(String fieldsCollectionUrl) {
            this.fieldsCollectionUrl = fieldsCollectionUrl;
            return this;
        }

        public Builder setReleasesContributedCount(int releasesContributedCount) {
            this.releasesContributedCount = releasesContributedCount;
            return this;
        }

        public Builder setRegisteredDate(String registeredDate) {
            this.registeredDate = registeredDate;
            return this;
        }

        public Builder setRatingAvg(double ratingAvg) {
            this.ratingAvg = ratingAvg;
            return this;
        }

        public Builder setNumCollection(int numCollection) {
            this.numCollection = numCollection;
            return this;
        }

        public Builder setRatedReleasesCount(int ratedReleasesCount) {
            this.ratedReleasesCount = ratedReleasesCount;
            return this;
        }

        public Builder setNumLists(int numLists) {
            this.numLists = numLists;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setNumWantlist(int numWantlist) {
            this.numWantlist = numWantlist;
            return this;
        }

        public Builder setInventoryUrl(String inventoryUrl) {
            this.inventoryUrl = inventoryUrl;
            return this;
        }

        public Builder setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
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

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    /**
     * Creates {@link User} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of user or null, if json is null
     */
    public static User getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setProfileInfo(jsonObject.optString(PROFILE_TAG, null))
                    .setWantlistUrl(jsonObject.optString(WANTLIST_URL_TAG, null))
                    .setRank(jsonObject.optInt(RANK_TAG, Constants.NO_ID))
                    .setNumPending(jsonObject.optInt(NUM_PENDING_TAG, Constants.NO_ID))
                    .setId(jsonObject.optString(ID_TAG, null))
                    .setNumForSale(jsonObject.optInt(NUM_FOR_SALE_TAG, Constants.NO_ID))
                    .setHomePageUrl(jsonObject.optString(HOME_PAGE_TAG, null))
                    .setLocationInfo(jsonObject.optString(LOCATION_TAG, null))
                    .setFoldersCollectionUrl(jsonObject.optString(COLLECTION_FOLDERS_URL_TAG, null))
                    .setUsername(jsonObject.optString(USERNAME_TAG, null))
                    .setFieldsCollectionUrl(jsonObject.optString(COLLECTION_FIELDS_URL_TAG, null))
                    .setReleasesContributedCount(jsonObject.optInt(RELEASES_CONTRIBUTED_TAG, Constants.NO_ID))
                    .setRegisteredDate(jsonObject.optString(REGISTERED_TAG, null))
                    .setRatingAvg(jsonObject.optDouble(RATING_AVG_TAG, Constants.NO_ID))
                    .setNumCollection(jsonObject.optInt(NUM_COLLECTION_TAG, Constants.NO_ID))
                    .setRatedReleasesCount(jsonObject.optInt(RELEASES_RATED_TAG, Constants.NO_ID))
                    .setNumLists(jsonObject.optInt(NUM_LISTS_TAG, Constants.NO_ID))
                    .setName(jsonObject.optString(NAME_TAG, null))
                    .setNumWantlist(jsonObject.optInt(NUM_WANTLIST_TAG, Constants.NO_ID))
                    .setInventoryUrl(jsonObject.optString(INVENTORY_URL_TAG, null))
                    .setAvatarUrl(jsonObject.optString(AVATAR_URL_TAG, null))
                    .setUri(jsonObject.optString(URI_TAG, null))
                    .setResourceUrl(jsonObject.optString(RESOURCE_URL_TAG, null))
                    .build();
        }
    }
}
