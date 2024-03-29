package com.jose.park_ok_colaborador.view.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.jose.park_ok_colaborador.R;
import com.jose.park_ok_colaborador.commom.Attendence;

import static com.jose.park_ok_colaborador.utils.Constants.ATTENDENCE;
import static com.jose.park_ok_colaborador.utils.MaskTextView.cpf;

public class BonusCustomerActivity extends AppCompatActivity {

    private MaterialButton btnReportPlate;
    private MaterialButton btnCheckCancel;
    private MaterialToolbar mtToolbarbonusCustomer;
    private EditText tvValueBonusCustomer;
    private TextView tvNameCustomer;
    private TextView tvCpfCustomer;

    private ImageView acivPhotoClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus_customer);

        //inicializar componente
        initializeComponents();
        setSupportActionBar(mtToolbarbonusCustomer);
        eventButton();

        Bundle extras = getIntent().getExtras();
        Attendence registrationData = extras.getParcelable(ATTENDENCE);

        if (registrationData != null) {
            Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/freedelivery-8ff6e.appspot.com/o/imagens%2FUsuario%2FyO40m4hU9dR2eoQLANMrSkkcIQP2jpeg?alt=media&token=30dffe08-64ba-4b08-acca-10c6f1ac7d0f").into(acivPhotoClient);
            tvNameCustomer.setText(registrationData.getNameUser());
            tvCpfCustomer.setText(cpf(registrationData.getCpf()));

        }

    }

    private void eventButton() {
        mtToolbarbonusCustomer.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnReportPlate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle extras = getIntent().getExtras();
                final Attendence attendence = extras.getParcelable(ATTENDENCE);
                Intent i = new Intent(BonusCustomerActivity.this, CheckOutActivity.class);
                i.putExtra(ATTENDENCE, attendence);
                startActivity(i);
            }
        });
        btnCheckCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BonusCustomerActivity.this, HomeActivity.class);
                startActivity(i);
                onBackPressed();
            }
        });
    }


    @Override
    public void onBackPressed() {
        SharedPreferences.Editor editor = getSharedPreferences("PARKOK", MODE_PRIVATE).edit();
        editor.putInt("SCREEN_ORIGEN", 2);
        editor.commit();
        super.onBackPressed();
    }





        private void initializeComponents () {
            tvValueBonusCustomer = findViewById(R.id.tv_value_bonus_customer);
            btnReportPlate = findViewById(R.id.btn_report_plate);
            btnCheckCancel = findViewById(R.id.btn_check_cancel);
            mtToolbarbonusCustomer = findViewById(R.id.mt_toolbar_bonus_customer);
            acivPhotoClient = findViewById(R.id.aciv_photo_bonus_customer_client);
            tvNameCustomer = findViewById(R.id.tv_name_bonus_customer);
            tvCpfCustomer = findViewById(R.id.tv_cpf_bonus_customer);
        }


    }

