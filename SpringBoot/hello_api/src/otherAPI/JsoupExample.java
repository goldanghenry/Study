package otherAPI;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupExample {
    public static void main(String[] args) {
        String url="https://sum.su.or.kr:8888/bible/today";

        try{//  예외처리
            Document document = Jsoup.connect(url).get(); //get으로 요청

            // bible_text와 bibleinfo_box 찾기
            Element bibleText = document.getElementById("bible_text");
            Element bibleInfoBox = document.getElementById("bibleinfo_box");

            System.out.println("Bible Text: "+bibleText.text());
            System.out.println("Bible Info Box: "+bibleInfoBox.text());
            System.out.println();

            // num과 info를 포함하는 요소 찾기
            Elements numElements =document.select(".num");
            Elements infoElements =document.select(".info");

            // num과 info 출력
            for (int i=0; i<numElements.size();i++){
                System.out.println(numElements.get(i).text()+":"+infoElements.get(i).text());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
