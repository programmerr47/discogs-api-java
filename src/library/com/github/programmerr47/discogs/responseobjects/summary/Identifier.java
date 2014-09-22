package library.com.github.programmerr47.discogs.responseobjects.summary;

/**
 * @author Michael Spitsin
 * @since 2014-07-27
 */
@SuppressWarnings("unused")
public class Identifier {
    private String type;
    private String description;
    private String value;

    private Identifier(Builder builder) {
        this.type = builder.type;
        this.description = builder.description;
        this.value = builder.value;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getValue() {
        return value;
    }

    public static class Builder {
        private String type;
        private String description;
        private String value;

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setValue(String value) {
            this.value = value;
            return this;
        }

        public Identifier build() {
            return new Identifier(this);
        }
    }
 }
