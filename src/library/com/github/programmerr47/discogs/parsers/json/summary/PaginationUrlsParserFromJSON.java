package library.com.github.programmerr47.discogs.parsers.json.summary;

import library.com.github.programmerr47.discogs.parsers.json.ParserFromJSON;
import library.com.github.programmerr47.discogs.responseobjects.summary.PaginationUrls;
import library.org.json.JSONObject;

/**
 * Parser from JSON to {@link PaginationUrls}.
 *
 * @author Michael Spitsin
 * @since 2014-09-22
 */
@SuppressWarnings("unused")
public class PaginationUrlsParserFromJSON extends ParserFromJSON<PaginationUrls> {
    public static final String LAST_URL_TAG = "last";
    public static final String FIRST_URL_TAG = "first";
    public static final String PREV_URL_TAG = "prev";
    public static final String NEXT_URL_TAG = "next";

    @Override
    protected PaginationUrls parseFromJSON(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new PaginationUrls.Builder()
                    .setFirstUrl(jsonObject.optString(FIRST_URL_TAG, null))
                    .setLastUrl(jsonObject.optString(LAST_URL_TAG, null))
                    .setNextUrl(jsonObject.optString(NEXT_URL_TAG, null))
                    .setPrevUrl(jsonObject.optString(PREV_URL_TAG, null))
                    .build();
        }
    }
}
