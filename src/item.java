import java.util.ArrayList;

/**
 * Created by lc on 2016/1/11.
 */
public class item {
    private ArrayList<String> list;
    private String name;
    public item(){

    }

    public void setName(String a){
        this.name = a;
    }
    public String getName(){
        return name;
    }

    public  void setList(ArrayList<String> l){
        this.list = l;
    }
    public  ArrayList<String> getList(){
        return list;
    }


}
