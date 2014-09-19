package library.com.github.programmerr47.discogs.parsers.json.summary;

import library.com.github.programmerr47.discogs.parsers.json.ParserFromJSON;
import library.com.github.programmerr47.discogs.responseobjects.summary.Recording;
import library.org.json.JSONObject;

/**
 * Parser from JSON to {@link Recording}.
 *
 * @author Michael Spitsin
 * @since 2014-09-19
 */
@SuppressWarnings("unused")
public class RecordingParserFromJSON extends ParserFromJSON<Recording> {
    private static final String TITLE_TAG = "title";
    private static final String POSITION_TAG = "position";
    private static final String DURATION_TAG = "duration";

    @Override
    protected Recording parseFromJSON(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Recording.Builder()
                    .setTitle(jsonObject.optString(TITLE_TAG, null))
                    .setDuration(jsonObject.optString(DURATION_TAG, null))
                    .setPosition(jsonObject.optString(POSITION_TAG, null))
                    .build();
        }
    }
}
