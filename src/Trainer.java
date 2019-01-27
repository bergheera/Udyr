import java.util.ArrayList;

/**
 * Created by Diggey on 15.11.16.
 */
public class Trainer {

    private String name;
    private int nrOfBadges;
    private String gender;
    private ArrayList<Character> pokemons;
    private Character pokemon;
    private Character currentPokemon;
    private ArrayList<Items> items;
    private Items currentItem;

    public Trainer(String name, int nrOfBadges, String gender, ArrayList<Character> pokemons, ArrayList<Items> items){

        this.name = name;
        this.nrOfBadges = nrOfBadges;
        this.gender = gender;
        this.pokemons = pokemons;
        this.currentPokemon = pokemons.get(0);
        this.items = items;
    }

    public void setPokemon(Character pokemon) {
        this.pokemon = pokemon;
    }

    public ArrayList<Character> getPokemons() {
        return pokemons;
    }

    public Character getCurrentPokemon(){
        return currentPokemon;
    }

    public void setCurrentPokemon(Character currentPokemon){
        this.currentPokemon = currentPokemon;
    }

    public void addPokemon(Character a){
        pokemons.add(a);
    }

    public void removePokemon(int nr){
        if(!pokemons.isEmpty() && pokemons.size()>= nr) {
            pokemons.remove(nr);
        } else {
            System.out.println("all out of pokemons");
        }
    }

    public void removeItem(int nr){
        if(!items.isEmpty() && items.size()>=nr){
            items.remove(nr);
        } else {
            System.out.println("all out of items");
        }
    }

    public void addItem(Items item){
        items.add(item);
    }


    public void getOnePokemon( int nr){
        this.currentPokemon = pokemons.get(nr);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setNrOfBadges(int nrOfBadges) {
        this.nrOfBadges = nrOfBadges;
    }

    public String getName(){
        return name;
    }

    public int getNrOfBadges(){
        return nrOfBadges;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }
    public void printTrainersPokemons(){
        System.out.println("     <POKEMONS> =============================================================");
        int count=1;
        for(Character c: getPokemons()){
            System.out.println("                "+count + ") Name: " + c.getName() + "    Type: " + c.getType() + "   Level: " + c.getLevel() + "   HP: "+ c.getHealth()+"/"+ c.getMaxHP());
            count++;
        }
        System.out.println("                =============================================================");
        System.out.println("");
    }

    public void printTrainersItems(){
        System.out.println("     <ITEMS> ================================================================");
        int count=1;
        for(Items i: items){
            System.out.println("             "+count +") Name: "+i.getName() +"    Desciption: " + i.getType());
            count++;
        }
        System.out.println("             ================================================================");
        System.out.println("");
    }

    public Items getItem(){
        return currentItem;

    }

    public ArrayList<Items>getItems(){
        return items;
    }

    public String loseScreem(int nr){
        ArrayList<String> screem = new ArrayList<String>();
        screem.add("Aaaaaaah...you got me...oh well take this!");
        screem.add("Aaaaaaah...you got me...oh well take this!");
        screem.add("..this is not over..I will win someday!..you have earned this!");
        screem.add("..crap..you win I guess");
        screem.add("...whyyyy God....whhhhhy?");
        screem.add("Well played, you should take this!");
        screem.add("Next time...I'll win!");
        screem.add("Well played, well played....");
        screem.add("Nobody beats me?, I'm the only one who beasts me!");
        screem.add("This is will never happen again!, I will have my revenge!");

        String s = screem.get(nr);
        return s;
    }


}
