package com.oliverbotello.miprimeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    // La funcion se puede llamar como sea. Solo la estoy identificando
    // Y esta se va a encargar de iniciar los componentes de la vista
    private void initView() {
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        login();
                    }
                }
        );
    }

    // Funcion que gestiona el login
    private void login() {
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        if (username.contentEquals("Oliver404") && password.contentEquals("Alexis")) {
            editTextUsername.setError(null);
            editTextPassword.setError(null);
            Toast.makeText(this, "Bienvenido a tu POKEDEX", Toast.LENGTH_LONG).show();
            goToPokedex();
        }
        else {
            editTextUsername.setError("Tu usuario no existe");
            editTextPassword.setError("Esta NO es tu contraseña");
        }
    }

    private void goToPokedex() {
        // Creamos la transaccion
        Intent transaction = new Intent(this, PokedexActivity.class);

        // La ejecutamos
        startActivity(transaction);
    }
}