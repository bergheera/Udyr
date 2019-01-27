import java.util.ArrayList;

/**
 * Created by Diggey on 07.11.16.
 */
public class Character {

    private String name;
    private int health;
    private ArrayList<Ability> abilites;
    private ArrayList<Ability> currentAbillities;
    private int accuracy;
    private int exp;
    private int level;
    private int abilityLimit;
    private Ability ability;
    private int maxHP;
    private int xpToNextLevel;
    private String type;
    private int speed;
    private Ability currentAbility;

    public Character(String name, int health, ArrayList<Ability>abilites,
                     int accuracy, int exp, int level, int maxHP, int xpToNextLevel,
                     String type, ArrayList<Ability> currentAbillities, int speed){
        this.name = name;
        this.health = health;
        this.type = type;
        this.abilites = abilites;
        this.accuracy = accuracy;
        this.exp = exp;
        this.level = level;
        this.maxHP = maxHP;
        this.xpToNextLevel = xpToNextLevel;
        abilityLimit = 4;
        this.currentAbillities=currentAbillities;
        this.ability = ability;
        this.speed = speed;
    }

    public void setCurrentAbility(Ability currentAbility){
        this.currentAbility = currentAbility;
    }

    public Ability getCurrentAbility(){
        return currentAbility;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getSpeed(){
        return speed;
    }

    public void setAbility(Ability a){
        this.ability = a;
    }

    public Ability getAbility(){
        return ability;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int damage) {
        this.health = health - damage;
    }

    public void newHealth(int hp){
        if(hp>getMaxHP()){
            this.health = getMaxHP();
        } else {
            this.health = hp;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbilityList(ArrayList<Ability> abilites){
        this.abilites= abilites;
    }

    public ArrayList<Ability> getAbilityList(){

        return abilites;
    }

    public void setAccuracy(int accuracy){
        this.accuracy= accuracy;
    }

    public int getAccuracy(){
        return accuracy;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ArrayList<Ability> getCurrentAbillities() {
        return currentAbillities;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getMaxHP(){
        return maxHP;
    }

    public void setXpToNextLevel(int xpToNextLevel) {
        this.xpToNextLevel = xpToNextLevel;
    }

    public int getXpToNextLevel() {
        return xpToNextLevel;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public void addAbility(int nr) {
            if(getAbilityList().get(nr -1) != null){
                currentAbillities.add(getAbilityList().get(nr));
                System.out.println("You learned "+ getAbilityList().get(nr-1).getAbilityName() + "!!");
                System.out.println(" ");
                getAbilityList().remove(nr-1);

            }
                else {
                System.out.println("you cant learn more ");
            }

    }

    public void startAbility(int nr){
       getCurrentAbillities().add(getAbilityList().get(nr));
    }


    public void printAllAbilities() {
        int number = 1;

        System.out.println("||---- Get All abilites -------------> ");
        for (Ability a : getAbilityList()){
            System.out.println(number++ +" : "+ a.getAbilityName()+ " ("+ a.getAbilityType()+ ")");

        }
        System.out.println("|==== End of All abilites ===============>");
    }

    public void printCurrentAbilities() {
        System.out.println(getName() + "'s abilities  ");
        System.out.println("========================================");
        int number = 1;
        for (Ability a : getCurrentAbillities()){
            System.out.println("   "+number++ +" : "+ a.getAbilityName()+ " ("+ a.getAbilityType()+ ")");

        }
        System.out.println("======================================== ");
    }


    public void printCharacterStat(){
        System.out.println(" ");
        System.out.println("    Type:   " + getType());
        System.out.println("    Health: " + getHealth() + "/" + getMaxHP());
        System.out.println("    Speed:  " + getSpeed());
        System.out.println("    Level:  " + getLevel());
        System.out.println("    XP:     " + getExp() + "/" + getXpToNextLevel());
        //System.out.println("---------------------------------------");
    }



}
