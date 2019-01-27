/**
 * Created by Diggey on 27.02.17.
 */
public class Pokeballs extends Items{

    private int prob;

    public Pokeballs(String name, String type){
        super(name,type);

    }

    public void getProb(){
        this.prob = prob;
    }

    public void setProb(int prob){
        this.prob = prob;
    }

}
