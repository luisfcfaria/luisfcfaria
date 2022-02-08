package academy.mindswap;

import java.util.ArrayList;
import java.util.List;

public class DynamicArray {

    private Object[] objects;
    private static int objectsCreated;


    public DynamicArray() {

        objects = new Object[2];
    }

    public void printArray() {
        System.out.print("[");

        for (int i = 0; i < this.objects.length; i++) {
            System.out.print(this.objects[i]+", ");
        }
        System.out.print("]");
        System.out.println();
    }


    public Object[] add(Object object) {

        for (int i = 0; i < this.objects.length; i++) {
            if (objects[i] == null) {
                objects[i] = object;
                return this.objects;
            }
        }

        Object[] newObject = new Object[this.objects.length * 2];

        for (int i = 0; i < this.objects.length; i++) {
            newObject[i] = this.objects[i];
        }

        this.objects = newObject;
        return add(object);
    }



        public void remove (int index){
        int nullCounter = 0;

            for (int i = index; i < this.objects.length-1; i++) {
                objects[i] = objects[i+1];
            }

            for (int i = 0; i < this.objects.length; i++) {
                if (objects[i] == null){
                    nullCounter++;
                }
            }
            if(nullCounter >=this.objects.length/2){
              Object[] temp = new Object[this.objects.length/2];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = this.objects[i];

                }
                this.objects = temp;
            }
        }

    }



