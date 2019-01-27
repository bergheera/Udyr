import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Diggey on 15.11.16.
 */
public class Utilities {

    private ArrayList<Integer> levelRange;

    public Utilities(){
        this.levelRange = new ArrayList<Integer>();
    }

    public void delay(int sec){
        try {
            Thread.sleep(sec); // Just to give the user a chance to see "hello".
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("\b\b\b\b\b");
    }


    public boolean checkIfCrit(Ability ability){
            double crit =  1 +(Math.random() * ((100 - 1) + 1));
            int crits = ((int) crit);

            //System.out.println("CritROLL:" + crits);
            //System.out.println("Crit chance: "+ ability.getCritChance());

            if(ability.getCritChance() >= crits) {
                System.out.println("Its a CRIT!");
                return true;
            }
            return false;
    }

    public int getRandomNr10(){
        double nr =  1 +(Math.random() * ((10 - 1) + 1));
        int number = ((int) nr);
        return number;
    }

    public int getRandomNr100(){
        double nr =  1 +(Math.random() * ((100 - 1) + 1));
        int number = ((int) nr);
        return number;
    }

    public boolean checkIfHit(Ability ability){
        double acc =  1 +(Math.random() * ((100 - 1) + 1));
        int accs = ((int) acc);
        //System.out.println("hitRoll="+ accs);
        //System.out.println("abilityHitChance=" + ability.getAbilityAccuracy());
        if(ability.getAbilityAccuracy() >= accs) {
            //System.out.println("HIT!!!");
            return true;
        } else {
            //System.out.println("MISSED");
            return false;
        }

    }

    public int levelCalculatpr(int xp, int pokemonLevel){
    /*
        HashMap<Integer,Integer> levelRange = new HashMap<Integer, Integer>();
        levelRange.put(1,10);
        levelRange.put(2,40);
        levelRange.put(3,)
 return i;
    */



       return 1;
    }

    public void generateXPLevels(){

        this.levelRange.add(10);

        for(int i = 1; i < 101; i++){
            int nextLevel = this.levelRange.get(i-1) * 100 / 80;
            this.levelRange.add(nextLevel);
        }
    }

    public int getLevelRange(int level){
        if(level>100) {
            level = 100;
        } if(level < 0) {
            level = 2;
        }

            int nr = this.levelRange.get(level);
            return nr;
    }

    public int whoGoesFirst(Character a,Character b){

        int characterA = a.getSpeed();
        int characterB = b.getSpeed();

        double chance1 =  1 +(Math.random() * ((100 - 1) + 1));
        int crits1 = ((int) chance1);

        double chance2 =  1 +(Math.random() * ((100 - 1) + 1));
        int crits2 = ((int) chance2);

        int aChance = characterA + crits1;
        int bChance = characterB + crits2;

        if(aChance>=100){
            aChance=100;
        }
        if(bChance>=100){
            bChance=100;
        }

            if(aChance > bChance) {
                return 1;
            }
            if(aChance < bChance){
                return 2;
            }
            else {
                double same =  1 +(Math.random() * ((100 - 1) + 1));
                int same1 = ((int) same);

                if (same1 > 50) {
                    return 1;
                }
                else {
                    return 2;
                }
            }
    }
}
