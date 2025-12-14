package com.example;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Person original = new Person("Pulenko", "Evheniy", 20);

        Gson gson = new Gson();

        String json = gson.toJson(original);
        System.out.println("JSON: " + json);

        Person restored = gson.fromJson(json, Person.class);
        System.out.println("Restored: " + restored);

        System.out.println("Equals: " + original.equals(restored));
    }
}

