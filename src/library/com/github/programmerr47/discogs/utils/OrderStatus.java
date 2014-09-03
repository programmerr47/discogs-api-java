package library.com.github.programmerr47.discogs.utils;

import library.org.json.JSONArray;
import library.org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Spitsin
 * @since 2014-09-02
 */
public enum OrderStatus {
    NewOrder(Constants.NEW_ORDER),
    BuyerContacted(Constants.BUYER_CONTACTED),
    InvoiveSent(Constants.INVOIVE_SENT),
    PaymentPending(Constants.PAYMENT_PENDING),
    PaymentReceived(Constants.PAYMENT_RECEIVED),
    Shipped(Constants.SHIPPED),
    CancelledNonPayingBuyer(Constants.CANCELLED_NON_PAYING_BUYER),
    CancelledItemUnavailable(Constants.CANCELLED_ITEM_UNAVAILABLE),
    CancelledPerBuyerRequest(Constants.CANCELLED_PER_BUYER_REQUEST);

    public static OrderStatus getFromString(String strRepresentation) {
        if (strRepresentation == null) {
            return null;
        } else {
            if (strRepresentation.equals(Constants.NEW_ORDER)) {
                return NewOrder;
            } else if (strRepresentation.equals(Constants.BUYER_CONTACTED)) {
                return BuyerContacted;
            } else if (strRepresentation.equals(Constants.INVOIVE_SENT)) {
                return InvoiveSent;
            } else if (strRepresentation.equals(Constants.PAYMENT_PENDING)) {
                return PaymentPending;
            } else if (strRepresentation.equals(Constants.PAYMENT_RECEIVED)) {
                return PaymentReceived;
            } else if (strRepresentation.equals(Constants.SHIPPED)) {
                return Shipped;
            } else if (strRepresentation.equals(Constants.CANCELLED_NON_PAYING_BUYER)) {
                return CancelledNonPayingBuyer;
            } else if (strRepresentation.equals(Constants.CANCELLED_ITEM_UNAVAILABLE)) {
                return CancelledItemUnavailable;
            } else if (strRepresentation.equals(Constants.CANCELLED_PER_BUYER_REQUEST)) {
                return CancelledPerBuyerRequest;
            } else {
                return null;
            }
        }
    }

    public static List<OrderStatus> getFromJSONArray(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        } else {
            List<OrderStatus> statuses = new ArrayList<OrderStatus>();
            for (int i = 0; i < jsonArray.length(); i++) {
                String element = jsonArray.optString(i, null);

                if (element != null) {
                    statuses.add(getFromString(element));
                }
            }

            return statuses;
        }
    }

    private String mRepresentation;

    private OrderStatus(String representation) {
        mRepresentation = representation;
    }

    @Override
    public String toString() {
        return mRepresentation;
    }

    private static class Constants {
        private static final String NEW_ORDER = "New Order";
        private static final String BUYER_CONTACTED = "Buyer Contacted";
        private static final String INVOIVE_SENT= "Invoice Sent";
        private static final String PAYMENT_PENDING = "Payment Pending";
        private static final String PAYMENT_RECEIVED = "Payment Received";
        private static final String SHIPPED = "Shipped";
        private static final String CANCELLED_NON_PAYING_BUYER = "Cancelled (Non-Paying Buyer)";
        private static final String CANCELLED_ITEM_UNAVAILABLE = "Cancelled (Item Unavailable)";
        private static final String CANCELLED_PER_BUYER_REQUEST = "Cancelled (Per Buyer's Request)";
    }
}
