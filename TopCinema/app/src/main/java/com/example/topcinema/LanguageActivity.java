package com.example.topcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {
    ImageButton btnEspanol;
    ImageButton btnIngles;
    ImageButton btnQuecha;
    Button btnVolver;
    Locale localizacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        btnEspanol = findViewById(R.id.btnEspanol);
        btnIngles = findViewById(R.id.btnIngles);
        btnQuecha = findViewById(R.id.btnQuechua);
        btnVolver = findViewById(R.id.btnVolver);

        btnEspanol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //localizacion = new Locale("es", "ES");
                localizacion = new Locale("default");
                Locale.setDefault(localizacion);
                Configuration config = new Configuration();
                config.locale = localizacion;
                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                refrescar();

            }
        });
        btnIngles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                localizacion = new Locale("en", "EN");
                Locale.setDefault(localizacion);
                Configuration config = new Configuration();
                config.locale = localizacion;
                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                refrescar();
            }
        });
        btnQuecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                localizacion = new Locale("qu", "BO");
                Locale.setDefault(localizacion);
                Configuration config = new Configuration();
                config.locale = localizacion;
                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                refrescar();
            }
        });
    }

    public void refrescar()
    {
        Intent refrescar = new Intent(this, MainActivity.class);
        startActivity(refrescar);
        finish();
    }
    public void volverLogin(View view)
    {
        try {
            Intent intent = new Intent(this, InicioActividad.class);
            startActivity(intent);
        }
        catch (Exception ex)
        {
            Toast.makeText(this ,ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
