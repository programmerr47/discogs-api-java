package library.com.github.programmerr47.discogs.parsers.json.summary;

import library.Constants;
import library.com.github.programmerr47.discogs.parsers.json.ParserFromJSON;
import library.com.github.programmerr47.discogs.responseobjects.summary.Image;
import library.org.json.JSONObject;

/**
 * Parser from JSON to {@link Image}
 *
 * @author Michael Spitsin
 * @since 2014-09-22
 */
@SuppressWarnings("unused")
public class ImageParserFromJSON extends ParserFromJSON<Image> {
    public static final String TYPE_TAG = "type";
    public static final String WIDTH_TAG = "width";
    public static final String HEIGHT_TAG = "height";
    public static final String URI_TAG = "uri";
    public static final String URI_150_TAG = "uri150";
    public static final String RESOURCE_URL_TAG = "resource_url";

    @Override
    protected Image parseFromJSON(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Image.Builder()
                    .setWidth(jsonObject.optInt(WIDTH_TAG, Constants.NO_ID))
                    .setHeight(jsonObject.optInt(HEIGHT_TAG, Constants.NO_ID))
                    .setResourceUrl(jsonObject.optString(RESOURCE_URL_TAG, null))
                    .setType(Image.TYPE.valueOf(jsonObject.optString(TYPE_TAG, null)))
                    .setUri(jsonObject.optString(URI_TAG, null))
                    .setUri150(jsonObject.optString(URI_150_TAG, null))
                    .build();
        }
    }
}
