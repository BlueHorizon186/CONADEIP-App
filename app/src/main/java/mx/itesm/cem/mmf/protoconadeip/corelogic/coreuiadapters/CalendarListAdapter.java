package mx.itesm.cem.mmf.protoconadeip.corelogic.coreuiadapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONArray;

import mx.itesm.cem.mmf.protoconadeip.R;
import mx.itesm.cem.mmf.protoconadeip.corelogic.coreconstants.CalendarData;

/**
 * Created on 13/11/16.
 */

public class CalendarListAdapter extends ArrayAdapter<JSONArray> {

    private final Activity context;
    private final JSONArray[] itemName;

    public CalendarListAdapter(Activity context, JSONArray[] itemName) {
        super(context, R.layout.calendar_listrow_layout, itemName);
        this.context = context;
        this.itemName = itemName;
    }

    public View getView(final int index, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.calendar_listrow_layout, null, true);
        JSONArray next = itemName[index];

        TextView homeTeamView = (TextView) rowView.findViewById(R.id.homeTeamValue);
        TextView visitTeamView = (TextView) rowView.findViewById(R.id.visitTeamValue);
        TextView homeScoreView = (TextView) rowView.findViewById(R.id.homeScoreValue);
        TextView visitScoreView = (TextView) rowView.findViewById(R.id.visitScoreValue);

        TextView gameStatusView = (TextView) rowView.findViewById(R.id.gameStatusValue);
        TextView gameDateView = (TextView) rowView.findViewById(R.id.gameDateValue);
        TextView gameTimeView = (TextView) rowView.findViewById(R.id.gameTimeValue);

        try {
            String gameStatus = "";

            homeTeamView.setText(next.getString(CalendarData.HOME_TEAM.num()));
            visitTeamView.setText(next.getString(CalendarData.VISIT_TEAM.num()));
            homeScoreView.setText(next.getString(CalendarData.HOME_SCORE.num()));
            visitScoreView.setText(next.getString(CalendarData.VISIT_SCORE.num()));

            gameDateView.setText(next.getString(CalendarData.DATE.num()));
            gameTimeView.setText(next.getString(CalendarData.TIME.num()));

            switch (next.getInt(CalendarData.STATUS.num())) {
                case 8:
                    gameStatus = "Programado";
                    break;
                case 6:
                    gameStatus = "Descanso";
                    break;
                case 5:
                    gameStatus = "Terminado";
                    break;
                case 4:
                    gameStatus = "Ultimo Cuarto";
                    break;
                case 3:
                    gameStatus = "Tercer Cuarto";
                    break;
                case 2:
                    gameStatus = "Segundo Cuarto";
                    break;
                case 1:
                    gameStatus = "Primer Cuarto";
                    break;
                default:
                    gameStatus = "Estado Desconocido";
                    break;
            }
            gameStatusView.setText(gameStatus);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowView;
    }
}
