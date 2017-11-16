package com.coapps.semillero.domain.interactor.impl;

import com.coapps.semillero.domain.interactor.UserInteractor;
import com.coapps.semillero.domain.model.User;
import com.coapps.semillero.repository.impl.UserRest;
import com.coapps.semillero.utilities.ThreadExecutor;

import java.io.IOException;

/**
 * Created by jhon on 11/11/2017.
 */

public class UserInteractorImpl implements UserInteractor {

    private UserRest userRest = new UserRest();;
    private String response= "";

    @Override
    public String syncLogin(final User puser, final Callback callback) {


        new ThreadExecutor(new ThreadExecutor.Executor(){

            @Override
            public Object execute() {
                try {
                    response =userRest.login(puser);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return response;
            }

            @Override
            public void finish(Object result) {

                if(result instanceof Throwable){
                    callback.error((Throwable) result);
                }else{
                    callback.success(result);
                }
            }
        }).execute();

        return response;
    }


    public String syncUserRegister(final User user, final Callback callback){

        new ThreadExecutor(new ThreadExecutor.Executor() {
            @Override
            public Object execute() {
                try {
                    response = userRest.userRegister(user);
                } catch (IOException e) {
                    e.printStackTrace();
                    response = "error registrando el usuario";
                }

                return response;
            }

            @Override
            public void finish(Object result) {

                if(result instanceof Throwable){
                    callback.error((Throwable) result);
                }else{
                    callback.success(result);
                }

            }

        }).execute();

        return response;
    }
}
