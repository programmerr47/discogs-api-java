package library.com.github.programmerr47.discogs.responseobjects.summary;

/**
 * Class for representing Discogs video from their database.
 *
 * @author Michael Spitsin
 * @since 2014-07-27
 */
@SuppressWarnings("unused")
public class Video {
    private String title;
    private int duration;
    private boolean embed;
    private String description;
    private String uri;

    private Video(Builder builder) {
        this.title = builder.title;
        this.duration = builder.duration;
        this.embed = builder.embed;
        this.description = builder.description;
        this.uri = builder.uri;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isEmbed() {
        return embed;
    }

    public String getDescription() {
        return description;
    }

    public String getUri() {
        return uri;
    }

    public static class Builder {
        private String title;
        private int duration;
        private boolean embed;
        private String description;
        private String uri;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDuration(int duration) {
            this.duration = duration;
            return this;
        }

        public Builder setEmbed(boolean embed) {
            this.embed = embed;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setUri(String uri) {
            this.uri = uri;
            return this;
        }

        public Video build() {
            return new Video(this);
        }
    }
}
