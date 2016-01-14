/**
 * Created by lc on 2016/1/11.
 */
public class vip {
    private boolean isvip;
    private int vc;
    private String member;
    private String name;
    public vip(){
        vc = 0;
        isvip = false;
    }

    public void setvip(boolean a){
        isvip = a;
    }
    public boolean getvip(){
        return isvip;
    }

    public void setVc(int a){
        vc += a;
    }
    public  int getVc(){
        return vc;
    }

    public void setMember(String a){
        member = a;
    }

    public String getMember(){
        return  member;
    }

    public void setName(String a){
        this.name = a;
    }
    public String getName(){
        return name;
    }
}
