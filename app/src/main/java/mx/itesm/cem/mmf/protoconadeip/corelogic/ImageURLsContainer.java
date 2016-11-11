package mx.itesm.cem.mmf.protoconadeip.corelogic;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created on 10/11/16.
 */
public class ImageURLsContainer {

    private static ImageURLsContainer ourInstance = new ImageURLsContainer();
    private static JSONReader jsonReader = new JSONReader();

    private final String TEAM_IMAGES_URL =
            "http://app.conadeipfba.org.mx/php/getEquiposUrlImagenes.php";

    private JSONObject imageURLs;

    public static ImageURLsContainer getInstance() {
        return ourInstance;
    }

    private ImageURLsContainer() {
        this.imageURLs = null;
    }

    private void retrieveTeamLogoURLs() {
        try {
            imageURLs = new JSONObject(
                    jsonReader.readJSONFromServer(TEAM_IMAGES_URL));

        } catch (Exception e) {
            e.printStackTrace();

        }
        return ;
    }

    public JSONObject getImageURLs() throws JSONException {
        if (imageURLs == null) retrieveTeamLogoURLs();
        return imageURLs.getJSONObject("equiposNombres");
    }
}
