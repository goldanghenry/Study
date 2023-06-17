package otherAPI;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherExample {
    public static void main(String[] args) {
        String apiKey="54ceb73e8f665c87d111e93692b09217";
        String city="Seoul";
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+apiKey+"&lang=kr&units=metric";

        try{
            URL url = new URL(urlString);   // 네트워크 API, url이 유효한지
            HttpURLConnection connection = (HttpURLConnection)url.openConnection(); // 연결
            connection.setRequestMethod("GET"); // 요청방식
            connection.setRequestProperty("Accept","application/json"); // 응답 방식

            int responseCode= connection.getResponseCode();   // 응답
            if (responseCode==200){
                // Stream(입출력 관련)의 연결
                // InputStreamReader는 서버에서 응답이 바이트 Stream을 통해서 올때, 한글의 경우 2byte인데 1byte씩 떨어져서 올 수 있기에
                // stream앞에 InputStreamReader라는 문자 단위를 읽을 수 있는 stream을 연결해서 깨지지 않도록 한다.(한글 인코딩)
                // BufferedReader 데이터를 모아서 한번에 처리하기 위함
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();  // BufferReader에서 한줄씩 받아온 문자를 붙이는 역할

                while((inputLine = in.readLine())!=null){
                    content.append(inputLine);
                }
                in.close();
                System.out.println("content.toString() = " + content.toString());
                JsonObject weatherData = JsonParser.parseString(content.toString()).getAsJsonObject();
                JsonObject mainData = weatherData.getAsJsonObject("main");
                double temp = mainData.get("temp").getAsDouble();
                System.out.println("temp = " + temp);
                connection.disconnect();
            } else {
                // error
                System.out.println("error");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
