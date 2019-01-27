import java.util.ArrayList;

/**
 * Created by Diggey on 15.11.16.
 */
public class Txt {

    private Character character;
    private Trainer t;

    public void startTxt(ArrayList <Trainer> trainers) {



    }

    public void turnText(Trainer trainer){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("  ******* " + trainer.getName() + " turn!  *******");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }


    public void characterStat(Character character){
        System.out.println();
    }

    public void linefeed(){
        System.out.println("");
    }
    public void linefeed2(){
        System.out.println("");
        System.out.println("");
    }
}
