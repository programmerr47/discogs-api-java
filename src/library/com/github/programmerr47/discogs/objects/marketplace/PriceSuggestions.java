package library.com.github.programmerr47.discogs.objects.marketplace;

import library.org.json.JSONObject;

/**
 * @author Michael Spitsin
 * @since 2014-09-10
 */
@SuppressWarnings("unused")
public class PriceSuggestions {
    private static final String VERY_GOOD_TAG = "Very Good (VG)";
    private static final String GOOD_PLUS_TAG = "Good Plus (G+)";
    private static final String NEAR_MINT_TAG = "Near Mint (NM or M-)";
    private static final String GOOD_TAG = "Good (G)";
    private static final String VERY_GOOD_PLUS_TAG = "Very Good Plus (VG+)";
    private static final String MINT_TAG = "Mint (M)";
    private static final String FAIR_TAG = "Fair (F)";
    private static final String POOR_TAG = "Poor (P)";

    private Price veryGoodQualityPrice;
    private Price goodPlusQualityPrice;
    private Price nearMintQualityPrice;
    private Price goodQualityPrice;
    private Price veryGoodPlusQualityPrice;
    private Price mintQualityPrice;
    private Price fairQualityPrice;
    private Price poorQualityPrice;

    public PriceSuggestions(Builder builder) {
        this.veryGoodQualityPrice = builder.veryGoodQualityPrice;
        this.goodPlusQualityPrice = builder.goodPlusQualityPrice;
        this.nearMintQualityPrice = builder.nearMintQualityPrice;
        this.goodQualityPrice = builder.goodQualityPrice;
        this.veryGoodPlusQualityPrice = builder.veryGoodPlusQualityPrice;
        this.mintQualityPrice = builder.mintQualityPrice;
        this.fairQualityPrice = builder.fairQualityPrice;
        this.poorQualityPrice = builder.poorQualityPrice;
    }

    public Price getVeryGoodQualityPrice() {
        return veryGoodQualityPrice;
    }

    public Price getGoodPlusQualityPrice() {
        return goodPlusQualityPrice;
    }

    public Price getNearMintQualityPrice() {
        return nearMintQualityPrice;
    }

    public Price getGoodQualityPrice() {
        return goodQualityPrice;
    }

    public Price getVeryGoodPlusQualityPrice() {
        return veryGoodPlusQualityPrice;
    }

    public Price getMintQualityPrice() {
        return mintQualityPrice;
    }

    public Price getFairQualityPrice() {
        return fairQualityPrice;
    }

    public Price getPoorQualityPrice() {
        return poorQualityPrice;
    }

    private static class Builder {
        private Price veryGoodQualityPrice;
        private Price goodPlusQualityPrice;
        private Price nearMintQualityPrice;
        private Price goodQualityPrice;
        private Price veryGoodPlusQualityPrice;
        private Price mintQualityPrice;
        private Price fairQualityPrice;
        private Price poorQualityPrice;

        public Builder setVeryGoodQualityPrice(Price veryGoodQualityPrice) {
            this.veryGoodQualityPrice = veryGoodQualityPrice;
            return this;
        }

        public Builder setGoodPlusQualityPrice(Price goodPlusQualityPrice) {
            this.goodPlusQualityPrice = goodPlusQualityPrice;
            return this;
        }

        public Builder setNearMintQualityPrice(Price nearMintQualityPrice) {
            this.nearMintQualityPrice = nearMintQualityPrice;
            return this;
        }

        public Builder setGoodQualityPrice(Price goodQualityPrice) {
            this.goodQualityPrice = goodQualityPrice;
            return this;
        }

        public Builder setVeryGoodPlusQualityPrice(Price veryGoodPlusQualityPrice) {
            this.veryGoodPlusQualityPrice = veryGoodPlusQualityPrice;
            return this;
        }

        public Builder setMintQualityPrice(Price mintQualityPrice) {
            this.mintQualityPrice = mintQualityPrice;
            return this;
        }

        public Builder setFairQualityPrice(Price fairQualityPrice) {
            this.fairQualityPrice = fairQualityPrice;
            return this;
        }

        public Builder setPoorQualityPrice(Price poorQualityPrice) {
            this.poorQualityPrice = poorQualityPrice;
            return this;
        }

        public PriceSuggestions build() {
            return new PriceSuggestions(this);
        }
    }

    /**
     * Creates {@link PriceSuggestions} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of price suggestions or null, if json is null
     */
    public static PriceSuggestions getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                   .setFairQualityPrice(Price.getFromJSONObject(jsonObject.optJSONObject(FAIR_TAG)))
                    .setGoodPlusQualityPrice(Price.getFromJSONObject(jsonObject.optJSONObject(GOOD_PLUS_TAG)))
                    .setGoodQualityPrice(Price.getFromJSONObject(jsonObject.optJSONObject(GOOD_TAG)))
                    .setMintQualityPrice(Price.getFromJSONObject(jsonObject.optJSONObject(MINT_TAG)))
                    .setNearMintQualityPrice(Price.getFromJSONObject(jsonObject.optJSONObject(NEAR_MINT_TAG)))
                    .setPoorQualityPrice(Price.getFromJSONObject(jsonObject.optJSONObject(POOR_TAG)))
                    .setVeryGoodPlusQualityPrice(Price.getFromJSONObject(jsonObject.optJSONObject(VERY_GOOD_PLUS_TAG)))
                    .setVeryGoodQualityPrice(Price.getFromJSONObject(jsonObject.optJSONObject(VERY_GOOD_TAG)))
                    .build();
        }
    }
}
