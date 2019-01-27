
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Diggey on 16.11.16.
 */
public class AbilityList {





    public ArrayList<String> typeList(String type){

        ArrayList<String> list = new ArrayList<String>();
        String grass = "grass";
        String water = "water";
        String fire = "fire";
        String normal = "normal";
        String ghost = "ghost";
        String ice = "ice";
        String rock = "rock";
        String electric = "electric";

        ArrayList<String> grassList = new ArrayList<String>();
        grassList.add(water);
        grassList.add(rock);

        ArrayList<String> waterList = new ArrayList<String>();
        waterList.add(fire);
        waterList.add(rock);

        ArrayList<String> fireList = new ArrayList<String>();
        fireList.add(grass);
        fireList.add(ice);

        ArrayList<String> normalList = new ArrayList<String>();
        normalList.add(ice);
        normalList.add(electric);

        ArrayList<String> ghostList = new ArrayList<String>();
        ghostList.add(grass);
        ghostList.add(rock);

        ArrayList<String> iceList = new ArrayList<String>();
        ghostList.add(ghost);
        ghostList.add(grass);

        ArrayList<String> rockList = new ArrayList<String>();
        ghostList.add(normal);
        ghostList.add(fire);

        if(type.equalsIgnoreCase("grass")){
            list= grassList;
        }
        else if (type.equalsIgnoreCase("water")){
            list= waterList;
        }
        else if(type.equalsIgnoreCase("fire")){
            list= fireList;
        }
        else if(type.equalsIgnoreCase("normal")){
            list= normalList;
        }
        else if(type.equalsIgnoreCase("ghost")){
            list= ghostList;
        }
        else if(type.equalsIgnoreCase("ghost")){
            list= ghostList;
        }
        else if(type.equalsIgnoreCase("ice")){
            //System.out.println("returned FIRELIST");
            list= iceList;
        }
        else if(type.equalsIgnoreCase("rock")){
            //System.out.println("returned FIRELIST");
            list= rockList;
        }
        return list;

    }

    public ArrayList<String> weakList(String type){

        ArrayList<String> list = new ArrayList<String>();
        String grass = "grass";
        String water = "water";
        String fire = "fire";
        String normal = "normal";
        String ghost = "ghost";
        String ice = "ice";
        String rock = "rock";
        String electric = "electric";

        ArrayList<String> grassList = new ArrayList<String>();
        grassList.add(fire);
        grassList.add(electric);

        ArrayList<String> waterList = new ArrayList<String>();
        waterList.add(electric);
        waterList.add(grass);

        ArrayList<String> fireList = new ArrayList<String>();
        fireList.add(water);
        fireList.add(rock);

        ArrayList<String> normalList = new ArrayList<String>();
        normalList.add(ghost);
        normalList.add(rock);

        ArrayList<String> ghostList = new ArrayList<String>();
        ghostList.add(water);
        ghostList.add(normal);

        ArrayList<String> iceList = new ArrayList<String>();
        ghostList.add(fire);
        ghostList.add(rock);

        ArrayList<String> rockList = new ArrayList<String>();
        ghostList.add(water);
        ghostList.add(grass);

        if(type.equalsIgnoreCase("grass")){
            list= grassList;
        }
        else if (type.equalsIgnoreCase("water")){
            list= waterList;
        }
        else if(type.equalsIgnoreCase("fire")){
            list= fireList;
        }
        else if(type.equalsIgnoreCase("normal")){
            list= normalList;
        }
        else if(type.equalsIgnoreCase("ghost")){
            list= ghostList;
        }
        else if(type.equalsIgnoreCase("ghost")){
            list= ghostList;
        }
        else if(type.equalsIgnoreCase("ice")){
            //System.out.println("returned FIRELIST");
            list= iceList;
        }
        else if(type.equalsIgnoreCase("rock")){
            //System.out.println("returned FIRELIST");
            list= rockList;
        }
        return list;

    }


    public boolean checkIfSuper(ArrayList<String> attackList, String defending){
        //System.out.println("Attacking= " + attacking);
        //2System.out.println("Defending= "+ defending);

        int tall;

        for(String type: attackList){

            if(type.equalsIgnoreCase(defending)){
                System.out.println("super");
                return true;
            }
        }

        return false;
    }

    public boolean checkIfWeak(ArrayList<String> defendList, String defending){
        //System.out.println("Attacking= " + attacking);
        //2System.out.println("Defending= "+ defending);

        int tall;

        for(String type: defendList){

            if(type.equalsIgnoreCase(defending)){
                System.out.println("weakr");
                return true;
            }
        }

        return false;
    }
}
