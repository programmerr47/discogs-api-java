package library.com.github.programmerr47.discogs.parsers.json;

import library.com.github.programmerr47.discogs.parsers.ParserFrom;
import library.com.github.programmerr47.discogs.utils.Util;
import library.org.json.JSONArray;
import library.org.json.JSONException;
import library.org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Basic implementation of {@link ParserFrom} for JSON type of responses.
 * All specific classes-parser for specific objects should extend this class.
 * In another case, they will have to implement all that already implemented
 * in this class.
 *
 * @author Michael Spitsin
 * @since 2014-09-18
 */
public abstract class ParserFromJSON<ParseResult> implements ParserFrom<ParseResult> {

    @Override
    public final ParseResult parseObjectFrom(InputStream objectIS) {
        String objectStr = null;

        try {
            objectStr = Util.getStringFromInputStream(objectIS);
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }

        return parseObjectFrom(objectStr);
    }

    @Override
    public final List<ParseResult> parseListFrom(String arrayStr) {
        if (arrayStr == null) {
            return null;
        }

        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(arrayStr);
        } catch (JSONException ignored) {
            ignored.printStackTrace();
        }

        if (jsonArray == null) {
            return null;
        } else {
            List<ParseResult> resultList = new ArrayList<ParseResult>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.optJSONObject(i);

                if (jsonObject != null) {
                    resultList.add(parseObjectFrom(jsonObject.toString()));
                }
            }

            return resultList;
        }
    }

    @Override
    public final List<ParseResult> parseListFrom(InputStream arrayIS) {
        String arrayStr = null;

        try {
            arrayStr = Util.getStringFromInputStream(arrayIS);
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }

        return parseListFrom(arrayStr);
    }
}
