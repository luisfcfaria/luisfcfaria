package academy.mindswap;

import academy.mindswap.Fruits.Apple;
import academy.mindswap.Fruits.Fruits;
import academy.mindswap.Fruits.Orange;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Apple apple = new Apple(1);

        List<Fruits> fruits = Arrays.asList(
                apple,
                new Apple(3),
                new Apple(1), //DUPE
                apple, //DUPE
                new Orange(1),
                new Orange(2),
                new Orange(4),
                new Apple(3), //DUPE
                new Orange(2)); //DUPE


        DupeFinder<Fruits> dupeFinder = new DupeFinder<>(fruits);
        System.out.println(dupeFinder.getDupes());


        System.out.println("Repeated Fruits: \n");
        for (Fruits fruit: dupeFinder.listDupes()) {
            System.out.println(fruit);

        }

    }
}