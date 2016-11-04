package quyntg.vn.session18_login.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by giaqu on 11/5/2016.
 */
public class ResultLogin {

    @SerializedName("code")
    private String code;

    public String getCode() {
        return code;
    }

    public boolean isSuccessful(){
        return ("1".equals(code));
    }
}
