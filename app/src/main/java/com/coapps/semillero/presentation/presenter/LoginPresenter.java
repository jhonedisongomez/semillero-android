package com.coapps.semillero.presentation.presenter;

import com.coapps.semillero.domain.interactor.LoginInteractor;
import com.coapps.semillero.domain.interactor.impl.LoginInteractorImpl;
import com.coapps.semillero.domain.model.User;


/**
 * Created by jhon on 11/11/2017.
 */

public class LoginPresenter {

    public interface View {
        void showProgress();
        void hideProgress();
        void showUser(User user);
        void showErrorMessage(String msg);
        void showSuccessMessage(String msg);
    }

    private View view;
    private LoginInteractor loginInteractor;
    private String response;


    public LoginPresenter(View view){
        this.view = view;
        loginInteractor = new LoginInteractorImpl();
    }

    public void login(String username, String password){
        view.showProgress();

        User user = new User(username, password);

        loginInteractor.syncLogin(user, new LoginInteractor.Callback(){

            @Override
            public void success(Object result) {
                view.hideProgress();
                view.showSuccessMessage(result.toString());
            }

            @Override
            public void error(Throwable error) {
                view.hideProgress();
                view.showErrorMessage(null);
            }
        });
    }

}
