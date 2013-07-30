
public class Main{
    public static void main(String args[]){
        try {
            ExcelReplaceAll era = new ExcelReplaceAll("classes/application.ini");
            era.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
