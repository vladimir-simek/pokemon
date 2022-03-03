package com.vladimirsimek.pokemon;

//,Name,Type 1,Type 2,Total,HP,Attack,Defense,Sp. Atk,Sp. Def,Speed,Generation,Legendary

public class Pokemon {
    int id;
    String name;
    String type1;
    String type2;
    int hp;
    int attack;
    int defense;
    int spattack;
    int spdefense;
    int speed;
    int undefined;
    int generation;
    boolean legendary;

    public Pokemon(int id, String name, String type1, String type2, int hp, int attack, int defense, int spattack, int spdefense, int speed, int undefined, int generation, boolean legendary) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spattack = spattack;
        this.spdefense = spdefense;
        this.speed = speed;
        this.undefined = undefined;
        this.generation = generation;
        this.legendary = legendary;
    }
}
