import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class ReadSerFile {
    public static void main(String[] args){
        ObjectInputStream input;
        try{
            input = new ObjectInputStream(new FileInputStream("UserInfo.ser"));
            ArrayList list = (ArrayList)input.readObject();
            input.close();
            System.out.println(list);
        } catch(Exception e) { e.printStackTrace(); }
    }
}
