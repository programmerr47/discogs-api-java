package library.com.github.programmerr47.discogs.responseobjects.marketplace;
import library.com.github.programmerr47.discogs.utils.CurrencyType;
import library.org.json.JSONObject;

/**
 * Class for representing Discogs price of inventory item.
 *
 * @author Michael Spitsin
 * @since 2014-08-17
 */
@SuppressWarnings("unused")
public class Price {
    public static final String CURRENCY_TAG = "currency";
    public static final String VALUE_TAG = "value";

    private CurrencyType currency;
    private double value;

    private Price(Builder builder) {
        this.currency = builder.currency;
        this.value = builder.value;
    }

    @SuppressWarnings("unused")
    public CurrencyType getCurrency() {
        return currency;
    }

    @SuppressWarnings("unused")
    public double getValue() {
        return value;
    }

    public static class Builder {
        private CurrencyType currency;
        private double value;

        public Builder setCurrency(CurrencyType currency) {
            this.currency = currency;
            return this;
        }

        public Builder setValue(double value) {
            this.value = value;
            return this;
        }

        public Price build() {
            return new Price(this);
        }
    }

    /**
     * Creates {@link Price} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of price or null, if json is null
     */
    public static Price getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setCurrency(CurrencyType.valueOf(jsonObject.optString(CURRENCY_TAG)))
                    .setValue(jsonObject.optDouble(VALUE_TAG))
                    .build();
        }
    }
}
