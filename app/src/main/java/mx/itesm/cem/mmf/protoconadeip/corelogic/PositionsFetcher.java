package mx.itesm.cem.mmf.protoconadeip.corelogic;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created on 30/10/16.
 */

public class PositionsFetcher extends AsyncTask<String, Void, JSONArray> {

    private static JSONReader jsonReader = new JSONReader();

    private JSONArray fetchPositions(String category, String group) {
        String positionsUrl = "http://app.conadeipfba.org.mx/"
                + "php/getTablaPosiciones.php?categoria=" + category
                + "&grupo=" + group;

        try {
            JSONObject positionsObj = new JSONObject(
                    jsonReader.readJSONFromServer(positionsUrl));
            return positionsObj.optJSONArray("posiciones");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected JSONArray doInBackground(String... params) {
        String cat = params[0];
        String grp = params[1];
        return fetchPositions(cat, grp);
    }
}
