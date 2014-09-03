package library.com.github.programmerr47.discogs.objects.summary;

import library.Constants;
import library.org.json.JSONObject;

import java.util.List;

/**
 * Class for representing Discogs community information from their database.
 *
 * @author Michael Spitsin
 * @since 2014-07-27
 */
@SuppressWarnings("unused")
public class Community {
    public static final String HAVE_TAG = "have";
    public static final String WANT_TAG = "want";
    public static final String RATING_TAG = "rating";
    public static final String SUBMITTER_TAG = "submitter";
    public static final String CONTRIBUTORS_TAG = "contributors";

    private int have;
    private int want;
    private Rating rating;
    private UserSummary submitter;
    private List<UserSummary> contributors;

    private Community(Builder builder) {
        this.have = builder.have;
        this.want = builder.want;
        this.rating = builder.rating;
        this.submitter = builder.submitter;
        this.contributors = builder.contributors;
    }

    public int getHave() {
        return have;
    }

    public int getWant() {
        return want;
    }

    public Rating getRating() {
        return rating;
    }

    public UserSummary getSubmitter() {
        return submitter;
    }

    public List<UserSummary> getContributors() {
        return contributors;
    }

    public static class Builder {
        private int have;
        private int want;
        private Rating rating;
        private UserSummary submitter;
        private List<UserSummary> contributors;

        public Builder setHave(int have) {
            this.have = have;
            return this;
        }

        public Builder setWant(int want) {
            this.want = want;
            return this;
        }

        public Builder setRating(Rating rating) {
            this.rating = rating;
            return this;
        }

        public Builder setSubmitter(UserSummary submitter) {
            this.submitter = submitter;
            return this;
        }

        public Builder setContributors(List<UserSummary> contributors) {
            this.contributors = contributors;
            return this;
        }

        public Community build() {
            return new Community(this);
        }
    }

    /**
     * Creates {@link Community} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of community or null, if json is null
     */
    public static Community getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setHave(jsonObject.optInt(HAVE_TAG, Constants.NO_ID))
                    .setWant(jsonObject.optInt(WANT_TAG, Constants.NO_ID))
                    .setRating(Rating.getFromJSONObject(jsonObject.optJSONObject(RATING_TAG)))
                    .setSubmitter(UserSummary.getFromJSONObject(jsonObject.optJSONObject(SUBMITTER_TAG)))
                    .setContributors(UserSummary.getFromJSONArray(jsonObject.optJSONArray(CONTRIBUTORS_TAG)))
                    .build();
        }
    }
}
