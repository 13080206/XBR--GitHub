import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by lc on 2016/1/7.
 */
public class ShowList {
    private ArrayList<cm> item;
    private ArrayList<cm> sentitem;
    private ArrayList<vip> vipm;
    private String user;
    private double summ;
    private double dissum;
    public ShowList(ArrayList<cm> i,ArrayList<vip> v,String u){
        item = i;
        summ = 0;
        dissum = 0;
        sentitem = new ArrayList<>();
        vipm = v;
        user = u;
    }

    public void show(){
        for(cm a:item) {
            if (a.getnum() == 0)
                continue;
            summ += a.getsum();
            dissum += a.getdissum();
            if (a.getpromotion())
                sentitem.add(a);
        }

        System.out.println("***商店购物清单***");
        for(vip v:vipm){
            if(v.getMember().equals(user))
                if(v.getvip()){
                    int i = 0;
                    int b= (int)summ;
                    if(0 <= v.getVc() && v.getVc() < 200)
                        i += b / 5;
                    else if(v.getVc() >= 200 && v.getVc() < 500)
                        i += b / 5 * 3;
                    else if(v.getVc() >= 500)
                        i += b / 5 * 5;
                    v.setVc(i);
                    System.out.println("会员编号："+v.getMember()+"  会员积分："+v.getVc()+"分");
                    break;
                }
        }
        new rf().WriteFile(vipm);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日(EE) HH点mm分ss秒");
        Date d1 = new Date();
        System.out.println("打印时间: " + sdf.format(d1));
        System.out.println("---------------------------");
        for(cm a:item){
            if(a.getnum() == 0)
                continue;
            System.out.println("名称："+a.getname()+",数量："+a.getnum()+a.getuit()+",单价："+a.getpri()+"(元),小计："+String.format("%.2f",a.getsum())+"(元)");
        }
        System.out.println("---------------------------");
        if(!sentitem.isEmpty()) {
            System.out.println("挥泪赠送商品：");
            for (cm sa : sentitem) {
                System.out.println("名称：" + sa.getname() + ",数量：" + sa.getnum() / 2 + sa.getuit());
            }
            System.out.println("---------------------------");
        }
        System.out.println("总计："+String.format("%.2f",summ)+"(元)");
        if(dissum != 0) {
            System.out.println("节省：" +String.format("%.2f",dissum) + "(元)");
        }
        System.out.println("***********************");
       /* for(cm a:item){
            System.out.println(a.getname());
            System.out.println(a.getcont());
            System.out.println(a.getvipdiscount());
        }*/
    }
}
