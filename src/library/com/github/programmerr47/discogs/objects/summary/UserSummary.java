package library.com.github.programmerr47.discogs.objects.summary;

import library.org.json.JSONArray;
import library.org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for representing Discogs user with short information from their database.
 *
 * @author Michael Spitsin
 * @since 2014-07-27
 */
@SuppressWarnings("unused")
public class UserSummary {
    public static final String ID_TAG = "id";
    public static final String USERNAME_TAG = "username";
    public static final String RESOURCE_URL_TAG = "resource_url";

    private String id;
    private String username;
    private String resourceUrl;

    private UserSummary(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.resourceUrl = builder.resourceUrl;
    }

    @SuppressWarnings("unused")
    public String getId() {
        return id;
    }

    @SuppressWarnings("unused")
    public String getUsername() {
        return username;
    }

    @SuppressWarnings("unused")
    public String getResourceUrl() {
        return resourceUrl;
    }

    public static class Builder {
        private String id;
        private String username;
        private String resourceUrl;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setResourceUrl(String resourceUrl) {
            this.resourceUrl = resourceUrl;
            return this;
        }

        public UserSummary build() {
            return new UserSummary(this);
        }
    }

    /**
     * Creates {@link UserSummary} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of userSummary or null, if json is null
     */
    public static UserSummary getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setId(jsonObject.optString(ID_TAG, null))
                    .setResourceUrl(jsonObject.optString(RESOURCE_URL_TAG, null))
                    .setUsername(jsonObject.optString(USERNAME_TAG, null))
                    .build();
        }
    }

    /**
     * Creates list of {@link UserSummary} objects from its JSON Counterpart.
     *
     * @param jsonArray - given JSON array
     * @return new instance of userSummary or null, if json is null
     */
    public static List<UserSummary> getFromJSONArray(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        } else {
            List<UserSummary> resultList = new ArrayList<UserSummary>();
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
