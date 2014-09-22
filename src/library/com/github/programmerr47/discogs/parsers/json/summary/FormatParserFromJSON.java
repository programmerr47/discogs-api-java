package library.com.github.programmerr47.discogs.parsers.json.summary;

import library.JSONUtil;
import library.com.github.programmerr47.discogs.parsers.json.ParserFromJSON;
import library.com.github.programmerr47.discogs.responseobjects.summary.Format;
import library.org.json.JSONObject;

/**
 * Parser from JSON to {@link Format}
 *
 * @author Michael Spitsin
 * @since 2014-09-22
 */
@SuppressWarnings("unused")
public class FormatParserFromJSON extends ParserFromJSON<Format> {
    public static final String DESCRIPTIONS_TAG = "descriptions";
    public static final String NAME_TAG = "name";
    public static final String QTY_TAG = "qty";

    @Override
    protected Format parseFromJSON(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Format.Builder()
                    .setName(jsonObject.optString(NAME_TAG, null))
                    .setQty(jsonObject.optString(QTY_TAG, null))
                    .setDescriptions(JSONUtil.getStringList(jsonObject.optJSONArray(DESCRIPTIONS_TAG)))
                    .build();
        }
    }
}
