package mx.itesm.cem.mmf.protoconadeip.corelogic.coreuiadapters;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;
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

    public View getView(final int index, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.positions_listrow_layout, null, true);

        LogoDownloader logodnld = new LogoDownloader();
        Bitmap teamLogoBmp = null;

        ImageView teamLogoView = (ImageView) rowView.findViewById(R.id.teamIcon);
        /*TextView playedGamesView = (TextView) rowView.findViewById(R.id.playedGamesValue);
        TextView wonGamesView = (TextView) rowView.findViewById(R.id.wonGamesValue);
        TextView pointsView = (TextView) rowView.findViewById(R.id.pointsValue);
        TextView percntView = (TextView) rowView.findViewById(R.id.percentageValue);*/

        /*try {
            playedGamesView.setText(next.getString(PositionData.PLAYED_GAMES.num()));
            wonGamesView.setText(next.getString(PositionData.WON_GAMES.num()));
            pointsView.setText(next.getString(PositionData.POINTS.num()));
            percntView.setText(next.getString(PositionData.PERCENTAGE.num()));

            Log.d("\n\nTeam: ", next.getString(PositionData.TEAM_NAME.num()));
            Log.d("\nPlayed: ", next.getString(PositionData.PLAYED_GAMES.num()));
            Log.d("\nWon: ", next.getString(PositionData.WON_GAMES.num()));

        } catch (JSONException e) {
            e.printStackTrace();
        }*/

        try {
            String nextLogoURL = logoUrls.getImageURLs().getString(itemName[index]);
            teamLogoBmp = logodnld.execute(nextLogoURL).get();

        } catch (Exception e) {
            e.printStackTrace();
        }

        teamLogoView.setImageBitmap(teamLogoBmp);
        return rowView;
    }
}
