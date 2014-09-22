package library.com.github.programmerr47.discogs.parsers.json.summary;

import library.com.github.programmerr47.discogs.parsers.json.ParserFromJSON;
import library.com.github.programmerr47.discogs.responseobjects.summary.Identifier;
import library.org.json.JSONObject;

/**
 * Parser from JSON to {@link Identifier}
 *
 * @author Michael Spitsin
 * @since 2014-09-22
 */
@SuppressWarnings("unused")
public class IdentifierParserFromJSON extends ParserFromJSON<Identifier> {
    public static final String TYPE_TAG = "type";
    public static final String DESCRIPTION_TAG = "description";
    public static final String VALUE_TAG = "value";

    @Override
    protected Identifier parseFromJSON(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Identifier.Builder()
                    .setType(jsonObject.optString(TYPE_TAG, null))
                    .setDescription(jsonObject.optString(DESCRIPTION_TAG, null))
                    .setValue(jsonObject.optString(VALUE_TAG, null))
                    .build();
        }
    }
}
