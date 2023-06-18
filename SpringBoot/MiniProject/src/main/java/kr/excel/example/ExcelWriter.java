package kr.excel.example;

import kr.excel.example.entity.MemberVo;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExcelWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MemberVo> members = new ArrayList<>();

        while(true){
            System.out.print("이름을 입력하세요:");
            String name = scanner.nextLine();
            if (name.equals("quit")){
                break;
            }
            System.out.print("나이를 입력하세요:");
            int age = scanner.nextInt();
            scanner.nextLine(); // 개행문자 제거

            System.out.print("생년월일을 입력하세요:");
            String birthdate = scanner.nextLine();
            scanner.nextLine();

            System.out.print("전화번호를 입력하세요:");
            String phone = scanner.nextLine();
            scanner.nextLine();

            System.out.print("주소를 입력하세요");
            String address = scanner.nextLine();
            scanner.nextLine();

            System.out.print("결혼여부를 입력하세요(true/false):");
            boolean isMarried = scanner.nextBoolean();
            scanner.nextLine();

            MemberVo member = new MemberVo(name, age, birthdate, phone,address,isMarried);
            members.add(member);
        }
        scanner.close();

        try{
            XSSFWorkbook workbook = new XSSFWorkbook();                   // 워크북 생성
            Sheet sheet = workbook.createSheet("회원정보");     // 시트 생성

            // 헤더 생성
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("이름");
            headerRow.createCell(1).setCellValue("나이");
            headerRow.createCell(2).setCellValue("생년월일");
            headerRow.createCell(3).setCellValue("전화번호");
            headerRow.createCell(4).setCellValue("주소");
            headerRow.createCell(5).setCellValue("결혼여부");

            // 데이터 생성
            for (int i =0; i<members.size();i++){
                MemberVo member = members.get(i);
                Row row = sheet.createRow(i+1);
                row.createCell(0).setCellValue(member.getName());
                row.createCell(1).setCellValue(member.getAge());
                row.createCell(2).setCellValue(member.getBirthdate());
                row.createCell(3).setCellValue(member.getPhone());
                row.createCell(4).setCellValue(member.getAddress());
                row.createCell(5).setCellValue(member.isMarried());
            }

            // 엑셀 파일 저장
            String filename = "members.xlsx";
            FileOutputStream outputStream = new FileOutputStream(new File(filename));
            workbook.write(outputStream);
            workbook.close();
            System.out.println("엑셀 파일이 저장되었습니다.");


        } catch(IOException e) {
            System.out.println("엑셀 파일 저장 중 오류 발생");
            e.printStackTrace();
        }

    }
}

