package library.com.github.programmerr47.discogs.requestparams;

import library.com.github.programmerr47.discogs.utils.OrderStatus;

/**
 * @author Michael Spitsin
 * @since 2014-09-09
 */
@SuppressWarnings("unused")
public class EditOrderParams implements RequestParams {
    private static final String STATUS_PARAM_NAME = "status";
    private static final String SHIPPING_PARAM_NAME = "shipping";

    private OrderStatus status;
    private String shipping;

    protected EditOrderParams(Builder builder) {
        this.status = builder.status;
        this.status = builder.status;
    }

    @Override
    public String getQuery() {
        StringBuilder result = new StringBuilder();

        ParamUtils.addParameterIfNeed(result, STATUS_PARAM_NAME, status);
        ParamUtils.addParameterIfNeed(result, SHIPPING_PARAM_NAME, shipping);

        return ParamUtils.removeFirstCharacterIfDelimiter(result.toString());
    }

    @Override
    public String toString() {
        return getQuery();
    }

    public static class Builder {
        private OrderStatus status;
        private String shipping;

        @SuppressWarnings("unused")
        public Builder setShipping(String shipping) {
            this.shipping = shipping;
            return this;
        }

        @SuppressWarnings("unused")
        public Builder setTitle(OrderStatus status) {
            this.status = status;
            return this;
        }

        public EditOrderParams build() {
            return new EditOrderParams(this);
        }
    }
}
