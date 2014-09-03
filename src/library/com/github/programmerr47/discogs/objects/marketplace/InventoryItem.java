package library.com.github.programmerr47.discogs.objects.marketplace;

import library.com.github.programmerr47.discogs.objects.summary.ReleaseSummary;
import library.com.github.programmerr47.discogs.objects.summary.UserSummary;
import library.com.github.programmerr47.discogs.utils.InventoryItemCondition;
import library.com.github.programmerr47.discogs.utils.InventoryItemSleeveCondition;
import library.com.github.programmerr47.discogs.utils.InventoryStatus;
import library.org.json.JSONArray;
import library.org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for representing Discogs inventory item.
 *
 * @author Michael Spitsin
 * @since 2014-08-17
 */
//TODO add field that only "seller visible"
public class InventoryItem {
    private static final String ID_TAG = "id";
    private static final String STATUS_TAG = "status";
    private static final String PRICE_TAG = "price";
    private static final String ALLOW_OFFERS_TAG = "allow_offers";
    private static final String SLEEVE_CONDITION_TAG = "sleeve_condition";
    private static final String CONDITION_TAG = "condition";
    private static final String POSTED_TAG = "posted";
    private static final String SHIPS_FROM_TAG = "ships_from";
    private static final String URI_TAG = "uri";
    private static final String COMMENTS_TAG = "comments";
    private static final String SELLER_TAG = "seller";
    private static final String RELEASE_TAG = "release";
    private static final String RESOURCE_URL_TAG = "resource_url";
    private static final String AUDIO_TAG = "audio";

    private final String id;
    private final InventoryStatus status;
    private final boolean allowOffers;
    private final InventoryItemSleeveCondition sleeveCondition;
    private final InventoryItemCondition condition;
    private final String posted;
    private final String shipsFrom;
    private final String uri;
    private final String comments;
    private final String resourceUrl;
    private final boolean audio;
    private final Price price;
    private final UserSummary seller;
    private final ReleaseSummary release;

    private InventoryItem(Builder builder) {
        this.id = builder.id;
        this.status = builder.status;
        this.allowOffers = builder.allowOffers;
        this.sleeveCondition = builder.sleeveCondition;
        this.condition = builder.condition;
        this.posted = builder.posted;
        this.shipsFrom = builder.shipsFrom;
        this.comments = builder.comments;
        this.uri = builder.uri;
        this.resourceUrl = builder.resourceUrl;
        this.audio = builder.audio;
        this.price = builder.price;
        this.seller = builder.seller;
        this.release = builder.release;
    }

    @SuppressWarnings("unused")
    public String getId() {
        return id;
    }

    @SuppressWarnings("unused")
    public InventoryStatus getStatus() {
        return status;
    }

    @SuppressWarnings("unused")
    public boolean isAllowOffers() {
        return allowOffers;
    }

    @SuppressWarnings("unused")
    public InventoryItemSleeveCondition getSleeveCondition() {
        return sleeveCondition;
    }

    @SuppressWarnings("unused")
    public InventoryItemCondition getCondition() {
        return condition;
    }

    @SuppressWarnings("unused")
    public String getPosted() {
        return posted;
    }

    @SuppressWarnings("unused")
    public String getShipsFrom() {
        return shipsFrom;
    }

    @SuppressWarnings("unused")
    public String getUri() {
        return uri;
    }

    @SuppressWarnings("unused")
    public String getComments() {
        return comments;
    }

    @SuppressWarnings("unused")
    public String getResourceUrl() {
        return resourceUrl;
    }

    @SuppressWarnings("unused")
    public boolean isAudio() {
        return audio;
    }

    @SuppressWarnings("unused")
    public Price getPrice() {
        return price;
    }

    @SuppressWarnings("unused")
    public UserSummary getSeller() {
        return seller;
    }

    @SuppressWarnings("unused")
    public ReleaseSummary getRelease() {
        return release;
    }

    private static class Builder {
        private String id;
        private InventoryStatus status;
        private boolean allowOffers;
        private InventoryItemSleeveCondition sleeveCondition;
        private InventoryItemCondition condition;
        private String posted;
        private String shipsFrom;
        private String uri;
        private String comments;
        private String resourceUrl;
        private boolean audio;
        private Price price;
        private UserSummary seller;
        private ReleaseSummary release;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setStatus(InventoryStatus status) {
            this.status = status;
            return this;
        }

        public Builder setAllowOffers(boolean allowOffers) {
            this.allowOffers = allowOffers;
            return this;
        }

        public Builder setSleeveCondition(InventoryItemSleeveCondition sleeveCondition) {
            this.sleeveCondition = sleeveCondition;
            return this;
        }

        public Builder setCondition(InventoryItemCondition condition) {
            this.condition = condition;
            return this;
        }

        public Builder setPosted(String posted) {
            this.posted = posted;
            return this;
        }

        public Builder setShipsFrom(String shipsFrom) {
            this.shipsFrom = shipsFrom;
            return this;
        }

        public Builder setUri(String uri) {
            this.uri = uri;
            return this;
        }

        public Builder setComments(String comments) {
            this.comments = comments;
            return this;
        }

        public Builder setResourceUrl(String resourceUrl) {
            this.resourceUrl = resourceUrl;
            return this;
        }

        public Builder setAudio(boolean audio) {
            this.audio = audio;
            return this;
        }

        public Builder setPrice(Price price) {
            this.price = price;
            return this;
        }

        public Builder setSeller(UserSummary seller) {
            this.seller = seller;
            return this;
        }

        public Builder setRelease(ReleaseSummary release) {
            this.release = release;
            return this;
        }

        public InventoryItem build() {
            return new InventoryItem(this);
        }
    }

    /**
     * Creates {@link InventoryItem} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of listing or null, if json is null
     */
    public static InventoryItem getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setId(jsonObject.optString(ID_TAG, null))
                    .setStatus(InventoryStatus.valueOf(jsonObject.optString(STATUS_TAG, "").replaceAll("\\s+","")))
                    .setAllowOffers(jsonObject.optBoolean(ALLOW_OFFERS_TAG, false))
                    .setSleeveCondition(InventoryItemSleeveCondition.getFromString(jsonObject.optString(SLEEVE_CONDITION_TAG, null)))
                    .setCondition(InventoryItemCondition.getFromString(jsonObject.optString(CONDITION_TAG, null)))
                    .setPosted(jsonObject.optString(POSTED_TAG, null))
                    .setShipsFrom(jsonObject.optString(SHIPS_FROM_TAG, null))
                    .setUri(jsonObject.optString(URI_TAG, null))
                    .setComments(jsonObject.optString(COMMENTS_TAG, null))
                    .setResourceUrl(jsonObject.optString(RESOURCE_URL_TAG, null))
                    .setAudio(jsonObject.optBoolean(AUDIO_TAG, false))
                    .setPrice(Price.getFromJSONObject(jsonObject.optJSONObject(PRICE_TAG)))
                    .setSeller(UserSummary.getFromJSONObject(jsonObject.optJSONObject(SELLER_TAG)))
                    .setRelease(ReleaseSummary.getFromJSONObject(jsonObject.optJSONObject(RELEASE_TAG)))
                    .build();
        }
    }

    /**
     * Creates list of {@link InventoryItem} objects from its JSON Counterpart.
     *
     * @param jsonArray - given JSON array
     * @return new instance of listings or null, if json is null
     */
    public static List<InventoryItem> getFromJSONArray(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        } else {
            List<InventoryItem> resultList = new ArrayList<InventoryItem>();
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
