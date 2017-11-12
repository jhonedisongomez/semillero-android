package com.coapps.semillero.domain.interactor.impl;

import com.coapps.semillero.domain.interactor.LoginInteractor;
import com.coapps.semillero.domain.model.User;
import com.coapps.semillero.repository.LoginRepository;
import com.coapps.semillero.repository.impl.LoginRest;
import com.coapps.semillero.utilities.ThreadExecutor;

import java.io.IOException;

import javax.security.auth.callback.Callback;

/**
 * Created by jhon on 11/11/2017.
 */

public class LoginInteractorImpl implements LoginInteractor {

    private LoginRest loginRest;
    private String response= "";

    @Override
    public String syncLogin(final User puser, final Callback callback) {
        loginRest = new LoginRest();

        new ThreadExecutor(new ThreadExecutor.Executor(){

            @Override
            public Object execute() {
                try {
                    response =loginRest.login(puser);
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
}
