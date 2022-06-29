// Exercise
// 콘솔에 파일이나 디렉토리 이름(c:\Temp)을 입력하고 
// <Enter> 키를 입력하면 그림과 같이 나타나는 프로그램을 작성하라
// isAbsolute() // 절대 경로?, getAbsolution()
import java.io.File;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file or directory name: ");
        analyzePath(sc.nextLine());
        sc.close();
    }
    public static void analyzePath( String path){
        // 파일 객체 생성
        File name = new File(path);

        if(name.exists()){
            // 파일(또는 디렉토리) 정보 디스플레이
            System.out.println(name.getName() + " exists");
            if(name.isFile()) System.out.println("is a file");
            else System.out.println("is not a file");
            if(name.isDirectory()) System.out.println("is a directory");
            else System.out.println("is not a directory");
            if(name.isAbsolute()) System.out.println("is a Absolute path");
            else System.out.println("is not a Absolute path");
            System.out.println("Last modified: " + name.lastModified());
            System.out.println("Length: " + name.length());
            System.out.println("Path: " + name.getAbsolutePath());
            System.out.println("Parent: " + name.getParent());

            if(name.isDirectory()){ // 디렉토리 정보 리스팅
                String [] directory = name.list();
                System.out.println("\n\nDirectory contents:\n");
                for(String directoryName : directory)
                    System.out.println(directoryName);
            }
        }
        else { // 에러 메시지
            System.out.println(path + " does not exist.");
        }

    }
}
