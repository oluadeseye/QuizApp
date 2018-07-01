package com.example.android.quizapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkResult(View v) {
        Toast toast = Toast.makeText(this, scoreMessage(), Toast.LENGTH_LONG);
      toast.show();

        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    public String scoreMessage() {

        EditText layerField = findViewById(R.id.layer_field);
        String layerAnswer = layerField.getText().toString();

        if (layerAnswer.equals("Inner layer")) {
            score += 1;
        }

        EditText adhesiveField = findViewById(R.id.adhesive_field);
        String adhesiveAnswer = adhesiveField.getText().toString();

        if (adhesiveAnswer.equals("Adhesive")) {
            score += 1;
        }

        EditText raysField = findViewById(R.id.rays_field);
        String raysAnswer = raysField.getText().toString();

        if (raysAnswer.equals("Gamma Ray")) {
            score += 1;
        }
        RadioGroup rgReceive = findViewById(R.id.receive_radio_group);

        if (rgReceive.getCheckedRadioButtonId() == R.id.rb_radio_wave) {
            score += 1;
        }

        RadioGroup rgPencil = findViewById(R.id.pencil_radio_group);

        if (rgPencil.getCheckedRadioButtonId() == R.id.rb_graphite) {
            score += 1;
        }
        RadioGroup rgNuclear = findViewById(R.id.nuclear_radio_group);

        if (rgNuclear.getCheckedRadioButtonId() == R.id.rb_neutron) {
            score += 1;
        }
        CheckBox cbClay = findViewById(R.id.cb_clay);
        Boolean clay = cbClay.isChecked();

        CheckBox cbLimestone = findViewById(R.id.cb_limestone);
        Boolean limestone = cbLimestone.isChecked();

        CheckBox cbGypsum = findViewById(R.id.cb_gypsum);
        Boolean gypsum = cbGypsum.isChecked();

        CheckBox cbStone = findViewById(R.id.cb_stone);
        Boolean stone = cbStone.isChecked();

        if (clay && limestone && !stone && !gypsum) {
            score += 1;
        }

        CheckBox cbWater = findViewById(R.id.cb_water);
        Boolean water = cbWater.isChecked();

        CheckBox cbOleum = findViewById(R.id.cb_oleum);
        Boolean oleum = cbOleum.isChecked();

        CheckBox cbSulphuric = findViewById(R.id.cb_sulphuric);
        Boolean sulphuric = cbSulphuric.isChecked();

        CheckBox cbPeroxide = findViewById(R.id.cb_peroxide);
        Boolean peroxide = cbPeroxide.isChecked();

        if (water && oleum && !sulphuric && !peroxide) {
            score += 1;
        }

        CheckBox cbBetaRay = findViewById(R.id.cb_beta_ray);
        Boolean betaRay = cbBetaRay.isChecked();

        CheckBox cbAlphaRay = findViewById(R.id.cb_alpha_ray);
        Boolean alphaRay = cbAlphaRay.isChecked();

        CheckBox cbGammaRay = findViewById(R.id.cb_gamma_ray);
        Boolean gammaRay = cbGammaRay.isChecked();

        CheckBox cbOmegaRay = findViewById(R.id.cb_omega_ray);
        Boolean omegaRay = cbOmegaRay.isChecked();

        if (betaRay && alphaRay && gammaRay && !omegaRay) {
            score += 1;
        }

        return "Your Scored:"   + score +   "out of 9";
    }
}

