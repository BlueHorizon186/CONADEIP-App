package mx.itesm.cem.mmf.protoconadeip.corelogic.coreuiadapters;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import mx.itesm.cem.mmf.protoconadeip.R;
import mx.itesm.cem.mmf.protoconadeip.corelogic.LogoDownloader;
import mx.itesm.cem.mmf.protoconadeip.corelogic.corecache.LogoURLsContainer;

/**
 * Created on 10/11/16.
 */

public class PositionsListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemName;
    private final LogoURLsContainer logoUrls;

    public PositionsListAdapter(Activity context, String[] itemName) {
        super(context, R.layout.positions_listrow_layout, itemName);
        this.context = context;
        this.itemName = itemName;
        this.logoUrls = LogoURLsContainer.getInstance();
    }

    public View getView(int index, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.positions_listrow_layout, null, true);

        LogoDownloader logodnld = new LogoDownloader();
        Bitmap teamLogoBmp = null;

        ImageView teamLogoView = (ImageView) rowView.findViewById(R.id.teamIcon);
        //TextView playedGamesView = (TextView) rowView.findViewById(R.id.playedGames);

        try {
            String nextLogoURL = logoUrls.getImageURLs().optString(itemName[index], "");
            //Log.d("\nNext URL to Render:", nextLogoURL);
            teamLogoBmp = logodnld.execute(nextLogoURL).get();

        } catch (Exception e) {
            e.printStackTrace();
        }

        teamLogoView.setImageBitmap(teamLogoBmp);
        //playedGamesView.setText(itemName[index]);
        return rowView;
    }
}
