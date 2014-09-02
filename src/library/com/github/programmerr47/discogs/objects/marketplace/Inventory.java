package library.com.github.programmerr47.discogs.objects.marketplace;

import library.com.github.programmerr47.discogs.objects.summary.Pagination;
import library.org.json.JSONObject;

import java.util.List;

/**
 * Class for representing Discogs user inventory.
 *
 * @author Michael Spitsin
 * @since 2014-09-02
 */
@SuppressWarnings("unused")
public class Inventory {
    public static final String PAGINATION_TAG = "pagination";
    public static final String ITEMS_TAG = "listings";

    private Pagination pagination;
    private List<InventoryItem> items;

    private Inventory(Builder builder) {
        this.pagination = builder.pagination;
        this.items = builder.items;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public List<InventoryItem> getItems() {
        return items;
    }

    public static class Builder {
        private Pagination pagination;
        private List<InventoryItem> items;

        public Builder setPagination(Pagination pagination) {
            this.pagination = pagination;
            return this;
        }

        public Builder setItems(List<InventoryItem> items) {
            this.items = items;
            return this;
        }

        public Inventory build() {
            return new Inventory(this);
        }
    }

    /**
     * Creates {@link Inventory} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of Inventory or null, if json is null
     */
    public static Inventory getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setPagination(Pagination.getFromJSONObject(jsonObject.optJSONObject(PAGINATION_TAG)))
                    .setItems(InventoryItem.getFromJSONArray(jsonObject.optJSONArray(ITEMS_TAG)))
                    .build();
        }
    }
}
