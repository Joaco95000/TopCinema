package com.example.topcinema;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.topcinema.controllers.PeliculaController;
import com.example.topcinema.controllers.UsuarioController;
import com.example.topcinema.modelos.Pelicula;
import com.example.topcinema.modelos.Usuario;

public class RegisterPeliculaActivity extends AppCompatActivity {
        Button btnCrear, btnAddImage;

        EditText etNombre;
        EditText etGenero;
        EditText etCompania;
        EditText etDuracion;
        EditText etPuntuacion;

        ImageView fotoP;

        Pelicula pelicula;
        PeliculaController peliculaController;

        String imgP;

    private static final int PICK_IMAGE=100;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelicula_register);
        btnCrear = findViewById(R.id.btnCrear);
        btnAddImage = findViewById(R.id.btnAddImage);

        etNombre = findViewById(R.id.etNombre);
        etGenero = findViewById(R.id.etGenero);
        etCompania = findViewById(R.id.etCompania);
        etDuracion = findViewById(R.id.etDuracion);
        etPuntuacion = findViewById(R.id.etPuntuacion);
        fotoP = findViewById(R.id.fotoP);
        peliculaController = new PeliculaController(RegisterPeliculaActivity.this);

        btnAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_PICK, Uri.parse("content://media/internal/images/media"));
                    startActivityForResult(intent,PICK_IMAGE);
                } catch (Exception ex)
                {
                    Toast.makeText(getApplicationContext(),ex.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String nombre = etNombre.getText().toString();
                    String genero = etGenero.getText().toString();
                    String compania = etCompania.getText().toString();
                    String duracion = etDuracion.getText().toString();
                    String puntuacion = etPuntuacion.getText().toString();


                    if ("".equals(nombre)) {
                        etNombre.setError("debes ingresar el nombre de la pelicula");
                        etNombre.requestFocus();
                        return;
                    }
                    if ("".equals(genero)) {
                        etGenero.setError("debes ingresar el Genero De La Pelicula");
                        etGenero.requestFocus();
                        return;
                    }
                    if ("".equals(compania)) {
                        etCompania.setError("debes ingresar la Compania De la Pelicula");
                        etCompania.requestFocus();
                        return;
                    }
                    if ("".equals(duracion)) {
                        etDuracion.setError("debes ingresar La Duracion De La Pelicula");
                        etDuracion.requestFocus();
                        return;
                    }

                    if ("".equals(puntuacion)) {
                        etPuntuacion.setError("debes ingresar la puntuacion de la pelicula");
                        etPuntuacion.requestFocus();

                    } else {
                        int duracionP = Integer.parseInt(duracion);
                        int puntuacionP = Integer.parseInt(puntuacion);
                        Toast.makeText(getApplicationContext(),imgP,Toast.LENGTH_SHORT).show();
                        pelicula = new Pelicula(nombre, genero, compania, duracionP, puntuacionP,imgP);
                        long creado = peliculaController.nuevaPelicula(pelicula);
                        if (creado == -1) {
                            Toast.makeText(RegisterPeliculaActivity.this, "Error al insertar pelicula", Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(RegisterPeliculaActivity.this, "Se insertó correctamente", Toast.LENGTH_LONG).show();
                            finish();
                        }
                    }
                }
                catch (Exception ex)
                {
                    Toast.makeText(RegisterPeliculaActivity.this, ex.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK && requestCode==PICK_IMAGE) {
            Uri uri = data.getData();
            String dir = uri.toString();
            fotoP.setImageURI(Uri.parse(dir));
            imgP = dir;
            Toast.makeText(getApplicationContext(), "completado", Toast.LENGTH_SHORT).show();
        }
    }


}

