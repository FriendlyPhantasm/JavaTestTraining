package ru.manapov.stqa.pft.sandbox;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Collectionis {
    public static void main(String[] args) {
        String[] langs = {"Java", "C#", "Python", "PHP"};

        List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

        for (String l : languages) {
            System.out.println("Я хочу выучить " + l);
        }
    }
}
