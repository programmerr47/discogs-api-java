package library.com.github.programmerr47.discogs.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Michael Spitsin
 * @since 2014-09-18
 */
public class Util {

    /**
     * Converts {@link InputStream} to {@link String}.
     *
     * @param inputStream given input stream
     * @return converted string if conversion is success
     * @throws IOException
     */
    public static String getStringFromInputStream(InputStream inputStream) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder total = new StringBuilder();
        String line;
        while ((line = r.readLine()) != null) {
            total.append(line);
        }

        return total.toString();
    }
}
