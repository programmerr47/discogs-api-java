package library.com.github.programmerr47.discogs.responseobjects.summary;

/**
 * Class for representing Discogs search result header.
 *
 * @author Michael Spitsin
 * @since 2014-07-27
 */
@SuppressWarnings("unused")
public class Pagination {
    private int perPageItemCount;
    private int pageCount;
    private int itemCount;
    private int currentPage;
    private PaginationUrls urls;
    
    private Pagination(Builder builder) {
        this.perPageItemCount = builder.perPageItemCount;
        this.pageCount = builder.pageCount;
        this.itemCount = builder.itemCount;
        this.currentPage = builder.currentPage;
        this.urls = builder.urls;
    }

    public int getPerPageItemCount() {
        return perPageItemCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getItemCount() {
        return itemCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public PaginationUrls getUrls() {
        return urls;
    }

    public static class Builder {
        private int perPageItemCount;
        private int pageCount;
        private int itemCount;
        private int currentPage;
        private PaginationUrls urls;

        public Builder setPerPageItemCount(int perPageItemCount) {
            this.perPageItemCount = perPageItemCount;
            return this;
        }

        public Builder setPageCount(int pageCount) {
            this.pageCount = pageCount;
            return this;
        }

        public Builder setItemCount(int itemCount) {
            this.itemCount = itemCount;
            return this;
        }

        public Builder setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
            return this;
        }

        public Builder setUrls(PaginationUrls urls) {
            this.urls = urls;
            return this;
        }

        public Pagination build() {
            return new Pagination(this);
        }
    }
}
