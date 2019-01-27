/**
 * Created by Diggey on 07.11.16.
 */
public class Ability {

    private String namenoob;
    private int damage;
    private String type;
    private int limit;
    private int accuracy;
    private int critChance;
    private String desc;
    private String name;


    public Ability(String name, int damage, String type, int limit, int accuracy, int critChance, String desc){
        this.name = name;
        this.damage = damage;
        this.type = type;
        this.limit = limit;
        this.accuracy = accuracy;
        this.critChance = critChance;
        this.desc = desc;
    }

    public String getDesc(){
        return desc;
    }


    public int getCritChance(){
        return critChance;
    }

    public void setCritChance(int critChance){
        this.critChance = critChance;
    }

    public int getAbiltyDamage(){
        return damage;
    }

    public void setAbilityDamage(int damage){
        this.damage = damage;
    }

    public String getAbilityName(){
        return this.name;
    }

    public void setAbilityName(String name){
        this.name= name;
    }

    public String getAbilityType(){
        return this.type;
    }

    public void setAbilityType(String type){
        this.type = type;
    }

    public int getAbilityLimit(){
        return this.limit;
    }

    public void setAbilityLimit(int limit){
        this.limit = limit;
    }

    public int getAbilityAccuracy(){
        return  this.accuracy;
    }

    public void setAbilityAccuracy(int accuracy){
        this.accuracy = accuracy;
    }
}
