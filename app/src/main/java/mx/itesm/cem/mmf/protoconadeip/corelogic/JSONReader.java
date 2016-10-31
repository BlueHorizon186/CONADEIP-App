package mx.itesm.cem.mmf.protoconadeip.corelogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created on 30/10/16.
 */

public class JSONReader {

    private static final int CHARS_READ_AT_ONCE = 1024;

    public String readJSONFromServer(String urlString) throws IOException {
        BufferedReader reader = null;

        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buf = new StringBuffer();

            int read;
            char[] chars = new char[CHARS_READ_AT_ONCE];

            while ((read = reader.read(chars)) != -1) {
                buf.append(chars, 0, read);
            }
            return buf.toString();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (reader != null) reader.close();
        }
        return "Error!";
    }
}
