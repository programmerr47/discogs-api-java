package library.com.github.programmerr47.discogs.parsers;

import java.io.InputStream;
import java.util.List;

/**
 * Basic interface for all parsers from some response from DiscoGS to {@code ParserResult} that
 * specified by some realisation. Assumed that discogs api can be changed like earlier, when
 * it abandon XML response format in favor of JSON.
 * <p/>
 * So if it is needed to provide some new parsers (there are new objects or new response format)
 * all parsers must implement this interface.
 *
 * @author Michael Spitsin
 * @since 2014-09-18
 */
public interface ParserFrom<ParseResult> {

    /**
     * Gets object from {@link String} that represented response.
     *
     * @param objectStr response string
     * @return object if it can be even partially created (when part of objectStr is valid and part is invalid) of null, if not
     */
    ParseResult parseObjectFrom(String objectStr);

    /**
     * Gets object from {@link InputStream} that represented response.
     *
     * @param objectIS response input stream
     * @return object if it can be even partially created (when part of objectIS is valid and part is invalid) of null, if not
     */
    ParseResult parseObjectFrom(InputStream objectIS);

    /**
     * Gets {@link List} of objects from {@link String} that represented response with array of result objects.
     *
     * @param arrayStr response string
     * @return list of objects if it can be even partially created (when part of arrayStr is valid and part is invalid) of null, if not
     */
    List<ParseResult> parseListFrom(String arrayStr);

    /**
     * Gets {@link List} of objects from {@link InputStream} that represented response with array of result objects.
     *
     * @param arrayIS input stream
     * @return list of objects if it can be even partially created (when part of arrayIS is valid and part is invalid) of null, if not
     */
    List<ParseResult> parseListFrom(InputStream arrayIS);
}
