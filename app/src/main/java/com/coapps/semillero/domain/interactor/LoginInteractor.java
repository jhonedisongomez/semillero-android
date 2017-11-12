package com.coapps.semillero.domain.interactor;

import com.coapps.semillero.domain.model.User;


/**
 * Created by jhon on 11/11/2017.
 */

public interface LoginInteractor {

    interface Callback {
        void success(Object result);

        void error(Throwable error);
    }

    String syncLogin(User user, Callback callback);

}
