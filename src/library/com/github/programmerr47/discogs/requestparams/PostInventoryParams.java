package library.com.github.programmerr47.discogs.requestparams;

import library.com.github.programmerr47.discogs.utils.InventoryItemCondition;
import library.com.github.programmerr47.discogs.utils.InventoryItemSleeveCondition;
import library.com.github.programmerr47.discogs.utils.InventoryStatus;

/**
 * Class for representing search params in Discogs search requests.
 * <strong>See:</strong> http://www.discogs.com/developers/#page:marketplace,header:marketplace-listing-post
 *
 * @author Michael Spitsin
 * @since 2014-09-02
 */
@SuppressWarnings("unused")
public class PostInventoryParams implements RequestParams {
    private static final String RELEASE_ID_PARAM_NAME = "release_id";
    private static final String CONDITION_PARAM_NAME = "condition";
    private static final String SLEEVE_CONDITION_PARAM_NAME = "sleeve_condition";
    private static final String PRICE_PARAM_NAME = "price";
    private static final String COMMENTS_PARAM_NAME = "comments";
    private static final String ALLOW_OFFERS_PARAM_NAME = "allow_offers";
    private static final String STATUS_PARAM_NAME = "status";
    private static final String EXTERNAL_ID_PARAM_NAME = "external_id";
    private static final String LOCATION_PARAM_NAME = "location";
    private static final String WEIGHT_PARAM_NAME = "weight";
    private static final String FORMAT_QUANTITY_PARAM_NAME = "format_quantity";

    private String releaseId;
    private InventoryItemCondition condition;
    private InventoryItemSleeveCondition sleeveCondition;
    private String price;
    private String comments;
    private boolean allowOffers;
    private InventoryStatus status;
    private String externalId;
    private String location;
    private String weight;
    private String formatQuantity;

    private PostInventoryParams(Builder builder) {
        this.releaseId = builder.releaseId;
        this.condition = builder.condition;
        this.sleeveCondition = builder.sleeveCondition;
        this.price = builder.price;
        this.comments = builder.comments;
        this.allowOffers = builder.allowOffers;
        this.status = builder.status;
        this.externalId = builder.externalId;
        this.location = builder.location;
        this.weight = builder.weight;
        this.formatQuantity = builder.formatQuantity;
    }

    @Override
    public String getQuery() {
        StringBuilder result = new StringBuilder();

        ParamUtils.addParameterIfNeed(result, RELEASE_ID_PARAM_NAME, releaseId);
        ParamUtils.addParameterIfNeed(result, CONDITION_PARAM_NAME, condition);
        ParamUtils.addParameterIfNeed(result, SLEEVE_CONDITION_PARAM_NAME, sleeveCondition);
        ParamUtils.addParameterIfNeed(result, PRICE_PARAM_NAME, price);
        ParamUtils.addParameterIfNeed(result, COMMENTS_PARAM_NAME, comments);
        ParamUtils.addParameterIfNeed(result, ALLOW_OFFERS_PARAM_NAME, allowOffers);
        ParamUtils.addParameterIfNeed(result, STATUS_PARAM_NAME, status);
        ParamUtils.addParameterIfNeed(result, EXTERNAL_ID_PARAM_NAME, externalId);
        ParamUtils.addParameterIfNeed(result, LOCATION_PARAM_NAME, location);
        ParamUtils.addParameterIfNeed(result, WEIGHT_PARAM_NAME, weight);
        ParamUtils.addParameterIfNeed(result, FORMAT_QUANTITY_PARAM_NAME, formatQuantity);

        return ParamUtils.removeFirstCharacterIfDelimiter(result.toString());
    }

    public static class Builder {
        private String releaseId;
        private InventoryItemCondition condition;
        private InventoryItemSleeveCondition sleeveCondition;
        private String price;
        private String comments;
        private boolean allowOffers;
        private InventoryStatus status = InventoryStatus.ForSale;
        private String externalId;
        private String location;
        private String weight;
        private String formatQuantity;

        /**
         * <strong>Required.</strong> Sets the ID of the release you are posting.
         *
         * @param releaseId the ID of the release you are posting
         * @return builder
         */
        public Builder setReleaseId(String releaseId) {
            this.releaseId = releaseId;
            return this;
        }

        /**
         * <strong>Required.</strong> Sets the condition of the release you are posting.
         *
         * @param condition The condition of the release you are posting. Must be one of {@link InventoryItemCondition}
         * @return builder
         */
        public Builder setCondition(InventoryItemCondition condition) {
            this.condition = condition;
            return this;
        }

        /**
         * <strong>Optional.</strong> Sets the condition of the sleeve of the item you are posting.
         *
         * @param sleeveCondition The condition of the sleeve of the item you are posting. Must be one of {@link InventoryItemSleeveCondition}
         * @return builder
         */
        public Builder setSleeveCondition(InventoryItemSleeveCondition sleeveCondition) {
            this.sleeveCondition = sleeveCondition;
            return this;
        }

