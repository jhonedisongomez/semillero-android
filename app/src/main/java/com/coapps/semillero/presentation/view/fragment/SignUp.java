package com.coapps.semillero.presentation.view.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.afollestad.materialdialogs.MaterialDialog;
import com.coapps.semillero.R;
import com.coapps.semillero.domain.model.User;
import com.coapps.semillero.presentation.presenter.UserPresenter;

/**
 * A simple {@link Fragment} subclass.

 */
public class SignUp extends Fragment implements UserPresenter.View, View.OnClickListener {

    private EditText eEmail;
    private EditText ePassword;
    private EditText ePasswordAgain;
    private CheckBox chAgree;
    private Button btnSignUp;

    private String email, password, passwordAgain;
    private boolean isAgree;
    private User user;
    private UserPresenter presenter;

    private MaterialDialog materialDialog;

    public SignUp() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        presenter = new UserPresenter(this);
        View view= inflater.inflate(R.layout.fragment_sign_up, container, false);

        eEmail = (EditText) view.findViewById(R.id.eEmail);
        ePassword = (EditText) view.findViewById(R.id.ePassword);
        ePasswordAgain = (EditText) view.findViewById(R.id.ePasswordAgain);

        chAgree = (CheckBox) view.findViewById(R.id.chAgree);
        btnSignUp = (Button) view.findViewById(R.id.btnSignUp);

        materialDialog = new MaterialDialog.Builder(getContext())
                .title(R.string.procesando)
                .content(R.string.espere)
                .progress(true,0)
                .build();

        btnSignUp.setOnClickListener(this);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View view) {

        //validar los campos
        email = eEmail.getText().toString();
        password = ePassword.getText().toString();
        passwordAgain = ePasswordAgain.getText().toString();
        isAgree = chAgree.isChecked();

        user = new User(email, email, password, passwordAgain);
        presenter.userRegister(user, isAgree);


    }

    @Override
    public void showProgress() {
        materialDialog.show();
    }

    @Override
    public void hideProgress() {
        materialDialog.hide();
    }

    @Override
    public void showUser(User user) {

    }

    @Override
    public void showErrorMessage(String msg) {
        Snackbar.make(getView(),msg, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showSuccessMessage(String msg) {
        Snackbar.make(getView(),msg, Snackbar.LENGTH_LONG).show();
    }
}
