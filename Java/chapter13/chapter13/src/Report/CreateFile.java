package Report;
import java.io.*;
import java.util.NoSuchElementException;

// 객체 입출력 메소드가 있는 클래스
public class CreateFile {
    ObjectOutputStream output;
    ObjectInputStream input;
    ContactBook con;

    public CreateFile(){
        con = new ContactBook();
    }

    public void openFile() {
        try {
            input = new ObjectInputStream(new FileInputStream("report10.ser"));
        } catch (IOException ioException) {
            System.err.println("Error opening file.");
        }

        try {
            if (input != null)
                con = (ContactBook)input.readObject();
        } catch (ClassNotFoundException classNotFoundException) {
            System.err.println("Unable to create object.");
        } catch (IOException ioException) {
            System.err.println("Error opening file.");
        }
    }

    public void saveFile() {
        
        try {
            output = new ObjectOutputStream(new FileOutputStream("report10.ser"));
        } catch (IOException ioException) {
            System.err.println("Error opening file.");
        }

        try {
            output.writeObject(con);
            System.out.println("주소록을 저장했습니다.");
        } catch (IOException ioException) {
            System.err.println("Error opening file.");
        } catch (NoSuchElementException elementExcepition) {
            System.err.println("Invalid input. Please try again");
        }
        try {
            if (output != null)
                output.close();
        } catch (IOException ioException) {
            System.err.println("Error closing file.");
            System.exit(1);
        }
    }
    }