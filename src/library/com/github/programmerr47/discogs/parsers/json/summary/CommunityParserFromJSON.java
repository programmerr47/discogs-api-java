package library.com.github.programmerr47.discogs.parsers.json.summary;

import library.Constants;
import library.com.github.programmerr47.discogs.parsers.json.ParserFromJSON;
import library.com.github.programmerr47.discogs.responseobjects.summary.Community;
import library.com.github.programmerr47.discogs.responseobjects.summary.UserSummary;
import library.org.json.JSONObject;

/**
 * Parser from JSON to {@link Community}
 *
 * @author Michael Spitsin
 * @since 2014-09-22
 */
@SuppressWarnings("unused")
//TODO Finish when change parsing UserSummary
public class CommunityParserFromJSON extends ParserFromJSON<Community> {
    public static final String HAVE_TAG = "have";
    public static final String WANT_TAG = "want";
    public static final String RATING_TAG = "rating";
    public static final String SUBMITTER_TAG = "submitter";
    public static final String CONTRIBUTORS_TAG = "contributors";

    @Override
    protected Community parseFromJSON(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            RatingParserFromJSON ratingParser = new RatingParserFromJSON();

            return new Community.Builder()
                    .setHave(jsonObject.optInt(HAVE_TAG, Constants.NO_ID))
                    .setWant(jsonObject.optInt(WANT_TAG, Constants.NO_ID))
                    .setRating(ratingParser.parseFromJSON(jsonObject.optJSONObject(RATING_TAG)))
                    .setSubmitter(UserSummary.getFromJSONObject(jsonObject.optJSONObject(SUBMITTER_TAG)))
                    .setContributors(UserSummary.getFromJSONArray(jsonObject.optJSONArray(CONTRIBUTORS_TAG)))
                    .build();
        }
    }
}
