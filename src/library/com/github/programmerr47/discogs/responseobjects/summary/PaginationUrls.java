package library.com.github.programmerr47.discogs.responseobjects.summary;

/**
 * @author Michael Spitsin
 * @since 2014-07-27
 */
@SuppressWarnings("unused")
public class PaginationUrls {
    private String lastUrl;
    private String firstUrl;
    private String nextUrl;
    private String prevUrl;

    private PaginationUrls(Builder builder) {
        this.lastUrl = builder.lastUrl;
        this.firstUrl = builder.firstUrl;
        this.nextUrl = builder.firstUrl;
        this.prevUrl = builder.prevUrl;
    }

    public String getLastUrl() {
        return lastUrl;
    }

    public String getFirstUrl() {
        return firstUrl;
    }

    public String getNextUrl() {
        return nextUrl;
    }

    public String getPrevUrl() {
        return prevUrl;
    }

    public static class Builder {
        private String lastUrl;
        private String firstUrl;
        private String nextUrl;
        private String prevUrl;

        public Builder setLastUrl(String lastUrl) {
            this.lastUrl = lastUrl;
            return this;
        }

        public Builder setFirstUrl(String firstUrl) {
            this.firstUrl = firstUrl;
            return this;
        }

        public Builder setNextUrl(String nextUrl) {
            this.nextUrl = nextUrl;
            return this;
        }

        public Builder setPrevUrl(String prevUrl) {
            this.prevUrl = prevUrl;
            return this;
        }

        public PaginationUrls build() {
            return new PaginationUrls(this);
        }
    }
}
