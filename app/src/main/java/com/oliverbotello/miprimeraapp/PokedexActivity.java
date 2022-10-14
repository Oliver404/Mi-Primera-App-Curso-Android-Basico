package com.oliverbotello.miprimeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.oliverbotello.miprimeraapp.entities.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokedexActivity extends AppCompatActivity {
    // Componentes de la UI
    private ImageView imageViewPokemon;
    private TextView textViewPokemonName;
    private TextView textViewPokemonDescription;
    private Button buttonSiguiente;
    private Button buttonAnterior;
    // Atributos
    private ArrayList<Pokemon> lstPokemon = new ArrayList<>();
    private int currenIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);
        lstPokemon = getPokemons(); // simulacion del api
        initView();
    }

    private void initView() {
        imageViewPokemon = findViewById(R.id.imageViewPokemon);
        textViewPokemonName = findViewById(R.id.textViewPokemonName);
        textViewPokemonDescription = findViewById(R.id.textViewPokemonDescription);
        buttonSiguiente = findViewById(R.id.buttonSiguiente);
        buttonAnterior = findViewById(R.id.buttonAnterior);

        buttonSiguiente.setOnClickListener(
                new View.OnClickListener() {
                    // array = {1, 2, 3}
                    //         [0, 1, 2]
                    // lista size = 3
                    // 3 - 1 = 2
                    @Override
                    public void onClick(View v) {
                        if (currenIndex < lstPokemon.size() - 1) {
                            currenIndex++;
                            setCurrentPokemon(currenIndex);
                        }
                    }
                }
        );
        buttonAnterior.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (currenIndex > 0) {
                            currenIndex--;
                            setCurrentPokemon(currenIndex);
                        }
                    }
                }
        );

        setCurrentPokemon(currenIndex);
    }

    private void setCurrentPokemon(int index) {
        imageViewPokemon.setImageResource(lstPokemon.get(index).getImage());
        textViewPokemonName.setText(lstPokemon.get(index).getName());
        textViewPokemonDescription.setText(lstPokemon.get(index).getDescription());
    }

    // Esto sirve de momento para simular la conexion al API/BASE DE DATOS
    private ArrayList<Pokemon> getPokemons() {
        ArrayList<Pokemon> newPokemons = new ArrayList<>();

        newPokemons.add(new Pokemon("Kiogre", "Es un pogemon legendario", R.drawable.kiogre));
        newPokemons.add(new Pokemon("Charmander", "Recaliente", R.drawable.charmander));
        newPokemons.add(new Pokemon("El vamo a calmarnos", "Lentes de titan", R.drawable.vamoacalmarnos));
        newPokemons.add(new Pokemon("Pokemon 4", "Lentes de titan", R.drawable.img));
        newPokemons.add(new Pokemon("Pokemon 5", "Lentes de titan", R.drawable.img_1));
        newPokemons.add(new Pokemon("Pokemon 6", "Lentes de titan", R.drawable.img_2));

        return newPokemons;
    }
}