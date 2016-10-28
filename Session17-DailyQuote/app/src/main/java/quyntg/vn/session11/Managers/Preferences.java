package quyntg.vn.session11.Managers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by giaqu on 10/16/2016.
 */
public class Preferences {
    private static final String KEY = "Quote";
    private static final String USER_NAME_KEY = "Username";
    private static final String OFFLINE_IMAGE_COUNT_KEY = "ImageCount";
    private SharedPreferences sharedPreferences;

    public Preferences(Context context){
        //context can be Activity or Application
        sharedPreferences = context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
    }

    public String getUsername(){
        return sharedPreferences.getString(USER_NAME_KEY, null);
    }

    public void putUsername(String username){
        sharedPreferences.edit().putString(USER_NAME_KEY, username).commit();
    }

    public void putImageCount(int imageCount){
        sharedPreferences.edit().putInt(OFFLINE_IMAGE_COUNT_KEY, imageCount).commit();
    }


    public int getImageCount(){
        return sharedPreferences.getInt(OFFLINE_IMAGE_COUNT_KEY, -1);
    }

    private static Preferences instance;
    public static Preferences getInstance(){

        return instance;
    }

    public static void init(Context context){
        instance = new Preferences(context);
    }
}
