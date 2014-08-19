package library.com.github.programmerr47.discogs.objects.summary;

import library.Constants;
import library.org.json.JSONArray;
import library.org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for representing Discogs image from their database.
 *
 * @author Michael Spitsin
 * @since 2014-07-25
 */
public class Image {
    public static final String TYPE_TAG = "type";
    public static final String WIDTH_TAG = "width";
    public static final String HEIGHT_TAG = "height";
    public static final String URI_TAG = "uri";
    public static final String URI_150_TAG = "uri150";
    public static final String RESOURCE_URL_TAG = "resource_url";

    public enum TYPE {
        primary,
        secondary
    }

    private TYPE type;
    private int width;
    private int height;
    private String resourceUrl;
    private String uri;
    private String uri150;

    private Image(Builder builder) {
        this.type = builder.type;
        this.width = builder.width;
        this.height = builder.height;
        this.resourceUrl = builder.resourceUrl;
        this.uri = builder.uri;
        this.uri150 = builder.uri150;
    }

    public TYPE getType() {
        return type;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public String getUri() {
        return uri;
    }

    public String getUri150() {
        return uri150;
    }

    public static class Builder {
        private TYPE type;
        private int width;
        private int height;
        private String resourceUrl;
        private String uri;
        private String uri150;

        public Builder setType(TYPE type) {
            this.type = type;
            return this;
        }

        public Builder setWidth(int width) {
            this.width = width;
            return this;
        }

        public Builder setHeight(int height) {
            this.height = height;
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

        public Builder setUri150(String uri150) {
            this.uri150 = uri150;
            return this;
        }

        public Image build() {
            return new Image(this);
        }
    }

    /**
     * Creates {@link Image} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of image or null, if json is null
     */
    public static Image getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setWidth(jsonObject.optInt(WIDTH_TAG, Constants.NO_ID))
                    .setHeight(jsonObject.optInt(HEIGHT_TAG, Constants.NO_ID))
                    .setResourceUrl(jsonObject.optString(RESOURCE_URL_TAG, null))
                    .setType(TYPE.valueOf(jsonObject.optString(TYPE_TAG, null)))
                    .setUri(jsonObject.optString(URI_TAG, null))
                    .setUri150(jsonObject.optString(URI_150_TAG, null))
                    .build();
        }
    }

    /**
     * Creates list of {@link Image} objects from its JSON Counterpart.
     *
     * @param jsonArray - given JSON array
     * @return new instance of image or null, if json is null
     */
    public static List<Image> getFromJSONArray(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        } else {
            List<Image> resultList = new ArrayList<Image>();
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
