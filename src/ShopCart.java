import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by lc on 2016/1/6.
 */
public class ShopCart {
    private ArrayList<cm> allItem;
    private JSONObject jsonObject;
    private Object jo;
    public ShopCart(){
        allItem = new ArrayList<>();
        String JsonContext = new rf().ReadFile("E:\\ideasoft\\src\\d5");
        jsonObject = JSONObject.fromObject(JsonContext);
        //System.out.println(jsonObject.size());
        Iterator  ji = jsonObject.keys();
        for(int i = 0;i < jsonObject.size();i++) {
            jo = ji.next();
            additem();
        }
        /*for(cm b:allItem){
            System.out.println(b.getbat());
            System.out.println(b.getname());
            System.out.println(b.getuit());
            System.out.println(b.getpri());
        }*/


    }

    public ArrayList<cm> getAllItem(){
        return allItem;
    }

    private void additem(){
        cm a = new cm();
        JSONObject job = jsonObject.getJSONObject(jo.toString());
        /*System.out.println(jo.toString());
        System.out.println(job);
        System.out.println(job.get("name"));
        System.out.println(job.get("unit"));
        System.out.println(job.get("price"));
        System.out.println(job.get("discount"));*/
        a.setbat(jo.toString());
        if(job.get("name") != null)
            a.setname(job.get("name").toString());
        else {
            System.out.println("name没有输入");
            System.exit(0);
        }

        if(job.get("unit") != null)
            a.setuit(job.get("unit").toString());
        else {
            System.out.println("unit没有输入");
            System.exit(0);
        }

        if(job.get("price") != null)
            a.setpri(Double.parseDouble(job.get("price").toString()));
        else {
            System.out.println("price没有输入");
            System.exit(0);
        }

        if(job.get("discount")!=null) {
            if (Double.parseDouble(job.get("discount").toString()) > 1 || Double.parseDouble(job.get("discount").toString()) < 0) {
                System.out.println("discount大小问题");
                System.exit(0);
            }
            else
                a.setcont(Double.parseDouble(job.get("discount").toString()));
            //System.out.println(a.getcont());
        }

        if(job.get("promotion") != null){
            if(job.get("discount")!=null){
                System.out.println("优惠和打折不会同时针对同一款产品");
                System.exit(0);
            }
            else if(job.get("vipDiscount")!=null){
                System.out.println("优惠和会员打折不会同时针对同一款产品");
                System.exit(0);
            }
            a.setpromotion(true);
        }

        if(job.get("vipDiscount")!=null) {
            System.out.println(job.get("vipDiscount"));
            if (Double.parseDouble(job.get("vipDiscount").toString()) > 1 || Double.parseDouble(job.get("vipDiscount").toString()) < 0) {
                System.out.println("vipDiscount大小问题");
                System.exit(0);
            }
            else
                a.setvipdiscount(Double.parseDouble(job.get("vipDiscount").toString()));
            //System.out.println(a.getcont());
        }
        allItem.add(a);
    }
}
