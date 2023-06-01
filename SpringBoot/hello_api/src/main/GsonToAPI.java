package main;

import com.google.gson.Gson;
import model.Person;

public class GsonToAPI {
    public static void main(String[] args) {
        Person person = new Person("John",30);
        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println(json);
    }
}
