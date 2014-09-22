package library.com.github.programmerr47.discogs.responseobjects.summary;

import java.util.List;

/**
 * @author Michael Spitsin
 * @since 2014-07-27
 */
@SuppressWarnings("unused")
public class Format {
    private List<String> descriptions;
    private String name;
    private String qty;

    private Format(Builder builder) {
        this.descriptions = builder.descriptions;
        this.name = builder.name;
        this.qty = builder.qty;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public String getName() {
        return name;
    }

    public String getQty() {
        return qty;
    }

    public static class Builder {
        private List<String> descriptions;
        private String name;
        private String qty;

        public Builder setDescriptions(List<String> descriptions) {
            this.descriptions = descriptions;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setQty(String qty) {
            this.qty = qty;
            return this;
        }

        public Format build() {
            return new Format(this);
        }
    }
}
