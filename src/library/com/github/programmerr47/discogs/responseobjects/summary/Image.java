package library.com.github.programmerr47.discogs.responseobjects.summary;

/**
 * Class for representing Discogs image from their database.
 *
 * @author Michael Spitsin
 * @since 2014-07-25
 */
@SuppressWarnings("unused")
public class Image {
    public enum TYPE {
        primary,
        secondary
    }

    private TYPE type;
    private int width;
    private int height;
    private String resourceUrl;
    private String uri;
    private String uri150;

    private Image(Builder builder) {
        this.type = builder.type;
        this.width = builder.width;
        this.height = builder.height;
        this.resourceUrl = builder.resourceUrl;
        this.uri = builder.uri;
        this.uri150 = builder.uri150;
    }

    public TYPE getType() {
        return type;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public String getUri() {
        return uri;
    }

    public String getUri150() {
        return uri150;
    }

    public static class Builder {
        private TYPE type;
        private int width;
        private int height;
        private String resourceUrl;
        private String uri;
        private String uri150;

        public Builder setType(TYPE type) {
            this.type = type;
            return this;
        }

        public Builder setWidth(int width) {
            this.width = width;
            return this;
        }

        public Builder setHeight(int height) {
            this.height = height;
            return this;
        }

        public Builder setResourceUrl(String resourceUrl) {
            this.resourceUrl = resourceUrl;
            return this;
        }

        public Builder setUri(String uri) {
            this.uri = uri;
            return this;
        }

        public Builder setUri150(String uri150) {
            this.uri150 = uri150;
            return this;
        }

        public Image build() {
            return new Image(this);
        }
    }
}
