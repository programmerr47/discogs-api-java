package library.com.github.programmerr47.discogs.parsers.json.summary;

import library.Constants;
import library.com.github.programmerr47.discogs.parsers.json.ParserFromJSON;
import library.com.github.programmerr47.discogs.responseobjects.summary.Rating;
import library.org.json.JSONObject;

/**
 * Parser from JSON to {@link Rating}
 *
 * @author Michael Spitsin
 * @since 2014-09-22
 */
@SuppressWarnings("unused")
public class RatingParserFromJSON extends ParserFromJSON<Rating> {
    public static final String COUNT_TAG = "count";
    public static final String AVERAGE_TAG = "average";

    @Override
    protected Rating parseFromJSON(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Rating.Builder()
                    .setAverage(jsonObject.optDouble(AVERAGE_TAG))
                    .setCount(jsonObject.optInt(COUNT_TAG, Constants.NO_ID))
                    .build();
        }
    }
}
