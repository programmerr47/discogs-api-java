package library.com.github.programmerr47.discogs.objects.summary;

import library.org.json.JSONArray;
import library.org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Spitsin
 * @since 2014-07-27
 */
public class Identifier {
    public static final String TYPE_TAG = "type";
    public static final String DESCRIPTION_TAG = "description";
    public static final String VALUE_TAG = "value";

    private String type;
    private String description;
    private String value;

    private Identifier(Builder builder) {
        this.type = builder.type;
        this.description = builder.description;
        this.value = builder.value;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getValue() {
        return value;
    }

    public static class Builder {
        private String type;
        private String description;
        private String value;

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setValue(String value) {
            this.value = value;
            return this;
        }

        public Identifier build() {
            return new Identifier(this);
        }
    }

    /**
     * Creates {@link Identifier} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of identifier or null, if json is null
     */
    public static Identifier getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setType(jsonObject.optString(TYPE_TAG, null))
                    .setDescription(jsonObject.optString(DESCRIPTION_TAG, null))
                    .setValue(jsonObject.optString(VALUE_TAG, null))
                    .build();
        }
    }

    /**
     * Creates list of {@link Identifier} objects from its JSON Counterpart.
     *
     * @param jsonArray - given JSON array
     * @return new instance of identifier or null, if json is null
     */
    public static List<Identifier> getFromJSONArray(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        } else {
            List<Identifier> resultList = new ArrayList<Identifier>();
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
