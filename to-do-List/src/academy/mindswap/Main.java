package academy.mindswap;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// write your code here


        TodoList todoList = new TodoList();

        todoList.add(PriorityLevel.MEDIUM, 1, "Wash the dishes");
        todoList.add(PriorityLevel.HIGH, 1, "Feed the dog");
        todoList.add(PriorityLevel.HIGH, 2, "Go groceries shopping");
        todoList.add(PriorityLevel.HIGH, 2, "Pay the bills");
        todoList.add(PriorityLevel.MEDIUM, 1, "Workout");
        todoList.add(PriorityLevel.LOW, 1, "Call my barber");
        todoList.add(PriorityLevel.LOW, 2, "Read a book");



        while (!todoList.isEmpty()){
            System.out.println(todoList.remove().toString());
        }

    }
}
