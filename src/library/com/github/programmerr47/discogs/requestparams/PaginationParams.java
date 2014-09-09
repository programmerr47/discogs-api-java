package library.com.github.programmerr47.discogs.requestparams;

/**
 * Class for representing pagination params in some Discogs requests.
 * <strong>Example:</strong> For search it is necessary to specify
 * current page number or number of result items per page.
 * <br>
 * All requests, that receive collection of data as a response, must use parameters,
 * that extends from {@link PaginationParams}
 *
 * @author Michael Spitsin
 * @since 2014-08-15
 */
@SuppressWarnings("unused")
public class PaginationParams implements RequestParams {
    private static final String CURRENT_PAGE_PARAM_NAME = "page";
    private static final String ITEMS_PER_PAGE_PARAM_NAME = "per_page";

    private Integer currentPage;
    private Integer itemCountPerPage;

    protected PaginationParams(Builder builder) {
        this.currentPage = builder.currentPage;
        this.itemCountPerPage = builder.itemCountPerPage;
    }

    @Override
    public String getQuery() {
        StringBuilder result = new StringBuilder();

        ParamUtils.addParameterIfNeed(result, CURRENT_PAGE_PARAM_NAME, currentPage);
        ParamUtils.addParameterIfNeed(result, ITEMS_PER_PAGE_PARAM_NAME, itemCountPerPage);

        return ParamUtils.removeFirstCharacterIfDelimiter(result.toString());
    }

    @Override
    public String toString() {
        return getQuery();
    }

    public static class Builder {
        private Integer currentPage;
        private Integer itemCountPerPage;

        @SuppressWarnings("unused")
        public Builder setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
            return this;
        }

        @SuppressWarnings("unused")
        public Builder setItemCountPerPage(int itemCountPerPage) {
            this.itemCountPerPage = itemCountPerPage;
            return this;
        }

        public PaginationParams build() {
            return new PaginationParams(this);
        }
    }
}
