package library.com.github.programmerr47.discogs.objects.useridentity;

import library.org.json.JSONObject;

/**
 * @author Michael Spitsin
 * @since 2014-09-10
 */
@SuppressWarnings("unused")
public class Identity {
    private static final String ID_TAG = "id";
    private static final String USERNAME_TAG = "username";
    private static final String RESOURCE_URL_TAG = "resource_url";
    private static final String CONSUMER_NAME_TAG = "consumer_name";

    private String id;
    private String username;
    private String resourceUrl;
    private String consumerName;

    public Identity(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.resourceUrl = builder.resourceUrl;
        this.consumerName = builder.consumerName;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public String getConsumerName() {
        return consumerName;
    }

    private static class Builder {
        private String id;
        private String username;
        private String resourceUrl;
        private String consumerName;

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

        public Builder setConsumerName(String consumerName) {
            this.consumerName = consumerName;
            return this;
        }

        public Identity build() {
            return new Identity(this);
        }
    }

    /**
     * Creates {@link Identity} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of identity or null, if json is null
     */
    public static Identity getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setId(jsonObject.optString(ID_TAG, null))
                    .setResourceUrl(jsonObject.optString(RESOURCE_URL_TAG, null))
                    .setUsername(jsonObject.optString(USERNAME_TAG, null))
                    .setConsumerName(jsonObject.optString(CONSUMER_NAME_TAG, null))
                    .build();
        }
    }
}
