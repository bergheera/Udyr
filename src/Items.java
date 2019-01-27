/**
 * Created by Diggey on 27.02.17.
 */
public abstract class Items {

    private String name;
    private String type;

    public Items(String name, String type) {
        setName(name);
        setTypt(type);

    }
    public void setTypt(String type){
        this.type=type;
    }

    public String getType(){
        return type;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}


