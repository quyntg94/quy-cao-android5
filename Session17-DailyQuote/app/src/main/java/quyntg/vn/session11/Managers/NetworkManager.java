package quyntg.vn.session11.Managers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by giaqu on 10/18/2016.
 */
public class NetworkManager {

    private ConnectivityManager connectivityManager;
    public NetworkManager(Context context){
        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public boolean isConnectedToInternet(){
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()){
            return true;
        } else{
            return false;
        }
    }

    private static NetworkManager instance;
    public static NetworkManager getInstance(){
        return instance;
    }

    public static void init(Context context){
        instance = new NetworkManager(context);
    }
}
