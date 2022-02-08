package academy.mindswap;

import java.util.PriorityQueue;
import java.util.Queue;

public class TodoList {

    private final Queue<TodoItem> TO_DO_ITEM = new PriorityQueue<>();

    public void add(PriorityLevel priorityLevel, int priority, String task){
        TO_DO_ITEM.offer(new TodoItem(priorityLevel,priority,task));
    }

    public boolean isEmpty() {
        return TO_DO_ITEM.isEmpty();
    }

    public TodoItem remove() {
        return TO_DO_ITEM.remove();
    }

   public static class TodoItem implements Comparable<TodoItem>{


        private PriorityLevel priorityLevel;
        private int importance;
        private String task;

        public TodoItem(PriorityLevel priorityLevel, int importance, String task) {
            this.priorityLevel = priorityLevel;
            this.importance = importance;
            this.task = task;

        }

        public PriorityLevel getPriorityLevel() {
            return priorityLevel;
        }

        public int getImportance() {
            return importance;
        }

        public String getTask() {
            return task;
        }

        @Override
        public int compareTo(TodoItem o) {

           int level = priorityLevel.compareTo(o.getPriorityLevel());
            if(level == 0){
                level = Integer.compare(this.getImportance(), o.getImportance());
            }

            return level;
        }

        @Override
       public String toString(){
            return "To do Item: \n" +
                    "Priority Level = " + getPriorityLevel() + "\n" +
                    "Importance = " + getImportance() + "\n" +
                    "Task = " + getTask() + "\n\n";

        }
    }
}
