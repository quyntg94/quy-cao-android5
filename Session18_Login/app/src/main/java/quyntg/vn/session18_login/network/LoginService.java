package quyntg.vn.session18_login.network;

import okhttp3.RequestBody;
import quyntg.vn.session18_login.jsonmodels.ResultLogin;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by giaqu on 11/5/2016.
 */
public interface LoginService {
    @POST("/api/login")
    Call<ResultLogin> login(@Body RequestBody body);
}
