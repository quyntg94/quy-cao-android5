package quyntg.vn.session11;

import android.app.Application;
import android.util.Log;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import quyntg.vn.session11.Jsonmodels.DBHelper;
import quyntg.vn.session11.Managers.FileManager;
import quyntg.vn.session11.Managers.NetworkManager;
import quyntg.vn.session11.Managers.Preferences;
import quyntg.vn.session11.Models.Quote;

/**
 * Created by giaqu on 10/16/2016.
 */
public class QuoteApplication extends Application {
    private static final String TAG = QuoteApplication.class.toString();

    @Override
    public void onCreate() {
        super.onCreate();

        Preferences.init(this);
        NetworkManager.init(this);
        FileManager.init(this);
        DBHelper.init(this);
        initImageLoader();

        if(NetworkManager.getInstance().isConnectedToInternet()){
            Log.d(TAG, "Connected");
        } else {
            Log.d(TAG, "not Connected");
        }
        Quote quote = new Quote("Hoang", "chu nong trai ");

        DBHelper.getInstance().insert(
                quote
        );
        Log.d(TAG, "Interested");

        for(Quote q : DBHelper.getInstance().selectAllQuotes()){
            Log.d(TAG, q.toString());
        }
        Log.d(TAG, "Random");

        Log.d(TAG, DBHelper.getInstance().selectRandomQuote().toString());

    }



    private void initImageLoader() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
    }
}
