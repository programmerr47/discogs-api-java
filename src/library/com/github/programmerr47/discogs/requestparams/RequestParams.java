package library.com.github.programmerr47.discogs.requestparams;

/**
 * Main interface for all classes, that represents optional (and not) parameters of
 * some queries in api requests.
 *
 * @author Michael Spitsin
 * @since 2014-08-15
 */
@SuppressWarnings("unused")
public interface RequestParams {

    /**
     * Calls when building final url for api request.
     *
     * @return query with certain params
     */
    String getQuery();
}
