package Report;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

// 정보를 저장할 수 있는 클래스
class Contact implements Serializable {
    private String Name;
    private String Phone;
    private String Email;

    public String getName() { return this.Name; }
    public String getEmail() { return this.Email; }
    public String getPhone() {return this.Phone; }
    public void setName(String name) { this.Name = name; }
    public void setEmail(String email) { this.Email = email; }
    public void setPhone(String phone) { this.Phone = phone; }
}

// 주소록 클래스
public class ContactBook implements Serializable{
    private ArrayList<Contact> list;

    public ContactBook() { list = new ArrayList<Contact>(); }
    public void addContact(Contact con) { this.list.add(con); } 
    public void removeContact(int num) { this.list.remove(num); }
    public int size() { return this.list.size(); }
    public Contact getContact(int index) {return this.list.get(index); }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactBook ConBook = new ContactBook();
        CreateFile CF = new CreateFile();
        int choice = 0; // 메뉴 선택
        
        // 기존 주소록이 있다면, 불러오기
        File file = new File("report10.ser");   // 상대주소
        if (file.exists()) {    // 파일이 존재한다면
            CF.openFile();  // CF.list에 저장
                if (!CF.con.list.isEmpty()) // CF.list에 data가 있다면
                    ConBook.list = CF.con.list; // Conbook의 list에 저장
        }
        
        System.out.println("주소록 프로그램입니다. 메뉴를 선택해주세요.");
        while (choice != 4) {
            System.out.println("1. 주소록 추가 / 2. 주소록 삭제 / 3. 주소록 출력 / 4. 주소록 저장 & 종료");
            switch (choice = sc.nextInt()) {
                case 1: { // 1. 주소록 추가
                    System.out.println("---------------------------");
                    Contact temp = new Contact();
                    System.out.print("이름을 입력하시오 : ");
                    temp.setName(sc.next());
                    System.out.print("전화번호를 입력하시오(-는 제외하고) : ");
                    temp.setPhone(sc.next());
                    System.out.print("이메일을 입력하시오 : ");
                    temp.setEmail(sc.next());
                    ConBook.addContact(temp);
                    System.out.println("---------------------------");
                    break;
                }
                case 2: { // 2. 주소록 삭제
                    System.out.println("---------------------------");
                    System.out.print("삭제할 전화부의 번호를 입력하세요 : ");
                    int n = sc.nextInt();
                    if (ConBook.size() - 1 < n) {
                        System.out.print("해당하는 번호가 전화부에 없습니다.\n");
                    } else {
                        ConBook.removeContact(n);
                    }
                    System.out.println("---------------------------");
                    break;
                }
                case 3: { // 3. 주소록 출력
                    String Name, Phone, Email;
                    System.out.println("---------------------------");
                    if (ConBook.list.isEmpty()) {
                        System.out.println("주소록이 비었습니다.");
                        System.out.println("---------------------------");
                    } else {
                        for (int i = 0; i < ConBook.size(); i++) {
                            System.out.println(i + "번 연락처");
                            Name = ConBook.getContact(i).getName();
                            Phone = ConBook.getContact(i).getPhone();
                            Email = ConBook.getContact(i).getEmail();
                            System.out.println("이름 : " + Name);
                            System.out.println("전화번호 : " + Phone);
                            System.out.println("이름 : " + Email);
                            System.out.println("---------------------------");
                        }
                    }
                    break;
                }
                case 4: { // 4. 주소록 저장 및 종료
                    System.out.println("---------------------------");
                    CF.con.list = ConBook.list;
                    CF.saveFile();
                    System.out.println("프로그램을 종료합니다.");
                    System.out.println("---------------------------");
                    sc.close();
                    System.exit(0);
                }
            }
        }
    }
}
