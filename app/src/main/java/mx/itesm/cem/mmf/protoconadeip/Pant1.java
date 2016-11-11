package mx.itesm.cem.mmf.protoconadeip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;

import java.util.ArrayList;

import mx.itesm.cem.mmf.protoconadeip.corelogic.PositionsFetcher;
import mx.itesm.cem.mmf.protoconadeip.corelogic.coreconstants.PositionData;
import mx.itesm.cem.mmf.protoconadeip.corelogic.coreuiadapters.PositionsListAdapter;

public class Pant1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View screenRootView = inflater.inflate(R.layout.pag1, container, false);
        Integer imageId = R.drawable.flower_ice;

        PositionsFetcher fetcher = new PositionsFetcher();
        String[] values = {"Error al cargar las posiciones actuales."};

        try {
            JSONArray positionsArr = fetcher.execute("Mayor", "Independencia").get();
            ArrayList<String> positionsLst = new ArrayList<>();

            for (int i = 0; i < positionsArr.length(); i++) {
                JSONArray next = positionsArr.getJSONArray(i);
                positionsLst.add(next.getString(PositionData.TEAM_NAME.num()));
                /*String pos = next.getString(PositionData.TEAM_NAME.num()) + "  "
                        + next.getString(PositionData.PLAYED_GAMES.num()) + "  "
                        + next.getString(PositionData.WON_GAMES.num()) + "  "
                        + next.getString(PositionData.POINTS.num()) + "  "
                        + next.getString(PositionData.PERCENTAGE.num());*/
            }

            values = positionsLst.toArray(new String[positionsLst.size()]);

        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                R.layout.positions_listrow_layout,
                R.id.playedGames,
                itemname);

        ListView lv = (ListView) screenRootView.findViewById(R.id.positionsListView);
        lv.setAdapter(adapter);*/

        PositionsListAdapter adapter =
                new PositionsListAdapter(getActivity(), values, imageId);
        ListView lv = (ListView) screenRootView.findViewById(R.id.positionsListView);
        lv.setAdapter(adapter);
        return screenRootView;
    }
}
