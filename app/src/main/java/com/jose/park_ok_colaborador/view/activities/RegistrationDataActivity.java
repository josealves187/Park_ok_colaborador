package com.jose.park_ok_colaborador.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.MaterialToolbar;
import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.commom.Users;

import static com.jose.park_ok_colaborador.utils.MaskTextView.cpfRegistration;

public class RegistrationDataActivity extends AppCompatActivity {

    private MaterialToolbar mtToolbarDataRegistrion;
    private ImageView acivPhotoUserDetais;
    private TextView tvNameRegister;
    private TextView tvCpfRegister;
    private TextView tvEmaiRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_data);
        initializeComponents();
        setSupportActionBar(mtToolbarDataRegistrion);
        eventButton();


        Users users = new Users(1, "José Alves", "14587965288", "jralves187@gmail.com");
        if (users != null){
            Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/freedelivery-8ff6e.appspot.com/o/imagens%2FUsuario%2FyO40m4hU9dR2eoQLANMrSkkcIQP2jpeg?alt=media&token=30dffe08-64ba-4b08-acca-10c6f1ac7d0f").into(acivPhotoUserDetais);
            tvNameRegister.setText(users.getNameUser());
            tvCpfRegister.setText(cpfRegistration(users.getCpf()));
            tvEmaiRegister.setText(users.getEmail());
        }


    }

    private void eventButton() {
        mtToolbarDataRegistrion.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });
    }

    @Override
    public void onBackPressed(){

        SharedPreferences.Editor editor = getSharedPreferences("PARKOK", MODE_PRIVATE).edit();
        editor.putInt("SCREEN_ORIGEN", 4);
        editor.commit();
        super.onBackPressed();
    }

    private void initializeComponents() {
        mtToolbarDataRegistrion = findViewById(R.id.mt_toolbar_data_registrion);
        acivPhotoUserDetais = findViewById(R.id.aciv_photo_user_detais);
        tvNameRegister = findViewById(R.id.tv_name_register);
        tvCpfRegister = findViewById(R.id.tv_cpf_register);
        tvEmaiRegister = findViewById(R.id.tv_email_register);
    }
}
