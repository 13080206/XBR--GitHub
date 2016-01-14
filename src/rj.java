
import java.util.*;


/**
 * Created by lc on 2016/1/5.
 */
public class rj {
    private ArrayList<cm> item;
    private ArrayList<String> list;
private ArrayList<vip> vipm;
    private  item mlist;
    public rj() {
        addallitem();
        new ShowList(item,vipm,mlist.getName()).show();
    }

    private void addallitem(){
        item = new ShopCart().getAllItem();
        mlist  = new ItemList().getmList();
        list = mlist.getList();
        vipm = new vipmessage().getvipm();

        int ii = 0;
        for(String l:list){
            for(cm i:item){
                if(i.getbat().equals(l.toString())){
                    i.addnum();
                    break;
                }
                ii++;
            }
            if(ii == item.size()) {
                System.out.println("该商品不存在");
                System.exit(0);
            }
            else
                ii = 0;
        }
        for(vip v:vipm){
            if(v.getMember().equals(mlist.getName()))
            {
                System.out.println(v.getMember());
                System.out.println(v.getvip());
                for(cm i:item){
                    i.setIsvip(v.getvip());
                }
            }
        }
    }

}
