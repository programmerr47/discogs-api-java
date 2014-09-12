package library.com.github.programmerr47.discogs.responseobjects.summary;

import library.Constants;
import library.org.json.JSONArray;
import library.org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for representing Discogs video from their database.
 *
 * @author Michael Spitsin
 * @since 2014-07-27
 */
@SuppressWarnings("unused")
public class Video {
    public static final String TITLE_TAG = "title";
    public static final String DURATION_TAG = "duration";
    public static final String EMBED_TAG = "embed";
    public static final String DESCRIPTION_TAG = "description";
    public static final String URI_TAG = "uri";

    private String title;
    private int duration;
    private boolean embed;
    private String description;
    private String uri;

    private Video(Builder builder) {
        this.title = builder.title;
        this.duration = builder.duration;
        this.embed = builder.embed;
        this.description = builder.description;
        this.uri = builder.uri;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isEmbed() {
        return embed;
    }

    public String getDescription() {
        return description;
    }

    public String getUri() {
        return uri;
    }

    public static class Builder {
        private String title;
        private int duration;
        private boolean embed;
        private String description;
        private String uri;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDuration(int duration) {
            this.duration = duration;
            return this;
        }

        public Builder setEmbed(boolean embed) {
            this.embed = embed;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setUri(String uri) {
            this.uri = uri;
            return this;
        }

        public Video build() {
            return new Video(this);
        }
    }

    /**
     * Creates {@link Video} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of video or null, if json is null
     */
    public static Video getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setTitle(jsonObject.optString(TITLE_TAG, null))
                    .setUri(jsonObject.optString(URI_TAG, null))
                    .setDescription(jsonObject.optString(DESCRIPTION_TAG, null))
                    .setDuration(jsonObject.optInt(DURATION_TAG, Constants.NO_ID))
                    .setEmbed(jsonObject.optBoolean(EMBED_TAG))
                    .build();
        }
    }

    /**
     * Creates list of {@link Video} objects from its JSON Counterpart.
     *
     * @param jsonArray - given JSON array
     * @return new instance of video or null, if json is null
     */
    public static List<Video> getFromJSONArray(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        } else {
            List<Video> resultList = new ArrayList<Video>();
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
