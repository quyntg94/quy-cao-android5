package quyntg.vn.session12.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by giaqu on 10/14/2016.
 */
public class HolderItem {
    @SerializedName("userId") private String userId;
    @SerializedName("title") private String title;
    @SerializedName("body") private String body;


    public HolderItem(String title, String body, String userId) {
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
