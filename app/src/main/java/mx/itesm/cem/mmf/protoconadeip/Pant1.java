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

import mx.itesm.cem.mmf.protoconadeip.corelogic.PositionsFetcher;

/**
 * Created by sandWolf on 06/10/2016.
 */
public class Pant1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View screenRootView = inflater.inflate(R.layout.pag1, container, false);
        PositionsFetcher fetcher = new PositionsFetcher();
        String[] values = {"Error al cargar las posiciones actuales."};

        try {
            JSONArray posArr = fetcher.execute(
                    "Mayor", "Independencia").get();
            ArrayList<String> posLst = new ArrayList<>();

            for (int i = 0; i < posArr.length(); i++) {
                JSONArray next = posArr.getJSONArray(i);
                String pos = next.getString(0) + "  " + next.getString(2) + "  "
                        + next.getString(3) + "  " + next.getString(7) + "  "
                        + next.getString(8);
                posLst.add(pos);
            }

            values = posLst.toArray(new String[posLst.size()]);

        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values);

        ListView lv = (ListView) screenRootView.findViewById(R.id.listView1);
        lv.setAdapter(adapter);
        return screenRootView;
    }
}
