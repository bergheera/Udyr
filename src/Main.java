import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// Here it all begins

        ArrayList abilities = new ArrayList<Ability>();
        ArrayList currAbilities1 = new ArrayList<Ability>();
        ArrayList currAbilities2 = new ArrayList<Ability>();
        ArrayList currAbilities3 = new ArrayList<Ability>();
        ArrayList currAbilities4 = new ArrayList<Ability>();
        ArrayList espensPokemons = new ArrayList<Character>();
        ArrayList garysPokemons = new ArrayList<Character>();
        ArrayList mistysPokemons = new ArrayList<Character>();
        ArrayList trainers = new ArrayList<Trainer>();
        ArrayList startpokemon = new ArrayList<Character>();
        ArrayList espensItems = new ArrayList<Items>();

        abilities.add(new Ability("Razor leafs", 500, "Grass",10,100,100, " sends out razor sharp leafs ")); // 0
        abilities.add(new Ability("Vine vip", 30, "Grass",20,100,20, " sends out 2 vines in high speed "));      // 1
        abilities.add(new Ability("Seed Storm", 70, "Grass",5,90,20, " fires seeds in high speed "));      // 2
        abilities.add(new Ability("Solar Beam", 120, "Grass",3,75,20," charging Solar Power "));     // 3
        abilities.add(new Ability("Tackle", 20, "Normal",30,90,10, " runs with full speed "));        // 4
        abilities.add(new Ability("Body Slam",40,"Normal",25,80,40, " runs with full body blast "));       // 5
        abilities.add(new Ability("Sand Attack",20,"Ground",20,80,30," blasting sand "));     // 6
        abilities.add(new Ability("Sword Dance",20,"Normal",25,80,30," ..dancing"));     // 7
        abilities.add(new Ability("Bobble",25,"Water",25,80,20, " spitting out concentrated bubbles "));          // 8
        abilities.add(new Ability("FireNaido", 40 , "Fire", 10,90,30, " spitting out a flaming cone"));     // 9
        abilities.add(new Ability("Scratch", 25, "Normal",30,90,10, " pulling out claws"));        //10


        currAbilities1.add(abilities.get(0));
        currAbilities1.add(abilities.get(1));
        currAbilities2.add(abilities.get(4));
        currAbilities2.add(abilities.get(8));
        currAbilities3.add(abilities.get(9));
        currAbilities3.add(abilities.get(10));
        currAbilities4.add(abilities.get(8));
        currAbilities4.add(abilities.get(7));

        Character bulbasaur = new Character("Bulbasaur",500,abilities,100,0,1,500,100,"grass",currAbilities1,15);
        Character squrtle = new Character("Squrtle",500,abilities,100,0,1,500,100,"water",currAbilities2,15);
        Character charmander = new Character("Charmander",500,abilities,100,0,1,500,100,"fire",currAbilities3,30);
        Character starmie= new Character("Starmie",300,abilities,100,0,1,300,100,"fire",currAbilities4,40);

        Potion potion = new Potion("potion","Healing");
        potion.setHealing(300);

        Pokeballs pokeball = new Pokeballs("pokeball","Catching Pokemons");



        espensItems.add(potion);
        espensItems.add(pokeball);


        espensPokemons.add(bulbasaur);
        espensPokemons.add(starmie);
        garysPokemons.add(squrtle);
        mistysPokemons.add(starmie);
        startpokemon.add(bulbasaur);
        startpokemon.add(squrtle);
        startpokemon.add(charmander);


        Trainer Espen = new Trainer("Espen",0,"Male",espensPokemons, espensItems);
        Trainer Gary = new Trainer("Gary",0,"Male",garysPokemons,espensItems);
        Trainer Misty = new Trainer("Misty",0,"Female,",mistysPokemons,espensItems);
        trainers.add(Gary);
        trainers.add(Misty);


        Battlefield b = new Battlefield(trainers, Espen, startpokemon,espensItems);

       // b.printAbility(player);
        b.intro();
        /*
        AbilityList a = new AbilityList();
        a.typeList("water");
        ArrayList<String> typeList = a.typeList("water");
        for(String s : typeList){
            System.out.println(s.toString());
        }

        boolean sup =  a.checkIfSuper(typeList, "fire");
        System.out.println(sup);
        */




    }
}
