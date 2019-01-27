/**
 * Created by Diggey on 27.02.17.
 */
public class Potion extends Items {

    private int healing;

    public Potion(String name, String type){
        super(name, type);
    }

    public int getHealing(){
        return healing;
    }

    public void setHealing(int healing){
        this.healing = healing;
    }

    public void getHealingText(Character character){
        System.out.println(character.getName() + " was healed +" + getHealing()+ "!");
    }
}
