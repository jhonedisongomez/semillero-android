package com.coapps.semillero.presentation.presenter;

import com.coapps.semillero.domain.interactor.UserInteractor;
import com.coapps.semillero.domain.interactor.impl.UserInteractorImpl;
import com.coapps.semillero.domain.model.User;


/**
 * Created by jhon on 11/11/2017.
 */

public class UserPresenter {

    public interface View {
        void showProgress();
        void hideProgress();
        void showUser(User user);
        void showErrorMessage(String msg);
        void showSuccessMessage(String msg);
    }

    private View view;
    private UserInteractor loginInteractor;
    private String response;


    public UserPresenter(View view){
        this.view = view;
        loginInteractor = new UserInteractorImpl();
    }

    public void login(String username, String password){
        view.showProgress();

        if(username.length() == 0){
            view.hideProgress();
            view.showErrorMessage("El campo de email no puede estar vacio");
            return;
        }

        if(password.length() == 0){
            view.hideProgress();
            view.showErrorMessage("La contraseña no puede estar vacia");
            return;
        }

        User user = new User(username, password);

        loginInteractor.syncLogin(user, new UserInteractor.Callback(){

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

    public void userRegister(User user, boolean agree){

        view.showProgress();

        if(!agree){
            view.hideProgress();
            view.showSuccessMessage("Acepta los terminos y condiciones");
            return;
        }


        loginInteractor.syncUserRegister(user, new UserInteractor.Callback() {
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
