package academy.mindswap;

import org.w3c.dom.Node;

public class Main {

    public static void main(String[] args) {
	// write your code here
        NodeContainer<String> container = new NodeContainer<>();
        NodeContainer<Integer> containerInt = new NodeContainer<>();

        containerInt.add(12);
        containerInt.add(45);
        containerInt.add(1);
        containerInt.add(12);

        System.out.println("------------------------");

        containerInt.indexOf(12);
    }
}
