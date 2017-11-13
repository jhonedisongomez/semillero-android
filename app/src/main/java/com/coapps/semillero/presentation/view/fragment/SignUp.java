package com.coapps.semillero.presentation.view.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.afollestad.materialdialogs.MaterialDialog;
import com.coapps.semillero.R;

/**
 * A simple {@link Fragment} subclass.

 */
public class SignUp extends Fragment implements View.OnClickListener {

    private EditText eEmail;
    private EditText ePassword;
    private EditText ePasswordAgain;
    private EditText eNames;
    private EditText eLastNames;
    private CheckBox chAgree;
    private Button btnSignUp;

    private String email, password, passwordAgain, names, lastNames;
    private boolean isAgree;

    private MaterialDialog materialDialog;

    public SignUp() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_sign_up, container, false);

        eNames =(EditText) view.findViewById(R.id.eName);
        eLastNames = (EditText) view.findViewById(R.id.eLastName);
        eEmail = (EditText) view.findViewById(R.id.eEmail);
        ePassword = (EditText) view.findViewById(R.id.ePassword);
        ePasswordAgain = (EditText) view.findViewById(R.id.ePasswordAgain);

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
        names = eNames.getText().toString();
        lastNames = eLastNames.getText().toString();
        email = eEmail.getText().toString();
        password = ePassword.getText().toString();
        passwordAgain = ePasswordAgain.getText().toString();

        //si los campos son validos entonces llamar al metodo para registrarlos

    }

}
