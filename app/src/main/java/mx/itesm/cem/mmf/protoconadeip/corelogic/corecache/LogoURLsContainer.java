package mx.itesm.cem.mmf.protoconadeip.corelogic.corecache;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import mx.itesm.cem.mmf.protoconadeip.corelogic.JSONReader;

/**
 * Created on 11/11/16.
 */
public class LogoURLsContainer extends AsyncTask<Void, Void, JSONObject> {

    private static LogoURLsContainer ourInstance = null;
    private static JSONReader jsonReader = new JSONReader();
    private static JSONObject imageURLs;

    private static final String TEAM_IMAGES_URL =
            "http://app.conadeipfba.org.mx/php/getEquiposUrlImagenes.php";

    public static LogoURLsContainer getInstance() {
        if (ourInstance == null) ourInstance = new LogoURLsContainer();
        return ourInstance;
    }

    private LogoURLsContainer() {
        try {
            this.imageURLs = execute().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSONObject getImageURLs() {
        return imageURLs;
    }

    /* ************************************* */
    /* This method is only used for testing. */
    public void printResult() {
        Log.d("\n\nImage URLs: ", imageURLs.toString());
    }
    /* ************************************* */

    @Override
    protected JSONObject doInBackground(Void... nonexistentParams) {
        try {
            JSONObject result = new JSONObject(
                    jsonReader.readJSONFromServer(TEAM_IMAGES_URL));
            return result.getJSONObject("equiposNombres");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
