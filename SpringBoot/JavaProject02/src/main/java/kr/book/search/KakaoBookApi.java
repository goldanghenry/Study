package kr.book.search;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KakaoBookApi {
    private static final String API_KEY = "b3c1692fe5d613be19a3da01688cc9bb"; // Rest Key
    private static final String API_BASE_URL = "https://dapi.kakao.com/v3/search/book";
    private static final OkHttpClient client = new OkHttpClient();  // 서버 연결용
    private static final Gson gson = new Gson();

    // 책 검색 메서드
    public static List<Book> searchBooks(String title) throws IOException {
        // 연결 url 생성
        HttpUrl.Builder urlBuilder = HttpUrl.parse(API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter("query", title);
        // 요청 정의
        Request request = new Request.Builder()
                .url(urlBuilder.build())
                .addHeader("Authorization", "KakaoAK " + API_KEY)
                .build();
        // 서버에 요청 -> response 응답
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Request failed: "+response);
            // body 에 응답 내용이 있음 json 타입 -> jsonObject로 변환
            JsonObject jsonResponse = gson.fromJson(response.body().charStream(), JsonObject.class);
            // 하나의 검색어 -> 여러 개의 책들이 검색됨 -> JsonArray
            JsonArray documents = jsonResponse.getAsJsonArray("documents");

            List<Book> books = new ArrayList<>();
            for (JsonElement document : documents) {    // 책 하나씩 꺼냄
                JsonObject bookJson = document.getAsJsonObject();
                Book book = new Book(
                        bookJson.get("title").getAsString(),
                        bookJson.get("authors").getAsJsonArray().toString(),
                        bookJson.get("publisher").getAsString(),
                        bookJson.get("thumbnail").getAsString()
                );
                books.add(book);
            }
            return books;
        }
    }
}
