/**
 * Created by Diggey on 07.11.16.
 */

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Battlefield {

    private Trainer espen;
    private Utilities utilities;
    private ArrayList<Trainer> trainers;
    private Trainer currentTrainer;
    private ArrayList<Character> startpokemons;
    private Scanner sc;
    private AbilityList abilityList;
    private boolean fight;
    private Txt TXT;
    private Items currentItem;
    private ArrayList<Items> startItems;

    public Battlefield( ArrayList<Trainer> trainers, Trainer espen, ArrayList<Character> startPokemons, ArrayList<Items> startItems) {

        this.utilities = new Utilities();
        this.trainers = trainers;
        this.espen = espen;
        this.currentTrainer = trainers.get(0);
        this.startpokemons = startPokemons;
        this.sc = new Scanner(System.in);
        espen.removePokemon(0);
        currentTrainer.removePokemon(0);
        abilityList = new AbilityList();
        fight = false;
        TXT = new Txt();
        this.startItems = startItems;
        utilities.generateXPLevels();


    }

    public void intro() {
        System.out.println("Udyr; work in-progress");
        System.out.println("By Espen Berg");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Hello!...my name is professor Oak!");
        System.out.println("My grandchild, I pay a lot of interest in my Pokemons, but not in my grandchildren");
        //utilities.delay(4000);
        System.out.println("...what is your name again?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        espen.setName(name);
        System.out.println("ooh! so your name is " + name + "?");
        System.out.println("Im not going to assume your gender!");
        //utilities.delay(2000);
        System.out.println("so...what is it?");
        String gender = scanner.nextLine();
        espen.setGender(gender);
        System.out.println("ah! of course your gender is " + gender + ".");
        System.out.println("Is that the one with the penis?..never mind.");
        System.out.println("Well let's start shall we!");
        System.out.println("You can have one of my dear Pokemons...choose wisely");
        //utilities.delay(7000);
        System.out.println("---------- CHOOSE A POKEMON ----------");
        printStartPokemons();
        checkIfcorrectInput();

    }
    public void checkIfcorrectInput() {
        Scanner scanner = new Scanner(System.in);
        int starter = scanner.nextInt();
            if (starter == 1 ) {
                choosePokemon(1);
            }
            else if (starter == 2) {
                choosePokemon(2);
            }
            else if(starter == 3) {
                choosePokemon(3);
            }
            else {
                System.out.println("eh...try again with 1, 2 or 3");
                checkIfcorrectInput();
            }
    }

    public void choosePokemon(int i){
        int pokemon = i -1;
        Character s = startpokemons.get(pokemon);
        espen.addPokemon(s);
        espen.setCurrentPokemon(s);
        System.out.println("You chose...." + s.getName() + "!!!");
        if(pokemon==0){
            System.out.println("Bulbasaur is nice choice! It is grass type Pokemon. It is weak against fire type Pokemons.");
            garysChoice(2);
        } else if (pokemon == 1){
            System.out.println("Squrtle is so cute! I love that water type Pokemon! It is weak against grass type Pokemons.");
            garysChoice(0);
        }  else{
            System.out.println("Charmander! this fire type pokemon is awesome! It is weak against water type Pokemons.");
            garysChoice(1);
        }
    }

    public void garysChoice(int i){

        System.out.println(".......................................");
        System.out.println("...." + espen.getName() + " your cousin is here..!");
        System.out.println("I can't remember your cousin's name either!");
        //utilities.delay(4000);
        System.out.println("...What was it again, "+ espen.getName()+ "?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        currentTrainer.setName(name);
        System.out.println("yes..silly me.." + name + "! now I remember! well you are not going to assume " + name + " gender");
        System.out.println(name + " you can have a Pokemon as well!");
        //utilities.delay(2000);
        System.out.println(name + " picked " + startpokemons.get(i).getName());

        currentTrainer.addPokemon(startpokemons.get(i));

        currentTrainer.setCurrentPokemon(startpokemons.get(i));
        System.out.println(currentTrainer.getName() + ": '" + espen.getName() + " we should let our Pokemons fight against each other! '");
        System.out.println(" ");
        //utilities.delay(10000);
        System.out.println("++++++++++++++++ FIGHTING ++++++++++++++++++++++++++++++++");
        System.out.println("Opponent: " + currentTrainer.getName()+ "  Gender: " + currentTrainer.getGender());
        System.out.println("Pokemons: "+ currentTrainer.getPokemons().size());

        System.out.println(" ");

        ArrayList<Ability> start = new ArrayList<Ability>();





        sendOutPokemon();
        fightMenu();
    }


    public void printStartPokemons(){
        int count = 1;
        for(Character pokemon: startpokemons){
            System.out.println(+count++ + ") " + pokemon.getName());
        }
        System.out.println("|-> Press 1, 2 or 3");
        System.out.println("--------------------------------------");

    }

    public void fightMenu(){
        System.out.println("MENU =======================================================================");
        System.out.println("     1: Fight                             ");
        System.out.println("     2: Items                             ");
        System.out.println("     3: Pokemon's                         ");
        System.out.println("     4: Run                               ");
        System.out.println("     =======================================================================");

        int input = sc.nextInt();
        if (input == 1) {
            fight();
        }

        else if (input == 2) {
            selectItems();
        }

        else if (input == 3){
            selectPokemon();
        } else if (input == 4){
            run();
        }

        else {
            System.out.println("press 1,2,3 or 4");
            fightMenu();
        }
    }

    public void run(){
        if(currentTrainer != null){
            System.out.println("you can't run from a trainer, you pussy...cat!");
            fightMenu();
        }
    }

    public void selectItems(){
        espen.printTrainersItems();
        int size = espen.getItems().size();
        int input = sc.nextInt() -1;

        if(!espen.getItems().isEmpty() && size >= input) {
            currentItem = espen.getItems().get(input);
            System.out.println(espen.getName() + " used " + currentItem.getName());

            if(currentItem.getName().equalsIgnoreCase("Potion")){
                int health = 300 + espen.getCurrentPokemon().getHealth();
                System.out.println(espen.getCurrentPokemon().getName() +" 's old HP: " + espen.getCurrentPokemon().getHealth() + "/" + espen.getCurrentPokemon().getMaxHP());
                espen.getCurrentPokemon().newHealth(health);
                System.out.println(espen.getCurrentPokemon().getName() + " healed for 300 HP!");
                System.out.println(espen.getCurrentPokemon().getName() +" 's NEW HP: " + espen.getCurrentPokemon().getHealth() + "/" + espen.getCurrentPokemon().getMaxHP());
                TXT.linefeed();
                fightMenu();
            }



        }else{
            TXT.linefeed();
            System.out.println("Bag is empty!");
            TXT.linefeed();
            fightMenu();

        }
    }

    public void selectPokemon(){
        if(espen.getPokemons().size()==1){
            System.out.println("You have only 1 Pokemon! you know this!");
        } else {

            espen.printTrainersPokemons();
            int size = espen.getPokemons().size();
            int input = sc.nextInt() -1;

            Character c = espen.getPokemons().get(input);
            if(!espen.getPokemons().isEmpty() && c.getName().equalsIgnoreCase(espen.getCurrentPokemon().getName())){
                System.out.println("This Pokemon is currently active");
                selectPokemon();
            }
            else if (!espen.getPokemons().isEmpty() && size >= input && !c.getName().equalsIgnoreCase(espen.getCurrentPokemon().getName())){
                System.out.println(espen.getCurrentPokemon().getName() + " come back!");
                espen.setCurrentPokemon(espen.getPokemons().get(input));
                System.out.println("GO!!!! "+ espen.getCurrentPokemon().getName());
                fightMenu();
            }
            else{
                System.out.println("");
            }

        }
    }




    public void sendOutPokemon(){
        Character AI = currentTrainer.getCurrentPokemon();
        System.out.println(currentTrainer.getName() + " sent out " + AI.getName() + "!");
        currentTrainer.getCurrentPokemon().printCharacterStat();
        TXT.linefeed2();
        utilities.delay(1000);
        System.out.println(espen.getName() + ": ''I choose you " + espen.getCurrentPokemon().getName() + "!!''...");
        espen.getCurrentPokemon().printCharacterStat();
        TXT.linefeed();
    }

    public void fight() {

        Character AI = currentTrainer.getCurrentPokemon();
        while (!fight) {

            int first = utilities.whoGoesFirst(espen.getCurrentPokemon(), AI);

            if(first == 1) {
                turn(espen,currentTrainer);
                checkIfDead(currentTrainer);
                if(currentTrainer.getCurrentPokemon().getHealth()>0) {
                    turn(currentTrainer, espen);
                    fightMenu();
                    checkIfDead(espen);
                }
            } else{
                turn(currentTrainer,espen);
                checkIfDead(espen);
                if (espen.getCurrentPokemon().getHealth()>0) {
                    turn(espen, currentTrainer);
                    checkIfDead(currentTrainer);
                    fightMenu();
                }
            }

        }

    }

    public void turn(Trainer trainer, Trainer defending) {
        TXT.turnText(trainer);
        selectingAttack(trainer);

        boolean hit = utilities.checkIfHit(trainer.getCurrentPokemon().getCurrentAbility());
        //System.out.println("is it a hit ="+hit);
        if(hit) {
            System.out.println(trainer.getCurrentPokemon().getName()+" hit "+ defending.getCurrentPokemon().getName()+"!");
            int damage = trainer.getCurrentPokemon().getCurrentAbility().getAbiltyDamage();

            boolean isCrit = utilities.checkIfCrit(trainer.getCurrentPokemon().getCurrentAbility());

            if (isCrit) {
                damage = damage * 2;

            }

            ArrayList<String> strong = this.abilityList.typeList(trainer.getCurrentPokemon().getCurrentAbility().getAbilityType());
            System.out.println("strongTYPE = "+trainer.getCurrentPokemon().getCurrentAbility().getAbilityType());
            ArrayList<String> weak = this.abilityList.weakList(trainer.getCurrentPokemon().getCurrentAbility().getAbilityType());
            boolean ifSuper = abilityList.checkIfSuper(strong,defending.getCurrentPokemon().getType());
            boolean ifWeak = abilityList.checkIfWeak(weak, defending.getCurrentPokemon().getType());


            if (ifSuper) {
                System.out.println("It's SUPER EFFECTIVE!");
                damage = damage * 3 / 2;
                //System.out.println("new damage = " + damage);
            }
            if (ifWeak) {
                System.out.println("It's not very effective..");
                damage = damage / 2;
            }
            System.out.println(damage + " damage!");
            defending.getCurrentPokemon().setHealth(damage);
            System.out.println(defending.getCurrentPokemon().getName() + "'s HP:" + defending.getCurrentPokemon().getHealth() + "/" + defending.getCurrentPokemon().getMaxHP());
            System.out.println(" ");
        } else {
            System.out.println(trainer.getCurrentPokemon().getName() + " missed!");
            System.out.println(" ");
        }
    }

    public boolean checkIfDead(Trainer trainer){
        if(trainer.getCurrentPokemon().getHealth() <= 0){
            System.out.println(trainer.getName() + " lost! end of game");
            System.out.println("'"+ trainer.loseScreem(utilities.getRandomNr10()) + "'");
            fight = true;
            return fight;
        }
        else {
            return false;
        }
    }

    public void selectingAttack(Trainer trainer) {
        int input = 1;
        if(trainer==espen ) {
            System.out.println(" ");
            espen.getCurrentPokemon().printCurrentAbilities();
            input = sc.nextInt();
        }
        if(trainer == currentTrainer) {
            double crit = 1 + (Math.random() * ((currentTrainer.getCurrentPokemon().getCurrentAbillities().size() - 1) + 1));
            input = ((int) crit);

        }

        if (input == 1) {
            Ability a = trainer.getCurrentPokemon().getCurrentAbillities().get(0);
            trainer.getCurrentPokemon().setCurrentAbility(a);
            System.out.println(trainer.getCurrentPokemon().getName() + " used " + a.getAbilityName());
            System.out.println(trainer.getCurrentPokemon().getName() + a.getDesc());

        }
        if (input == 2) {
            Ability a = trainer.getCurrentPokemon().getCurrentAbillities().get(1);
            trainer.getCurrentPokemon().setCurrentAbility(a);
            System.out.println(trainer.getCurrentPokemon().getName() + " used " + a.getAbilityName());
            System.out.println(trainer.getCurrentPokemon().getName() + a.getDesc());

        }
        if (input == 3) {
            if (trainer.getCurrentPokemon().getCurrentAbillities().size() > 2) {
                Ability a = trainer.getCurrentPokemon().getCurrentAbillities().get(2);
                trainer.getCurrentPokemon().setCurrentAbility(a);
                System.out.println(trainer.getCurrentPokemon().getName() + " used " + a.getAbilityName());

            } else {
                System.out.println("try again..there is no 3..pick 1 or 2");
            }
        }
    }

}