        /**
         * <strong>Required.</strong> Sets the price of the item.
         *
         * @param price The price of the item (in the seller’s currency)
         * @return builder
         */
        public Builder setPrice(double price) {
            this.price = price + "";
            return this;
        }

        /**
         * <strong>Optional.</strong> Sets remarks about the item.
         *
         * @param comments Any remarks about the item that will be displayed to buyers
         * @return builder
         */
        public Builder setComments(String comments) {
            this.comments = comments;
            return this;
        }

        /**
         * <strong>Optional.</strong> Sets possibility of making offers on the item. <strong>Defaults to</strong> false.
         *
         * @param allowOffers Whether or not to allow buyers to make offers on the item.
         * @return builder
         */
        public Builder setAllowOffers(boolean allowOffers) {
            this.allowOffers = allowOffers;
            return this;
        }

        /**
         * <strong>Required.</strong> Sets the status of the listing. <strong>Defaults to</strong> “For Sale”.
         *
         * @param status The status of the listing. <strong>Defaults to</strong> “For Sale”.
         *               Options are For Sale (the listing is ready to be shown on the Marketplace)
         *               and Draft (the listing is not ready for public display).
         * @return builder
         */
        public Builder setStatus(InventoryStatus status) {
            this.status = status;
            return this;
        }


        /**
         * <strong>Required.</strong> Sets "private comments" field.
         *
         * @param externalId A freeform field that can be used for the seller’s own reference.
         *                   Information stored here will not be displayed to anyone other than the seller.
         *                   This field is called “Private Comments” on the Discogs website.
         * @return builder
         */
        public Builder setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }


        /**
         * <strong>Required.</strong> Sets item’s physical storage location.
         *
         * @param location A freeform field that is intended to help identify an item’s physical storage location.
         *                 Information stored here will not be displayed to anyone other than the seller.
         *                 This field will be visible on the inventory management page
         *                 and will be available in inventory exports via the website
         * @return builder
         */
        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }


        /**
         * <strong>Required.</strong> Sets the weight, in grams, of this listing.
         *
         * @param weight The weight, in grams, of this listing, for the purpose of calculating shipping
         * @return builder
         */
        public Builder setWeight(double weight) {
            this.weight = weight + "";
            return this;
        }


        /**
         * <strong>Required.</strong> Sets the number of items this listing counts as
         *
         * @param formatQuantity The number of items this listing counts as, for the purpose of calculating shipping. This field is called “Counts As” on the Discogs website
         * @return builder
         */
        public Builder setFormatQuantity(int formatQuantity) {
            this.formatQuantity = formatQuantity + "";
            return this;
        }

        public PostInventoryParams build() {
            if ((releaseId == null) || (condition == null) || (price == null) ||
                    (status == null) || (externalId == null) || (location == null) ||
                    (weight == null) || (formatQuantity == null)) {
                StringBuilder listOfParams = new StringBuilder("");
                boolean first = true;

                if (releaseId == null) {
                    if (listOfParams.length() > 0) {
                        listOfParams.append(", ");
                    }
                    listOfParams.append("releaseId");
                }

                if (condition == null) {
                    if (listOfParams.length() > 0) {
                        listOfParams.append(", ");
                    }
                    listOfParams.append("condition");
                }

                if (price == null) {
                    if (listOfParams.length() > 0) {
                        listOfParams.append(", ");
                    }
                    listOfParams.append("price");
                }

                if (status == null) {
                    if (listOfParams.length() > 0) {
                        listOfParams.append(", ");
                    }
                    listOfParams.append("status");
                }

                if (externalId == null) {
                    if (listOfParams.length() > 0) {
                        listOfParams.append(", ");
                    }
                    listOfParams.append("externalId");
                }

                if (location == null) {
                    if (listOfParams.length() > 0) {
                        listOfParams.append(", ");
                    }
                    listOfParams.append("location");
                }

                if (weight == null) {
                    if (listOfParams.length() > 0) {
                        listOfParams.append(", ");
                    }
                    listOfParams.append("weight");
                }

                if (formatQuantity == null) {
                    if (listOfParams.length() > 0) {
                        listOfParams.append(", ");
                    }
                    listOfParams.append("formatQuantity");
                }

                throw new IllegalStateException("Some required params (" + listOfParams + ") are not defined");
            }

            if (!status.equals(InventoryStatus.ForSale) && !status.equals(InventoryStatus.Draft)) {
                throw new IllegalStateException("Only ForSale or Draft values are allowed as listing status");
            }

            return new PostInventoryParams(this);
        }
    }
}
