package library.com.github.programmerr47.discogs.responseobjects.summary;

/**
 * Class for representing Discogs recording from their database.
 *
 * @author Michael Spitsin
 * @since 2014-07-27
 */
@SuppressWarnings("unused")
public class Recording {
    private String title;
    private String position;
    private String duration;

    private Recording(Builder builder) {
        this.title = builder.title;
        this.position = builder.position;
        this.duration = builder.duration;
    }

    public String getTitle() {
        return title;
    }

    public String getPosition() {
        return position;
    }

    public String getDuration() {
        return duration;
    }

    public static class Builder {
        private String title;
        private String position;
        private String duration;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setPosition(String position) {
            this.position = position;
            return this;
        }

        public Builder setDuration(String duration) {
            this.duration = duration;
            return this;
        }

        public Recording build() {
            return new Recording(this);
        }
    }
}
