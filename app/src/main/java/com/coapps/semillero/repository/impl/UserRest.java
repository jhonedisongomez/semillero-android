package com.coapps.semillero.repository.impl;


import com.coapps.semillero.domain.model.User;
import com.coapps.semillero.repository.UserRepository;
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

public class UserRest implements UserRepository {

    public interface UserService{

        @POST("/rest-auth/login/")
        Call<User> loginUser(@Body User user);

        @POST("/rest-auth/registration")
        Call<User> registerUser(@Body User user);

    }

    private Retrofit retrofit = RetrofitSingleton.getInstance();
    private UserService userService = retrofit.create(UserService.class);
    private Call<User> userCall = null;
    private Response<User> response = null;

    public String login(User user) throws IOException {

        userCall = userService.loginUser(user);
        response = userCall.execute();
        if(response.body() == null){
            return "El email o password no estan correctos";
        }else{
            Constants.token = response.body().getKey();
            return "Bienvendo";
        }

    }

    public String userRegister (User user) throws IOException {

        userCall = userService.registerUser(user);
        response = userCall.execute();

        if(response.body() == null){
            return "El email existe en la base de datos";
        }else{
            return "Estas registrado ya puedes iniciar sesión";
        }

    }
}
