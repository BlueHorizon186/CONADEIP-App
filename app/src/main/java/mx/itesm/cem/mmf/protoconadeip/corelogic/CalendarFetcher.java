package mx.itesm.cem.mmf.protoconadeip.corelogic;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created on 05/11/16.
 */

public class CalendarFetcher extends AsyncTask<Integer, Void, JSONArray> {

    private static JSONReader jsonReader = new JSONReader();

    private JSONArray fetchCalendar(int category) {
        String calendarUrl = "http://app.conadeipfba.org.mx/"
                + "php/getMatches.php?categoriaId=" + category;

        try {
            JSONObject calendarObj = new JSONObject(
                    jsonReader.readJSONFromServer(calendarUrl));
            return calendarObj.optJSONArray("matchesInfo");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected JSONArray doInBackground(Integer... params) {
        int cat = params[0];
        return fetchCalendar(cat);
    }
}
