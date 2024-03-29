package com.jose.park_ok_colaborador.view.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.appbar.MaterialToolbar;
import com.jose.park_ok_colaborador.R;

public class TutorialAndFAQ extends AppCompatActivity {

    private CardView mcTutorial;
    private CardView mcTutorialFaq;
    private MaterialToolbar mtToolbarTutorialFaq;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_and_faq);
        initializeComponents();
        setSupportActionBar(mtToolbarTutorialFaq);
        eventButton();


    }

    private void eventButton() {
        mtToolbarTutorialFaq.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mcTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TutorialAndFAQ.this, TutorialActivity.class);
                startActivity(i);
            }
        });

        mcTutorialFaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TutorialAndFAQ.this, FaqActivity.class);
                startActivity(i);
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
        mtToolbarTutorialFaq = findViewById(R.id.mt_toolbar_tutorial_faq);
        mcTutorial = findViewById(R.id.mc_tutorial);
        mcTutorialFaq = findViewById(R.id.mc_tutorial_faq);
    }

}

