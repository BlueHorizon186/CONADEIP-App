package mx.itesm.cem.mmf.protoconadeip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;

import java.util.ArrayList;

import mx.itesm.cem.mmf.protoconadeip.corelogic.CalendarFetcher;
import mx.itesm.cem.mmf.protoconadeip.corelogic.coreconstants.CalendarData;
import mx.itesm.cem.mmf.protoconadeip.corelogic.coreuiadapters.CalendarListAdapter;

/**
 * Created on 06/10/2016.
 */
public class Pant2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View screenRootView = inflater.inflate(R.layout.pag2, container, false);
        //CalendarFetcher fetcher = new CalendarFetcher();
        String[] values = {"Error al cargar el calendario actual."};

        /*try {
            JSONArray calendarArr = fetcher.execute(15).get();
            ArrayList<String> calendarAsLst = new ArrayList<>();

            for (int i = 0; i < calendarArr.length(); i++) {
                JSONArray next = calendarArr.getJSONArray(i);
                String game = next.getString(CalendarData.HOME_TEAM.num()) + " "
                        + next.getString(CalendarData.VISIT_TEAM.num()) + " "
                        + next.getString(CalendarData.DATE.num()) + " "
                        + next.getInt(CalendarData.HOME_SCORE.num()) + " "
                        + next.getInt(CalendarData.VISIT_SCORE.num());
                calendarAsLst.add(game);
            }

            values = calendarAsLst.toArray(new String[calendarAsLst.size()]);

        } catch (Exception e) {
            e.printStackTrace();
        }*/

        CalendarListAdapter adapter =
                new CalendarListAdapter(getActivity(), values);
        ListView lv = (ListView) screenRootView.findViewById(R.id.calendarListView);
        lv.setAdapter(adapter);
        return screenRootView;
    }
}
