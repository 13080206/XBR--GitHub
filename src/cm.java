/**
 * Created by lc on 2016/1/5.
 */
public class cm {
    private String barcode;
    private String name;
    private String unit;
    private double price;
    private double sum;
    private double discount;
    private int num;
    private double dissum;
    private boolean promotion;
    private double vipdiscount;
    private boolean isvip;

    public cm(){
        discount = 1.0;
        sum = 0;
        num = 0;
        dissum = 0;
        promotion = false;
        vipdiscount = 1.0;
        isvip = false;
    }

    public void setbat(String bar){
        this.barcode = bar;
    }
    public String getbat(){
        return barcode;
    }

    public void setname(String nam){
        this.name = nam;
    }
    public String getname(){
        return name;
    }

    public void setuit(String un){
        this.unit = un;
    }
    public String getuit( ){
        return unit;
    }


    public void setpri(double pri){
        this.price = pri;
    }
    public double getpri(){
        return price;
    }

    public void setcont(double cont){ this.discount = cont;}
    public double getcont(){
        return discount;
    }

    public double getsum(){
        if(promotion)
            sum = price * (num-num/2) ;
        else if(isvip)
            sum = price * num * discount * vipdiscount;
        else
            sum = price * num * discount;
        return sum;
    }

    public double getdissum(){
        if(promotion)
            dissum = num/2*price;
        else if(isvip)
            dissum = price * num  - price * num * discount * vipdiscount;
        else
            dissum = price * num * (1 - discount);
        return dissum;
    }
    public void addnum(){
        num++;
    }
    public int getnum(){
        return num;
    }
    public void setpromotion(boolean pro){
        promotion = pro;
    }
    public boolean getpromotion(){
        return promotion;
    }

    public void setvipdiscount(double cont){ this.vipdiscount = cont;}
    public double getvipdiscount(){
        return vipdiscount;
    }

    public void setIsvip(boolean a){
        isvip = a;
    }

}
