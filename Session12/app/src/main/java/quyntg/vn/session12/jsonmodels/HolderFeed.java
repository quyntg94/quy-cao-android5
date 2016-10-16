package quyntg.vn.session12.jsonmodels;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by giaqu on 10/14/2016.
 */
public class HolderFeed {
    @SerializedName("id")
    private ArrayList<HolderItem> id;
    @SerializedName("title")
    private String title;


    public String getTitle() {
        return title;
    }

    public List<HolderItem> getId(){
        return id;
    }
}
