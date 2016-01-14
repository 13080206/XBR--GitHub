import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by lc on 2016/1/11.
 */
public class vipmessage {
    private ArrayList<vip> vipm;
    private JSONObject jsonObject;
    private Object jo;
    public vipmessage(){
        vipm = new ArrayList<>();
        String JsonContext = new rf().ReadFile("E:\\ideasoft\\src\\d5m");
        jsonObject = JSONObject.fromObject(JsonContext);
        Iterator ji = jsonObject.keys();
        for(int i = 0;i < jsonObject.size();i++) {
            jo = ji.next();
            addmessage();
        }
    }
    public void addmessage(){
        vip a = new vip();
        JSONObject job = jsonObject.getJSONObject(jo.toString());
        a.setMember(jo.toString());
        if(job.get("name") != null)
            a.setName(job.get("name").toString());
        else {
            System.out.println("vipname没有输入");
            System.exit(0);
        }
        if(job.get("isVip") != null) {
            if (job.get("isVip").toString().equals("true"))
                a.setvip(true);
            else
                a.setvip(false);
        }
        else {
            System.out.println("vip没有输入");
            System.exit(0);
        }

        if(job.get("vc") != null) {
            a.setVc(Integer.parseInt(job.get("vc").toString()));
        }
        vipm.add(a);
    }

    public ArrayList<vip> getvipm(){
        return vipm;
    }
}
