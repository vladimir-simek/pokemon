package com.vladimirsimek.pokemon;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        Operations.readPokemon("src/com/vladimirsimek/pokemon/pokemon.csv", pokemons);
        Operations.getStatistics(pokemons);
    }
}
