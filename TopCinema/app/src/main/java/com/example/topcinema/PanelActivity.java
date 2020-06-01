package com.example.topcinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PanelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);
    }
    public void cargarUserView(View w)
    {
        try {
            Intent intent = new Intent(this, ViewUserActivity.class);
            startActivity(intent);
        }
        catch (Exception ex)
        {
            Toast.makeText(this,ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public void cargarMovieView(View w)
    {
        try {
            Intent intent = new Intent(this, ViewPeliculaActivity.class);
            startActivity(intent);
        }
        catch (Exception ex)
        {
            Toast.makeText(this,ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    public void cerrarSesion(View w)
    {
        try {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        catch (Exception ex)
        {
            Toast.makeText(this,ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}