package library.com.github.programmerr47.discogs.objects.marketplace;

import library.com.github.programmerr47.discogs.objects.summary.OrderMessage;
import library.com.github.programmerr47.discogs.objects.summary.Pagination;
import library.org.json.JSONObject;

import java.util.List;

/**
 * @author Michael Spitsin
 * @since 2014-09-10
 */
@SuppressWarnings("unused")
public class ListOrderMessages {
    public static final String PAGINATION_TAG = "pagination";
    public static final String MESSAGES_TAG = "messages";

    private Pagination pagination;
    private List<OrderMessage> orderMessages;

    private ListOrderMessages(Builder builder) {
        this.pagination = builder.pagination;
        this.orderMessages = builder.orderMessages;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public List<OrderMessage> getOrderMessages() {
        return orderMessages;
    }

    private static class Builder {
        private Pagination pagination;
        private List<OrderMessage> orderMessages;

        public Builder setPagination(Pagination pagination) {
            this.pagination = pagination;
            return this;
        }

        public Builder setOrderMessages(List<OrderMessage> orderMessages) {
            this.orderMessages = orderMessages;
            return this;
        }

        public ListOrderMessages build() {
            return new ListOrderMessages(this);
        }
    }

    /**
     * Creates {@link ListOrderMessages} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of listOrderMessages or null, if json is null
     */
    public static ListOrderMessages getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setPagination(Pagination.getFromJSONObject(jsonObject.optJSONObject(PAGINATION_TAG)))
                    .setOrderMessages(OrderMessage.getFromJSONArray(jsonObject.optJSONArray(MESSAGES_TAG)))
                    .build();
        }
    }
}
