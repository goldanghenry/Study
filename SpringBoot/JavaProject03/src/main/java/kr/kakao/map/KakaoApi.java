package kr.kakao.map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLEncoder;

public class KakaoApi {
    private static final String KAKAO_API_KEY = "b3c1692fe5d613be19a3da01688cc9bb";
    public static double[] getAdressCoordinate(String address) throws IOException {
        String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json";
        String encodedAddress = URLEncoder.encode(address, "UTF-8");    // 한글 -> 네트워크 과정에서 깨지기 때문
        String requestUrl = apiUrl + "?query=" + encodedAddress;

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(requestUrl);  // 요청 URL
        httpGet.setHeader("Authorization", "KakaoAK " + KAKAO_API_KEY); // 인증키

        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            String responseBody = EntityUtils.toString(response.getEntity());
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
            JsonArray documents = jsonObject.getAsJsonArray("documents");

            if (documents.size() > 0) {
                JsonObject document = documents.get(0).getAsJsonObject();   // 가장 상위 데이터가 가능성 높음
                double latitude = document.get("y").getAsDouble();
                double longitude = document.get("x").getAsDouble();
                return new double[] {latitude, longitude};
            } else {
                return null;
            }
        }
    }
}
