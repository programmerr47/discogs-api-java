package library.com.github.programmerr47.discogs.requestparams;

import library.com.github.programmerr47.discogs.utils.SortOrderType;
import library.com.github.programmerr47.discogs.utils.InventorySortType;

/**
 * Class for representing params for getting user inventory.
 * <strong>See:</strong> http://www.discogs.com/developers/#page:marketplace,header:marketplace-inventory-get
 *
 * @author Michael Spitsin
 * @since 2014-08-15
 */
@SuppressWarnings("unused")
public class GetInventoryParams extends PaginationParams {
    private static final String USERNAME_PARAM_NAME = "username";
    private static final String STATUS_PARAM_NAME = "status";
    private static final String SORT_PARAM_NAME = "sort";
    private static final String SORT_ORDER_PARAM_NAME = "sort_order";

    private String username;
    private String status;
    private InventorySortType sort;
    private SortOrderType sortOrder;

    protected GetInventoryParams(Builder builder) {
        super(builder);
        this.username = builder.username;
        this.status = builder.status;
        this.sort = builder.sort;
        this.sortOrder = builder.sortOrder;
    }

    @Override
    public String getQuery() {
        StringBuilder result = new StringBuilder(super.getQuery());

        ParamUtils.addParameterIfNeed(result, USERNAME_PARAM_NAME, username);
        ParamUtils.addParameterIfNeed(result, STATUS_PARAM_NAME, status);
        ParamUtils.addParameterIfNeed(result, SORT_PARAM_NAME, sort);
        ParamUtils.addParameterIfNeed(result, SORT_ORDER_PARAM_NAME, sortOrder);

        return ParamUtils.removeFirstCharacterIfDelimiter(result.toString());
    }

    public static class Builder extends PaginationParams.Builder {
        private String username;
        private String status;
        private InventorySortType sort;
        private SortOrderType sortOrder;

        @SuppressWarnings("unused")
        public Builder setSearchQuery(String username) {
            this.username = username;
            return this;
        }

        @SuppressWarnings("unused")
        public Builder setTitle(String status) {
            this.status = status;
            return this;
        }

        @SuppressWarnings("unused")
        public Builder setType(InventorySortType sort) {
            this.sort = sort;
            return this;
        }

        @SuppressWarnings("unused")
        public Builder setReleaseTitle(SortOrderType sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }

        public GetInventoryParams build() {
            return new GetInventoryParams(this);
        }
    }
}
