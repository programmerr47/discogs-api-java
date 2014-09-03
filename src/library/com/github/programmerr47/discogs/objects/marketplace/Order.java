package library.com.github.programmerr47.discogs.objects.marketplace;


import library.com.github.programmerr47.discogs.objects.summary.InventoryItemSummary;
import library.com.github.programmerr47.discogs.objects.summary.UserSummary;
import library.com.github.programmerr47.discogs.utils.OrderStatus;
import library.org.json.JSONArray;
import library.org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for representing Discogs user inventory.
 *
 * @author Michael Spitsin
 * @since 2014-09-02
 */
@SuppressWarnings("unused")
public class Order {
    private static final String ID_TAG = "id";
    private static final String RESOURCE_URL_TAG = "resource_url";
    private static final String MESSAGES_URL_TAG = "messages_url";
    private static final String URI_TAG = "uri";
    private static final String STATUS_TAG = "status";
    private static final String NEXT_STATUS_TAG = "next_status";
    private static final String FEE_TAG = "fee";
    private static final String CREATED_TAG = "created";
    private static final String ITEMS_TAG = "items";
    private static final String SHIPPING_TAG = "shipping";
    private static final String SHIPPING_ADDRESS_TAG = "shipping_address";
    private static final String ADDITIONAL_INSTRUCTIONS_TAG = "additional_instructions";
    private static final String SELLER_TAG = "seller";
    private static final String LAST_ACTIVITY_TAG = "last_activity";
    private static final String BUYER_TAG = "buyer";
    private static final String TOTAL_TAG = "total";

    private String id;
    private String resourceUrl;
    private String messagesUrl;
    private String uri;
    private OrderStatus status;
    private List<OrderStatus> nextStatus;
    private Price fee;
    private String createdDate;
    private List<InventoryItemSummary> orderItems;
    private Price shippingPrice;
    private String shippingAddress;
    private String additionalInstructions;
    private UserSummary sellerInfo;
    private String lastActivityDate;
    private UserSummary buyerInfo;
    private Price totalPrice;

    public Order(Builder builder) {
        this.id = builder.id;
        this.resourceUrl = builder.resourceUrl;
        this.messagesUrl = builder.messagesUrl;
        this.uri = builder.uri;
        this.status = builder.status;
        this.nextStatus = builder.nextStatus;
        this.fee = builder.fee;
        this.createdDate = builder.createdDate;
        this.orderItems = builder.orderItems;
        this.shippingPrice = builder.shippingPrice;
        this.shippingAddress = builder.shippingAddress;
        this.additionalInstructions = builder.additionalInstructions;
        this.sellerInfo = builder.sellerInfo;
        this.lastActivityDate = builder.lastActivityDate;
        this.buyerInfo = builder.buyerInfo;
        this.totalPrice = builder.totalPrice;
    }

    public String getId() {
        return id;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public String getMessagesUrl() {
        return messagesUrl;
    }

    public String getUri() {
        return uri;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<OrderStatus> getNextStatus() {
        return nextStatus;
    }

    public Price getFee() {
        return fee;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public List<InventoryItemSummary> getOrderItems() {
        return orderItems;
    }

    public Price getShippingPrice() {
        return shippingPrice;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public String getAdditionalInstructions() {
        return additionalInstructions;
    }

    public UserSummary getSellerInfo() {
        return sellerInfo;
    }

    public String getLastActivityDate() {
        return lastActivityDate;
    }

    public UserSummary getBuyerInfo() {
        return buyerInfo;
    }

    public Price getTotalPrice() {
        return totalPrice;
    }

    private static class Builder {
        private String id;
        private String resourceUrl;
        private String messagesUrl;
        private String uri;
        private OrderStatus status;
        private List<OrderStatus> nextStatus;
        private Price fee;
        private String createdDate;
        private List<InventoryItemSummary> orderItems;
        private Price shippingPrice;
        private String shippingAddress;
        private String additionalInstructions;
        private UserSummary sellerInfo;
        private String lastActivityDate;
        private UserSummary buyerInfo;
        private Price totalPrice;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setResourceUrl(String resourceUrl) {
            this.resourceUrl = resourceUrl;
            return this;
        }

        public Builder setMessagesUrl(String messagesUrl) {
            this.messagesUrl = messagesUrl;
            return this;
        }

        public Builder setUri(String uri) {
            this.uri = uri;
            return this;
        }

        public Builder setStatus(OrderStatus status) {
            this.status = status;
            return this;
        }

        public Builder setNextStatus(List<OrderStatus> nextStatus) {
            this.nextStatus = nextStatus;
            return this;
        }

        public Builder setFee(Price fee) {
            this.fee = fee;
            return this;
        }

        public Builder setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder setOrderItems(List<InventoryItemSummary> orderItems) {
            this.orderItems = orderItems;
            return this;
        }

        public Builder setShippingPrice(Price shippingPrice) {
            this.shippingPrice = shippingPrice;
            return this;
        }

        public Builder setShippingAddress(String shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        public Builder setAdditionalInstructions(String additionalInstructions) {
            this.additionalInstructions = additionalInstructions;
            return this;
        }

        public Builder setSellerInfo(UserSummary sellerInfo) {
            this.sellerInfo = sellerInfo;
            return this;
        }

        public Builder setLastActivityDate(String lastActivityDate) {
            this.lastActivityDate = lastActivityDate;
            return this;
        }

        public Builder setBuyerInfo(UserSummary buyerInfo) {
            this.buyerInfo = buyerInfo;
            return this;
        }

        public Builder setTotalPrice(Price totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    /**
     * Creates {@link Order} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of order or null, if json is null
     */
    public static Order getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setId(jsonObject.optString(ID_TAG, null))
                    .setResourceUrl(jsonObject.optString(RESOURCE_URL_TAG, null))
                    .setMessagesUrl(jsonObject.optString(MESSAGES_URL_TAG, null))
                    .setCreatedDate(jsonObject.optString(CREATED_TAG, null))
                    .setLastActivityDate(jsonObject.optString(LAST_ACTIVITY_TAG, null))
                    .setUri(jsonObject.optString(URI_TAG, null))
                    .setShippingAddress(jsonObject.optString(SHIPPING_ADDRESS_TAG, null))
                    .setAdditionalInstructions(jsonObject.optString(ADDITIONAL_INSTRUCTIONS_TAG, null))
                    .setStatus(OrderStatus.getFromString(jsonObject.optString(STATUS_TAG, null)))
                    .setNextStatus(OrderStatus.getFromJSONArray(jsonObject.optJSONArray(NEXT_STATUS_TAG)))
                    .setFee(Price.getFromJSONObject(jsonObject.optJSONObject(FEE_TAG)))
                    .setShippingPrice(Price.getFromJSONObject(jsonObject.optJSONObject(SHIPPING_TAG)))
                    .setTotalPrice(Price.getFromJSONObject(jsonObject.optJSONObject(TOTAL_TAG)))
                    .setBuyerInfo(UserSummary.getFromJSONObject(jsonObject.optJSONObject(BUYER_TAG)))
                    .setSellerInfo(UserSummary.getFromJSONObject(jsonObject.optJSONObject(SELLER_TAG)))
                    .setOrderItems(InventoryItemSummary.getFromJSONArray(jsonObject.optJSONArray(ITEMS_TAG)))
                    .build();
        }
    }

    /**
     * Creates list of {@link Order} objects from its JSON Counterpart.
     *
     * @param jsonArray - given JSON array
     * @return new instance of order or null, if json is null
     */
    public static List<Order> getFromJSONArray(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        } else {
            List<Order> resultList = new ArrayList<Order>();
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
