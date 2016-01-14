import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import java.util.ArrayList;

/**
 * Created by lc on 2016/1/6.
 */
public class ItemList {
    private item mlist;
    private ArrayList<String> list;
    public ItemList(){
        mlist = new item();
        list = new ArrayList<>();
        String JsonContext = new rf().ReadFile("E:\\ideasoft\\src\\d5l");
        JSONObject jsonObject = JSONObject.fromObject(JsonContext);

        if(jsonObject.get("user") != null)
             mlist.setName(jsonObject.get("user").toString());
        else {
            System.out.println("user name没有输入");
            System.exit(0);
        }
        JSONArray jsonArray = JSONArray.fromObject(jsonObject.get("items"));
        int size = jsonArray.size();
        for(int i = 0;i < size ;i++){
            list.add(jsonArray.getString(i));
            System.out.println(jsonArray.getString(i));
        }
        mlist.setList(list);
    }
    public item getmList(){
        return mlist;
    }
}
