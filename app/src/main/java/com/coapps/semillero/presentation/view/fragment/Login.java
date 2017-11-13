package com.coapps.semillero.presentation.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.coapps.semillero.R;
import com.coapps.semillero.domain.model.User;
import com.coapps.semillero.presentation.presenter.UserPresenter;
import com.coapps.semillero.presentation.view.activity.MainActivity;
import com.coapps.semillero.utilities.Constants;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 * create an instance of this fragment.
 */
public class Login extends Fragment implements UserPresenter.View, View.OnClickListener {

    private MaterialDialog materialDialog;
    private EditText eEmail;
    private EditText ePassword;
    private Button btnLogin;
    private UserPresenter presenter;

    private String email;
    private String password;
    private TextView link;

    public Login() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);

        eEmail = (EditText) view.findViewById(R.id.txtEmail);
        ePassword = (EditText) view.findViewById(R.id.txtPassword);
        btnLogin = (Button) view.findViewById(R.id.btnLogin);
        materialDialog = new MaterialDialog.Builder(getContext())
        .title("Procesando")
        .content("Espere un momento")
        .progress(true,0)
        .build();

        link = (TextView) view.findViewById(R.id.txtLinkSignUp);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                Fragment fragment = new SignUp();
                fragmentTransaction.replace(R.id.content_main, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        btnLogin.setOnClickListener(this);
        presenter = new UserPresenter(this);


        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnLogin:

                onClickLogin(view);
        }

    }

    public void onClickLogin(View view){

        email = eEmail.getText().toString();
        password = ePassword.getText().toString();

        presenter.login(email, password);
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

        if(Constants.token.length() > 0){
            Intent intent = new Intent(getContext(), MainActivity.class);
            startActivity(intent);
        }

    }



}
