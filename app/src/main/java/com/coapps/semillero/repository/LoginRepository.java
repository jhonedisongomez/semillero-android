package com.coapps.semillero.repository;

import com.coapps.semillero.domain.model.User;

import java.io.IOException;

/**
 * Created by jhon on 11/11/2017.
 */

public interface LoginRepository {

    String login(User user) throws IOException;

}
