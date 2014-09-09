package library.com.github.programmerr47.discogs.requestparams;

import library.Constants;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Common functions for request parameters.
 *
 * @author Michael Spitsin
 * @since 2014-08-15
 */
class ParamUtils {

    /**
     * Gets given parameters as {@link StringBuilder} and adds to this object:
     * {@code paramName=paramValue.toString()}.
     *
     * @param params particularly built request parameters
     * @param paramName name of new parameter, that must be added
     * @param paramValue value of new parameter, that must be added
     * @return request parameters with new added parameter
     */
    @SuppressWarnings("unused")
    static StringBuilder addParameterIfNeed(StringBuilder params, String paramName, Object paramValue) {
        if (paramValue != null) {
            String correctParamValue;
            try {
                correctParamValue = URLEncoder.encode(paramValue.toString(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                correctParamValue = paramValue.toString().replaceAll(" ", Constants.SPACE_URL_ENCODING);
                e.printStackTrace();
            }

            params.append(Constants.REQUEST_PARAMS_DELIMITER).append(paramName).append(Constants.EQUAL_SYMBOL).append(correctParamValue.replaceAll("\\+", Constants.SPACE_URL_ENCODING));
        }

        return params;
    }

    /**
     * Gets given parameters as {@link String} and adds to this object:
     * {@code paramName=paramValue.toString()}.
     *
     * @param params particularly built request parameters
     * @param paramName name of new parameter, that must be added
     * @param paramValue value of new parameter, that must be added
     * @return request parameters with new added parameter
     */
    @SuppressWarnings("unused")
    static String addParameterIfNeed(String params, String paramName, Object paramValue) {
        if (paramValue != null) {
            String correctParamValue;
            try {
                correctParamValue = URLEncoder.encode(paramValue.toString(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                correctParamValue = paramValue.toString().replaceAll(" ", Constants.SPACE_URL_ENCODING);
                e.printStackTrace();
            }

            params += Constants.REQUEST_PARAMS_DELIMITER + paramName + Constants.EQUAL_SYMBOL + correctParamValue.replaceAll("\\+", Constants.SPACE_URL_ENCODING);
        }

        return params;
    }

    @SuppressWarnings("unused")
    static String removeFirstCharacterIfDelimiter(String source) {
        if (source.startsWith(Constants.REQUEST_PARAMS_DELIMITER)) {
            source = source.substring(Constants.REQUEST_PARAMS_DELIMITER.length());
        }

        return source;
    }
}
