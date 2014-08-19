package library.com.github.programmerr47.discogs.objects.summary;

import library.JSONUtil;
import library.org.json.JSONArray;
import library.org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Spitsin
 * @since 2014-07-27
 */
public class Format {
    public static final String DESCRIPTIONS_TAG = "descriptions";
    public static final String NAME_TAG = "name";
    public static final String QTY_TAG = "qty";

    private List<String> descriptions;
    private String name;
    private String qty;

    private Format(Builder builder) {
        this.descriptions = builder.descriptions;
        this.name = builder.name;
        this.qty = builder.qty;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public String getName() {
        return name;
    }

    public String getQty() {
        return qty;
    }

    public static class Builder {
        private List<String> descriptions;
        private String name;
        private String qty;

        public Builder setDescriptions(List<String> descriptions) {
            this.descriptions = descriptions;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setQty(String qty) {
            this.qty = qty;
            return this;
        }

        public Format build() {
            return new Format(this);
        }
    }

    /**
     * Creates {@link Format} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of format or null, if json is null
     */
    public static Format getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setName(jsonObject.optString(NAME_TAG, null))
                    .setQty(jsonObject.optString(QTY_TAG, null))
                    .setDescriptions(JSONUtil.getStringList(jsonObject.optJSONArray(DESCRIPTIONS_TAG)))
                    .build();
        }
    }

    /**
     * Creates list of {@link Format} objects from its JSON Counterpart.
     *
     * @param jsonArray - given JSON array
     * @return new instance of format or null, if json is null
     */
    public static List<Format> getFromJSONArray(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        } else {
            List<Format> resultList = new ArrayList<Format>();
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
