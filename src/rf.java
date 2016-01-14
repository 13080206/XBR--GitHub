import java.io.*;
import java.util.ArrayList;

/**
 * Created by lc on 2016/1/6.
 */
public class rf {
    private ArrayList<vip> vipm;
    public rf(){

    }
    public  String ReadFile(String path){
        BufferedReader reader = null;
        String laststr = "";
        try{
            FileInputStream fileInputStream = new FileInputStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while((tempString = reader.readLine()) != null){
                laststr += tempString;
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(laststr);
        return laststr;
    }
    public void WriteFile(ArrayList<vip> v){
        vipm = v;
        int i = 0;
        try {
            FileOutputStream fos = new FileOutputStream("E:\\ideasoft\\src\\d5m");
            PrintWriter pw = new PrintWriter(fos);
            pw.println("{");
            for(vip p:vipm){
                i++;
                pw.println('"'+p.getMember()+'"'+":{");
                pw.println('"'+"name"+'"'+":"+'"'+p.getName()+'"'+",");
                pw.println('"'+"vc"+'"'+":"+p.getVc()+",");
                pw.println('"'+"isVip"+'"'+":"+p.getvip());
                if(vipm.size() != i)
                    pw.println("},");
                else
                    pw.println("}");

            }
            pw.println("}");
            pw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
