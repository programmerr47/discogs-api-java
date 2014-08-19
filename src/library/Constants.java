package library;

/**
 * Main container for all api-related and other constants using for authenticate via discogs and work with it.
 * All necessary constants (tokens, urls, e.t.c.) must add here.
 *
 * @author Michael Spitsin
 * @since 2014-07-25
 */
public class Constants {
    /**
     * Common constant for all unidentified non-negative integers.
     */
    public static final int NO_ID = -1;

    /**
     * Delimiter between all params in GET requests.
     */
    public static final String REQUEST_PARAMS_DELIMITER = "&";

    /**
     * Symbol that commonly used for request parameters.
     */
    public static final String EQUAL_SYMBOL = "=";

    public static final String SPACE_URL_ENCODING = "%20";

    //----------------------------------------------------------------------
    //-------------------------Response codes-------------------------------
    //----------------------------------------------------------------------
    public static final int RESPONSE_OK = 200;
    public static final int RESPONSE_CONTINUE = 201;
    public static final int RESPONSE_NO_CONTENT = 204;
    public static final int RESPONSE_UNAUTHORIZED = 401;
    public static final int RESPONSE_FORBIDDEN = 403;
    public static final int RESPONSE_NOT_FOUND = 404;
    public static final int RESPONSE_METHOD_NOT_ALLOWED = 405;
    public static final int RESPONSE_UNPROCESSABLE_ENTITY = 422;
    public static final int RESPONSE_TOO_MANY_REQUESTS = 429;
    public static final int RESPONSE_INTERNAL_SERVER_ERROR = 500;
}
