package mx.itesm.cem.mmf.protoconadeip.corelogic.coreuiadapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import org.json.JSONArray;

import mx.itesm.cem.mmf.protoconadeip.R;

/**
 * Created on 13/11/16.
 */

public class CalendarListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemName;

    public CalendarListAdapter(Activity context, String[] itemName) {
        super(context, R.layout.calendar_listrow_layout, itemName);
        this.context = context;
        this.itemName = itemName;
    }

    public View getView(final int index, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.calendar_listrow_layout, null, true);
        return rowView;
    }
}
