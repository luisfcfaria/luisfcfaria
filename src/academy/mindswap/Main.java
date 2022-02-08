package academy.mindswap;

import java.io.ObjectInput;

public class Main {


    public static void main(String[] args) {

        DynamicArray arr = new DynamicArray();

        arr.printArray();
        arr.add("3");
        arr.add("4");
        arr.add("5");
        arr.add("6");
        arr.add("7");
        arr.add("3");
        arr.printArray();
        arr.remove(0);
        arr.remove(1);
        arr.printArray();


    }
}
