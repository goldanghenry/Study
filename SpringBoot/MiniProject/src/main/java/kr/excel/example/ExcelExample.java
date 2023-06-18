package kr.excel.example;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelExample {
    public static void main(String[] args) {
        try{
            // 파일을 읽어오기 위해 FileInputStream을 사용
            // new File -> 파일 객체를 만들어 읽어옴
            // 스트림을 통해 읽어온 내용을 메모리에 가상의 파일(워크북) 생성
            FileInputStream file = new FileInputStream(new File("example.xlsx"));
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);   // 0번째 시트
            for(Row row: sheet){
                for(Cell cell : row){
                    switch (cell.getCellType()){
                        case NUMERIC :
                            if (DateUtil.isCellDateFormatted(cell)){
                                Date dateValue = cell.getDateCellValue();
                                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                String formattedDate = dateFormat.format(dateValue);
                                System.out.print(formattedDate+"\t");
                            } else{
                                double numericValue = cell.getNumericCellValue();
                                if (numericValue == Math.floor(numericValue)){  // 내림해도 같다면 정수타입 -> 간단한 방법
                                    int intValue = (int)numericValue;
                                    System.out.print(intValue+"\t");
                                } else{
                                    System.out.print(numericValue+"\t");
                                }
                            }
                            break;
                        case STRING:
                            String stringValue = cell.getStringCellValue();
                            System.out.print(stringValue+"\t");
                            break;
                        case BOOLEAN:
                            Boolean booleanValue = cell.getBooleanCellValue();
                            System.out.print(booleanValue+"\t");
                            break;
                        case FORMULA:
                            String formulaValue = cell.getCellFormula();
                            System.out.print(formulaValue+"\t");
                            break;
                        case BLANK:
                            System.out.print("\t");
                            break;
                        default:
                            System.out.print("\t");
                            break;
                    }
                }
                System.out.println();
            }
            file.close();
            System.out.println("엑셀에서 데이터 읽어오기 성공");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
