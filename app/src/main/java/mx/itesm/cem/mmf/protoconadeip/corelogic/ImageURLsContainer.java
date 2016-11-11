package mx.itesm.cem.mmf.protoconadeip.corelogic;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

/**
 * Created on 11/11/16.
 */
public class ImageURLsContainer extends AsyncTask<Void, Void, JSONObject> {

    private static ImageURLsContainer ourInstance = null;
    private static JSONReader jsonReader = new JSONReader();
    private static JSONObject imageURLs;

    private static final String TEAM_IMAGES_URL =
            "http://app.conadeipfba.org.mx/php/getEquiposUrlImagenes.php";

    public static ImageURLsContainer getInstance() {
        if (ourInstance == null) ourInstance = new ImageURLsContainer();
        return ourInstance;
    }

    private ImageURLsContainer() {
        try {
            this.imageURLs = execute().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printResult() {
        Log.d("\n\nImage URLs: ", imageURLs.toString());
    }

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
