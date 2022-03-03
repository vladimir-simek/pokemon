package com.vladimirsimek.pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Operations {

    public static void readPokemon(String path, ArrayList<Pokemon> list) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

            String line = bufferedReader.readLine();

            while (line != null){
                addToList(line, list);
                line = bufferedReader.readLine();

            }
            System.out.println("Successfully added all pokemons.");
            bufferedReader.close();

        } catch (Exception e) {
            System.out.println("" + e);
        }

    }

    public static void addToList(String pokemon, ArrayList<Pokemon> list){
        String[] pokemonInfo = pokemon.split(",");


        list.add(new Pokemon(Integer.parseInt(pokemonInfo[0]), pokemonInfo[1], pokemonInfo[2], pokemonInfo[3], Integer.parseInt(pokemonInfo[5]), Integer.parseInt(pokemonInfo[6]), Integer.parseInt(pokemonInfo[6]), Integer.parseInt(pokemonInfo[7]), Integer.parseInt(pokemonInfo[8]), Integer.parseInt(pokemonInfo[9]), Integer.parseInt(pokemonInfo[10]), Integer.parseInt(pokemonInfo[11]), isLegendary(pokemonInfo[12])));
    }

    public static boolean isLegendary(String bool){
        return !bool.equals("False");
    }

    public static void getStatistics(ArrayList<Pokemon> list){

        OptionalDouble averageAttackFirstGen = list
                .stream()
                .filter(i -> i.generation == 1)
                .map(i -> i.attack)
                .mapToDouble(a -> a)
                .average();

        System.out.println("Average attack from pokemons from first generation: " + averageAttackFirstGen.getAsDouble());

        var namesOfLegendaryPokemons = list
                .stream()
                .filter(i -> i.generation == 2)
                .filter(i -> i.legendary)
                .map(i -> i.name)
                .collect(Collectors.toList());

        System.out.println("Names of legendary pokemons from second generation: " + namesOfLegendaryPokemons);

        var highestHpPokemonFirstGen = list
                .stream()
                .filter(i -> i.generation == 1)
                .max((o1, o2) -> o1.hp - o2.hp)
                .get();


        System.out.println("Pokemon with the highest HP from first generation: " + highestHpPokemonFirstGen.name + " (" + highestHpPokemonFirstGen.hp + "HP)");

        var onlyOneTypePokemonFirstGen = list
                .stream()
                .filter(i -> i.generation == 1)
                .filter(i -> i.type1.equals("NULL") || i.type2.equals("NULL"))
                .map(i -> i.name)
                .collect(Collectors.toList());

        System.out.println(onlyOneTypePokemonFirstGen);
    }

}
