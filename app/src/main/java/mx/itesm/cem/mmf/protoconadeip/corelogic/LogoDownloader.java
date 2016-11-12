package mx.itesm.cem.mmf.protoconadeip.corelogic;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.URL;

/**
 * Created on 11/11/16.
 */

public class LogoDownloader extends AsyncTask<String, Void, Bitmap> {

    private Bitmap getLogoImage(String logoUrl) {
        Bitmap teamLogo = null;

        try {
            InputStream incoming = new URL(logoUrl).openStream();
            teamLogo = BitmapFactory.decodeStream(incoming);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return teamLogo;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        String logoUrl = params[0];
        return getLogoImage(logoUrl);
    }
}
