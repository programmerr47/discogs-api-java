package library.com.github.programmerr47.discogs.parsers.json.summary;

import library.Constants;
import library.com.github.programmerr47.discogs.parsers.json.ParserFromJSON;
import library.com.github.programmerr47.discogs.responseobjects.summary.Pagination;
import library.com.github.programmerr47.discogs.responseobjects.summary.PaginationUrls;
import library.org.json.JSONObject;

/**
 * Parser from JSON to {@link Pagination}.
 *
 * @author Michael Spitsin
 * @since 2014-09-22
 */
@SuppressWarnings("unused")
public class PaginationParserFromJSON extends ParserFromJSON<Pagination> {
    public static final String PER_PAGE_TAG = "per_page";
    public static final String PAGE_COUNT_TAG = "pages";
    public static final String CURRENT_PAGE_TAG = "page";
    public static final String ITEM_COUNT_TAG = "items";
    public static final String URLS_TAG = "urls";

    @Override
    protected Pagination parseFromJSON(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            PaginationUrlsParserFromJSON paginationUrlsParser = new PaginationUrlsParserFromJSON();

            return new Pagination.Builder()
                    .setCurrentPage(jsonObject.optInt(CURRENT_PAGE_TAG, Constants.NO_ID))
                    .setItemCount(jsonObject.optInt(ITEM_COUNT_TAG, Constants.NO_ID))
                    .setPageCount(jsonObject.optInt(PAGE_COUNT_TAG, Constants.NO_ID))
                    .setPerPageItemCount(jsonObject.optInt(PER_PAGE_TAG, Constants.NO_ID))
                    .setUrls(paginationUrlsParser.parseFromJSON(jsonObject.optJSONObject(URLS_TAG)))
                    .build();
        }
    }
}
