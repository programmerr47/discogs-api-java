package library.com.github.programmerr47.discogs.responseobjects.summary;

/**
 * Class for representing Discogs rating from their database.
 *
 * @author Michael Spitsin
 * @since 2014-07-27
 */
@SuppressWarnings("unused")
public class Rating {
    private int count;
    private double average;

    private Rating(Builder builder) {
        this.count = builder.count;
        this.average = builder.average;
    }

    public int getCount() {
        return count;
    }

    public double getAverage() {
        return average;
    }

    public static class Builder {
        private int count;
        private double average;

        public Builder setCount(int count) {
            this.count = count;
            return this;
        }

        public Builder setAverage(double average) {
            this.average = average;
            return this;
        }

        public Rating build() {
            return new Rating(this);
        }
    }
}
