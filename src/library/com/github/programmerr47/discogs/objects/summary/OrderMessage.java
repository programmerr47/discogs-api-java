package library.com.github.programmerr47.discogs.objects.summary;

import library.org.json.JSONArray;
import library.org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Spitsin
 * @since 2014-09-10
 */
@SuppressWarnings("unused")
public class OrderMessage {
    private static final String FROM_TAG = "from";
    private static final String MESSAGE_TAG = "message";
    private static final String ORDER_TAG = "order";
    private static final String TIMESTAMP_TAG = "timestamp";
    private static final String SUBJECT_TAG = "subject";

    private UserSummary from;
    private String message;
    private OrderSummary order;
    private String timestamp;
    private String subject;

    public OrderMessage(Builder builder) {
        this.from = builder.from;
        this.message = builder.message;
        this.order = builder.order;
        this.timestamp = builder.timestamp;
        this.subject = builder.subject;
    }

    public UserSummary getFrom() {
        return from;
    }

    public String getMessage() {
        return message;
    }

    public OrderSummary getOrder() {
        return order;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getSubject() {
        return subject;
    }

    private static class Builder {
        private UserSummary from;
        private String message;
        private OrderSummary order;
        private String timestamp;
        private String subject;

        public Builder setFrom(UserSummary from) {
            this.from = from;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setOrder(OrderSummary order) {
            this.order = order;
            return this;
        }

        public Builder setTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public OrderMessage build() {
            return new OrderMessage(this);
        }
    }

    /**
     * Creates {@link OrderMessage} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of orderMessage or null, if json is null
     */
    public static OrderMessage getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setFrom(UserSummary.getFromJSONObject(jsonObject.optJSONObject(FROM_TAG)))
                    .setMessage(jsonObject.optString(MESSAGE_TAG, null))
                    .setOrder(OrderSummary.getFromJSONObject(jsonObject.optJSONObject(ORDER_TAG)))
                    .setSubject(jsonObject.optString(SUBJECT_TAG, null))
                    .setTimestamp(jsonObject.optString(TIMESTAMP_TAG, null))
                    .build();
        }
    }

    /**
     * Creates list of {@link OrderMessage} objects from its JSON Counterpart.
     *
     * @param jsonArray - given JSON array
     * @return new instance of orderMessage or null, if json is null
     */
    public static List<OrderMessage> getFromJSONArray(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        } else {
            List<OrderMessage> resultList = new ArrayList<OrderMessage>();
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
