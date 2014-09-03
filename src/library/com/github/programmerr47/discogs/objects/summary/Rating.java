package library.com.github.programmerr47.discogs.objects.summary;

import library.Constants;
import library.org.json.JSONObject;

/**
 * Class for representing Discogs rating from their database.
 *
 * @author Michael Spitsin
 * @since 2014-07-27
 */
@SuppressWarnings("unused")
public class Rating {
    public static final String COUNT_TAG = "count";
    public static final String AVERAGE_TAG = "average";

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

    /**
     * Creates {@link Rating} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of rating or null, if json is null
     */
    public static Rating getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setAverage(jsonObject.optDouble(AVERAGE_TAG))
                    .setCount(jsonObject.optInt(COUNT_TAG, Constants.NO_ID))
                    .build();
        }
    }
}
