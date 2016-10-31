package mx.itesm.cem.mmf.protoconadeip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

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
        String[] values = new String[] {"One", "Two", "Three", "Four", "Five"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values);

        ListView lv = (ListView) screenRootView.findViewById(R.id.listView1);
        lv.setAdapter(adapter);
        return screenRootView;
    }
}
