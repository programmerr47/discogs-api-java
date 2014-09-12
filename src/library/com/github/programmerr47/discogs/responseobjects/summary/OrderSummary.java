package library.com.github.programmerr47.discogs.responseobjects.summary;

import library.org.json.JSONArray;
import library.org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Spitsin
 * @since 2014-09-09
 */
@SuppressWarnings("unused")
public class OrderSummary {
    private static final String ID_TAG = "id";
    private static final String RESOURCE_URL_TAG = "resource_url";

    private String id;
    private String resourceUrl;

    private OrderSummary(Builder builder) {
        this.id = builder.id;
        this.resourceUrl = builder.resourceUrl;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public String getId() {
        return id;
    }

    private static class Builder {
        private String id;
        private String resourceUrl;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setResourceUrl(String resourceUrl) {
            this.resourceUrl = resourceUrl;
            return this;
        }

        public OrderSummary build() {
            return new OrderSummary(this);
        }
    }

    /**
     * Creates {@link OrderSummary} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of orderSummary or null, if json is null
     */
    public static OrderSummary getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setId(jsonObject.optString(ID_TAG, null))
                    .setResourceUrl(jsonObject.optString(RESOURCE_URL_TAG, null))
                    .build();
        }
    }

    /**
     * Creates list of {@link OrderSummary} objects from its JSON Counterpart.
     *
     * @param jsonArray - given JSON array
     * @return new instance of orderSummary or null, if json is null
     */
    public static List<OrderSummary> getFromJSONArray(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        } else {
            List<OrderSummary> resultList = new ArrayList<OrderSummary>();
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
