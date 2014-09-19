package library.com.github.programmerr47.discogs.parsers.json.summary;

import library.Constants;
import library.com.github.programmerr47.discogs.parsers.json.ParserFromJSON;
import library.com.github.programmerr47.discogs.responseobjects.summary.Video;
import library.org.json.JSONObject;

/**
 * Parser from JSON to {@link Video}.
 *
 * @author Michael Spitsin
 * @since 2014-09-19
 */
@SuppressWarnings("unused")
public class VideoParserFromJSON extends ParserFromJSON<Video>{
    private static final String TITLE_TAG = "title";
    private static final String DURATION_TAG = "duration";
    private static final String EMBED_TAG = "embed";
    private static final String DESCRIPTION_TAG = "description";
    private static final String URI_TAG = "uri";

    @Override
    protected Video parseFromJSON(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Video.Builder()
                    .setTitle(jsonObject.optString(TITLE_TAG, null))
                    .setUri(jsonObject.optString(URI_TAG, null))
                    .setDescription(jsonObject.optString(DESCRIPTION_TAG, null))
                    .setDuration(jsonObject.optInt(DURATION_TAG, Constants.NO_ID))
                    .setEmbed(jsonObject.optBoolean(EMBED_TAG))
                    .build();
        }
    }
}
