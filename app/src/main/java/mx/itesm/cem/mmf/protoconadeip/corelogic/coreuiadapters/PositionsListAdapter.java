package mx.itesm.cem.mmf.protoconadeip.corelogic.coreuiadapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import mx.itesm.cem.mmf.protoconadeip.R;

/**
 * Created on 10/11/16.
 */

public class PositionsListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemName;
    private final Integer imgId;

    public PositionsListAdapter(Activity context, String[] itemName, Integer imgId) {
        super(context, R.layout.positions_listrow_layout, itemName);
        this.context = context;
        this.itemName = itemName;
        this.imgId = imgId;
    }

    public View getView(int index, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.positions_listrow_layout, null, true);

        ImageView teamLogoView = (ImageView) rowView.findViewById(R.id.teamIcon);
        TextView playedGamesView = (TextView) rowView.findViewById(R.id.playedGames);

        teamLogoView.setImageResource(imgId);
        playedGamesView.setText(itemName[index]);
        return rowView;
    }
}
