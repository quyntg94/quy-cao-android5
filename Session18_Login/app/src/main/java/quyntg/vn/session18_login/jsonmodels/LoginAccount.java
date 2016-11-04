package quyntg.vn.session18_login.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by giaqu on 11/5/2016.
 */
public class LoginAccount {
    @SerializedName("username")
    String username;
    @SerializedName("password")
    String password;

    public LoginAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
