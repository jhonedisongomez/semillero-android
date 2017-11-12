package com.coapps.semillero.repository.impl;


import android.util.Log;

import com.coapps.semillero.domain.model.User;
import com.coapps.semillero.repository.LoginRepository;
import com.coapps.semillero.utilities.RetrofitSingleton;
import com.coapps.semillero.utilities.Constants;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * Created by jhon on 11/11/2017.
 */

public class LoginRest implements LoginRepository {

    public interface LoginService{

        @POST("/rest-auth/login/")
        Call<User> loginUser(@Body User user);

    }


    public String login(User user) throws IOException {

        Retrofit retrofit = RetrofitSingleton.getInstance();
        LoginService loginService = retrofit.create(LoginService.class);
        Call<User> userCall = loginService.loginUser(user);
        Response<User> response = userCall.execute();
        if(response.body() == null){
            return "El email o password no estan correctos";
        }else{
            Constants.token = response.body().getKey();
            return "Bienvendo";
        }



    }
}
