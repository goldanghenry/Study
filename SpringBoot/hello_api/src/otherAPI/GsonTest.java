package otherAPI;

import com.google.gson.Gson;

public class GsonTest {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Address address = new Address("서울", "대한민국");
        String member = gson.toJson(new Member("홍길동",29,"wshdhkd@naver.com",address));
        System.out.println(member);

        Member mvo = gson.fromJson(member, Member.class);
        System.out.println(mvo.getAge());
    }
}
