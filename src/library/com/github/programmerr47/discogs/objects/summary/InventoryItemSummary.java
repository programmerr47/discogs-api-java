package library.com.github.programmerr47.discogs.objects.summary;

import library.com.github.programmerr47.discogs.objects.marketplace.Price;
import library.org.json.JSONArray;
import library.org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for representing Discogs listing with short information from their database.
 *
 * @author Michael Spitsin
 * @since 2014-07-27
 */
@SuppressWarnings("unused")
public class InventoryItemSummary {
    public static final String ID_TAG = "id";
    public static final String PRICE_TAG = "price";
    public static final String RELEASE_TAG = "release";

    private String id;
    private Price price;
    private ReleaseSummary release;

    private InventoryItemSummary(Builder builder) {
        this.id = builder.id;
        this.price = builder.price;
        this.release = builder.release;
    }

    public String getId() {
        return id;
    }

    public Price getPrice() {
        return price;
    }

    public ReleaseSummary getRelease() {
        return release;
    }

    private static class Builder {
        private String id;
        private Price price;
        private ReleaseSummary release;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setPrice(Price price) {
            this.price = price;
            return this;
        }

        public Builder setRelease(ReleaseSummary release) {
            this.release = release;
            return this;
        }

        public InventoryItemSummary build() {
            return new InventoryItemSummary(this);
        }
    }

    /**
     * Creates {@link InventoryItemSummary} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of listing with short info or null, if json is null
     */
    public static InventoryItemSummary getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setId(jsonObject.optString(ID_TAG, null))
                    .setPrice(Price.getFromJSONObject(jsonObject.optJSONObject(PRICE_TAG)))
                    .setRelease(ReleaseSummary.getFromJSONObject(jsonObject.optJSONObject(RELEASE_TAG)))
                    .build();
        }
    }

    /**
     * Creates list of {@link InventoryItemSummary} objects from its JSON Counterpart.
     *
     * @param jsonArray - given JSON array
     * @return new instance of listings with short info or null, if json is null
     */
    public static List<InventoryItemSummary> getFromJSONArray(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        } else {
            List<InventoryItemSummary> resultList = new ArrayList<InventoryItemSummary>();
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
