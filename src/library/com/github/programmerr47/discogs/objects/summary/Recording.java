package library.com.github.programmerr47.discogs.objects.summary;

import library.org.json.JSONArray;
import library.org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for representing Discogs recording from their database.
 *
 * @author Michael Spitsin
 * @since 2014-07-27
 */
public class Recording {
    public static final String TITLE_TAG = "title";
    public static final String POSITION_TAG = "position";
    public static final String DURATION_TAG = "duration";

    private String title;
    private String position;
    private String duration;

    private Recording(Builder builder) {
        this.title = builder.title;
        this.position = builder.position;
        this.duration = builder.duration;
    }

    public String getTitle() {
        return title;
    }

    public String getPosition() {
        return position;
    }

    public String getDuration() {
        return duration;
    }

    public static class Builder {
        private String title;
        private String position;
        private String duration;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setPosition(String position) {
            this.position = position;
            return this;
        }

        public Builder setDuration(String duration) {
            this.duration = duration;
            return this;
        }

        public Recording build() {
            return new Recording(this);
        }
    }

    /**
     * Creates {@link Recording} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of recording or null, if json is null
     */
    public static Recording getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setTitle(jsonObject.optString(TITLE_TAG, null))
                    .setDuration(jsonObject.optString(DURATION_TAG, null))
                    .setPosition(jsonObject.optString(POSITION_TAG, null))
                    .build();
        }
    }

    /**
     * Creates list of {@link Recording} objects from its JSON Counterpart.
     *
     * @param jsonArray - given JSON array
     * @return new instance of recording or null, if json is null
     */
    public static List<Recording> getFromJSONArray(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        } else {
            List<Recording> resultList = new ArrayList<Recording>();
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
